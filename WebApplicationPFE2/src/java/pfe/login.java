/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfe;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class login extends HttpServlet{
    
    
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) 
    {
        String nom=request.getParameter("user");
        String mdp=request.getParameter("pass");
        String role=null;
        HttpSession session=request.getSession();
             session.setAttribute("user", nom);
             session.setAttribute("pass", mdp);
        
        try 
        {
       
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pfe","root","");
          
   PreparedStatement st=con.prepareStatement("Select role from login where username= ? and pass=?");
            st.setString(1,nom);
            st.setString(2,mdp);
        ResultSet rs=st.executeQuery();
       
        
         if(rs.next())
           {
                  
               role=rs.getString("role");
                
                
         if( role.equals("p"))
         { 
           
           response.sendRedirect("AdminAcceuil.jsp");
           
         }
         else if( role.equals("e"))
         {
             response.sendRedirect("homeEtudiant.jsp");
            
         }
        }
         
         
        }catch(IOException | ClassNotFoundException | SQLException e)
        {
            System.out.println("erueeeeeeeer SQL");
        }
        
    }
    
}
