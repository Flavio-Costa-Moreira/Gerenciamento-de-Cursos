package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.SistemaGereciamento;
import br.edu.ifba.saj.fwads.exception.CursoInvalidoException;
import br.edu.ifba.saj.fwads.exception.IdInsuficientesException;
import br.edu.ifba.saj.fwads.exception.TurmaInvalidaException;
import br.edu.ifba.saj.fwads.exception.VagasInsuficientesException;
import br.edu.ifba.saj.fwads.model.Aluno;
import br.edu.ifba.saj.fwads.model.Curso;
import br.edu.ifba.saj.fwads.model.Turma;
import br.edu.ifba.saj.fwads.negocio.ValidaTurma;
import br.edu.ifba.saj.fwads.negocio.ValidaUsuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TableColumn;

public class CadTurmaController {

    @FXML
    private ChoiceBox<Aluno> slAluno;

    @FXML
    private ChoiceBox<Curso> slCurso;

    @FXML
    private TableColumn<Aluno, String> columnNome;

    @FXML
    private TableView<Aluno> tblAluno;

    @FXML
    private TextField txID;

    private List<Aluno> alunosSelecionados = new ArrayList<>();

    private ObservableList<Aluno> alunosTabela = FXCollections.observableArrayList();

    private ValidaUsuario validaUsuario = new ValidaUsuario();

    private ValidaTurma validaTurma = new ValidaTurma();

    @FXML
    private void initialize() {
        // Inicializa os ChoiceBoxes com conversores e carrega listas de alunos e cursos
        configurarSeletores();
        carregarListaAlunos();
        carregarListaCursos();

        columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        tblAluno.setItems(alunosTabela);
    }

    private void configurarSeletores() {
        slAluno.setConverter(new StringConverter<Aluno>() {
            @Override
            public String toString(Aluno obj) {
                return obj != null ? obj.getNome() + ":" + obj.getCpf() : "";
            }

            @Override
            public Aluno fromString(String stringAluno) {
                return SistemaGereciamento.listaAlunos
                        .stream()
                        .filter(aluno -> stringAluno.equals(aluno.getNome() + ":" + aluno.getCpf()))
                        .findAny()
                        .orElse(null);
            }
        });

        slCurso.setConverter(new StringConverter<Curso>() {
            @Override
            public String toString(Curso obj) {
                return obj != null ? obj.getNome() : "";
            }

            @Override
            public Curso fromString(String stringCurso) {
                return SistemaGereciamento.listaCursos
                        .stream()
                        .filter(curso -> stringCurso.equals(curso.getNome()))
                        .findAny()
                        .orElse(null);
            }
        });
    }

    private void carregarListaAlunos() {
        slAluno.setItems(SistemaGereciamento.listaAlunos);
    }

    private void carregarListaCursos() {
        slCurso.setItems(SistemaGereciamento.listaCursos);
    }

    @FXML
    void adicionarAluno(ActionEvent event) {
        Aluno alunoSelecionado = slAluno.getValue();
        if (alunoSelecionado != null && !alunosSelecionados.contains(alunoSelecionado)) {
            alunosSelecionados.add(alunoSelecionado);
            alunosTabela.add(alunoSelecionado); 
            new Alert(AlertType.INFORMATION, "Aluno adicionado: " + alunoSelecionado.getNome()).showAndWait();
        }
    }

    @FXML
    void salvarTurma(ActionEvent event) {
        
        String idTurma = txID.getText();
        Curso cursoSelecionado = slCurso.getValue();

        try {
            validaTurma.validaTurma(idTurma, cursoSelecionado, alunosSelecionados);
            Turma novaTurma = Turma.criarTurma(alunosSelecionados, cursoSelecionado, idTurma);
            SistemaGereciamento.listaTurmas.add(novaTurma);

            new Alert(AlertType.CONFIRMATION, "Turma criada com sucesso!").showAndWait();
            limparCampos();
        } catch (Exception e) {
            new Alert(AlertType.ERROR, e.getMessage()).showAndWait();
        }
    }

    

    @FXML
    void limparCampos() {
        txID.clear();
        alunosSelecionados.clear();
        tblAluno.setItems(null);
    }
}