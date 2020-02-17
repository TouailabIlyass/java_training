/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_ecole.Java;

import gestion_ecole.Java.Control.Users;
import gestion_ecole.Java.Gui.CustomizedStage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author FiveHearoes
 */
public class GestionEcole extends Application {
    
    private static Stage primaryStage;
    public static Users user;


    public  void start(Stage stage) throws Exception {
        primaryStage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("/gestion_ecole/Fxml/LogIn.fxml"));

        CustomizedStage cs = new CustomizedStage(stage, root,true);

        Scene scene = new Scene(cs);
        scene.getStylesheets().add(getClass().getResource("/gestion_ecole/Css/GestionEcoleStyle.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    
    public static void changeScene(String sceneN) {
        try {
            Parent root = FXMLLoader.load(GestionEcole.class.getResource("/gestion_ecole/Fxml/"+sceneN));
            CustomizedStage cs = new CustomizedStage(primaryStage, root,false);
            Scene scene = new Scene(cs);
            scene.getStylesheets().add(GestionEcole.class.getResource("/gestion_ecole/Css/GestionEcoleStyle.css").toExternalForm());
            primaryStage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(GestionEcole.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
