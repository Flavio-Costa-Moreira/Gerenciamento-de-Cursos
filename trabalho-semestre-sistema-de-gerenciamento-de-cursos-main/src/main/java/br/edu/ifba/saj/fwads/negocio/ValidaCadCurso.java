package br.edu.ifba.saj.fwads.negocio;

import java.util.List;

import br.edu.ifba.saj.fwads.SistemaGereciamento;
import br.edu.ifba.saj.fwads.exception.CamposNaoPreenchidosException;
import br.edu.ifba.saj.fwads.exception.CursoInvalidoException;
import br.edu.ifba.saj.fwads.exception.IdInsuficientesException;
import br.edu.ifba.saj.fwads.exception.VagasInsuficientesException;
import br.edu.ifba.saj.fwads.model.Aluno;
import br.edu.ifba.saj.fwads.model.Curso;

public class ValidaCadCurso{
    
    public void cadastrarCurso(String nome, String duracao) throws CamposNaoPreenchidosException{
        if (nome!="" && duracao!=""){
            Curso novoCurso = new Curso(nome, duracao);
            SistemaGereciamento.listaCursos.add(novoCurso);  
        }else{
           throw new CamposNaoPreenchidosException("Existem campos vazios!");
        }
    }
}