package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class ProfessorDAO extends Professor implements Serializable{
	private ArrayList<Professor> listaDeProfessores;
	
	public void carregaProfessores(){
		ArquivoXML<Professor> patati = new ArquivoXML<>("professores.xml");
		patati.leXMLCliente();
		listaDeProfessores = patati.getLista();
	}
	
	public void cadastraProfessor(String nome, String email, String cpf, String data_nasc){
		Professor novoProfessor = new Professor(nome, email, cpf, data_nasc, geraMatricula());
		listaDeProfessores.add(novoProfessor);
		ArquivoXML<Professor> patati = new ArquivoXML<>("professores.xml");
		for (int indice = 0; indice < listaDeProfessores.size(); indice++){
			patati.adiciona(listaDeProfessores.get(indice));
		}
		patati.escreveXMLCliente();
	}
	
	public int geraMatricula(){
		String matricula = String.valueOf(listaDeProfessores.size() + 1	);
		matricula =  '4' + matricula;
		return (Integer.parseInt(matricula));
	}
}
