package controle;

import modelo.AlunoDAO;

public class ControleCadastroDeAluno {
	public static boolean cadastrarAluno(String nome, String email, String cpf, String dataDeNascimento)
	{
		AlunoDAO novoAluno = new AlunoDAO();
		return novoAluno.cadastraAluno(nome, email, Integer.parseInt(cpf), dataDeNascimento);
	}
}
