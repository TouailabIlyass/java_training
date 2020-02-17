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
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author FiveHearoes
 */
public class AddResultController implements Initializable {

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
    private HBox set;

    @FXML
    private JFXTextField RusltN;

    @FXML
    private JFXComboBox<Label> SelectAr;

    @FXML
    private JFXButton Add;

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
        SelectAr.getItems().add(new Label("False"));
        SelectAr.getItems().add(new Label("True"));
        Valid = new DoubleValidator();
        Valid.setIcon(new ImageView(new Image("/gestion_ecole/Picture/Warning.png")));
        RusltN.getValidators().add(Valid);
        RusltN.focusedProperty().addListener((o, oldval, newval) -> {
            if (!newval) {
                Valid.setMessage("Enter Period");
                if (RusltN.validate()) {
                    if (Float.valueOf(RusltN.getText()) > 20.0) {
                        RusltN.setText("");
                        Valid.setMessage("Period Large Then 20");
                        RusltN.validate();
                    }
                }
            }
        }
        );

        Show.setOnMouseClicked(
                (e) -> {
                    set.setVisible(false);
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
                                    st = "Rslt";
                                    R = AdminsStudents.getResult(stds.get(indS).getIDS(), listS.get(indSB).getID());
                                    ListView.getItems().clear();
                                    ListView.getItems().add(new Label("Ds 1"));
                                    ListView.getItems().add(new Label("Ds 2"));
                                    ListView.getItems().add(new Label("Exam"));
                                    ListView.getItems().add(new Label("Ratt"));
                                    ListView.getItems().add(new Label("AR"));
                                } else if (st.equals("Rslt")) {
                                    if (ListView.getSelectionModel().getSelectedIndex() != 4) {
                                        Add.setText("ADD");
                                        SelectAr.setVisible(false);
                                        RusltN.setVisible(true);
                                        SelectAr.setPrefWidth(0.0);
                                        RusltN.setPrefWidth(219);

                                        float not = 0;
                                        switch (ListView.getSelectionModel().getSelectedIndex()) {
                                            case 0:
                                                not = R.getDs1();
                                                break;
                                            case 1:
                                                not = R.getDs2();
                                                break;
                                            case 2:
                                                not = R.getExam();
                                                break;
                                            case 3:
                                                not = R.getRatt();
                                                break;
                                        }
                                        set.setVisible(true);
                                        if (not != 0.0) {
                                            RusltN.setText(not + "");
                                            RusltN.setDisable(true);
                                        } else {
                                            RusltN.setText("");
                                            RusltN.setDisable(false);
                                        }
                                    } else {
                                        Add.setText("SET");
                                        RusltN.setVisible(false);
                                        SelectAr.setVisible(true);
                                        RusltN.setPrefWidth(0.0);
                                        SelectAr.setPrefWidth(219.0);
                                        SelectAr.getSelectionModel().select(R.getAR() ? 1 : 0);
                                        SelectAr.setDisable(R.getAR());
                                        set.setVisible(true);
                                    }
                                }
                            }
                        });

                    }
                }
        );

        Add.setOnMouseClicked((e) -> {
            if (!RusltN.isDisable() && RusltN.isVisible()) {
                Valid.setMessage("Enter Period");
                if (RusltN.validate()) {
                    if (Float.valueOf(RusltN.getText()) > 20.0) {
                        RusltN.setText("");
                        Valid.setMessage("Period Large Then 20.00");
                        RusltN.validate();
                    } else {
                        RusltN.setDisable(true);
                        AdminsStudents.UploadRslt(Float.valueOf(RusltN.getText()), ListView.getSelectionModel().getSelectedIndex(), stds.get(indS).getIDS(), listS.get(indSB).getID());
                        R = AdminsStudents.getResult(stds.get(indS).getIDS(), listS.get(indSB).getID());
                    }
                }
            } else if ((SelectAr.getSelectionModel().getSelectedIndex() == 1 ? true : false) && SelectAr.isVisible()) {
                SelectAr.setDisable(true);
                AdminsStudents.UploadRslt(1, ListView.getSelectionModel().getSelectedIndex(), stds.get(indS).getIDS(), listS.get(indSB).getID());
                R = AdminsStudents.getResult(stds.get(indS).getIDS(), listS.get(indSB).getID());
            }
        }
        );
        // TODO
    }

}
