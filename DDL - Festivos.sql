--Ejecutar primero
DROP DATABASE Festivos WITH (FORCE);
--Ejecutar segundo
CREATE DATABASE Festivos; 

--Para las siguientes instrucciones, se debe cambiar la conexión

-- Crear la tabla TIPO
CREATE TABLE tipo(
    id SERIAL PRIMARY KEY,
    tipo VARCHAR(100) NOT NULL
);

-- Crear la tabla FESTIVO
CREATE TABLE festivo(
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    dia INT NOT NULL,
    mes INT NOT NULL,
    diaspascua INT NOT NULL,
    idtipo INT NOT NULL,
    CONSTRAINT fk_festivo_tipo FOREIGN KEY (idtipo) REFERENCES tipo(id)
);