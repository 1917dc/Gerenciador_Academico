package controller;

import java.util.List;

import model.Professor;

public interface InterfaceProfessor {
	List<Professor> fetchAll();
	void save(Professor professor);
	void readFile(List<Professor> professores);
	void writeFile(List<Professor> professores);
}
