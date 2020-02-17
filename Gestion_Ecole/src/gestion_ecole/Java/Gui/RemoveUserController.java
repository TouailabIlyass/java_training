/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_ecole.Java.Gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import gestion_ecole.Java.Control.AdminsUsers;
import gestion_ecole.Java.Control.Students;
import gestion_ecole.Java.Control.Users;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author FiveHearoes
 */
public class RemoveUserController implements Initializable {

    @FXML
    private JFXTextField FirstnameF;

    @FXML
    private JFXButton Show;

    @FXML
    private JFXListView<CustomizedItem> ListView;
    
    private List<Users> users;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Show.setOnMouseClicked((e) -> {
            ListView.getItems().clear();
            users = AdminsUsers.getUsers(FirstnameF.getText());
            if (users.isEmpty()) {

                ListView.getItems().add(new CustomizedItem(new Students(), ListView));
            } else {
                users.forEach((s) -> {
                    ListView.getItems().add(new CustomizedItem(s, ListView));
                });
            }
        }
        );
        // TODO
    }

}
