
package model.bean;


public class Personal extends Pessoa{
    private String registro;
    private String planos;
    private Pessoa pessoa;

    public Personal() {
    }

    public Personal(String registro, String planos, Pessoa pessoa, String nome, String nascimento, String cpf, String cep, String celular, String email, String senha, String endereco) {
        super(nome, nascimento, cpf, cep, celular, email, senha, endereco);
        this.registro = registro;
        this.planos = planos;
        this.pessoa = pessoa;
    }
    
    

    public void setRegistro(String registro) {
        this.registro = registro;
    }
    public String getRegistro() {
        return registro;
    }
    
}