package model.bean;


public class Pessoa {
    
    private int id;
    private String nome ;
    private String nascimento;
    private String cpf;
    private String cep;
    private String celular;
    private String email;
    private String senha ;
    private String endereco;

    public Pessoa(){
        
    }

    public Pessoa(String nome, String nascimento, String cpf, String cep, String celular, String email, String senha, String endereco) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.cpf = cpf;
        this.cep = cep;
        this.celular = celular;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNascimento() {
        return nascimento;
    }
    
    public void setNascimento(String nascimento) {
        this.nascimento = getNascimento();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
   public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
     public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }
public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }



 

   

    
  
 
}
