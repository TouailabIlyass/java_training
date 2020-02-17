/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appstage;

import static appstage.FXMLAfficherController.connexion;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableView;

/**
 *
 * @author kingdragon
 */
public class Supp extends FXMLAfficherController{
    
    @FXML private JFXTreeTableView <Dossier> listeview;
    
    @FXML  private JFXButton btncomp;
  private int column;
  
  
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
  
       SetColumn();
        
       try {
           Afficher();
       } catch (SQLException ex) {
           System.out.println(ex.getMessage());
       }
       
  
    }    
    
    
    @Override
    public void Afficher() throws SQLException
    { 
        
        
         PreparedStatement prepStat;
        
        prepStat=connexion.prepareStatement("select ds.id,ds.Titre,Achats.Acheteur,Entite.entite,Type.type,Besion.DA,Besion.DateAffec,EntiteSCE.entite,Besion.Estimation,chefProjet.chef,Besion.Objet,RFI.NumRFI,RFI.Date, RFI.Echeange,CGAO.NumPV,CGAO.Date,AO.NumAO,AO.DateAO,AO.Echeange,AO.Relance,COF.DateTech,COF.DateAvis,COF.DateCom,Nature.nature,AE.Annee,AE.MontantAE,AE.MontantEngage ,AE.NumAE,AE.DateAE,AE.DateArrive,CAD.PVNum,CAD.DateCAD,Sig.Nom,CAD.Adjudicataire,CAD.Origine,CAD.NumCDE,CAD.DateCDE,Sig.Nom,CAD.Delai,CAD.Montant ,CAD.Situation,CAD.Observation FROM ds,Achats,Besion,RFI,CGAO,AO,COF,AE,CAD,chefProjet,Entite,Type,Sig,Nature,EntiteSCE WHERE ds.NumAcheteur=Achats.id && Besion.NumDossier=ds.id && RFI.NumDossier=ds.id && CGAO.NumDossier=ds.id && AO.NumDossier=ds.id && COF.NumDossier=ds.id && AE.NumDossier=ds.id && CAD.NumDossier=ds.id && Besion.ChefProjet=chefProjet.id && Achats.Entite=Entite.id && Besion.Type=Type.id && Besion.SCE=EntiteSCE.id && AE.idNature=Nature.id && CAD.Signataire=Sig.id && CAD.SignataireCDE=Sig.id");
               
        ResultSet result=prepStat.executeQuery();
        
         ObservableList<Dossier> ds= FXCollections.observableArrayList();
        while (result.next()) 
            ds.add(new Dossier(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getString(8),result.getString(9),result.getString(10),result.getString(11),result.getString(12),result.getString(13),result.getString(14),result.getString(15),result.getString(16),result.getString(17),result.getString(18),result.getString(19),result.getString(20),result.getString(21),result.getString(22),result.getString(23),result.getString(24),result.getString(25),result.getString(26),result.getString(27),result.getString(28),result.getString(29),result.getString(30),result.getString(31),result.getString(32),result.getString(33),result.getString(34),result.getString(35),result.getString(36),result.getString(37),result.getString(38),result.getString(39),result.getString(40),result.getString(41),result.getString(42)));
  
        TreeItem<Dossier> root= new RecursiveTreeItem<Dossier>(ds,RecursiveTreeObject::getChildren);
                listeview.setRoot(root);
                
        
    }
    
     @FXML
   public void OnClick(ActionEvent e) throws IOException, SQLException {
       
                 Alert alert = new Alert(AlertType.CONFIRMATION);
                 alert.setTitle("Confirmation");
                 alert.setHeaderText("vous venez de supprimer un dossier");
                 alert.setContentText("vous voulez continuer ?");

                 Optional<ButtonType> result = alert.showAndWait();
                 if (result.get() == ButtonType.OK){
                    TreeTableView.TreeTableViewFocusModel<Dossier> T=listeview.getFocusModel();
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



         PreparedStatement stat;
         int id=Integer.valueOf(column[0]);
         
                 stat=connexion.prepareStatement("delete from RFI where NumDossier = "+id);
                 stat.executeUpdate();
                 stat=connexion.prepareStatement("delete from CGAO where NumDossier = "+id);
                 stat.executeUpdate();
                 stat=connexion.prepareStatement("delete from COF where NumDossier = "+id);
                 stat.executeUpdate();
                 stat=connexion.prepareStatement("delete from CAD where NumDossier = "+id);
                 stat.executeUpdate();
                 stat=connexion.prepareStatement("delete from Besion where NumDossier = "+id);
                 stat.executeUpdate();
                 stat=connexion.prepareStatement("delete from AE where NumDossier = "+id);
                 stat.executeUpdate();
                 stat=connexion.prepareStatement("delete from AO where NumDossier = "+id);
                 stat.executeUpdate();
                 stat=connexion.prepareStatement("delete from ds where id = "+id);
                 stat.executeUpdate();
                 
                 Alert alert2 = new Alert(AlertType.INFORMATION);
                alert2.setTitle("Information");
                alert2.setHeaderText(null);
                alert2.setContentText("ce dossier est bien supprimer ");

                
                     
                 } else {
                    return ;
                 }
       
       
                 
                 
    
                   
  
    }
  
    
}
