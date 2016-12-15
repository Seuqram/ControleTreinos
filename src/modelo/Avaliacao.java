package modelo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Avaliacao implements Serializable{
	Medidas medida;
	String /*nomeDoAluno, */dataDeCadastro, objetivo;
	float peso, altura;
	
	public Avaliacao(){}
	
	public Avaliacao(Medidas medida, 
					 String objetivo, 
					 /*String nomeDoAluno, */
					 String dataDecadastro, 
					 float peso, 
					 float altura){
		this.medida = medida;
		this.objetivo = objetivo;
		//this.nomeDoAluno = nomeDoAluno;
		this.dataDeCadastro = dataDecadastro;
		this.peso = peso;
		this.altura = altura;
	}

	public Medidas getMedida() {
		return medida;
	}

	public void setMedida(Medidas medida) {
		this.medida = medida;
	}

	/*public String getNomeDoAluno() { 
		return nomeDoAluno;
	}

	public void setNomeDoAluno(String nomeDoAluno) {
		this.nomeDoAluno = nomeDoAluno;
	}*/

	public String getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(String dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}
}
