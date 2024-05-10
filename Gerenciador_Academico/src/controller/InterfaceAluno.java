package controller;

import java.util.List;

import model.Aluno;

public interface InterfaceAluno {
	List<Aluno> fetchAll();
	void save(Aluno aluno);
	void readFile(List<Aluno> alunos);
	void writeFile(List<Aluno> alunos);
}
