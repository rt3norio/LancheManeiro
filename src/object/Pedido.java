package object;

import java.util.Date;

public class Pedido {

private Integer id;
private Date criacao;
private String cliente;
private String comida;
private String observacao;
private Boolean prioritario;


public Pedido(Integer id, Date criacao, String cliente, String comida, String observacao) {
	super();
	this.id = id;
	this.criacao = criacao;
	this.cliente = cliente;
	this.comida = comida;
	this.observacao = observacao;
	
	if (new Date().after((new Date(this.criacao.getTime()+(1000 * 60 * 15)))))
		this.prioritario = true;
	
	else
		this.prioritario = false;
	
	
	
//	if (this.criacao.after(dataAtualPlus15Minutos))
//		this.prioritario = true;
//	else
//		this.prioritario = false;
//	
//I M P L E M E N T A R ! ! !
//	if(criacao - tempo atual > 15min)
//		this.prioritario = true;
//	else
//		this.prioritario  =false;
}

public Pedido(String cliente, String comida, String observacao) {
	super();
	this.cliente = cliente;
	this.comida = comida;
	this.observacao = observacao;
}


public Pedido() {
	// TODO Auto-generated constructor stub
}


public String toHTML() {
	return "<a href=\"FinalizarPedidoServlet?pedido="+id+"\"><p>Pedido [criacao=" + criacao + ", cliente=" + cliente + ", comida=" + comida + ", observacao=" + observacao
			+ ", prioritario=" + prioritario + "]</p>";
}

@SuppressWarnings("deprecation")
public String toTable() {
return "<tr>"+
"	<td align=\"center\">"+this.id+"</td>"+
"	<td>"+this.criacao.getHours()+":"+this.criacao.getMinutes()+"</td>"+
"	<td>"+this.cliente+"</td>"+
"	<td>"+this.comida+"</td>"+
"	<td>"+this.observacao+"</td>"+
"	<td>"+this.prioritario+"</td>"+
"</tr>";
}

@Override
public String toString() {
	return "Pedido - Criacao= " + criacao + ", Cliente= " + cliente + ", comida=" + comida + ", observacao=" + observacao
			+ ", prioritario=" + prioritario + "]";
}

public String getCliente() {
	return cliente;
}
public void setCliente(String cliente) {
	this.cliente = cliente;
}
public String getComida() {
	return comida;
}
public void setComida(String comida) {
	this.comida = comida;
}
public String getObservacao() {
	return observacao;
}
public void setObservacao(String observacao) {
	this.observacao = observacao;
}


public Date getCriacao() {
	return criacao;
}


public void setCriacao(Date criacao) {
	this.criacao = criacao;
}


public Integer getId() {
	return id;
}


public void setId(Integer id) {
	this.id = id;
}


public Boolean getPrioritario() {
	return prioritario;
}


public void setPrioritario(Boolean prioritario) {
	this.prioritario = prioritario;
}



}
