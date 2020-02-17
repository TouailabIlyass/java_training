/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author drging
 */
public class Fenet1Controller implements Initializable {

   @FXML
    private TextField edt1;

    @FXML
    private TextField edt2,pk,vk;

    @FXML
    private ComboBox<Label> combo;

    @FXML
    private Button btn;
    private static String op1="Chiffrer";
    private static String op2="Dechiffrer";

    @FXML
    void crypter(ActionEvent event) {
       Label l= combo.getSelectionModel().getSelectedItem();
       String s=null,s2=null;
       if (l.getText().equals(op1))
       {
           s=Operation.Crypter(edt1.getText());
           edt2.setText(s);
           
       }
       else if (l.getText().equals(op2))
       {
           edt2.setText(Operation.Decrypter(edt1.getText()));
       }
        pk.setText(""+Operation.getKey().get('e'));
        vk.setText(""+Operation.getKey().get('d'));
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combo.getItems().add(new Label(op1));
        combo.getItems().add(new Label(op2));
        //combo.setItems(FXCollections.observableArrayList(new Label (op1),new Label (op2)));
       
    }    
    
}
