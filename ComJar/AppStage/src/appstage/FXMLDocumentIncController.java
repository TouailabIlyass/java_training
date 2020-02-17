
package appstage;

import static appstage.FXMLAfficherController.connexion;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableView.TreeTableViewFocusModel;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class FXMLDocumentIncController extends FXMLAfficherController {
    
    @FXML private JFXTreeTableView <Dossier> listeview;
    
    @FXML  private JFXButton btncomp;
  private int column;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
  
       SetColumn();
        System.out.println("appstage.FXMLDocumentIncController.initialize()");
       try {
           Afficher();
       } catch (SQLException ex) {
           Logger.getLogger(FXMLAfficherController.class.getName()).log(Level.SEVERE, null, ex);
       }
       
      
    }    
    
    
    @Override
    public void Afficher() throws SQLException
    {  System.out.println("appstage.FXMLDocumentIncController.Afficher()");
        
        
         PreparedStatement prepStat;
         
        prepStat=connexion.prepareStatement("select ds.id,ds.Titre,Achats.Acheteur,Achats.Entite,Besion.Type,Besion.DA,Besion.DateAffec,Besion.SCE,Besion.Estimation,chefProjet.chef,Besion.Objet,RFI.NumRFI,RFI.Date, RFI.Echeange,CGAO.NumPV,CGAO.Date,AO.NumAO,AO.DateAO,AO.Echeange,AO.Relance,COF.DateTech,COF.DateAvis,COF.DateCom,AE.Nature,AE.Annee,AE.MontantAE,AE.MontantEngage ,AE.NumAE,AE.DateAE,AE.DateArrive,CAD.PVNum,CAD.DateCAD,CAD.Signataire,CAD.Adjudicataire,CAD.Origine,CAD.NumCDE,CAD.DateCDE,CAD.SignataireCDE,CAD.Delai,CAD.Montant ,CAD.Situation,CAD.Observation FROM ds,Achats,Besion,RFI,CGAO,AO,COF,AE,CAD,chefProjet WHERE ds.Complet = 0 && ds.NumAcheteur=Achats.id && Besion.NumDossier=ds.id && RFI.NumDossier=ds.id && CGAO.NumDossier=ds.id && AO.NumDossier=ds.id && COF.NumDossier=ds.id && AE.NumDossier=ds.id && CAD.NumDossier=ds.id && Besion.ChefProjet=chefProjet.id");
               
        ResultSet result=prepStat.executeQuery();
        
         ObservableList<Dossier> ds= FXCollections.observableArrayList();
        while (result.next()) 
            ds.add(new Dossier(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getString(8),result.getString(9),result.getString(10),result.getString(11),result.getString(12),result.getString(13),result.getString(14),result.getString(15),result.getString(16),result.getString(17),result.getString(18),result.getString(19),result.getString(20),result.getString(21),result.getString(22),result.getString(23),result.getString(24),result.getString(25),result.getString(26),result.getString(27),result.getString(28),result.getString(29),result.getString(30),result.getString(31),result.getString(32),result.getString(33),result.getString(34),result.getString(35),result.getString(36),result.getString(37),result.getString(38),result.getString(39),result.getString(40),result.getString(41),result.getString(42)));
  
        TreeItem<Dossier> root= new RecursiveTreeItem<Dossier>(ds,RecursiveTreeObject::getChildren);
                listeview.setRoot(root);
                
        
    }
    
     @FXML
   public void OnClick(ActionEvent e) throws IOException {
       TreeTableViewFocusModel<Dossier> T=listeview.getFocusModel();
        TreeItem<Dossier> test;
        test = listeview.getTreeItem(T.getFocusedIndex());
         System.out.println(test.toString());
  String str=test.toString();
 str= str.substring(str.indexOf(":")+2);
                 System.out.println(str);
         String [] column=str.split("  ");
         
         for (String s: column) {
             System.out.print(s+":");
         }
         
         
         
                 
             Stage stg=FXMLDocumentController.getLoader();
         Scene sc=stg.getScene();
         Pane p =(Pane) sc.lookup("#pantab1");
         
           FXMLLoader  loader = new FXMLLoader();
                 
                    loader.setLocation(getClass().getResource("Vue/FXMLAjouter.fxml"));
                    loader.load();
                    ScrollPane root = loader.getRoot();
                    FXMLAjouterController controle = loader.getController();
                   root.setPrefSize(p.getWidth(), p.getHeight());
                   
                   controle.NumDossier.setText(column[0]);
                   controle.TitreDossier.setText(column[1]);
                   controle.Acheteur.setValue(column[2]);
                   controle.Entite.setValue(column[3]);
                   controle.BesionType.setValue(column[4]);
                   controle.NDA.setText(column[5]);
                   if(column[6].equals("") || column[6].equals("NULL"))
                   {
                      controle.DateAffec.setValue(fromDate(Date.valueOf(column[6])));  
                   }
                  
                    controle.SCE.setValue(column[7]);
                    controle.Estimation.setText(column[8]);
                    controle.ChefProjet.setValue(column[9]);
                   
                   
                   
                   p.getChildren().setAll(root);
                   
                   
         


   
    }
   public static LocalDate fromDate(Date date) {
    Instant instant = Instant.ofEpochMilli(date.getTime());
    return LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
        .toLocalDate();
  }
    
}
