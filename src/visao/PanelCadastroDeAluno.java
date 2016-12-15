package visao;


import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controle.ControleCadastroDeAluno;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;

@SuppressWarnings("serial")
public class PanelCadastroDeAluno extends PanelGenerico {
	ControleCadastroDeAluno controleCadastroDeAluno = new ControleCadastroDeAluno();
	ArrayList<JTextField> listaDeTextField;
	private JTextField nomeTextField;
	private JTextField CPFTextField;
	private JTextField dataDeNascimentoTextField;
	private JTextField emailTextField;
	private JButton salvarButton;

	/**
	 * Create the panel.
	 */
	public PanelCadastroDeAluno(int width, int height, double porcentagemWidth, double porcentagemHeight) {
		super(width, height, porcentagemWidth, porcentagemHeight);
		setTituloLabel("Cadastro de Aluno");
		
		nomeTextField = new JTextField();
		nomeTextField.setName("NOME");
		CPFTextField = new JFormattedTextField();
		CPFTextField.setName("CPF");
		dataDeNascimentoTextField = new JFormattedTextField();
		dataDeNascimentoTextField.setName("DATA DE NASCIMENTO");
		emailTextField = new JTextField();
		emailTextField.setName("EMAIL");
		resetaCampos();
		
		listaDeTextField = new ArrayList<>();
		listaDeTextField.add(nomeTextField);
		listaDeTextField.add(CPFTextField);
		listaDeTextField.add(dataDeNascimentoTextField);
		listaDeTextField.add(emailTextField);
		
		/*
		 * Criação dos texts fields do preenchimento de cadastro
		 */
		for (int indice = 0; indice < listaDeTextField.size(); indice++){
			JTextField textField = listaDeTextField.get(indice); 
			textField.setBounds(
					(int)(this.width * 0.1),
					(int)((this.height * 0.15) * (indice + 1)),
					(int)(this.width * 0.8),
					(int)(this.height * 0.1));
			textField.setHorizontalAlignment(JTextField.CENTER);
			textField.setColumns(10);
			add(textField);
			
			textField.addFocusListener(new FocusAdapter() {
				public void focusGained(FocusEvent arg0) {
					textField.setText("");
					
					
					MaskFormatter mascaraCpf = null;
					MaskFormatter mascaraData = null;
					try {
						mascaraData = new MaskFormatter("##/##/####");
						mascaraCpf = new MaskFormatter("###.###.###-##");
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//DEFINE A MASCARA DO CAMPO CPF QUANDO RECEBE FOCO
					if (textField.getName().equals(CPFTextField.getName())){
						mascaraCpf.install((JFormattedTextField) textField);
					}
					
					//DEFINE A MASCARA DO CAMPO DATA QUANDO RECEBE FOCO
					if (textField.getName().equals(dataDeNascimentoTextField.getName())){
						mascaraData.install((JFormattedTextField) textField);
					}
				}
			});
		}
			
		salvarButton = new JButton("SALVAR");
		salvarButton.setBounds(
				(int)(this.width * 0.2),
				(int)(this.height * 0.75),
				(int)(this.width * 0.6),
				(int)(this.height * 0.1));
		add(salvarButton);
		salvarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(validaCampos(listaDeTextField))
				{
					controleCadastroDeAluno.cadastrarAluno(
							nomeTextField.getText(), 
							emailTextField.getText(), 
							CPFTextField.getText(), 
							dataDeNascimentoTextField.getText());
					JOptionPane.showMessageDialog(null, "Aluno Incluido!");
					resetaCampos();
				}else
					JOptionPane.showMessageDialog(null, "Erro no preenchimento dos campos!");
			}
		});
	}
	
	private void resetaCampos(){
		listaDeTextField.forEach(textField -> {
			String nome = textField.getName();
			textField = new JTextField();
			textField.setText(nome);;
			textField.setName(nome);
		});
	}
}
