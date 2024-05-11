package controller;

import java.util.List;

import model.Aluno;

public interface InterfaceAluno {
	//essa funcao precisaria ser static, vou comentar pois posso estar errado
	//List<Aluno> fetchAll();
	void save(String nome, String cpf, String senha, String curso);
	void readFile(List<Aluno> alunos);
	void writeFile(List<Aluno> alunos);
}
