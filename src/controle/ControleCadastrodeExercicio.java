package controle;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Aluno;
import modelo.Exercicio;
import modelo.ExercicioDAO;
import modelo.Medidas;

public class ControleCadastrodeExercicio {
	
	public static boolean cadastraExercicio(String nome, int repeticoes, int series) {
		ExercicioDAO novoExercicio = new ExercicioDAO();
		novoExercicio.cadastraExercicio(nome, repeticoes, series);
		JOptionPane.showMessageDialog(null, "Exercício cadastrado com sucesso!");
		return true;
	}

}
