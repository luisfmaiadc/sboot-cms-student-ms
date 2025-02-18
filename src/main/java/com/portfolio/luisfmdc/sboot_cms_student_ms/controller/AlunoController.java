package com.portfolio.luisfmdc.sboot_cms_student_ms.controller;

import com.portfolio.luisfmdc.sboot_cms_student_ms.domain.aluno.AlunoRequest;
import com.portfolio.luisfmdc.sboot_cms_student_ms.domain.aluno.AlunoResponse;
import com.portfolio.luisfmdc.sboot_cms_student_ms.domain.aluno.UpdateAlunoRequest;
import com.portfolio.luisfmdc.sboot_cms_student_ms.service.AlunoService;
import com.portfolio.luisfmdc.sboot_cms_student_ms.service.MatriculaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private MatriculaService matriculaService;

    @PostMapping("/cadastrar")
    public ResponseEntity<AlunoResponse> cadastrarAluno(@RequestBody @Valid AlunoRequest request, UriComponentsBuilder uriComponentsBuilder) {
        return alunoService.cadastrarAluno(request, uriComponentsBuilder);
    }

    @PutMapping("/atualizar/{idAluno}")
    public ResponseEntity<AlunoResponse> atualizarAluno(@PathVariable Integer idAluno, @RequestBody UpdateAlunoRequest request) {
        return alunoService.atualizarAluno(idAluno, request);
    }

    @PostMapping("/cadastrar/matricula/{idAluno}")
    public ResponseEntity cadastrarMatricula(@PathVariable Integer idAluno, @RequestParam Integer idCurso,
                                             UriComponentsBuilder uriComponentsBuilder) {
        return matriculaService.cadastrarMatricula(idAluno, idCurso, uriComponentsBuilder);
    }

    @DeleteMapping("/matricula/{idMatricula}")
    public ResponseEntity inativarMatricula(@PathVariable Integer idMatricula) {
        return matriculaService.inativarMatricula(idMatricula);
    }
}
