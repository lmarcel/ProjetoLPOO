
package model.bean;

public class Aluno extends Pessoa {
    private String segunda ;
    private String terca ;
    private String quarta ;
    private String quinta;
    private String sexta;
    private String sabado;
    private String domingo;
    private Personal personal;

    public Aluno(Personal personal) {
        this.personal = personal;
    }

    public Aluno() {
    }

    public Aluno(Personal personal, String nome, String nascimento, String cpf, String cep, String celular, String email, String senha, String endereco) {
        super(nome, nascimento, cpf, cep, celular, email, senha, endereco);
        this.personal = personal;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
    
    
   

    
    public String getAltura() {
        return segunda;
    }

  
    public void setAltura(String segunda) {
        this.segunda = segunda;
    }

    
    public String getPeso() {
        return terca;
    }

 
    public void setPeso(String terca) {
        this.terca = terca;
    }

   
    public String getCintura() {
        return quarta;
    }

 
    public void setCintura(String quarta) {
        this.quarta = quarta;
    }

    
    public String getPeitoral() {
        return quinta;
    }

    
    public void setPeitoral(String quinta) {
        this.quinta = quinta;
    }

   
    public String getCoxaD() {
        return sexta;
    }

    
    public void setCoxaD(String sexta) {
        this.sexta = sexta;
    }

    
    public String getCoxaE() {
        return sabado;
    }

    
    public void setCoxaE(String sabado) {
        this.sabado = sabado;
    }

    
    public String getBicpsD() {
        return domingo;
    }

    
    public void setBicpsD(String domingo) {
        this.domingo = domingo;
    }

    public Object setPersonal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



 
}
