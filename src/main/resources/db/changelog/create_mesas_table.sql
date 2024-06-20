-- liquibase formatted sql
-- changeset Lucy:createMesasTable

create table mesas
(
    id          BIGINT not null auto_increment primary key,
    nro_mesa    INT    not null,
    capacidad   INT    not null,
    estado      enum ('ACTIVO', 'INACTIVO', 'ELIMINADO') null default 'ACTIVO',
    created_at  TIMESTAMP null default current_timestamp,
    updated_at  TIMESTAMP null on update current_timestamp
);