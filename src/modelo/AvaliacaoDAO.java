package modelo;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class AvaliacaoDAO extends Avaliacao implements Serializable{
	static ArrayList<Avaliacao> listaDeAvaliacoes = new ArrayList<>();
	public AvaliacaoDAO(){}
	
	public static void carregaAvaliacoes(){
		try{
			XMLDecoder decoder = null;
			try{
				decoder = new XMLDecoder(
						new FileInputStream("avaliacoes.xml"));
				ArrayList<Avaliacao> lista = (ArrayList<Avaliacao>) decoder.readObject();
				listaDeAvaliacoes = lista;
			} finally {
				if (decoder != null)
					decoder.close();
			}
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public boolean cadastraAvaliacao(Medidas medida, String objetivo, String nomeDoAluno, String dataDecadastro,
			int idade, float peso, float altura){
		carregaAvaliacoes();
		Avaliacao novaAvaliacao = new Avaliacao(medida, objetivo, nomeDoAluno, dataDecadastro,
				idade, peso, altura);
		listaDeAvaliacoes.add(novaAvaliacao);
		try{

			XMLEncoder encoder = null;

			try{

				encoder = new XMLEncoder(new FileOutputStream("avaliacoes.xml"));
				encoder.writeObject(listaDeAvaliacoes);
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
