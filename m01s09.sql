DROP TABLE pessoa;

CREATE TABLE pessoa (
  id   int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  nome varchar(100),
  doc_receita_federal varchar(20)
);

SELECT * FROM pessoa p 


----------------------------------------------------


CREATE TABLE pet (
  id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  nome varchar(50) NOT NULL,
  tipo varchar(50) NOT NULL,
  raca varchar(50)
);

CREATE TABLE tutor (
  id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  nome varchar(50) NOT NULL
);

ALTER TABLE pet ADD tutor_id int constraint fk_pet_tutor_id references tutor(id); 

ALTER TABLE pessoa ADD tutor_id int constraint fk_pessoa_tutor_id references tutor(id); 

Drop Table servico;
CREATE TABLE servico (
  id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  ativo boolean NOT NULL DEFAULT TRUE,
  nome varchar(50) NOT NULL,
  valor decimal(19, 2) NOT NULL DEFAULT 0.00
);


CREATE TABLE kit (
  id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  ativo boolean NOT NULL DEFAULT TRUE,
  nome varchar(50) NOT NULL,
  descricao text,
  valor decimal(19, 2) NOT NULL DEFAULT 0.00
);

DROP TABLE kit_servico;
CREATE TABLE kit_servico (
  id int NOT NULL PRIMARY KEY AUTO_INCREMENT
);

ALTER TABLE kit_servico ADD kit_id int CONSTRAINT fk_kit_servico_kit REFERENCES kit(id); 
ALTER TABLE kit_servico ADD servico_id int CONSTRAINT fk_kit_servico_servico REFERENCES servico(id); 

ALTER TABLE kit ADD validade datetime;



