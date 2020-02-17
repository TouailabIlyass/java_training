
package appstage;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Dossier extends RecursiveTreeObject<Dossier>{
    
public  StringProperty     NumDossier,TitreDossier,Acheteur,Entite,BesionType,NDA,DateAffec,SCE,Estimation,ChefProjet,Objet,NRFI,DateRFI,RFIEcheance,CGAONPV,
                           DateCGAO,NAO,DateAO,AOEcheance,AORelance,COFDateTech,COFDateAvis,COFDateCom,AENature,AEAnnee,AEMontant,AEMontEnagage,
                           NAE,AEDate,AEDateArrivee,CADPVNum,CADDate,CADSignataire,CADAdjucataire,CADOrigine,CDENum,CDEDate,CDESignataire,CDEDelai,
                           CADMontant,CADSituation,CADObservation;

    public Dossier(String NumDossier, String TitreDossier, String Acheteur, String Entite, String BesionType, String NDA, String DateAffec, String SCE, String Estimation, String ChefProjet, String Objet, String NRFI, String DateRFI, String RFIEcheance, String CGAONPV, String DateCGAO, String NAO, String DateAO, String AOEcheance, String AORelance, String COFDateTech, String COFDateAvis, String COFDateCom, String AENature, String AEAnnee, String AEMontant, String AEMontEnagage, String NAE, String AEDate, String AEDateArrivee, String CADPVNum, String CADDate, String CADSignataire, String CADAdjucataire, String CADOrigine, String CDENum, String CDEDate, String CDESignataire, String CDEDelai, String CADMontant, String CADSituation, String CADObservation) {
        this.NumDossier = new SimpleStringProperty(NumDossier);
        this.TitreDossier = new SimpleStringProperty(TitreDossier);
        this.NDA = new SimpleStringProperty(NDA);
        this.Estimation = new SimpleStringProperty(Estimation);
        this.Objet = new SimpleStringProperty(Objet);
        this.NRFI = new SimpleStringProperty(NRFI);
        this.CGAONPV = new SimpleStringProperty(CGAONPV);
        this.NAO = new SimpleStringProperty(NAO);
        this.NAE = new SimpleStringProperty(NAE);
        this.AEAnnee = new SimpleStringProperty(AEAnnee);
        this.AEMontant = new SimpleStringProperty(AEMontant);
        this.AEMontEnagage = new SimpleStringProperty(AEMontEnagage);
        this.CADPVNum = new SimpleStringProperty(CADPVNum);
        this.CADAdjucataire = new SimpleStringProperty(CADAdjucataire);
        this.CADOrigine = new SimpleStringProperty(CADOrigine);
        this.CDENum = new SimpleStringProperty(CDENum);
        this.CDEDelai = new SimpleStringProperty(CDEDelai);
        this.CADMontant = new SimpleStringProperty(CADMontant);
        this.CADSituation = new SimpleStringProperty(CADSituation);
        this.CADObservation = new SimpleStringProperty(CADObservation);
        this.DateCGAO = new SimpleStringProperty(DateCGAO);
        this.DateAffec = new SimpleStringProperty(DateAffec);
        this.DateRFI = new SimpleStringProperty(DateRFI);
        this.DateAO = new SimpleStringProperty(DateAO);
        this.AEDate = new SimpleStringProperty(AEDate);
        this.AEDateArrivee = new SimpleStringProperty(AEDateArrivee);
        this.CADDate = new SimpleStringProperty(CADDate);
        this.CDEDate = new SimpleStringProperty(CDEDate);
        this.COFDateTech = new SimpleStringProperty(COFDateTech);
        this.COFDateAvis = new SimpleStringProperty(COFDateAvis);
        this.COFDateCom = new SimpleStringProperty(COFDateCom);
        this.AORelance = new SimpleStringProperty(AORelance);
        this.AOEcheance = new SimpleStringProperty(AOEcheance);
        this.RFIEcheance =new SimpleStringProperty( RFIEcheance);
        this.Acheteur = new SimpleStringProperty(Acheteur);
        this.Entite = new SimpleStringProperty(Entite);
        this.BesionType =new SimpleStringProperty( BesionType);
        this.SCE = new SimpleStringProperty(SCE);
        this.ChefProjet = new SimpleStringProperty(ChefProjet);
        this.AENature = new SimpleStringProperty(AENature);
        this.CDESignataire = new SimpleStringProperty(CDESignataire);
        this.CADSignataire = new SimpleStringProperty(CADSignataire);
    }
                              

   

    
 

    
    
}

/*
    
private Pane pan;

    public Dossier() {
      pan=FXMLAjouterController.getPan();
        
    }
     public Dossier(Pane p) {
      pan=p;
        
    }

   

@Override
  public String toString()
  { String str="";
  
      for (Node obj : pan.getChildren()) {
          
            if(obj instanceof HBox)
            {
                 HBox hbx= (HBox)obj;
                 
                 for (Node elem : hbx.getChildren()) {
                    if(elem instanceof JFXTextField )
                        str+=((JFXTextField) elem).getText()+"  ";       
                    else if(elem instanceof JFXDatePicker )  
                         str+=((JFXDatePicker) elem).toString()+"  ";
                    else if(elem instanceof JFXComboBox )
                      str+=((JFXComboBox) elem).getValue()+"  "; 
                }
                
            }
          
      }
      
      return str;
  }
    
    
    
    
    /*
   @Override
    public String toString()
    {
        NumDossier+"  "+TitreDossier+"  "+Acheteur+"  "+Entite+"  "+BesionType+"  "+NDA+"  "+DateAffec+"  "+SCE+"  "+Estimation+"  "+ChefProjet+"  "+
                Objet+"  "+NRFI+"  "+DateRFI+"  "+RFIEcheance+"  "+CGAONPV+"  "+DateCGAO+"  "+NAO+"  "+DateAO+"  "+
                AOEcheance+"  "+AORelance+"  "+COFDateTech+"  "+COFDateAvis+"  "+COFDateCom+"  "+ 
               AENature+"  "+AEAnnee+"  "+AEMontant+"  "+AEMontEnagage+"  "+AEDate+"  "+NAE+"  "+AEDateArrivee+"  "+
                
                
        
        return null;
    }
    */

