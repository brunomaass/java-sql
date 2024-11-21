package entities;

public class Pessoa {

    // atributos privados
    private Integer idPessoa;
    private String nome;
    private String cpf;
    private String email;

    //Construtor sem entrada de argumentos
    public Pessoa() {

    }

    // construtor com entrada de argumentos
    // (sobrecarga de construtores)
    public Pessoa(Integer idPessoa, String nome, 
                    String cpf, String email) {
            
            super();
            this.idPessoa = idPessoa;
            this.nome = nome;
            this.cpf = cpf;
            this.email = email;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // sobrecarga de métodos
    @Override
    public String toString() {
        return "Pessoa [idPessoa=" + idPessoa + ", nome="
        + nome + ", cpf=" + cpf + ", email=" + email + "]";
    }
}
