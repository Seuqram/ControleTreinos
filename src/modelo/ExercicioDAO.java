package modelo;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class ExercicioDAO extends Exercicio implements Serializable {

	static ArrayList<Exercicio> listaDeExercicios = new ArrayList<>();
	public ExercicioDAO(){}
	
	public static void carregaExercicios(){
		try{
			XMLDecoder decoder = null;
			try{
				decoder = new XMLDecoder(
						new FileInputStream("exercicios.xml"));
				ArrayList<Exercicio> lista = (ArrayList<Exercicio>) decoder.readObject();
				listaDeExercicios = lista;
			} finally {
				if (decoder != null)
					decoder.close();
			}
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public boolean cadastraExercicio(String nome, int repeticoes, int series){
		carregaExercicios();
		Exercicio novoExercicio = new Exercicio(nome, repeticoes, series);
		listaDeExercicios.add(novoExercicio);
		try{

			XMLEncoder encoder = null;

			try{

				encoder = new XMLEncoder(new FileOutputStream("exercicios.xml"));
				encoder.writeObject(listaDeExercicios);
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
	
}
