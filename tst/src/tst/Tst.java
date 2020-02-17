/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tst;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Tst {
    private static Connection con;
    
    public static void main(String[] args) throws SQLException {
        
        
        
        B.ok().forEach(s->{
            System.out.println(s.toString());
        
        });
        
        for (Object object : B.ok()) {
             System.out.println(object.toString());
        }
        
     /*
    
    
        try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB","root", "");
			System.out.println("connexion reussie!!");
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
        
       String qr="select id,nom from user";
       PreparedStatement stmt;
       
            stmt=con.prepareStatement(qr);
        
        
        ResultSet rst=stmt.executeQuery();
        while(rst.next())
        {
            System.out.println(rst.getString(1));
        }
       String s="insert into etudiant values (0,'okk','oo')";
       stmt.executeUpdate(s);
       
       String del="delete from etudiant where ";
         */
        
    }
    
}

