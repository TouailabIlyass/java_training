
package pfe2;

import com.jfoenix.controls.JFXRadioButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.layout.Pane;

public class ContainerDrawerControlle implements Initializable{
    
   
   @FXML  private Pane containerDrawer;
   @FXML  private Accordion Accor;
   @FXML  private JFXRadioButton convergente,divergente,MiroireCv,MiroireCx;
   
  private Control cntl;
  
      @Override
    public void initialize(URL location, ResourceBundle resources) {
      
        cntl=Main.getCtl().getController();
    }
      
  
 
  @FXML private  void ShoseOp(ActionEvent e) {
        
     if(convergente.isSelected())
     {   cntl.ChangeToLentille();
         cntl.ChangeOP(0);
     }
     
     else if(divergente.isSelected())
     {  cntl.ChangeToLentille();
         cntl.ChangeOP(180);
     }
         
     else if(MiroireCv.isSelected())
     {
         cntl.ChangeToMiroire();
       
     }
     else if(MiroireCx.isSelected())
     {
         cntl.ChangeToMiroire();
     }
     
        
      
    }
    
    public boolean isConvergente()
    {
        return convergente.isSelected();
    }
    
    public boolean isMiroireConcave()
    {
                return MiroireCv.isSelected();
        
    }
  public void setConrole(Control c)
    {
        cntl=c;
    }
     
}
