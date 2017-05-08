package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.sql.ResultSet;

import object.Pedido;

public class PedidosBanco {
	
	
	
	
	public static Boolean adicionarPedido(Pedido p){

		
		try{
			ConexaoBanco.iniciaBd();
			Connection conexao = ConexaoBanco.getConexao();
			String query = " insert into pedidos (cliente, comida, observacao)"
							+ " values (?, ?, ?)";
			PreparedStatement pStatement = conexao.prepareStatement(query);
			pStatement.setString(1, p.getCliente());
			pStatement.setString(2, p.getComida());
			pStatement.setString(3, p.getObservacao());
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
		
	}

	public static ArrayList<Pedido> listarPedidos() {
		ArrayList<Pedido> pedidos = new ArrayList<>();
		try{
			ConexaoBanco.iniciaBd();
			Connection conexao = ConexaoBanco.getConexao();
			String query = "select * from pedidos where atendido is null";
			PreparedStatement pStatement = conexao.prepareStatement(query);
			ResultSet rSet = pStatement.executeQuery();
			while(rSet.next()){
				//Pedido p = new Pedido();
				Pedido p = new Pedido(rSet.getInt("id"),rSet.getTimestamp("data_criacao"),rSet.getString("cliente"),rSet.getString("comida"),rSet.getString("observacao"));
//				p.setId(rSet.getInt("id"));
//				p.setCliente(rSet.getString("cliente"));
//				p.setComida(rSet.getString("comida"));
//				p.setObservacao(rSet.getString("observacao"));
//				p.setCriacao(rSet.getDate("data_criacao"));

				pedidos.add(p);
				p = null;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return pedidos;
	}
}

