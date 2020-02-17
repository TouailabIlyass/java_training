<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Plateforme Loi optique</title>
  <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="css/style.css">
  <script src="bootstrap-3.3.7-dist/jquery-3.1.0.min.js"></script>
  <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
  
</head>




<style type="text/css">

  .main-title:hover
{
   text-decoration: underline double brown; 
   cursor: default;
}

body
{
    background-image: url('img/proj.jpg');
}

</style>

  
  <br><br><br><br>
  <center><h1 style="color:green;"><em>Platforme des Lois Optiques<em></h1></marquee></center>

    <h1 data-toggle="modal" data-target="#myModal" class="main-title">Log In</h1>



 <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
        <div class="modal-header" style="background-image:url('flou.jpg');">
          <button type="button" class="close" data-dismiss="modal">&times;</button>

          <center><h4 class="modal-title"><strong style="color: black;">Connection :</strong></h4></center>
        </div>
        <div class="modal-body" style="background-image: url('flou.jpg');">
      <!-------------------------------------------------------------->


<form action="login" >
    
 <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
      <input  type="text" class="form-control" name="user" placeholder="Utilisateur" required>
    </div><br>

    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
      <input  type="password" class="form-control" name="pass" placeholder="Mot de Passe" required>
    </div><br>
 </div>
 
   <div class="modal-footer" style="background-image: url('flou.jpg');">
   <button type="reset" class="btn btn-info" >Reset</button>
   <button type="submit" name="envoyer" class="btn btn-success">LogIn</button>
   

        </div>
      </div>
    </div>
  </div>
</div>
</form>
      
      


</html>
