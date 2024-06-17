-- liquibase formatted sql
-- changeset Lucy:createDistritosTable

CREATE TABLE distritos
(
    id          BIGINT                                                                  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(100)                                              NOT NULL,
    estado      enum ('ACTIVO', 'INACTIVO', 'ELIMINADO')   NULL DEFAULT 'ACTIVO',
    created_at  TIMESTAMP                                                   NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP                                                  NULL ON UPDATE CURRENT_TIMESTAMP
);

