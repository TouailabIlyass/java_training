<html>
<head>
	<title>Admin page</title>
	<link rel="stylesheet" type="text/css" href="css/admin.css">
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
</head>


<body style="background-image: url('img/proj.jpg'); background-attachment: fixed; ">
<%
    if(session.getAttribute("user")==null && session.getAttribute("user")==null)
    {
        response.sendRedirect("index.jsp");
    }
    %>
<header>
 <div class="jumbotron">
    <center><h1>Gestionnaire platforme</h1>
    <p>Gestion des etudiants,des cours,des simulations .</p> </center>
  </div> 
</header>


<section>
    <ul>
	  <li><center><a href="StudentForm.jsp">Gestion des Etudiants</a></center></li>
	 <li><center><a href="CoursForm.jsp">Gestion des Cours</a></center></li>
	 <li><center><a href="#">Gestion des Simulations</a></center></li>
	 <li><center><a href="AdminAcceuil.jsp">Quitter</a></center></li>
	</ul>
</section>

<div id="section1">
<center><h2>Ajouter Etudiant :</h2></center> <br><br>
 <form action="addStudent.jsp" method="POST">


    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
      <input   type="text" class="form-control" name="nom" placeholder="Nom" required>
    </div><br>

    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
      <input  type="text" class="form-control" name="prenom" placeholder="Prenom" required>
    </div><br>

    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
      <input  type="text" class="form-control" name="email" placeholder="Adresse Email" required>
    </div><br>

    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
      <input  type="text" class="form-control" name="user" placeholder="Utilisateur" required>
    </div><br>

    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
      <input  type="password" class="form-control" name="pass" placeholder="Mot de Passe" required>
    </div><br>

    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i> <strong> Date de Naissance</strong></span>
      <input  type="date" class="form-control" name="date" required>
    </div><br>


    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-education"></i>    <strong>Votre Filiere ?</strong></span>
      <select class="form-control" id="filiere" name="filiere">
      	<option >Genie Informatique</option>
      	<option >Genie Industrielle et Maintenance</option>
      	<option >Technique de Management</option>
      	<option >Controle de Qualité</option>
      </select>
    </div><br><br><br>
<center>
<button type="reset" class="btn btn-info" >Reset</button>
<button type="submit" name="envoyer" class="btn btn-success" >Ajouter</button>
</center>
</form>
	
</div>

<%@page import='pfe.Student' %>
<%@page import='pfe.StudentDao' %>
<%@page import='java.util.*' %>
<%@page import='javax.servlet.http.*,javax.servlet.*' %>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>

    <% 
         StudentDao st=new StudentDao();
    List<Student> list=st.getAllstudent();
    request.setAttribute("list", list);
    %>
    
<div id="section2">
<center><h2>Liste des Etudiant :</h2></center> <br><br>

  <table class="table table-striped">
    <thead>
        <tr>
        <th>Nom</th>
        <th>Prenom</th>
        <th>Adresse</th>
        <th>User</th>
        <th>Password</th>
        <th>Date</th>
        <th>Filiere</th>
        <th></th>
      </tr>
    </thead>
   
    <c:forEach var='s' items="${list}" >
    <tbody>
      <tr>
        <td>${s.getNom()}</td>
        <td>${s.getPrenom()}</td>
        <td>${s.getAdresse()}</td>
        <td>${s.getUser()}</td>
        <td>${s.getPass()}</td>
        <td>${s.getDate()}</td>
        <td>${s.getFiliere()}</td>
 <td><a href="DeleteStudent.jsp?user=${s.getUser()}">Supprimer </a><a href="EditStudent.jsp?user=${s.getUser()}">Editer</a></td>
      </tr>
    </tbody>
    </c:forEach>
    
  </table>
</div>
	

<br><br><br>


</body>

</html>