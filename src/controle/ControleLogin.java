package controle;

import javax.swing.JOptionPane;

import modelo.AlunoDAO;

public class ControleLogin {
	
	public static boolean validaLogin(String matricula, String senha)
	{
		int nivelAcesso = 0;
		boolean usuarioValido = false;
		if (!matricula.isEmpty())
		{
			nivelAcesso = Character.getNumericValue(matricula.charAt(0));
			switch(nivelAcesso)
			{
			case 1:
				//usuarioValido = RecepcionistaDAO.validar(matricula, senha);
				break;
			case 2:
				//usuarioValido = FisioterapeutaDAO.validar(matricula, senha);
				break;
			case 3:
				//JOptionPane.showMessageDialog(null, "Professor");
				//usuarioValido = ProfessorDAO.validar(matricula, senha);
				break;
			case 4:
				//JOptionPane.showMessageDialog(null, "Aluno");
				usuarioValido = AlunoDAO.validar(matricula, senha);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Erro no Login");
				return false;
			}
			if (usuarioValido)
				return true;
			else
				JOptionPane.showMessageDialog(null, "Usuário Inválido");
		}
		return false;
	}
	
	public static void setNivelDeAcesso(String matricula)
	{
		ControleSessao.setNivelDeAcesso(Character.getNumericValue(matricula.charAt(0)));
	}
	
	public static void inicializaTelaPrincipal()
	{
		ControlePrincipal.inicializaTelaPrincipal();
	}
	
	public static void carregaBaseDeDados()
	{
		ControleSessao.carregaBaseDeDados();
	}
}
