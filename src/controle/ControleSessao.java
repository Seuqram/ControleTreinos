package controle;

import modelo.AlunoDAO;

public class ControleSessao {
	static int nivelDeAcesso = 0;

	public static int getNivelDeAcesso() {
		return nivelDeAcesso;
	}

	public static void setNivelDeAcesso(int nivelDeAcessoEntrado) {
		nivelDeAcesso = nivelDeAcessoEntrado;
	}
	
	public static void carregaBaseDeDados()
	{
		carregaAlunos();
	}
	
	public static void carregaAlunos()
	{
		AlunoDAO.carregaAlunos();
	}
}
