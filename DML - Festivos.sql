-- Registros tabla TIPO
INSERT INTO tipo(id, tipo) VALUES(1, 'Fijo');
INSERT INTO tipo(id, tipo) VALUES(2, 'Ley Puente Festivo');
INSERT INTO tipo(id, tipo) VALUES(3, 'Basado en Pascua');
INSERT INTO tipo(id, tipo) VALUES(4, 'Basado en Pascua y Ley Puente Festivo');

-- Registros tabla FESTIVO
INSERT INTO festivo (dia, mes, nombre, idtipo, diaspascua) VALUES(1, 1, 'Año nuevo', 1, 0);
INSERT INTO festivo (dia, mes, nombre, idtipo, diaspascua) VALUES(6, 1, 'Santos Reyes', 2, 0);
INSERT INTO festivo (dia, mes, nombre, idtipo, diaspascua) VALUES(19, 3, 'San José', 2, 0);
INSERT INTO festivo (dia, mes, nombre, idtipo, diaspascua) VALUES(0, 0, 'Jueves Santo', 3, -3);
INSERT INTO festivo (dia, mes, nombre, idtipo, diaspascua) VALUES(0, 0, 'Viernes Santo', 3, -2);
INSERT INTO festivo (dia, mes, nombre, idtipo, diaspascua) VALUES(0, 0, 'Domingo de Pascua', 3, 0);
INSERT INTO festivo (dia, mes, nombre, idtipo, diaspascua) VALUES(1, 5, 'Día del Trabajo', 1, 0);
INSERT INTO festivo (dia, mes, nombre, idtipo, diaspascua) VALUES(0, 0, 'Ascensión del Señor', 4, 40);
INSERT INTO festivo (dia, mes, nombre, idtipo, diaspascua) VALUES(0, 0, 'Corpus Christi', 4, 61);
INSERT INTO festivo (dia, mes, nombre, idtipo, diaspascua) VALUES(0, 0, 'Sagrado Corazón de Jesús', 4, 68);
INSERT INTO festivo (dia, mes, nombre, idtipo, diaspascua) VALUES(29, 6, 'San Pedro y San Pablo', 2, 0);
INSERT INTO festivo (dia, mes, nombre, idtipo, diaspascua) VALUES(20, 7, 'Independencia Colombia', 1, 0);
INSERT INTO festivo (dia, mes, nombre, idtipo, diaspascua) VALUES(7, 8, 'Batalla de Boyacá', 1, 0);
INSERT INTO festivo (dia, mes, nombre, idtipo, diaspascua) VALUES(15, 8, 'Asunción de la Virgen', 2, 0);
INSERT INTO festivo (dia, mes, nombre, idtipo, diaspascua) VALUES(12, 10, 'Día de la Raza', 2, 0);
INSERT INTO festivo (dia, mes, nombre, idtipo, diaspascua) VALUES(1, 11, 'Todos los santos', 2, 0);
INSERT INTO festivo (dia, mes, nombre, idtipo, diaspascua) VALUES(11, 11, 'Independencia de Cartagena', 2, 0);
INSERT INTO festivo (dia, mes, nombre, idtipo, diaspascua) VALUES(8, 12, 'Inmaculada Concepción', 1, 0);
INSERT INTO festivo (dia, mes, nombre, idtipo, diaspascua) VALUES(25, 12, 'Navidad', 1, 0);
