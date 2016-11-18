package controle;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Aluno;
import modelo.Avaliacao;
import modelo.AvaliacaoDAO;
import modelo.Medidas;

public class ControleCadastrodeAvaliacao {
	
	public static String[] getAlunos()
	{
		ArrayList<Aluno> arrayDeAlunos = ControleSessao.getListaDeAlunos();
		String listaDeAlunos[] = new String[arrayDeAlunos.size()];
		Aluno alunoDaLista = new Aluno();
		for (int i = 0; i < arrayDeAlunos.size(); i++)
		{
			alunoDaLista = arrayDeAlunos.get(i);
			listaDeAlunos[i] = alunoDaLista.getNome();
		}
		return listaDeAlunos;
	}
	
	public static void cadastraAvaliacao(float bracoDireito, float bracoEsquerdo, float coxaDireita, float coxaEsquerda, 
										 float peito, float percentualDeGordura, String objetivo, String nomeDoAluno,
										 String dataDeCadastro,	int idade, 	float peso, float altura){
		JOptionPane.showMessageDialog(null, 1);
		Medidas medida = new Medidas(bracoDireito, bracoEsquerdo, coxaDireita, coxaEsquerda, peito, percentualDeGordura);
		JOptionPane.showMessageDialog(null, 2);
		AvaliacaoDAO novaAvaliacao = new AvaliacaoDAO();
		//Avaliacao novaAvaliacao = new Avaliacao(medida, objetivo, nomeDoAluno, dataDeCadastro, idade, peso, altura);
		novaAvaliacao.cadastraAvaliacao(medida, objetivo, nomeDoAluno, dataDeCadastro, idade, peso, altura);
	}
	
	public static String getIdadeAluno(String nomeDoAluno){
		return ControleSessao.getIdadeAluno(nomeDoAluno);
	}
}
