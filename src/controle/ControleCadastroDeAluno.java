package controle;

import modelo.AlunoDAO;

public class ControleCadastroDeAluno {
	ControlePrincipal controlePrincipal = new ControlePrincipal();
	public void cadastrarAluno(String nome, String email, String cpf, String dataDeNascimento)
	{
		AlunoDAO novoAluno = new AlunoDAO();
		novoAluno.cadastraAluno(nome, email, cpf, dataDeNascimento);
	}
	
	public void setVisibilidadeTelaPrincipal(boolean visibilidade)
	{
		controlePrincipal.setVisibilidade(visibilidade);
	}
}
