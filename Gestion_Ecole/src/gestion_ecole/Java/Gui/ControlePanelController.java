/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_ecole.Java.Gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTabPane;
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
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author FiveHearoes
 */
public class ControlePanelController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private JFXTabPane Tabpane;

    @FXML
    private Tab TabUsers;

    @FXML
    private HBox MainU;

    @FXML
    private JFXButton Usr_Show;

    @FXML
    private JFXButton Usr_Add;

    @FXML
    private JFXButton Usr_Remove;

    @FXML
    private JFXButton Usr_Update;

    @FXML
    private StackPane ResultWU;

    @FXML
    private AnchorPane ContentU;

    @FXML
    private JFXButton ExitU;

    @FXML
    private Tab TabStudents;

    @FXML
    private HBox Main;

    @FXML
    private JFXButton Std_Show;

    @FXML
    private JFXButton Std_Add;

    @FXML
    private JFXButton Std_Remove;

    @FXML
    private JFXButton Std_Update;

    @FXML
    private VBox Show;

    @FXML
    private JFXButton Std_Rslt;

    @FXML
    private JFXButton Std_stds;

    @FXML
    private JFXButton Std_Absense;

    @FXML
    private JFXButton Cancel_Show;

    @FXML
    private VBox Add;

    @FXML
    private JFXButton Std_RsltA;

    @FXML
    private JFXButton Std_std;

    @FXML
    private JFXButton Std_AbsenseA;

    @FXML
    private JFXButton Cancel_Add;

    @FXML
    private VBox Update;

    @FXML
    private JFXButton Std_RsltU;

    @FXML
    private JFXButton Std_stdU;

    @FXML
    private JFXButton Std_AbsenseU;

    @FXML
    private JFXButton Cancel_Update;

    @FXML
    private StackPane ResultW;

    @FXML
    private AnchorPane Content;

    @FXML
    private JFXButton Exit;

    private Pane paneU;
    private Pane pane;
    private double LayoutYU;
    private double LayoutY;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ResultW.getChildren().get(0).setClip(new Rectangle(772, 462));
        ResultWU.getChildren().get(0).setClip(new Rectangle(772, 462));

        TabUsers.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/User_Groups.png")));
        TabStudents.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Student_Cente_un.png")));

        TabUsers.selectedProperty().addListener((o, oldval, newval) -> {
            if (newval) {
                TabUsers.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/User_Groups.png")));
                TabStudents.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Student_Cente_un.png")));
            } else {
                TabUsers.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/User_Groups_un.png")));
                TabStudents.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Student_Center.png")));
            }
        });

        Usr_Show.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/CBS_un.png")));
        Usr_Add.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Plus_Math_un.png")));
        Usr_Remove.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Trash_Can_un.png")));
        Usr_Update.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Installing_Updates_un.png")));
        Std_Show.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/CBS_un.png")));
        Std_Add.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Plus_Math_un.png")));
        Std_Remove.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Trash_Can_un.png")));
        Std_Update.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Installing_Updates_un.png")));
        Std_stds.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Student_Male_un.png")));
        Std_Rslt.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Test_Passed_un.png")));
        Std_Absense.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Test_Failed_un.png")));
        Std_Update.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Installing_Updates_un.png")));
        Std_std.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Student_Male_un.png")));
        Std_RsltA.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Test_Passed_un.png")));
        Std_AbsenseA.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Test_Failed_un.png")));
        Std_Update.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Installing_Updates_un.png")));
        Std_stdU.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Student_Male_un.png")));
        Std_RsltU.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Test_Passed_un.png")));
        Std_AbsenseU.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Test_Failed_un.png")));

        Usr_Show.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> {
            Usr_Show.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/CBS.png")));
        });
        Usr_Show.addEventHandler(MouseEvent.MOUSE_EXITED, (e) -> {
            Usr_Show.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/CBS_un.png")));
        });

        Usr_Add.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> {
            Usr_Add.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Plus_Math.png")));
        });
        Usr_Add.addEventHandler(MouseEvent.MOUSE_EXITED, (e) -> {
            Usr_Add.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Plus_Math_un.png")));
        });

        Usr_Remove.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> {
            Usr_Remove.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Trash_Can.png")));
        });
        Usr_Remove.addEventHandler(MouseEvent.MOUSE_EXITED, (e) -> {
            Usr_Remove.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Trash_Can_un.png")));
        });

        Usr_Update.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> {
            Usr_Update.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Installing_Updates.png")));
        });
        Usr_Update.addEventHandler(MouseEvent.MOUSE_EXITED, (e) -> {
            Usr_Update.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Installing_Updates_un.png")));
        });
        Std_Show.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> {
            Std_Show.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/CBS.png")));
        });
        Std_Show.addEventHandler(MouseEvent.MOUSE_EXITED, (e) -> {
            Std_Show.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/CBS_un.png")));
        });

        Std_Add.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> {
            Std_Add.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Plus_Math.png")));
        });
        Std_Add.addEventHandler(MouseEvent.MOUSE_EXITED, (e) -> {
            Std_Add.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Plus_Math_un.png")));
        });

        Std_Remove.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> {
            Std_Remove.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Trash_Can.png")));
        });
        Std_Remove.addEventHandler(MouseEvent.MOUSE_EXITED, (e) -> {
            Std_Remove.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Trash_Can_un.png")));
        });

        Std_Update.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> {
            Std_Update.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Installing_Updates.png")));
        });
        Std_Update.addEventHandler(MouseEvent.MOUSE_EXITED, (e) -> {
            Std_Update.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Installing_Updates_un.png")));
        });
        Std_stds.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> {
            Std_stds.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Student_Male.png")));
        });
        Std_stds.addEventHandler(MouseEvent.MOUSE_EXITED, (e) -> {
            Std_stds.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Student_Male_un.png")));
        });
        Std_Rslt.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> {
            Std_Rslt.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Test_Passed.png")));
        });
        Std_Rslt.addEventHandler(MouseEvent.MOUSE_EXITED, (e) -> {
            Std_Rslt.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Test_Passed_un.png")));
        });
        Std_Absense.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> {
            Std_Absense.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Test_Failed.png")));
        });
        Std_Absense.addEventHandler(MouseEvent.MOUSE_EXITED, (e) -> {
            Std_Absense.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Test_Failed_un.png")));
        });
        Std_std.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> {
            Std_std.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Student_Male.png")));
        });
        Std_std.addEventHandler(MouseEvent.MOUSE_EXITED, (e) -> {
            Std_std.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Student_Male_un.png")));
        });
        Std_RsltA.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> {
            Std_RsltA.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Test_Passed.png")));
        });
        Std_RsltA.addEventHandler(MouseEvent.MOUSE_EXITED, (e) -> {
            Std_RsltA.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Test_Passed_un.png")));
        });
        Std_AbsenseA.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> {
            Std_AbsenseA.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Test_Failed.png")));
        });
        Std_AbsenseA.addEventHandler(MouseEvent.MOUSE_EXITED, (e) -> {
            Std_AbsenseA.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Test_Failed_un.png")));
        });
        Std_stdU.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> {
            Std_stdU.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Student_Male.png")));
        });
        Std_stdU.addEventHandler(MouseEvent.MOUSE_EXITED, (e) -> {
            Std_stdU.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Student_Male_un.png")));
        });
        Std_RsltU.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> {
            Std_RsltU.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Test_Passed.png")));
        });
        Std_RsltU.addEventHandler(MouseEvent.MOUSE_EXITED, (e) -> {
            Std_RsltU.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Test_Passed_un.png")));
        });
        Std_AbsenseU.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> {
            Std_AbsenseU.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Test_Failed.png")));
        });
        Std_AbsenseU.addEventHandler(MouseEvent.MOUSE_EXITED, (e) -> {
            Std_AbsenseU.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Test_Failed_un.png")));
        });

        Usr_Show.setOnMouseClicked((e) -> {
            try {
                paneU = MainU;
                AnchorPane vb = FXMLLoader.load(getClass().getResource("/gestion_ecole/Fxml/ShowUserInfo.fxml"));
                ContentU.getChildren().add(vb);
                ShowWindowsU();
            }catch (IOException ex) {
                Logger.getLogger(ControlePanelController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Usr_Add.setOnMouseClicked((e) -> {
            try {
                paneU = MainU;
                AnchorPane vb = FXMLLoader.load(getClass().getResource("/gestion_ecole/Fxml/AddUser.fxml"));
                ContentU.getChildren().add(vb);
                ShowWindowsU();
            }catch (IOException ex) {
                Logger.getLogger(ControlePanelController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Usr_Update.setOnMouseClicked((e) -> {
            try {
                paneU = MainU;
                AnchorPane vb = FXMLLoader.load(getClass().getResource("/gestion_ecole/Fxml/UpdateUser.fxml"));
                ContentU.getChildren().add(vb);
                ShowWindowsU();
            }catch (IOException ex) {
                Logger.getLogger(ControlePanelController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Usr_Remove.setOnMouseClicked((e) -> {
            try {
                paneU = MainU;
                AnchorPane vb = FXMLLoader.load(getClass().getResource("/gestion_ecole/Fxml/RemoveUser.fxml"));
                ContentU.getChildren().add(vb);
                ShowWindowsU();
            }catch (IOException ex) {
                Logger.getLogger(ControlePanelController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Std_Show.setOnMouseClicked((e) -> {
            Timeline changeW = new Timeline();
            KeyFrame closeW = new KeyFrame(Duration.millis(500), new KeyValue(Main.layoutXProperty(), -1 * Main.getPrefWidth() - 4, Interpolator.EASE_BOTH));
            KeyFrame openW = new KeyFrame(Duration.millis(500), new KeyValue(Show.layoutXProperty(), Main.getLayoutX(), Interpolator.EASE_BOTH));
            changeW.getKeyFrames().addAll(closeW, openW);
            changeW.play();
        });
        Std_Add.setOnMouseClicked((e) -> {
            Timeline changeW = new Timeline();
            KeyFrame closeW = new KeyFrame(Duration.millis(500), new KeyValue(Main.layoutXProperty(), -1 * Main.getPrefWidth() - 4, Interpolator.EASE_BOTH));
            KeyFrame openW = new KeyFrame(Duration.millis(500), new KeyValue(Add.layoutXProperty(), Main.getLayoutX(), Interpolator.EASE_BOTH));
            changeW.getKeyFrames().addAll(closeW, openW);
            changeW.play();
        });
        Std_Update.setOnMouseClicked((e) -> {
            Timeline changeW = new Timeline();
            KeyFrame closeW = new KeyFrame(Duration.millis(500), new KeyValue(Main.layoutXProperty(), 804, Interpolator.EASE_BOTH));
            KeyFrame openW = new KeyFrame(Duration.millis(500), new KeyValue(Update.layoutXProperty(), Main.getLayoutX(), Interpolator.EASE_BOTH));
            changeW.getKeyFrames().addAll(closeW, openW);
            changeW.play();
        });
        Cancel_Show.setOnMouseClicked((e) -> {
            Timeline changeW = new Timeline();
            KeyFrame closeW = new KeyFrame(Duration.millis(500), new KeyValue(Show.layoutXProperty(), 802, Interpolator.EASE_BOTH));
            KeyFrame openW = new KeyFrame(Duration.millis(500), new KeyValue(Main.layoutXProperty(), Show.getLayoutX(), Interpolator.EASE_BOTH));
            changeW.getKeyFrames().addAll(closeW, openW);
            changeW.play();
        });
        Cancel_Add.setOnMouseClicked((e) -> {
            Timeline changeW = new Timeline();
            KeyFrame closeW = new KeyFrame(Duration.millis(500), new KeyValue(Add.layoutXProperty(), 804, Interpolator.EASE_BOTH));
            KeyFrame openW = new KeyFrame(Duration.millis(500), new KeyValue(Main.layoutXProperty(), Add.getLayoutX(), Interpolator.EASE_BOTH));
            changeW.getKeyFrames().addAll(closeW, openW);
            changeW.play();
        });
        Cancel_Update.setOnMouseClicked((e) -> {
            Timeline changeW = new Timeline();
            KeyFrame closeW = new KeyFrame(Duration.millis(500), new KeyValue(Update.layoutXProperty(), -1 * Update.getPrefWidth() - 4, Interpolator.EASE_BOTH));
            KeyFrame openW = new KeyFrame(Duration.millis(500), new KeyValue(Main.layoutXProperty(), Update.getLayoutX(), Interpolator.EASE_BOTH));
            changeW.getKeyFrames().addAll(closeW, openW);
            changeW.play();
        });

        Std_Remove.setOnMouseClicked((e) -> {
            try {
                pane = Main;
                AnchorPane vb = FXMLLoader.load(getClass().getResource("/gestion_ecole/Fxml/RemoveStd.fxml"));
                Content.getChildren().add(vb);
                ShowWindows();
            } catch (IOException ex) {
                Logger.getLogger(ControlePanelController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Std_Rslt.setOnMouseClicked((e) -> {
            try {
                pane = Show;
                AnchorPane vb = FXMLLoader.load(getClass().getResource("/gestion_ecole/Fxml/ShowResult.fxml"));
                Content.getChildren().add(vb);
                ShowWindows();
            } catch (IOException ex) {
                Logger.getLogger(ControlePanelController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Std_stds.setOnMouseClicked((e) -> {
            try {
                pane = Show;
                AnchorPane vb = FXMLLoader.load(getClass().getResource("/gestion_ecole/Fxml/ShowStudentInfo.fxml"));
                Content.getChildren().add(vb);
                ShowWindows();
            } catch (IOException ex) {
                Logger.getLogger(ControlePanelController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Std_Absense.setOnMouseClicked((e) -> {
            try {
                pane = Show;
                AnchorPane vb = FXMLLoader.load(getClass().getResource("/gestion_ecole/Fxml/ShowAbsence.fxml"));
                Content.getChildren().add(vb);
                ShowWindows();
            } catch (IOException ex) {
                Logger.getLogger(ControlePanelController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        Std_RsltA.setOnMouseClicked((e) -> {
            try {
                pane = Add;
                AnchorPane vb = FXMLLoader.load(getClass().getResource("/gestion_ecole/Fxml/AddResult.fxml"));
                Content.getChildren().add(vb);
                ShowWindows();
            } catch (IOException ex) {
                Logger.getLogger(ControlePanelController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Std_std.setOnMouseClicked((e) -> {
            try {
                pane = Add;
                AnchorPane vb = FXMLLoader.load(getClass().getResource("/gestion_ecole/Fxml/AddStudent.fxml"));
                Content.getChildren().add(vb);
                ShowWindows();
            } catch (IOException ex) {
                Logger.getLogger(ControlePanelController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Std_AbsenseA.setOnMouseClicked((e) -> {
            try {
                pane = Add;
                AnchorPane vb = FXMLLoader.load(getClass().getResource("/gestion_ecole/Fxml/AddAbsence.fxml"));
                Content.getChildren().add(vb);
                ShowWindows();
            } catch (IOException ex) {
                Logger.getLogger(ControlePanelController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        Std_RsltU.setOnMouseClicked((e) -> {
            try {
                pane = Update;
                AnchorPane vb = FXMLLoader.load(getClass().getResource("/gestion_ecole/Fxml/UpdateRslt.fxml"));
                Content.getChildren().add(vb);
                ShowWindows();
            } catch (IOException ex) {
                Logger.getLogger(ControlePanelController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Std_stdU.setOnMouseClicked((e) -> {
            try {
                pane = Update;
                AnchorPane vb = FXMLLoader.load(getClass().getResource("/gestion_ecole/Fxml/UpdateStd.fxml"));
                Content.getChildren().add(vb);
                ShowWindows();
            } catch (IOException ex) {
                Logger.getLogger(ControlePanelController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Std_AbsenseU.setOnMouseClicked((e) -> {
            try {
                pane = Update;
                AnchorPane vb = FXMLLoader.load(getClass().getResource("/gestion_ecole/Fxml/UpdateAbsence.fxml"));
                Content.getChildren().add(vb);
                ShowWindows();
            } catch (IOException ex) {
                Logger.getLogger(ControlePanelController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        ExitU.setOnMouseClicked((e) -> {
            HideWindowsU();
        });
        Exit.setOnMouseClicked((e) -> {
            HideWindows();
        });
        
        Usr_Add.setDisable(!GestionEcole.user.getPermissionMU().isAddUser());;
        Usr_Remove.setDisable(!GestionEcole.user.getPermissionMU().isRemoveUser());
        Usr_Update.setDisable(!GestionEcole.user.getPermissionMU().isUpdateUser());

    }

    private void ShowWindows() {
        Timeline changeW = new Timeline();
        LayoutY = pane.getLayoutY();
        KeyFrame closeW = new KeyFrame(Duration.millis(500), new KeyValue(pane.layoutYProperty(), 490, Interpolator.EASE_BOTH));
        KeyFrame openW = new KeyFrame(Duration.millis(500), new KeyValue(ResultW.layoutYProperty(), 0, Interpolator.EASE_BOTH));
        changeW.getKeyFrames().addAll(closeW, openW);
        changeW.play();
    }

    private void HideWindows() {
        Timeline changeW = new Timeline();
        KeyFrame closeW = new KeyFrame(Duration.millis(500), new KeyValue(ResultW.layoutYProperty(), -500, Interpolator.EASE_BOTH));
        KeyFrame openW = new KeyFrame(Duration.millis(500), new KeyValue(pane.layoutYProperty(), LayoutY, Interpolator.EASE_BOTH));
        changeW.getKeyFrames().addAll(closeW, openW);
        changeW.play();
        changeW.setOnFinished((e) -> {
            if (!Content.getChildren().isEmpty()) {
                Content.getChildren().remove(0);
            }
        });
    }
    private void ShowWindowsU() {
        Timeline changeW = new Timeline();
        LayoutYU = paneU.getLayoutY();
        KeyFrame closeW = new KeyFrame(Duration.millis(500), new KeyValue(paneU.layoutYProperty(), 490, Interpolator.EASE_BOTH));
        KeyFrame openW = new KeyFrame(Duration.millis(500), new KeyValue(ResultWU.layoutYProperty(), 0, Interpolator.EASE_BOTH));
        changeW.getKeyFrames().addAll(closeW, openW);
        changeW.play();
    }

    private void HideWindowsU() {
        Timeline changeW = new Timeline();
        KeyFrame closeW = new KeyFrame(Duration.millis(500), new KeyValue(ResultWU.layoutYProperty(), -500, Interpolator.EASE_BOTH));
        KeyFrame openW = new KeyFrame(Duration.millis(500), new KeyValue(paneU.layoutYProperty(), LayoutYU, Interpolator.EASE_BOTH));
        changeW.getKeyFrames().addAll(closeW, openW);
        changeW.play();
        changeW.setOnFinished((e) -> {
            if (!ContentU.getChildren().isEmpty()) {
                ContentU.getChildren().remove(0);
            }
        });
    }

}
