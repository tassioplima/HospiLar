package br.com.crud.hospilar.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;

public class View extends JFrame {

	private JPanel getContentPane;
	private JTextField txtNome;
	private JTextField txtIdade;
	private JTextField txtSangue;
	private JTextField textField;

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

	/**
	 * Create the frame.
	 */
	public View() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\tassi\\git\\HospiLar\\hospilar\\hospital.png"));
		setTitle("Hospilar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 360);
		getContentPane = new JPanel();
		getContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(getContentPane);
		getContentPane.setLayout(null);
		
		JPanel painelBotoes = new JPanel();
		painelBotoes.setBounds(0, 0, 551, 90);
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
		GroupLayout gl_painelBotoes = new GroupLayout(painelBotoes);
		gl_painelBotoes.setHorizontalGroup(
			gl_painelBotoes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelBotoes.createSequentialGroup()
					.addGap(38)
					.addComponent(btnRegistrar, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(btnConsultar, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(btnDeletar, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(38, Short.MAX_VALUE))
		);
		gl_painelBotoes.setVerticalGroup(
			gl_painelBotoes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelBotoes.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_painelBotoes.createParallelGroup(Alignment.LEADING)
						.addComponent(btnRegistrar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnConsultar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDeletar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		gl_painelBotoes.linkSize(SwingConstants.VERTICAL, new Component[] {btnRegistrar, btnConsultar, btnAlterar, btnDeletar});
		gl_painelBotoes.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnRegistrar, btnConsultar, btnAlterar, btnDeletar});
		painelBotoes.setLayout(gl_painelBotoes);
		
		JPanel painelRegistros = new JPanel();
		painelRegistros.setBounds(0, 89, 551, 102);
		getContentPane.add(painelRegistros);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome Paciente");
		
		JLabel lblNewLabel = new JLabel("Idade");
		
		txtIdade = new JTextField();
		txtIdade.setColumns(10);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		
		JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
		
		txtSangue = new JTextField();
		txtSangue.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo Sanguineo");
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout gl_painelRegistros = new GroupLayout(painelRegistros);
		gl_painelRegistros.setHorizontalGroup(
			gl_painelRegistros.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelRegistros.createSequentialGroup()
					.addGap(3)
					.addGroup(gl_painelRegistros.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNome)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_painelRegistros.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_painelRegistros.createSequentialGroup()
							.addGap(10)
							.addComponent(textField))
						.addGroup(gl_painelRegistros.createSequentialGroup()
							.addComponent(txtIdade, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1)
							.addGap(18)
							.addComponent(txtSangue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(rdbtnMasculino)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnFeminino)
					.addContainerGap(28, Short.MAX_VALUE))
		);
		gl_painelRegistros.setVerticalGroup(
			gl_painelRegistros.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelRegistros.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_painelRegistros.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnMasculino)
						.addComponent(rdbtnFeminino))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_painelRegistros.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSangue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		painelRegistros.setLayout(gl_painelRegistros);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 192, 551, 118);
		getContentPane.add(scrollPane);
	}
}
