package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.SistemaGereciamento;
import br.edu.ifba.saj.fwads.exception.CamposNaoPreenchidosException;
import br.edu.ifba.saj.fwads.model.Curso;
import br.edu.ifba.saj.fwads.negocio.ValidaCadCurso;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class CadCursoController {

    @FXML
    private TextField txDuracao;

    @FXML
    private TextField txNome;

    @FXML
    void limparTela(ActionEvent event) {
        txNome.setText("");
        txDuracao.setText("");
    }

    private void limparCampo() {
        txNome.setText("");
        txDuracao.setText("");
    }

    @FXML
    void salvarCurso(ActionEvent event) {
        try {
            ValidaCadCurso validaCadCurso = new ValidaCadCurso();
            validaCadCurso.cadastrarCurso(txNome.getText(), txDuracao.getText());
            new Alert(AlertType.CONFIRMATION, "Curso cadastrado com sucesso!").showAndWait();
            limparCampo();
        } catch (Exception e) {
            new Alert(AlertType.ERROR, e.getMessage()).showAndWait();
            limparCampo();
        }

    }

}