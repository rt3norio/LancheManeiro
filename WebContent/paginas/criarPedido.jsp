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
		<TABLE BORDER=0 CELLSPACING=0 CELLPADDING=0>



			<TR>
				<TD>
					<label for="nome">Nome:</label>
					<input type="text" id="nome" name="nome"/>
				</TD>
			</TR>



				
			<TR>    
				<TD>State</TD>
            	<TD><SELECT id="tipoDeCarne" NAME=tipoDeCarne>
<%  
					String[] tipoDeCarne = {"Costela", "Duas Carnes", "Uma Carne", "Sem Carne", "..."};
    				for(String carneAtual:tipoDeCarne) {    
%>
                    <OPTION><%=carneAtual%></OPTION>
<%					}%>
					</SELECT>
				</TD>
			</TR>




<%
	String[] acompanhamentos = {"Cebola","CebolaCaramelada","MolhoShoyu","BananaFrita","SemCriatividade"};
    	for(String acompAtual:acompanhamentos){
%>
			<TR>    
				<TD><INPUT TYPE="checkbox" name="acompanhamentos" value=<%=acompAtual%>><%=acompAtual%></TD>
			</TR>
<%  }   %>
			<TR>
				<TD>
					<label for="obs">Observação:</label>
					<input type="text" id="obs" name="obs"/>
				</TD>
			</TR>
			<TR>
				<TD>
					<label for="obs">Observação:</label>
					<input type="submit" title="enviar" class="botao" value="Enviar"/>
				</TD>
			</TR>
			

		</TABLE>
	</form>
</body>
</html>