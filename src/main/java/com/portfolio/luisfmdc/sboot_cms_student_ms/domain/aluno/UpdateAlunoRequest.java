package com.portfolio.luisfmdc.sboot_cms_student_ms.domain.aluno;

import java.time.LocalDate;

public record UpdateAlunoRequest(String nome, String sobrenome, Genero genero,
                                 String email, LocalDate dataNascimento) {
}
