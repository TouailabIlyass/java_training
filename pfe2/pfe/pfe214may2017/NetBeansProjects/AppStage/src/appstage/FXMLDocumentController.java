
package appstage;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FXMLDocumentController  implements Initializable {
    
   
  @FXML private JFXTextField user;
  @FXML private JFXButton suivant,cancel;
  @FXML private JFXPasswordField passwd;
  @FXML private Label lbl;
  private FXMLLoader loaderMain;
  private Stage stg;
  private static  Connection connexion;
   private static Scene sc;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         connexion =  ConnexionDB.getInstance().getConnexion();
         
         
    }   

    
   @FXML public  void Conncet(ActionEvent event) throws SQLException, IOException {
          int id=1;
    
       PreparedStatement prepStat=connexion.prepareStatement("select user,pass from Admin where id= ?");
       prepStat.setInt(1, id);
       String user2="",passwd2="";
       
       ResultSet result=prepStat.executeQuery();
       System.out.println("okkkkkkkkkkkkkkkkk");
      result.next();
     user2=result.getString(1);
     passwd2=result.getString(2);   
   
       if(user.getText().equals(user2) && passwd.getText().equals(passwd2))
       {
          stg=AppStage.getStage();
         FXMLLoader   loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("Vue/Home.fxml"));
                    loader.load();
                    Pane root = loader.getRoot();
                   Scene sc =new Scene(root);
                   sc.getStylesheets().add(getClass().getResource("css/main.css").toExternalForm());
                   stg.close();
                   stg= new Stage();
                   stg.setScene(sc);
                   stg.show();
                   stg.widthProperty().addListener((Observable e) -> {
            if(stg.getWidth() < 600) {
                System.out.println("apps)");
            } else {
             if(sc.lookup("#TabPane") != null) {
               if(sc.lookup("#panAjouter") != null) 
                 {  Pane pan=(Pane)sc.lookup("#pantab1"); 
                    pan.setPrefSize(stg.getWidth()-163,stg.getHeight());
                    ScrollPane scroll = (ScrollPane) sc.lookup("#scroll");
                    scroll.setPrefSize(stg.getWidth()-163,stg.getHeight());
                    Pane pan2=(Pane)sc.lookup("#panAjouter");  
                    pan2.setPrefWidth(stg.getWidth()-163);
                   
                  }
               else if(sc.lookup("#scroll2") != null)
               {   ScrollPane scroll = (ScrollPane) sc.lookup("#scroll2");
                    scroll.setPrefSize(stg.getWidth()-163,stg.getHeight());
                   Pane pan=(Pane)sc.lookup("#pantab1"); 
                  
                   BorderPane bp = (BorderPane) sc.lookup("#borderp");
                    pan.setPrefSize(stg.getWidth()-163,stg.getHeight());
                   bp.setPrefHeight(stg.getHeight());
                   
               }
               }
                 
            }
        });
                   
                   stg.heightProperty().addListener((Observable e) -> {
            if(stg.getWidth() < 600) {
                System.out.println("apps)");
            } else {
             if(sc.lookup("#TabPane") != null) {
               if(sc.lookup("#panAjouter") != null) 
                 {  Pane pan=(Pane)sc.lookup("#pantab1"); 
                    pan.setPrefSize(stg.getWidth()-163,stg.getHeight());
                    ScrollPane scroll = (ScrollPane) sc.lookup("#scroll");
                    scroll.setPrefSize(stg.getWidth()-163,stg.getHeight());
                    Pane pan2=(Pane)sc.lookup("#panAjouter");  
                    pan2.setPrefWidth(stg.getWidth()-163);
                   
                  }
               else if(sc.lookup("#scroll2") != null)
               {   
                   Pane pan=(Pane)sc.lookup("#pantab1"); 
                  pan.setPrefSize(stg.getWidth()-163,stg.getHeight()-70);
                   BorderPane bp = (BorderPane) sc.lookup("#borderp");
                   bp.setPrefHeight(stg.getHeight()-70);
                   ScrollPane scroll = (ScrollPane) sc.lookup("#scroll2");
                    scroll.setPrefSize(stg.getWidth()-163,stg.getHeight()-60);
                   
               }
               }
                 
            }
        });
                   
   
      
       }    
          
       
       else
           lbl.setText("user ou mot de passe incorrecte !!");
    }
   
   
   @FXML void Cancel(ActionEvent event) {
      stg=AppStage.getStage();

       stg.close();
       

    }
    
    
}
