CREATE TABLE cursos(
    id INT NOT NULL PRIMARY KEY ,
    nome VARCHAR(100) NOT NULL ,
    categoria VARCHAR(100) NOT NULL
);

CREATE TABLE usuarios(
    id INT NOT NULL PRIMARY KEY ,
    nome,
    email,
    senha
);

CREATE TABLE topicos(
    id INT NOT NULL PRIMARY KEY ,
    titulo,
    mensagem,
    data_criacao,
    status,
    autor_id,
    curso_id,
    FOREIGN KEY(autor_id) REFERENCES(id) ON
    FOREIGN KEY(curso_id) REFERENCES(id) ON
);