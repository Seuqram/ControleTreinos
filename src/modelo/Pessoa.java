package modelo;

public class Pessoa {

	String nome;
	String email;
	String dataDeNascimento;
	String cpf;
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	
	public Pessoa(String nome, String email, String cpf, String data_nasc, int matricula) {

		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataDeNascimento = data_nasc;
		this.matricula = matricula;
		
	}
	public Pessoa() {
		// TODO Auto-generated constructor stub
	}
}