<%-- 
    Document   : mespro
    Created on : Mar 6, 2019, 4:46:53 PM
    Author     : drging
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        
        HashMap<String,Integer> list=(HashMap<String,Integer>)session.getAttribute("produit");
        Set s = list.entrySet();
        Iterator it =s.iterator();
       
        while(it.hasNext())
        {
            Map.Entry<String,Integer> val = (Map.Entry<String,Integer>)it.next();
            out.println(val.getKey()+"    "+val.getValue()+" DH<br>");
        }
        
        
        %>
        <form action="produit" method="post">
            
            
            <input type="submit" name="vl" class="btn btn-primary" value="Confirm">
        </form>
        
    </body>
</html>
