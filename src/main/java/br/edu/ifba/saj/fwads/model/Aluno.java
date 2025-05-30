package br.edu.ifba.saj.fwads.model;
public class Aluno {
    private String id;
    private String nome;
    private int idade;
    private String email;
    private String cpf;

    public Aluno(String id, String nome, int idade, String email, String cpf) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.cpf = cpf;
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "ID='" + id + '\'' +
                ", Nome='" + nome + '\'' +
                ", Idade=" + idade +
                ", Email='" + email + '\'' +
                ", CPF='" + cpf + '\'' +
                '}';
    }
}