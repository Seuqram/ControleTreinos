package modelo;

import java.io.*;
import java.util.ArrayList;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

public class AlunoDAO extends Aluno implements Serializable{
	public AlunoDAO()
	{
		
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
	
	public /*ArrayList<Aluno>*/ void carregaAlunos()
	{
		Aluno[] alunos = new Aluno[3];
		System.out.println("eeeeeee");
		try{
			XMLDecoder decoder = null;
			try{
				decoder = new XMLDecoder(
						new FileInputStream("alunos.xml"));
				
				alunos = (Aluno[]) decoder.readObject();//ESSA LINHA NÃO ESTÁ FUNCIONANDO
				System.out.println("Alunos lidos: " + alunos.length);
				for (Aluno a : alunos)
					System.out.println(a.getNome());
			} finally {
				if (decoder != null)
					decoder.close();
			}
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
	
}
