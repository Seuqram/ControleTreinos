package modelo;

import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

public class AlunoDAO extends Aluno implements Serializable{
	private static ArrayList<Aluno> listaDeAlunos = new ArrayList<>();
	public AlunoDAO()
	{
	}
	
	private static int geraMatricula()
	{
		String matricula = String.valueOf(listaDeAlunos.size() + 1	);
		matricula =  '4' + matricula;
		return (Integer.parseInt(matricula));
	}
	
	public boolean cadastraAluno(String nome, String email, int cpf, String data_nasc){
		carregaAlunos();
		Aluno novoAluno = new Aluno(nome, email, cpf, data_nasc, geraMatricula());
		listaDeAlunos.add(novoAluno);
		try{

			XMLEncoder encoder = null;

			try{

				encoder = new XMLEncoder(new FileOutputStream("alunos.xml"));
				encoder.writeObject(listaDeAlunos);
			} finally {
				if (encoder!=null){
					encoder.close();
					return true;
				}
			}
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public static void carregaAlunos()
	{
		try{
			XMLDecoder decoder = null;
			try{
				decoder = new XMLDecoder(
						new FileInputStream("alunos.xml"));
				ArrayList<Aluno> lista = (ArrayList<Aluno>) decoder.readObject();
				listaDeAlunos = lista;
			} finally {
				if (decoder != null)
					decoder.close();
			}
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public static boolean validar(String matriculaEntrada, String senhaEntrada)
	{
		boolean alunoValido = false;
		Aluno alunoEntrado = null;
		for (int i = 0; i < listaDeAlunos.size()-1; i++){
			alunoEntrado = listaDeAlunos.get(i);
			if (Integer.parseInt(matriculaEntrada) == alunoEntrado.getMatricula())
			{
				alunoValido = true;
				break;
			}
		}
		return alunoValido;
	}
	
}
