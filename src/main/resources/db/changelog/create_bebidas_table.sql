-- liquibase formatted sql
-- changeset Lucy:createBebidasTable

CREATE TABLE bebidas
(
    id            BIGINT                                   NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre        VARCHAR(100)                             NOT NULL,
    descripcion   TEXT                                     NOT NULL,
    precio        INT                                      NOT NULL,
    stock         INT                                      NOT NULL DEFAULT 0,
    estado        enum ('ACTIVO', 'INACTIVO', 'ELIMINADO') NULL     DEFAULT 'ACTIVO',
    created_at    TIMESTAMP                                NULL     DEFAULT CURRENT_TIMESTAMP,
    updated_at    TIMESTAMP                                NULL ON UPDATE CURRENT_TIMESTAMP,
    categorias_id BIGINT                                   NOT NULL,
    FOREIGN KEY (categorias_id) REFERENCES categorias (id)
);
