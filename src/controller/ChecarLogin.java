package controller;

import model.Aluno;
import model.Pessoa;
import model.Professor;
import model.ReadFile;

public class ChecarLogin {
	
	Pessoa pessoaLogada = null;
	
	public boolean logar(String cpf, String senha) {
		for (Aluno aluno : ReadFile.getAllAlunos()) {
			if (aluno.getCpf().equals(cpf) && aluno.getSenha().equals(senha)) {
				
				pessoaLogada = aluno;
				
				return true;
			}
		}
		
		for (Professor professor : ReadFile.getAllProfessores()) {
			if (professor.getCpf().equals(cpf) && professor.getSenha().equals(senha)) {
				
				pessoaLogada = professor;
				
				return true;
			}
		}
		
		return false;
	}

	public Pessoa getPessoaLogada() {
		return pessoaLogada;
	}

	public boolean checarTipo() {
		return pessoaLogada instanceof Aluno;
	}
}
