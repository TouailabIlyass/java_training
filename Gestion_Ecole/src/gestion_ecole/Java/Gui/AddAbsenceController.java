/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_ecole.Java.Gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import gestion_ecole.Java.Control.AdminsStudents;
import gestion_ecole.Java.Control.Courses;
import gestion_ecole.Java.Control.Module;
import gestion_ecole.Java.Control.Result;
import gestion_ecole.Java.Control.Students;
import gestion_ecole.Java.Control.Subject;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
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
public class AddAbsenceController implements Initializable {

    @FXML
    private HBox First;

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
    private HBox Last;

    @FXML
    private JFXDatePicker DateC;

    @FXML
    private JFXTimePicker TimeC;

    @FXML
    private JFXCheckBox just;

    @FXML
    private JFXButton add;

    @FXML
    private JFXButton Back;

    @FXML
    private JFXRadioButton OH;

    @FXML
    private ToggleGroup nbrH;

    @FXML
    private JFXRadioButton TH;

    @FXML
    private JFXRadioButton TRH;

    @FXML
    private JFXRadioButton FH;

    private String st;
    private List<Subject> listS;
    private List<Module> listM;
    private List<Students> stds;
    private Result R;
    private int indS;
    private int indSB;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AdminsStudents.getDep().forEach((dprt) -> {
            SelectD.getItems().add(new Label(dprt.getDescription()));
        });

        Show.setOnMouseClicked(
                (e) -> {

                    ListView.getItems().clear();
                    stds = AdminsStudents.getStudents(SelectD.getSelectionModel().isEmpty() ? "" : SelectD.getSelectionModel().getSelectedItem().getText(), FY.isSelected() ? 1 : (SY.isSelected() ? 2 : 0), FirstnameF.getText());
                    if (stds.isEmpty()) {
                        ListView.getItems().add(new Label("None"));
                        st = "None";
                    } else {
                        stds.forEach((s) -> {
                            ListView.getItems().add(new Label(s.getLastname() + "  " + s.getFirstname()));
                        });
                        st = "std";
                        ListView.setOnMouseClicked((l) -> {
                            if (!ListView.getSelectionModel().isEmpty()) {
                                if (st.equals("std")) {
                                    st = "mdl";
                                    indS = ListView.getSelectionModel().getSelectedIndex();
                                    listM = AdminsStudents.getMdl(stds.get(ListView.getSelectionModel().getSelectedIndex()).getIDS());
                                    ListView.getItems().clear();
                                    listM.forEach((M) -> {
                                        ListView.getItems().add(new Label(M.getNumMdl() + "  " + M.getNameMdl()));
                                    });
                                } else if (st.equals("mdl")) {
                                    st = "sbj";
                                    listS = AdminsStudents.getSub(listM.get(ListView.getSelectionModel().getSelectedIndex()).getIdM());
                                    ListView.getItems().clear();
                                    listS.forEach((S) -> {
                                        ListView.getItems().add(new Label(S.getName()));
                                    });
                                } else if (st.equals("sbj")) {
                                    indSB = ListView.getSelectionModel().getSelectedIndex();
                                    Timeline changeW = new Timeline();
                                    KeyFrame closeW = new KeyFrame(Duration.millis(500), new KeyValue(First.layoutXProperty(), -1 * First.getPrefWidth() - 4, Interpolator.EASE_BOTH));
                                    KeyFrame openW = new KeyFrame(Duration.millis(500), new KeyValue(Last.layoutXProperty(), 0, Interpolator.EASE_BOTH));
                                    changeW.getKeyFrames().addAll(closeW, openW);
                                    changeW.play();
                                }
                            }
                        });

                    }
                }
        );

        Back.setOnMouseClicked((e) -> {
            Timeline changeW = new Timeline();
            KeyFrame closeW = new KeyFrame(Duration.millis(500), new KeyValue(Last.layoutXProperty(), Last.getPrefWidth() + 4, Interpolator.EASE_BOTH));
            KeyFrame openW = new KeyFrame(Duration.millis(500), new KeyValue(First.layoutXProperty(), 0, Interpolator.EASE_BOTH));
            changeW.getKeyFrames().addAll(closeW, openW);
            changeW.play();
        });

        add.setOnMouseClicked((e) -> {
            if (nbrH.getSelectedToggle() != null && DateC.getValue() != null && TimeC.getValue() != null) {
                AdminsStudents.addAbsence(new Courses(0, listS.get(indSB).getID(), Date.valueOf(DateC.getValue()), Time.valueOf(TimeC.getValue()), OH.isSelected() ? 1 : (TH.isSelected() ? 2 : (TRH.isSelected() ? 3 : 4))), just.isSelected() ? 1 : 0, stds.get(indS).getIDS());
            }
        });
        // TODO
    }

}
