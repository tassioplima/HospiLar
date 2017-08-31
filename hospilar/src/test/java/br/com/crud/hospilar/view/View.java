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
	private JTextField txtSexo;
	private JTextField txtCPF;
	private JTextField txtEND;
	private JTextField txtEMAIL;
	private JTextField txtSintomas;

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
	private JTextField txtID;
	
	

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
		setBounds(100, 100, 700, 500);
		getContentPane = new JPanel();
		getContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(getContentPane);
		
		JPanel painelBotoes = new JPanel();
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String query= "insert into cadastropaciente (id,nome,idade,tsanguineo,sexo,cpf,endereco,email,sintomas) VALUES(?,?,?,?,?,?,?,?,?)";
					PreparedStatement stmt=con.prepareStatement(query);
					stmt.setString(1, txtID.getText());
					stmt.setString(2, txtNome.getText());
					stmt.setString(3, txtIdade.getText());
					stmt.setString(4, txtSangue.getText());
					stmt.setString(5, txtSexo.getText());	
					stmt.setString(6, txtCPF.getText());
					stmt.setString(7, txtEND.getText());
					stmt.setString(8, txtEMAIL.getText());
					stmt.setString(9, txtSintomas.getText());
					
					
					//stmt.executeUpdate();
					stmt.execute();
					
					JOptionPane.showMessageDialog(null,"Dados registrados!");
					
					stmt.close();	
				
					
				} catch (Exception ei) {
					ei.printStackTrace();
				}
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
					
					stmt.close();	
					rs.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		GroupLayout gl_painelBotoes = new GroupLayout(painelBotoes);
		gl_painelBotoes.setHorizontalGroup(
			gl_painelBotoes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelBotoes.createSequentialGroup()
					.addGap(49)
					.addComponent(btnRegistrar, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnConsultar, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(btnDeletar, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(btnCarregar, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(78, Short.MAX_VALUE))
		);
		gl_painelBotoes.setVerticalGroup(
			gl_painelBotoes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelBotoes.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_painelBotoes.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCarregar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDeletar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnConsultar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRegistrar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(78, Short.MAX_VALUE))
		);
		painelBotoes.setLayout(gl_painelBotoes);
		
		JPanel painelRegistros = new JPanel();
		
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
		
		txtSexo = new JTextField();
		txtSexo.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		
		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endereço");
		
		txtEND = new JTextField();
		txtEND.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail");
		
		txtEMAIL = new JTextField();
		txtEMAIL.setColumns(10);
		
		JLabel lblSintomas = new JLabel("Sintomas");
		
		txtSintomas = new JTextField();
		txtSintomas.setColumns(10);
		
		txtID = new JTextField();
		txtID.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		GroupLayout gl_painelRegistros = new GroupLayout(painelRegistros);
		gl_painelRegistros.setHorizontalGroup(
			gl_painelRegistros.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelRegistros.createSequentialGroup()
					.addGroup(gl_painelRegistros.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painelRegistros.createSequentialGroup()
							.addGap(17)
							.addGroup(gl_painelRegistros.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_painelRegistros.createSequentialGroup()
									.addComponent(lblNome)
									.addGap(4)
									.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(lblNewLabel)
									.addGap(18)
									.addComponent(txtIdade, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(lblNewLabel_1)
									.addGap(4)
									.addComponent(txtSangue, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_painelRegistros.createSequentialGroup()
									.addComponent(lblSexo)
									.addGap(4)
									.addComponent(txtSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(lblCpf)
									.addGap(4)
									.addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(lblEndereo)
									.addGap(4)
									.addComponent(txtEND, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(lblEmail)
									.addGap(10)
									.addComponent(txtEMAIL, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_painelRegistros.createSequentialGroup()
									.addComponent(lblSintomas)
									.addGap(4)
									.addComponent(txtSintomas, GroupLayout.PREFERRED_SIZE, 495, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_painelRegistros.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblId)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtID, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(115, Short.MAX_VALUE))
		);
		gl_painelRegistros.setVerticalGroup(
			gl_painelRegistros.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelRegistros.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_painelRegistros.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblId))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_painelRegistros.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painelRegistros.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNome))
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_painelRegistros.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel))
						.addComponent(txtIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_painelRegistros.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1))
						.addComponent(txtSangue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_painelRegistros.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painelRegistros.createSequentialGroup()
							.addGap(3)
							.addComponent(lblSexo))
						.addComponent(txtSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_painelRegistros.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCpf))
						.addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_painelRegistros.createSequentialGroup()
							.addGap(3)
							.addComponent(lblEndereo))
						.addComponent(txtEND, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_painelRegistros.createSequentialGroup()
							.addGap(3)
							.addComponent(lblEmail))
						.addComponent(txtEMAIL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_painelRegistros.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painelRegistros.createSequentialGroup()
							.addGap(3)
							.addComponent(lblSintomas))
						.addComponent(txtSintomas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		painelRegistros.setLayout(gl_painelRegistros);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
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
		GroupLayout gl_getContentPane = new GroupLayout(getContentPane);
		gl_getContentPane.setHorizontalGroup(
			gl_getContentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(painelRegistros, GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
				.addComponent(painelBotoes, GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
				.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
		);
		gl_getContentPane.setVerticalGroup(
			gl_getContentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_getContentPane.createSequentialGroup()
					.addGroup(gl_getContentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_getContentPane.createSequentialGroup()
							.addGap(89)
							.addComponent(painelRegistros, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
						.addGroup(gl_getContentPane.createSequentialGroup()
							.addComponent(painelBotoes, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
							.addGap(101)))
					.addGap(1)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
					.addGap(1))
		);
		getContentPane.setLayout(gl_getContentPane);
	}
}
