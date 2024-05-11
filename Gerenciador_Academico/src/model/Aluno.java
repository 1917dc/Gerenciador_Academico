package model;

@SuppressWarnings("serial")
public class Aluno extends Pessoa{
	String curso;
	
	public Aluno(String nome, String cpf, String senha, String curso) {
		super(nome, cpf, senha);
		this.curso = curso;
	}
}
