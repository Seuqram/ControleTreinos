package visao;

import java.util.ArrayList;

import modelo.Exercicio;
import modelo.ExercicioDAO;

public class ControleMontarTreino {
	public ArrayList<Exercicio> getExercicios(){
		ExercicioDAO a = new ExercicioDAO();
		return a.getExercicios();
	}
}
