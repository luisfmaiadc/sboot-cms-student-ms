package com.portfolio.luisfmdc.sboot_cms_student_ms.service;

import com.portfolio.luisfmdc.sboot_cms_student_ms.domain.aluno.Aluno;
import com.portfolio.luisfmdc.sboot_cms_student_ms.domain.aluno.AlunoRequest;
import com.portfolio.luisfmdc.sboot_cms_student_ms.domain.aluno.AlunoResponse;
import com.portfolio.luisfmdc.sboot_cms_student_ms.domain.aluno.UpdateAlunoRequest;
import com.portfolio.luisfmdc.sboot_cms_student_ms.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    public ResponseEntity<AlunoResponse> cadastrarAluno(AlunoRequest request, UriComponentsBuilder uriComponentsBuilder) {
        Aluno aluno = new Aluno(request);
        repository.save(aluno);
        URI uri = uriComponentsBuilder.path("/cadastrar/{id}").buildAndExpand(aluno.getDataCadastro()).toUri();
        return ResponseEntity.created(uri).body(new AlunoResponse(aluno));
    }

    public ResponseEntity<AlunoResponse> atualizarAluno(Integer idAluno, UpdateAlunoRequest request) {
        Aluno aluno = repository.getReferenceById(idAluno);
        aluno.atualizarAluno(request);
        repository.save(aluno);
        return ResponseEntity.ok(new AlunoResponse(aluno));
    }
}
