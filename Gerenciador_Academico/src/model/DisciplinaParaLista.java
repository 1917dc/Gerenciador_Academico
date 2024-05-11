package model;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaParaLista {
	private static List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	public static List<Disciplina> getAll() {
		return disciplinas;
	}

	public static void save(Disciplina disciplina) {
        disciplinas.add(disciplina);		
	}
}
