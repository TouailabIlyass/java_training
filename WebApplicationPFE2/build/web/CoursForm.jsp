
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

<div id="section3">
<center><h2>Ajouter Cours :</h2></center> <br><br>
 <form action="Ajoutercours.jsp" method="POST">

     <br><br><br>
     
     <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-file"></i></span>
      <input  type="file" class="form-control" name="cours" >
    </div><br>
    
    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-file"></i></span>
      <input  type="text" class="form-control" name="desc"  placeholder="Description du cour" >
    </div><br>

<br><br><br>
<center>
<button type="reset" class="btn btn-info" >Reset</button>
<button type="submit" name="envoyer" class="btn btn-success" >Ajouter</button>
<a href="cours.jsp" >Voir Tout les Cours</a></form></center>
</div>

<br><br><br>



</body>
</html>