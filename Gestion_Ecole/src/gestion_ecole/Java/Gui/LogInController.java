/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_ecole.Java.Gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import gestion_ecole.Java.Control.AdminsUsers;
import gestion_ecole.Java.GestionEcole;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 *
 * @author FiveHearoes
 */
public class LogInController implements Initializable {

    @FXML
    private StackPane stackpane;

    @FXML
    private AnchorPane Content;

    @FXML
    private AnchorPane ContentField;

    @FXML
    private JFXTextField Username;

    @FXML
    private JFXPasswordField Password;

    @FXML
    private JFXButton LogIn;

    private Timeline WindowAnimated;
    private Timeline CloseLogIn;
    private boolean Finished;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RequiredFieldValidator validatorU = new RequiredFieldValidator();
        validatorU.setIcon(new ImageView(new Image("/gestion_ecole/Picture/Warning.png")));
        Username.getValidators().add(validatorU);
        RequiredFieldValidator validatorP = new RequiredFieldValidator();
        validatorP.setIcon(new ImageView(new Image("/gestion_ecole/Picture/Warning.png")));
        Password.getValidators().add(validatorP);
        Username.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                validatorU.setMessage("Enter Your Username");
                Username.validate();
            }
        });
        Password.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                validatorP.setMessage("Enter Your Password");
                Password.validate();
            }
        });
        Finished = true;
        LogIn.setOnAction((action) -> {
            if (Username.getText().isEmpty() || Password.getText().isEmpty()) {
                errorLogin();
                validatorU.setMessage("Enter Your Username");
                validatorP.setMessage("Enter Your Password");
            } else {
                GestionEcole.user = AdminsUsers.getUser(Username.getText());
                if (GestionEcole.user != null) {
                    if (Password.getText().equals(GestionEcole.user.getCode())) {
                        try {
                            CloseLogIn = new Timeline();
                            KeyFrame Anim1 = new KeyFrame(Duration.ZERO, new KeyValue(Content.layoutXProperty(), Content.getLayoutX(), Interpolator.EASE_BOTH));
                            KeyFrame Anim2 = new KeyFrame(Duration.millis(300), new KeyValue(Content.layoutXProperty(), Content.getLayoutX() - 100, Interpolator.EASE_BOTH));
                            KeyFrame Anim3 = new KeyFrame(Duration.millis(330), new KeyValue(Content.layoutXProperty(), Content.getLayoutX(), Interpolator.EASE_BOTH));
                            KeyFrame Anim4 = new KeyFrame(Duration.millis(600), new KeyValue(Content.layoutXProperty(), 810, Interpolator.EASE_BOTH));
                            CloseLogIn.getKeyFrames().addAll(Anim1, Anim2, Anim3, Anim4);
                            Parent root = FXMLLoader.load(getClass().getResource("/gestion_ecole/Fxml/LogIn.fxml"));
                            Timeline resizeBar = new Timeline();
                            resizeBar.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(((Pane) ((VBox) stackpane.getChildren().get(0)).getChildren().get(0)).prefHeightProperty(), 59.0, Interpolator.EASE_BOTH)));
                            CloseLogIn.play();
                            CloseLogIn.setOnFinished((value) -> {
                                resizeBar.play();
                            });
                            resizeBar.setOnFinished((value) -> {
                                GestionEcole.changeScene("ControlePanel.fxml");
                            });
                        } catch (IOException ex) {
                            Logger.getLogger(LogInController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        errorLogin();
                        Password.setText("");
                        validatorP.setMessage("Incorrect Password");
                        Password.validate();
                    }

                } else {
                    errorLogin();
                    Username.setText("");
                    validatorU.setMessage("Incorrect Username");
                    Username.validate();
                }
            }
        });

    }

    private void errorLogin() {
        if (Finished) {
            WindowAnimated = new Timeline();
            double x = ContentField.getLayoutX();
            for (int i = 0; i < 11; i++) {
                double newX = i % 2 == 0 ? x - 10 : x + 10;
                if (i == 10) {
                    newX = x;
                }
                KeyFrame anime = new KeyFrame(Duration.millis(100 * (i + 1)), new KeyValue(ContentField.layoutXProperty(), newX));
                WindowAnimated.getKeyFrames().add(anime);
            }
            WindowAnimated.play();
            Username.validate();
            Password.validate();
            Finished = false;
            WindowAnimated.setOnFinished((value) -> {
                Finished = true;
            });
        }
    }

}
