<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>


<%
     String nom,desc;
     
     nom=request.getParameter("cours");
     desc=request.getParameter("desc");
    

    try 
        {
       
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pfe","root","");
          
   PreparedStatement st=con.prepareStatement("insert into cours values(?,?,?)");
   
            st.setInt(1,0);
            st.setString(2,nom);
            st.setString(3,desc);
            st.executeUpdate();
            
        }catch(Exception e)
        {
            out.print("ereuuuuuuuuuuur");
        }
       
    response.sendRedirect("Coursadded.jsp");
    
        %>