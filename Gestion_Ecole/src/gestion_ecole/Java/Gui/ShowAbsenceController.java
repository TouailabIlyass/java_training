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
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import gestion_ecole.Java.Control.AdminsStudents;
import gestion_ecole.Java.Control.Students;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Function;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author FiveHearoes
 */
public class ShowAbsenceController implements Initializable {

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
    private VBox Last;

    @FXML
    private JFXTreeTableView<Absenc> treeTableView;

    @FXML
    private JFXTreeTableColumn<Absenc, String> MDLC;

    @FXML
    private JFXTreeTableColumn<Absenc, String> SBJCTC;

    @FXML
    private JFXTreeTableColumn<Absenc, String> DATEC;

    @FXML
    private JFXTreeTableColumn<Absenc, String> TIMEC;

    @FXML
    private JFXTreeTableColumn<Absenc, String> NBHC;

    @FXML
    private JFXTreeTableColumn<Absenc, String> JSC;

    @FXML
    private JFXButton Back;

    private List<Students> stds;

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
            } else {
                stds.forEach((s) -> {
                    ListView.getItems().add(new Label(s.getLastname() + "  " + s.getFirstname()));
                });
                ListView.setOnMouseClicked((l) -> {
                    if (!ListView.getSelectionModel().isEmpty()) {
                        ObservableList<Absenc> dummyData = getListAb(stds.get(ListView.getSelectionModel().getSelectedIndex()).getIDS());
                        treeTableView.setRoot(new RecursiveTreeItem<>(dummyData, RecursiveTreeObject::getChildren));
                        treeTableView.setShowRoot(false);
                        Timeline changeW = new Timeline();
                        KeyFrame closeW = new KeyFrame(Duration.millis(500), new KeyValue(First.layoutXProperty(), -1 * First.getPrefWidth() - 4, Interpolator.EASE_BOTH));
                        KeyFrame openW = new KeyFrame(Duration.millis(500), new KeyValue(Last.layoutXProperty(), 0, Interpolator.EASE_BOTH));
                        changeW.getKeyFrames().addAll(closeW, openW);
                        changeW.play();
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

        setupCellValueFactory(MDLC, Absenc::getMDL);
        setupCellValueFactory(SBJCTC, Absenc::getSBJCT);
        setupCellValueFactory(DATEC, Absenc::getDATE);
        setupCellValueFactory(TIMEC, Absenc::getTIME);
        setupCellValueFactory(NBHC, Absenc::getNH);
        setupCellValueFactory(JSC, Absenc::getJS);

        // TODO
    }

    private <T> void setupCellValueFactory(JFXTreeTableColumn<Absenc, T> column, Function<Absenc, ObservableValue<T>> mapper) {
        column.setCellValueFactory((TreeTableColumn.CellDataFeatures<Absenc, T> param) -> {
            if (column.validateValue(param)) {
                return mapper.apply(param.getValue().getValue());
            } else {
                return column.getComputedValue(param);
            }
        });
    }

    private ObservableList<Absenc> getListAb(int IDS) {
        ObservableList<Absenc> listAb = FXCollections.observableArrayList();
        AdminsStudents.getAb(IDS).forEach((Ab) -> {
            String MDL = new String(AdminsStudents.getM(Ab.getCrs().getID_SBJ()).getNameMdl());
            String SBJCT = new String(AdminsStudents.getS(Ab.getCrs().getID_SBJ()).getName());
            listAb.add(new Absenc(MDL, SBJCT, Ab.getCrs().getDATE_CRS().toLocalDate().toString(), Ab.getCrs().getTIME_CRS().toLocalTime().toString(), String.valueOf(Ab.getCrs().getNbrH()), String.valueOf(Ab.getJUST())));
        });
        return listAb;
    }

    static final class Absenc extends RecursiveTreeObject<Absenc> {

        final StringProperty MDL;
        final StringProperty SBJCT;
        final StringProperty DATE;
        final StringProperty TIME;
        final StringProperty NH;
        final StringProperty JS;

        public Absenc(String MDL, String SBJCT, String DATE, String TIME, String NH, String JS) {
            this.MDL = new SimpleStringProperty(MDL);
            this.SBJCT = new SimpleStringProperty(SBJCT);
            this.DATE = new SimpleStringProperty(DATE);
            this.TIME = new SimpleStringProperty(TIME);
            this.NH = new SimpleStringProperty(NH);
            this.JS = new SimpleStringProperty(JS);
        }

        public StringProperty getMDL() {
            return MDL;
        }

        public StringProperty getSBJCT() {
            return SBJCT;
        }

        public StringProperty getDATE() {
            return DATE;
        }

        public StringProperty getTIME() {
            return TIME;
        }

        public StringProperty getNH() {
            return NH;
        }

        public StringProperty getJS() {
            return JS;
        }

    }

}
