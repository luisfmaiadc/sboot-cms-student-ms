CREATE TABLE aluno (
  id INT GENERATED ALWAYS AS IDENTITY,
  nome VARCHAR(50) NOT NULL,
  sobrenome VARCHAR(50) NOT NULL,
  genero CHAR(1) NOT NULL,
  email VARCHAR(75) NOT NULL,
  data_nascimento DATE NOT NULL,
  data_cadastro TIMESTAMP NOT NULL,
  PRIMARY KEY (id)
  );

CREATE TABLE matricula (
  id INT GENERATED ALWAYS AS IDENTITY,
  id_aluno INT NOT NULL,
  id_curso INT NOT NULL,
  data_matricula TIMESTAMP NOT NULL,
  ativo BOOLEAN NOT NULL,
  FOREIGN KEY (id_aluno) REFERENCES aluno(id)
  );