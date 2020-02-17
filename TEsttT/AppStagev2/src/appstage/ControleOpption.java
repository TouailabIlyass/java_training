/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appstage;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 *
 * @author kingdragon
 */
public class ControleOpption implements Initializable{

    @FXML
    private JFXButton btnAjouter;

    @FXML
    private JFXTextField textfield;

    @FXML
   private  void Add(ActionEvent e) throws SQLException {

       if(!textfield.getText().equals(""))
       insert(textfield.getText());
       
       
    }
    public static void insert(String s) throws SQLException
    {  
        String id=FXMLAjouterController.getId();
        Connection   connexion=ConnexionDB.getConnexion();
        FXMLAjouterController ct=HomeFxmlController.getLoader().getController();
        PreparedStatement stat;
        if(id.equals("icon_Acheteur"))
        {
            stat=connexion.prepareStatement("insert into Achats values (?,?,?)");
            stat.setInt(1, 0);
            stat.setString(2, s);
            stat.setInt(3, 1);
            stat.executeUpdate();
           
            
            ct.Acheteur.getItems().add(s);
            
        }
        else if(id.equals("icon_Entite"))
        {
            stat=connexion.prepareStatement("insert into Entite values(?,?)");
            stat.setInt(1, 0);
            stat.setString(2, s);
            stat.executeUpdate();
             ct.Entite.getItems().add(s);
        }
        else if(id.equals("icon_Type"))
        {
            stat=connexion.prepareStatement("insert into besion values(?,?)");
            stat.setInt(1, 0);
            stat.setString(2, s);
            ct.BesionType.getItems().add(s);
        }
        else if(id.equals("icon_SCE"))
        {
            stat=connexion.prepareStatement("insert into EntiteSCE values(?,?)");
            stat.setInt(1, 0);
            stat.setString(2, s);
            ct.SCE.getItems().add(s);
            
        }
         else if(id.equals("icon_Chefprojet"))
        {
            stat=connexion.prepareStatement("insert into chefProjet values(?,?)");
            stat.setInt(1, 0);
            stat.setString(2, s);
            ct.ChefProjet.getItems().add(s);
        }
         else if(id.equals("icon_Nature"))
        {
            stat=connexion.prepareStatement("insert into Nature values(?,?)");
            stat.setInt(1, 0);
            stat.setString(2, s);
            ct.AENature.getItems().add(s);
        }
          else if(id.equals("icon_Sig"))
        {
            stat=connexion.prepareStatement("insert into Sig values(?,?)");
            stat.setInt(1, 0);
            stat.setString(2, s);
            ct.CADSignataire.getItems().add(s);
            ct.CDESignataire.getItems().add(s);
            
        }
        
        
      
    }
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }
    
    
    
    
}
