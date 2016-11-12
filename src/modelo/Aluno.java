package modelo;

import java.io.Serializable;

public class Aluno extends Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;

	public Aluno(String nome, String email, int cpf, String data_nasc, int matricula) {
		super(nome, email, cpf, data_nasc, matricula);
	}

	public Aluno(){

	}
}
