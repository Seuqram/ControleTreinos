package controle;

import java.util.ArrayList;

import modelo.AlunoDAO;
import modelo.Avaliacao;
import modelo.Aluno;

public class ControleVisualizacaoDeAvaliacao{
	public String getNomeAluno(String cpfEntrado){
		AlunoDAO aluno = new AlunoDAO();
		return aluno.getNome(cpfEntrado);
	}
	
	public String getDataDeNascimentoAluno(String cpfDoAluno){
		AlunoDAO aluno = new AlunoDAO();
		return aluno.getDataDeNascimento(cpfDoAluno);
	}
	
	public ArrayList<Avaliacao> getAvaliacoes(String cpfDoAluno){
		AlunoDAO alunoDAO = new AlunoDAO();
		Aluno aluno = alunoDAO.getAluno(cpfDoAluno);
		return aluno.getAvaliacoes();
	}
}
