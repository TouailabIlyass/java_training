<%-- 
    Document   : fin.jsp
    Created on : Mar 6, 2019, 4:23:24 PM
    Author     : drging
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        session = request.getSession(false);
        
        %>
         <h4>First Name : <%out.println(session.getAttribute("fname"));%></h4>
        <h4>Last Name  : <%out.println(session.getAttribute("lname"));%></h4>
        <h4>Amount to pay : <%out.println(session.getAttribute("amount"));%> DH </h4>
    </body>
</html>
