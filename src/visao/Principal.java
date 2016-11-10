package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import javax.swing.JToolBar;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Principal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Login telaDeLogin = new Login() ;
		/*telaDeLogin.setTitle("Login");
		telaDeLogin.pack();
		telaDeLogin.setVisible(true);*/
		Principal telaPrincipal = new Principal();
		telaPrincipal.mudaVisibilidade(true);
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		do
		{
			if (!telaDeLogin.isVisible())
				telaPrincipal.frame.setVisible(true);
				//telaPrincipal.mudaVisibilidade(true);
		}while(!telaPrincipal.frame.isVisible());*/
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}
	
	public void mudaVisibilidade(boolean visivel)
	{
		frame.setVisible(visivel);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("Controle de Treinos");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton cadastrarAlunoButton = new JButton("Cadastrar Aluno");
		cadastrarAlunoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastrodeAluno a = new CadastrodeAluno();
				mudaVisibilidade(false);
				a.setVisible(true);
				a.pack();
			}
		});
		
		JButton montarTreinoButton = new JButton("Montar Treino");
		
		JButton cadastrarAvaliacaoButton = new JButton("Cadastrar Avalia\u00E7\u00E3o");
		
		JButton VisualizarTreinoButton = new JButton("Visualizar Treino");
		
		JButton CadastrarExerccioButton = new JButton("Cadastrar Exerc\u00EDcio");
		
		JButton VisualizarAvalicaoButton = new JButton("Visualizar Avalia\u00E7\u00E3o");
		
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
						.addComponent(CadastrarExerccioButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(montarTreinoButton, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
						.addComponent(VisualizarTreinoButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(VisualizarAvalicaoButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
						.addComponent(VisualizarTreinoButton)
						.addComponent(cadastrarAvaliacaoButton))
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(VisualizarAvalicaoButton)
						.addComponent(CadastrarExerccioButton))
					.addGap(33)
					.addComponent(sairButton)
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}