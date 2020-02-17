<%@page import="java.lang.System.out"%>
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
        String passwd=null,user=null,role=null;
        
        try 
        {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pfe","root","");
          
         Statement st=con.createStatement();
                
        ResultSet rs=st.executeQuery("Select * from login");
        
         while(rs.next())
                {
                  user=rs.getString("username");
                  passwd=rs.getString("pass");
                  role=rs.getString("role");
                
                
         if( nom.equals(user) && mdp.equals(passwd) && role.equals("p"))
         { 
           response.sendRedirect("AdminAcceuil.html");
           out.print("fffffffffffffffff");
         }
         else if( nom.equals(user) && mdp.equals(passwd) && role.equals("e"))
         {
             response.sendRedirect("index.jsp");
            
         }
        }
         
         
         response.sendRedirect("Failed.jsp");
         
        }catch(SQLException e)
        {
           out.print("erueeeeeeeer SQL");
        }
        
        %>
        
    </body>
</html>
