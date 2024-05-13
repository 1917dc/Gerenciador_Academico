package model;

import java.util.HashMap;
import java.util.List;

@SuppressWarnings("serial")
public class Aluno extends Pessoa{
	String curso;
	HashMap<String, Double> notas = new HashMap<String, Double>();
	
	public Aluno(String nome, String cpf, String senha, String curso) {
		super(nome, cpf, senha);
		this.curso = curso;
	}
	
	public String getCurso() {
		return curso;
	}
	
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	public Double getNota(String disciplinaNome) {
		Double nota = 0.0;
		List<Disciplina> disciplinas = ReadFile.getAllDisciplinas();
		
		for (Disciplina disciplina : disciplinas) {
			if (disciplina.getNome().equals(disciplinaNome)) {
				nota = notas.get(disciplinaNome);
			}
		}
		return nota;
	}

	@Override
	public String toString() {
		return "Aluno [curso=" + curso + ", notas=" + notas + "]";
	}

	public void setNota(String nomeDisciplina, Double nota) {
		this.notas.remove(nomeDisciplina);
		this.notas.put(nomeDisciplina, nota);
	}

	public void setNotas(HashMap<String, Double> notas) {
        this.notas = notas;		
	}
}
