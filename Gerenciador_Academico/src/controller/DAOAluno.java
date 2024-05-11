package controller;

import java.util.List;

import model.Aluno;
import model.AlunoParaLista;

public class DAOAluno implements InterfaceAluno {
	
	public List<Aluno> fetchAll() {
		return AlunoParaLista.getAll();
	}

	@Override
	public void save(String nome, String cpf, String senha, String curso) {
		AlunoParaLista.save(new Aluno(nome, cpf, senha, curso));
	}

	//essas funções n deviam estar em controller
	@Override
	public void readFile(List<Aluno> alunos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeFile(List<Aluno> alunos) {
		// TODO Auto-generated method stub
		
	}

}
