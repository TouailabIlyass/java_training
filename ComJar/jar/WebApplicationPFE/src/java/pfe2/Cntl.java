
package pfe2;

import com.jfoenix.controls.JFXColorPicker;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.jdom2.JDOMException;


public class Cntl implements Initializable{
    
   @FXML private JFXColorPicker color;
   private Control Cont;
   
      @Override
    public void initialize(URL location, ResourceBundle resources) {
       Cont =Main.getCtl().getController();
    }

    
   @FXML private void Change(ActionEvent e) throws IOException, JDOMException {
   
       Cont.ChangeC(color.getValue().toString());
         
      
   
       
    }
  
  
}
