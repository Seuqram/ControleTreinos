package visao;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import modelo.Exercicio;

public class PanelMontarTreino extends PanelGenerico{
	ArrayList<Exercicio> listaDeExerciciosDisponiveis;
	ArrayList<Exercicio> listaDeExerciciosSelecionados;
	ControleMontarTreino controle = new ControleMontarTreino();
	JButton hipertrofiaButton = new JButton("HIPERTROFIA");
	JButton emagrecimentoButton = new JButton("EMAGRECIMENTO");
	JButton fortalecimentoButton = new JButton("FORTALECIMENTO");
	ArrayList<JButton> listaDeButton = new ArrayList<>();
	JLabel subTitulo;
	JTable exerciciosSelecionados;
	Object[][] dados;
	
	public PanelMontarTreino(int width, int height, double porcentagemWidth, double porcentagemHeight){
		super(width, height, porcentagemWidth, porcentagemHeight);
		setTituloLabel("Montar Treino");
		subTitulo= new JLabel("");
		subTitulo.setFont(new Font("Tahoma", Font.PLAIN, (int)(this.height * 0.07)));
		subTitulo.setBounds(
				0, 
				(int)(this.height * 0.12), 
				(int)(this.width), 
				(int)(this.height * 0.1));
		add(subTitulo);
		subTitulo.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		listaDeExerciciosDisponiveis = controle.getExercicios();
		listaDeExerciciosSelecionados = new ArrayList<>();
		inicializaEscolhaObjetivo();
		exibeColunas();
	}
	
	public void fechaSelecaoObjetivo(){
		listaDeButton.forEach(button -> {
			button.setEnabled(false);
			button.setVisible(false);
		});
	}
	
	public void inicializaEscolhaObjetivo(){
		subTitulo.setText("SELECIONE O OBJETIVO");
		hipertrofiaButton.setName("HIPERTROFIA");
		emagrecimentoButton.setName("EMAGRECIMENTO");
		fortalecimentoButton.setName("FORTALECIMENTO DAS ARTICULAÇÕES");

		listaDeButton.add(hipertrofiaButton);
		listaDeButton.add(emagrecimentoButton);
		listaDeButton.add(fortalecimentoButton);

		int tamanhoButton = (int)((this.width * 0.3) / listaDeButton.size());
		listaDeButton.forEach(button -> {
			button.setBounds(
					(int)(this.width * 0.1),
					(int)(((this.height * 0.05) + tamanhoButton) * (listaDeButton.indexOf(button) + 1)),
					(int)(this.width * 0.8),
					tamanhoButton);
			button.setText(button.getName());
			add(button);

			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					subTitulo.setText(button.getName());
					fechaSelecaoObjetivo();
					exibeExerciciosParaEscolha();
					refresh();
				}
			});
		});
	}
	
	public void exibeExerciciosParaEscolha(){
		int widthButton = (int)(this.width * 0.1);
		int heightButton = (int)((this.height * 0.75) / ((listaDeExerciciosDisponiveis.size()/3) + 1));
		int indiceLinha = 0;
		for (int indice = 0; indice < listaDeExerciciosDisponiveis.size(); indice++){
			JButton button = new JButton();
			Exercicio exercicio = listaDeExerciciosDisponiveis.get(indice);
			button.setText(exercicio.getNome());
			button.setBounds(
					(int)((this.width * 0.1) + (widthButton * indiceLinha)), 
					(int)((this.height * 0.2) + (heightButton * (indice/3))),
					widthButton,
					heightButton);
			add(button);
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					int repeticoes = Integer.parseInt(JOptionPane.showInputDialog("Entre com a quantidade de repetições"));
					int serie = Integer.parseInt(JOptionPane.showInputDialog("Entre com o número de séries"));
					exercicio.setRepeticoes(repeticoes);
					exercicio.setSerie(serie);
					Exercicio patati = new Exercicio(
							exercicio.getNome(),
							exercicio.getDescricao(),
							repeticoes,
							serie
							);
					adicionaExercicioALista(patati);
					refresh();
				}
			});
			if (indiceLinha == 2){
				indiceLinha = 0;
			}else{
				indiceLinha++;
			}
			
		}
		refresh();
	}
	
	public void adicionaExercicioALista(Exercicio exercicioEntrado){
		listaDeExerciciosSelecionados.add(exercicioEntrado);
		listaDeExerciciosSelecionados.forEach(exercicio -> {
			JLabel nomeLabel = new JLabel();
			nomeLabel.setText(exercicio.getNome());
			JLabel repeticaoLabel = new JLabel(String.valueOf(exercicio.getRepeticoes()));
			JLabel serieLabel = new JLabel(String.valueOf(exercicio.getSerie()));
			JLabel excluirLabel = new JLabel("X");
			JLabel[] labels = new JLabel[4];
			labels[0] = nomeLabel; 
			labels[1] = repeticaoLabel;
			labels[2] = serieLabel;
			labels[3] = excluirLabel;
			int widthLabel = (int)((this.width * 0.3) / 4);
			int heightLabel = (int)((this.height * 0.01));
			int widthNomeLabel = (int)(this.width * 0.27);
			nomeLabel.setBounds(
					(int)(this.width * 0.5),
					(int)(this.height * 0.3) + ((heightLabel * listaDeExerciciosSelecionados.indexOf(exercicio) * 3)),
					widthNomeLabel,
					100);
			add(nomeLabel);
			repeticaoLabel.setBounds(
					(int)((this.width * 0.5) + (widthNomeLabel)),
					(int)(this.height * 0.3) + ((heightLabel * listaDeExerciciosSelecionados.indexOf(exercicio) * 3)),
					(int)(this.width * 0.01),
					100);
			serieLabel.setBounds(
					(int)((this.width * 0.5) + widthNomeLabel + ((int)((this.width * 0.01)* 2))),
					(int)(this.height * 0.3) + ((heightLabel * listaDeExerciciosSelecionados.indexOf(exercicio) * 3)),
					(int)(this.width * 0.01),
					100);
			excluirLabel.setBounds(
					(int)((this.width * 0.5) + widthNomeLabel + ((int)((this.width * 0.015)* 3))),
					(int)(this.height * 0.3) + ((heightLabel * listaDeExerciciosSelecionados.indexOf(exercicio) * 3)),
					(int)(this.width * 0.01),
					100);
			for (int indice = 1; indice < 4; indice ++){
				/*labels[indice].setBounds(
						(int)((this.width * 0.5) + (widthNomeLabel * indice)),
						(int)(this.height * 0.3) + ((heightLabel * listaDeExerciciosSelecionados.indexOf(exercicio) * 3)),
						(int)(this.width * 0.01),
						100);*/
				add(labels[indice]);
			}
			/*add(nomeLabel);
			add(repeticaoLabel);
			add(serieLabel);*/
		});
		refresh();
	}
	
	public void inicializaTabelaDeExerxeciosEscolhidos(){
		String[] colunas = {"Exercício", "Repetições", "Série"};
		exerciciosSelecionados = new JTable(dados, colunas);
		adicionaExercicioALista("Exercício", "Repetições", "Série");
		add(exerciciosSelecionados);
		exerciciosSelecionados.setBounds((int)(this.width * 0.5),
										 (int)(this.height * 0.2), 
										 (int)(this.width * 0.3), 
										 (int)(this.width * 0.3));
	}
	
	public void adicionaExercicioALista(String nome, String repeticao, String serie){
		
	}
	
	public void exibeColunas(){
	}
}
