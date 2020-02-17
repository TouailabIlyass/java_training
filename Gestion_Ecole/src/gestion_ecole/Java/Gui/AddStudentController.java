/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_ecole.Java.Gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import gestion_ecole.Java.Control.AdminsStudents;
import gestion_ecole.Java.Control.Students;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author FiveHearoes
 */
public class AddStudentController implements Initializable {

    @FXML
    private HBox First;

    @FXML
    private JFXTextField Firstname;

    @FXML
    private JFXTextField Lastname;

    @FXML
    private JFXTextField CIN;

    @FXML
    private JFXTextField BrithPlace;

    @FXML
    private JFXDatePicker BrithDate;

    @FXML
    private JFXTextField CNE;

    @FXML
    private JFXButton Next;

    @FXML
    private HBox Last;

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        AdminsStudents.getDep().forEach((depart) -> {
            SelectD.getItems().add(new Label(depart.getDescription()));
        });
        RequiredFieldValidator validatorF = new RequiredFieldValidator();
        RequiredFieldValidator validatorL = new RequiredFieldValidator();
        RequiredFieldValidator validatorBP = new RequiredFieldValidator();
        RequiredFieldValidator validatorCI = new RequiredFieldValidator();
        RequiredFieldValidator validatorCN = new RequiredFieldValidator();
        RequiredFieldValidator validatorBD = new RequiredFieldValidator();
        RequiredFieldValidator validatorDI = new RequiredFieldValidator();
        RequiredFieldValidator validatorSD = new RequiredFieldValidator();
        validatorF.setIcon(new ImageView(new Image("/gestion_ecole/Picture/Warning.png")));
        validatorL.setIcon(new ImageView(new Image("/gestion_ecole/Picture/Warning.png")));
        validatorBP.setIcon(new ImageView(new Image("/gestion_ecole/Picture/Warning.png")));
        validatorCI.setIcon(new ImageView(new Image("/gestion_ecole/Picture/Warning.png")));
        validatorCN.setIcon(new ImageView(new Image("/gestion_ecole/Picture/Warning.png")));
        validatorBD.setIcon(new ImageView(new Image("/gestion_ecole/Picture/Warning.png")));
        validatorDI.setIcon(new ImageView(new Image("/gestion_ecole/Picture/Warning.png")));
        validatorSD.setIcon(new ImageView(new Image("/gestion_ecole/Picture/Warning.png")));
        Firstname.getValidators().add(validatorF);
        Lastname.getValidators().add(validatorL);
        BrithPlace.getValidators().add(validatorBP);
        CIN.getValidators().add(validatorCI);
        CNE.getValidators().add(validatorCN);
        Next.setOnMouseClicked((e) -> {
            Timeline changeW = new Timeline();
            KeyFrame closeW = new KeyFrame(Duration.millis(500), new KeyValue(First.layoutXProperty(), -1 * First.getPrefWidth() - 4, Interpolator.EASE_BOTH));
            KeyFrame openW = new KeyFrame(Duration.millis(500), new KeyValue(Last.layoutXProperty(), 0, Interpolator.EASE_BOTH));
            changeW.getKeyFrames().addAll(closeW, openW);
            changeW.play();
        });
        Back.setOnMouseClicked((e) -> {
            Timeline changeW = new Timeline();
            KeyFrame closeW = new KeyFrame(Duration.millis(500), new KeyValue(Last.layoutXProperty(), Last.getPrefWidth() + 4, Interpolator.EASE_BOTH));
            KeyFrame openW = new KeyFrame(Duration.millis(500), new KeyValue(First.layoutXProperty(), 0, Interpolator.EASE_BOTH));
            changeW.getKeyFrames().addAll(closeW, openW);
            changeW.play();
        });

        Firstname.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                validatorF.setMessage("Enter Your Firstname");
                Firstname.validate();
            }
        });
        Lastname.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                validatorL.setMessage("Enter Your Lastname");
                Lastname.validate();
            }
        });
        BrithPlace.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                validatorBP.setMessage("Enter Your Brith Place");
                BrithPlace.validate();
            }
        });
        CIN.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                validatorCI.setMessage("Enter Your CIN");
                CIN.validate();
            }
        });
        CNE.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                validatorCN.setMessage("Enter Your CNE");
                CNE.validate();
            }
        });

        Add.setOnMouseClicked((e) -> {
            if (Firstname.getText().isEmpty() || Lastname.getText().isEmpty() || BrithPlace.getText().isEmpty() || CIN.getText().isEmpty() || CNE.getText().isEmpty() || BrithDate.getEditor().getText().isEmpty() || DateInc.getEditor().getText().isEmpty() || SelectD.getSelectionModel().isEmpty()) {
                if (Firstname.getText().isEmpty()) {
                    validatorF.setMessage("Enter You Firstname");
                    Firstname.validate();
                }
                if (Lastname.getText().isEmpty()) {
                    validatorL.setMessage("Enter You Lastname");
                    Lastname.validate();
                }
                if (BrithPlace.getText().isEmpty()) {
                    validatorBP.setMessage("Enter You Brith Place");
                    BrithPlace.validate();
                }
                if (CIN.getText().isEmpty()) {
                    validatorCI.setMessage("Enter You CIN");
                    CIN.validate();
                }
                if (CNE.getText().isEmpty()) {
                    validatorCN.setMessage("Enter You CNE");
                    CNE.validate();
                }
            } else {
                Students std;
                Date dateIn = Date.valueOf(DateInc.getValue());
                Date dateB = Date.valueOf(BrithDate.getValue());
                String Depart = SelectD.getSelectionModel().getSelectedItem().getText();
                int Year = FY.isSelected() ? 1 : 2;
                std = new Students(dateIn, CNE.getText(), Firstname.getText(), Lastname.getText(), BrithPlace.getText(), dateB, CIN.getText(), Phone.getText(), Email.getText(), "None", Depart, Year);
                AdminsStudents.AddStudents(std);
                Firstname.setText("");
                Lastname.setText("");
                BrithPlace.setText("");
                BrithDate.setValue(LocalDate.now());
                CIN.setText("");
                CNE.setText("");
                Phone.setText("");
                Email.setText("");
                DateInc.setValue(LocalDate.now());
            }
        });

        // TODO
    }

}
