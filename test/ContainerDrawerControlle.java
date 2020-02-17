
package pfe2;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXSlider;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ContainerDrawerControlle implements Initializable{
    
   
   @FXML  private Pane containerDrawer;
   @FXML  private Accordion Accor;
   @FXML  private JFXRadioButton convergente,divergente,MiroireCv,MiroireCx;
   @FXML  private JFXSlider sldWidth,sldHeight;

   
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
     
      cntl.Init();
      
      
    }
    
    public boolean isConvergente()
    {
        return convergente.isSelected();
    }
     public boolean isDivergente()
    {
        return divergente.isSelected();
    }
    
    public boolean isMiroireConcave()
    {
        return MiroireCv.isSelected();
        
    }
    public boolean isMiroireConvexe()
    {
        return MiroireCx.isSelected();
        
    }
    
  public void setConrole(Control c)
    {
        cntl=c;
    }
     
  
  @FXML
    void Size(MouseEvent e) {
        
        if(e.getSource().equals(sldWidth))
        {
            cntl.ChangeWidth(sldWidth.getValue());
            System.out.println("pfe2.ContainerDrawerControlle.Size()");
        }
        else 
        {
            cntl.ChangeHeight(sldHeight.getValue());
        }
    }
    
    
    @FXML
    void Close(MouseEvent e) {
      cntl.Close();
        System.err.println("hh");
    }
    
    public void SetSliderWidth(double d)
    {
        sldWidth.setValue(d);
    }
    public void SetSliderHeight(double d)
    {
        sldHeight.setValue(d);
    }
}
