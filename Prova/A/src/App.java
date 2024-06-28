import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        List<String> Alunos = readFile("alunos");

        createAlunos(Alunos);

        writeFile(Alunos);

    }

    public static List<String> readFile(String name) throws FileNotFoundException {

        File file = new File("C:\\_ws\\dev_QuemApagarÉCorno\\A1\\" + name + ".csv");
        Scanner read = new Scanner(file);

        List<String> dados = new ArrayList<>();

        while (read.hasNext()) {
            String dado = read.nextLine();
            dados.add(dado);
        }

        read.close();

        return dados;
    }

    public static Aluno createAlunos(List<String> Alunos) {
        Aluno aluno = new Aluno();

        for (int i = 0; i < Alunos.size(); i++) {
            String[] dados = Alunos.get(i).split(";");
            Double dado2 = Double.parseDouble(dados[2]);
            aluno.setNome(dados[0]);
            aluno.setMatricula(dados[1]);
            aluno.setNota(dado2);
        }

        return aluno;
    }

    public static void writeFile(List<String> Alunos) throws IOException {

        FileWriter resumo = new FileWriter("C:\\_ws\\dev_QuemApagarÉCorno\\A1\\resumo.csv");
        int apro = 0;
        int repro = 0;
        Double menor = 10.0;
        Double maior = 0.0;
        Double sum = 0.0;

        resumo.write("\nQuantidade de alunos: " + Alunos.size());
        for (int i = 0; i < Alunos.size(); i++) {
            String[] dados = Alunos.get(i).split(";");
            Double nota = Double.parseDouble(dados[2]);
            if (nota >= 6.0)
                apro++;
            else
                repro++;
            if (menor > nota)
                menor = nota;
            if (maior < nota)
                maior = nota;
            sum += nota;
        }

        resumo.write("\nQuantidade de alunos aprovados: " + apro);
        resumo.write("\nQuantidade de alunos reprovados: " + repro);

        resumo.write("\nMenor nota: " + menor);
        resumo.write("\nMaior nota: " + maior);

        resumo.write("\nMédia Geral: " + (sum / Alunos.size()));

        resumo.close();
    }
}