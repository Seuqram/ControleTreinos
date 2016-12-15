package visao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controle.ControleCadastrodeAvaliacao;

@SuppressWarnings("serial")
public class PanelCadastroDeAvaliacao extends PanelGenerico {
	ControleCadastrodeAvaliacao controleCadastroDeAvaliacao = new ControleCadastrodeAvaliacao();
	private JTextField bracoDireitoTextField;
	private JTextField bracoEsquerdoTextField;
	private JTextField coxaDireitaTextField;
	private JTextField coxaEsquerdaTextField;
	private JTextField peitoTextField;
	private JTextField percentualDeGorduraTextField;
	private JTextField pesoTextField;
	private JTextField alturaTextField;
	private ArrayList<JTextField> listaDeTextField = new ArrayList<>();
	private JComboBox objetivoComboBox;

	/**
	 * Create the panel.
	 */
	public PanelCadastroDeAvaliacao(int width, int height, double porcentagemWidth, double porcentagemHeight) {
		super(width, height, porcentagemWidth, porcentagemHeight);
		setTituloLabel("Cadastro de Avaliação");
		
		bracoDireitoTextField = new JFormattedTextField();
		bracoDireitoTextField.setText("Braço Direito");
		bracoDireitoTextField.setName("medidaCm");
		bracoEsquerdoTextField = new JFormattedTextField();
		bracoEsquerdoTextField.setText("Braço Esquerdo");
		bracoEsquerdoTextField.setName("medidaCm");
		coxaDireitaTextField = new JFormattedTextField();
		coxaDireitaTextField.setText("Coxa Direita");
		coxaDireitaTextField.setName("medidaCm");
		coxaEsquerdaTextField = new JFormattedTextField();
		coxaEsquerdaTextField.setText("Coxa Esquerda");
		coxaEsquerdaTextField.setName("medidaCm");
		peitoTextField = new JFormattedTextField();
		peitoTextField.setText("Peito");
		peitoTextField.setName("medidaCm");
		percentualDeGorduraTextField = new JFormattedTextField();
		percentualDeGorduraTextField.setText("% de gordura");
		percentualDeGorduraTextField.setName("medidaGordura");
		pesoTextField = new JFormattedTextField();
		pesoTextField.setText("Peso");
		pesoTextField.setName("medidaPeso");
		alturaTextField = new JFormattedTextField();
		alturaTextField.setText("Altura");
		alturaTextField.setName("medidaAltura");
		
		listaDeTextField.add(bracoDireitoTextField);
		listaDeTextField.add(bracoEsquerdoTextField);
		listaDeTextField.add(coxaDireitaTextField);
		listaDeTextField.add(coxaEsquerdaTextField);
		listaDeTextField.add(peitoTextField);
		listaDeTextField.add(percentualDeGorduraTextField);
		listaDeTextField.add(pesoTextField);
		listaDeTextField.add(alturaTextField);
		
		int quantidadeDeTextField = listaDeTextField.size();
		int heightDoTextField = (int)((this.height * 0.4)/(quantidadeDeTextField/2));
		/*
		 * Criação dos texts fields do preenchimento de cadastro
		 */
		for (int indice = 0; indice < listaDeTextField.size(); indice++){
			JTextField textField = listaDeTextField.get(indice); 

			if (indice < (quantidadeDeTextField/2)){
				//Textfields do lado direito
				textField.setBounds(
						(int)(this.width * 0.1),
						(int)(((heightDoTextField + 20) * (indice + 1)) + this.tituloLabel.getHeight()),
						(int)(this.width * 0.35),
						(int)(heightDoTextField));
			}else{
				//Textfields do lado esquerdo
				textField.setBounds(
						(int)(this.width * 0.55),
						(int)(((heightDoTextField + 10) * ((indice) - ((quantidadeDeTextField/2) - 1)))  + this.tituloLabel.getHeight()),
						(int)(this.width * 0.35),
						(int)(heightDoTextField));
			}
			textField.setHorizontalAlignment(JTextField.CENTER);
			textField.setColumns(10);
			add(textField);

			listaDeTextField.get(indice).addFocusListener(new FocusAdapter() {
				public void focusGained(FocusEvent arg0) {
					textField.setText("");

					MaskFormatter mascaraMedidaCm = null;
					MaskFormatter mascaraMedidaPeso= null;
					MaskFormatter mascaraMedidaGordura = null;
					MaskFormatter mascaraMedidaAltura = null;
					try {
						mascaraMedidaCm = new MaskFormatter("##.## cm");
						mascaraMedidaPeso = new MaskFormatter("###.## kg");
						mascaraMedidaGordura = new MaskFormatter("##.## %");
						mascaraMedidaAltura = new MaskFormatter("#.## m");
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					//DEFINE A MASCARA QUANDO O CAMPO RECEBE FOCO
					if (textField.getName().equals("medidaCm")){
						mascaraMedidaCm.install((JFormattedTextField) textField);
					}else{
						if (textField.getName().equals("medidaPeso")){
							mascaraMedidaPeso.install((JFormattedTextField) textField);
						}else{
							if (textField.getName().equals("medidaGordura")){
								mascaraMedidaGordura.install((JFormattedTextField) textField);
							}else{
								if (textField.getName().equals("medidaAltura")){
									mascaraMedidaAltura.install((JFormattedTextField) textField);
								}
							}
						}
					}
				}
			});
		}

		JComboBox alunosComboBox = new JComboBox(controleCadastroDeAvaliacao.getAlunos());
		alunosComboBox.setBounds(
				(int)(this.width * 0.1),
				(int)(this.height * 0.15),
				(int)(this.width * 0.35), 
				(int)(this.height * 0.05));
		add(alunosComboBox);
		
		String[] objetivos = new String[3];
		objetivos[0] = "Hipertrofia";
		objetivos[1] = "Emagrecimento";
		objetivos[2] = "Fortalecimento de Articulações";
		
		objetivoComboBox = new JComboBox(objetivos);
		objetivoComboBox.setBounds(
				(int)(this.width * 0.1),
				(int)(this.height * 0.21),
				(int)(this.width * 0.35), 
				(int)(this.height * 0.05));
		add(objetivoComboBox);

		JLabel nomeDoAluno = new JLabel();
		nomeDoAluno.setFont(new Font("Tahoma", Font.PLAIN, (int)(this.height * 0.025)));
		nomeDoAluno.setBounds(
				(int)(this.width * 0.55),
				(int) (this.height * 0.15),
				(int) (this.width * 0.35),
				(int) (this.height * 0.05)
				);
		JLabel dataDeNascimento = new JLabel();
		dataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, (int)(this.height * 0.025)));
		dataDeNascimento.setBounds(
				(int)(this.width * 0.55),
				(int) (this.height * 0.20),
				(int) (this.width * 0.35),
				(int) (this.height * 0.05)
				);
		add(nomeDoAluno);
		add(dataDeNascimento);
		
		alunosComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String cpf = alunosComboBox.getSelectedItem().toString();
				String nome = "Nome: " + controleCadastroDeAvaliacao.getNomeAluno(cpf);
				String data = "Data de Nascimento: " + controleCadastroDeAvaliacao.getDataDeNascimentoAluno(cpf);
				nomeDoAluno.setText(nome);
				dataDeNascimento.setText(data);
				habilitaCadastro(true);
			}
		});

		JButton salvarButton = new JButton();
		salvarButton.setBounds(
				(int)(this.width * 0.46),
				(int)(this.height * 0.7),
				(int)(this.width * 0.08),
				(int)(this.height * 0.1));
		add(salvarButton);
		salvarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (controleCadastroDeAvaliacao.cadastraAvaliacao(
						bracoDireitoTextField.getText(),
						bracoEsquerdoTextField.getText(),
						coxaDireitaTextField.getText(), 
						coxaEsquerdaTextField.getText(), 
						peitoTextField.getText(),
						percentualDeGorduraTextField.getText(), 
						objetivoComboBox.getSelectedItem().toString(),
						alunosComboBox.getSelectedItem().toString(),
						pesoTextField.getText(),
						alturaTextField.getText()))
						{
					JOptionPane.showMessageDialog(null, "Avaliação Incluída");
					/*limpaCampos();
					preencheCampos();*/
						}
				else
					JOptionPane.showMessageDialog(null, "Problema na Inclusão do Aluno");
			}

		});
		habilitaCadastro(false);
	}
	
	private void habilitaCadastro(boolean enable){
		for (int indice = 0; indice < listaDeTextField.size(); indice++){
			JTextField textField = new JTextField();
			textField = listaDeTextField.get(indice);
			textField.setEditable(enable);
			textField.setEnabled(enable);
		}
		objetivoComboBox.setEnabled(enable);
	}
}
