package controller;

import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import model.Disciplina;
import model.Feedback;
import model.Professor;
import model.ReadFile;
import model.WriteFile;

public class DisciplinasDAO {
	private List<Disciplina> fetchAllDisciplinas() {
		return ReadFile.getAllDisciplinas();
	}

	private List<Professor> fetchAllProfessores() {
		return ReadFile.getAllProfessores();
	}

	public static void save(String aluno, String disciplina, Double novaNota) {
		var writeFile = new WriteFile();
		writeFile.changeNota(aluno, disciplina, novaNota);
	}

	public Object[][] getDisciplinasParaTabela(String pessoaLogadaNome) {
		var professores = fetchAllProfessores();
		var disciplinas = fetchAllDisciplinas();
		var disciplinasNova = new ArrayList<Disciplina>();

		Aluno aluno = null;

		for (Aluno a : ReadFile.getAllAlunos()) {
			if (a.getNome().equals(pessoaLogadaNome)) {
				aluno = a;
			}
		}
		
		for (int i = 0; i < disciplinas.size(); i++) {
			if (disciplinas.get(i).getDiscentes().contains(aluno.getNome())) {
				disciplinasNova.add(disciplinas.get(i));
			}
		}

		if (disciplinas != null) {
			Object[][] dados = new Object[disciplinasNova.size()][4];

			for (int i = 0; i < disciplinasNova.size(); i++) {
				dados[i][0] = disciplinasNova.get(i).getNome();
				dados[i][1] = disciplinasNova.get(i).getDoscente();
				dados[i][2] = aluno.getNota(disciplinasNova.get(i).getNome());
				dados[i][3] = disciplinasNova.get(i).getHorarios();
				for (Professor p : professores) {
					if (p.getCpf().equals(disciplinasNova.get(i).getDoscente())) {
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
		for (Professor a : ReadFile.getAllProfessores()) {
			if (a.getNome().equals(pessoaLogadaNome)) {
				disciplinas.removeIf(disciplina -> !disciplina.getDoscente().equals(a.getCpf()));
			}
		}
		
		
		if (disciplinas != null) {
			Object[][] dados = new Object[disciplinas.size()][3];

			for (int i = 0; i < disciplinas.size(); i++) {
				dados[i][0] = disciplinas.get(i).getNome();
				dados[i][1] = disciplinas.get(i).getHorarios();
				dados[i][2] = disciplinas.get(i).getSala();
			}
			return dados;
		}
		return null;
	}

	public String[] getDisciplinasProfessor(String pessoaLogadaCpf) {
		var disciplinas = fetchAllDisciplinas();
		System.out.println(disciplinas.get(0));
		disciplinas.removeIf(disciplinaVerify -> !disciplinaVerify.getDoscente().equals(pessoaLogadaCpf));
		String[] disciplinasNomes = new String[disciplinas.size()];

		for (Disciplina disciplina : disciplinas) {
			disciplinasNomes[disciplinas.indexOf(disciplina)] = disciplina.getNome();
		}

		return disciplinasNomes;
	}

	public String getCpfProfessor(String nome) {
		var professores = fetchAllProfessores();
		for (Professor p : professores) {
			if (p.getNome().equals(nome)) {
				return p.getCpf();
			}
		}
		return null;
	}

	public Object[][] getDisciplinasParaTabelaProfessorNotas(String pessoaLogadaNome, String disciplinaSelecionada) {
		var alunos = ReadFile.getAllAlunos();
		var disciplinas = fetchAllDisciplinas();
		var alunosNova = new ArrayList<Aluno>();
		
		for (Disciplina d : disciplinas) {
			if (d.getNome().equals(disciplinaSelecionada)) {
				for (String discente : d.getDiscentes()) {
					for (Aluno a : alunos) {
						if (a.getNome().equals(discente)) {
							alunosNova.add(a);
						}
					}
				}
			}
		}
		
		if (disciplinas != null) {
			Object[][] dados = new Object[alunosNova.size()][3];
			for (int i = 0; i < alunosNova.size(); i++) {
				dados[i][0] = alunosNova.get(i).getNome();
				dados[i][1] = alunosNova.get(i).getNota(disciplinaSelecionada);
				dados[i][2] = alunosNova.get(i).getCpf();
			}
			
			return dados;
		}
		return null;
	}

	public Object[][] getDisciplinasParaTabelaInscricao(String pessoaLogadaNome) {
		var disciplinas = fetchAllDisciplinas();
		var disciplinasNova = new ArrayList<Disciplina>();
		
		Aluno aluno = null;

		for (Aluno a : ReadFile.getAllAlunos()) {
			if (a.getNome().equals(pessoaLogadaNome)) {
				aluno = a;
			}
		}
		
		for (int i = 0; i < disciplinas.size(); i++) {
			if (!disciplinas.get(i).getDiscentes().contains(aluno.getNome())) {
				disciplinasNova.add(disciplinas.get(i));
			}
		}
		
		if (disciplinasNova != null) {
			Object[][] dados = new Object[disciplinasNova.size()][3];
			for (int i = 0; i < disciplinasNova.size(); i++) {
				dados[i][0] = disciplinasNova.get(i).getNome();
				
				for (Professor p : fetchAllProfessores()) {
					if (p.getCpf().equals(disciplinasNova.get(i).getDoscente())) {
						dados[i][1] = p.getNome();
					}
				}
				
				dados[i][2] = disciplinasNova.get(i).getHorarios();
			}
			return dados;
		}
		return null;
	}

	public void inscreverAluno(String pessoaLogadaNome, String nomeDisciplina) {
		var disciplinas = fetchAllDisciplinas();
		var alunos = ReadFile.getAllAlunos();
		for (Disciplina disciplina : disciplinas) {
			if (disciplina.getNome().equals(nomeDisciplina)) {
				for (Aluno aluno : alunos) {
					if (aluno.getNome().equals(pessoaLogadaNome)) {
						aluno.setNota(nomeDisciplina, 0.0);
						WriteFile.addAlunoDisciplina(aluno.getNome(), disciplina.getNome());
					}
				}
			}
		}

		
		WriteFile.writeAluno(alunos);
	}

	public Object[][] getFeedbacks(String pessoaLogadaNome) {
		List<Feedback> feedbacks = ReadFile.getAllFeedbacks();
		List<Aluno> alunos = ReadFile.getAllAlunos();
		feedbacks.removeIf(feedback -> !feedback.getProfessor().equals(getCpfProfessor(pessoaLogadaNome)));
		
		Object[][] dados = new Object[feedbacks.size()][2];
		
		for (int i = 0; i < feedbacks.size(); i++) {
			String alunoNome = "";
			
			for(Aluno aluno: alunos) {
				if (aluno.getCpf().equals(feedbacks.get(i).getAluno())) {
					alunoNome = aluno.getNome();
				}
			}
			
			dados[i][0] = alunoNome;
			dados[i][1] = feedbacks.get(i).getTitulo();
		}
		
		return dados;
	}
	
	public String getFeedbackBody(int i) {
		List<Feedback> feedbacks = ReadFile.getAllFeedbacks();
		
		return feedbacks.get(i).getCorpo();
	}
	
	public void addFeedback(String alunoNome, String titulo, String corpo, String professorNome) {
		List<Feedback> feedbacks = ReadFile.getAllFeedbacks();
		List<Aluno> alunos = ReadFile.getAllAlunos();
		String alunoCpf = "";
		
		for (Aluno aluno : alunos) {
			if (aluno.getNome().equals(alunoNome)) {
				alunoCpf = aluno.getCpf();
			}
		}
		
		feedbacks.add(new Feedback(alunoCpf, titulo, corpo, getCpfProfessor(professorNome)));
		WriteFile.writeFeedbacks(feedbacks);
	}
}
