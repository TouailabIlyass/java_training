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
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import gestion_ecole.Java.Control.AdminsUsers;
import gestion_ecole.Java.Control.ManagerStudents;
import gestion_ecole.Java.Control.ManagerUsers;
import gestion_ecole.Java.Control.Module;
import gestion_ecole.Java.Control.Subject;
import gestion_ecole.Java.Control.Users;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author FiveHearoes
 */
public class AddUserController implements Initializable {

    @FXML
    private HBox First;

    @FXML
    private JFXTextField Firstname;

    @FXML
    private JFXTextField Lastname;

    @FXML
    private JFXTextField BrithPlace;

    @FXML
    private JFXDatePicker BrithDate;

    @FXML
    private JFXTextField CIN;

    @FXML
    private JFXTextField Phone;

    @FXML
    private JFXTextField Email;

    @FXML
    private JFXTextField Position;

    @FXML
    private JFXTextField Username;

    @FXML
    private JFXPasswordField Password;

    @FXML
    private JFXPasswordField Password1;

    @FXML
    private JFXButton Next;

    @FXML
    private VBox Secend;

    @FXML
    private JFXCheckBox AS;

    @FXML
    private JFXCheckBox RS;

    @FXML
    private JFXCheckBox US;

    @FXML
    private JFXCheckBox AR;

    @FXML
    private JFXCheckBox RR;

    @FXML
    private JFXCheckBox UR;

    @FXML
    private JFXCheckBox AA;

    @FXML
    private JFXCheckBox RA;

    @FXML
    private JFXCheckBox UA;

    @FXML
    private JFXComboBox<Label> Dprt;

    @FXML
    private JFXComboBox<Label> Mdl;

    @FXML
    private JFXComboBox<Label> Sbjct;

    @FXML
    private JFXListView<CustomizedItem1> listA;

    @FXML
    private JFXButton NextL;

    @FXML
    private JFXButton Back;

    @FXML
    private JFXButton R;

    @FXML
    private JFXButton ADDA;

    @FXML
    private VBox LAST;

    @FXML
    private JFXCheckBox AU;

    @FXML
    private JFXCheckBox RU;

    @FXML
    private JFXCheckBox UU;

    @FXML
    private JFXButton ADD;

    @FXML
    private JFXButton BackS;

    @FXML
    private JFXListView<Label> listS;

    @FXML
    private JFXComboBox<Label> Dprt1;

    @FXML
    private JFXComboBox<Label> Mdl1;

    @FXML
    private JFXComboBox<Label> Sbjct1;

    @FXML
    private JFXButton R1;

    @FXML
    private JFXButton ADDS;

    private List<Module> listMdl;
    private List<Module> listMdl1;
    private Users user;
    private List<ManagerStudents> managerStudents;
    public static ManagerStudents m;
    public static boolean b;
    boolean add;
    private String SDEPARTMENT;
    private List<Subject> listSbj;
    private List<Subject> sb;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        b = false;
        listSbj = new ArrayList<>();
        RequiredFieldValidator ValidF = new RequiredFieldValidator();
        RequiredFieldValidator ValidL = new RequiredFieldValidator();
        RequiredFieldValidator ValidB = new RequiredFieldValidator();
        RequiredFieldValidator ValidC = new RequiredFieldValidator();
        NumberValidator ValidPH = new NumberValidator();
        RequiredFieldValidator ValidU = new RequiredFieldValidator();
        RequiredFieldValidator ValidP = new RequiredFieldValidator();
        RequiredFieldValidator ValidPA = new RequiredFieldValidator();

        ValidF.setIcon(new ImageView(new Image("/gestion_ecole/Picture/Warning.png")));
        ValidL.setIcon(new ImageView(new Image("/gestion_ecole/Picture/Warning.png")));
        ValidB.setIcon(new ImageView(new Image("/gestion_ecole/Picture/Warning.png")));
        ValidC.setIcon(new ImageView(new Image("/gestion_ecole/Picture/Warning.png")));
        ValidU.setIcon(new ImageView(new Image("/gestion_ecole/Picture/Warning.png")));
        ValidPH.setIcon(new ImageView(new Image("/gestion_ecole/Picture/Warning.png")));
        ValidP.setIcon(new ImageView(new Image("/gestion_ecole/Picture/Warning.png")));
        ValidPA.setIcon(new ImageView(new Image("/gestion_ecole/Picture/Warning.png")));

        ValidF.setMessage("Enter Your Firstname");
        ValidL.setMessage("Enter Your Lastname");
        ValidB.setMessage("Enter Your BrithPlace");
        ValidC.setMessage("Enter Your CIN");
        ValidP.setMessage("Enter Your Phone");
        ValidU.setMessage("Enter Your Username");
        ValidP.setMessage("Enter Your Password");
        ValidPA.setMessage("Enter Your Password");

        Firstname.setValidators(ValidF);
        Lastname.setValidators(ValidL);
        BrithPlace.setValidators(ValidB);
        CIN.setValidators(ValidC);
        Phone.setValidators(ValidC);
        Username.setValidators(ValidU);
        Password.setValidators(ValidP);
        Password1.setValidators(ValidPA);

        Firstname.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                ValidF.setMessage("Enter Your Firstname");
                Firstname.validate();
            }
        });
        Lastname.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                ValidL.setMessage("Enter Your Lastname");
                Lastname.validate();
            }
        });
        BrithPlace.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                ValidB.setMessage("Enter Your BrithPlace");
                BrithPlace.validate();
            }
        });
        CIN.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                ValidC.setMessage("Enter Your CIN");
                CIN.validate();
            }
        });
        Phone.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                ValidP.setMessage("Enter Your Phone");
                Phone.validate();
            }
        });
        Username.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                ValidU.setMessage("Enter Your Username");
                Username.validate();
            }
        });
        Password.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                ValidP.setMessage("Enter Your Password");
                Password.validate();
            }
        });
        Password1.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                ValidPA.setMessage("Enter Your Password");
                Password1.validate();
            }
        });

        Next.setOnMouseClicked((e) -> {
            Timeline changeW = new Timeline();
            KeyFrame closeW = new KeyFrame(Duration.millis(500), new KeyValue(First.layoutXProperty(), -1 * First.getPrefWidth() - 4, Interpolator.EASE_BOTH));
            KeyFrame openW = new KeyFrame(Duration.millis(500), new KeyValue(Secend.layoutXProperty(), 0, Interpolator.EASE_BOTH));
            changeW.getKeyFrames().addAll(closeW, openW);
            changeW.play();
        });
        NextL.setOnMouseClicked((e) -> {
            Timeline changeW = new Timeline();
            KeyFrame closeW = new KeyFrame(Duration.millis(500), new KeyValue(Secend.layoutXProperty(), -1 * Secend.getPrefWidth() - 4, Interpolator.EASE_BOTH));
            KeyFrame openW = new KeyFrame(Duration.millis(500), new KeyValue(LAST.layoutXProperty(), 0, Interpolator.EASE_BOTH));
            changeW.getKeyFrames().addAll(closeW, openW);
            changeW.play();
        });
        Back.setOnMouseClicked((e) -> {
            Timeline changeW = new Timeline();
            KeyFrame closeW = new KeyFrame(Duration.millis(500), new KeyValue(Secend.layoutXProperty(), Secend.getPrefWidth() + 4, Interpolator.EASE_BOTH));
            KeyFrame openW = new KeyFrame(Duration.millis(500), new KeyValue(First.layoutXProperty(), 0, Interpolator.EASE_BOTH));
            changeW.getKeyFrames().addAll(closeW, openW);
            changeW.play();
        });

        BackS.setOnMouseClicked((e) -> {
            Timeline changeW = new Timeline();
            KeyFrame closeW = new KeyFrame(Duration.millis(500), new KeyValue(LAST.layoutXProperty(), LAST.getPrefWidth() + 4, Interpolator.EASE_BOTH));
            KeyFrame openW = new KeyFrame(Duration.millis(500), new KeyValue(Secend.layoutXProperty(), 0, Interpolator.EASE_BOTH));
            changeW.getKeyFrames().addAll(closeW, openW);
            changeW.play();
        });

        ADD.setOnMouseClicked((e) -> {
            if (Firstname.validate() && Lastname.validate() && BrithPlace.validate() && CIN.validate() && Phone.validate() && Username.validate() && Password.validate() && Password1.validate() && (BrithDate.getValue() != null)) {
                if (!Password.getText().equals(Password1.getText())) {
                    ValidPA.setMessage("Incorrect Password");
                    Password1.setText("");
                    Password1.validate();
                } else {
                    user = new Users(Username.getText(), Password.getText(), Position.getText(), Firstname.getText(), Lastname.getText(), BrithPlace.getText(), Date.valueOf(BrithDate.getValue()), CIN.getText(), Phone.getText(), Email.getText(), "None");
                    user.setID(0);
                    user.setPermissionMS(managerStudents);
                    user.setPermissionMU(new ManagerUsers(0, AU.isSelected(), RU.isSelected(), UU.isSelected()));
                    AdminsUsers.addUser(user);
                }
            } else {
                Back.fire();
            }
        });

        Dprt.getItems().add(new Label("All"));
        Mdl.getItems().add(new Label("All"));
        Sbjct.getItems().add(new Label("All"));
        Dprt.getSelectionModel().select(0);
        Mdl.getSelectionModel().select(0);
        Sbjct.getSelectionModel().select(0);

        AdminsUsers.getDep().forEach((d) -> {
            Dprt.getItems().add(new Label(d.getDescription()));
            Dprt.getItems().add(new Label(d.getDescription() + "-1"));
            Dprt.getItems().add(new Label(d.getDescription() + "-2"));
        });

        Dprt.focusedProperty().addListener((e, oldVal, newVal) -> {
            if (!newVal) {
                if (Mdl.getItems().size() != 1) {
                    Mdl.getSelectionModel().select(0);
                    Mdl.getItems().remove(1, Mdl.getItems().size());
                }
                if (Sbjct.getItems().size() != 1) {
                    Sbjct.getSelectionModel().select(0);
                    Sbjct.getItems().remove(1, Sbjct.getItems().size());
                }
                if (!Dprt.getSelectionModel().getSelectedItem().getText().equals("All") && Dprt.getSelectionModel().getSelectedItem().getText().split("-").length != 1) {
                    String dpay = new String(Dprt.getSelectionModel().getSelectedItem().getText());
                    String tdpay[] = dpay.split("-");
                    listMdl = AdminsUsers.getMdl(tdpay[0], tdpay.length == 2 ? Integer.parseInt(tdpay[1]) : 0);
                    listMdl.forEach((M) -> {
                        Mdl.getItems().add(new Label(M.getSemester() + ":" + M.getNumMdl() + ":" + M.getNameMdl()));
                    });

                }
            }
        });
        Mdl.focusedProperty().addListener((e, oldVal, newVal) -> {
            if (!newVal) {
                if (Sbjct.getItems().size() != 1) {
                    Sbjct.getSelectionModel().select(0);
                    Sbjct.getItems().remove(1, Sbjct.getItems().size());
                }
                if (!Mdl.getSelectionModel().getSelectedItem().getText().equals("All")) {

                    List<Subject> sb = AdminsUsers.getSB(listMdl.get(Mdl.getSelectionModel().getSelectedIndex() - 1).getIdM());

                    sb.forEach((S) -> {
                        Sbjct.getItems().add(new Label(S.getDescription()));
                    });

                }
            }
        });
        listA.getItems().add(new CustomizedItem1("", "", "", "", "", "", "", "", "", "", "", "", "", false));
        managerStudents = new ArrayList<>();
        ADDA.setOnMouseClicked((e) -> {
            if (AS.isSelected() || RS.isSelected() || US.isSelected() || AR.isSelected() || RR.isSelected() || UR.isSelected() || AA.isSelected() || RA.isSelected() || UA.isSelected()) {
                SDEPARTMENT = new String("All");
                AdminsUsers.getDep().forEach((d) -> {
                    if (d.getDescription().equals(Dprt.getSelectionModel().getSelectedItem().getText().split("-")[0])) {
                        SDEPARTMENT = d.getName();
                    }
                });

                String SMODULE = Mdl.getSelectionModel().getSelectedItem().getText().split(":").length == 1 ? "All" : Mdl.getSelectionModel().getSelectedItem().getText().split(":")[1];
                String SYEAR = Dprt.getSelectionModel().getSelectedItem().getText().split("-").length == 1 ? "All" : Dprt.getSelectionModel().getSelectedItem().getText().split("-")[1];
                ManagerStudents ms = new ManagerStudents(0, AS.isSelected(), RS.isSelected(), US.isSelected(), AR.isSelected(), RR.isSelected(), UR.isSelected(), AA.isSelected(), RA.isSelected(), UA.isSelected(), SDEPARTMENT, SYEAR, SMODULE, Sbjct.getSelectionModel().getSelectedItem().getText(), listA);

                if (managerStudents.isEmpty()) {
                    managerStudents.add(ms);
                    listA.getItems().add(ms);

                } else {
                    add = true;
                    managerStudents.forEach((mgs) -> {
                        if (mgs.THERE(ms)) {
                            add = false;
                        }
                    });
                    if (b) {
                        managerStudents.remove(m);
                        b = false;
                    }
                    if (add) {
                        managerStudents.add(ms);
                        listA.getItems().add(ms);
                    }
                }
            }
        });

        R.setOnMouseClicked((e) -> {
            if (!listA.getSelectionModel().isEmpty() && listA.getSelectionModel().getSelectedIndex() != 0) {
                managerStudents.remove(listA.getSelectionModel().getSelectedIndex() - 1);
                listA.getItems().remove(listA.getSelectionModel().getSelectedItem());
            }
        });
        //ADDA.
        // TODO
    }

}
