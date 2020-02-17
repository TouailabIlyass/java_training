<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/ilyase" user="root" password=""
/>
</head>
<body>
    <h1 align="center">Gestion des Clients</h1>
    <h3>Insertion</h3>
    
    
	<form action="ex3.jsp" >
		Entrer le nom  : <input name="nom" /><br>
		Entrer le salaire  : <input name="salaire" /><br>
		<input type="submit" name="snd" value="Enregistrer" />
	</form>
	
	<c:if test="${param.nom != null && param.salaire != null && param.snd!= null}">
		
	<sql:transaction  dataSource="${db}">
		<sql:update>
                    insert into client values(0,?,?)
                    <sql:param value="${param.nom}"/>
                    <sql:param value="${param.salaire}"/>
                    
                    
                </sql:update>
	</sql:transaction>
	</c:if>
    <h3>Mise a jour</h3>
       <!--update -->
       <form action="ex3.jsp" >
		Entrer le nom  : <input name="nom" /><br>
		Entrer le salaire  : <input name="sal" /><br>
		<input type="submit" name="up" value="Update" />
	</form>
	
	<c:if test="${param.nom != null && param.up!= null}">
		
	<sql:transaction  dataSource="${db}">
		<sql:update>
                    update client set salaire=? where nom=?
                    <sql:param value="${param.sal}"/>
                    <sql:param value="${param.nom}"/>
                </sql:update>
	</sql:transaction>
	</c:if>
                    
                    
                    
                    
    <!-- dele  -->
    <h3>Suppression</h3>
	<form action="ex3.jsp" >
		Entrer le nom  : <input name="nom" /><br>
		<input type="submit" name="del" value="delete" />
	</form>
	
	<c:if test="${param.nom != null && param.del!= null}">
		
	<sql:transaction  dataSource="${db}">
		<sql:update>
                    delete from client where nom=?
                    <sql:param value="${param.nom}"/>
                </sql:update>
	</sql:transaction>
	</c:if>
    
    
    <h3>Affichage</h3>
	<!-- affichage -->
	<sql:query var="rs" dataSource="${db}">
	select * from client
	</sql:query>
        <table border="1">
            <tr><td><b>name</b></td><td><b>salaire</b></td></tr>
        <c:forEach var="columnName" items="${rs.rows}">
            <tr>
                <td><c:out value="${columnName.nom }"></c:out></td>
                <td><c:out value="${columnName.salaire }"></c:out></td>
            </tr>    
	 
	</c:forEach>
	</table>
        
        
</body> 
</html>
