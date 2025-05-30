package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.App;
import br.edu.ifba.saj.fwads.SistemaGereciamento;
import br.edu.ifba.saj.fwads.model.Curso;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ListCursoController {
    @FXML
    private TableView<Curso> tblCurso;

    @FXML
    private TableColumn<Curso, String> columnDuracao;

    @FXML
    private TableColumn<Curso, String> columnNome;


    @FXML
    public void initialize() {
        columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        columnDuracao.setCellValueFactory(new PropertyValueFactory<>("duracao"));
        tblCurso.setItems(SistemaGereciamento.listaCursos);
    }

    @FXML
    public void showNovoCurso() {
        
        Stage stage = new Stage();            
        Scene scene = new Scene(App.loadFXML("controller/CadCurso.fxml"));            
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL); 
        stage.showAndWait();            
    }

}
