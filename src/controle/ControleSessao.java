package controle;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Aluno;
import modelo.AlunoDAO;
import modelo.AvaliacaoDAO;
import modelo.Pessoa;

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
		carregaFisioterapeutas();
		carregaAvaliacoes();
	}

	public static void carregaAlunos()
	{
		AlunoDAO.carregaAlunos();
	}

	public static void carregaFisioterapeutas()
	{
		//FisioterapeutaDAO.carregaFisioterapeutas();
	}

	public static ArrayList<Aluno> getListaDeAlunos()
	{
		return AlunoDAO.getListaAlunos();
	}

	public static void carregaAvaliacoes(){
		AvaliacaoDAO.carregaAvaliacoes();
	}
	
	public static String getIdadeAluno(String nomeDoAluno){
		return AlunoDAO.getIdadeAluno(nomeDoAluno);
	}
}
