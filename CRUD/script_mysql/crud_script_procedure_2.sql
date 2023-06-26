
-- Procedimiento almacenado para actualizar
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarPersona`(
    IN p_Dni VARCHAR(15),
    IN p_Nombre VARCHAR(50),
    IN p_Edad VARCHAR(4),
    IN p_Genero VARCHAR(45)
)
BEGIN
    UPDATE persona
    SET Nombre = p_Nombre, Edad = p_Edad, Genero = p_Genero
    WHERE Dni = p_Dni;
END ;;
DELIMITER ;


-- Procedimiento almacenado para eliminar
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `EliminarPersona`(
    IN p_Dni VARCHAR(15)
)
BEGIN
    DELETE FROM persona
    WHERE Dni = p_Dni;
END ;;
 
 
 -- Procedimiento almacenado para insertar
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertarPersona`(
    IN p_Dni VARCHAR(15),
    IN p_Nombre VARCHAR(50),
    IN p_Edad VARCHAR(4),
    IN p_Genero VARCHAR(45)
)
BEGIN
    INSERT INTO persona (Dni, Nombre, Edad, Genero)
    VALUES (p_Dni, p_Nombre, p_Edad, p_Genero);
END ;;


-- Procedimiento almacenado para listar 
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ListarPersona`(
    IN p_Dni VARCHAR(15)
)
BEGIN
    select dni, nombre, edad, genero from persona 
    where dni = p_Dni;
END ;;
DELIMITER ;


