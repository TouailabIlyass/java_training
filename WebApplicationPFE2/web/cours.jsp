
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<html>
<body>
    <%
    if(session.getAttribute("user")==null && session.getAttribute("user")==null)
    {
        response.sendRedirect("index.jsp");
    }
    %>
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
  
  <%@page import='pfe.Cours' %>
  <%@page import='pfe.StudentDao' %>
<%@page import='java.util.*' %>
<%@page import='javax.servlet.http.*,javax.servlet.*' %>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>

<% 
         StudentDao st=new StudentDao();
    List<Cours> list=st.getAllcours();
    request.setAttribute("list", list);
    
    %>


    <c:forEach var='s' items="${list}" >
  
<div class="list-group-item">
 <a href="cours/${s.getPath()}"target="_blanc" ><strong style="color:black;">${s.getDesc()}</strong></a>
 <a href="supcours.jsp?path=${s.getPath()}" style="float:right;"><i class="glyphicon glyphicon-trash"></i></a></div>
        
    </c:forEach>









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