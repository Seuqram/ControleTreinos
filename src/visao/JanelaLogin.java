package visao;

import controle.ControleLogin;
import modelo.Aluno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class JanelaLogin extends JFrame{
	/* V�riaveis */
	static JanelaLogin janela ;
	public JTextField usuario ;
	public JPasswordField password ;
	public String userid, erro, asenha;
	private ControleLogin controleLogin;

	public JanelaLogin() {

		/* Constroi a tela de LOGIN com gridBaglayout */
		Container contantPane = getContentPane();
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		contantPane.setLayout(gridbag);

		getContentPane().setBackground(Color.white);

		JLabel intro = new JLabel("Controle de Treinos");
		c.gridwidth = 2;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		gridbag.setConstraints(intro, c);
		getContentPane().add(intro);

		JLabel user = new JLabel("Usuario:");
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 2;
		gridbag.setConstraints(user, c);
		getContentPane().add(user);

		JLabel senha = new JLabel("Senha:");
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 3;
		gridbag.setConstraints(senha, c);
		getContentPane().add(senha);

		usuario = new JTextField(15);
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 2;
		gridbag.setConstraints(usuario, c);
		getContentPane().add(usuario);

		password = new JPasswordField(15);
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 3;
		gridbag.setConstraints(password, c);
		getContentPane().add(password);

		JButton entra = new JButton("Entrar");
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 4;
		gridbag.setConstraints(entra, c);
		getContentPane().add(entra);

		JButton cancela = new JButton("Cancelar");
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 4;
		gridbag.setConstraints(cancela, c);
		getContentPane().add(cancela);

		/* Funcao de entrar  */
		entra.addActionListener( new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				//validar();
				ControleLogin.validar(usuario.getText(), senha.getText());
			}
		});

		cancela.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

	}

	public static void main(String[] args) {
		/* Chama o programa */
		janela = new JanelaLogin() ;
		janela.setTitle("Login");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.pack();
		janela.setVisible(true); 
		
	}   
}
