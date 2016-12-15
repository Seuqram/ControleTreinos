package modelo;

import java.io.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class AlunoDAO extends Aluno implements Serializable{
	private static ArrayList<Aluno> listaDeAlunos = new ArrayList<>();
	public AlunoDAO()
	{
	}
	
	private int geraMatricula()
	{
		String matricula = String.valueOf(listaDeAlunos.size() + 1	);
		matricula =  '4' + matricula;
		return (Integer.parseInt(matricula));
	}
	
	public void cadastraAluno(String nome, String email, String cpf, String data_nasc){
		Aluno novoAluno = new Aluno(nome, email, cpf, data_nasc, geraMatricula());
		listaDeAlunos.add(novoAluno);
		ArquivoXML<Aluno> patati = new ArquivoXML<>("alunos.xml");
		for (int indice = 0; indice < listaDeAlunos.size(); indice++){
			patati.adiciona(listaDeAlunos.get(indice));
		}
		patati.escreveXMLCliente();
	}
	
	public Aluno getAluno(String cpf){
		for (int indice = 0; indice < listaDeAlunos.size(); indice++){
			if (listaDeAlunos.get(indice).getCpf().equals(cpf)){
				return listaDeAlunos.get(indice);
			}
		}
		return null;
	}
	
	public void carregaAlunos()
	{
		ArquivoXML<Aluno> patati = new ArquivoXML<>("alunos.xml");
		patati.leXMLCliente();
		listaDeAlunos = patati.getLista();
	}
	
	public boolean validar(String matriculaEntrada, String senhaEntrada)
	{
		for (int indice = 0; indice < listaDeAlunos.size()-1; indice++){
			if (Integer.parseInt(matriculaEntrada) == listaDeAlunos.get(indice).getMatricula()){
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Aluno> getListaAlunos(){
		return listaDeAlunos;
	}
	
	public String getDataDeNascimento(String cpfDoAluno){
		for (int indice = 0; indice < listaDeAlunos.size(); indice++){
			if (cpfDoAluno.equals(listaDeAlunos.get(indice).getCpf())){
				return listaDeAlunos.get(indice).getDataDeNascimento();
			}
		}
		return "0";
	}
	
	public String getNome(String cpfDoAluno){
		for (int indice = 0; indice < listaDeAlunos.size(); indice++){
			if (cpfDoAluno.equals(listaDeAlunos.get(indice).getCpf())){
				return listaDeAlunos.get(indice).getNome();
			}
		}
		return "0";
	}
	
	public void gravaAlunos(){
		ArquivoXML<Aluno> patati = new ArquivoXML<>("alunos.xml");
		for (int indice = 0; indice < listaDeAlunos.size(); indice++){
			patati.adiciona(listaDeAlunos.get(indice));
		}
		patati.escreveXMLCliente();
	}
	
	public void addAvaliacao(Avaliacao avaliacao, String cpfDoAluno){
		for (int indice = 0; indice < listaDeAlunos.size(); indice++){
			if (listaDeAlunos.get(indice).getCpf().equals(cpfDoAluno)){
				listaDeAlunos.get(indice).addAvaliacao(avaliacao);
			}
		}
		gravaAlunos();
	}
	
}
