/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

import Databases.MysqlCon;
import Model.Produit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author drging
 */
public class ProduitService {
    public static ArrayList<Produit> getProduits()
    {
        ArrayList<Produit> list = new ArrayList<Produit>();
        try {
            PreparedStatement stmt = MysqlCon.getConnexion().prepareStatement("select * from produit");
            ResultSet rst=stmt.executeQuery();
            while(rst.next())
                list.add(new Produit(rst.getInt(1),rst.getString(2),rst.getDouble(3))); 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return list;
    }
     public static Produit getProduit(int id)
    {
        try {
            PreparedStatement stmt = MysqlCon.getConnexion().prepareStatement("select * from produit where id = ?");
            stmt.setInt(1, id);
            ResultSet rst=stmt.executeQuery();
            if(rst.next())
                return  new Produit(rst.getInt(1),rst.getString(2),rst.getDouble(3)); 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return null;
    }
    
}
