

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDonne {
    
    private static Connection connexion;
	
	public  BaseDonne()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ouss","root", "");
			System.out.println("la connexion a réussie!!");
		} catch (ClassNotFoundException | SQLException e) {
			
			  System.out.println("erreur de connexion!!!");
		}
	}
	
	private static  BaseDonne conn = new BaseDonne();
	
	public static Connection getConnexion() {
		return connexion;
	}


	public static BaseDonne getInstance()
	{
		return conn;
	}
}
