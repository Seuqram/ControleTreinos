package controle;

import visao.Principal;

public class ControlePrincipal {
	public static int carregaNivelDeAcesso(){
		return ControleSessao.getNivelDeAcesso();
	}
	
	public static void visbilidadeTelaPrincipal(boolean visibilidade)
	{
		Principal.mudaVisibilidade(visibilidade);
	}
}
