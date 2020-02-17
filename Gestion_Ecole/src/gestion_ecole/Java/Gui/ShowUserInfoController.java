/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_ecole.Java.Gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import gestion_ecole.Java.Control.AdminsUsers;
import gestion_ecole.Java.Control.Users;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author FiveHearoes
 */
public class ShowUserInfoController implements Initializable {

    @FXML
    private HBox Main;

    @FXML
    private JFXTextField FirstnameF;

    @FXML
    private JFXButton Show;

    @FXML
    private JFXListView<Label> ListView;

    @FXML
    private HBox Info;

    @FXML
    private ImageView Picture;

    @FXML
    private Label Firstname;

    @FXML
    private Label Lastname;

    @FXML
    private Label Brith_Place;

    @FXML
    private Label Brith_Date;

    @FXML
    private Label CIN;

    @FXML
    private Label Phone;

    @FXML
    private Label Email;

    @FXML
    private Label Position;

    @FXML
    private JFXButton Back;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Show.setOnMouseClicked((e) -> {
            ListView.getItems().clear();
            List<Users> users = AdminsUsers.getUsers(FirstnameF.getText());
            if (users.isEmpty()) {
                ListView.getItems().add(new Label("None"));
            } else {
                users.forEach((u) -> {
                    ListView.getItems().add(new Label(u.getLastname() + "  " + u.getFirstname()));
                });
                ListView.setOnMouseClicked((l) -> {
                    if (!ListView.getSelectionModel().isEmpty()) {
                        intInf(users.get(ListView.getSelectionModel().getSelectedIndex()));
                        Timeline changeW = new Timeline();
                        KeyFrame closeW = new KeyFrame(Duration.millis(500), new KeyValue(Main.layoutXProperty(), -776, Interpolator.EASE_BOTH));
                        KeyFrame openW = new KeyFrame(Duration.millis(500), new KeyValue(Info.layoutXProperty(), Main.getLayoutX(), Interpolator.EASE_BOTH));
                        changeW.getKeyFrames().addAll(closeW, openW);
                        changeW.play();
                    }
                });

            }
        });

        Back.setOnMouseClicked((e) -> {
            Timeline changeW = new Timeline();
            KeyFrame closeW = new KeyFrame(Duration.millis(500), new KeyValue(Info.layoutXProperty(), 776, Interpolator.EASE_BOTH));
            KeyFrame openW = new KeyFrame(Duration.millis(500), new KeyValue(Main.layoutXProperty(), Info.getLayoutX(), Interpolator.EASE_BOTH));
            changeW.getKeyFrames().addAll(closeW, openW);
            changeW.play();
        });
        // TODO
    }

    private void intInf(Users user) {
        Firstname.setText(user.getFirstname());
        Lastname.setText(user.getLastname());
        Brith_Place.setText(user.getBrith_Place());
        Brith_Date.setText(user.getBrith_Date().toString());
        CIN.setText(user.getCIN());
        Phone.setText(user.getPhone());
        Email.setText(user.getEmail());
        Position.setText(user.getPosition());
    }
    // TODO
}
