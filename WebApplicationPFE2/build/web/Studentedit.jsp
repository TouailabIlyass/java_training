<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>


<% 
    
    String nom,prenom,adresse,user,pass,date,filiere,olduser;
     
     nom=request.getParameter("nom");
     prenom=request.getParameter("prenom");
     adresse=request.getParameter("email");
     user=request.getParameter("user"); 
     olduser=request.getParameter("olduser");
     pass=request.getParameter("pass");
     date=request.getParameter("date");
     filiere=request.getParameter("filiere");
    
    try 
        {
       
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pfe","root","");
          
   PreparedStatement ps=con.prepareStatement
     ("update student set nom=?,prenom=?,adresse=?,user=?,pass=?,date=?,filiere=? where user=?");
            ps.setString(1,nom);
            ps.setString(2,prenom);
            ps.setString(3,adresse);
            ps.setString(4,user);
            ps.setString(5,pass);
            ps.setString(6,date);
            
            ps.setString(7,filiere);
            ps.setString(8,olduser); 
            ps.executeUpdate();
            
        response.sendRedirect("StudentEdited.jsp");
    
        }catch(Exception e)
        {
            
            response.sendRedirect("Failed.jsp");
        }
        
    
    
%>





