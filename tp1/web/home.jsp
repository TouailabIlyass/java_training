<%-- 
    Document   : home
    Created on : 25 févr. 2019, 20:53:56
    Author     : win87
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    
    session = request.getSession(false);
   if(session.getAttribute("user") == null || session.getAttribute("user").equals(""))
   {
       response.sendRedirect("index.jsp");
   }
%>

<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- CSRF Token -->
    <meta name="csrf-token" content="yU1yjS2EiaEnV08yKTJNwfKYqrerimkkjRnrTZWB">

    <title>E-learning</title>


    <title>home</title>
<link href="css/simple-line-icons.css" rel="stylesheet" type="text/css">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>
    <link href="css/agency.css" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet" />
 
  
  </head>



  <body id="page-top">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarTogglerDemo01"><strong>
    <a class="navbar-brand" href="elearn.jsp">E-learning</a></strong>
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        <% 
            
        out.println(session.getAttribute("user"));
        %>
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          
                                        <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="http://localhost:8000/logout"
                                            onclick="event.preventDefault();
                                                     document.getElementById('logout-form').submit();">Déconnecter
                                                     <form id="logout-form" action="http://localhost:8000/logout" method="POST" style="display: none;">
                                                      <input type="hidden" name="_token" value="yU1yjS2EiaEnV08yKTJNwfKYqrerimkkjRnrTZWB">
                                                    </form></a>
        </div>
      </li>
          </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control" type="search" placeholder="Search" aria-label="Search">
       <span class="input-group-btn">
                     <button class="btn btn-primary" type="submit"><span class="fa fa-search"></span></button>
                   </span>
    </form>
    
  </div>
</nav>

  

   <!--content-->
   
   
      <!-- Header -->
    <header class="mastheadt">
      <div class="container">
        <div class="intro-text">
          
        </div>
      </div>
    </header>
  <!--headeEnd-->  
  <section>
<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="alert alert-success" role="alert">
  <h4 class="alert-heading">Vous étes connecté</h4>
  <p>Bienvenu chez votre site web</p>
  <hr>
  <p class="mb-0">E-learning</p>
</div>
        </div>
    </div>
</div>
</section>

   <!--content end-->

     <!-- Footer -->
<footer class="page-footer font-small stylish-color-dark pt-4 darkbackground">

    <div class="container text-center text-md-left ">
      <div class="row">
        <div class="col-md-4 mx-auto">

          <h5 class="font-weight-bold text-uppercase mt-3 mb-4">Footer Content</h5>
          <p>hna ghanhdro 3la charika aw site bsifa 3ama hna ghanhdro 3la charika aw site bsifa 3ama hna ghanhdro 3la charika aw site bsifa 3ama hna ghanhdro 3la charika aw site bsifa 3ama </p>

        </div>
        <hr class="clearfix w-100 d-md-none">
        <div class="col-md-2 mx-auto">

          <h5 class="font-weight-bold text-uppercase mt-3 mb-4">Links</h5>

          <ul class="list-unstyled">
            <li>
              <a href="#!" class="text-white">Link 1</a>
            </li>
            <li>
              <a href="#!" class="text-white">Link 2</a>
            </li>
            <li>
              <a href="#!" class="text-white">Link 3</a>
            </li>
            <li>
              <a href="#!" class="text-white">Link 4</a>
            </li>
          </ul>

        </div>
       

        <hr class="clearfix w-100 d-md-none">

        <div class="col-md-2 mx-auto">

          <h5 class="font-weight-bold text-uppercase mt-3 mb-4">Links</h5>

          <ul class="list-unstyled">
            <li>
              <a href="#!" class="text-white">Link 1</a>
            </li>
            <li>
              <a href="#!" class="text-white">Link 2</a>
            </li>
            <li>
              <a href="#!" class="text-white">Link 3</a>
            </li>
            <li>
              <a href="#!" class="text-white">Link 4</a>
            </li>
          </ul>

        </div>

        <hr class="clearfix w-100 d-md-none">

        <div class="col-md-2 mx-auto">

          <h5 class="font-weight-bold text-uppercase mt-3 mb-4">Links</h5>

          <ul class="list-unstyled">
            <li>
              <a href="#!" class="text-white">Link 1</a>
            </li>
            <li>
              <a href="#!" class="text-white">Link 2</a>
            </li>
            <li>
              <a href="#!" class="text-white">Link 3</a>
            </li>
            <li>
              <a href="#!" class="text-white">Link 4</a>
            </li>
          </ul>

        </div>

      </div>

    </div>

    <hr>
    <ul class="list-unstyled list-inline text-center py-2">
      <li class="list-inline-item">
        <h5 class="mb-1">Nous contacter</h5>
      </li>
      <li class="list-inline-item">
        <a href="#!" class="btn btn-outline-warning btn-rounded">contacter</a>
      </li>
    </ul>
</footer>

<!--second footer-->
<footer> <div class="container">
       
        <div class="row">
          <div class="col-md-4">
            <span class="copyright">Copyright &copy; elearning 2019</span>
          </div>
          <div class="col-md-4">
            <ul class="list-inline social-buttons">
              <li class="list-inline-item">
                <a href="#">
                  <i class="fab fa-twitter"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#">
                  <i class="fab fa-facebook-f"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#">
                  <i class="fab fa-linkedin-in"></i>
                </a>
              </li>
            </ul>
          </div>
          <div class="col-md-4">
            <ul class="list-inline quicklinks">
               <li class="list-inline-item">
                <a href="" class="badge badge-info" target="_blank">created by C.I.S.T ensa</a>
              </li>
            </ul>
          </div>
        </div>
      </div></footer>
<!--FooterEnd -->
    <script src="http://localhost:8000/tawfik/jquery/jquery.min.js"></script>
    <script src="http://localhost:8000/tawfik/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="http://localhost:8000/tawfik/jquery-easing/jquery.easing.min.js"></script>
    <script src="http://localhost:8000/tawfik/js/jqBootstrapValidation.js"></script>
    <script src="http://localhost:8000/tawfik/js/contact_me.js"></script>
    <script src="http://localhost:8000/tawfik/js/agency.min.js"></script>




  </body>

</html>

    
