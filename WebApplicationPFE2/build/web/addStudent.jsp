<%@page import="java.sql.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    



<%
     String nom,prenom,adresse,user,pass,date,filiere;
     
     nom=request.getParameter("nom");
     prenom=request.getParameter("prenom");
     adresse=request.getParameter("email");
     user=request.getParameter("user");
     pass=request.getParameter("pass");
     date=request.getParameter("date");
     filiere=request.getParameter("filiere");
     
     out.print(nom);
    try 
        {
       
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pfe","root","");
          
   PreparedStatement st=con.prepareStatement
        ("insert into student values(?,?,?,?,?,?,?)");
   
            st.setString(1,nom);
            st.setString(2,prenom);
            st.setString(3,adresse);
            st.setString(4,user);
            st.setString(5,pass);
            st.setString(6,date);
            st.setString(7,filiere);
            st.executeUpdate();
            
     st=con.prepareStatement("insert into login values(?,?,?)");
     st.setString(1,user);
     st.setString(2,pass);
     st.setString(3, "e");
     
     st.executeUpdate();
     
        }catch(Exception e)
        {
            out.print("ereuuuuuuuuuuur");
        }
       
    response.sendRedirect("StudentAdded.jsp");
    
        %>
           
   
</html>
