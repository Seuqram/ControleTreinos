package controle;

import javax.swing.JOptionPane;

import modelo.AlunoDAO;

public class ControleLogin {
	public static boolean validar(String matricula, String senha)
	{
		int nivelAcesso = 0;
		boolean usuarioValido = false;
		if (!matricula.isEmpty())
		{
			nivelAcesso = Character.getNumericValue(matricula.charAt(0));
			switch(nivelAcesso)
			{
			case 1:
				JOptionPane.showMessageDialog(null, "Recepcionista");
				//usuarioValido = RecepcionistaDAO.validar(matricula, senha);
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "Fisioterapeuta");
				//usuarioValido = FisioterapeutaDAO.validar(matricula, senha);
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "Professor");
				//usuarioValido = ProfessorDAO.validar(matricula, senha);
				break;
			case 4:
				JOptionPane.showMessageDialog(null, "Aluno");
				usuarioValido = AlunoDAO.validar(matricula, senha);
				break;
			default:
				JOptionPane.showMessageDialog(null, "N�vel de Acesso Inv�lido");
				return false;
			}
			if (usuarioValido){
				//carregaBaseDeDados
				AlunoDAO a = new AlunoDAO(); 
				a.carregaAlunos();//N�O EST� FUNCIONANDO AINDA
				JOptionPane.showMessageDialog(null, "Usu�rio V�lido");
				return true;
			}
			else
				JOptionPane.showMessageDialog(null, "Usu�rio Inv�lido");
		}
		return false;
	}
}
