package com.portfolio.luisfmdc.sboot_cms_student_ms.domain.aluno;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AlunoRequest(
        @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
        @NotBlank String nome,

        @Size(min = 3, max = 50, message = "O sobrenome deve ter entre 3 e 50 caracteres")
        @NotBlank String sobrenome,

        @NotNull Genero genero,

        @Size(min = 10, max = 50, message = "O e-mail deve ter entre 10 e 75 caracteres")
        @NotBlank String email,

        @NotNull LocalDate dataNascimento) {
}
