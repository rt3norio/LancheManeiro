<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pagina Inicial</title>
</head>
<body>
<h1>Escolha a ação desejada!</h1>
<ul>
<li><a href="realizaVendas.jsp">Realizar Vendas</a></li>
<li><a href="listaVendas.jsp">Listar Vendas</a></li>
<li><form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Sair" />
</form>
</li>
</ul>
</body>
</html>