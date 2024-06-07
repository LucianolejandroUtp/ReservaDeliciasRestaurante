--liquibase formatted sql
--changeset Lucy:createCategoriasTable

CREATE TABLE categorias
(
    id          BIGINT                                   NOT NULL AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(100)                             NOT NULL,
    estado      enum ('ACTIVO', 'INACTIVO', 'ELIMINADO') NOT NULL DEFAULT 'ACTIVO',
    created_at  TIMESTAMP                                NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP                                NULL ON UPDATE CURRENT_TIMESTAMP
);
