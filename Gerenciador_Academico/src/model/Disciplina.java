<<<<<<< HEAD
package model;

import java.util.List;

public class Disciplina {
	private String nome;
	private Professor doscente;
	private List<Aluno> discentes;
	private List<String> horarios;
    private String sala;
}
=======
package model;

import java.util.List;

public class Disciplina {
	private String nome;
	private String doscente;
	private List<String> discentes;
	private String horarios;
    private String sala;
    
	public Disciplina(String nome, String doscente,String horarios, String sala, List<String> discentes) {
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

	public String getDoscente() { return doscente; }

	public void setDoscente(String doscente) {
		this.doscente = doscente;
	}

	public List<String> getDiscentes() {
		return discentes;
	}

	public void setDiscentes(List<String> discentes) {
		this.discentes = discentes;
	}

	public String getHorarios() {
		return horarios;
	}

	public void setHorarios(String horarios) {
		this.horarios = horarios;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	@Override
	public String toString() {
		return "Disciplina{" +
				"nome='" + nome + '\'' +
				", doscente=" + doscente +
				", discentes=" + discentes +
				", horarios='" + horarios + '\'' +
				", sala='" + sala + '\'' +
				'}';
	}
	
	public void addDiscente(String discente) {
		this.discentes.add(discente);
    }
}
>>>>>>> branch-leo
