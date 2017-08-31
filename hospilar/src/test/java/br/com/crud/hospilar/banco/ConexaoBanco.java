package br.com.crud.hospilar.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;



public class  ConexaoBanco {
	
	
	
	Connection con=null;
	 
	 public static Connection abrirConexao() throws ClassNotFoundException {
		
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cadastropaciente","root","root");
			
			return con;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			return  null;
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
	 
	

