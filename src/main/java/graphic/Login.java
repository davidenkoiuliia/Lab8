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
import org.intellij.lang.annotations.Language;

import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {

    @FXML
    private TextField nameTextField;

    @FXML Label logToAccesLabel;

    @FXML Label welcomeLabel;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Button registerButton;

    @FXML
    private Label haveAccountLabel;
    @FXML
    private Label toRegisterLabel;


    @FXML Button signUpButton;


    @FXML private Text errorText;

    @FXML private Label languageLabel;

    @FXML private MenuButton languageMenuButton;

    @FXML private MenuItem ruLanguage;

    @FXML private MenuItem geLanguage;

    @FXML private MenuItem enLanguage;

    @FXML private MenuItem albLanguage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errorText.setVisible(false);
        registerButton.setOnAction(event -> {
            String login = nameTextField.getText();
            String password = passwordTextField.getText();
            User user = new User(login, password);
            AuthManager authManager = new AuthManager();
            boolean isLogin = authManager.auth(user);
            if(isLogin){
                CurrentUser.setUser(user);
                ChangeSceneHandler changeSceneHandler = new ChangeSceneHandler("/scenes/main/Main.fxml");
                changeSceneHandler.handle(event);
            }
            else {
                errorText.setVisible(true);
            }
        });
        signUpButton.setOnAction(new ChangeSceneHandler("/scenes/registerWindow/RegisterWindow.fxml"));
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
        errorText.setText(currentLanguage.getString("failed to login"));
        welcomeLabel.setText(currentLanguage.getString("welcome to music band"));
        logToAccesLabel.setText(currentLanguage.getString("Log to account"));
        toRegisterLabel.setText(currentLanguage.getString("toRegisterButton"));
        nameTextField.setPromptText(currentLanguage.getString("name"));
        passwordTextField.setPromptText(currentLanguage.getString("password"));
        registerButton.setText(currentLanguage.getString("loginButton"));
        haveAccountLabel.setText(currentLanguage.getString("not have account"));
        signUpButton.setText(currentLanguage.getString("toRegisterButton"));
        ruLanguage.setText(currentLanguage.getString("ru"));
        geLanguage.setText(currentLanguage.getString("ge"));
        enLanguage.setText(currentLanguage.getString("en"));
        albLanguage.setText(currentLanguage.getString("alb"));
        languageLabel.setText(currentLanguage.getString("language:"));


    }
}
