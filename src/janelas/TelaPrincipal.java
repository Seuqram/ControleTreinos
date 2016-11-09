package janelas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import javax.swing.JToolBar;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class TelaPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("Controle de Treinos");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Cadastrar Aluno");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastrodeAluno a = new CadastrodeAluno();
				a.setVisible(true);
				a.pack();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Montar Treino");
		
		JButton btnNewButton_2 = new JButton("Cadastrar Avalia\u00E7\u00E3o");
		
		JButton btnVisualizarTreino = new JButton("Visualizar Treino");
		
		JButton btnCadastrarExerccio = new JButton("Cadastrar Exerc\u00EDcio");
		
		JButton btnVisualizarAvaliao = new JButton("Visualizar Avalia\u00E7\u00E3o");
		
		JButton btnSair = new JButton("Sair");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(185)
					.addComponent(btnSair)
					.addContainerGap(211, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
						.addComponent(btnNewButton_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
						.addComponent(btnCadastrarExerccio, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
						.addComponent(btnVisualizarTreino, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnVisualizarAvaliao, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(17))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnVisualizarTreino)
						.addComponent(btnNewButton_2))
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnVisualizarAvaliao)
						.addComponent(btnCadastrarExerccio))
					.addGap(33)
					.addComponent(btnSair)
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
