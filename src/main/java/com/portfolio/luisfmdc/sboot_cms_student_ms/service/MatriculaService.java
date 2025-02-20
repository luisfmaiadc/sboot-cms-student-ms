package com.portfolio.luisfmdc.sboot_cms_student_ms.service;

import com.portfolio.luisfmdc.sboot_cms_student_ms.client.CursoClient;
import com.portfolio.luisfmdc.sboot_cms_student_ms.domain.aluno.Aluno;
import com.portfolio.luisfmdc.sboot_cms_student_ms.domain.matricula.Matricula;
import com.portfolio.luisfmdc.sboot_cms_student_ms.repository.AlunoRepository;
import com.portfolio.luisfmdc.sboot_cms_student_ms.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoClient curso;

    public ResponseEntity cadastrarMatricula(Integer idAluno, Integer idCurso,
                                             UriComponentsBuilder uriComponentsBuilder) {
        boolean cursoValido = validarCurso(idCurso);

        if (!cursoValido) {
            throw new RuntimeException("Curso inválido!");
        }

        Aluno aluno = alunoRepository.getReferenceById(idAluno);
        Matricula matricula = new Matricula(aluno, idCurso);
        matriculaRepository.save(matricula);
        URI uri = uriComponentsBuilder.path("/cadastrar/matricula/{idAluno}/{idMatricula}")
                .buildAndExpand(aluno.getId(), matricula.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    public ResponseEntity inativarMatricula(Integer idMatricula) {
        Matricula matricula = matriculaRepository.getReferenceById(idMatricula);
        matricula.setAtivo(Boolean.FALSE);
        matriculaRepository.save(matricula);
        return ResponseEntity.noContent().build();
    }

    private boolean validarCurso(Integer idCurso) {
        ResponseEntity<Void> response = curso.validarCurso(idCurso);
        return response.getStatusCode().is2xxSuccessful();
    }
}
