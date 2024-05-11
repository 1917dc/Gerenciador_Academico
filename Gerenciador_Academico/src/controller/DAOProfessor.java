package controller;

import java.util.List;

import model.Professor;
import model.ProfessorParaLista;

public abstract class DAOProfessor implements InterfaceProfessor{
	public List<Professor> fetchAll() {
		return ProfessorParaLista.getAll();
	}

	@Override
	public void save(String nome, String cpf, String senha) {
		ProfessorParaLista.save(new Professor(nome, cpf, senha));
	}
	

	//mesma coisa aq
	@Override
	public void readFile(List<Professor> professores) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeFile(List<Professor> professores) {
		// TODO Auto-generated method stub
		
	}

}
