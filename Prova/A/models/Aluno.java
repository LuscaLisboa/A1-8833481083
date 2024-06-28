public class Aluno {
    private String Nome;
    private String Matricula;
    private Double Nota;

    public Aluno() {

    }

    public Aluno(String Nome, String Matricula, Double Nota) {
        this.Nome = Nome;
        this.Matricula = Matricula;
        this.Nota = Nota;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String matricula) {
        Matricula = matricula;
    }

    public Double getNota() {
        return Nota;
    }

    public void setNota(Double nota) {
        Nota = nota;
    }

    public String toCSV() {
        return "Nome:" + this.Nome + ";" + "Matricula:" + this.Matricula + ";" + "Nota:" + this.Nota;
    }

}
