package br.edu.ifba.saj.fwads.negocio;

import java.util.List;

import br.edu.ifba.saj.fwads.SistemaGereciamento;
import br.edu.ifba.saj.fwads.exception.CamposNaoPreenchidosException;
import br.edu.ifba.saj.fwads.exception.CursoInvalidoException;
import br.edu.ifba.saj.fwads.exception.IdInsuficientesException;
import br.edu.ifba.saj.fwads.exception.VagasInsuficientesException;
import br.edu.ifba.saj.fwads.model.Aluno;
import br.edu.ifba.saj.fwads.model.Curso;

public class ValidaCadAluno{
    
    public void cadastrarAluno(String id, String nome, int idade, String email, String cpf) throws CamposNaoPreenchidosException{
        if (nome!="" && id!="" && email!="" && cpf!=""){
            Aluno novoAluno = new Aluno (id, nome, idade, email, cpf);
            SistemaGereciamento.listaAlunos.add(novoAluno);  
        }else{
           throw new CamposNaoPreenchidosException("Existem campos vazios!");
        }
    }
}