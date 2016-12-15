package controle;

import java.util.ArrayList;

import modelo.Aluno;
import modelo.AlunoDAO;
import modelo.AvaliacaoDAO;

public class ControleSessao {
	static int nivelDeAcesso = 0;
	AlunoDAO aluno = new AlunoDAO();
	String usuarioLogado = null;
	public int getNivelDeAcesso() {
		return nivelDeAcesso;
	}

	public void setNivelDeAcesso(int nivelDeAcessoEntrado) {
		nivelDeAcesso = nivelDeAcessoEntrado;
	}
	
	public void setUsuarioLogado(String matricula){
		usuarioLogado = matricula;
	}

	public void carregaBaseDeDados()
	{
		carregaAlunos();
		carregaFisioterapeutas();
		carregaAvaliacoes();
	}

	public void carregaAlunos()
	{
		aluno.carregaAlunos();
	}

	public void carregaFisioterapeutas()
	{
		//FisioterapeutaDAO.carregaFisioterapeutas();
	}

	public ArrayList<Aluno> getListaDeAlunos()
	{
		return aluno.getListaAlunos();
	}

	public void carregaAvaliacoes(){
		AvaliacaoDAO.carregaAvaliacoes();
	}
}
