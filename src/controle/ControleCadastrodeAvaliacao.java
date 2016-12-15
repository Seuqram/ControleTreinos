package controle;

import java.util.ArrayList;
import modelo.Aluno;
import modelo.AlunoDAO;
import modelo.AvaliacaoDAO;

public class ControleCadastrodeAvaliacao {
	ControleSessao controleSessao = new ControleSessao();
	public String[] getAlunos()
	{
		ArrayList<Aluno> arrayDeAlunos = controleSessao.getListaDeAlunos();
		String listaDeAlunos[] = new String[arrayDeAlunos.size()];
		for (int i = 0; i < arrayDeAlunos.size(); i++)
		{
			listaDeAlunos[i] = arrayDeAlunos.get(i).getCpf();
		}
		return listaDeAlunos;
	}
	
	public boolean cadastraAvaliacao(
			String bracoDireito, 
			String bracoEsquerdo, 
			String coxaDireita, 
			String coxaEsquerda,
			String peito, 
			String percentualDeGordura, 
			String objetivo, 
			String cpfDoAluno,
			String peso, 
			String altura){
		
		AvaliacaoDAO novaAvaliacao = new AvaliacaoDAO();
		return novaAvaliacao.cadastraAvaliacao(
				bracoDireito,
				bracoEsquerdo,
				coxaDireita,
				coxaEsquerda,
				peito, 
				percentualDeGordura,
				objetivo, 
				cpfDoAluno,
				peso, 
				altura);
	}
	
	public String getDataDeNascimentoAluno(String cpfDoAluno){
		AlunoDAO aluno = new AlunoDAO();
		return aluno.getDataDeNascimento(cpfDoAluno);
	}
	
	public String getNomeAluno(String cpfDoAluno){
		AlunoDAO aluno = new AlunoDAO();
		return aluno.getNome(cpfDoAluno);
	}
}
