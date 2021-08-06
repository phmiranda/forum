INSERT INTO usuarios(id, nome, email, senha) VALUES(1, 'Administrador', 'admin@email.com.br', '$2a$04$ygKK8TiwMgUA64teTjLk0eA5QBTRQX/Xym54qzoCk6dbd.dt8Y0OK');
INSERT INTO usuarios(id, nome, email, senha) VALUES(2, 'Débora Silva Viana', 'debora.viana@email.com.br', '$2a$04$ygKK8TiwMgUA64teTjLk0eA5QBTRQX/Xym54qzoCk6dbd.dt8Y0OK');
INSERT INTO usuarios(id, nome, email, senha) VALUES(3, 'Alexander da Silva Vasconcelos', 'alexander.vasconcelos@email.com.br', '$2a$04$ygKK8TiwMgUA64teTjLk0eA5QBTRQX/Xym54qzoCk6dbd.dt8Y0OK');

INSERT INTO cursos(id, nome, categoria) VALUES(1, 'HTML/CSS', 'FRONTEND');
INSERT INTO cursos(id, nome, categoria) VALUES(2, 'Javascript', 'FRONTEND');
INSERT INTO cursos(id, nome, categoria) VALUES(3, 'Java SE', 'BACKEND');
INSERT INTO cursos(id, nome, categoria) VALUES(4, 'Java EE', 'BACKEND');
INSERT INTO cursos(id, nome, categoria) VALUES(5, 'Python', 'BACKEND');
INSERT INTO cursos(id, nome, categoria) VALUES(6, 'PHP', 'BACKEND');

INSERT INTO topicos(id, titulo, mensagem, data_criacao, topico_status, usuario_id, curso_id) VALUES(1, 'Dúvida #01', 'MENSAGEM DA DÚVIDA', NOW(), 'NAO_RESPONDIDO', 1, 1);
INSERT INTO topicos(id, titulo, mensagem, data_criacao, topico_status, usuario_id, curso_id) VALUES(2, 'Dúvida #02', 'MENSAGEM DA DÚVIDA', NOW(), 'NAO_RESPONDIDO', 2, 2);
INSERT INTO topicos(id, titulo, mensagem, data_criacao, topico_status, usuario_id, curso_id) VALUES(3, 'Dúvida #03', 'MENSAGEM DA DÚVIDA', NOW(), 'NAO_RESPONDIDO', 3, 3);

INSERT INTO respostas(id, data_criacao, mensagem, solucao, topico_id, usuario_id) VALUES (1,NOW(),'MENSAGEM DA DÚVIDA',FALSE, 1, 1);
INSERT INTO respostas(id, data_criacao, mensagem, solucao, topico_id, usuario_id) VALUES (2,NOW(),'MENSAGEM DA DÚVIDA',FALSE, 1, 2);
INSERT INTO respostas(id, data_criacao, mensagem, solucao, topico_id, usuario_id) VALUES (3,NOW(),'MENSAGEM DA DÚVIDA',FALSE, 1, 3);
INSERT INTO respostas(id, data_criacao, mensagem, solucao, topico_id, usuario_id) VALUES (4,NOW(),'MENSAGEM DA DÚVIDA',FALSE, 2, 1);
INSERT INTO respostas(id, data_criacao, mensagem, solucao, topico_id, usuario_id) VALUES (5,NOW(),'MENSAGEM DA DÚVIDA',FALSE, 2, 2);
INSERT INTO respostas(id, data_criacao, mensagem, solucao, topico_id, usuario_id) VALUES (6,NOW(),'MENSAGEM DA DÚVIDA',FALSE, 2, 3);
INSERT INTO respostas(id, data_criacao, mensagem, solucao, topico_id, usuario_id) VALUES (7,NOW(),'MENSAGEM DA DÚVIDA',FALSE, 3, 1);
INSERT INTO respostas(id, data_criacao, mensagem, solucao, topico_id, usuario_id) VALUES (8,NOW(),'MENSAGEM DA DÚVIDA',FALSE, 3, 2);
INSERT INTO respostas(id, data_criacao, mensagem, solucao, topico_id, usuario_id) VALUES (9,NOW(),'MENSAGEM DA DÚVIDA',FALSE, 3, 3);