/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author drging
 */
public class RSA extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       try {    
            FXMLLoader    loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("fenet1.fxml")); 
            loader.load();
            Pane root=loader.getRoot();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setTitle("RSA");
           // primaryStage.setHeight(600);
            //primaryStage.setWidth(800);
            //primaryStage.setMinWidth(800);
            //primaryStage.setMinHeight(600);
            } catch(IOException e){
                
            }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
