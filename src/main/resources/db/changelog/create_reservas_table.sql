--liquibase formatted sql
--changeset Lucy:createBebidasTable

CREATE TABLE reservas
(
    id           BIGINT                                   NOT NULL AUTO_INCREMENT PRIMARY KEY,
    fecha        DATE                                     NOT NULL,
    hora         TIME                                     NOT NULL,
    nro_personas INT                                      NOT NULL,
    estado       enum ('ACTIVO', 'INACTIVO', 'ELIMINADO') NOT NULL DEFAULT 'ACTIVO',
    created_at   TIMESTAMP                                 NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP                                NULL ON UPDATE CURRENT_TIMESTAMP,
    bebidas_id   BIGINT                                   NOT NULL,
    platos_id    BIGINT                                   NOT NULL,
    usuarios_id  BIGINT                                   NOT NULL,
    FOREIGN KEY (usuarios_id) REFERENCES usuarios (id),
    FOREIGN KEY (bebidas_id) REFERENCES bebidas (id),
    FOREIGN KEY (platos_id) REFERENCES platos (id)
);