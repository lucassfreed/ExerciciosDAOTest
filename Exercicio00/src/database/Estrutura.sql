/**
 * Author:  Lucas Rodrigo Frederico
 * Created: 08/10/2018
 */
DROP DATABASE IF EXISTS ex00;
CREATE DATABASE ex00;
USE ex00;

CREATE TABLE filmes (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(200) NOT NULL,
	diretor VARCHAR(200) NOT NULL,
	categoria VARCHAR(100) NOT NULL,
	ator_principal VARCHAR(200) NOT NULL,
	ano INT NOT NULL,
	tempo_filme SMALLINT NOT NULL,
	faixa_etaria VARCHAR(150) NOT NULL,
	idioma_original VARCHAR(200) NOT NULL,
	orcamento DOUBLE NOT NULL,
	faturamento DOUBLE NOT NULL,
	legenda BOOLEAN NOT NULL,
	dublado BOOLEAN NOT NULL
);



