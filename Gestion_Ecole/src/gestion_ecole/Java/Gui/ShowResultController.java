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
import com.jfoenix.validation.DoubleValidator;
import gestion_ecole.Java.Control.AdminsStudents;
import gestion_ecole.Java.Control.Module;
import gestion_ecole.Java.Control.Result;
import gestion_ecole.Java.Control.Students;
import gestion_ecole.Java.Control.Subject;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author FiveHearoes
 */
public class ShowResultController implements Initializable {

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
    private Label DS_1;

    @FXML
    private Label DS_2;

    @FXML
    private Label EXAM;

    @FXML
    private Label RATT;

    @FXML
    private Label AR;

    private String st;
    private List<Subject> listS;
    private List<Module> listM;
    private List<Students> stds;
    private Result R;
    private int indS;
    private int indSB;
    private DoubleValidator Valid;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AdminsStudents.getDep().forEach((dprt) -> {
            SelectD.getItems().add(new Label(dprt.getDescription()));
        });

        Show.setOnMouseClicked((e) -> {
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
                            R = AdminsStudents.getResult(stds.get(indS).getIDS(), listS.get(indSB).getID());

                            DS_1.setText((R.getDs1() == 0.0 ? "None" : R.getDs1()) + "");
                            DS_2.setText((R.getDs2() == 0.0 ? "None" : R.getDs2()) + "");
                            EXAM.setText((R.getExam() == 0.0 ? "None" : R.getExam()) + "");
                            RATT.setText((R.getRatt() == 0.0 ? "None" : R.getRatt()) + "");
                            AR.setText(R.getAR() ? "AVEC AR" : "SANS AR");
                        }
                    }
                });

            }
        }
        );
        // TODO
    }

}
