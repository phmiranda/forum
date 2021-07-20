CREATE TABLE respostas(
    id INT NOT NULL PRIMARY KEY ,
    autor VARCHAR(200) NOT NULL ,
    solucao LONGTEXT NOT NULL ,
    data_criacao DATE NOT NULL ,
    topico_id INTEGER NULL
);