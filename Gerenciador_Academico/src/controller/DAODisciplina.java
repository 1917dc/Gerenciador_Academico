package controller;

import java.util.List;

import model.Aluno;
import model.Disciplina;
import model.DisciplinaParaLista;
import model.Professor;

public class DAODisciplina implements InterfaceDisciplinas {
	@Override
	public List<Disciplina> fetchAll() {
		return DisciplinaParaLista.getAll();
	}

	@Override
	public void save(String nome, Professor doscente, List<Aluno> discentes, List<String> horarios, String sala) {
		DisciplinaParaLista.save(new Disciplina(nome, doscente, discentes, horarios, sala));
	}
	
	//mesma coisa, olhe a parte de aluno
	@Override
	public void readFile(List<Disciplina> disciplinas) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeFile(List<Disciplina> disciplinas) {
		// TODO Auto-generated method stub
		
	}
}
