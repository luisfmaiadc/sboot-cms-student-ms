package com.portfolio.luisfmdc.sboot_cms_student_ms.domain.aluno;

import com.portfolio.luisfmdc.sboot_cms_student_ms.domain.matricula.Matricula;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String sobrenome;
    @Enumerated(EnumType.STRING)
    private Genero genero;
    private String email;
    private LocalDate dataNascimento;
    private LocalDateTime dataCadastro = LocalDateTime.now();

    @OneToMany(mappedBy = "aluno")
    private List<Matricula> matriculas;

    public Aluno(AlunoRequest request) {
        this.nome = request.nome();
        this.sobrenome = request.sobrenome();
        this.genero = request.genero();
        this.email = request.email();
        this.dataNascimento = request.dataNascimento();
    }

    public void atualizarAluno(UpdateAlunoRequest request) {

        if (request.nome() != null && !request.nome().isEmpty()) {
            this.nome = request.nome();
        }

        if (request.sobrenome() != null && !request.sobrenome().isEmpty()) {
            this.sobrenome = request.sobrenome();
        }

        if(request.genero() != null) {
            this.genero = request.genero();
        }

        if (request.email() != null && !request.email().isEmpty()) {
            this.email = request.email();
        }

        if (request.dataNascimento() != null) {
            this.dataNascimento = request.dataNascimento();
        }
    }
}
