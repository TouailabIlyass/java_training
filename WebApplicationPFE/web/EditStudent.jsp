
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <title>Edit Student</title>
    </head>
    <body>
        

<%@page import='pfe.Student' %>
<%@page import='pfe.StudentDao' %>
        
        <% 
            String id=request.getParameter("id");
            Student s=StudentDao.getOnestudent(Integer.parseInt(id));
        %>
        
        
        <center><h2>Modifier Etudiant :</h2></center> <br><br>
 <form action="Studentedit.jsp" method="POST">


    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
      <input   type="text" class="form-control" name="nom" placeholder="Nom"  value="<%=s.getNom() %>" >
    </div><br>

    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
      <input  type="text" class="form-control" name="prenom" placeholder="Prenom" value="<%=s.getPrenom() %>" >
    </div><br>
    
    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
      <input  type="text" class="form-control" name="email" placeholder="Adresse Email" value="<%=s.getAdresse() %>">
    </div><br>


    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
      <input  type="text" class="form-control" name="user" placeholder="Utilisateur" value="<%=s.getUser()%>">
    </div><br>

    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
      <input  type="password" class="form-control" name="pass" placeholder="Mot de Passe" value="<%=s.getPass() %>">
    </div><br>

    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i> <strong> Date de Naissance</strong></span>
      <input  type="date" class="form-control" name="Date" value="<%=s.getDate()%>">
    </div><br>


    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-education"></i>    <strong>Votre Filiere ?</strong></span>
      <select class="form-control" id="filiere" name="filiere" >
      	<option >Genie Informatique</option>
      	<option >Genie Industrielle et Maintenance</option>
      	<option >Technique de Management</option>
      	<option >Controle de Qualité</option>
      </select>
    </div><br><br><br>
<center>
<button type="reset" class="btn btn-info" >Reset</button>
<button type="submit" name="envoyer" class="btn btn-success" >Edit</button>
</center>
</form>
    </body>
</html>
