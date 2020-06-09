<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@page import="java.util.ArrayList" %>
   <%@page import="model.Noticia" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Noticia</h1>

	<% 
	
	ArrayList<Noticia> noticias = (ArrayList) session.getAttribute("noticias");
	
	 
	%>
	<c:forEach items="${ noticias}" var="noticia">
					<c:out value="${ noticia.id }"></c:out>
				</c:forEach>
	
				
</body>
</html>