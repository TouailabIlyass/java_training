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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author FiveHearoes
 */
public class RemoveStdController implements Initializable {

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
    private JFXListView<CustomizedItem> ListView;

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

                ListView.getItems().add(new CustomizedItem(new Students(), ListView));
            } else {
                stds.forEach((s) -> {
                    ListView.getItems().add(new CustomizedItem(s, ListView));
                });

            }
        }
        );

        // TODO
    }

}
