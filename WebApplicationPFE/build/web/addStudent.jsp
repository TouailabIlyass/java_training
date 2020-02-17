<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
       
<%@page import="pfe.StudentDao" %>
<jsp:useBean id="s" class="pfe.Student"></jsp:useBean>
<jsp:setProperty property="*" name="s"/>



<%

int num = StudentDao.Add(s);

if(num>0){
	response.sendRedirect("StudentAdded.jsp");
}else{
	response.sendRedirect("StudentFailed.jsp");
}


%>

             
    
</html>
