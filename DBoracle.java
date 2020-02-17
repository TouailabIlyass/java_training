/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_ecole.Java.Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author windows
 */
public class DB {
    
    private static Connection con;
    private DB()
    {
        try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                String url = "jdbc:oracle:thin:@localhost:1521:orcl";
                con = DriverManager.getConnection(url, "system", "system");
                System.out.println("ok");
              
                
            } catch (ClassNotFoundException | SQLException ex) {
               System.out.println(ex.getMessage());
            }

           
        }
    
    private static DB base = new DB();
    
    public static Connection getCon()
    {
        return con;
    }
    
    public static DB getInstance()
    {
        return base;
    }

    
}
