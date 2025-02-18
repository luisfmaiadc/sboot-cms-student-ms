package com.portfolio.luisfmdc.sboot_cms_student_ms.domain.matricula;

import com.portfolio.luisfmdc.sboot_cms_student_ms.domain.aluno.Aluno;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;

    private Integer idCurso;
    private LocalDateTime dataMatricula = LocalDateTime.now();
    private Boolean ativo = Boolean.TRUE;

    public Matricula(Aluno aluno, Integer idCurso) {
        this.aluno = aluno;
        this.idCurso = idCurso;
    }
}
