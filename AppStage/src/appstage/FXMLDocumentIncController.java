
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
import java.time.LocalDate;
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
         
       prepStat=connexion.prepareStatement("select ds.id,ds.Titre,Achats.Acheteur,Entite.entite,Type.type,Besion.DA,Besion.DateAffec,EntiteSCE.entite,Besion.Estimation,chefProjet.chef,Besion.Objet,RFI.NumRFI,RFI.Date, RFI.Echeange,CGAO.NumPV,CGAO.Date,AO.NumAO,AO.DateAO,AO.Echeange,AO.Relance,COF.DateTech,COF.DateAvis,COF.DateCom,Nature.nature,AE.Annee,AE.MontantAE,AE.MontantEngage ,AE.NumAE,AE.DateAE,AE.DateArrive,CAD.PVNum,CAD.DateCAD,Sig.Nom,CAD.Adjudicataire,CAD.Origine,CAD.NumCDE,CAD.DateCDE,Sig.Nom,CAD.Delai,CAD.Montant ,CAD.Situation,CAD.Observation FROM ds,Achats,Besion,RFI,CGAO,AO,COF,AE,CAD,chefProjet,Entite,Type,Sig,Nature,EntiteSCE WHERE ds.Complet = 0 && ds.NumAcheteur=Achats.id && Besion.NumDossier=ds.id && RFI.NumDossier=ds.id && CGAO.NumDossier=ds.id && AO.NumDossier=ds.id && COF.NumDossier=ds.id && AE.NumDossier=ds.id && CAD.NumDossier=ds.id && Besion.ChefProjet=chefProjet.id && Achats.Entite=Entite.id && Besion.Type=Type.id && Besion.SCE=EntiteSCE.id && AE.idNature=Nature.id && CAD.Signataire=Sig.id && CAD.SignataireCDE=Sig.id");
        //prepStat=connexion.prepareStatement("select ds.id,ds.Titre,Achats.Acheteur,Entite.entite,Type.type,Besion.DA,Besion.DateAffec,EntiteSCE.entite,Besion.Estimation,ChefProjet.chef,Besion.Objet,RFI.NumRFI,RFI.Date, RFI.Echeance,CGAO.NumPV,CGAO.Date,NumAO.NumAO,NumAO.DateAO,NumAO.Echeance,NumAO.Relance,COF.DateTech,COF.DateAvis,COF.DateCom,Nature.nature,AE.Annee,AE.MantantAE,AE.MantantEngage ,AE.NumAE,AE.DateAE,AE.DateArrive,CAD.PVNum,CAD.DateCAD,Sig.Nom,CAD.Adjucataire,CAD.Origine,CAD.NumCDE,CAD.DateCDE,Sig.Nom,CAD.Delai,CAD.Montant ,CAD.Situation,CAD.Observation FROM ds,Achats,Besion,RFI,CGAO,NumAO,COF,AE,CAD,ChefProjet,Entite,Type,Sig,Nature,EntiteSCE WHERE ds.Complet = 0 && ds.Numcheteur=Achats.id && Besion.NumDossier=ds.id && RFI.NumDossier=ds.id && CGAO.NumDossier=ds.id && NumAO.NumDossier=ds.id && COF.NumDossier=ds.id && AE.NumDossier=ds.id && CAD.NumDossier=ds.id && Besion.ChefProjet=ChefProjet.id && Achats.Entite=Entite.id && Besion.Type=Type.id && Besion.SCE=EntiteSCE.id && AE.idNature=Nature.id && CAD.Signataire=Sig.id");
               
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
                 
                    loader.setLocation(getClass().getResource("Vue/FXMLUpdate.fxml"));
                    loader.load();
                    ScrollPane root = loader.getRoot();
                    FXMLUpdateController controle = loader.getController();
                   root.setPrefSize(p.getWidth(), p.getHeight());
                   
                   controle.NumDossier.setText(column[0]);
                   controle.oldnum.setText(column[0]);
                   controle.TitreDossier.setText(column[1]);
                   controle.Acheteur.setValue(column[2]);
                   controle.Entite.setValue(column[3]);
                   controle.BesionType.setValue(column[4]);
                   controle.NDA.setText(column[5]);
                   if(!column[6].equals("") || !column[6].equals("NULL"))
                   { 
                 
                  controle.DateAffec.setValue(LocalDate.parse(column[6]));
                 
                     
                       
                   }
                  
                    controle.SCE.setValue(column[7]);
                    controle.Estimation.setText(column[8]);
                    controle.ChefProjet.setValue(column[9]);
                   controle.Objet.setText(column[10]);
                   controle.NRFI.setText(column[11]);
                  try
                   {
                       controle.DateRFI.setValue(LocalDate.parse(column[12]));
                   }
                    catch(Exception ex)
                  {
                      
                  }
                   
                   try
                   {
                       controle.RFIEcheance.setValue(LocalDate.parse(column[13]));
                   }  catch(Exception ex)
                  {
                      
                  }
                    controle.CGAONPV.setText(column[14]);
                    
                    try
                   {
                       controle.DateCGAO.setValue(LocalDate.parse(column[15]));
                   }  catch(Exception ex)
                  {
                      
                  }
                    
                   controle.NAO.setText(column[16]);
                   System.out.println("\n"+column[16]);
                    try
                   {
                       controle.DateAO.setValue(LocalDate.parse(column[17]));
                   }
                      catch(Exception ex)
                  {
                      
                  }
                   try
                   {
                       controle.AOEcheance.setValue(LocalDate.parse(column[18]));
                   }
                     catch(Exception ex)
                  {
                      
                  }
                   try
                   {
                       controle.AORelance.setValue(LocalDate.parse(column[19]));
                   }  catch(Exception ex)
                  {
                      
                  }
                   
                    try
                   {
                       controle.COFDateTech.setValue(LocalDate.parse(column[20]));
                   }
                     catch(Exception ex)
                  {
                      
                  }
                  try
                   {
                       controle.COFDateAvis.setValue(LocalDate.parse(column[21]));
                   }
                    catch(Exception ex)
                  {
                      
                  }
                    try
                   {
                       controle.COFDateCom.setValue(LocalDate.parse(column[22]));
                   }
                   catch(Exception ex)
                  {
                      
                  }
                    
                    controle.AENature.setValue(column[23]);
                    controle.AEAnnee.setText(column[24]);
                    controle.AEMontant.setText(column[25]);
                    controle.AEMontEnagage.setText(column[26]);
                    controle.NAE.setText(column[28]);
                   
                  try
                  {
                      controle.AEDate.setValue(LocalDate.parse(column[27]));
                  }
                   catch(Exception ex)
                  {
                      
                  }
                     
                  try
                   {
                       controle.AEDateArrivee.setValue(LocalDate.parse(column[29]));
                   }  catch(Exception ex)
                  {
                      
                  }
                    
                       controle.CADPVNum.setText(column[30]);
                  try
                   {
                       controle.CADDate.setValue(LocalDate.parse(column[31]));
                   }  catch(Exception ex)
                  {
                      
                  }
                       
                   controle.CADSignataire.setValue(column[32]);
                   controle.CADAdjucataire.setText(column[33]);
                   controle.CADOrigine.setText(column[34]);
                   
                   controle.CDENum.setText(column[35]);
                   
                    try
                   {
                       controle.CDEDate.setValue(LocalDate.parse(column[36]));
                   }  catch(Exception ex)
                  {
                      
                  }
                   
                    controle.CDESignataire.setValue(column[37]);
                    controle.CDEDelai.setText(column[38]);
                    controle.CADMontant.setText(column[39]);
                    controle.CADSituation.setText(column[40]);
                    controle.CADObservation.setText(column[41]);
                    
                    
                   p.getChildren().setAll(root);
                   
  
    }
  
  
}
