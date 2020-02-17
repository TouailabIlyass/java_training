<%-- 
    Document   : index
    Created on : Dec 1, 2018, 4:09:59 PM
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
        <form>
            <input type="input" id="search">
            
            <input type="submit" id="submit" value="search">
            
        </form>
        <div id="content">
            <table id="item" class="table table-bordered">
                
                <tr><th>Departement</th><th>cours name</th><th>summary</th></tr>
                <tbody id="tbd">
                   
                </tbody>
            </table>
            
        </div>
    </body>
     
     <script src="jq.min.js" type="text/javascript"></script>
      <script src="js/bootstrap.min.js"></script>
      <script>
            $(document).ready(function(){
                //var url = "LivreController?action=livres";
                  var content=$("#content");
                  var search=$("#search");
                  var item=$("#tbd");
                $("#submit").click(function(e){
                    e.preventDefault();
                    item.html('');
                     //var url="http://localhost:8084/moodle/webresources/course/";
                     var url="http://192.168.1.16/moodle/moodle/webservice/webs.php";
                     url =  url+"?name="+search.val();
                    $.ajax({
                        url: url,
                        type: "GET",
                        datatype : "JSON",
                     success: function(data) {
                           // var h1 = $("#txt").text(JSON.stringify(data)); 
                           //alert(JSON.stringify(data));
                           for(var i=0;i<data.length;i++)
                           {
                             item.append('<tr><td>'+data[i].categorie+'</td><td><a href="'+data[i].link+data[i].id+'">'+data[i].fullname+'</a></td><td>'+data[i].summary+'</td></tr>');
                           }
                      }
                    });
                    getDataFromChamilo();
                    getDataFromOrcl();
                });
                
               function getDataFromChamilo()
               {
                    var url="http://192.168.1.8/chamilo/webservice/webs.php";
                    url =  url+"?name="+search.val();
                        $.ajax({
                        url: url,
                        type: "GET",
                        datatype : "JSON",
                     success: function(data){
                           for(var i=0;i<data.length;i++)
                           {
                             item.append('<tr><td>'+data[i].categorie+'</td><td><a href="'+data[i].link+data[i].id+'">'+data[i].fullname+'</a></td><td>'+data[i].summary+'</td></tr>');
                           }
                      }
                    });
                }
                function getDataFromOrcl()
               {console.log('ok');
                    var url="http://192.168.1.16/el/webresources/post";
                    //url =  url+"?name="+search.val();
                        $.ajax({
                        url: url,
                        type: "GET",
                        datatype : "JSON",
                     success: function(data){
                         console.log('ok111');
                           for(var i=0;i<data.length;i++)
                           {
                             item.append('<tr><td>'+data[i].categorie+'</td><td><a href="'+data[i].link+data[i].id+'">'+data[i].fullname+'</a></td><td>'+data[i].summary+'</td></tr>');
                           }
                      }
                    });
                }
            });
        </script>
      
<!--     <script>
            $(document).ready(function(){
                //var url = "LivreController?action=livres";
                var url2="http://win87-PC:8084/el/webresources/post/test";
                  var content=$("#content");
                  var search=$("#search");
                  var item=$("#tbd");
                $("#submit").click(function(e) {
                    e.preventDefault();
                     var url="http://192.168.1.8:8084/moodle/webresources/course/";
                     
                     url =  url+search.val();
                    $.ajax({
                        url: url2,
                        headers: {
                              Accept:  "application/json; charset=utf-8",
                                "Content-Type" : "application/json; charset=utf-8",
                                "Access-Control-Allow-Origin":"*"
                            },
                        type: "GET",
                        datatype : "JSON",
                     success: function(data) {
                           // var h1 = $("#txt").text(JSON.stringify(data)); 
                           //alert(JSON.stringify(data));
                           item.html('');
                           alert("ok1111"); 
                           for(var i=0;i<data.length;i++)
                           {
                                //alert("ok"); 
                            //item.append('<tr><td>'+data[i].categorie+'</td><td><a href="'+data[i].link+data[i].id+'">'+data[i].fullname+'</a></td><td>'+data[i].summary+'</td></tr>');

                           }
                      
                        },
                        error:function(x,y)
                        {
                          alert(JSON.stringify(x));  
                        }
                    });
                    ///////
                    //getOrcl();
                    //////
                });  
            });
            
            function getOrcl()
            {
                 alert('eeee');
                $.ajax({
                        url: url2,
                        type: "GET",
                        datatype : "JSON",
                     success: function(data) {
                           // var h1 = $("#txt").text(JSON.stringify(data)); 
                           //alert(JSON.stringify(data));
                           //item.html('');
                          
                           for(var i=0;i<data.length;i++)
                           {
                                //alert("ok"); 
                            item.append('<tr><td>'+data[i].categorie_id+'</td><td><a href="'+data[i].nom+data[i].id+'">'+data[i].sdesc+'</a></td><td>'+data[i].fdesc+'</td></tr>');

                           }
                      
                            }
                    });
                ///
            }
            
        </script>-->
</html>
