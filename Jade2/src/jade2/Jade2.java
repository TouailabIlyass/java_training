/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jade2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Jade2 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("FXMLDocument.fxml")); 
       
        loader.load();
        Parent root=loader.getRoot();
        Scene scene = new Scene(root,600,600);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Mini Projet");
        String [] x={"-gui", "F1:jade2.feux1;F2:jade2.feux2;"};
         jade.Boot.main(x);
        
        
       
        
    }

   
    public static void main(String[] args) {
     
        launch(args);
      
        
       
    }
    
}
