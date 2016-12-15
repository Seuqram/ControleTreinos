package visao;

import java.awt.EventQueue;

import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controle.ControlePrincipal;

import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class TelaPrincipal {
	
	static Rectangle gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
	static double janelaWidth = gc.getWidth();
	static double janelaHeight = gc.getHeight();
	static JButton logoutButton = new JButton("logout");
	static JButton voltarButton = new JButton("voltar");
	private static JFrame frame;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		ControlePrincipal controlePrincipal = new ControlePrincipal();
		controlePrincipal.carregaBaseDeDados();
		PanelLogin login = new PanelLogin(
				(int)(janelaWidth), 
				(int)(janelaHeight ),
				0.5,
				0.4);
		exibePanel(login, login.getPorcentagemWidth(), login.getPorcentagemHeight());
	}
	
	public TelaPrincipal() {
		initialize();
	}
	
	public static void exibePanel(JPanel panelParaExibir, double width, double height){
		panelParaExibir.setBounds(
				(int)((janelaWidth - (janelaWidth * width))/2),
				(int)((janelaHeight - (janelaHeight * height))/2),
				(int)(janelaWidth * width),
				(int)(janelaHeight * height)
		);
		frame.getContentPane().add(panelParaExibir);
		refresh();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(33, 150, 243));
		frame.getContentPane().setLayout(null);
		
		/*
		 * BOTÃO FECHAR
		 */
		JButton closeButton = new JButton("X");
		closeButton.setDefaultCapable(false);
		closeButton.setFont(new Font("Tahoma", Font.PLAIN, (int)(janelaHeight * 0.05)));
		closeButton.setBorderPainted(false);
		closeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		closeButton.setBounds(
				(int)(janelaWidth-(janelaHeight * 0.1)),
				0, 
				(int)(janelaHeight * 0.1), 
				(int)(janelaHeight * 0.1)
		);
		closeButton.setBackground(new Color(33, 150, 243));
		frame.getContentPane().add(closeButton);
		closeButton.getModel().addChangeListener(new ChangeListener() {
		    @Override
		    public void stateChanged(ChangeEvent e) {
		        ButtonModel model = (ButtonModel) e.getSource();
		        if (model.isRollover()) {
		        	closeButton.setBackground(Color.RED);
		        } else {
		        	closeButton.setBackground(new Color(33, 150, 243));
		        }
		    }
		});
		
		/*
		 * Botão Logout
		 */
		logoutButton.setEnabled(false);
		logoutButton.setDefaultCapable(false);
		logoutButton.setBorderPainted(false);
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				frame.getContentPane().removeAll();
				frame.getContentPane().add(closeButton);
				frame.getContentPane().add(logoutButton);
				frame.getContentPane().add(voltarButton);
				ControlePrincipal controlePrincipal = new ControlePrincipal();
				controlePrincipal.realizaLogout();
				refresh();
			}
		});
		logoutButton.setFont(new Font("Tahoma", Font.PLAIN, (int)(janelaHeight * 0.05)));
		logoutButton.setBounds(
				(int)(janelaWidth-(janelaHeight * 0.35)),
				0, 
				(int)(janelaHeight * 0.25), 
				(int)(janelaHeight * 0.1)
				);
		logoutButton.setBackground(new Color(33, 150, 243));
		frame.getContentPane().add(logoutButton);
		logoutButton.getModel().addChangeListener(new ChangeListener() {
		    @Override
		    public void stateChanged(ChangeEvent e) {
		        ButtonModel model = (ButtonModel) e.getSource();
		        if (model.isRollover()) {
		        	logoutButton.setBackground(new Color(200, 200, 200));
		        	logoutButton.setForeground(new Color(33, 150, 243));
		        } else {
		        	logoutButton.setBackground(new Color(33, 150, 243));
		        	logoutButton.setForeground(new Color(200, 200, 200));
		        }
		    }
		});
		
		/*
		 * Voltar Logout
		 */
		voltarButton.setEnabled(false);
		voltarButton.setDefaultCapable(false);
		voltarButton.setBorderPainted(false);
		voltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				System.out.println("ação voltar");
			}
		});
		voltarButton.setFont(new Font("Tahoma", Font.PLAIN, (int)(janelaHeight * 0.05)));
		voltarButton.setBounds(
				(int)(janelaWidth-(janelaHeight * 0.35)),
				0, 
				(int)(janelaHeight * 0.25), 
				(int)(janelaHeight * 0.1)
				);
		voltarButton.setBackground(new Color(33, 150, 243));
		frame.getContentPane().add(voltarButton);
		voltarButton.getModel().addChangeListener(new ChangeListener() {
		    @Override
		    public void stateChanged(ChangeEvent e) {
		        ButtonModel model = (ButtonModel) e.getSource();
		        if (model.isRollover()) {
		        	voltarButton.setBackground(new Color(200, 200, 200));
		        	voltarButton.setForeground(new Color(33, 150, 243));
		        } else {
		        	voltarButton.setBackground(new Color(33, 150, 243));
		        	voltarButton.setForeground(new Color(200, 200, 200));
		        }
		    }
		});

		//frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	
	public static void setLogoutButton(boolean habilitacao){
		logoutButton.setEnabled(habilitacao);
	}
	
	public static double getWidth(){
		return janelaWidth;
	}
	
	public static double getHeight(){
		return janelaHeight;
	}
	
	public static void refresh(){
		frame.invalidate();
		frame.validate();
		frame.repaint();
	}
}