package br.com.crud.hospilar.view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.crud.hospilar.banco.ConexaoBanco;
import net.proteanit.sql.DbUtils;

public class View extends JFrame {

	private JPanel getContentPane;
	private JTextField txtNome;
	private JTextField txtIdade;
	private JTextField txtSangue;
	private JTable table;
	private JTextField textSexo;
	private JTextField textCPF;
	private JTextField textEnde;
	private JTextField textEmail;
	private JTextField textSintomas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	Connection con=null;
	
	

	/**
	 * Create the frame.
	 */
	public View() {
		
		try {
			con = ConexaoBanco.abrirConexao();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\tassi\\git\\HospiLar\\hospilar\\hospital.png"));
		setTitle("Hospilar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 406);
		getContentPane = new JPanel();
		getContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(getContentPane);
		getContentPane.setLayout(null);
		
		JPanel painelBotoes = new JPanel();
		painelBotoes.setBounds(0, 0, 596, 90);
		getContentPane.add(painelBotoes);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Nome: " + txtNome.getText());
				
			}
		});
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnAlterar = new JButton("Alterar");
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnCarregar = new JButton("Carregar");
		btnCarregar.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					String query="select * from cadastropaciente";
					PreparedStatement stmt=con.prepareStatement(query);
					ResultSet rs=stmt.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		GroupLayout gl_painelBotoes = new GroupLayout(painelBotoes);
		gl_painelBotoes.setHorizontalGroup(
			gl_painelBotoes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelBotoes.createSequentialGroup()
					.addGap(36)
					.addComponent(btnRegistrar, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnConsultar, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnDeletar, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCarregar, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(33, Short.MAX_VALUE))
		);
		gl_painelBotoes.setVerticalGroup(
			gl_painelBotoes.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_painelBotoes.createSequentialGroup()
					.addContainerGap(27, Short.MAX_VALUE)
					.addGroup(gl_painelBotoes.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_painelBotoes.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnRegistrar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnConsultar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_painelBotoes.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnDeletar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnCarregar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
					.addGap(25))
		);
		gl_painelBotoes.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnRegistrar, btnConsultar, btnAlterar, btnDeletar, btnCarregar});
		painelBotoes.setLayout(gl_painelBotoes);
		
		JPanel painelRegistros = new JPanel();
		painelRegistros.setBounds(0, 89, 596, 102);
		getContentPane.add(painelRegistros);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome Paciente");
		
		JLabel lblNewLabel = new JLabel("Idade");
		
		txtIdade = new JTextField();
		txtIdade.setColumns(10);
		
		txtSangue = new JTextField();
		txtSangue.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo Sanguineo");
		
		JLabel lblSexo = new JLabel("Sexo");
		
		textSexo = new JTextField();
		textSexo.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		
		textCPF = new JTextField();
		textCPF.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endereço");
		
		textEnde = new JTextField();
		textEnde.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail");
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		
		JLabel lblSintomas = new JLabel("Sintomas");
		
		textSintomas = new JTextField();
		textSintomas.setColumns(10);
		GroupLayout gl_painelRegistros = new GroupLayout(painelRegistros);
		gl_painelRegistros.setHorizontalGroup(
			gl_painelRegistros.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelRegistros.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_painelRegistros.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_painelRegistros.createSequentialGroup()
							.addComponent(lblSintomas)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textSintomas))
						.addGroup(gl_painelRegistros.createSequentialGroup()
							.addComponent(lblSexo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblCpf)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblEndereo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textEnde, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblEmail)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textEmail))
						.addGroup(gl_painelRegistros.createSequentialGroup()
							.addComponent(lblNome)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(txtIdade, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtSangue, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		gl_painelRegistros.setVerticalGroup(
			gl_painelRegistros.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_painelRegistros.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_painelRegistros.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(txtIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(txtSangue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_painelRegistros.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSexo)
						.addComponent(textSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCpf)
						.addComponent(textCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEndereo)
						.addComponent(textEnde, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail)
						.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_painelRegistros.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSintomas)
						.addComponent(textSintomas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9))
		);
		painelRegistros.setLayout(gl_painelRegistros);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 192, 596, 164);
		getContentPane.add(scrollPane_1);
		
		JScrollPane tabelaBanco = new JScrollPane();
		scrollPane_1.setViewportView(tabelaBanco);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Idade", "Tipo Sanguineo", "Sexo", "CPF", "Endere\u00E7o", "E-mail", "Sintomas"
			}
		));
		tabelaBanco.setViewportView(table);
	}
}
