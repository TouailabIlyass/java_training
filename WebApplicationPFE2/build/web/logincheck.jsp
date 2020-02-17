<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
       
        <% 
            
        String nom=request.getParameter("user");
        String mdp=request.getParameter("pass");
        String role=null;
        
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
                 
             session.setAttribute("user", nom);
             session.setAttribute("pass", mdp);
           response.sendRedirect("AdminAcceuil.jsp");
           
         }
         else if( role.equals("e"))
         {
             session.setAttribute("user", nom);
             session.setAttribute("pass", mdp);
             response.sendRedirect("homeEtudiant.jsp");
            
         }
        }
         
         
         else  response.sendRedirect("Failed.jsp");
         
        }catch(SQLException e)
        {
           out.print("erueeeeeeeer SQL");
        }
        
        %>
        
    </body>
</html>
