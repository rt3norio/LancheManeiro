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
// TODO criar estruturas de buscas dos dados disponiveis para o formulario

%>
	<form id="pedido" action="PedidoServlet" method="post">
		<TABLE BORDER=0 CELLSPACING=0 CELLPADDING=0>



			<TR>
				<TD>
					<label for="nome">Nome/Mesa:</label>
				</TD>
				<TD>
					<input type="text" id="nome" name="nome"/>
				</TD>
			</TR>
				
			<TR>    
				<TD>Tipo de Carne:</TD>
            	<TD><SELECT id="tipoDeCarne" NAME=tipoDeCarne>
<%  
					String[] tipoDeCarne = {"CarneMacica", "CarneRecheada", "2xCostelaMacica", "CordeiroComHortelã", "CordeiroSemHortelã"};
    				for(String carneAtual:tipoDeCarne) {    
%>
                    <OPTION><%=carneAtual%></OPTION>
<%					}%>
					</SELECT>
				</TD>
			</TR>

			<TR>    
				<TD>Tipo de Pão:</TD>
            	<TD><SELECT id="tipoDePao" NAME=tipoDePao>
<%  
					String[] tipoDePao = {"PãoIntegral", "PãoCareca", "PãoComGergelim", "Brioche"};
    				for(String paoAtual:tipoDePao) {    
%>
                    <OPTION><%=paoAtual%></OPTION>
<%					}%>
					</SELECT>
				</TD>
			</TR>

			<TR>    
				<TD>Recheio 1:</TD>
            	<TD><SELECT id="recheio1" NAME=recheio1>
<%  
					String[] recheio = {"Calabresa", "Bacon", "Peru", "Presunto","Parmesao","Catupiry","Provolone","Cheddar","Mussarela"};
    				for(String rechAtual:recheio) {    
%>
                    <OPTION><%=rechAtual%></OPTION>
<%					}%>
					</SELECT>
				</TD>
			</TR>
			<TR>    
				<TD>Recheio 2:</TD>
            	<TD><SELECT id="recheio2" NAME=recheio2>
<%
    				for(String rechAtual:recheio) {    
%>
                    <OPTION><%=rechAtual%></OPTION>
<%					}%>
					</SELECT>
				</TD>
			</TR>
			<TR>    
				<TD>Recheio 3:</TD>
            	<TD><SELECT id="recheio3" NAME=recheio3>
<%  
    				for(String rechAtual:recheio) {    
%>
                    <OPTION><%=rechAtual%></OPTION>
<%					}%>
					</SELECT>
				</TD>
			</TR>


			<TR>
			<TD>
			Complementos:
			</TD>
			</TR>
			
<%
	String[] complementos = {"Alface","Tomate","CebolaCrua","CebolaRefogada","CebolaRoxaCrua","CebolaRoxaRefogada","Cheddar","Bacon"};
    	for(String compAtual:complementos){
%>
			<TR>
				<td>
				</td> 
				<TD><INPUT TYPE="checkbox" name="complementos" value=<%=compAtual%>><%=compAtual%></TD>
			</TR>
<%  }   %>
			<TR>
				<TD>
					<label for="obs">Observação:</label>
				</TD>
				<TD>
					<input type="text" id="obs" name="obs"/>
				</TD>
			</TR>
			<TR>
				<TD>
					<label for="obs">Fazer Pedido!</label>
				</TD>
				<TD>
					<input type="submit" title="enviar" class="botao" value="Enviar"/>
				</TD>
			</TR>
			

		</TABLE>
	</form>
	<h2><a href="index2.jsp">Area Administrativa</a></h2>
</body>
</html>
	