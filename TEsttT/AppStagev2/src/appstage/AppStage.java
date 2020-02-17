
package appstage;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class AppStage extends Application {
    private static FXMLLoader loader;
    private static Stage stg;
    @Override
    public void start(Stage stage) throws Exception {
        
                    loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("Vue/FXMLDocument.fxml"));
                    loader.load();
        
                    
        Pane root = loader.getRoot();
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("css/main.css").toExternalForm());
        
        stage.setScene(scene);
        stage.setTitle("Gestion des dossiers");
        stage.show();
        stg=stage;
   stage.widthProperty().addListener((Observable e) -> {
            if(stage.getWidth() < 600) {
                System.out.println("apps)");
            } else {
              if(scene.lookup("#pan") != null) 
              {
                 Pane pan=(Pane)scene.lookup("#pan");  
                 pan.setLayoutX(stage.getWidth()/4);
                pan.setLayoutY(stage.getHeight()/4);
              } 
  
                 
                 
            }
        });
   
   
    }
    
  

  public static Stage getStage()
  {
      return stg;
  }
    
public static void Exit()
{
    stg.close();
}
    public static FXMLLoader getLoader()
    {
        return loader;
        
    }
    public static void main(String[] args) {
       launch(args);
       
      
       
    }
    
}
