<%-- 
    Document   : info
    Created on : Mar 6, 2019, 3:31:08 PM
    Author     : drging
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>
    <link href="css/agency.css" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet" />
    </head>
    <body>
        <%
        session = request.getSession(false);
        
        %>
        <h4>You are entered the folowing data</h4>
        <h4>First Name : <%out.println(session.getAttribute("fname"));%></h4>
        <h4>Last Name  : <%out.println(session.getAttribute("lname"));%></h4>
        <h4>Amount to pay : <%out.println(session.getAttribute("amount"));%> DH </h4>
        
        <form action="test" method="post">
            
            
            <input type="submit" name="ch" class="btn btn-primary" value="Confirm">
        </form>
        
    </body>
</html>
