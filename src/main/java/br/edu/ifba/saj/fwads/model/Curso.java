package br.edu.ifba.saj.fwads.model;
import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nome;
    private String duracao;
    private List<Turma> turmas;

    public Curso(String nome, String duracao) {
        this.nome = nome;
        this.duracao = duracao;
        this.turmas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getDuracao() {
        return duracao;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void adicionarTurma(Turma turma) {
        turmas.add(turma);
    }

    public void listarTurmas() {
        System.out.println("Curso: " + nome + " (Duração: " + duracao + ")");
        for (Turma turma : turmas) {
            System.out.println("ID da Turma: " + turma.getId());
            turma.listarAlunos();
        }
    }
}