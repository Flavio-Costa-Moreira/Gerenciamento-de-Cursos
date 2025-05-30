package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.App;
import br.edu.ifba.saj.fwads.SistemaGereciamento;
import br.edu.ifba.saj.fwads.model.Curso;
import br.edu.ifba.saj.fwads.model.Turma;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ListTurmaController {
    @FXML
    private TableView<Turma> tblTurma;

    @FXML
    private TableColumn<Turma, String> columnID;

    @FXML
    private TableColumn<Turma, String> columnCurso;


    @FXML
    public void initialize() {
        columnCurso.setCellValueFactory(new PropertyValueFactory<>("curso"));
        columnID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblTurma.setItems(SistemaGereciamento.listaTurmas);
    }

    @FXML
    public void showNovaTurma() {
        
        Stage stage = new Stage();            
        Scene scene = new Scene(App.loadFXML("controller/CadTurma.fxml"));          
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL); 
        stage.showAndWait();            
    }
}
