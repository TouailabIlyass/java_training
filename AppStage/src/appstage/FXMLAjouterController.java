/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appstage;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.jdom2.JDOMException;

/**
 * FXML Controller class
 *
 * @author kingdragon
 */
public class FXMLAjouterController implements Initializable {

  
   
    @FXML private JFXButton btnValide,btnReset;
    private static String id;
   
   @FXML private Label lblErreur;

   public static boolean valide=true;
    @FXML
    private Pane panAjouter ;
    private static Pane panel;
    private final static ObservableList<String> AcheteurList = FXCollections.observableArrayList();
    private final static ObservableList<String> EntiteList = FXCollections.observableArrayList();
    private final static ObservableList<String> EntiteSCE = FXCollections.observableArrayList();
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
            Logger.getLogger(FXMLAjouterController.class.getName()).log(Level.SEVERE, null, ex);
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
       EntiteSCE.clear();
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
            EntiteSCE.add(result.getString(1));
           
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
        SCE.setItems(EntiteSCE);
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
                stage.setTitle("Ajouter ressource");
                stage.setResizable(false);
                
                
       
    }
    public static String getId()
    {
        
        return id;
    }
    
   @FXML private void Valide (ActionEvent event) throws SQLException, JDOMException, JDOMException, IOException {
       
       //////////////////////
        PreparedStatement prepStat;
   
       int id=AcheteurList.indexOf(Acheteur.getValue())+1;
      
      
       prepStat=connexion.prepareStatement("insert into ds(id,Titre,NumAcheteur) values(?,?,?)");
       prepStat.setInt(1, Integer.valueOf(NumDossier.getText()));
       prepStat.setString(2, MyException.StringToString(TitreDossier.getText()));
       prepStat.setInt(3, id);
      
       prepStat.executeUpdate();
       ////////////////////
  
     int  chef=ChefList.indexOf(ChefProjet.getValue())+1;
     int  be=TypeList.indexOf(BesionType.getValue())+1;
     int  e=EntiteList.indexOf(SCE.getValue())+1;
//        int  chef=ChefList.indexOf(MyException.StringToString(ChefProjet.getValue()))+1;
//     int  be=TypeList.indexOf(MyException.StringToString(BesionType.getValue()))+1;
       prepStat=connexion.prepareStatement("insert into Besion values (?,?,?,?,?,?,?,?,?)");
       prepStat.setInt(1, 0);
   
       prepStat.setInt(2, MyException.StringtoNumber(NDA.getText()));
 
       prepStat.setInt(3,be);
       prepStat.setDate(4, MyException.StringToDate(DateAffec.getValue()));
       prepStat.setInt(5, e);
       prepStat.setDouble(6,MyException.StringtoDouble(Estimation.getText()));
       prepStat.setInt(7, chef);
       prepStat.setString(8, MyException.StringToString(Objet.getText()));
       prepStat.setInt(9,MyException.StringtoNumber(NumDossier.getText()));  
       prepStat.executeUpdate();
       ///////////////////////////////////////////////////////
       prepStat=connexion.prepareStatement("insert into RFI values(?,?,?,?,?)");
       prepStat.setInt(1, 0);
       prepStat.setInt(2, MyException.StringtoNumber(NRFI.getText()));
       //prepStat.setDate(3, Date.valueOf(DateRFI.getValue()));
      // prepStat.setDate(4, Date.valueOf(RFIEcheance.getValue()));
      prepStat.setDate(3, MyException.StringToDate(DateRFI.getValue()));
      prepStat.setDate(4, MyException.StringToDate(RFIEcheance.getValue()));
       prepStat.setInt(5,MyException.StringtoNumber(NumDossier.getText())); 
       prepStat.executeUpdate();
       ////////////////////////////////////
        prepStat=connexion.prepareStatement("insert into CGAO values(?,?,?,?)");
        prepStat.setInt(1, 0);
        prepStat.setInt(2,MyException.StringtoNumber(CGAONPV.getText()));
        prepStat.setDate(3, MyException.StringToDate(DateCGAO.getValue()));
        prepStat.setInt(4,MyException.StringtoNumber(NumDossier.getText())); 
        prepStat.executeUpdate();
        ////////////////////////////////////
        prepStat=connexion.prepareStatement("insert into AO values(?,?,?,?,?,?)");
        prepStat.setInt(1, 0);
        prepStat.setInt(2, MyException.StringtoNumber(NAO.getText()));
        prepStat.setDate(3, MyException.StringToDate(DateAO.getValue()));
        prepStat.setDate(4, MyException.StringToDate(AOEcheance.getValue()));
        prepStat.setDate(5, MyException.StringToDate(AORelance.getValue()));
        prepStat.setInt(6,MyException.StringtoNumber(NumDossier.getText())); 
        prepStat.executeUpdate();
          ////////////////////////////////////
        prepStat=connexion.prepareStatement("insert into COF values(?,?,?,?,?)");
        prepStat.setInt(1, 0);
        prepStat.setDate(2, MyException.StringToDate(COFDateTech.getValue()));
        prepStat.setDate(3, MyException.StringToDate(COFDateAvis.getValue()));
        prepStat.setDate(4, MyException.StringToDate(COFDateTech.getValue()));
        prepStat.setInt(5,MyException.StringtoNumber(NumDossier.getText())); 
        prepStat.executeUpdate();
        ////////////////////////////////////
        int  AE=NatureList.indexOf(AENature.getValue())+1;
        prepStat=connexion.prepareStatement("insert into AE values (?,?,?,?,?,?,?,?,?)");
        prepStat.setInt(1, 0);
        prepStat.setString(2,MyException.StringToString(NAE.getText()));
        prepStat.setInt(3, AE);
        prepStat.setString(4, MyException.StringToString(AEAnnee.getText()));
        prepStat.setDouble(5, MyException.StringtoDouble(AEMontant.getText()));
        prepStat.setDouble(6, MyException.StringtoDouble(AEMontEnagage.getText()));
        prepStat.setDate(7, MyException.StringToDate(AEDate.getValue()));
        prepStat.setDate(8,MyException.StringToDate(AEDateArrivee.getValue()));
        prepStat.setInt(9,MyException.StringtoNumber(NumDossier.getText()));
        prepStat.executeUpdate();
         ////////////////////////////////////
         int  SIg=SigList.indexOf(CADSignataire.getValue())+1;
          int  CAD=SigList.indexOf(CDESignataire.getValue())+1;
        prepStat=connexion.prepareStatement("insert into CAD values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        prepStat.setInt(1, 0);
        prepStat.setInt(2, MyException.StringtoNumber(CADPVNum.getText()));
        prepStat.setDate(3, MyException.StringToDate(CADDate.getValue()));
        prepStat.setInt(4, CAD);
        prepStat.setString(5,MyException.StringToString(CADAdjucataire.getText()));
        prepStat.setString(6,MyException.StringToString(CADOrigine.getText()));      
        prepStat.setString(7,MyException.StringToString(CDENum.getText()));
        prepStat.setDate(8, MyException.StringToDate(CDEDate.getValue()));
        prepStat.setInt(9,SIg);
        prepStat.setString(10,MyException.StringToString(CDEDelai.getText()));
        prepStat.setDouble(11,MyException.StringtoDouble(CADMontant.getText()));
        prepStat.setString(12, MyException.StringToString(CADSituation.getText()));
        prepStat.setString(13,MyException.StringToString(CADObservation.getText()));
        prepStat.setInt(14,MyException.StringtoNumber(NumDossier.getText()));
        prepStat.executeUpdate();
        
        if(valide)
        {
            prepStat=connexion.prepareStatement("update ds set Complet ="+1);
            prepStat.executeUpdate();
        }
        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setTitle("Information");
                alert2.setHeaderText(null);
                alert2.setContentText("ce dossier est bien ajouter ");
                Optional<ButtonType> result2;
                     result2 = alert2.showAndWait();
       System.out.println("bien");
       
       
       
        
    }

    public static Pane getPan()
    {
        return panel;
    }
    
    /*
     private void Enregistrer(int id) throws JDOMException, IOException
    {
        SAXBuilder sax= new SAXBuilder();
        Document doc=sax.build(new File("his.xml"));
        Element racine = doc.getRootElement();
        Element elm = new Element("Objet");
         List l =racine.getChildren();
        
        if(l.size()<=50)
        {
  
                 elm.addContent("<Object id='"+id+"'  />");
         
        }else
        {
            
        }
         XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
         sortie.output(doc, new FileOutputStream("his.xml"));
        
    }
    private void Lire() throws JDOMException, IOException
    { 
         SAXBuilder sax= new SAXBuilder();
        Document doc=sax.build(new File("/home/kingdragon/Desktop/NetBeansProjects/pfe2/src/pfe2/save.xml"));
        Element racine = doc.getRootElement();
        Element elm = new Element("Objet");
         List list =racine.getChildren();
         Iterator i=list.iterator();
         
         while(i.hasNext())
         {
             elm= (Element) i.next();
             if(elm.getAttribute("class").getValue().equals("line"))
             {   
                
             }
           else if(elm.getAttribute("class").getValue().equals("cercle"))
             {   
                
             }
         }
        
    }
    
    */
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
    
  @FXML protected JFXTextField NumDossier,TitreDossier,NDA,
                               Estimation,Objet,NRFI,CGAONPV,NAO,
                               NAE,AEAnnee,AEMontant,AEMontEnagage,CADPVNum,
                               CADAdjucataire,CADOrigine,CDENum,CDEDelai,CADMontant,
                               CADSituation,CADObservation;

    
    @FXML protected JFXDatePicker DateCGAO,DateAffec,DateRFI,DateAO,AEDate,AEDateArrivee,CADDate,CDEDate,
                                COFDateTech,COFDateAvis,COFDateCom,AORelance,AOEcheance,RFIEcheance;
     @FXML
    protected JFXComboBox<String> Acheteur,Entite,BesionType,SCE,ChefProjet,AENature,CDESignataire,CADSignataire;

}

     




/*


package appstage;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;


public class FXMLAjouterController implements Initializable {

   
    @FXML private JFXButton btnValide,btnReset;
   
   @FXML private Label lblErreur;

       public static boolean valide=true;
    @FXML
    private Pane panAjouter ;
    private static Pane panel;
    private final ObservableList<String> AcheteurList = FXCollections.observableArrayList("RBIB HICHAM");
    private final ObservableList<String> EntiteList = FXCollections.observableArrayList("OIA/S","OIA/SP","OIS/l");
    private final ObservableList<String> TypeList = FXCollections.observableArrayList("DPM","STOCK","DAM");
    private final ObservableList<String> ChefList = FXCollections.observableArrayList("ANAYNYAA","GUERMAH","INOUS","EL OUAHLOULI");
    private final ObservableList<String> NatureList = FXCollections.observableArrayList("INV","GT");
    private final ObservableList<String> SigList = FXCollections.observableArrayList("ABOULFARAH","LAFRAOUI","MHANDI","MERHARI","LARGOU","EL BAHAR","HIMMAD","BOUCHAOUIR","QACHAR","BIYADI","JEBRIL","SADIK","AMHARECH","BENCHBABA");
  private static  Connection connexion;
   @Override
    public void initialize(URL url, ResourceBundle rb) {
        connexion=ConnexionDB.getConnexion();
     //   Acheteur.setValue(AcheteurList.get(0));
        Acheteur.setItems(AcheteurList);
        Entite.setItems(EntiteList);
       // Entite.setValue(EntiteList.get(0));
       // BesionType.setValue(TypeList.get(0));
        BesionType.setItems(TypeList);
        SCE.setItems(EntiteList);
        ChefProjet.setItems(ChefList);
        AENature.setItems(NatureList);
        CADSignataire.setItems(SigList);
        CDESignataire.setItems(SigList);
        System.out.println("string "+SCE.getValue());
        panel=panAjouter;
        
        
        
    }
   
    @FXML private  void Reset(ActionEvent event) {

    }

    
   @FXML private void Valide (ActionEvent event) throws SQLException {
       
       
       for (Node elem: panAjouter.getChildren()) {
           if(elem instanceof HBox)
           {
               HBox hbx= (HBox)elem;
              // MyException myExcep = new MyException();
               boolean b;
               for (Node elm :hbx.getChildren()) {
                   if(elm.getAccessibleText()!=null && elm.getAccessibleText().equals("Number"))
                   {  JFXTextField Num=(JFXTextField) elm;
                       System.out.println("value"+Num.getText());
                      if(Num.getText().equals(null) || Num.getText().equals(""))
                      {
                          Num.setText("0");
                      }
                       b=MyException.isNumber(Num.getText());
                       if(!b){
                           Num.getStyleClass().add("erreur");
                           System.out.println("okkkk"+Num.getText()+b);
                           lblErreur.setText("erreur");
                           return ;
                       }else
                           Num.getStyleClass().removeAll("erreur");
                       
                   }
                  else if(elm.getAccessibleText()!=null && elm.getAccessibleText().equals("NumberDouble"))
                   {  JFXTextField Num=(JFXTextField) elm;
                    if(Num.getText().equals(null) ||Num.getText().equals(""))
                      {
                          Num.setText("0");
                      }
                       b=MyException.isDouble(Num.getText());
                       if(!b){
                           Num.getStyleClass().add("erreur");
                           System.out.println("okkkk"+Num.getText()+b);
                           lblErreur.setText("erreur");
                           return ;
                       }else
                           Num.getStyleClass().removeAll("erreur");
                       
                   }
                   
                   
                   
               }
               
           }
           
           
       }
       
       
       
        PreparedStatement prepStat;
   
       int id=AcheteurList.indexOf(Acheteur.getValue())+1;
       System.out.println("appstage.FXMLAjouterController.Valide()"+id);
       prepStat=connexion.prepareStatement("insert into ds values(?,?,?,?)");
       prepStat.setInt(1, Integer.valueOf(NumDossier.getText()));
       prepStat.setString(2, TitreDossier.getText());
       prepStat.setInt(3, id);
      
       prepStat.executeUpdate();
       ////////////////////
     //  DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
       
      
       //String s=df.format(DateAffec.getValue());
       //System.out.println("appstage.FXMLAjouterController.Valide()"+s);
      // Date date = Date.from(localDate.atStartOfDay(DateAffec.systemDefault()).toInstant());
     int  chef=ChefList.indexOf(ChefProjet.getValue())+1;
       prepStat=connexion.prepareStatement("insert into Besion values (?,?,?,?,?,?,?,?,?)");
       prepStat.setInt(1, 0);
       prepStat.setInt(2, Integer.parseInt(NDA.getText()));
       prepStat.setString(3,BesionType.getValue());
//       prepStat.setDate(4, Date.valueOf(DateAffec.getValue()));
       prepStat.setDate(4, MyException.isDate(DateAffec.getValue()));
       prepStat.setString(5, SCE.getValue());
       prepStat.setDouble(6,Double.valueOf(Estimation.getText()));
       prepStat.setInt(7, chef);
       prepStat.setString(8, Objet.getText());
       prepStat.setInt(9,Integer.valueOf(NumDossier.getText()));  
       prepStat.executeUpdate();
       ///////////////////////////////////////////////////////
       prepStat=connexion.prepareStatement("insert into RFI values(?,?,?,?,?)");
       prepStat.setInt(1, 0);
       prepStat.setInt(2, Integer.parseInt(NRFI.getText()));
       //prepStat.setDate(3, Date.valueOf(DateRFI.getValue()));
      // prepStat.setDate(4, Date.valueOf(RFIEcheance.getValue()));
      prepStat.setDate(3, MyException.isDate(DateRFI.getValue()));
      prepStat.setDate(4, MyException.isDate(RFIEcheance.getValue()));
       prepStat.setInt(5,Integer.valueOf(NumDossier.getText())); 
       prepStat.executeUpdate();
       ////////////////////////////////////
        prepStat=connexion.prepareStatement("insert into CGAO values(?,?,?,?)");
        prepStat.setInt(1, 0);
        prepStat.setInt(2,Integer.valueOf(CGAONPV.getText()));
        prepStat.setDate(3, MyException.isDate(DateCGAO.getValue()));
        prepStat.setInt(4,Integer.valueOf(NumDossier.getText())); 
        prepStat.executeUpdate();
        ////////////////////////////////////
        prepStat=connexion.prepareStatement("insert into AO values(?,?,?,?,?,?)");
        prepStat.setInt(1, 0);
        prepStat.setInt(2, Integer.valueOf(NAO.getText()));
        prepStat.setDate(3, MyException.isDate(DateAO.getValue()));
        prepStat.setDate(4, MyException.isDate(AOEcheance.getValue()));
        prepStat.setDate(5, MyException.isDate(AORelance.getValue()));
        prepStat.setInt(6,Integer.valueOf(NumDossier.getText())); 
        prepStat.executeUpdate();
          ////////////////////////////////////
        prepStat=connexion.prepareStatement("insert into COF values(?,?,?,?,?)");
        prepStat.setInt(1, 0);
        prepStat.setDate(2, MyException.isDate(COFDateTech.getValue()));
        prepStat.setDate(3, MyException.isDate(COFDateAvis.getValue()));
        prepStat.setDate(4, MyException.isDate(COFDateTech.getValue()));
        prepStat.setInt(5,Integer.valueOf(NumDossier.getText())); 
        prepStat.executeUpdate();
        ////////////////////////////////////
        prepStat=connexion.prepareStatement("insert into AE values (?,?,?,?,?,?,?,?,?)");
        prepStat.setInt(1, 0);
        prepStat.setString(2,NAE.getText());
        prepStat.setString(3, AENature.getValue());
        prepStat.setString(4, AEAnnee.getText());
        prepStat.setDouble(5, Double.valueOf(AEMontant.getText()));
        prepStat.setDouble(6, Double.valueOf(AEMontEnagage.getText()));
        prepStat.setDate(7, MyException.isDate(AEDate.getValue()));
        prepStat.setDate(8,MyException.isDate(AEDateArrivee.getValue()));
        prepStat.setInt(9,Integer.valueOf(NumDossier.getText()));
        prepStat.executeUpdate();
         ////////////////////////////////////
        prepStat=connexion.prepareStatement("insert into CAD values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        prepStat.setInt(1, 0);
        prepStat.setInt(2, Integer.valueOf(CADPVNum.getText()));
        prepStat.setDate(3, MyException.isDate(CADDate.getValue()));
        prepStat.setString(4, CADSignataire.getValue());
        prepStat.setString(5, CADAdjucataire.getText());
        prepStat.setString(6, CADOrigine.getText());
        prepStat.setString(7, CDENum.getText());
        prepStat.setDate(8, MyException.isDate(CDEDate.getValue()));
        prepStat.setString(9, CDESignataire.getValue());
        prepStat.setString(10, CDEDelai.getText());
        prepStat.setDouble(11, Double.valueOf(CADMontant.getText()));
        prepStat.setString(12, CADSituation.getText());
        prepStat.setString(13, CADObservation.getText());
        prepStat.setInt(14,Integer.valueOf(NumDossier.getText()));
        prepStat.executeUpdate();
       System.out.println("bien");
       
       
       
        
    }

    public static Pane getPan()
    {
        return panel;
    }
    
  @FXML private JFXTextField NumDossier,TitreDossier,NDA,
                               Estimation,Objet,NRFI,CGAONPV,NAO,
                               NAE,AEAnnee,AEMontant,AEMontEnagage,CADPVNum,
                               CADAdjucataire,CADOrigine,CDENum,CDEDelai,CADMontant,
                               CADSituation,CADObservation;

    
    @FXML private JFXDatePicker DateCGAO,DateAffec,DateRFI,DateAO,AEDate,AEDateArrivee,CADDate,CDEDate,
                                COFDateTech,COFDateAvis,COFDateCom,AORelance,AOEcheance,RFIEcheance;
     @FXML
    private JFXComboBox<String> Acheteur,Entite,BesionType,SCE,ChefProjet,AENature,CDESignataire,CADSignataire;

}


*/