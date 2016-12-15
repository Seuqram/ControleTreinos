package visao;

import javax.swing.JPanel;

import controle.ControlePrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class PanelPrincipal extends PanelGenerico {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//ControlePrincipal controlePrincipal = new ControlePrincipal();
	JButton cadastrarAlunoButton = new JButton("CADASTRAR ALUNO");
	JButton montarTreinoButton = new JButton("MONTAR TREINO");
	JButton cadastrarAvaliacaoButton = new JButton("CADASTRAR AVALIA\u00C7\u00C3O");
	JButton visualizarTreinoButton = new JButton("VISUALIZAR TREINO");
	JButton cadastrarExercicioButton = new JButton("CADASTRAR EXERC\u00CDCIO");
	JButton visualizarAvaliacaoButton = new JButton("VISUALIZAR AVALIA\u00C7\u00C3O");
	
	public PanelPrincipal(int width, int height, double porcentagemWidth, double porcentagemHeight) {
		super(width, height, porcentagemWidth, porcentagemHeight);
		setTituloLabel("Tela Principal");
		
		ArrayList<JButton> botoes = new ArrayList<>();
		botoes.add(cadastrarAlunoButton);
		botoes.add(montarTreinoButton);
		botoes.add(cadastrarAvaliacaoButton);
		botoes.add(visualizarAvaliacaoButton);
		botoes.add(cadastrarExercicioButton);
		botoes.add(visualizarTreinoButton);
		double botaoHeight = (0.8/(botoes.size()));
		for (int index = 0; index < botoes.size(); index++){
			JButton botao = botoes.get(index); 
			botao.setBounds(
					(int)(this.width* 0.25),
					(int)((this.height * botaoHeight) *  (index + 1)),
					(int)(this.width * 0.50),
					(int)(this.height * botaoHeight)
					);
			add(botao);
		}
		
		cadastrarAlunoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				setVisible(false);
				ControlePrincipal controlePrincipal = new ControlePrincipal();
				controlePrincipal.abrePanel("cadastroDeAluno");
			}
		});
		
		
		cadastrarAvaliacaoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				ControlePrincipal controlePrincipal = new ControlePrincipal();
				controlePrincipal.abrePanel("cadastroDeAvaliacao");
			}
		});	
		
		visualizarAvaliacaoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				ControlePrincipal controlePrincipal = new ControlePrincipal();
				controlePrincipal.abrePanel("visualizacaoDeAvaliacao");
			}
		});
		
		cadastrarExercicioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				ControlePrincipal controlePrincipal = new ControlePrincipal();
				controlePrincipal.abrePanel("cadastroDeExercicio");
			}
		});
		
		montarTreinoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				ControlePrincipal controle = new ControlePrincipal();
				controle.abrePanel("montarTreino");
			}
		});
	}
	
	public void setInterface()
	{
		ControlePrincipal controlePrincipal = new ControlePrincipal();
		int nivelDeAcesso = controlePrincipal.getNivelDeAcesso();
		switch(nivelDeAcesso)
		{
		case 1:
			cadastrarAlunoButton.setEnabled(true);
			montarTreinoButton.setEnabled(false);
			cadastrarAvaliacaoButton.setEnabled(false);
			visualizarTreinoButton.setEnabled(false);
			cadastrarExercicioButton.setEnabled(false);
			visualizarAvaliacaoButton.setEnabled(false);
			break;
		case 2:
			cadastrarAlunoButton.setEnabled(false);
			montarTreinoButton.setEnabled(false);
			cadastrarAvaliacaoButton.setEnabled(true);
			visualizarTreinoButton.setEnabled(false);
			cadastrarExercicioButton.setEnabled(false);
			visualizarAvaliacaoButton.setEnabled(true);
			break;
		case 3:
			cadastrarAlunoButton.setEnabled(false);
			montarTreinoButton.setEnabled(true);
			cadastrarAvaliacaoButton.setEnabled(false);
			visualizarTreinoButton.setEnabled(true);
			cadastrarExercicioButton.setEnabled(true);
			visualizarAvaliacaoButton.setEnabled(true);
			break;
		case 4:
			cadastrarAlunoButton.setEnabled(false);
			montarTreinoButton.setEnabled(false);
			cadastrarAvaliacaoButton.setEnabled(false);
			visualizarTreinoButton.setEnabled(true);
			cadastrarExercicioButton.setEnabled(false);
			visualizarAvaliacaoButton.setEnabled(true);
			break;
		default:
			cadastrarAlunoButton.setEnabled(false);
			montarTreinoButton.setEnabled(false);
			cadastrarAvaliacaoButton.setEnabled(false);
			visualizarTreinoButton.setEnabled(false);
			cadastrarExercicioButton.setEnabled(false);
			visualizarAvaliacaoButton.setEnabled(false);
			break;
		}

	}
}
