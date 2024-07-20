-- liquibase formatted sql
-- changeset Lucy:insertRolesTable

INSERT INTO delicias_rest.roles (descripcion) VALUES ('ADMIN,RECEPCIONISTA,USER,INVITADO');
INSERT INTO delicias_rest.roles (descripcion) VALUES ('RECEPCIONISTA');
INSERT INTO delicias_rest.roles (descripcion) VALUES ('USER');
INSERT INTO delicias_rest.roles (descripcion) VALUES ('INVITADO');

