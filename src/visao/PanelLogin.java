package visao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controle.ControleLogin;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PanelLogin extends PanelGenerico {
	ControleLogin controleLogin = new ControleLogin();
	private JTextField matriculaTextField;
	private JTextField senhaTextField;

	/**
	 * Create the panel.
	 */
	public PanelLogin(int width, int height, double porcentagemWidth, double porcentagemHeight) {
		super(width, height, porcentagemWidth, porcentagemHeight);
		setTituloLabel("");
		setBackground(new Color(244, 67, 54));
		JLabel matriculaLabel = new JLabel("Matr\u00EDcula", SwingConstants.CENTER);
		matriculaLabel.setFont(new Font("Tahoma", Font.PLAIN, (int)(this.height * 0.1)));
		matriculaLabel.setBounds(
				0,
				(int)(this.height * 0.05),
				this.width,
				(int)(this.height * 0.1));
		add(matriculaLabel);
		
		JLabel senhaLabel = new JLabel("Senha", SwingConstants.CENTER);
		senhaLabel.setFont(new Font("Tahoma", Font.PLAIN, (int)(this.height * 0.1)));
		senhaLabel.setBounds(0,(int)(this.height * 0.35), this.width, (int)(this.height * 0.1));
		add(senhaLabel);
		
		matriculaTextField = new JTextField();
		matriculaTextField.setBounds(
				(int)(this.width * 0.1),
				(int)(this.height * 0.15),
				(int)(this.width * 0.8),
				(int)(this.height * 0.1)
		);
		add(matriculaTextField);
		matriculaTextField.setHorizontalAlignment(JTextField.CENTER);
		matriculaTextField.setColumns(50);
		
		senhaTextField = new JTextField();
		senhaTextField.setBounds(
				(int)(this.width * 0.1),
				(int)(this.height * 0.45),
				(int)(this.width * 0.8),
				(int)(this.height * 0.1)
		);
		senhaTextField.setHorizontalAlignment(JTextField.CENTER);
		senhaTextField.setColumns(10);
		add(senhaTextField);
		
		JButton loginButton = new JButton("LOGIN");
		loginButton.setBounds(
				(int)(this.width * 0.1),
				(int)(this.height * 0.60),
				(int)(this.width * 0.8),
				(int)(this.height * 0.3)
				);
		add(loginButton);
		
		loginButton.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String matricula = matriculaTextField.getText();
				if (ControleLogin.validaLogin(matricula, senhaTextField.getText()))
				{
					setVisible(false);
					controleLogin.realizaProcedimentosLogin(matricula);
				}else
					JOptionPane.showMessageDialog(null, "Problema no Login");
			}
		});
	}
}
