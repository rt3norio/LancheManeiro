package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBanco {

	//objeto de conexão
	private Connection con;

	public void iniciaBd()
	{	try
	{	
		//jdbc:mysql//PortaDeConexão/NomeDoEsquema
		String database = "jdbc:mysql://ntj.mooo.com/lanchemaneiro";
		//nome do usuário para acessar o banco
		String usuario = "lanche";
		//senha para acessar o banco
		String senha = "maneiro";		
		//chama a conexão para que o jar seja utilizado
		Class.forName("com.mysql.jdbc.Driver"); 
		//criando a conexão/instanciando o objeto conexão, passando como parametros o database, usuario e senha
		con = (Connection) DriverManager.getConnection( database, usuario, senha );
		System.out.println(con.toString());

	}
	catch ( Exception e ) {
		e.printStackTrace();
	}// o bloco deve conter os comandos try e catch pois pode gerar alguma exceção		
	}

	//fecha a conexão
	public void fechaBd(){	
		try{
			con.close();
		}
		catch ( Exception e ) {
			e.printStackTrace();
		}
	}	

	//retorna a conexão	
	public Connection getConexao()
	{	
		return con;		
	}
}
