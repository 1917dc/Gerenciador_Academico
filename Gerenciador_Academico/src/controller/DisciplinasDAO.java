package controller;

import java.util.List;

import model.Aluno;
import model.Disciplina;
import model.Professor;
import model.ReadFile;
import model.WriteFile;

public class DisciplinasDAO {
	private List<Disciplina> fetchAllDisciplinas() {
		return ReadFile.getAllDisciplinas();
	}
	private List<Professor> fetchAllProfessores(){
		return ReadFile.getAllProfessores();
	}
	public static void save(String aluno){
		WriteFile writeFile = new WriteFile();
		writeFile.writeAluno(aluno);
	}
	public Object[][] getDisciplinasParaTabela(String pessoaLogadaNome) {
		var professores = fetchAllProfessores();
		var disciplinas = fetchAllDisciplinas();
		Aluno aluno = null;
		
		for (Aluno a : ReadFile.getAllAlunos()) {
			if (a.getNome().equals(pessoaLogadaNome)) {
				aluno = a;
			}
		}

		if (disciplinas != null) {
			Object[][] dados = new Object[disciplinas.size()][4];

			for (int i = 0; i < disciplinas.size(); i++) {
				dados[i][0] = disciplinas.get(i).getNome();
				dados[i][1] = disciplinas.get(i).getDoscente();
				dados[i][2] = aluno.getNota(disciplinas.get(i).getNome());
				dados[i][3] = disciplinas.get(i).getHorarios();
				for(Professor p : professores) {
					if(p.getCpf().equals(disciplinas.get(i).getDoscente())) {
						dados[i][1] = p.getNome();
					}
				}
			}

			return dados;
		}
		
		return null;
	}
	public Object[][] getDisciplinasParaTabelaProfessor(String pessoaLogadaNome) {
		var disciplinas = fetchAllDisciplinas();
		Professor professor = null;
		for(Professor a : ReadFile.getAllProfessores()) {
			if(a.getNome().equals(pessoaLogadaNome)) {
				professor = a;
			}
		}
		if(disciplinas != null) {
			Object[][] dados = new Object[disciplinas.size()][3];

			for(int i = 0; i < disciplinas.size(); i++) {
				dados[i][0] = disciplinas.get(i).getNome();
				dados[i][1] = disciplinas.get(i).getHorarios();
				dados[i][2] = disciplinas.get(i).getSala();
			}
			return dados;
		}
		return null;
	}
	public List<Disciplina> getDisciplinasProfessor(String pessoaLogadaCpf){
		var disciplinas = fetchAllDisciplinas();
		disciplinas.removeIf(disciplinaVerify -> !disciplinaVerify.getDoscente().equals(pessoaLogadaCpf));
		return disciplinas;
	}
	public String getCpfProfessor(String nome) {
		var professores = fetchAllProfessores();
		for(Professor p : professores) {
			if(p.getNome().equals(nome)) {
				return p.getCpf();
			}
		}
		return null;
	}

	public Object[][] getDisciplinasParaTabelaProfessorNotas(String pessoaLogadaNome, String disciplinaSelecionada) {
		var alunos = ReadFile.getAllAlunos();
		var disciplinas = fetchAllDisciplinas();
		if (disciplinas != null) {
			Object[][] dados = new Object[alunos.size()][3];
			for (int i = 0; i < alunos.size(); i++) {
				dados[i][0] = alunos.get(i).getNome();
				dados[i][1] = alunos.get(i).getNota(disciplinaSelecionada);
				dados[i][2] = alunos.get(i).getCpf();
			}
			return dados;
		}
		return null;
	}
}
