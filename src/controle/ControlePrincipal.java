package controle;

public class ControlePrincipal {
	public static int carregaNivelDeAcesso(){
		return ControleSessao.getNivelDeAcesso();
	}
}
