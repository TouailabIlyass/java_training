<!DOCTYPE html>
<html>
<body>
<header><jsp:include page="header.html" /></header>
<style>
    h3{
        color:red;
      }
      p{
          color:white;
      }
</style>
<section class="box-content box-4 box-style-2">
      <div class="container" >
        <div class="row">
          <div class="box-item">
              <blockquote><h4 style="color:white;">Voici touts les cours en ce qui concerne l'optique géométrique</h4></blockquote>
          </div>
        </div>
      </div>
</section>
<br>
<br>
<div class="container" >
<center><button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal"><strong>Voir Tous les Cours</strong></button></center>
</marquee><br><br>
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <center><h2 class="modal-title"><em>CHAPITRES :</em></h2></center>
        </div>
        <div class="modal-body">
          <div class="list-group">
              <center> <a href="#" class="list-group-item active disabled"><h3>Lentille & Mirroires</h3></a></center>
               <a href="cours/Lentillesconvergentes.pdf" target="_blanc" class="list-group-item"><strong>1/- Lentille Convergente</strong></a>
               <a href="cours/divergente.html" target="_blanc" class="list-group-item"><strong>2/- Lentille Divergente</strong></a>
               <a href="cours/miroir.pdf" target="_blanc" class="list-group-item"><strong>3/- Miroir Concave</strong></a>
               <a href="cours/miroir.pdf" target="_blanc" class="list-group-item"><strong>4/- Miroir Convexe</strong></a>
          </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-danger" data-dismiss="modal"><strong style="color :blue;">Close</strong></button>
        </div>
      </div>
      
    </div>
  </div>
</div>

<nav>
    <center>
<div class="row">
          <div class="col-md-4">
            <div class="box-item">
              <img src="img/l3.png" class="img-responsive"/>
              <div class="content">
                  <center><h3>Lentille Convergente</h3></center>
<p>Une lentille est constituée par un milieu transparent limité par deux dioptres sphériques de
rayons r1 et r2. La droite joignant les centres C1 et C2 de ces calottes est l?axe optique de la
lentille. Si les rayons des deux calottes sont égaux, le centre de la lentille est son centre
optique O.<br>Si elle est plus mince aux bords qu'au milieu elle est convergente, sinon elle est
divergente </p>               
<span>MAY 21, 2014 BY VAFPRESS</span><br>
                <center><a class="btn btn-1" href="cours/Lentillesconvergentes.pdf">Read More</a></center>
              </div>
            </div>
            </div>
            
            <div class="col-md-4">
            <div class="box-item">
              <img src="img/l2.jpg" class="img-responsive"/>
              <div class="content">
                <center><h3>Lentille Divergente</h3></center>
<p>Une lentille est constituée par un milieu transparent limité par deux dioptres sphériques de
rayons r1 et r2. La droite joignant les centres C1 et C2 de ces calottes est l?axe optique de la
lentille. Si les rayons des deux calottes sont égaux, le centre de la lentille est son centre
optique O. <br>Si elle est plus mince aux bords qu'au milieu elle est convergente, sinon elle est
divergente</p>                
<span>MAY 21, 2014 BY VAFPRESS</span><br>
<center><a class="btn btn-1" href="cours/divergente.html" >Read More</a></center>
              </div>
            </div>
            </div>

             <div class="col-md-4">
            <div class="box-item">
              <img src="img/l6.jpg" class="img-responsive"/>
              <div class="content">
                  <center><h3>Miroir Convexe</h3></center>
                <p>Suspendisse porttitor sapien ac lectus euismod imperdiet. Curabitur nec nibh at massa pellentesque accumsan eu id nibh. Donec accumsan ut mi et tincidunt. Aliquam eget metus nec leo tempor bibendum. Phasellus tincidunt lobortis metus. Duis euismod lorem turpis at diam.</p>
                <span>MAY 21, 2014 BY VAFPRESS</span><br>
                <center><a class="btn btn-1" href="cours/miroir.pdf">Read More</a></center>
              </div>
            </div>
             </div><br>
             
          
            
            

 </div></center>
</nav>
<br><br><br>
<jsp:include page="footer.html" />
</body>
</html>