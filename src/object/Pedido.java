package object;

import java.sql.Date;

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
//I M P L E M E N T A R ! ! !
//	if(criacao - tempo atual > 10min)
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
