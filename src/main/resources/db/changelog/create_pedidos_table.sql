-- liquibase formatted sql
-- changeset Lucy:createPedidosTable

create table pedidos
(
    id           BIGINT                                   not null auto_increment primary key,
    estado       enum ('ACTIVO', 'INACTIVO', 'ELIMINADO') null default 'ACTIVO',
    created_at   TIMESTAMP                                null default current_timestamp,
    updated_at   TIMESTAMP                                null on update current_timestamp,
    reservas_id  BIGINT                                   not null,
    platos_id    BIGINT                                   not null,
    bebidas_id   BIGINT                                   not null,
    FOREIGN KEY (reservas_id) REFERENCES reservas (id),
    FOREIGN KEY (platos_id) REFERENCES platos (id),
    FOREIGN KEY (bebidas_id) REFERENCES bebidas (id)
);