-- Utilizar en phpmyadmin o HeidiSQL

DELIMITER //
CREATE TRIGGER tri_distritos_insert
    before INSERT
    ON distritos FOR EACH ROW
begin
    IF NEW.estado IS NULL THEN
        SET NEW.estado = 'ACTIVO';
    END if;
    IF NEW.created_at IS NULL THEN
        SET NEW.created_at = CURRENT_TIMESTAMP;
    END IF;
end//
DELIMITER ;

DELIMITER //
CREATE TRIGGER tri_roles_insert
    before INSERT
    ON roles FOR EACH ROW
begin
    IF NEW.estado IS NULL THEN
        SET NEW.estado = 'ACTIVO';
    END if;
    IF NEW.created_at IS NULL THEN
        SET NEW.created_at = CURRENT_TIMESTAMP;
    END IF;
end//
DELIMITER ;

DELIMITER //
CREATE TRIGGER tri_usuarios_insert
    before INSERT
    ON usuarios FOR EACH ROW
begin
    IF NEW.estado IS NULL THEN
        SET NEW.estado = 'ACTIVO';
    END if;
    IF NEW.created_at IS NULL THEN
        SET NEW.created_at = CURRENT_TIMESTAMP;
    END IF;
end//
DELIMITER ;

DELIMITER //
CREATE TRIGGER tri_reservas_insert
    before INSERT
    ON reservas FOR EACH ROW
begin
    IF NEW.estado IS NULL THEN
SET NEW.estado = 'ACTIVO';
END if;
IF NEW.created_at IS NULL THEN
SET NEW.created_at = CURRENT_TIMESTAMP;
END IF;
end//
DELIMITER ;

DELIMITER //
CREATE TRIGGER tri_platos_insert
    before INSERT
    ON platos FOR EACH ROW
begin
    IF NEW.estado IS NULL THEN
SET NEW.estado = 'ACTIVO';
END if;
IF NEW.created_at IS NULL THEN
SET NEW.created_at = CURRENT_TIMESTAMP;
END IF;
end//
DELIMITER ;

DELIMITER //
CREATE TRIGGER tri_bebidas_insert
    before INSERT
    ON bebidas FOR EACH ROW
begin
    IF NEW.estado IS NULL THEN
SET NEW.estado = 'ACTIVO';
END if;
IF NEW.created_at IS NULL THEN
SET NEW.created_at = CURRENT_TIMESTAMP;
END IF;
end//
DELIMITER ;

DELIMITER //
CREATE TRIGGER tri_categorias_insert
    before INSERT
    ON categorias FOR EACH ROW
begin
    IF NEW.estado IS NULL THEN
SET NEW.estado = 'ACTIVO';
END if;
IF NEW.created_at IS NULL THEN
SET NEW.created_at = CURRENT_TIMESTAMP;
END IF;
end//
DELIMITER ;





DELIMITER //
CREATE TRIGGER tri_distritos_update
    before update
    ON distritos FOR EACH ROW
begin
    IF NEW.updated_at IS NULL THEN
        SET NEW.updated_at = CURRENT_TIMESTAMP;
    END IF;
end//
DELIMITER ;

DELIMITER //
CREATE TRIGGER tri_roles_update
    before update
    ON roles FOR EACH ROW
begin
    IF NEW.updated_at IS NULL THEN
        SET NEW.updated_at = CURRENT_TIMESTAMP;
    END IF;
end//
DELIMITER ;

DELIMITER //
CREATE TRIGGER tri_usuarios_update
    before update
    ON usuarios FOR EACH ROW
begin
    IF NEW.updated_at IS NULL THEN
        SET NEW.updated_at = CURRENT_TIMESTAMP;
    END IF;
end//
DELIMITER ;

DELIMITER //
CREATE TRIGGER tri_reservas_update
    before update
    ON reservas FOR EACH ROW
begin
    IF NEW.updated_at IS NULL THEN
        SET NEW.updated_at = CURRENT_TIMESTAMP;
    END IF;
end//
DELIMITER ;

DELIMITER //
CREATE TRIGGER tri_platos_update
    before update
    ON platos FOR EACH ROW
begin
    IF NEW.updated_at IS NULL THEN
        SET NEW.updated_at = CURRENT_TIMESTAMP;
    END IF;
end//
DELIMITER ;

DELIMITER //
CREATE TRIGGER tri_bebidas_update
    before update
    ON bebidas FOR EACH ROW
begin
    IF NEW.updated_at IS NULL THEN
        SET NEW.updated_at = CURRENT_TIMESTAMP;
    END IF;
end//
DELIMITER ;

DELIMITER //
CREATE TRIGGER tri_categorias_update
    before update
    ON categorias FOR EACH ROW
begin
    IF NEW.updated_at IS NULL THEN
        SET NEW.updated_at = CURRENT_TIMESTAMP;
    END IF;
end//
DELIMITER ;
