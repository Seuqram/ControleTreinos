package visao;

import controle.ControleLogin;
import controle.ControlePrincipal;
import visao.Principal;
import modelo.Aluno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Login extends JFrame{
	Login janela ;
	public JTextField usuario ;
	public JPasswordField password ;
	public String userid, erro, asenha;

	public Login() {

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

		this.setTitle("Login");
		this.setVisible(true);
		this.pack();

		/* Função Login*/
		entra.addActionListener( new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				String matricula = usuario.getText();
				if (ControleLogin.validaLogin(matricula, senha.getText()))
				{
					JOptionPane.showMessageDialog(null, "Logado com sucesso");
					ControleLogin.setNivelDeAcesso(matricula);
					setVisibilidade(false);
					ControleLogin.carregaBaseDeDados();
					ControleLogin.inicializaTelaPrincipal();
				}else
					JOptionPane.showMessageDialog(null, "Problema no Login");
			}
		});

		cancela.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

	}

	public void setVisibilidade(boolean visibilidade)
	{
		this.setVisible(visibilidade);
	}
	
	
}