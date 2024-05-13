package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFile {
	// leo
	static String pathAlunos = "/Users/leozi/git/CodeTogether/Gerenciador_Academico/Gerenciador_Academico/src/alunos.txt";
	static String pathProfessores = "/Users/leozi/git/CodeTogether/Gerenciador_Academico/Gerenciador_Academico/src/professores.txt";
	static String pathDisciplinas = "/Users/leozi/git/CodeTogether/Gerenciador_Academico/Gerenciador_Academico/src/disciplinas.txt";

	// luiz
	//static String pathAlunos = "/home/lua/Documents/GitHub/Gerenciador_Academico/Gerenciador_Academico/src/alunos.txt";
	//static String pathProfessores = "/home/lua/Documents/GitHub/Gerenciador_Academico/Gerenciador_Academico/src/professores.txt";
	//static String pathDisciplinas = "/home/lua/Documents/GitHub/Gerenciador_Academico/Gerenciador_Academico/src/disciplinas.txt";

	// alunos
	public static List<Aluno> getAllAlunos() {
		List<String> linesList;
		List<Aluno> alunosList = new ArrayList<>();
		try (Stream<String> lines = Files.lines(Paths.get(pathAlunos))) {
			linesList = lines.collect(Collectors.toList());

		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		for (String aluno : linesList) {
			String[] alunoSplit = aluno.split("-")[0].split(",");
			HashMap<String, Double> notas = new HashMap<String, Double>();
			Aluno a = new Aluno(alunoSplit[0], alunoSplit[1], alunoSplit[2], alunoSplit[3]);
			
			if (aluno.split("-").length > 1) {
				String[] notasSplit = aluno.split("-")[1].split(",");
				
				for (int i = 0; i < notasSplit.length; i++) {
					notas.put(notasSplit[i].split("=")[0], Double.parseDouble(notasSplit[i].split("=")[1]));
				}
				
				a.setNotas(notas);
			}
			

			
			alunosList.add(a);
		}

		return alunosList;
	}

	// disciplinas
	public static List<Disciplina> getAllDisciplinas() {
		List<String> linesList;
		List<Disciplina> disciplinasList = new ArrayList<>();
		try (Stream<String> lines = Files.lines(Paths.get(pathDisciplinas))) {
			linesList = lines.collect(Collectors.toList());

		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		for (String disciplina : linesList) {
			String discentesSplitInfo = disciplina.split("-")[0];
			String disciplinaSplitDiscentes = disciplina.split("-")[1];
			String[] discentesSplitInfoVirgula = discentesSplitInfo.split(",");
			List<String> discentes = new ArrayList<>();
			for (String discente : disciplinaSplitDiscentes.split(",")) {
				discentes.add(discente);
			}

			for (Professor professor : getAllProfessores()) {
				if (professor.getCpf().equals(discentesSplitInfoVirgula[1])) {
					Disciplina a = new Disciplina(discentesSplitInfoVirgula[0], professor.getCpf(), discentesSplitInfoVirgula[2], discentesSplitInfoVirgula[3], discentes);
					disciplinasList.add(a);
				}
			}
			
		}

		return disciplinasList;
	}

	public static List<Professor> getAllProfessores() {
		List<String> linesList;
		List<Professor> professorList = new ArrayList<>();
		try (Stream<String> lines = Files.lines(Paths.get(pathProfessores))) {
			linesList = lines.collect(Collectors.toList());

		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		for (String professor : linesList) {
			String[] professorSplit = professor.split(",");
			Professor a = new Professor(professorSplit[0], professorSplit[1], professorSplit[2]);
			professorList.add(a);
		}
		return professorList;
	}
}
