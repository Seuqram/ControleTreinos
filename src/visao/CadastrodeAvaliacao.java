package visao;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.ControleCadastrodeAvaliacao;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("serial")
public class CadastrodeAvaliacao extends JFrame {

	private JPanel contentPane;
	private JTextField bracoDireitoTextField;
	private JTextField bracoEsquerdoTextField;
	private JTextField coxaDireitaTextField;
	private JTextField coxaEsquerdaTextField;
	private JTextField peitoTextField;
	private JTextField percentualDeGorduraTextField;
	private JLabel idadeTextField;
	private JTextField pesoTextField;
	private JTextField alturaTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrodeAvaliacao frame = new CadastrodeAvaliacao();
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
	public CadastrodeAvaliacao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel cadastroDeAvaliacaoLabel = new JLabel("Cadastro de Avalia\u00E7\u00E3o F\u00EDsica");
		cadastroDeAvaliacaoLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		JLabel idadeLabel = new JLabel("Idade");
		idadeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		JLabel pesoLabel = new JLabel("Peso");
		pesoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		JLabel alturaLabel = new JLabel("Altura");
		JLabel alunoLabel = new JLabel("Aluno");
		JLabel avaliadorLabel = new JLabel("Avaliador");
		JLabel bracoDireitoLabel = new JLabel("Bra\u00E7o Direito");
		JLabel bracoEsquerdoLabel = new JLabel("Bra\u00E7o Esquerdo");
		JLabel coxaDireitaLabel = new JLabel("Coxa Direita");
		JLabel coxaEsquerdaLabel = new JLabel("Coxa Esquerda");
		JLabel peitoLabel = new JLabel("Peito");
		peitoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		JLabel gorduraLabel = new JLabel("% Gordura");
		gorduraLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		idadeTextField = new JLabel();		
		
		String[] objetivos = new String[3];
		objetivos[0] = "Hipertrofia";
		objetivos[1] = "Emagrecimento";
		objetivos[2] = "Fortalecimento de Articulações";
		
		String[] professores = new String[3];
		professores[0] = "Arnold";
		professores[1] = "Zane";
		professores[2] = "Serge";
		
		JLabel objetivoLabel = new JLabel("Objetivo");
		JComboBox alunosComboBox = new JComboBox(ControleCadastrodeAvaliacao.getAlunos());
		JComboBox avaliadorComboBox = new JComboBox(professores);
		JComboBox objetivoComboBox = new JComboBox(objetivos);
		
		idadeTextField.setText(ControleCadastrodeAvaliacao.getIdadeAluno(alunosComboBox.getSelectedItem().toString()));
		
		JSeparator separator = new JSeparator();
		
		bracoDireitoTextField = new JTextField();
		bracoDireitoTextField.setColumns(10);
		bracoEsquerdoTextField = new JTextField();
		bracoEsquerdoTextField.setColumns(10);
		coxaDireitaTextField = new JTextField();
		coxaDireitaTextField.setColumns(10);
		coxaEsquerdaTextField = new JTextField();
		coxaEsquerdaTextField.setColumns(10);
		peitoTextField = new JTextField();
		peitoTextField.setColumns(10);
		percentualDeGorduraTextField = new JTextField();
		percentualDeGorduraTextField.setColumns(10);
		pesoTextField = new JTextField();
		pesoTextField.setColumns(10);
		alturaTextField = new JTextField();
		alturaTextField.setColumns(10);
		
		JButton salvarButton = new JButton("Salvar");
		JButton cancelarButton = new JButton("Cancelar");
		
		alunosComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				idadeTextField.setText(ControleCadastrodeAvaliacao.getIdadeAluno(alunosComboBox.getSelectedItem().toString()));
			}
		});
		
		salvarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DateTimeFormatter dataDeHoje = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDateTime now = LocalDateTime.now();
				JOptionPane.showMessageDialog(null, dataDeHoje.format(now));
				ControleCadastrodeAvaliacao.cadastraAvaliacao(Float.parseFloat(bracoDireitoTextField.getText()),
							Float.parseFloat(bracoEsquerdoTextField.getText()), 
							Float.parseFloat(coxaDireitaTextField.getText()),
							Float.parseFloat(coxaEsquerdaTextField.getText()),
							Float.parseFloat(peitoTextField.getText()),
							Float.parseFloat(percentualDeGorduraTextField.getText()),
							objetivoComboBox.getSelectedItem().toString(),
							alunosComboBox.getSelectedItem().toString(),
							dataDeHoje.format(now),
							Integer.parseInt(idadeTextField.getText()),
							Float.parseFloat(pesoTextField.getText()),
							Float.parseFloat(alturaTextField.getText())
							);
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(avaliadorLabel)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(avaliadorComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(alunoLabel)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(alunosComboBox, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(pesoLabel)
												.addComponent(idadeLabel)
												.addComponent(alturaLabel))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(alturaTextField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
												.addComponent(pesoTextField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
												.addComponent(idadeTextField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))))
									.addGap(75)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(separator, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
										.addComponent(bracoDireitoLabel)
										.addComponent(coxaDireitaLabel, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
										.addComponent(bracoEsquerdoLabel)
										.addComponent(coxaEsquerdaLabel)
										.addComponent(peitoLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
											.addComponent(objetivoLabel)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(objetivoComboBox, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(salvarButton)
											.addGap(45)))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(gorduraLabel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(cancelarButton)))
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(peitoTextField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(coxaEsquerdaTextField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(coxaDireitaTextField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(bracoEsquerdoTextField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(bracoDireitoTextField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(percentualDeGorduraTextField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(111)
							.addComponent(cadastroDeAvaliacaoLabel)))
					.addContainerGap(79, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(cadastroDeAvaliacaoLabel)
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(alunoLabel)
							.addComponent(alunosComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(bracoDireitoTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(bracoDireitoLabel))
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(idadeLabel)
								.addComponent(idadeTextField))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(pesoLabel)
								.addComponent(pesoTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(alturaLabel)
								.addComponent(alturaTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(21)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(avaliadorLabel)
								.addComponent(avaliadorComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(objetivoLabel)
								.addComponent(objetivoComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(bracoEsquerdoLabel)
								.addComponent(bracoEsquerdoTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(coxaDireitaLabel)
								.addComponent(coxaDireitaTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(coxaEsquerdaLabel)
								.addComponent(coxaEsquerdaTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(peitoLabel)
								.addComponent(peitoTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(gorduraLabel)
								.addComponent(percentualDeGorduraTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(cancelarButton)
						.addComponent(salvarButton))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		
	}
}
