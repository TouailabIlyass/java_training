<%-- 
    Document   : index
    Created on : Feb 13, 2019, 3:02:19 PM
    Author     : drging
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <title>JSP Page</title>
        
    </head>
    <body>
        
        <% if(request.getAttribute("status")!=null && request.getAttribute("status").equals("erreur")) {%>
    <div class="alert alert-danger fade in">

        <a href="#" class="close" data-dismiss="alert">&times;</a>
         user or password incorrect!!

    </div>
<% }%>

        <form method="POST" action="Servlet1">
            <label>Login </label><input type="text" id="login" name="login"><br>
            <label>Password </label><input type="password" id="pass" name="pass"><br>
            <input type="submit" value="Submit"/>
            </form>
    </body>
     <script src="jq.min.js"></script>
      <script src="js/bootstrap.min.js"></script>
</html>
