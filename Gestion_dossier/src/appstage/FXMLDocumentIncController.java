
package appstage;

import static appstage.FXMLAfficherController.connexion;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;


public class FXMLDocumentIncController extends FXMLAfficherController {
    
    @FXML private JFXTreeTableView <Dossier> listeview;
    
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
         
        prepStat=connexion.prepareStatement("select ds.id,ds.Titre,Achats.Acheteur,Achats.Entite,Besion.Type,Besion.DA,Besion.DateAffec,Besion.SCE,Besion.Estimation,chefProjet.chef,Besion.Objet,RFI.NumRFI,RFI.Date, RFI.Echeange,CGAO.NumPV,CGAO.Date,AO.NumAO,AO.DateAO,AO.Echeange,AO.Relance,COF.DateTech,COF.DateAvis,COF.DateCom,AE.Nature,AE.Annee,AE.MontantAE,AE.MontantEngage ,AE.NumAE,AE.DateAE,AE.DateArrive,CAD.PVNum,CAD.DateCAD,CAD.Signataire,CAD.Adjudicataire,CAD.Origine,CAD.NumCDE,CAD.DateCDE,CAD.SignataireCDE,CAD.Delai,CAD.Montant ,CAD.Situation,CAD.Observation FROM ds,Achats,Besion,RFI,CGAO,AO,COF,AE,CAD,chefProjet WHERE  ds.id = 1");
               
        ResultSet result=prepStat.executeQuery();
        
         ObservableList<Dossier> ds= FXCollections.observableArrayList();
        while (result.next()) 
            ds.add(new Dossier(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getString(8),result.getString(9),result.getString(10),result.getString(11),result.getString(12),result.getString(13),result.getString(14),result.getString(15),result.getString(16),result.getString(17),result.getString(18),result.getString(19),result.getString(20),result.getString(21),result.getString(22),result.getString(23),result.getString(24),result.getString(25),result.getString(26),result.getString(27),result.getString(28),result.getString(29),result.getString(30),result.getString(31),result.getString(32),result.getString(33),result.getString(34),result.getString(35),result.getString(36),result.getString(37),result.getString(38),result.getString(39),result.getString(40),result.getString(41),result.getString(42)));
  
        TreeItem<Dossier> root= new RecursiveTreeItem<Dossier>(ds,RecursiveTreeObject::getChildren);
                listeview.setRoot(root);
        
    }
    
    
    
}
