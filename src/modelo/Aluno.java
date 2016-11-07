package modelo;
import java.util.Date;
import java.io.*;
import java.beans.XMLEncoder;

public class Aluno extends Pessoa implements Serializable{
	
/*  	String nome;
  	String email;
  	int cpf;
  	String data_nasc;
  	int matricula;
  	int nivelacesso;*/
	
	/*public Aluno(String nome, String email, int cpf, String data_nasc, int matricula, int nivelacesso) {
		
		super(nome, email, cpf, data_nasc, matricula, nivelacesso);
		
	}*/
	
  	public Aluno(String nome, String email, int cpf, String data_nasc, int matricula, int nivelacesso){
  		this.nome=nome;
  		this.email = email;
  		this.cpf = cpf;
  		this.data_nasc = data_nasc;
  		this.matricula = matricula;
  		this.nivelacesso = nivelacesso;
  	}
	
	public Aluno(){
		
	}

/*	public String getNome() {
		return nome;
	}*/

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(String data_nasc) {
		this.data_nasc = data_nasc;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public int getNivelacesso() {
		return nivelacesso;
	}

	public void setNivelacesso(int nivelacesso) {
		this.nivelacesso = nivelacesso;
	}
	
	public void incluiAluno(String nome, String email, int cpf, String data_nasc, int matricula, int nivelacesso ){
		Aluno aluno = new Aluno();
		aluno = new Aluno(nome, email, cpf, data_nasc, matricula, nivelacesso);
		System.out.println(aluno.getNome());
		
		try{
			
			XMLEncoder encoder = null;
			
			try{
				
				encoder = new XMLEncoder(new FileOutputStream("alunos.xml"));
				encoder.writeObject(aluno);
			} finally {
				if (encoder!=null)
					encoder.close();
			}
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
	
}
