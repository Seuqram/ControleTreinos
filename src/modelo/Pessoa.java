package modelo;
import java.util.Date;

public class Pessoa {

	String nome;
	String email;
	String data_nasc;
	int cpf;
	int matricula;
	int nivelacesso;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public String getData_nasc() {
		return data_nasc;
	}
	public void setData_nasc(String data_nasc) {
		this.data_nasc = data_nasc;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public int getNivelacesso() {
		return nivelacesso;
	}
	public void setNivelacesso(int nivelacesso) {
		this.nivelacesso = nivelacesso;
	}
	
	public Pessoa(String nome, String email, int cpf, String data_nasc, int matricula, int nivelacesso) {

		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.data_nasc = data_nasc;
		this.matricula = matricula;
		this.nivelacesso = nivelacesso;
	}
	public Pessoa() {
		// TODO Auto-generated constructor stub
	}
}
