<html>
    <%
    if(session.getAttribute("user")==null && session.getAttribute("user")==null)
    {
        response.sendRedirect("index.jsp");
    }
    %>
    <style>
        #start  
        {
            position: absolute;
            margin: 200px 290px 305px 475px ;
            color: red;
            width: 620px;
            height: 150px;
            border-radius: 100px;
            background-color: white;
            
        }
        #start:hover{
            background-color: greenyellow;
        }
        #tt
        {
            padding: 40px 30px 40px 90px;
            color: black;
        }
    
   </style>
    
<jsp:include page="header.html" />
    
<div id="start">
    <a href="start.jsp"><h3 id="tt">Demarrer la simulation !</h3></a> 
</div>

  

</html>
