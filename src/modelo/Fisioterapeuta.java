package modelo;
import java.util.Date;

public class Fisioterapeuta extends Pessoa {
	
public Fisioterapeuta(String nome, String email, int cpf, String data_nasc, int matricula, int nivelacesso) {
		
		super(nome, email, cpf, data_nasc, matricula, nivelacesso);
		
	}

	String especialidade;
	
}
