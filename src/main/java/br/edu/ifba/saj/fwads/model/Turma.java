package br.edu.ifba.saj.fwads.model;
import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String id;
    private List<Aluno> alunos;
    private Curso curso;

    // Construtor privado, apenas será chamado pelo método criarTurma
    private Turma(String id) {
        this.id = id;
        this.alunos = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public Curso getCurso() {
        return curso;
    }

    // Método para adicionar aluno à turma
    public void adicionarAluno(Aluno aluno) {
        if (alunos.size() < 10) {
            alunos.add(aluno);
        } else {
            System.out.println("A turma já atingiu o limite de 10 alunos.");
        }
    }

    // Método que cria a turma com os alunos passados, se cumprir as regras de negócio
    public static Turma criarTurma(List<Aluno> alunos, Curso curso, String identificador) {
        if (curso == null) {
            System.out.println("A turma só pode ser criada se estiver vinculada a um curso.");
            return null;
        }

        if (alunos.size() < 5 || alunos.size() > 10) {
            System.out.println("A turma deve ter entre 5 e 10 alunos.");
            return null;
        }

        Turma novaTurma = new Turma(identificador);
        novaTurma.alunos.addAll(alunos);  // Adiciona todos os alunos de uma vez
        curso.adicionarTurma(novaTurma);  // Vincula a turma ao curso
        System.out.println("Turma criada com sucesso e adicionada ao curso: " + curso.getNome());
        return novaTurma;
    }

    // Método para listar alunos da turma
    public void listarAlunos() {
        System.out.println("Alunos na Turma " + id + ":");
        for (Aluno aluno : alunos) {
            System.out.println(aluno.getNome());
        }
    }
}