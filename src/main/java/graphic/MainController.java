package graphic;

import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.*;
import commands.Clear;
import commands.ExecuteScript;
import commands.Remove;
import commands.Update;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import javafx.util.converter.IntegerStringConverter;
import localizations.CurrentLanguage;
import localizations.Languages;
import managers.CurrentCollectionManager;
import models.CurrentUser;
import models.MusicBand;
import models.MusicGenre;

import java.io.File;
import java.net.URL;
import java.util.*;

public class MainController implements Initializable {
    @FXML private Label userLabel;
    @FXML private Button exitButton;

    @FXML private Button mapButton;

    @FXML private Button helpButton;

    @FXML private Button infoButton;

    @FXML private Button addButton;

    @FXML private Button executeScriptButton;

    @FXML private Button pauseButton;

    @FXML private Button clearButton;

    @FXML private Button removeGreaterButton;

    @FXML private TableView<MusicBand> tableView;

    @FXML private TableColumn<MusicBand, String> idColumn;

    @FXML private TableColumn<MusicBand, String> nameColumn;

    @FXML private TableColumn<MusicBand, Integer> xColumn;

    @FXML private TableColumn<MusicBand, Integer> yColumn;

    @FXML private TableColumn<MusicBand, String> creationDateColumn;

    @FXML private TableColumn<MusicBand, Integer> countParticipantsColumn;

    @FXML private TableColumn<MusicBand, Integer> singleCountColumn;

    @FXML private Text genreText;

    @FXML private TableColumn<MusicBand, MusicGenre> genreColumn;

    @FXML private TableColumn<MusicBand, Integer> labelColumn;

    private final Duration searchDelay = Duration.seconds(0.3);
    private javafx.animation.Timeline searchTimeline;

    @FXML private Label searchLabel;

    @FXML private TextField searchField;
    @FXML private Button stopButton;

    @FXML private Label languageLabel;

    @FXML private MenuButton languageMenuButton;

    @FXML private MenuItem ruLanguage;

    @FXML private MenuItem geLanguage;

    @FXML private MenuItem enLanguage;

    @FXML private MenuItem albLanguage;

    @FXML private Button deleteButton;

    @FXML private Button tableButton;

    @FXML private AnchorPane mapPane;

    private ImageView playImage = new ImageView(new Image(getClass().getResourceAsStream("/images/play.png")));
    private ImageView pauseImage = new ImageView(new Image(getClass().getResourceAsStream("/images/pause.png")));

    private static final int NUM_BANDS = 40; // Количество полос эквалайзера
    private static final double RADIUS = 100; // Радиус окружности
    private static final double BAR_WIDTH = 10; // Ширина прямоугольников
    private static final double BAR_HEIGHT = 100; // Высота прямоугольников

    private Rectangle[] equalizerBars;

    private Group equalizerGroup;
    private MediaPlayer mediaPlayer;

    private final ObservableList<MusicGenre> MUSIC_GENRES = FXCollections.observableArrayList(MusicGenre.PHONK, MusicGenre.POP,
            MusicGenre.PROGRESSIVE_ROCK, MusicGenre.RAP, MusicGenre.SOUL);




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        playImage.setFitWidth(80); // Устанавливаем ширину
        playImage.setFitHeight(80); // Устанавливаем высоту
        playImage.setPreserveRatio(true);
        pauseImage.setFitWidth(80); // Устанавливаем ширину
        pauseImage.setFitHeight(80); // Устанавливаем высоту
        pauseImage.setPreserveRatio(true);
        pauseButton.setGraphic(pauseImage);
        pauseButton.setVisible(false);
        stopButton.setVisible(false);
        tableView.setEditable(true);
        deleteButton.setVisible(false);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setOnEditCommit(event -> {
            MusicBand selectedMusicBand = event.getRowValue();
            if (CurrentUser.getUser().getId() == selectedMusicBand.getCreatorId()) {
               try {
                   String newValue = event.getNewValue();
                   selectedMusicBand.setName(newValue);
                   Update updateCommand = new Update();
                   updateCommand.setCollectionManager(CurrentCollectionManager.getCollectionManager());
                   updateCommand.setUser(CurrentUser.getUser());
                   updateCommand.setMusicBand(selectedMusicBand);
                   updateCommand.execute(new String[]{String.valueOf(selectedMusicBand.getId())});
                   updateTable(CurrentCollectionManager.getCollectionManager().getLinkedList());
               }catch (NullPointerException nullPointerException){
                   showAlert(CurrentLanguage.getCurrentLanguage().getString("null"), CurrentLanguage.getCurrentLanguage().getString("not null"));
                   tableView.refresh();
               }
            }else {
                showAlert(CurrentLanguage.getCurrentLanguage().getString("not update"),
                        CurrentLanguage.getCurrentLanguage().getString("not this user"));

                tableView.refresh();
            }
        });

        xColumn.setCellValueFactory(new PropertyValueFactory<>("x"));
        xColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        xColumn.setOnEditCommit(event -> {
            MusicBand selectedMusicBand = event.getRowValue();
            if (CurrentUser.getUser().getId() == selectedMusicBand.getCreatorId()) {
                try {
                    Integer newValue = event.getNewValue();
                    selectedMusicBand.setX(newValue);
                    Update updateCommand = new Update();
                    updateCommand.setCollectionManager(CurrentCollectionManager.getCollectionManager());
                    updateCommand.setUser(CurrentUser.getUser());
                    updateCommand.setMusicBand(selectedMusicBand);
                    updateCommand.execute(new String[]{String.valueOf(selectedMusicBand.getId())});
                    updateTable(CurrentCollectionManager.getCollectionManager().getLinkedList());
                }catch (NullPointerException nullPointerException){
                    showAlert(CurrentLanguage.getCurrentLanguage().getString("null"), CurrentLanguage.getCurrentLanguage().getString("not null"));
                    tableView.refresh();
                }
            }else {
                showAlert(CurrentLanguage.getCurrentLanguage().getString("not update"),
                        CurrentLanguage.getCurrentLanguage().getString("not this user"));

                tableView.refresh();
            }
        });
        yColumn.setCellValueFactory(new PropertyValueFactory<>("y"));
        yColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        yColumn.setOnEditCommit(event -> {
            MusicBand selectedMusicBand = event.getRowValue();
            if (CurrentUser.getUser().getId() == selectedMusicBand.getCreatorId()) {
                try {
                    Integer newValue = event.getNewValue();
                    selectedMusicBand.setY(newValue);
                    Update updateCommand = new Update();
                    updateCommand.setCollectionManager(CurrentCollectionManager.getCollectionManager());
                    updateCommand.setUser(CurrentUser.getUser());
                    updateCommand.setMusicBand(selectedMusicBand);
                    updateCommand.execute(new String[]{String.valueOf(selectedMusicBand.getId())});
                    updateTable(CurrentCollectionManager.getCollectionManager().getLinkedList());
                }catch (NullPointerException nullPointerException){
                    showAlert(CurrentLanguage.getCurrentLanguage().getString("null"), CurrentLanguage.getCurrentLanguage().getString("not null"));
                    tableView.refresh();
                }
            }else {
                showAlert(CurrentLanguage.getCurrentLanguage().getString("not update"),
                        CurrentLanguage.getCurrentLanguage().getString("not this user"));

                tableView.refresh();
            }
        });
        creationDateColumn.setCellValueFactory(new PropertyValueFactory<>("formatDate"));
        countParticipantsColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfParticipants"));
        countParticipantsColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        countParticipantsColumn.setOnEditCommit(event -> {
            MusicBand selectedMusicBand = event.getRowValue();
            if (CurrentUser.getUser().getId() == selectedMusicBand.getCreatorId()) {
                try {
                    Integer newValue = event.getNewValue();
                    selectedMusicBand.setNumberOfParticipants(newValue);
                    Update updateCommand = new Update();
                    updateCommand.setCollectionManager(CurrentCollectionManager.getCollectionManager());
                    updateCommand.setUser(CurrentUser.getUser());
                    updateCommand.setMusicBand(selectedMusicBand);
                    updateCommand.execute(new String[]{String.valueOf(selectedMusicBand.getId())});
                    updateTable(CurrentCollectionManager.getCollectionManager().getLinkedList());
                }catch (NullPointerException nullPointerException) {
                    showAlert(CurrentLanguage.getCurrentLanguage().getString("null"), CurrentLanguage.getCurrentLanguage().getString("not null"));
                    tableView.refresh();
                }
            }else {
                showAlert(CurrentLanguage.getCurrentLanguage().getString("not update"),
                        CurrentLanguage.getCurrentLanguage().getString("not this user"));

                tableView.refresh();
            }
        });
        singleCountColumn.setCellValueFactory(new PropertyValueFactory<>("singleCount"));
        singleCountColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        singleCountColumn.setOnEditCommit(event -> {
            MusicBand selectedMusicBand = event.getRowValue();
            if (CurrentUser.getUser().getId() == selectedMusicBand.getCreatorId()) {
                try {
                    Integer newValue = event.getNewValue();
                    selectedMusicBand.setSingleCount(newValue);
                    Update updateCommand = new Update();
                    updateCommand.setCollectionManager(CurrentCollectionManager.getCollectionManager());
                    updateCommand.setUser(CurrentUser.getUser());
                    updateCommand.setMusicBand(selectedMusicBand);
                    updateCommand.execute(new String[]{String.valueOf(selectedMusicBand.getId())});
                    updateTable(CurrentCollectionManager.getCollectionManager().getLinkedList());
                }catch (NullPointerException nullPointerException) {
                    showAlert(CurrentLanguage.getCurrentLanguage().getString("null"), CurrentLanguage.getCurrentLanguage().getString("not null"));
                    tableView.refresh();
                }
            }else {
                showAlert(CurrentLanguage.getCurrentLanguage().getString("not update"),
                        CurrentLanguage.getCurrentLanguage().getString("not this user"));

                tableView.refresh();
            }
        });
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
        genreColumn.setCellFactory(ComboBoxTableCell.forTableColumn(MUSIC_GENRES));
        genreColumn.setOnEditCommit(event -> {
            MusicBand selectedMusicBand = event.getRowValue();
            if (CurrentUser.getUser().getId() == selectedMusicBand.getCreatorId()) {
                MusicGenre newValue = event.getNewValue();
                selectedMusicBand.setGenre(newValue);
                Update updateCommand = new Update();
                updateCommand.setCollectionManager(CurrentCollectionManager.getCollectionManager());
                updateCommand.setUser(CurrentUser.getUser());
                updateCommand.setMusicBand(selectedMusicBand);
                updateCommand.execute(new String[]{String.valueOf(selectedMusicBand.getId())});
                updateTable(CurrentCollectionManager.getCollectionManager().getLinkedList());
            }
            else {
                showAlert(CurrentLanguage.getCurrentLanguage().getString("not update"),
                        CurrentLanguage.getCurrentLanguage().getString("not this user"));

                tableView.refresh();
            }
        });
        labelColumn.setCellValueFactory(new PropertyValueFactory<>("sales"));
        labelColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        labelColumn.setOnEditCommit(event -> {
            MusicBand selectedMusicBand = event.getRowValue();
            if (CurrentUser.getUser().getId() == selectedMusicBand.getCreatorId()) {
                try {
                    Integer newValue = event.getNewValue();
                    selectedMusicBand.setSales(newValue);
                    Update updateCommand = new Update();
                    updateCommand.setCollectionManager(CurrentCollectionManager.getCollectionManager());
                    updateCommand.setUser(CurrentUser.getUser());
                    updateCommand.setMusicBand(selectedMusicBand);
                    updateCommand.execute(new String[]{String.valueOf(selectedMusicBand.getId())});
                    updateTable(CurrentCollectionManager.getCollectionManager().getLinkedList());
                }catch (NullPointerException nullPointerException) {
                    showAlert(CurrentLanguage.getCurrentLanguage().getString("null"), CurrentLanguage.getCurrentLanguage().getString("not null"));
                    tableView.refresh();
                }
            }else {
                showAlert(CurrentLanguage.getCurrentLanguage().getString("not update"),
                        CurrentLanguage.getCurrentLanguage().getString("not this user"));

                tableView.refresh();
            }
        });

        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                // Выбрана новая строка
                if(newSelection.getCreatorId() == CurrentUser.getUser().getId()){
                    deleteButton.setVisible(true);
                    deleteButton.setOnAction(event -> {
                        Remove removeCommand = new Remove();
                        removeCommand.setUser(CurrentUser.getUser());
                        removeCommand.setCollectionManager(CurrentCollectionManager.getCollectionManager());
                        removeCommand.execute(new String[]{String.valueOf(newSelection.getId())});
                        updateTable(CurrentCollectionManager.getCollectionManager().getLinkedList());
                        deleteButton.setVisible(false);
                    });
                }else {
                    deleteButton.setVisible(false);
                }

                // Вызов нужного обработчика или выполнение логики
            }
        });


        updateTable(CurrentCollectionManager.getCollectionManager().getLinkedList());

        helpButton.setOnAction(event -> {
            showAlert(CurrentLanguage.getCurrentLanguage().getString("info about help"),
                    CurrentLanguage.getCurrentLanguage().getString("help command"));
        });

        infoButton.setOnAction(event -> {
            showAlert(CurrentLanguage.getCurrentLanguage().getString("info about commands"),
                    CurrentLanguage.getCurrentLanguage().getString("info")
                           + CurrentCollectionManager.getCollectionManager().getCreationDate() + "\n"
                     + CurrentLanguage.getCurrentLanguage().getString("count elements")
                            + CurrentCollectionManager.getCollectionManager().getLinkedList().size());

        });

        stopButton.setOnAction(e -> {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
            }
            if(equalizerGroup != null) equalizerGroup.setVisible(false);
            stopButton.setVisible(false);
            pauseButton.setVisible(false);
        });

        executeScriptButton.setOnAction(event -> {
            ExecuteScript executeScript = new ExecuteScript(CurrentCollectionManager.getCollectionManager());
            executeScript.setUser(CurrentUser.getUser());
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle(CurrentLanguage.getCurrentLanguage().getString("choose script"));
            File file = fileChooser.showOpenDialog(tableView.getScene().getWindow());
            if(file != null){
                executeScript.execute(new String[]{file.getAbsolutePath()});
                updateTable(CurrentCollectionManager.getCollectionManager().getLinkedList());

            }
              });

        addButton.setOnAction(event -> {
            Scene root = addButton.getScene();
            ModalSceneHandler handler = new ModalSceneHandler("/scenes/addElement/addElementWindow.fxml",
                    root);
            handler.handle(event);
            updateTable(CurrentCollectionManager.getCollectionManager().getLinkedList());
        });

        pauseButton.setOnAction(event -> {
            if (mediaPlayer != null) {
                if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
                    mediaPlayer.pause();
                    pauseButton.setGraphic(playImage); // При паузе меняем иконку на "Воспроизведение"
                } else if (mediaPlayer.getStatus() == MediaPlayer.Status.PAUSED) {
                    mediaPlayer.play();
                    pauseButton.setGraphic(pauseImage); // При воспроизведении меняем иконку на "Пауза"
                }
            }
        });

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (searchTimeline != null) {
                searchTimeline.stop();
            }

            // Запускаем таймлайн с задержкой
            searchTimeline = new Timeline();
            searchTimeline.getKeyFrames().add(
                    new KeyFrame(searchDelay, event -> performSearch(newValue))
            );
            searchTimeline.play();
        });

        removeGreaterButton.setOnAction(event -> {
            Scene root = addButton.getScene();
            ModalSceneHandler handler = new ModalSceneHandler("/scenes/removeGreaterElement/addElementWindow.fxml",
                    root);
            handler.handle(event);
            updateTable(CurrentCollectionManager.getCollectionManager().getLinkedList());
        });

        userLabel.setText(CurrentUser.getUser().getName());

        clearButton.setOnAction(event -> {
            Clear clear = new Clear();
            clear.setCollectionManager(CurrentCollectionManager.getCollectionManager());
            clear.setUser(CurrentUser.getUser());
            clear.execute(new String[]{});
            updateTable(CurrentCollectionManager.getCollectionManager().getLinkedList());
        });

        tableButton.setOnAction(event -> {
            mapButton.setVisible(true);
            tableView.setVisible(true);
            searchField.setVisible(true);
            searchLabel.setVisible(true);
            tableButton.setVisible(false);
            mapPane.setVisible(false);
            if(mediaPlayer != null) mediaPlayer.stop();
            stopButton.setVisible(false);
            pauseButton.setVisible(false);
        });

        mapButton.setOnAction(event -> {
            deleteButton.setVisible(false);
            mapPane.setVisible(true);
            tableButton.setVisible(true);
            tableView.setVisible(false);
            searchField.setVisible(false);
            searchLabel.setVisible(false);
            mapButton.setVisible(false);
            for (MusicBand musicBand : CurrentCollectionManager.getCollectionManager().getLinkedList()) {
                Integer userId = musicBand.getCreatorId();
                Color color = ColorsUsers.getColorsUsers().get(userId);
                if (color == null) {
                    color = generateRandomColor();
                    ColorsUsers.getColorsUsers().put(userId, color);
                }
                Circle circle = new Circle(normalizeX(musicBand.getCoordinates().getX()),
                        normalizeY(musicBand.getCoordinates().getY()), 15);
                circle.setFill(color);
                circle.setUserData(musicBand);
                circle.setOnMouseEntered(event1 -> {
                    MusicBand musicBand1 = (MusicBand) circle.getUserData();
                    genreText.setText(String.valueOf(musicBand1.getGenre()));
                    genreText.setVisible(true);
                });
                circle.setOnMouseExited(event1 -> {
                    genreText.setVisible(false);
                });
                circle.setOnMouseClicked(event1 -> {
                    MusicBand musicBand1 = (MusicBand) circle.getUserData();
                    String genre = String.valueOf(musicBand1.getGenre());
                    int randomNumberSong = getRandomNumber();
                    String audioFile = "/music/" + genre + "/" + randomNumberSong + ".mp3";
                    pauseButton.setVisible(true);
                    stopButton.setVisible(true);
                    URL soundResource = getClass().getResource(audioFile);
                    Media sound = new Media(soundResource.toExternalForm());
                    mediaPlayer = new MediaPlayer(sound);
                    equalizerBars = new Rectangle[NUM_BANDS];
                    for (int i = 0; i < NUM_BANDS; i++) {
                        Rectangle bar = new Rectangle(BAR_WIDTH, BAR_HEIGHT);
                        bar.setFill(Color.BLUE);
                        equalizerBars[i] = bar;
                    }

                    double centerX = RADIUS + BAR_WIDTH / 2;
                    double centerY = RADIUS + BAR_HEIGHT / 2;
                    double angleIncrement = 360.0 / NUM_BANDS;
                    for (int i = 0; i < NUM_BANDS; i++) {
                        double angle = i * angleIncrement;
                        double x = centerX + RADIUS * Math.cos(Math.toRadians(angle)) - BAR_WIDTH / 2;
                        double y = centerY + RADIUS * Math.sin(Math.toRadians(angle)) - BAR_HEIGHT / 2;
                        equalizerBars[i].setLayoutX(x);
                        equalizerBars[i].setLayoutY(y);
                        equalizerBars[i].getTransforms().add(new Rotate(angle + 90, BAR_WIDTH / 2, BAR_HEIGHT / 2));
                    }

                    equalizerGroup = new Group(equalizerBars);
                    equalizerGroup.setLayoutX(100);
                    equalizerGroup.setVisible(true);



                    mediaPlayer.setAudioSpectrumListener((double timestamp, double duration, float[] magnitudes, float[] phases) -> {
                        for (int i = 0; i < NUM_BANDS; i++) {
                            double magnitude = magnitudes[i + 1] + 60; // Добавление смещения и нормализация
                            double height = magnitude * BAR_HEIGHT / 60; // Масштабирование высоты прямоугольника
                            equalizerBars[i].setHeight(height);
                            equalizerBars[i].setLayoutY(centerY - height / 2); // Установка положения прямоугольника по вертикали
                        }
                    });


                    // Check if something is already playing
                    if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
                        mediaPlayer.stop();
                    }

// Animation loop for equalizer visualization


                    mediaPlayer.setOnReady(() -> {
                        mediaPlayer.play();
                        pauseButton.setGraphic(pauseImage);
                    });

                    mediaPlayer.setOnEndOfMedia(() -> {
                        mediaPlayer.stop();
                        mediaPlayer.dispose();
                        pauseButton.setGraphic(playImage);
                        equalizerGroup.setVisible(false);
                    });

                    mapPane.getChildren().add(equalizerGroup);

                });

                mapPane.getChildren().add(circle);
                }
        });

        exitButton.setOnAction(event -> {
               ChangeSceneHandler changeSceneHandler =  new ChangeSceneHandler("/scenes/login/LogInWindow.fxml");
               changeSceneHandler.handle(event);
               mediaPlayer.stop();

        });
        ruLanguage.setOnAction(event -> {
            CurrentLanguage.setCurrentLanguage(Languages.ru);
            CurrentLanguage.setCurrentLanguageString("ru");
            setLanguage();
        });
        enLanguage.setOnAction(event -> {
            CurrentLanguage.setCurrentLanguage(Languages.en);
            CurrentLanguage.setCurrentLanguageString("en");
            setLanguage();
        });
        albLanguage.setOnAction(event -> {
            CurrentLanguage.setCurrentLanguage(Languages.alb);
            CurrentLanguage.setCurrentLanguageString("alb");
            setLanguage();
        });
        geLanguage.setOnAction(event -> {
            CurrentLanguage.setCurrentLanguage(Languages.ge);
            CurrentLanguage.setCurrentLanguageString("ge");

            setLanguage();
        });
        setLanguage();
    }

    public void updateTable(Collection<MusicBand> data){
        tableView.setItems(FXCollections.observableArrayList(
                data
        ));
        tableView.refresh();
    }






    private void showAlert(String title, String result){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(result);
        ButtonType okButton = new ButtonType(CurrentLanguage.getCurrentLanguage().getString("ok"));
        alert.setResizable(true);
        alert.getButtonTypes().setAll(okButton);
        alert.showAndWait();
    }

    private void performSearch(String searchTerm) {
        // Очищаем предыдущий результат поиска
        tableView.getItems().clear();

        // Выполняем поиск и добавляем найденные элементы в таблицу
        for (MusicBand musicBand : CurrentCollectionManager.getCollectionManager().getLinkedList()) {
            if (String.valueOf(musicBand.getId()).contains(searchTerm) || musicBand.getName().contains(searchTerm)
                   || musicBand.getCoordinates().toString().contains(searchTerm)
            || musicBand.getFormatCreationDate().contains(searchTerm) || String.valueOf(musicBand.getNumberOfParticipants()).contains(searchTerm)
            || musicBand.getSingleCount().toString().contains(searchTerm) || String.valueOf(musicBand.getGenre()).contains(searchTerm)
                || musicBand.getLabel().toString().contains(searchTerm))
            {
                tableView.getItems().add(musicBand);
            }
        }
    }
        private Color generateRandomColor() {
            Random random = new Random();
            double red = random.nextDouble();
            double green = random.nextDouble();
            double blue = random.nextDouble();

            return new Color(red, green, blue, 1.0);
        }
    private double normalizeX(Integer x){
        double minValue = Integer.MIN_VALUE;
        double maxValue = Integer.MAX_VALUE;
        return ((x - minValue) / (maxValue - minValue)) * mapPane.getWidth();
    }
    private double normalizeY(Integer y){
        double minValue = Integer.MIN_VALUE;
        double maxValue = Integer.MAX_VALUE;
        double res =  (y - minValue) /   (maxValue - minValue);
        return res*mapPane.getHeight();
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(5) + 1;  // генерирует числа от 0 до 4 и добавляет 1, чтобы сделать их в диапазоне от 1 до 5
    }

    private void setLanguage(){
        ResourceBundle currentLanguage = CurrentLanguage.getCurrentLanguage();
        languageMenuButton.setText(currentLanguage.getString(CurrentLanguage.getCurrentLanguageString()));
        exitButton.setText(currentLanguage.getString("exit"));
        mapButton.setText(currentLanguage.getString("map"));
        helpButton.setText(currentLanguage.getString("help"));
        infoButton.setText(currentLanguage.getString("information"));
        addButton.setText(currentLanguage.getString("add"));
        executeScriptButton.setText(currentLanguage.getString("script"));
        removeGreaterButton.setText(currentLanguage.getString("remove greater"));
        clearButton.setText(currentLanguage.getString("clear"));
        searchLabel.setText(currentLanguage.getString("searchLabel"));
        searchField.setPromptText(currentLanguage.getString("searchField"));
        nameColumn.setText(currentLanguage.getString("name"));
        creationDateColumn.setText(currentLanguage.getString("creation date"));
        countParticipantsColumn.setText(currentLanguage.getString("count fans"));
        singleCountColumn.setText(currentLanguage.getString("single count"));
        genreColumn.setText(currentLanguage.getString("genre"));
        labelColumn.setText(currentLanguage.getString("labels"));
        ruLanguage.setText(currentLanguage.getString("ru"));
        geLanguage.setText(currentLanguage.getString("ge"));
        enLanguage.setText(currentLanguage.getString("en"));
        albLanguage.setText(currentLanguage.getString("alb"));
        languageLabel.setText(currentLanguage.getString("language:"));
        tableButton.setText(currentLanguage.getString("table"));
        deleteButton.setText(currentLanguage.getString("delete"));
    }
}
