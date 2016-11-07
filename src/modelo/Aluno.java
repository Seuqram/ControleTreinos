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
