package com.portfolio.luisfmdc.sboot_cms_student_ms.repository;

import com.portfolio.luisfmdc.sboot_cms_student_ms.domain.aluno.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}
