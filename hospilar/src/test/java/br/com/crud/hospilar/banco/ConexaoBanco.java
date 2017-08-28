package br.com.crud.hospilar.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;



public class  ConexaoBanco {
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql:localhost:3306/cadastropaciente";
	private static final String USER = "root";
	private static final String PASS = "root";
	 
	 public static Connection abrirConexao() throws SQLException{
		
		 try {
			Class.forName(DRIVER);
			
			return DriverManager.getConnection(URL, USER, PASS);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("Erro na conexao: ", e);
		} 
		
		
	 }
	 
	 public static void fecharConexao(Connection con){
		 
		 if (con!=null){
			 try {
				 con.close();
			 } catch (SQLException e) {
				 
			 }
			 
		 }
	 }
	 
public static void fecharConexao(Connection con, PreparedStatement stmt){
	
		fecharConexao(con);
	
		 try {
			 
			 if(stmt!=null);
			 
			 stmt.close();
		 
		 }catch (SQLException e) {
				 
			 }
			 
		 }

public static void fecharConexao(Connection con, PreparedStatement stmt, ResultSet rs){
	
	fecharConexao(con, stmt);

	 try {
		 
		 if(rs!=null);
		 
		 rs.close();
	 
	 }catch (SQLException e) {
			 
		 }
		 
	 }
	 } 
	 
	

