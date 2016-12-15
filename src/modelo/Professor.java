package modelo;

import java.io.Serializable;

public class Professor extends Pessoa implements Serializable{
	public Professor(String nome, String email, String cpf, String data_nasc, int matricula) {
		super(nome, email, cpf, data_nasc, matricula);
	}
	
	public Professor(){}
}
