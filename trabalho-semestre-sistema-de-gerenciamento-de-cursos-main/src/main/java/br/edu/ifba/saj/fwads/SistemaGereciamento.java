package br.edu.ifba.saj.fwads;

import br.edu.ifba.saj.fwads.model.Aluno;
import br.edu.ifba.saj.fwads.model.Curso;
import br.edu.ifba.saj.fwads.model.Turma;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SistemaGereciamento {
     public static ObservableList<Curso> listaCursos = FXCollections.observableArrayList();
     public static ObservableList<Turma> listaTurmas = FXCollections.observableArrayList();
     public static ObservableList<Aluno> listaAlunos = FXCollections.observableArrayList();

/*      private static SistemaGereciamento instance;
          // Outros atritubos
      
          public static SistemaGereciamento getInstance() {
              if (instance == null) {
                  instance = new SistemaGereciamento();
              }
              return instance;
          }*/
      
}