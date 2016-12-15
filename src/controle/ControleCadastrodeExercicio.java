package controle;

import javax.swing.JOptionPane;
import modelo.ExercicioDAO;

public class ControleCadastrodeExercicio {
	
	public boolean cadastraExercicio(String nome, String descricao) {
		ExercicioDAO novoExercicio = new ExercicioDAO();
		novoExercicio.cadastraExercicio(nome, 0, 0, descricao);
		JOptionPane.showMessageDialog(null, "Exercício cadastrado com sucesso!");
		return true;
	}

}
