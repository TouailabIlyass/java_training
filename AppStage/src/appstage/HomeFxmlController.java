
package appstage;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;


public class HomeFxmlController  implements Initializable {

    
   @FXML private Button btnAjouter,btnAfficher,btnHisto,btnIncomp,btnModifier,btnSupp;
   @FXML  private  Pane panAjouter,pantab1;
   @FXML private JFXTextField lblNum,lblTitre;
  @FXML private TabPane TabPane;
  @FXML private static FXMLLoader   loader;

    
  @FXML private  void Afficher(ActionEvent event) throws IOException {
      
               ChangePanel("Vue/FXMLAfficher.fxml");
                btnAfficher.getStyleClass().add("selected");
                btnHisto.getStyleClass().removeAll("selected");
                 btnAjouter.getStyleClass().removeAll("selected");
                 btnIncomp.getStyleClass().removeAll("selected");
                 btnModifier.getStyleClass().removeAll("selected");
                 btnSupp.getStyleClass().removeAll("selected");

    }

   
   @FXML public  void Ajouter(ActionEvent event) throws IOException {
                 ChangePanel("Vue/FXMLAjouter.fxml");
                   btnAjouter.getStyleClass().add("selected");
                btnHisto.getStyleClass().removeAll("selected");
                 btnAfficher.getStyleClass().removeAll("selected");
                 btnIncomp.getStyleClass().removeAll("selected");
                 btnModifier.getStyleClass().removeAll("selected");
                 btnSupp.getStyleClass().removeAll("selected");
    }
    @FXML
   private void  Modifier(ActionEvent e) throws IOException {
         ChangePanel("Vue/Modifier.fxml");
           btnModifier.getStyleClass().add("selected");
                btnHisto.getStyleClass().removeAll("selected");
                 btnAfficher.getStyleClass().removeAll("selected");
                 btnIncomp.getStyleClass().removeAll("selected");
                 btnAjouter.getStyleClass().removeAll("selected");
                 btnSupp.getStyleClass().removeAll("selected");
         
    }
   @FXML
   private void  Supprimer(ActionEvent e) throws IOException {
         ChangePanel("Vue/Supprimer.fxml");
           btnSupp.getStyleClass().add("selected");
                btnHisto.getStyleClass().removeAll("selected");
                 btnAfficher.getStyleClass().removeAll("selected");
                 btnIncomp.getStyleClass().removeAll("selected");
                 btnModifier.getStyleClass().removeAll("selected");
                 btnAjouter.getStyleClass().removeAll("selected");
    }
   
   @FXML private void Historique(ActionEvent event) {
                btnHisto.getStyleClass().add("selected");
                btnAjouter.getStyleClass().removeAll("selected");
                 btnAfficher.getStyleClass().removeAll("selected");
                 btnIncomp.getStyleClass().removeAll("selected");
                 btnModifier.getStyleClass().removeAll("selected");
                 btnSupp.getStyleClass().removeAll("selected");
    }

    @FXML
    void IncompletDoc(ActionEvent event) throws IOException {
       ChangePanel("Vue/Incomplet.fxml");
                btnIncomp.getStyleClass().add("selected");
                btnHisto.getStyleClass().removeAll("selected");
                 btnAfficher.getStyleClass().removeAll("selected");
                 btnAjouter.getStyleClass().removeAll("selected");
                 btnModifier.getStyleClass().removeAll("selected");
                 btnSupp.getStyleClass().removeAll("selected");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        try {
           ChangePanel("Vue/FXMLAfficher.fxml");
       } catch (IOException ex) {
            System.out.println(ex.getMessage());
       }
      
    }   
    

    public  void ChangePanel(String fichierxml) throws IOException
    {
                 loader=null;
                 loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource(fichierxml));
                    loader.load();
                    ScrollPane root = loader.getRoot();
                   root.setPrefSize(pantab1.getWidth(), pantab1.getHeight());
                   pantab1.getChildren().setAll(root);
    }
    public static FXMLLoader getLoader()
    {
        return loader;
    }
  
}
