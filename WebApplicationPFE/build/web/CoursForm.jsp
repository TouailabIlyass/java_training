
<html>
<head>
	<title>Admin page</title>
	<link rel="stylesheet" type="text/css" href="admin.css">
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
</head>

<body style="background-image: url('proj.jpg'); background-attachment: fixed; ">

<header>
 <div class="jumbotron">
    <center><h1>Gestionnaire platforme</h1>
    <p>Gestion des etudiants,des cours,des simulations .</p> </center>
  </div> 
</header>

<section>
    <ul>
	 <li><a href="StudentForm.jsp">Gestion des Etudiants</a></li>
	 <li><a href="CoursForm">Gestion des Cours</a></li>
	 <li><a href="#">Gestion des Simulations</a></li>
	 <li><center><a href="AdminAcceuil.html">Quitter</a></center></li>
	</ul>
</section>

<div id="section3">
<center><h2>Ajouter Cours :</h2></center> <br><br>
 <form action="#" method="POST">


    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-book"></i></span>
      <input   type="text" class="form-control" name="nom" placeholder="Nom Cour" required>
    </div><br>

    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-file"></i></span>
      <input  type="file" class="form-control" name="prenom" required>
    </div><br>

    

    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i> <strong> Date :</strong></span>
      <input  type="date" class="form-control" name="Date" required>
    </div><br>

<br><br><br>
<center>
<button type="reset" class="btn btn-info" >Reset</button>
<button type="submit" name="envoyer" class="btn btn-success" >S'inscrire</button>
</center>
</form>
	
</div>


<div id="section4">
<center><h2>Liste des Cours :</h2></center> <br><br>

  <table class="table table-striped">
    <thead>
      <tr>
        <th>Nom Cour</th>
        <th>Date</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>lois optiques</td>
        <td>12/12/1996</td>
        <td><a href="">Editer </a><a href="">Supprimer</a></td>
      </tr>
    </tbody>
  </table>
</div>
	

<br><br><br>



</body>
</html>