package com.portfolio.luisfmdc.sboot_cms_student_ms.service;

import com.portfolio.luisfmdc.sboot_cms_student_ms.client.CursoClient;
import com.portfolio.luisfmdc.sboot_cms_student_ms.domain.aluno.Aluno;
import com.portfolio.luisfmdc.sboot_cms_student_ms.domain.matricula.Matricula;
import com.portfolio.luisfmdc.sboot_cms_student_ms.infra.exception.ErrorClientException;
import com.portfolio.luisfmdc.sboot_cms_student_ms.infra.exception.InvalidCourseException;
import com.portfolio.luisfmdc.sboot_cms_student_ms.repository.AlunoRepository;
import com.portfolio.luisfmdc.sboot_cms_student_ms.repository.MatriculaRepository;
import feign.FeignException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

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

        Optional<Aluno> optional = alunoRepository.findById(idAluno);
        if(!optional.isPresent()) {
            throw new EntityNotFoundException("Aluno não encontrado.");
        }

        boolean cursoValido = validarCurso(idCurso);
        if (!cursoValido) {
            throw new InvalidCourseException("Curso inválido.");
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
        try {
            curso.validarCurso(idCurso);
            return true;
        } catch (FeignException.NotFound e) {
            return false;
        } catch (FeignException e) {
            throw new ErrorClientException("Erro na tentativa de validar curso.");
        }
    }
}
