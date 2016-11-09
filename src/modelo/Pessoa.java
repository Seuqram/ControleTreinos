package modelo;

public class Pessoa {

	String nome;
	String email;
	String data_nasc;
	int cpf;
	int matricula;
	
	
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
	
	
	public Pessoa(String nome, String email, int cpf, String data_nasc, int matricula) {

		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.data_nasc = data_nasc;
		this.matricula = matricula;
		
	}
	public Pessoa() {
		// TODO Auto-generated constructor stub
	}
}