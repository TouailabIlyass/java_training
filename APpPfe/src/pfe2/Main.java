package pfe2;
	
import com.jfoenix.controls.JFXHamburger;
import java.io.IOException;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;



public class Main extends Application {
     private static FXMLLoader loader;
	@Override
	public void start(Stage primaryStage) {
		try {    
                    loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("fenetrexml.fxml")); 
                   
                    loader.load();
                    
                    
			
                         
                        Pane root=loader.getRoot();
                      
			Scene scene = new Scene(root);
			
			primaryStage.setScene(scene);
                       
			primaryStage.show();
                        primaryStage.setTitle("simulation Lois optique");
			primaryStage.setHeight(600);
			primaryStage.setWidth(800);
			primaryStage.setMinWidth(800);
			primaryStage.setMinHeight(600);
			Control.setStage(primaryStage);
             
                        primaryStage.heightProperty().addListener((Observable e) -> {
                            
                            Control c = loader.getController();
                             c.Init();
                             
                        
                          
                         
                        
                        });
                        
                        primaryStage.widthProperty().addListener((Observable e) -> {
                             
                            Control c = loader.getController();
                            c.Init();
                         JFXHamburger   hamburger= (JFXHamburger) scene.lookup("#hamburger");
                         hamburger.setLayoutX(primaryStage.getWidth()-45);
                                   
                        });
                        
                        Control c= loader.getController();
                        c.Calculer();
                        //Control.setP(root); 
                        
                        
                       
		} catch(IOException e) {
		}
                
                
      
	}
       
        
       public static FXMLLoader getCtl()
      {
          return loader;
      }
        
        
        
	
	public static void main(String[] args) {
		launch(args);
	}
        
        
    
        
}
