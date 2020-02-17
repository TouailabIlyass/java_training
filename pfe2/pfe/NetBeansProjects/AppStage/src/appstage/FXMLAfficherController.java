
package appstage;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author kingdragon
 */
public class FXMLAfficherController implements Initializable {

    
    
   @FXML private JFXTreeTableView <Dossier> listeview;
    private static  Connection connexion;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       connexion=ConnexionDB.getConnexion();
  
       SetColumn();
 
       try {
           Afficher();
       } catch (SQLException ex) {
           Logger.getLogger(FXMLAfficherController.class.getName()).log(Level.SEVERE, null, ex);
       }
      
    }    
    
    public void Afficher() throws SQLException
    {
        PreparedStatement prepStat;
        
        prepStat=connexion.prepareStatement("select ds.id,ds.Titre,Achats.Acheteur,Achats.Entite,Besion.Type,Besion.DA,Besion.DateAffec,Besion.SCE,Besion.Estimation,chefProjet.chef,Besion.Objet,RFI.NumRFI,RFI.Date, RFI.Echeange,CGAO.NumPV,CGAO.Date,AO.NumAO,AO.DateAO,AO.Echeange,AO.Relance,COF.DateTech,COF.DateAvis,COF.DateCom,AE.Nature,AE.Annee,AE.MontantAE,AE.MontantEngage ,AE.NumAE,AE.DateAE,AE.DateArrive,CAD.PVNum,CAD.DateCAD,CAD.Signataire,CAD.Adjudicataire,CAD.Origine,CAD.NumCDE,CAD.DateCDE,CAD.SignataireCDE,CAD.Delai,CAD.Montant ,CAD.Situation,CAD.Observation FROM ds,Achats,Besion,RFI,CGAO,AO,COF,AE,CAD,chefProjet WHERE ds.NumAcheteur=Achats.id && Besion.NumDossier=ds.id && RFI.NumDossier=ds.id && CGAO.NumDossier=ds.id && AO.NumDossier=ds.id && COF.NumDossier=ds.id && AE.NumDossier=ds.id && CAD.NumDossier=ds.id && Besion.ChefProjet=chefProjet.id");
        ResultSet result=prepStat.executeQuery();
        
        ObservableList<Dossier> ds= FXCollections.observableArrayList();
        while (result.next()) 
            ds.add(new Dossier(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getString(8),result.getString(9),result.getString(10),result.getString(11),result.getString(12),result.getString(13),result.getString(14),result.getString(15),result.getString(16),result.getString(17),result.getString(18),result.getString(19),result.getString(20),result.getString(21),result.getString(22),result.getString(23),result.getString(24),result.getString(25),result.getString(26),result.getString(27),result.getString(28),result.getString(29),result.getString(30),result.getString(31),result.getString(32),result.getString(33),result.getString(34),result.getString(35),result.getString(36),result.getString(37),result.getString(38),result.getString(39),result.getString(40),result.getString(41),result.getString(42)));
  
        TreeItem<Dossier> root= new RecursiveTreeItem<Dossier>(ds,RecursiveTreeObject::getChildren);
                listeview.setRoot(root);
               
        
    }
    
 private void SetColumn()
 {
      JFXTreeTableColumn<Dossier,String> Numds= new JFXTreeTableColumn<Dossier, String>("Num Dossier");
     Numds.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().NumDossier;
      }
       }); Numds.setMinWidth(120);           //////////////
      JFXTreeTableColumn<Dossier,String> Title= new JFXTreeTableColumn<Dossier, String>("Titre");
     Title.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().TitreDossier;}
       });  Title.setMinWidth(120);  
      /////////////////////////
      JFXTreeTableColumn<Dossier,String> Acheteur= new JFXTreeTableColumn<Dossier, String>("Acheteur");
     Acheteur.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().Acheteur;}
       });Acheteur.setMinWidth(120);  
       JFXTreeTableColumn<Dossier,String> Entite= new JFXTreeTableColumn<Dossier, String>("Entite");
     Entite.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().Entite;}
       }); Entite.setMinWidth(120); 
                            //////////////////
      JFXTreeTableColumn<Dossier,String> Type= new JFXTreeTableColumn<Dossier, String>("Type");
     Type.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().BesionType; }
       });                      
                       Type.setMinWidth(120); 
       JFXTreeTableColumn<Dossier,String> NDA= new JFXTreeTableColumn<Dossier, String>("Num DA");
     NDA.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().NDA; }
       });NDA.setMinWidth(120); 
                            
         JFXTreeTableColumn<Dossier,String> DateAffec= new JFXTreeTableColumn<Dossier, String>("Date Affectation");
     DateAffec.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().DateAffec; }
       });DateAffec.setMinWidth(120); 
                            
            JFXTreeTableColumn<Dossier,String> SCE= new JFXTreeTableColumn<Dossier, String>("SCE DEMANDEUR");
     SCE.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().SCE;   }
       });       SCE.setMinWidth(120);         
               
   JFXTreeTableColumn<Dossier,String> Estimation= new JFXTreeTableColumn<Dossier, String>("Estimation");
     Estimation.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().Estimation; }
       });Estimation.setMinWidth(120); 
     
           JFXTreeTableColumn<Dossier,String> Chefprojet= new JFXTreeTableColumn<Dossier, String>("Chef de Projet");
     Chefprojet.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().ChefProjet;  }
       });Chefprojet.setMinWidth(120); 
     
                            
     JFXTreeTableColumn<Dossier,String> Objet= new JFXTreeTableColumn<Dossier, String>("Objet");
     Objet.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().Objet; }
       });Objet.setMinWidth(120); 
                            
                            ///////////////////////
       JFXTreeTableColumn<Dossier,String> NRFI= new JFXTreeTableColumn<Dossier, String>("Num RFI");
     NRFI.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().NRFI; }
       });NRFI.setMinWidth(120); 
     

    JFXTreeTableColumn<Dossier,String> DateRFI= new JFXTreeTableColumn<Dossier, String>("Date");
     DateRFI.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().DateRFI;  
                            }
       });DateRFI.setMinWidth(120); 
     
      JFXTreeTableColumn<Dossier,String> RFIEcheance= new JFXTreeTableColumn<Dossier, String>("Echeance");
     RFIEcheance.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().RFIEcheance;  
                            }
       });RFIEcheance.setMinWidth(120); 
           ////////////////////////////////////////////
       JFXTreeTableColumn<Dossier,String> CGAONPV= new JFXTreeTableColumn<Dossier, String>("PV Num");
     CGAONPV.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().CGAONPV;  
                            }
       });CGAONPV.setMinWidth(120); 
         
     
        JFXTreeTableColumn<Dossier,String> DateCGAO= new JFXTreeTableColumn<Dossier, String>("Date ");
     DateCGAO.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().DateCGAO;  
                            }
       });DateCGAO.setMinWidth(120); 
     
     ////////////////////////
       JFXTreeTableColumn<Dossier,String> NAO= new JFXTreeTableColumn<Dossier, String>("Num AO");
     NAO.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().NAO;  
                            }
       });NAO.setMinWidth(120); 
     
        JFXTreeTableColumn<Dossier,String> DateAO= new JFXTreeTableColumn<Dossier, String>("Date AO");
     DateAO.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().DateAO;  
                            }
       });DateAO.setMinWidth(120); 
     
          JFXTreeTableColumn<Dossier,String> AOEcheance= new JFXTreeTableColumn<Dossier, String>("Echeance");
     AOEcheance.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().AOEcheance;  
                            }
       });AOEcheance.setMinWidth(120); 
        JFXTreeTableColumn<Dossier,String> AORelance= new JFXTreeTableColumn<Dossier, String>("Relance");
     AORelance.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().AORelance;  
                            }
       });AORelance.setMinWidth(120); 
     ////////////////////////////////
       JFXTreeTableColumn<Dossier,String> COFDateTech= new JFXTreeTableColumn<Dossier, String>("Date Technique");
     COFDateTech.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().COFDateTech;  
                            }
       });COFDateTech.setMinWidth(120);
      JFXTreeTableColumn<Dossier,String> COFDateAvis= new JFXTreeTableColumn<Dossier, String>("Date Avis Technique");
     COFDateAvis.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().COFDateAvis;  
                            }
       });COFDateAvis.setMinWidth(120);
      JFXTreeTableColumn<Dossier,String> COFDateCom= new JFXTreeTableColumn<Dossier, String>("Date COM");
     COFDateCom.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().COFDateCom;  
                            }
       });COFDateCom.setMinWidth(120);
     //////////////////
       JFXTreeTableColumn<Dossier,String> AENature= new JFXTreeTableColumn<Dossier, String>("Nature");
     AENature.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().AENature;  
                            }
       });AENature.setMinWidth(120);
     
       JFXTreeTableColumn<Dossier,String> AEAnnee= new JFXTreeTableColumn<Dossier, String>("Annee");
     AEAnnee.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().AEAnnee;  
                            }
       });AEAnnee.setMinWidth(120);
     
       JFXTreeTableColumn<Dossier,String> AEMontant= new JFXTreeTableColumn<Dossier, String>("Montant AE");
     AEMontant.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().AEMontant;  
                            }
       });AEMontant.setMinWidth(120);
     
       JFXTreeTableColumn<Dossier,String> AEMontEnagage= new JFXTreeTableColumn<Dossier, String>("Montant Engage sur L'AE");
     AEMontEnagage.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().AEMontEnagage;  
                            }
       });AEMontEnagage.setMinWidth(120);
     
       JFXTreeTableColumn<Dossier,String> NAE= new JFXTreeTableColumn<Dossier, String>("Num AE");
     NAE.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().NAE;  
                            }
       });NAE.setMinWidth(120);
     
       JFXTreeTableColumn<Dossier,String> AEDate= new JFXTreeTableColumn<Dossier, String>("Date AE");
     AEDate.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().AEDate;  
                            }
       });AEDate.setMinWidth(120);
     
       JFXTreeTableColumn<Dossier,String> AEDateArrivee= new JFXTreeTableColumn<Dossier, String>("Date arrivee");
     AEDateArrivee.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().AEDateArrivee;  
                            }
       });AEDateArrivee.setMinWidth(120);
     //////////////////////
       JFXTreeTableColumn<Dossier,String> CADPVNum= new JFXTreeTableColumn<Dossier, String>("Num Pv");
     CADPVNum.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().CADPVNum;  
                            }
       });CADPVNum.setMinWidth(120);
     
       JFXTreeTableColumn<Dossier,String> CADDate= new JFXTreeTableColumn<Dossier, String>("Date CAD");
     CADDate.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().CADDate;  
                            }
       });CADDate.setMinWidth(120);
    
       JFXTreeTableColumn<Dossier,String> CADSignataire= new JFXTreeTableColumn<Dossier, String>("Signataire");
     CADSignataire.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().CADSignataire;  
                            }
       });CADSignataire.setMinWidth(120);
      
     /////////////////
 
      JFXTreeTableColumn<Dossier,String> CADAdjucataire= new JFXTreeTableColumn<Dossier, String>("Adjudicataire");
     CADAdjucataire.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().CADAdjucataire;  
                            }
       });CADAdjucataire.setMinWidth(120);
     
      JFXTreeTableColumn<Dossier,String> CADOrigine= new JFXTreeTableColumn<Dossier, String>("Origine");
     CADOrigine.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().CADOrigine;  
                            }
       });CADOrigine.setMinWidth(120);
         
      JFXTreeTableColumn<Dossier,String> CDENum= new JFXTreeTableColumn<Dossier, String>("Num CDE");
     CDENum.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().CDENum;  
                            }
       });CDENum.setMinWidth(120);
     
      JFXTreeTableColumn<Dossier,String> CDEDate= new JFXTreeTableColumn<Dossier, String>("Date CDE");
     CDEDate.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().CDEDate;  
                            }
       });CDEDate.setMinWidth(120);
     
      JFXTreeTableColumn<Dossier,String> CDESignataire= new JFXTreeTableColumn<Dossier, String>("Signataire CDE");
     CDESignataire.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().CDESignataire;  
                            }
       });CDESignataire.setMinWidth(120);
     
      JFXTreeTableColumn<Dossier,String> CDEDelai= new JFXTreeTableColumn<Dossier, String>("Delai");
     CDEDelai.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().CDEDelai;  
                            }
       });CDEDelai.setMinWidth(120);
     
      JFXTreeTableColumn<Dossier,String> CADMontant= new JFXTreeTableColumn<Dossier, String>("Montant/MAD/TTC");
     CADMontant.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().CADMontant;  
                            }
       });CADMontant.setMinWidth(120);
     
      JFXTreeTableColumn<Dossier,String> CADSituation= new JFXTreeTableColumn<Dossier, String>("Situation");
     CADSituation.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().CADSituation;
                            }
       });CADSituation.setMinWidth(120);
     
     JFXTreeTableColumn<Dossier,String> CADObservation= new JFXTreeTableColumn<Dossier, String>("Observations");
     CADObservation.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Dossier,String>,ObservableValue<String>>() {
                         @Override
                         public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Dossier, String> param) {
                            return param.getValue().getValue().CADObservation;
                            }
       });CADObservation.setMinWidth(120);

  listeview.getColumns().addAll(Numds,Title,Acheteur,Entite,Type,NDA,DateAffec,SCE,Estimation,Chefprojet,Objet,NRFI,DateRFI,RFIEcheance,CGAONPV,DateCGAO,NAO,DateAO,AOEcheance,AORelance,COFDateTech,COFDateAvis,COFDateCom,AENature,AEAnnee,AEMontant,AEMontEnagage,NAE,AEDate,AEDateArrivee,CADPVNum,CADDate,CADSignataire,CADAdjucataire,CADOrigine,CDENum,CDEDate,CDESignataire,CDEDelai,CADMontant,CADSituation,CADObservation);                           
 
      
 
 
 }
    
}
