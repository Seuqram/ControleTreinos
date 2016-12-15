package visao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controle.ControleCadastrodeExercicio;

@SuppressWarnings("serial")
public class PanelCadastroDeExercicio extends PanelGenerico{
	JTextField nomeTextField;
	JTextField descricaoTextField;
	ArrayList<JTextField> listaDeTextFields = new ArrayList<>();
	
	public PanelCadastroDeExercicio(int width, int height, double porcentagemWidth, double porcentagemHeight) {
		super(width, height, porcentagemWidth, porcentagemHeight);
		setTituloLabel("Cadastro de Exercício");
		exibeMontagemExercicio();
		
		
	}
	
	public void exibeMontagemExercicio(){
		nomeTextField = new JTextField();
		nomeTextField.setName("NOME");
		descricaoTextField = new JTextField();
		descricaoTextField.setName("DESCRIÇÃO");
		
		listaDeTextFields = new ArrayList<>();
		listaDeTextFields.add(nomeTextField);
		listaDeTextFields.add(descricaoTextField);
		
		int tamanhoTextField = (int)((this.width * 0.3) / listaDeTextFields.size());
		listaDeTextFields.forEach(textField -> {
			textField.setBounds(
					(int)(this.width * 0.1),
					(int)(((this.height * 0.01) + tamanhoTextField) * (listaDeTextFields.indexOf(textField) + 1)),
					(int)(this.width * 0.8),
					tamanhoTextField
					);
			textField.setHorizontalAlignment(JTextField.CENTER);
			textField.setColumns(10);
			add(textField);
			
			textField.addFocusListener(new FocusAdapter() {
				public void focusGained(FocusEvent arg0) {
					checaPreenchimento(listaDeTextFields);
					if (textField.getText().equals(textField.getName())){
						textField.setText("");
					}
				}
			});
		});
		resetaCampos(listaDeTextFields);
		
		JButton salvarButton = new JButton("SALVAR");
		salvarButton.setBounds(
				(int)(this.width * 0.2),
				(int)(this.height * 0.75),
				(int)(this.width * 0.6),
				(int)(this.height * 0.1));
		add(salvarButton);
		salvarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (validaCampos(listaDeTextFields)){
					ControleCadastrodeExercicio controle = new ControleCadastrodeExercicio();
					controle.cadastraExercicio(nomeTextField.getText(),
											   descricaoTextField.getText());
					resetaCampos(listaDeTextFields);
				}else{
					JOptionPane.showMessageDialog(null, "Erro no preenchimento dos campos");
				}
			}
		});
	}
}
