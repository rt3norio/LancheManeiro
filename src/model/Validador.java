package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Validador {
	public static Boolean checarUsuario(String login, String senha){
		Boolean flagValidadora = false;
		try {
			ConexaoBanco cb = new ConexaoBanco();
			cb.iniciaBd();
			Connection conexao = cb.getConexao();
			PreparedStatement pStatement = conexao.prepareStatement("select * from usuarios where login=? and senha=?");
			pStatement.setString(1, login);
			pStatement.setString(2, senha);
			ResultSet resSet = pStatement.executeQuery();
			flagValidadora = resSet.next();
			conexao.close();
			cb.fechaBd();
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flagValidadora;       


	}
}
