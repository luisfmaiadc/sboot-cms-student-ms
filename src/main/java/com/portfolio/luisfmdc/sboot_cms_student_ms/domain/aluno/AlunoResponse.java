package com.portfolio.luisfmdc.sboot_cms_student_ms.domain.aluno;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AlunoResponse(@NotBlank String nome, @NotBlank String sobrenome, @NotNull Genero genero,
                            @NotBlank String email, @NotNull LocalDate dataNascimento) {

    public AlunoResponse(Aluno aluno) {
        this(aluno.getNome(), aluno.getSobrenome(), aluno.getGenero(), aluno.getEmail(), aluno.getDataNascimento());
    }
}
