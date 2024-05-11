package controller;

import java.util.List;

import model.Professor;

public interface InterfaceProfessor {
	List<Professor> fetchAll();
	void save(String nome, String cpf, String senha);
	void readFile(List<Professor> professores);
	void writeFile(List<Professor> professores);
}
