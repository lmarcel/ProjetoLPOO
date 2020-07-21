
package model.bean;

public class Exercicio {
    private int exerId;
    private String dia ;
    private String tipo ;
    private String nome ;
    private String series;
    private String repeti;
    private Aluno aluno;

    public Exercicio(int exerId, Aluno aluno) {
        this.exerId = exerId;
        this.aluno = aluno;
    }

    public Exercicio(Aluno aluno) {
        this.aluno = aluno;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Exercicio() {
    }
    
    
    public int getExerId() {
        return exerId;
    }

    public void setExerId(int exerId) {
        this.exerId = exerId;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getRepeti() {
        return repeti;
    }

    public void setRepeti(String repeti) {
        this.repeti = repeti;
    }
 
}
