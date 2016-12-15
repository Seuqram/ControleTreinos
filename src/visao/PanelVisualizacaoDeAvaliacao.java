package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.function.Consumer;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import controle.ControleCadastrodeAvaliacao;
import controle.ControleVisualizacaoDeAvaliacao;
import modelo.Avaliacao;

@SuppressWarnings("serial")
public class PanelVisualizacaoDeAvaliacao extends PanelGenerico{
	ArrayList<JRadioButton> listADeradioButtonsAvaliacoes;
	ArrayList<JLabel> listaDeLabelsAvaliacao = new ArrayList<>();
	ControleCadastrodeAvaliacao controleCadastroDeAvaliacao = new ControleCadastrodeAvaliacao();
	JLabel bracoDireitoLabel = new JLabel();
	JLabel bracoEsquerdoLabel = new JLabel();
	JLabel coxaDireitaLabel = new JLabel();
	JLabel coxaEsquerdaLabel = new JLabel();
	JLabel peitoLabel = new JLabel();
	JLabel percentualDeGorduraLabel = new JLabel();
	JLabel objetivoLabel = new JLabel();
	JLabel pesoLabel = new JLabel();
	
	
	public PanelVisualizacaoDeAvaliacao(int width, int height, double porcentagemWidth, double porcentagemHeight) {
		super(width, height, porcentagemWidth, porcentagemHeight);
		setTituloLabel("Visualização de Avaliação");
		listADeradioButtonsAvaliacoes = new ArrayList<>();
		
		listaDeLabelsAvaliacao.add(bracoDireitoLabel);
		listaDeLabelsAvaliacao.add(bracoEsquerdoLabel);
		listaDeLabelsAvaliacao.add(coxaDireitaLabel);
		listaDeLabelsAvaliacao.add(coxaEsquerdaLabel);
		listaDeLabelsAvaliacao.add(peitoLabel);
		listaDeLabelsAvaliacao.add(percentualDeGorduraLabel);
		listaDeLabelsAvaliacao.add(objetivoLabel);
		listaDeLabelsAvaliacao.add(pesoLabel);
		
		JLabel nomeLabel = new JLabel();
		JLabel idadeLabel = new JLabel();
		
		ArrayList<JLabel> listaDeLabel = new ArrayList<>();
		listaDeLabel.add(nomeLabel);
		listaDeLabel.add(idadeLabel);
		int sizeLabel = (int)(this.width * 0.4);
		
		for (int indice = 0; indice < listaDeLabel.size(); indice++){
			listaDeLabel.get(indice).setFont(new Font("Tahoma", Font.PLAIN, (int)(this.height * 0.03)));
			listaDeLabel.get(indice).setBounds(
					(int)((this.width * 0.46) + ((sizeLabel/2) * (indice))), 
					(int)(this.height * 0.12), 
					sizeLabel, 
					(int)(this.height * 0.1));
			add(listaDeLabel.get(indice));
		}
		
		JComboBox alunosComboBox = new JComboBox(controleCadastroDeAvaliacao.getAlunos());
		alunosComboBox.setBounds(
				(int)(this.width * 0.1),
				(int)(this.height * 0.15),
				(int)(this.width * 0.35), 
				(int)(this.height * 0.05));
		add(alunosComboBox);
		
		alunosComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ControleVisualizacaoDeAvaliacao controleVisualicaoDeAvaliacao = new ControleVisualizacaoDeAvaliacao();
				nomeLabel.setText("Nome: " + controleVisualicaoDeAvaliacao.getNomeAluno(alunosComboBox.getSelectedItem().toString()));
				idadeLabel.setText("Idade : " + controleVisualicaoDeAvaliacao.getDataDeNascimentoAluno(alunosComboBox.getSelectedItem().toString()));
				criaRadioButtonsAvaliacoes(controleVisualicaoDeAvaliacao.getAvaliacoes(alunosComboBox.getSelectedItem().toString()));
				invalidate();
				validate();
				repaint();
			}
		});
	}
	
	private void criaRadioButtonsAvaliacoes(ArrayList<Avaliacao> avaliacoes){
		int distancia = (int)(this.height * 0.21);
		listADeradioButtonsAvaliacoes.clear();		
		avaliacoes.forEach(
				avaliacao -> {
					JRadioButton radioButton = new JRadioButton(avaliacao.getDataDeCadastro());
					listADeradioButtonsAvaliacoes.add(radioButton);
					radioButton.setFont(new Font("Tahoma", Font.PLAIN, (int)(this.height * 0.03)));
					radioButton.setBounds(
							(int)(this.width * 0.1),
							(int)(distancia + (this.height * 0.05 * avaliacoes.indexOf(avaliacao))), 
							(int)(this.width * 0.35), 
							(int)(this.height * 0.05));
					add(radioButton);
					radioButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							habilitaRadioButtonDesabilitado();
							desselecionaRadioButtonSelecionado();
							radioButton.setEnabled(false);
							radioButton.setSelected(true);
							clearAvaliacao();
							exibeAvaliacao(avaliacao);
						}
					});
				});
	}
	
	private void exibeAvaliacao(Avaliacao avaliacao){
		bracoDireitoLabel.setText("Braço Direito: " + avaliacao.getMedida().getBracoDireito());
		bracoEsquerdoLabel.setText("Braço Esquerdo: " + avaliacao.getMedida().getBracoEsquerdo());
		coxaDireitaLabel.setText("Coxa Direita: " + avaliacao.getMedida().getCoxaDireita());
		coxaEsquerdaLabel.setText("Coxa Esquerda: " + avaliacao.getMedida().getCoxaEsquerda());
		peitoLabel.setText("Peito: " + avaliacao.getMedida().getPeito());
		percentualDeGorduraLabel.setText("% de gordura: " + avaliacao.getMedida().getPercentualDeGordura());
		objetivoLabel.setText("Objetivo: " + avaliacao.getObjetivo());
		pesoLabel.setText("Peso: " + avaliacao.getPeso());
		
		listaDeLabelsAvaliacao.forEach(
				(label) -> {
					label.setFont(new Font("Tahoma", Font.PLAIN, (int)(this.height * 0.03)));
					label.setBounds(
							(int)((this.width * 0.46)), 
							(int)((this.height * 0.2) + ((this.height * 0.05) * listaDeLabelsAvaliacao.indexOf(label))), 
							(int)(this.width * 0.5), 
							(int)(this.height * 0.1));
					add(label);
					invalidate();
					validate();
					repaint();
				});
	}
	
	public void clearAvaliacao(){
		listaDeLabelsAvaliacao.forEach(label -> label.setText(""));
	}
	
	public void habilitaRadioButtonDesabilitado(){
		listADeradioButtonsAvaliacoes.forEach(
				radioButton -> {
					if (!radioButton.isEnabled()){
						radioButton.setEnabled(true);
					}
				});
	}
	
	public void desselecionaRadioButtonSelecionado(){
		listADeradioButtonsAvaliacoes.forEach(
				radioButton -> {
					if (radioButton.isSelected()){
						radioButton.setSelected(false);
					}
				});
		
	}
}
