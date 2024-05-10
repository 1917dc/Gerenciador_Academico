package model;

public class Aluno extends Pessoa{
	private String curso;
	public Aluno(String nome, String cpf, String senha, String curso) {
		super(nome, cpf, senha);
		// TODO Auto-generated constructor stub
		setCurso(curso);
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
}
