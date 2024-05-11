package model;

import java.util.List;

public class Disciplina {
	private String nome;
	private Professor doscente;
	private List<Aluno> discentes;
	private List<String> horarios;
    private String sala;
    
	public Disciplina(String nome, Professor doscente, List<Aluno> discentes, List<String> horarios, String sala) {
		super();
		this.nome = nome;
		this.doscente = doscente;
		this.discentes = discentes;
		this.horarios = horarios;
		this.sala = sala;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Professor getDoscente() {
		return doscente;
	}

	public void setDoscente(Professor doscente) {
		this.doscente = doscente;
	}

	public List<Aluno> getDiscentes() {
		return discentes;
	}

	public void setDiscentes(List<Aluno> discentes) {
		this.discentes = discentes;
	}

	public List<String> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<String> horarios) {
		this.horarios = horarios;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}
}
