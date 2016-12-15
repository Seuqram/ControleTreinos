package modelo;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Aluno extends Pessoa implements Serializable{
	ArrayList<Avaliacao> avaliacoes;

	public Aluno(String nome, String email, String cpf, String data_nasc, int matricula) {
		super(nome, email, cpf, data_nasc, matricula);
		avaliacoes = new ArrayList<>();
	}

	public Aluno(){

	}
	
	public void addAvaliacao(Avaliacao avaliacao){
		avaliacoes.add(avaliacao);
	}

	public ArrayList<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(ArrayList<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
}
