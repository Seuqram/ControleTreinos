package visao;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import controle.ControlePrincipal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal {

	private static JFrame frame;
	private static JButton cadastrarAlunoButton = new JButton("Cadastrar Aluno");
	private static JButton montarTreinoButton = new JButton("Montar Treino");
	private static JButton cadastrarAvaliacaoButton = new JButton("Cadastrar Avalia\u00E7\u00E3o");
	private static JButton visualizarTreinoButton = new JButton("Visualizar Treino");
	private static JButton cadastrarExercicioButton = new JButton("Cadastrar Exerc\u00EDcio");
	private static JButton visualizarAvalicaoButton = new JButton("Visualizar Avalia\u00E7\u00E3o");
	static Principal telaPrincipal = new Principal();

	public static void main(String[] args) {
		Login telaDeLogin = new Login() ;
		Principal.setVisibilidade(false);
	}
	
	public Principal() {
		initialize();
	}

	public static void setVisibilidade(boolean visivel)
	{
		frame.setVisible(visivel);
	}

	public static void setInterface()
	{
		int nivelDeAcesso = ControlePrincipal.getNivelDeAcesso();
		switch(nivelDeAcesso)
		{
		case 1:
			cadastrarAlunoButton.setEnabled(true);
			montarTreinoButton.setEnabled(false);
			cadastrarAvaliacaoButton.setEnabled(false);
			visualizarTreinoButton.setEnabled(false);
			cadastrarExercicioButton.setEnabled(false);
			visualizarAvalicaoButton.setEnabled(false);
			break;
		case 2:
			cadastrarAlunoButton.setEnabled(false);
			montarTreinoButton.setEnabled(false);
			cadastrarAvaliacaoButton.setEnabled(true);
			visualizarTreinoButton.setEnabled(false);
			cadastrarExercicioButton.setEnabled(false);
			visualizarAvalicaoButton.setEnabled(true);
			break;
		case 3:
			cadastrarAlunoButton.setEnabled(false);
			montarTreinoButton.setEnabled(true);
			cadastrarAvaliacaoButton.setEnabled(false);
			visualizarTreinoButton.setEnabled(true);
			cadastrarExercicioButton.setEnabled(true);
			visualizarAvalicaoButton.setEnabled(true);
			break;
		case 4:
			cadastrarAlunoButton.setEnabled(false);
			montarTreinoButton.setEnabled(false);
			cadastrarAvaliacaoButton.setEnabled(false);
			visualizarTreinoButton.setEnabled(true);
			cadastrarExercicioButton.setEnabled(false);
			visualizarAvalicaoButton.setEnabled(true);
			break;
		default:
			cadastrarAlunoButton.setEnabled(false);
			montarTreinoButton.setEnabled(false);
			cadastrarAvaliacaoButton.setEnabled(false);
			visualizarTreinoButton.setEnabled(false);
			cadastrarExercicioButton.setEnabled(false);
			visualizarAvalicaoButton.setEnabled(false);
			break;
		}

	}

	private static void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("Controle de Treinos");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		cadastrarAlunoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastrodeAluno a = new CadastrodeAluno();
				setVisibilidade(false);
				a.setVisible(true);
				a.pack();
			}
		});
		
		cadastrarAvaliacaoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastrodeAvaliacao a = new CadastrodeAvaliacao();
				setVisibilidade(false);
				a.setVisible(true);
				a.pack();
			}
		});

		JButton sairButton = new JButton("Sair");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(185)
						.addComponent(sairButton)
						.addContainerGap(211, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(cadastrarAlunoButton, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
								.addComponent(cadastrarAvaliacaoButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
								.addComponent(cadastrarExercicioButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
						.addGap(44)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(montarTreinoButton, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
								.addComponent(visualizarTreinoButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(visualizarAvalicaoButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(17))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(44)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(cadastrarAlunoButton)
								.addComponent(montarTreinoButton))
						.addGap(37)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(visualizarTreinoButton)
								.addComponent(cadastrarAvaliacaoButton))
						.addGap(35)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(visualizarAvalicaoButton)
								.addComponent(cadastrarExercicioButton))
						.addGap(33)
						.addComponent(sairButton)
						.addContainerGap())
				);
		frame.getContentPane().setLayout(groupLayout);
	}
}