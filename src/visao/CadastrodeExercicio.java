package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.ControleCadastrodeAvaliacao;
import controle.ControleCadastrodeExercicio;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CadastrodeExercicio extends JFrame {

	private JPanel contentPane;
	private JTextField nomeTextField;
	private JTextField repeticoesTextField;
	private JTextField seriesTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrodeExercicio frame = new CadastrodeExercicio();
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
	public CadastrodeExercicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblCadastroDeExerccio = new JLabel("Cadastro de Exerc\u00EDcio");
		lblCadastroDeExerccio.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblNome = new JLabel("Nome");
		
		nomeTextField = new JTextField();
		nomeTextField.setColumns(10);
		
		JLabel lblSries = new JLabel("S\u00E9ries");
		
		repeticoesTextField = new JTextField();
		repeticoesTextField.setColumns(10);
		
		JLabel lblRepeties = new JLabel("Repeti\u00E7\u00F5es");
		
		seriesTextField = new JTextField();
		seriesTextField.setColumns(10);
		
		JButton btnSlavar = new JButton("Salvar");
		
		JButton btnCancelar = new JButton("Cancelar");		
		
		btnSlavar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(ControleCadastrodeExercicio.cadastraExercicio(nomeTextField.getText(),
							Integer.parseInt(repeticoesTextField.getText()), 
							Integer.parseInt(seriesTextField.getText())))
						limpaTela();
			}

			private void limpaTela() {
				// TODO Auto-generated method stub
				nomeTextField.setText("");
				repeticoesTextField.setText("");
				seriesTextField.setText("");
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(184)
							.addComponent(lblNome))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(156)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(repeticoesTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(seriesTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(114)
							.addComponent(btnSlavar)
							.addGap(38)
							.addComponent(btnCancelar))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(86)
							.addComponent(nomeTextField, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(182)
							.addComponent(lblSries))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(175)
							.addComponent(lblRepeties))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(123)
							.addComponent(lblCadastroDeExerccio)))
					.addContainerGap(109, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCadastroDeExerccio)
					.addGap(18)
					.addComponent(lblNome)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(nomeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblSries)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(repeticoesTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblRepeties)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(seriesTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnSlavar))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

}
