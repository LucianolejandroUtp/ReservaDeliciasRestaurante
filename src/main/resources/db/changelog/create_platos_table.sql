--liquibase formatted sql
--changeset Lucy:createPlatosTable

CREATE TABLE platos
(
    id            BIGINT                                   NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre        VARCHAR(100)                             NOT NULL,
    descripcion   TEXT,
    precio        DECIMAL(10, 2)                           NOT NULL,
    disponible    BOOLEAN                                  NOT NULL DEFAULT TRUE,
    stock         INT                                      NOT NULL DEFAULT 0,
    estado        enum ('ACTIVO', 'INACTIVO', 'ELIMINADO') NOT NULL DEFAULT 'ACTIVO',
    created_at    TIMESTAMP                                NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at    TIMESTAMP                                NULL ON UPDATE CURRENT_TIMESTAMP,
    categorias_id BIGINT                                   NOT NULL,
    FOREIGN KEY (categorias_id) REFERENCES categorias (id)
);
