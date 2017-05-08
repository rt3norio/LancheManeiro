<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="pedido" action="../PedidoServlet" method="post">
		<fieldset>
			<legend>Pedido</legend>
			<a title="form para lanchonete"></a>
			
			<label for="nome">Nome do Cliente:</label>
			<input type="text" id="nome" name="nome"/></br>
			
			<label for="comida">Comida:</label>
			<input type="radio" id="comida" name="comida" value="Sanduiche"/>
			
			<label for="sand">Sanduiche</label>
			<input type="radio" id="comida" name="comida" value="Pizza"/>
			
			<label for="pizza">Pizza</label>
			<input type="radio" id="comida" name="comida" value="Refeicao"/>
			
			<label for="coxinha">Refeição</label></br>
			
			<label for="nome">Observação:</label>
			<input type="text" id="obs" name="obs"/></br>
			
			<input type="submit" title="entrar" class="botao" value="Enviar"/>	 
				 
		</fieldset>	
	</form>
</body>
</html>