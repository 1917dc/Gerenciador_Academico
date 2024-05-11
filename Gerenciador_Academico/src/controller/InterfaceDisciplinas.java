package controller;

import java.util.List;

import model.Aluno;
import model.Disciplina;
import model.Professor;

public interface InterfaceDisciplinas {
	List<Disciplina> fetchAll();
	void save(String nome, Professor doscente, List<Aluno> discentes, List<String> horarios, String sala);
	void readFile(List<Disciplina> disciplinas);
	void writeFile(List<Disciplina> disciplinas);
}
