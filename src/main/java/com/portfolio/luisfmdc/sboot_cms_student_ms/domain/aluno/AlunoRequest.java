package com.portfolio.luisfmdc.sboot_cms_student_ms.domain.aluno;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AlunoRequest(@NotBlank String nome, @NotBlank String sobrenome, @NotNull Genero genero,
                           @NotBlank String email, @NotNull LocalDate dataNascimento) {
}
