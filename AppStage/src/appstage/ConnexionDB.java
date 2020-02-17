
package appstage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnexionDB {
    
    private static Connection connexion;
	
	private ConnexionDB()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ap","root", "");
			System.out.println("connexion reussie!!");
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	private static  ConnexionDB conn = new ConnexionDB();
	
	public static Connection getConnexion() {
		return connexion;
	}


	public static ConnexionDB getInstance()
	{
		return conn;
	}
}
