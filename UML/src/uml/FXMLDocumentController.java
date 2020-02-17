/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uml;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author kingdragon
 */
public class FXMLDocumentController  {
    
    @FXML
    private ImageView imgview1;

    @FXML
    private ImageView imgview2;

    @FXML
    private JFXButton oncare1,oncare2,offcare1,offcare2;
    
    private static int onc1=1,onc2=5;

        Contact F = new ContactFerrari( new Ferrari());
        Contact P = new ContactFerrari( new Porsch());
        
        @FXML
    void buttonOpenPressed(ActionEvent e) {
            if (e.getSource().equals(oncare1)) {
              if(onc1<5){
                  onc1=onc1+1;
                   F.buttonOpenPressed();
                Image image = new Image("images/"+onc1+".jpg");
                imgview1.setImage(image);
                System.out.println(onc1);
              } 
            }
            else
            {
                
                if(onc2>1)
                {
                    onc2=onc2-1;
                    P.buttonOpenPressed();
               Image image = new Image("images/"+onc2+"x.jpg");
                imgview2.setImage(image);
                 System.out.println(onc2);
                }
               
              
            }

    }

    @FXML
    void buttonClosePressed(ActionEvent e) {
             if (e.getSource().equals(offcare1)) {
                 if(onc1>1)
                 {
                     onc1=onc1-1;
                     F.buttonClosedPressed();
                     Image image = new Image("images/"+onc1+".jpg");
                     imgview1.setImage(image);
                     System.out.println(onc1);
                 }
                     
                 
                
                
            }
            else
             {
                 if(onc2<5)
                 {
                     onc2=onc2+1;
                     P.buttonClosedPressed();
                     Image image = new Image("images/"+onc2+"x.jpg");
                     imgview2.setImage(image);
                     System.out.println(onc2);
                 }
             }
               
    }
    
}
