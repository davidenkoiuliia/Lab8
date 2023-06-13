package graphic;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import localizations.CurrentLanguage;
import localizations.Languages;
import managers.AuthManager;
import models.CurrentUser;
import models.User;

import java.net.URL;
import java.util.ResourceBundle;

public class Register implements Initializable {
    @FXML
    private TextField nameTextField;

    @FXML
    private Label logToAccesLabel;

    @FXML private Label welcomeLabel;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Button registerButton;

    @FXML
    private Label haveAccountLabel;
    @FXML
    private Label toLoginLabel;


    @FXML private Text errorText;

    @FXML private Label languageLabel;


    @FXML private MenuButton languageMenuButton;

    @FXML private MenuItem ruLanguage;

    @FXML private MenuItem geLanguage;

    @FXML private MenuItem enLanguage;

    @FXML private MenuItem albLanguage;

    @FXML private Button logInButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errorText.setVisible(false);
        registerButton.setOnAction(event -> {
            String login = nameTextField.getText();
            String password = passwordTextField.getText();
            User user = new User(login, password);
            AuthManager authManager = new AuthManager();
            boolean isLogin = authManager.register(user);
            if (isLogin) {
                CurrentUser.setUser(user);
                ChangeSceneHandler changeSceneHandler = new ChangeSceneHandler("/scenes/main/Main.fxml");
                changeSceneHandler.handle(event);
            } else {
                errorText.setVisible(true);
            }
        });
        logInButton.setOnAction(new ChangeSceneHandler("/scenes/login/LogInWindow.fxml"));
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

    private void setLanguage(){
        ResourceBundle currentLanguage = CurrentLanguage.getCurrentLanguage();
        languageMenuButton.setText(currentLanguage.getString(CurrentLanguage.getCurrentLanguageString()));
        errorText.setText(currentLanguage.getString("failed to register"));
        welcomeLabel.setText(currentLanguage.getString("welcome to music band"));
        logToAccesLabel.setText(currentLanguage.getString("Register"));
        toLoginLabel.setText(currentLanguage.getString("toLoginButton"));
        nameTextField.setPromptText(currentLanguage.getString("name"));
        passwordTextField.setPromptText(currentLanguage.getString("password"));
        registerButton.setText(currentLanguage.getString("registerButton"));
        haveAccountLabel.setText(currentLanguage.getString("have account"));
        logInButton.setText(currentLanguage.getString("toLoginButton"));
        ruLanguage.setText(currentLanguage.getString("ru"));
        geLanguage.setText(currentLanguage.getString("ge"));
        enLanguage.setText(currentLanguage.getString("en"));
        albLanguage.setText(currentLanguage.getString("alb"));
        languageLabel.setText(currentLanguage.getString("language:"));


    }
    }
