
package appstage;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kingdragon
 */
public class FXMLUpdateController implements Initializable {

  
   
    @FXML private JFXButton btnValide,btnReset;
    private static String id;
   
   @FXML private Label lblErreur;

   public static boolean valide=true;

    @FXML
    private Pane panAjouter ;
    private static Pane panel;
    private final static ObservableList<String> AcheteurList = FXCollections.observableArrayList();
    private final static ObservableList<String> EntiteList = FXCollections.observableArrayList();
    private final static ObservableList<String> EntiteListSCE = FXCollections.observableArrayList();
    private final static ObservableList<String> TypeList = FXCollections.observableArrayList();
    private final static ObservableList<String> ChefList = FXCollections.observableArrayList();
    private final static ObservableList<String> NatureList = FXCollections.observableArrayList();
    private final static ObservableList<String> SigList = FXCollections.observableArrayList();
  private static  Connection connexion;
   @Override
    public void initialize(URL url, ResourceBundle rb) {
        connexion=ConnexionDB.getConnexion();
        panel=panAjouter;
        
        try {
            initCombobox();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }
    public  void initCombobox() throws SQLException
    {  PreparedStatement stat;
       ResultSet result;
       
       AcheteurList.clear();
       EntiteList.clear();
       TypeList.clear();
       ChefList.clear();
       NatureList.clear();
       SigList.clear();
       EntiteListSCE.clear();
       stat=connexion.prepareStatement("select Acheteur from Achats where id !=0");
         result=stat.executeQuery();
        
        while(result.next())
        {
            AcheteurList.add(result.getString(1));
           
        }
        
        stat=connexion.prepareStatement("select entite from Entite where id !=0");
         result=stat.executeQuery();
         while(result.next())
        {
            EntiteList.add(result.getString(1));
           
        }///////////////////////////////
           stat=connexion.prepareStatement("select entite from EntiteSCE where id !=0");
         result=stat.executeQuery();
         while(result.next())
        {
            EntiteListSCE.add(result.getString(1));
           
        }
         ////////////////////////////////
         stat=connexion.prepareStatement("select type from Type where id !=0");
         result=stat.executeQuery();
         while(result.next())
        {
           TypeList.add(result.getString(1));
        }
         
         ////////////////////////////////
         stat=connexion.prepareStatement("select chef from chefProjet where id !=0");
         result=stat.executeQuery();
         while(result.next())
        {
            ChefList.add(result.getString(1));
        }
         ////////////////////////////////
         stat=connexion.prepareStatement("select nature from Nature where id !=0");
         result=stat.executeQuery();
         while(result.next())
        {
            NatureList.add(result.getString(1));
 
        }
          ////////////////////////////////
         stat=connexion.prepareStatement("select Nom from Sig where id !=0");
         result=stat.executeQuery();
         while(result.next())
        {
           SigList.add(result.getString(1));
          
           
        }
         
        Acheteur.setItems(AcheteurList);
        Entite.setItems(EntiteList);
        BesionType.setItems(TypeList);
        SCE.setItems(EntiteListSCE);
        ChefProjet.setItems(ChefList);
        AENature.setItems(NatureList);
        CADSignataire.setItems(SigList);
        CDESignataire.setItems(SigList);
        
    }
    
    
    @FXML private  void Reset(ActionEvent e) {
      NumDossier.setText("");TitreDossier.setText("");NDA.setText("");
     Estimation.setText("");Objet.setText("");NRFI.setText("");CGAONPV.setText("");NAO.setText("");
     NAE.setText("");AEAnnee.setText("");AEMontant.setText("");AEMontEnagage.setText("");CADPVNum.setText("");
     CADAdjucataire.setText("");CADOrigine.setText("");CDENum.setText("");CDEDelai.setText("");CADMontant.setText("");
     CADSituation.setText("");CADObservation.setText("");
     
     Acheteur.setValue("");Entite.setValue("");BesionType.setValue("");SCE.setValue("");ChefProjet.setValue("");AENature.setValue("");CDESignataire.setValue("");CADSignataire.setValue("");
     
    }
    @FXML
    void Click_icon_add(MouseEvent e) throws IOException, SQLException {
         
        
        id=String.valueOf(e.getSource());
                id=id.substring(id.indexOf("=")+1,id.indexOf(","));
                System.out.println(id);
                
                Parent vue = FXMLLoader.load(getClass().getResource("Vue/option.fxml"));
               Scene scene = new Scene(vue);
               
                Stage stage = new Stage();
                stage.setScene(scene);  
                stage.show();
                stage.setTitle("Chose Color");
                stage.setResizable(false);
                
                
       
    }
    public static String getId()
    {
        
        return id;
    }
    
   @FXML private void Valide (ActionEvent event) throws SQLException {
       
       //////////////////////
        PreparedStatement prepStat;
   
       int id=AcheteurList.indexOf(Acheteur.getValue())+1;
       int entite= EntiteList.indexOf(Entite.getValue())+1;
     
       prepStat=connexion.prepareStatement("UPDATE ds SET id=?,Titre=?,NumAcheteur=? WHERE id=?");
       prepStat.setInt(1, Integer.valueOf(NumDossier.getText()));
       prepStat.setString(2, MyException.StringToString(TitreDossier.getText()));
       prepStat.setInt(3, id);
      prepStat.setInt(4, Integer.valueOf(oldnum.getText()));
       prepStat.executeUpdate();
        prepStat=connexion.prepareStatement("UPDATE Achats SET Entite=? WHERE id=?");
        prepStat.setInt(1, entite);
        prepStat.setInt(2, id);
        prepStat.executeUpdate();
       
       ////////////////////
  
     int  chef=ChefList.indexOf(ChefProjet.getValue())+1;
     int  be=TypeList.indexOf(BesionType.getValue())+1;
     int  e=EntiteList.indexOf(SCE.getValue())+1;

       prepStat=connexion.prepareStatement("UPDATE Besion SET DA=?,Type=?,DateAffec=?,SCE=?,Estimation=?,ChefProjet=?,Objet=?, NumDossier=? WHERE NumDossier=?");
      
       prepStat.setInt(1, MyException.StringtoNumber(NDA.getText()));
       prepStat.setInt(2,be);
       prepStat.setDate(3, MyException.StringToDate(DateAffec.getValue()));
       prepStat.setInt(4, e);
       prepStat.setDouble(5,MyException.StringtoDouble(Estimation.getText()));
       prepStat.setInt(6, chef);
       prepStat.setString(7, MyException.StringToString(Objet.getText()));
       prepStat.setInt(8,Integer.valueOf(NumDossier.getText()));  
       prepStat.setInt(9,Integer.valueOf(oldnum.getText()));  
       prepStat.executeUpdate();
       ///////////////////////////////////////////////////////
       prepStat=connexion.prepareStatement("UPDATE RFI SET NumRFI=?,Date=?,Echeange=? , NumDossier=? WHERE NumDossier=?");
       
      
       prepStat.setInt(1, MyException.StringtoNumber(NRFI.getText()));
      
      prepStat.setDate(2, MyException.StringToDate(DateRFI.getValue()));
      prepStat.setDate(3, MyException.StringToDate(RFIEcheance.getValue()));
       prepStat.setInt(4,Integer.valueOf(NumDossier.getText())); 
       prepStat.setInt(5,Integer.valueOf(oldnum.getText())); 
       prepStat.executeUpdate();
       ////////////////////////////////////
        prepStat=connexion.prepareStatement("UPDATE CGAO SET NumPV=?,Date=? , NumDossier=?  WHERE NumDossier=?");

        prepStat.setInt(1,MyException.StringtoNumber(CGAONPV.getText()));
        prepStat.setDate(2, MyException.StringToDate(DateCGAO.getValue()));
        prepStat.setInt(3,Integer.valueOf(NumDossier.getText()));
        prepStat.setInt(4,Integer.valueOf(oldnum.getText())); 
        prepStat.executeUpdate();
        ////////////////////////////////////
        prepStat=connexion.prepareStatement("UPDATE AO SET  NumAO=?,DateAO=?,Echeange=?,Relance=?, NumDossier=?   WHERE NumDossier=?");

        prepStat.setInt(1, MyException.StringtoNumber(NAO.getText()));
        prepStat.setDate(2, MyException.StringToDate(DateAO.getValue()));
        prepStat.setDate(3, MyException.StringToDate(AOEcheance.getValue()));
        prepStat.setDate(4, MyException.StringToDate(AORelance.getValue()));
        prepStat.setInt(5,Integer.valueOf(NumDossier.getText())); 
        prepStat.setInt(6,Integer.valueOf(oldnum.getText())); 
        prepStat.executeUpdate();
          ////////////////////////////////////
        prepStat=connexion.prepareStatement("UPDATE COF SET DateTech=?,DateAvis=?,DateCom=? , NumDossier=?  WHERE NumDossier=?");
        
        prepStat.setDate(1, MyException.StringToDate(COFDateTech.getValue()));
        prepStat.setDate(2, MyException.StringToDate(COFDateAvis.getValue()));
        prepStat.setDate(3, MyException.StringToDate(COFDateTech.getValue()));
        prepStat.setInt(4,Integer.valueOf(NumDossier.getText())); 
        prepStat.setInt(5,Integer.valueOf(oldnum.getText())); 
        prepStat.executeUpdate();
        ////////////////////////////////////
        int  AE=NatureList.indexOf(AENature.getValue())+1;
        prepStat=connexion.prepareStatement("UPDATE AE SET NumAE=?,idNature=?,Annee=?,MontantAE=?,MontantEngage=?,DateAE=?,DateArrive=? , NumDossier=?  WHERE NumDossier=?");
        
        prepStat.setString(1,MyException.StringToString(NAE.getText()));
        prepStat.setInt(2, AE);
        prepStat.setString(3, MyException.StringToString(AEAnnee.getText()));
        prepStat.setDouble(4, MyException.StringtoDouble(AEMontant.getText()));
        prepStat.setDouble(5, MyException.StringtoDouble(AEMontEnagage.getText()));
        prepStat.setDate(6, MyException.StringToDate(AEDate.getValue()));
        prepStat.setDate(7,MyException.StringToDate(AEDateArrivee.getValue()));
        prepStat.setInt(8,Integer.valueOf(NumDossier.getText()));
        prepStat.setInt(9,Integer.valueOf(oldnum.getText())); 
        prepStat.executeUpdate();
         ////////////////////////////////////
         int  SIg=SigList.indexOf(CADSignataire.getValue())+1;
          int  CAD=SigList.indexOf(CDESignataire.getValue())+1;
        prepStat=connexion.prepareStatement("UPDATE CAD SET PVNum=?,DateCAD=?,Signataire=?,Adjudicataire=?,Origine=?,NumCDE=?,DateCDE=?,SignataireCDE=?,Delai=?,Montant=?,Situation=?,Observation=? , NumDossier=? WHERE NumDossier=?");

        prepStat.setInt(1, MyException.StringtoNumber(CADPVNum.getText()));
        prepStat.setDate(2, MyException.StringToDate(CADDate.getValue()));
        prepStat.setInt(3, CAD);
        prepStat.setString(4,MyException.StringToString(CADAdjucataire.getText()));
        prepStat.setString(5,MyException.StringToString(CADOrigine.getText()));      
        prepStat.setString(6,MyException.StringToString(CDENum.getText()));
        prepStat.setDate(7, MyException.StringToDate(CDEDate.getValue()));
        prepStat.setInt(8,SIg);
        prepStat.setString(9,MyException.StringToString(CDEDelai.getText()));
        prepStat.setDouble(10,MyException.StringtoDouble(CADMontant.getText()));
        prepStat.setString(11, MyException.StringToString(CADSituation.getText()));
        prepStat.setString(12,MyException.StringToString(CADObservation.getText()));
        prepStat.setInt(13,Integer.valueOf(NumDossier.getText()));
        prepStat.setInt(14,Integer.valueOf(oldnum.getText())); 
        prepStat.executeUpdate();
        
        if(valide)
        {
            prepStat=connexion.prepareStatement("update ds set Complet ="+1);
            prepStat.executeUpdate();
        }
       System.out.println("bien");
       
       
       
        
    }

    public static Pane getPan()
    {
        return panel;
    }
    
   
    
  @FXML protected JFXTextField NumDossier,oldnum,TitreDossier,NDA,
                               Estimation,Objet,NRFI,CGAONPV,NAO,
                               NAE,AEAnnee,AEMontant,AEMontEnagage,CADPVNum,
                               CADAdjucataire,CADOrigine,CDENum,CDEDelai,CADMontant,
                               CADSituation,CADObservation;

    
    @FXML protected DatePicker DateCGAO,DateAffec,DateRFI,DateAO,AEDate,AEDateArrivee,CADDate,CDEDate,
                                COFDateTech,COFDateAvis,COFDateCom,AORelance,AOEcheance,RFIEcheance;
     @FXML
    protected JFXComboBox<String> Acheteur,Entite,BesionType,SCE,ChefProjet,AENature,CDESignataire,CADSignataire;
  

}

