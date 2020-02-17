<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="Css.css">
	<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
</head>
<body>
 <%
    if(session.getAttribute("user")==null && session.getAttribute("user")==null)
    {
        response.sendRedirect("index.jsp");
    }
    %>
<style type="text/css">
	
.etud
{
	position: relative;
	margin-left: 779px;
	margin-right: 100px;
	margin-top: 200px;
	background-color: white;
	border: 5px gray solid;
   height: 320px;
   padding: 20px 20px 20px 20px;
}

.prof
{
	position: relative;
	margin-left: 100px;
	margin-right: 772px;
	margin-top: -321px;
	background-color: white;
	border: 5px gray solid;
    height: 320px;
    padding: 20px 20px 20px 20px;
}

img
{
	padding-bottom: 20px;
}

body
{
	background-image: url('img/proj.jpg');
}


</style>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <ul class="nav navbar-nav navbar-right">
     <li><a href="logout"><span class="glyphicon glyphicon-off"></span> Log Out</a></li>
    </ul>
  </div>
</nav>

<div class="etud">

<center><h2 style="color:green;">En tant qu'etudiant</h2></center>
<p style="color:black;">Si vous selectioner ce choix vous allez etre deriger vers les pages d'observations .</p>
<center><img src="img/proj.jpg" width="350" height="125"></center>
<center><a href="homeEtudiant.jsp"><button type="button" class="btn btn-info btn-md">Visualiser</button></a></center>

</div>

<div class="prof">

<center><h2 style="color:green;">En tant que prof</h2></center>
<p style="color:black;">Si vous selectionner ce choix vous allez etre se deriger vers la gestion de la plateforme .</p>
<center><img src="img/s2.png" width="350" height="125"></center>
<center><a href="StudentForm.jsp"><button type="button" class="btn btn-info btn-md" >Visualiser</button></a></center>



	

</div>
</body>
</html>
