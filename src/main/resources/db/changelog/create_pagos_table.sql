-- liquibase formatted sql
-- changeset Lucy:createPagosTable

CREATE TABLE pagos (
    id            BIGINT                                   NOT NULL AUTO_INCREMENT PRIMARY KEY,
    monto         INT                          NOT NULL,
    fecha         DATE                                     NOT NULL,
    hora          TIME                                     NULL,
    tipo          enum ('YAPE', 'EFECTIVO', 'TARJETA', 'TRANSFERENCIA') NOT NULL DEFAULT 'EFECTIVO',
    estado        enum ('PENDIENTE', 'APROBADO', 'RECHAZADO') NULL     DEFAULT 'PENDIENTE',
    created_at    TIMESTAMP                                NULL     DEFAULT CURRENT_TIMESTAMP,
    updated_at    TIMESTAMP                                NULL ON UPDATE CURRENT_TIMESTAMP,
    reservas_id   BIGINT                                   NOT NULL,
    FOREIGN KEY (reservas_id) REFERENCES reservas (id)
);