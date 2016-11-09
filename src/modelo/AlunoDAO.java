package modelo;

import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

public class AlunoDAO extends Aluno implements Serializable{
	public AlunoDAO()
	{
		
	}
	public void incluiAluno(String nome, String email, int cpf, String data_nasc/*, int matricula*/){

		ArrayList<Aluno> listaDeAlunos = carregaAlunos();
		Aluno novoAluno = new Aluno(nome, email, cpf, data_nasc/*, matricula*/, (41 + listaDeAlunos.size()));
		listaDeAlunos.add(novoAluno);
		try{

			XMLEncoder encoder = null;

			try{

				encoder = new XMLEncoder(new FileOutputStream("alunos.xml"));
				encoder.writeObject(listaDeAlunos);
			} finally {
				if (encoder!=null)
					encoder.close();
			}
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public static ArrayList<Aluno> carregaAlunos()
	{
		try{
			XMLDecoder decoder = null;
			try{
				decoder = new XMLDecoder(
						new FileInputStream("alunos.xml"));
				ArrayList<Aluno> lista = (ArrayList<Aluno>) decoder.readObject();
				return lista;
			} finally {
				if (decoder != null)
					decoder.close();
			}
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static boolean validar(String matriculaEntrada, String senhaEntrada)
	{
		boolean alunoValido = false, gambiarraFimDoWhile = false;
		ArrayList<Aluno> listaDeAlunos= carregaAlunos();
		/*************
		 * GAMBIARRA *
		 *************/
		Aluno gambiarra = null;
		int i = 0;
		do{
			gambiarra = listaDeAlunos.get(i);
			if (Integer.parseInt(matriculaEntrada) == gambiarra.getMatricula())
			{
				alunoValido = true;
				gambiarraFimDoWhile = true;
			}
			/******************
			 * SUPER GAMBIARRA*
			 ******************/
			if (i == listaDeAlunos.size()-1)
				gambiarraFimDoWhile = true;
			else
				i++;
		}while(!gambiarraFimDoWhile);
		return alunoValido;
	}
	
}
