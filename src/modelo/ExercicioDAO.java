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
		ArquivoXML<Exercicio> patati = new ArquivoXML<>("exercicios.xml");
		patati.leXMLCliente();
		listaDeExercicios = patati.getLista();
	}
	
	public void cadastraExercicio(String nome, int repeticoes, int serie, String descricao){
		carregaExercicios();
		Exercicio novoExercicio = new Exercicio(nome, descricao, repeticoes, serie);
		listaDeExercicios.add(novoExercicio);
		ArquivoXML<Exercicio> patati = new ArquivoXML<>("exercicios.xml");
		listaDeExercicios.forEach(exercicio -> patati.adiciona(exercicio));
		patati.escreveXMLCliente();
	}
	
	public ArrayList<Exercicio> getExercicios(){
		carregaExercicios();
		return listaDeExercicios;
	}
}
