<%-- 
    Document   : page2
    Created on : Mar 27, 2019, 4:25:51 PM
    Author     : drging
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1 align="center">Ex2: outile de calcule Imc</h1>
       <form action="page2.jsp" method="get">
           
           <input type="number" name="age" placeholder="age"><br>
           <input type="number" name="poids"  placeholder="poids"><br>
           <input type="number" name="taille" placeholder="taille"><br>
            <input type="submit" name="snd" value="Send">
        </form>
            
          <c:set var="imc" value="${param.poids/param.taille}"/>
     
         <c:if test="${param.age<=65 && param.age>=18}">
             
         <c:if test="${imc<=16}">
        <c:out  value ="Anorexie ou denutrition" />
         </c:if>
       <c:if test="${imc>=16.5 && imc<18.5}">
        <c:out  value ="Maigreur" />
         </c:if>
       <c:if test="${imc>=18.5 && imc<25}">
        <c:out  value ="Corpulence normale" />
         </c:if>
        
        
       <c:if test="${imc>=25 && imc<30}">
        <c:out  value ="Surpoids" />
         </c:if>
        
       <c:if test="${imc>=30 && imc<35}">
        <c:out  value ="Obesite moderee Classe 1" />
         </c:if>
        
       <c:if test="${imc>=35 && imc<40}">
        <c:out  value ="Obesite eleve Classe 2" />
         </c:if>
        
        
       <c:if test="${imc>=40}">
        <c:out  value ="Obesite morbide ou massive" />
         </c:if>
        
         </c:if>
        
          <c:if test="${param.age<18 || param.age>65}">
        <c:out  value ="votre age doit  etre entre 18 et 65." />
         </c:if>
        

    </body>
</html>
