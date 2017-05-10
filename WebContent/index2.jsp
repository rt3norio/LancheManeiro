<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if (session.getAttribute("senha") != null){
String senha = (String) session.getAttribute("senha");
if (senha.equals("incorreta")){     
	out.println("<script type=\"text/javascript\">");
	out.println("alert('SENHA OU LOGIN INCORRETO!!');");
	out.println("</script>");
}      
}
%>

<form method="post" action="/LancheManeiro/LoginServlet">
  Login:<br>
  <input type="text" name="login" id="login" value="Mickey">
  <br>
  Senha:<br>
  <input type="password" name="senha" id="senha" value="Mouse">
  <br><br>
  <input type="submit" value="Entrar">
</form> 

</body>
</html>