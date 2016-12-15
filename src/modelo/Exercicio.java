package modelo;

import java.io.Serializable;

public class Exercicio implements Serializable{
	
	String nome, descricao;
	int repeticoes, serie;
	
	public Exercicio(){
		
	}
	
	public Exercicio(String nome, String descricao, int repeticoes, int serie) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.repeticoes = repeticoes;
		this.serie = serie;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getRepeticoes() {
		return repeticoes;
	}

	public void setRepeticoes(int repeticoes) {
		this.repeticoes = repeticoes;
	}

	public int getSerie() {
		return serie;
	}

	public void setSerie(int serie) {
		this.serie = serie;
	}

}
