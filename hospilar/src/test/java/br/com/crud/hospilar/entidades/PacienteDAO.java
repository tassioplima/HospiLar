package br.com.crud.hospilar.entidades;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import br.com.crud.hospilar.banco.ConexaoBanco;

public class PacienteDAO {
	
Connection con=null;
	
	
	public void salvar(Paciente p) throws SQLException, ClassNotFoundException {

		Connection con = ConexaoBanco.abrirConexao();
		java.sql.PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(
					"INSERT INTO cadastropaciente (nome, idade, tsanguineo, sexo, cpf, endereco, email, sintomas) VALUES(?,?,?,?,?,?,?,?,?) ");
			
			stmt.setString(1, p.getNome() );
			stmt.setInt(2, p.getIdade());
			stmt.setString(1, p.getTsanguineo());
			stmt.setString(1, p.getSexo());
			stmt.setInt(1, p.getCpf() );
			stmt.setString(1, p.getEndereco() );
			stmt.setString(1, p.getEmail() );
			stmt.setString(1, p.getSintomas());
			
			stmt.executeUpdate();
			
		
			
		} catch (SQLException e) {

			e.printStackTrace();
		}finally{
			
			ConexaoBanco.fecharConexao(con);
		}

	}

}
