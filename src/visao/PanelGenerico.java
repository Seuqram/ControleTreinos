package visao;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PanelGenerico extends JPanel{
	double porcentagemWidth;
	double porcentagemHeight;
	int width;
	int height;
	JLabel tituloLabel;
	
	public PanelGenerico(){}
	
	PanelGenerico(int width, int height, double porcentagemWidth, double porcentagemHeight) {
		this.porcentagemWidth = porcentagemWidth;
		this.porcentagemHeight = porcentagemHeight;
		this.width = (int)(width * this.porcentagemWidth);
		this.height = (int)(height * this.porcentagemHeight);
		setLayout(null);
		
		tituloLabel = new JLabel("Título", SwingConstants.CENTER);
		tituloLabel.setFont(new Font("Tahoma", Font.PLAIN, (int)(this.height * 0.1)));
		tituloLabel.setBounds(
				0, 
				0, 
				(int)(this.width), 
				(int)(this.height * 0.1));
		tituloLabel.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		add(tituloLabel);
	}

	public double getPorcentagemWidth() {
		return porcentagemWidth;
	}

	public void setPorcentagemWidth(double porcentagemWidth) {
		this.porcentagemWidth = porcentagemWidth;
	}

	public double getPorcentagemHeight() {
		return porcentagemHeight;
	}

	public void setPorcentagemHeight(double porcentagemHeight) {
		this.porcentagemHeight = porcentagemHeight;
	}

	public void setTituloLabel(String titulo) {
		tituloLabel.setText(titulo);
	}
	
	public boolean validaCampos(ArrayList<JTextField> listaDeTextFields){
		JTextField textField;
		for (int indice = 0; indice < listaDeTextFields.size(); indice++){
			textField = listaDeTextFields.get(indice);
			if (textField.getText().equals("")){
				return false;
			}else{
				if (textField.getText().equals(textField.getName())){
					return false;
				}
			}
		}
		return true;
	}
	
	public void resetaCampos(ArrayList<JTextField> listaDeTextFields){
		listaDeTextFields.forEach(textField -> textField.setText(textField.getName()));
	}
	
	public void checaPreenchimento(ArrayList<JTextField> listaDeTextFields){
		listaDeTextFields.forEach(textField -> {
			if (textField.getText().equals("")){
				textField.setText(textField.getName());
			}
		});
	}
	
	public void refresh(){
		invalidate();
		validate();
		repaint();
	}
	
}
