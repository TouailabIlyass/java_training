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

        Contact F = new ContactFerrari( new Ferrari());
        Contact P = new ContactFerrari( new Porsch());
        
        @FXML
    void buttonOpenPressed(ActionEvent e) {
            if (e.getSource().equals(oncare1)) {
                F.buttonOpenPressed();
                Image image = new Image("images/F_opened.jpeg");
                imgview1.setImage(image);
                
            }
            else
            {
               P.buttonOpenPressed();
               Image image = new Image("images/P_opened.jpg");
                imgview2.setImage(image);
              
            }

    }

    @FXML
    void buttonClosePressed(ActionEvent e) {
             if (e.getSource().equals(offcare1)) {
                F.buttonClosedPressed();
                 Image image = new Image("images/F_closed.jpeg");
                imgview1.setImage(image);
                
            }
            else
             {
                  P.buttonClosedPressed();
                Image image = new Image("images/P_closed.jpg");
                imgview2.setImage(image);
             }
               
    }
    
}
