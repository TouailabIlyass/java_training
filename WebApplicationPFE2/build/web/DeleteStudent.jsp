<%-- 
    Document   : DeleteStudent
    Created on : 30 mai 2017, 15:53:23
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

<%@page import='pfe.StudentDao' %>
<jsp:useBean id='s' class='pfe.Student' ></jsp:useBean>
<jsp:setProperty property='*' name='s' />

<% 
    
     StudentDao st=new StudentDao();
     st.delete(s);
     response.sendRedirect("StudentForm.jsp");
           
%>
    </body>
</html>
