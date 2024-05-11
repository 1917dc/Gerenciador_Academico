package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class readFile {
    public static void main(String[] args) {
        System.out.println(readAlunos("/home/lua/Documents/GitHub/Gerenciador_Academico/Gerenciador_Academico/src/alunos.txt"));
    }
    public static List readAlunos(String path) {
        List<String> result;
        try(Stream<String> lines = Files.lines(Paths.get(path))) {
            result = lines.collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
