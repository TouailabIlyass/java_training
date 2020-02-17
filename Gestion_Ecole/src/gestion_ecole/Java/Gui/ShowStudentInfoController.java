/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_ecole.Java.Gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import gestion_ecole.Java.Control.AdminsStudents;
import gestion_ecole.Java.Control.Students;
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
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author FiveHearoes
 */
public class ShowStudentInfoController implements Initializable {

    @FXML
    private HBox Main;

    @FXML
    private JFXTextField FirstnameF;

    @FXML
    private JFXComboBox<Label> SelectD;

    @FXML
    private JFXRadioButton FY;

    @FXML
    private ToggleGroup Year;

    @FXML
    private JFXRadioButton SY;

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
    private Label CNE;

    @FXML
    private Label Phone;

    @FXML
    private Label Email;

    @FXML
    private Label DoR;

    @FXML
    private JFXButton Back;
    
    private boolean moving;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        AdminsStudents.getDep().forEach((dprt) -> {
            SelectD.getItems().add(new Label(dprt.getDescription()));
        });

        Show.setOnMouseClicked((e) -> {
            ListView.getItems().clear();
            List<Students> stds = AdminsStudents.getStudents(SelectD.getSelectionModel().isEmpty() ? "" : SelectD.getSelectionModel().getSelectedItem().getText(), FY.isSelected() ? 1 : (SY.isSelected() ? 2 : 0), FirstnameF.getText());
            if (stds.isEmpty()) {
                ListView.getItems().add(new Label("None"));
            } else {
                stds.forEach((s) -> {
                    ListView.getItems().add(new Label(s.getLastname() + "  " + s.getFirstname()));
                });
                ListView.setOnMouseClicked((l) -> {
                    if (!ListView.getSelectionModel().isEmpty() && !moving) {
                        intInf(stds.get(ListView.getSelectionModel().getSelectedIndex()));
                        Timeline changeW = new Timeline();
                        KeyFrame closeW = new KeyFrame(Duration.millis(500), new KeyValue(Main.layoutXProperty(), -776, Interpolator.EASE_BOTH));
                        KeyFrame openW = new KeyFrame(Duration.millis(500), new KeyValue(Info.layoutXProperty(), Main.getLayoutX(), Interpolator.EASE_BOTH));
                        changeW.getKeyFrames().addAll(closeW, openW);
                        changeW.play();
                        moving = true;
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
            moving = false;
        });
        // TODO
    }

    private void intInf(Students std) {
        Firstname.setText(std.getFirstname());
        Lastname.setText(std.getLastname());
        Brith_Place.setText(std.getBrith_Place());
        Brith_Date.setText(std.getBrith_Date().toString());
        CIN.setText(std.getCIN());
        CNE.setText(std.getCNE());
        Phone.setText(std.getPhone());
        Email.setText(std.getEmail());
        DoR.setText(std.getDate_Insc().toString());
    }

}
