package modelo;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@SuppressWarnings("serial")
public class AvaliacaoDAO extends Avaliacao implements Serializable{
	static ArrayList<Avaliacao> listaDeAvaliacoes = new ArrayList<>();
	public AvaliacaoDAO(){}
	
	public static void carregaAvaliacoes(){
	}
	
	public boolean cadastraAvaliacao(
			String bracoDireito, 
			String bracoEsquerdo, 
			String coxaDireita, 
			String coxaEsquerda,
			String peito, 
			String percentualDeGordura, 
			String objetivo, 
			String cpfDoAluno,
			String peso, 
			String altura){
		Medidas medida = new Medidas(
				converteMedidaCmGorduraParaFloat(bracoDireito), 
				converteMedidaCmGorduraParaFloat(bracoEsquerdo), 
				converteMedidaCmGorduraParaFloat(coxaDireita), 
				converteMedidaCmGorduraParaFloat(coxaEsquerda), 
				converteMedidaCmGorduraParaFloat(peito), 
				converteMedidaCmGorduraParaFloat(percentualDeGordura)
				);
		Avaliacao novaAvaliacao = new Avaliacao(
				medida, 
				objetivo,  
				getDataDeHoje(),
				converteMedidaPesoParaFloat(peso), 
				converteMedidaAlturaParaFloat(altura));
		AlunoDAO aluno = new AlunoDAO();
		aluno.addAvaliacao(novaAvaliacao, cpfDoAluno);
		return true;
	}
	
	private String getDataDeHoje(){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	private float converteMedidaCmGorduraParaFloat(String medidaEntrada){
		int antesDaVirgula = 0, depoisDaVirgula = 0;
		antesDaVirgula = Character.getNumericValue(medidaEntrada.charAt(0)) * 10;
		antesDaVirgula = antesDaVirgula + Character.getNumericValue(medidaEntrada.charAt(1));
		depoisDaVirgula = Character.getNumericValue(medidaEntrada.charAt(3)) * 10;
		depoisDaVirgula = depoisDaVirgula + Character.getNumericValue(medidaEntrada.charAt(4));
		float medida =  ((float)(depoisDaVirgula)) / 100;
		medida = medida + (float) antesDaVirgula;
		return medida;
	}
	
	private float converteMedidaAlturaParaFloat(String medidaEntrada){
		int antesDaVirgula = 0, depoisDaVirgula = 0;
		antesDaVirgula = Character.getNumericValue(medidaEntrada.charAt(0));
		depoisDaVirgula = Character.getNumericValue(medidaEntrada.charAt(2)) * 10;
		depoisDaVirgula = depoisDaVirgula + Character.getNumericValue(medidaEntrada.charAt(3));
		float medida =  ((float)(depoisDaVirgula)) / 100;
		medida = medida + (float) antesDaVirgula;
		return medida;
	}
	
	private float converteMedidaPesoParaFloat(String medidaEntrada){
		int antesDaVirgula = 0, depoisDaVirgula = 0;
		antesDaVirgula = Character.getNumericValue(medidaEntrada.charAt(0)) * 100;
		antesDaVirgula = antesDaVirgula + (Character.getNumericValue(medidaEntrada.charAt(1)) * 10);
		antesDaVirgula = antesDaVirgula + Character.getNumericValue(medidaEntrada.charAt(2));
		depoisDaVirgula = Character.getNumericValue(medidaEntrada.charAt(4)) * 10;
		depoisDaVirgula = depoisDaVirgula + Character.getNumericValue(medidaEntrada.charAt(5));
		float medida =  ((float)(depoisDaVirgula)) / 100;
		medida = medida + (float) antesDaVirgula;
		return medida;
	}

}
