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
public class UpdateRsltController implements Initializable {

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
    private JFXTextField DS1;

    @FXML
    private JFXTextField DS2;

    @FXML
    private JFXTextField EXAM;

    @FXML
    private JFXTextField RATT;

    @FXML
    private JFXRadioButton AAR;

    @FXML
    private ToggleGroup ARF;

    @FXML
    private JFXRadioButton SAR;

    @FXML
    private JFXButton Update;

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
                                    st = "sbj";
                                    R = AdminsStudents.getResult(stds.get(indS).getIDS(), listS.get(indSB).getID());
                                    DS1.setText(R.getDs1() + "");
                                    DS2.setText(R.getDs2() + "");
                                    EXAM.setText(R.getExam() + "");
                                    RATT.setText(R.getRatt() + "");
                                    
                                    AAR.selectedProperty().set(R.getAR());
                                    SAR.selectedProperty().set(!R.getAR());
                                }
                            }
                        });

                    }
                }
        );

        DoubleValidator ValidD1 = new DoubleValidator();
        DoubleValidator ValidD2 = new DoubleValidator();
        DoubleValidator ValidE = new DoubleValidator();
        DoubleValidator ValidR = new DoubleValidator();

        ValidD1.setIcon(new ImageView(new Image("/gestion_ecole/Picture/Warning.png")));
        ValidD2.setIcon(new ImageView(new Image("/gestion_ecole/Picture/Warning.png")));
        ValidE.setIcon(new ImageView(new Image("/gestion_ecole/Picture/Warning.png")));
        ValidR.setIcon(new ImageView(new Image("/gestion_ecole/Picture/Warning.png")));

        DS1.getValidators().add(ValidD1);
        DS2.getValidators().add(ValidD2);
        EXAM.getValidators().add(ValidE);
        RATT.getValidators().add(ValidR);

        DS1.focusedProperty().addListener((o, oldval, newval) -> {
            if (!newval) {
                ValidD1.setMessage("Enter Period");
                if (DS1.validate()) {
                    if (Float.valueOf(DS1.getText()) > 20.0) {
                        DS1.setText("");
                        ValidD1.setMessage("Period Large Then 20");
                        DS1.validate();
                    }
                }
            }
        }
        );
        DS2.focusedProperty().addListener((o, oldval, newval) -> {
            if (!newval) {
                ValidD2.setMessage("Enter Period");
                if (DS2.validate()) {
                    if (Float.valueOf(DS2.getText()) > 20.0) {
                        DS2.setText("");
                        ValidD2.setMessage("Period Large Then 20");
                        DS2.validate();
                    }
                }
            }
        }
        );
        EXAM.focusedProperty().addListener((o, oldval, newval) -> {
            if (!newval) {
                ValidE.setMessage("Enter Period");
                if (EXAM.validate()) {
                    if (Float.valueOf(EXAM.getText()) > 20.0) {
                        EXAM.setText("");
                        ValidE.setMessage("Period Large Then 20");
                        EXAM.validate();
                    }
                }
            }
        }
        );
        RATT.focusedProperty().addListener((o, oldval, newval) -> {
            if (!newval) {
                ValidR.setMessage("Enter Period");
                if (RATT.validate()) {
                    if (Float.valueOf(RATT.getText()) > 20.0) {
                        RATT.setText("");
                        ValidR.setMessage("Period Large Then 20");
                        RATT.validate();
                    }
                }
            }
        }
        );

        Update.setOnMouseClicked((e) -> {
            ValidD1.setMessage("Enter Period");
            ValidD2.setMessage("Enter Period");
            ValidE.setMessage("Enter Period");
            ValidR.setMessage("Enter Period");
            if (DS1.validate() && DS2.validate() && EXAM.validate() && RATT.validate()) {
                if (Float.valueOf(DS1.getText()) > 20.0 && Float.valueOf(DS2.getText()) > 20.0 && Float.valueOf(EXAM.getText()) > 20.0 && Float.valueOf(RATT.getText()) > 20.0) {
                    if (Float.valueOf(DS1.getText()) > 20.0) {
                        DS1.setText("");
                        ValidD1.setMessage("Period Large Then 20.00");
                        DS1.validate();
                    }
                    if (Float.valueOf(DS2.getText()) > 20.0) {
                        DS2.setText("");
                        ValidD2.setMessage("Period Large Then 20.00");
                        DS2.validate();
                    }
                    if (Float.valueOf(EXAM.getText()) > 20.0) {
                        EXAM.setText("");
                        ValidE.setMessage("Period Large Then 20.00");
                        EXAM.validate();
                    }
                    if (Float.valueOf(RATT.getText()) > 20.0) {
                        RATT.setText("");
                        ValidR.setMessage("Period Large Then 20.00");
                        RATT.validate();
                    }
                } else {
                    AdminsStudents.UploadRslt(Float.valueOf(DS1.getText()), 0, stds.get(indS).getIDS(), listS.get(indSB).getID());
                    AdminsStudents.UploadRslt(Float.valueOf(DS2.getText()), 1, stds.get(indS).getIDS(), listS.get(indSB).getID());
                    AdminsStudents.UploadRslt(Float.valueOf(EXAM.getText()), 2, stds.get(indS).getIDS(), listS.get(indSB).getID());
                    AdminsStudents.UploadRslt(Float.valueOf(RATT.getText()), 3, stds.get(indS).getIDS(), listS.get(indSB).getID());
                    AdminsStudents.UploadRslt(AAR.isSelected()?1:0, 4, stds.get(indS).getIDS(), listS.get(indSB).getID());
                    R = AdminsStudents.getResult(stds.get(indS).getIDS(), listS.get(indSB).getID());
                }
            }
        });
        // TODO
    }

}
