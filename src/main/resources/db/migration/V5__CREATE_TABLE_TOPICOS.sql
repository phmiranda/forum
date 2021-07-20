CREATE TABLE topicos(
    id INT NOT NULL PRIMARY KEY ,
    titulo VARCHAR(180) NOT NULL ,
    mensagem LONGTEXT NOT NULL ,
    data_criacao DATE NOT NULL ,
    status_topico ENUM('NAO_RESPONDIDO','NAO_SOLUCIONADO','SOLUCIONADO', 'FECHADO') NOT NULL ,
    curso_id INT NOT NULL ,
    usuario_id INT NOT NULL ,
    resposta_id INT NOT NULL ,
    FOREIGN KEY(curso_id) REFERENCES cursos(id),
    FOREIGN KEY(usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY(resposta_id) REFERENCES respostas(id)
);