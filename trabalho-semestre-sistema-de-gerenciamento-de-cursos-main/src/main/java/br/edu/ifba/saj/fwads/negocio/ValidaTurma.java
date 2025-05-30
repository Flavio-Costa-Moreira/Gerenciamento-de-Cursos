package br.edu.ifba.saj.fwads.negocio;

import java.util.List;
import br.edu.ifba.saj.fwads.exception.CursoInvalidoException;
import br.edu.ifba.saj.fwads.exception.IdInsuficientesException;
import br.edu.ifba.saj.fwads.exception.VagasInsuficientesException;
import br.edu.ifba.saj.fwads.model.Aluno;
import br.edu.ifba.saj.fwads.model.Curso;

public class ValidaTurma{

    public void validaTurma(String id, Curso curso, List<Aluno> alunos) throws Exception {
        if (id == null || id.isEmpty()) {
            throw new IdInsuficientesException("ID da turma não pode estar vazio.");
        }

        if (curso == null) {
            throw new CursoInvalidoException("Selecione um curso válido.");
        }

        if (alunos.size() < 5) {
            throw new VagasInsuficientesException("A turma deve ter no mínimo 5 alunos.");
        } else if (alunos.size() > 10) {
            throw new VagasInsuficientesException("A turma deve ter no máximo 10 alunos.");
        }
    }
}