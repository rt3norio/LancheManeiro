package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import object.Pedido;

public class PedidosBanco {
	
	
	public static Boolean finalizarPedido(Integer codigo){
		try{
			ConexaoBanco cb = new ConexaoBanco();
			cb.iniciaBd();
			Connection conexao = cb.getConexao();
			String query = "update pedidos set atendido = now() where id = ?";
			
			PreparedStatement pStatement = conexao.prepareStatement(query);
			pStatement.setInt(1, codigo);
			pStatement.executeUpdate();
			System.out.println(pStatement.toString());
			conexao.close();
			cb.fechaBd();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	
	}
	
 	public static Boolean adicionarPedido(Pedido p){

		
		try{
			//ConexaoBanco.iniciaBd();
			ConexaoBanco cb = new ConexaoBanco();
			cb.iniciaBd();
			Connection conexao = cb.getConexao();
			String query = " insert into pedidos (cliente, comida, observacao)"
							+ " values (?, ?, ?)";
			PreparedStatement pStatement = conexao.prepareStatement(query);
			pStatement.setString(1, p.getCliente());
			pStatement.setString(2, p.getComida());
			pStatement.setString(3, p.getObservacao());
			pStatement.execute();
			System.out.println(pStatement.toString());
			conexao.close();
			cb.fechaBd();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
		
	}

	public static ArrayList<Pedido> listarPedidos() {
		ArrayList<Pedido> pedidos = new ArrayList<>();
		ConexaoBanco cb = new ConexaoBanco();
		cb.iniciaBd();
		Connection conexao = cb.getConexao();
		try{
			//ConexaoBanco.iniciaBd();
			
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
			conexao.close();
			cb.fechaBd();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
		
		}
		
		return pedidos;
	}
	
	

	public static ArrayList<Pedido> historicoPedidos() {
		ArrayList<Pedido> pedidos = new ArrayList<>();
		ConexaoBanco cb = new ConexaoBanco();
		cb.iniciaBd();
		Connection conexao = cb.getConexao();
		try{
			//ConexaoBanco.iniciaBd();
			
			String query = "select * from pedidos where atendido is not null";
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
			conexao.close();
			cb.fechaBd();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
		
		}
		
		return pedidos;
	}
}

