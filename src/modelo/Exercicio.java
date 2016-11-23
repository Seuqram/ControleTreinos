package modelo;

import java.io.Serializable;

public class Exercicio implements Serializable{
	
	String nome;
	int repeticoes, series;
	
	public Exercicio(){
		
	}
	
	public Exercicio(String nome, int repeticoes, int series){
		
		this.nome=nome;
		this.repeticoes=repeticoes;
		this.series=series;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getRepeticoes() {
		return repeticoes;
	}

	public void setRepeticoes(int repeticoes) {
		this.repeticoes = repeticoes;
	}

	public int getSeries() {
		return series;
	}

	public void setSeries(int series) {
		this.series = series;
	}

}
