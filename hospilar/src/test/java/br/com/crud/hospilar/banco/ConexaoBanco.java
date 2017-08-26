package br.com.crud.hospilar.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
	
	Connection conexao = null;
	
	public static void main(String[] args) throws SQLException{
		try{
		Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/cadastropaciente", "root", "root");
		System.out.println("Conectado com o Bando de Dados");
		conexao.close();
		} 	catch(SQLException e)  {
			
			
		}

	}

}