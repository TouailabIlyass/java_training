/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_ecole.Java.Gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import gestion_ecole.Java.Control.AdminsStudents;
import gestion_ecole.Java.Control.Students;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.layout.HBox;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author FiveHearoes
 */
public class UpdateStdController implements Initializable {

    @FXML
    private HBox First;

    @FXML
    private JFXTextField FirstnameF;

    @FXML
    private JFXComboBox<Label> SelectD1;

    @FXML
    private JFXRadioButton FY1;

    @FXML
    private ToggleGroup Year;

    @FXML
    private JFXRadioButton SY1;

    @FXML
    private JFXButton Show;

    @FXML
    private JFXListView<Label> ListView;

    @FXML
    private JFXTextField Firstname;

    @FXML
    private JFXTextField Lastname;

    @FXML
    private JFXTextField CIN;

    @FXML
    private JFXButton Next;

    @FXML
    private HBox Last;

    @FXML
    private JFXTextField BrithPlace;

    @FXML
    private JFXDatePicker BrithDate;

    @FXML
    private JFXTextField CNE;

    @FXML
    private JFXComboBox<Label> SelectD;

    @FXML
    private JFXDatePicker DateInc;

    @FXML
    private JFXRadioButton FY;

    @FXML
    private ToggleGroup SelectAn;

    @FXML
    private JFXRadioButton SY;

    @FXML
    private JFXTextField Email;

    @FXML
    private JFXTextField Phone;

    @FXML
    private JFXButton Back;

    @FXML
    private JFXButton Add;

    private int IDS;
    private int ID;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AdminsStudents.getDep().forEach((dprt) -> {
            SelectD.getItems().add(new Label(dprt.getDescription()));
        });

        AdminsStudents.getDep().forEach((dprt) -> {
            Label l = new Label(dprt.getDescription());
            SelectD1.getItems().add(l);
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
                    if (!ListView.getSelectionModel().isEmpty()) {
                        intInf(stds.get(ListView.getSelectionModel().getSelectedIndex()));
                        ID = stds.get(ListView.getSelectionModel().getSelectedIndex()).getID();
                        IDS = stds.get(ListView.getSelectionModel().getSelectedIndex()).getIDS();
                    }
                });

            }
        });

        Next.setOnMouseClicked((e) -> {
            Timeline changeW = new Timeline();
            KeyFrame closeW = new KeyFrame(Duration.millis(500), new KeyValue(First.layoutXProperty(), -776, Interpolator.EASE_BOTH));
            KeyFrame openW = new KeyFrame(Duration.millis(500), new KeyValue(Last.layoutXProperty(), First.getLayoutX(), Interpolator.EASE_BOTH));
            changeW.getKeyFrames().addAll(closeW, openW);
            changeW.play();
        });

        Back.setOnMouseClicked((e) -> {
            Timeline changeW = new Timeline();
            KeyFrame closeW = new KeyFrame(Duration.millis(500), new KeyValue(Last.layoutXProperty(), 776, Interpolator.EASE_BOTH));
            KeyFrame openW = new KeyFrame(Duration.millis(500), new KeyValue(First.layoutXProperty(), Last.getLayoutX(), Interpolator.EASE_BOTH));
            changeW.getKeyFrames().addAll(closeW, openW);
            changeW.play();
        });

        Add.setOnMouseClicked((e) -> {
            Students std = new Students(Date.valueOf(DateInc.getValue()), CNE.getText(), Firstname.getText(), Lastname.getText(), BrithPlace.getText(), Date.valueOf(BrithDate.getValue()), CIN.getText(), Phone.getText(), Email.getText(), "None", SelectD1.getSelectionModel().getSelectedItem().getText(), FY1.isSelected() ? 1 : 2);
            std.setID(ID);
            std.setIDS(IDS);
            AdminsStudents.UpDateStd(std);
            Show.fire();
        });
        // TODO
    }

    private void intInf(Students std) {
        Firstname.setText(std.getFirstname());
        Lastname.setText(std.getLastname());
        CIN.setText(std.getCIN());
        BrithPlace.setText(std.getBrith_Place());
        BrithDate.setValue(std.getBrith_Date().toLocalDate());
        CNE.setText(std.getCNE());
        Label l = null;
        for (Label object : SelectD1.getItems()) {
            if (object.getText().equals(std.getDepartement())) {
                l = object;
            }
        }
        SelectD1.getSelectionModel().select(l);
        System.out.println(std.getYear() + " " + std.getDepartement());
        FY1.selectedProperty().set(std.getYear() == 1 ? true : false);
        SY1.selectedProperty().set(std.getYear() == 2 ? true : false);
        DateInc.setValue(std.getDate_Insc().toLocalDate());
        Email.setText(std.getEmail());
        Phone.setText(std.getPhone());
    }

}
