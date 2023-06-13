package graphic;

import commands.Add;
import commands.RemoveGreater;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import localizations.CurrentLanguage;
import managers.CurrentCollectionManager;
import models.Coordinates;
import models.CurrentUser;
import models.MusicBand;
import models.MusicGenre;

import java.net.URL;
import java.util.ResourceBundle;

public class RemoveGreaterElementController implements Initializable, ModalController{

    private Stage modalStage;

    private final ObservableList<MusicGenre> MUSIC_GENRES = FXCollections.observableArrayList(MusicGenre.PHONK, MusicGenre.POP,
            MusicGenre.PROGRESSIVE_ROCK, MusicGenre.RAP, MusicGenre.SOUL);

    @FXML private Label nameLabel;
    @FXML private TextField nameField;
    @FXML private Label coordinateXLabel;
    @FXML private Label coordinateYLabel;
    @FXML private Button submitButton;

    @FXML private ChoiceBox<MusicGenre> musicGenresChoice;

    @FXML private Text errorText;
    @FXML private Label addLabel;
    @FXML private TextField coordinateXField;
    @FXML private TextField coordinateYField;
    @FXML private Label countPartLabel;
    @FXML private TextField countPartField;

    @FXML private Label countSingleLabel;

    @FXML private TextField countSingleField;
    @FXML private Label genreLabel;

    @FXML private Label labelSales;

    @FXML private TextField labelSaleField;

    @FXML private Button closeButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errorText.setVisible(false);
        musicGenresChoice.setItems(MUSIC_GENRES);
        musicGenresChoice.setValue(MUSIC_GENRES.get(0));
        submitButton.setOnAction(event -> {
            String wrong = "";
            String name = nameField.getText();
            String coordinateX = coordinateXField.getText();
            String coordinateY = coordinateYField.getText();
            String countPart = countPartField.getText();
            String countSingle = countSingleField.getText();
            MusicGenre genre = musicGenresChoice.getValue();
            String labelSale = labelSaleField.getText();
            String[] fields = {name, coordinateX, coordinateY, countPart, countSingle, labelSale};
            for(String el : fields){
                if(el.isBlank()){
                    wrong = "not empty";
                    break;
                }
            }
            String[] canTransform = {coordinateX, coordinateY, countPart, countSingle, labelSale};
            if(wrong.isEmpty()){
                for(String el : canTransform){
                    if(!el.matches("^-?\\d+$")){
                        wrong = "not numbers";
                        break;
                    }
                }
            }
            if(wrong.isEmpty()){
                MusicBand musicBand = new MusicBand(name, new Coordinates(Integer.parseInt(coordinateX), Integer.parseInt(coordinateY)),
                        Integer.parseInt(countPart), Integer.parseInt(countSingle), genre, new models.Label(Integer.parseInt(labelSale)));
                RemoveGreater removeGreaterCommand = new RemoveGreater();
                removeGreaterCommand.setUser(CurrentUser.getUser());
                removeGreaterCommand.setCollectionManager(CurrentCollectionManager.getCollectionManager());
                removeGreaterCommand.setMusicBand(musicBand);
                removeGreaterCommand.execute(new String[]{});
                modalStage.close();
            }else {
                errorText.setText(CurrentLanguage.getCurrentLanguage().getString(wrong));
                errorText.setVisible(true);
            }

        });

        closeButton.setOnAction(event -> modalStage.close());
        setLanguage();
    }
    @Override
    public void setModalStage(Stage modalStage) {
        this.modalStage = modalStage;
    }

    private void setLanguage(){
        ResourceBundle currentLanguage = CurrentLanguage.getCurrentLanguage();
        addLabel.setText(currentLanguage.getString("remove greater"));
        nameLabel.setText(currentLanguage.getString("name"));
        nameField.setPromptText(currentLanguage.getString("input text"));
        coordinateXField.setPromptText(currentLanguage.getString("input text"));
        coordinateYField.setPromptText(currentLanguage.getString("input text"));
        coordinateXLabel.setText(currentLanguage.getString("coord x"));
        coordinateYLabel.setText(currentLanguage.getString("coord y"));
        countPartLabel.setText(currentLanguage.getString("count fans"));
        countSingleField.setPromptText(currentLanguage.getString("input text"));
        countSingleLabel.setText(currentLanguage.getString("single count"));
        genreLabel.setText(currentLanguage.getString("genre"));
        labelSaleField.setPromptText(currentLanguage.getString("input text"));
        labelSales.setText(currentLanguage.getString("labels"));
        submitButton.setText(currentLanguage.getString("delete"));

    }
}
