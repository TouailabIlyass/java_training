<%-- 
    Document   : Studentedit
    Created on : 30 mai 2017, 16:04:41
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

<%@page import='pfe.StudentDao' %>
<jsp:useBean id='s' class='pfe.Student' ></jsp:useBean>
<jsp:setProperty property='*' name='s' />

 <% 
      int num=StudentDao.Update(s);
          
if(num>0)
   {
       response.sendRedirect("StudentEdited.jsp");
   }
   else
   {
       response.sendRedirect("StudentFailed.jsp");
   }
        %>






    </body>
</html>
