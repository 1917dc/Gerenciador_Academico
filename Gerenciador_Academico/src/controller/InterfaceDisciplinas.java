package controller;

import java.util.List;

import model.Disciplina;

public interface InterfaceDisciplinas {
	List<Disciplina> fetchAll();
	void readFile(List<Disciplina> disciplinas);
	void writeFile(List<Disciplina> disciplinas);
	void save(Disciplina disciplina);
}
