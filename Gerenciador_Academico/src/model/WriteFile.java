package model;

public class WriteFile {
    private ReadFile readFile = new ReadFile();
    public void writeAluno(String aluno) {
        Aluno alunoWrite = null;
        for(Aluno a : readFile.getAllAlunos()) {
            if (a.getCpf().equals(aluno)) {
                alunoWrite = a;
            }
        }
        readFile.getAllAlunos().removeIf(a -> a.getCpf().equals(aluno));
        readFile.getAllAlunos().add(alunoWrite);
        System.out.println(readFile.getAllAlunos().get(2).toString());
    }
}
