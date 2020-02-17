/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

import Databases.MysqlCon;
import Model.Client;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author drging
 */

public class ClientService {
    public static ArrayList<Client> getClients()
    {
        ArrayList<Client> list = new ArrayList<Client>();
        try {
            PreparedStatement stmt = MysqlCon.getConnexion().prepareStatement("select * from client");
            ResultSet rst=stmt.executeQuery();
            while(rst.next())
                list.add(new Client(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4))); 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return list;
    }
     public static Client getClient(String id)
    {
        try {
            PreparedStatement stmt = MysqlCon.getConnexion().prepareStatement("select * from client where cin = ?");
            stmt.setString(1, id);
            ResultSet rst=stmt.executeQuery();
            if(rst.next())
                return  new Client(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4)); 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return null;
    }
}
