package visao;
import modelo.AlunoDAO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrodeAluno extends JFrame implements ActionListener{

	static CadastrodeAluno janela ;
	public JTextField nome, id, dataNasc, mail ;
	JButton inclui = new JButton("Incluir");

	public CadastrodeAluno() {

		/* Constroi a tela de LOGIN com gridBaglayout */
		Container contantPane = getContentPane();
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		contantPane.setLayout(gridbag);

		getContentPane().setBackground(Color.white);

		JLabel intro = new JLabel("Cadastro de Aluno");
		c.gridwidth = 2;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		intro.setFont(new Font("Serif", Font.BOLD, 20));
		gridbag.setConstraints(intro, c);
		getContentPane().add(intro);

		JLabel user = new JLabel("Nome Completo");
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 2;
		gridbag.setConstraints(user, c);
		getContentPane().add(user);

		JLabel cpf = new JLabel("Cpf:");
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 3;
		gridbag.setConstraints(cpf, c);
		getContentPane().add(cpf);

		JLabel nasc = new JLabel("Data de Nascimento:");
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 4;
		gridbag.setConstraints(nasc, c);
		getContentPane().add(nasc);

		JLabel email = new JLabel("E-mail:");
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 5;
		gridbag.setConstraints(email, c);
		getContentPane().add(email);

		nome = new JTextField(15);
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 2;
		gridbag.setConstraints(nome, c);
		getContentPane().add(nome);

		id = new JTextField(15);
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 3;
		gridbag.setConstraints(id, c);
		getContentPane().add(id);

		dataNasc = new JTextField(15);
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 4;
		gridbag.setConstraints(dataNasc, c);
		getContentPane().add(dataNasc);

		mail = new JTextField(15);
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 5;
		gridbag.setConstraints(mail, c);
		getContentPane().add(mail);


		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 10;
		gridbag.setConstraints(inclui, c);
		getContentPane().add(inclui);

		JButton cancela = new JButton("Cancelar");
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 10;
		gridbag.setConstraints(cancela, c);
		getContentPane().add(cancela);

		inclui.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == inclui){
			AlunoDAO a = new AlunoDAO();
			a.incluiAluno(nome.getText(), mail.getText(), Integer.parseInt(id.getText()), dataNasc.getText(), 001);
			JOptionPane.showMessageDialog(null, "Aluno Incluido");
		}

	}

	public static void main(String[] args) {
		/* Chama o programa */

		janela = new CadastrodeAluno() ;
		janela.setTitle("Cadastro de Aluno");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(500, 500);
		//janela.pack();
		janela.setVisible(true);  

	}   

}

