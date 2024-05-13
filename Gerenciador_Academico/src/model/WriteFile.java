package model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class WriteFile {
    public static void main(String[] args) {
        WriteFile writeFile = new WriteFile();
        writeFile.writeAluno("12345566");
    }
    private ReadFile readFile = new ReadFile();
    public void writeAluno(String aluno) {
//        Aluno alunoWrite = null;
//        for(Aluno a : readFile.getAllAlunos()) {
//            if (a.getCpf().equals(aluno)) {
//                alunoWrite = a;
//            }
//        }
//        readFile.getAllAlunos().removeIf(a -> a.getCpf().equals(aluno));
//        readFile.getAllAlunos().add(alunoWrite);
//        System.out.println(readFile.getAllAlunos().get(2).toString());

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("/home/lua/Documents/GitHub/Gerenciador_Academico/Gerenciador_Academico/src/teste.txt");
            fos.write("teste".getBytes("UTF-8"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
