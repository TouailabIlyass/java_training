/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_ecole.Java.Gui;

import com.jfoenix.controls.JFXButton;
import gestion_ecole.Java.Control.AdminsDB;
import gestion_ecole.Java.Control.Person;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

/**
 *
 * @author FiveHearoes
 */
public class CustomizedItem extends HBox {

    private HBox item;
    private Label Firstname;
    private Label Lastname;
    private JFXButton remove;

    private final Person prs;
    private final ListView<CustomizedItem> list;

    public CustomizedItem(Person prs, ListView<CustomizedItem> list) {
        this.prs = prs;
        this.list = list;

        init();
    }

    private void init() {

        try {
            item = FXMLLoader.load(getClass().getResource("/gestion_ecole/Fxml/Item.fxml"));

            Firstname = (Label) item.getChildren().get(0);
            Lastname = (Label) item.getChildren().get(1);
            remove = (JFXButton) item.getChildren().get(2);

            remove.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Trash_un.png")));
            remove.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> {
                remove.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Trash.png")));
            });
            remove.addEventHandler(MouseEvent.MOUSE_EXITED, (e) -> {
                remove.setGraphic(new ImageView(new Image("/gestion_ecole/Picture/Trash_un.png")));
            });
            remove.setOnMouseClicked((e) -> {
                if(!prs.getFirstname().equals("None"))
                {
                    AdminsDB.prsDelete(prs.getID());
                }
                list.getItems().remove(this);
            });

            Firstname.setText(prs.getFirstname());
            Lastname.setText(prs.getLastname());

            setPrefHeight(item.getPrefHeight());
            setPrefWidth(item.getPrefWidth());

            setPadding(item.getPadding());

            getChildren().addAll(item.getChildren().get(0), item.getChildren().get(1), item.getChildren().get(2));
        } catch (IOException ex) {
            Logger.getLogger(CustomizedItem.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
