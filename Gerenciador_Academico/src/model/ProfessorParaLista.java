package model;

import java.util.ArrayList;
import java.util.List;

public abstract class ProfessorParaLista {
	private static List<Professor> professores = new ArrayList<Professor>();
	
	public static List<Professor> getAll() {
		return professores;
	}

	public static void save(Professor professor) {
		professores.add(professor);
	}
}
