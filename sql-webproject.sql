CREATE DATABASE webproject;
use webproject;

CREATE TABLE usuario 
( 
 id  INT auto_increment PRIMARY KEY,  
 nome VARCHAR(20),  
 sobrenome VARCHAR(20),  
 email VARCHAR(45),  
 celular VARCHAR(20),  
senha VARCHAR(100)  
); 
SELECT * FROM usuario;