package janelas;
import modelo.Aluno;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CadastrodeAluno extends JFrame implements ActionListener{
	 
//		static CadastrodeAluno janela;
//
//		JLabel l1, l2, l3, l4, l5, l6, l7, l8;
//		JTextField tf1, tf2, tf5, tf6, tf7;
//		JButton btn1, btn2;
//		JPasswordField p1, p2;
//	 
//	    public CadastrodeAluno(){
//	     
//	        setVisible(true);
//	        setSize(700, 700);
//	        setLayout(null);
//	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	        setTitle("Registration Form in Java");
//	 
//	        l1 = new JLabel("Registration Form in Windows Form:");
//	        l1.setForeground(Color.blue);
//	        l1.setFont(new Font("Serif", Font.BOLD, 20));
//	 
//	        l2 = new JLabel("Name:");
//	        l3 = new JLabel("Email-ID:");
//	        l4 = new JLabel("Create Passowrd:");
//	        l5 = new JLabel("Confirm Password:");
//	        l6 = new JLabel("Country:");
//	        l7 = new JLabel("State:");
//	        l8 = new JLabel("Phone No:"); 
//	        tf1 = new JTextField();
//	        tf2 = new JTextField();
//	        p1 = new JPasswordField();
//	        p2 = new JPasswordField();
//	        tf5 = new JTextField();
//	        tf6 = new JTextField();
//	        tf7 = new JTextField();
//	 
//	        btn1 = new JButton("Submit");
//	        btn2 = new JButton("Clear");
//	 
//	        btn1.addActionListener(this);
//	        btn2.addActionListener(this);
//	 
//	        l1.setBounds(100, 30, 400, 30);
//	        l2.setBounds(80, 70, 200, 30);
//	        l3.setBounds(80, 110, 200, 30);
//	        l4.setBounds(80, 150, 200, 30);
//	        l5.setBounds(80, 190, 200, 30);
//	        l6.setBounds(80, 230, 200, 30);
//	        l7.setBounds(80, 270, 200, 30);
//	        l8.setBounds(80, 310, 200, 30);
//	        tf1.setBounds(300, 70, 200, 30);
//	        tf2.setBounds(300, 110, 200, 30);
//	        p1.setBounds(300, 150, 200, 30);
//	        p2.setBounds(300, 190, 200, 30);
//	        tf5.setBounds(300, 230, 200, 30);
//	        tf6.setBounds(300, 270, 200, 30);
//	        tf7.setBounds(300, 310, 200, 30);
//	        btn1.setBounds(50, 350, 100, 30);
//	        btn2.setBounds(170, 350, 100, 30);
//	 
//	        add(l1);
//	        add(l2);
//	        add(tf1);
//	        add(l3);
//	        add(tf2);
//	        add(l4);
//	        add(p1);
//	        add(l5);
//	        add(p2);
//	        add(l6);
//	        add(tf5);
//	        add(l7);
//	        add(tf6);
//	        add(l8);
//	        add(tf7);
//	        add(btn1);
//	        add(btn2);
//	    }
	    
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
			
			Aluno a = new Aluno();
			String s1 = nome.getText();
			int s2 = Integer.parseInt(id.getText());
			String s3 = dataNasc.getText();
			String s4 = mail.getText();
			int na = 1;
			int mat = 001;
			a.incluiAluno(s1, s4, s2, s3, na, mat);
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


	
