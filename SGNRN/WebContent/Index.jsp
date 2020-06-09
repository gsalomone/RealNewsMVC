<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body><h1>Cadastrar</h1>
	<form action="ManterNoticiaController.do" method="post">
		<input type="hidden" name="acao" value="cadastrarNoticia">
		<input type= "submit" value = "Cadastrar"/><br>
	</form>
	
	<form action="ManterNoticiaController.do" method="post">
		<input type="hidden" name="acao" value="visualizarNoticia">
		<input type= "submit" value= "Visualizar"/>
	</form>

</body>
</html>