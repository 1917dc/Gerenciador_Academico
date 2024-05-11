package model;

import java.util.ArrayList;
import java.util.List;

public abstract class AlunoParaLista {
	static List<Aluno> alunos = new ArrayList<Aluno>();
	
	public static List<Aluno> getAll() {
		return alunos;
	}

	public static void save(Aluno aluno) {
        alunos.add(aluno);		
	}

}
