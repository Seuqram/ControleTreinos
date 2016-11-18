package controle;

import modelo.AlunoDAO;

public class ControleLogin {
	
	static String usuarioLogado = null;
	
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
				usuarioValido = true; //PARA TESTES
				//usuarioValido = RecepcionistaDAO.validar(matricula, senha);
				break;
			case 2:
				usuarioValido = true; //PARA TESTES
				//usuarioValido = FisioterapeutaDAO.validar(matricula, senha);
				break;
			case 3:
				usuarioValido = true; //PARA TESTES
				//usuarioValido = ProfessorDAO.validar(matricula, senha);
				break;
			case 4:
				//JOptionPane.showMessageDialog(null, "Aluno");
				usuarioValido = AlunoDAO.validar(matricula, senha);
				break;
			default:
				return false;
			}
			if (usuarioValido)
				return true;
		}
		return false;
	}
	
	public static void realizaProcedimentosLogin(String matricula){
		setNivelDeAcesso(matricula);
		setUsuarioLogado(matricula);
		carregaBaseDeDados();
		inicializaTelaPrincipal();
	}
	
	public static void setUsuarioLogado(String matricula){
		usuarioLogado = matricula;
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
