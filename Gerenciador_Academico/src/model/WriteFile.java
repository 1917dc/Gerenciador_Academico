package model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class WriteFile {

	// leo
//	static String pathAlunos = "/Users/leozi/git/CodeTogether/Gerenciador_Academico/Gerenciador_Academico/src/alunos.txt";
//	static String pathProfessores = "/Users/leozi/git/CodeTogether/Gerenciador_Academico/Gerenciador_Academico/src/professores.txt";
//	static String pathDisciplinas = "/Users/leozi/git/CodeTogether/Gerenciador_Academico/Gerenciador_Academico/src/disciplinas.txt";

	// luiz
	 static String pathAlunos =
	 "/home/lua/Documents/GitHub/Gerenciador_Academico/Gerenciador_Academico/src/alunos.txt";
	 static String pathProfessores =
	 "/home/lua/Documents/GitHub/Gerenciador_Academico/Gerenciador_Academico/src/professores.txt";
	 static String pathDisciplinas =
	 "/home/lua/Documents/GitHub/Gerenciador_Academico/Gerenciador_Academico/src/disciplinas.txt";

	public void writeAluno(Aluno aluno) {
		var alunos = ReadFile.getAllAlunos();
		try (FileOutputStream fos = new FileOutputStream(
				pathAlunos)) {
			alunos.removeIf(a -> a.getCpf().equals(aluno.getCpf()));
			for (Aluno alunosWrite : alunos) {
				String linha = alunosWrite.getNome() + "," + alunosWrite.getCpf() + "," + alunosWrite.getSenha() + ","
						+ alunosWrite.getCurso() + "-";
				for (int i = 0; i < alunosWrite.notas.size(); i++) {
					if (i == alunosWrite.notas.size() - 1) {
						String key = alunosWrite.notas.keySet().toArray()[i].toString();
						linha += key + "=" + alunosWrite.notas.get(key) + "\n";
					} else {
						String key = alunosWrite.notas.keySet().toArray()[i].toString();
						linha += key + "=" + alunosWrite.notas.get(key) + ",";
					}
				}

				System.out.println(linha);
				fos.write(linha.getBytes("UTF-8"));
			}
		} catch (IOException e) {

		}
	}

	public static void writeAluno(List<Aluno> alunos) {
		try (FileOutputStream fos = new FileOutputStream(
				pathAlunos)) {
			for (Aluno alunosWrite : alunos) {
				String linha = alunosWrite.getNome() + "," + alunosWrite.getCpf() + "," + alunosWrite.getSenha() + ","
						+ alunosWrite.getCurso() + "-";
				for (int i = 0; i < alunosWrite.notas.size(); i++) {
					if (i == alunosWrite.notas.size() - 1) {
						String key = alunosWrite.notas.keySet().toArray()[i].toString();
						linha += key + "=" + alunosWrite.notas.get(key) + "\n";
					} else {
						String key = alunosWrite.notas.keySet().toArray()[i].toString();
						linha += key + "=" + alunosWrite.notas.get(key) + ",";
					}
				}

				fos.write(linha.getBytes("UTF-8"));
			}
		} catch (IOException e) {

		}

	}

	public static void changeNota(String aluno, String disciplina, Double notaNova) {
		var alunos = ReadFile.getAllAlunos();
		for (Aluno alunoWrite : alunos) {
			if (aluno.equals(alunoWrite.getCpf())) {
				alunoWrite.setNota(disciplina, notaNova);
			}
		}
		writeAluno(alunos);
	}

	public static void addAlunoDisciplina(String aluno, String disciplina) {
		var disciplinas = ReadFile.getAllDisciplinas();

		for (Disciplina disciplinaWrite : disciplinas) {
			if (disciplina.equals(disciplinaWrite.getNome())) {
				disciplinaWrite.addDiscente(aluno);
			}
		}
		
		writeDisciplinas(disciplinas);
	}

	public static void writeDisciplinas(List<Disciplina> disciplinas) {
		try (FileOutputStream fos = new FileOutputStream(pathDisciplinas)) {
			for (Disciplina disciplinaWrite : disciplinas) {
				String linha = disciplinaWrite.getNome() + "," + disciplinaWrite.getDoscente() + ","
						+ disciplinaWrite.getHorarios() + "," + disciplinaWrite.getSala() + "-";
				System.out.println(linha);
				
				for (int i = 0; i < disciplinaWrite.getDiscentes().size(); i++) {
					if (i == disciplinaWrite.getDiscentes().size() - 1) {
						linha += disciplinaWrite.getDiscentes().get(i) + "\n";
					} else {
						linha += disciplinaWrite.getDiscentes().get(i) + ",";
					}
				}
				System.out.println(linha);
				fos.write(linha.getBytes("UTF-8"));
			}

		} catch (IOException e) {

		}
	}

}
