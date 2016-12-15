package controle;

import modelo.AlunoDAO;
import visao.PanelLogin;
import visao.TelaPrincipal;

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
				AlunoDAO aluno = new AlunoDAO();
				usuarioValido = aluno.validar(matricula, senha);
				break;
			default:
				return false;
			}
			if (usuarioValido)
				return true;
		}
		return false;
	}
	
	public void realizaProcedimentosLogin(String matricula){
		setNivelDeAcesso(matricula);
		setUsuarioLogado(matricula);
		inicializaTelaPrincipal();
	}
	
	public void realizaProcedimentosLogout(){
		setNivelDeAcesso("0");
		setUsuarioLogado(null);
		PanelLogin login = new PanelLogin(
				(int)(TelaPrincipal.getWidth()), 
				(int)(TelaPrincipal.getHeight()),
				0.5,
				0.4);
		TelaPrincipal.exibePanel(login, login.getPorcentagemWidth(), login.getPorcentagemHeight());
		TelaPrincipal.setLogoutButton(false);
	}
	
	public void setUsuarioLogado(String matricula){
		ControleSessao controleSessao = new ControleSessao();
		controleSessao.setUsuarioLogado(matricula);
	}
	
	public void setNivelDeAcesso(String matricula){
		ControleSessao controleSessao = new ControleSessao();
		controleSessao.setNivelDeAcesso(Character.getNumericValue(matricula.charAt(0)));
	}
	
	public void inicializaTelaPrincipal(){
		ControlePrincipal controlePrincipal = new ControlePrincipal();
		controlePrincipal.inicializaTelaPrincipal();
	}
}
