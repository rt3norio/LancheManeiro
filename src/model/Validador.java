package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Validador {
	public static Boolean checarUsuario(String login, String senha){
		Boolean flagValidadora = false;
		try {
			ConexaoBanco.iniciaBd();
			Connection conexao = ConexaoBanco.getConexao();
			PreparedStatement pStatement = conexao.prepareStatement("select * from usuarios where login=? and senha=?");
			pStatement.setString(1, login);
			pStatement.setString(2, senha);
			ResultSet resSet = pStatement.executeQuery();
			flagValidadora = resSet.next();

			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flagValidadora;       


	}
}
