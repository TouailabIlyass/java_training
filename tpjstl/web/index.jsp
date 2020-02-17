<%-- 
    Document   : index
    Created on : Mar 27, 2019, 3:08:17 PM
    Author     : drging
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1 align="center">Ex1:Nombre Parfait</h1>
        <form action="index.jsp" method="get">
            <input type="number" name="value" >
            <input type="submit" name="snd" value="Send">
        </form>
        
         <c:set var="t" value="${param.value}"/>
         <c:set var="s" value="0"/>
         <c:forEach var="i" begin="1" end="${t-1}">
             <c:if test="${t%i==0}">
            <c:set var="s" value="${s+i}"/>
             </c:if>
            </c:forEach>
         
         
         <c:if test="${t==s}">
        <c:out  value ="${s} is parfait" />
         </c:if>
         
         <c:if test="${t!=s}">
        <c:out  value ="${t} is not" />
         </c:if>
    </body>
</html>

   