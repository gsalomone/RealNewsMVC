<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Cadastrar Noticia</h1>
		
	<form action="ManterNoticiaController.do" method="post">
		Id: <input type="text" name="id_noticia"><br> 
		Descricao:<input type="text" name="descricao_noticia"><br> 
		Titulo:<input type="text" name="titulo_noticia"><br> 
		Texto:<textarea name= "texto_noticia" ></textarea><br>
		<input type="hidden" name="acao" value="cadastroNoticia">
		<input type = "submit" Value = "Cadastrar Noticia">	
	</form>

</body>
</html>