
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConBD {
    
    private static Connection connexion;
	
	private ConBD()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/AppSatge","root", "");
			System.out.println("connexion reussie!!");
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	private static  ConBD conn = new ConBD();
	
	public static Connection getConnexion() {
		return connexion;
	}


	public static ConBD getInstance()
	{
		return conn;
	}
}
