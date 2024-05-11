package controller;

import model.Aluno;
import model.AlunoParaLista;
import model.Pessoa;
import model.Professor;
import model.ProfessorParaLista;

public class ChecarLogin {
	
	Pessoa pessoaLogada = null;
	
	public boolean logar(String cpf, String senha) {
		for (Aluno aluno : AlunoParaLista.getAll()) {
			if (aluno.getCpf().equals(cpf) && aluno.getSenha().equals(senha)) {
				
				pessoaLogada = aluno;
				
				return true;
			}
		}
		
		for (Professor professor : ProfessorParaLista.getAll()) {
			if (professor.getCpf().equals(cpf) && professor.getSenha().equals(senha)) {
				
				pessoaLogada = professor;
				
				return true;
			}
		}
		
		return false;
	}
}
