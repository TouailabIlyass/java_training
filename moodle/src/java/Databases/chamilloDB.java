/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author drging
 */
public class chamilloDB {
    
    private static Connection connexion;
	
	private chamilloDB()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/chamilo","root", "");
			System.out.println("connexion reussie!!");
		} catch (ClassNotFoundException e) {
			
                     System.out.println(e.getMessage());
		}
                catch(SQLException e)
                {
                    System.out.println(e.getMessage());
                }
	}
	
	private static  chamilloDB conn = new chamilloDB();
	
	public static Connection getConnexion() {
		return connexion;
	}

	public static chamilloDB getInstance()
	{
		return conn;
	}
}