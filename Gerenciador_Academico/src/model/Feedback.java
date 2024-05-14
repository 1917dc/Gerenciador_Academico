package model;

public class Feedback {
	private String aluno;
	private String professor;
	private String titulo;
	private String corpo;

	public Feedback(String aluno, String titulo, String corpo, String professor) {
		super();
		this.aluno = aluno;
		this.titulo = titulo;
		this.setCorpo(corpo);
		this.professor = professor;
	}

	public String getAluno() {
		return aluno;
	}

	public void setAluno(String aluno) {
		this.aluno = aluno;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String feedback) {
		this.titulo = feedback;
	}

	@Override
	public String toString() {
		return "Feedback [aluno=" + aluno + ", disciplina=" + professor + ", feedback=" + titulo + "]";
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}
}
