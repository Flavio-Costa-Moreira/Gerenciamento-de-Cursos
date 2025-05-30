package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.SistemaGereciamento;
import br.edu.ifba.saj.fwads.model.Aluno;
import br.edu.ifba.saj.fwads.negocio.ValidaCadAluno;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class CadAlunoController {

    @FXML
    private TextField txCPF;

    @FXML
    private TextField txEmail;

    @FXML
    private TextField txId;

    @FXML
    private TextField txIdade;

    @FXML
    private TextField txNome;

    @FXML
    void limparCampos(ActionEvent event) {
        txNome.setText("");
        txCPF.setText("");
        txEmail.setText("");
        txId.setText("");
        txIdade.setText("");
    }

    private void limparTela() {
        txNome.setText("");
        txCPF.setText("");
        txEmail.setText("");
        txId.setText("");
        txIdade.setText("");
    }

    @FXML
    void salvarAluno(ActionEvent event) {
        try {
            String sIdade= txIdade.getText();
            int idade = Integer.parseInt(sIdade);
            ValidaCadAluno validaCadAluno = new ValidaCadAluno();
            validaCadAluno.cadastrarAluno(txId.getText(), txNome.getText(), idade, txEmail.getText(), txCPF.getText());
            new Alert(AlertType.CONFIRMATION, "Aluno Cadastrado com sucesso!").showAndWait();
            limparTela();
        } catch (Exception e) {
            new Alert(AlertType.ERROR, e.getMessage()).showAndWait();
        }
       
    }

}