DROP SCHEMA IF EXISTS bd_biblioteca ;
CREATE SCHEMA bd_biblioteca;

use bd_biblioteca;
CREATE TABLE tb_inventario(
	id INT AUTO_INCREMENT primary key,
	nombreLibro varchar(25) not null,
    descripcion varchar(225) null,
    prestado boolean
);
