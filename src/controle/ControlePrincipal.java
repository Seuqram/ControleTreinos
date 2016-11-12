package controle;

import visao.Principal;

public class ControlePrincipal {
	public static int getNivelDeAcesso(){
		return ControleSessao.getNivelDeAcesso();
	}
	
	public static void setVisibilidade(boolean visibilidade)
	{
		Principal.setVisibilidade(visibilidade);
	}
	
	public static void inicializaTelaPrincipal()
	{
		Principal.setVisibilidade(true);
		Principal.setInterface();
	}
}
