--liquibase formatted sql
--changeset Lucy:createUsuariosTable

CREATE TABLE usuarios
(
    id           BIGINT                                   NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombres      VARCHAR(100)                             NOT NULL,
    apellido_pat VARCHAR(100)                             NOT NULL,
    apellido_mat VARCHAR(100)                             NOT NULL,
    telefono     VARCHAR(100)                             NOT NULL,
    direccion    VARCHAR(100)                             NOT NULL,
    referencia   VARCHAR(100)                             NOT NULL,
    dni          VARCHAR(100)                             NOT NULL,
    email        VARCHAR(100)                             NOT NULL,
    password     VARCHAR(100)                             NOT NULL,
    estado       enum ('ACTIVO', 'INACTIVO', 'ELIMINADO') NOT NULL DEFAULT 'ACTIVO',
    created_at   TIMESTAMP                                NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP                                NULL ON UPDATE CURRENT_TIMESTAMP,
    distritos_id BIGINT                                   NOT NULL,
    roles_id     BIGINT                                   NOT NULL,
    FOREIGN KEY (distritos_id) REFERENCES distritos (id),
    FOREIGN KEY (roles_id) REFERENCES roles (id)
);

