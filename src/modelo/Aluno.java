package modelo;
import java.util.ArrayList;
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
	
	public Aluno(String nome, String email, int cpf, String data_nasc, int matricula) {
		
		super(nome, email, cpf, data_nasc, matricula);
		
	}
	
	public Aluno(){
		
	}
	
	public void incluiAluno(String nome, String email, int cpf, String data_nasc, int matricula){
		
		Aluno aluno1 = new Aluno(nome + " 1", email, cpf, data_nasc, matricula);
		Aluno aluno2 = new Aluno(nome + " 2", email, cpf, data_nasc, matricula);
		Aluno aluno3 = new Aluno(nome + " 3", email, cpf, data_nasc, matricula);
		
		ArrayList<Aluno> lista = new ArrayList<>();
		lista.add(aluno1);
		lista.add(aluno2);
		lista.add(aluno3);
		
		try{
			
			XMLEncoder encoder = null;
			
			try{
				
				encoder = new XMLEncoder(new FileOutputStream("alunos.xml"));
				encoder.writeObject(lista);
			} finally {
				if (encoder!=null)
					encoder.close();
			}
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
}
