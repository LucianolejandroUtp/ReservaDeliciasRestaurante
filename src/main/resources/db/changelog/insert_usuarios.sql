-- liquibase formatted sql
-- changeset Lucy:insertUsuariosTable

INSERT INTO delicias_rest.usuarios (nombres, apellido_pat, apellido_mat, telefono, direccion, referencia, dni, email, password, distritos_id, roles_id)
VALUES ('Admin', 'Admin', 'Admin', '999999999', 'Direccion', 'Referencia', '99999999', 'admin@admin.com', '$2a$12$ieyUosFWB0bdv9AkT8TSUenZt23O5y3Tj/fqAhK8X6Tlwi5XJMhBa', 2,1);
INSERT INTO delicias_rest.usuarios (nombres, apellido_pat, apellido_mat, telefono, direccion, referencia, dni, email, password, distritos_id, roles_id)
VALUES ('Recepcionista', 'Recepcionista', 'Recepcionista', '999999999', 'Direccion', 'Referencia', '99999999', 'recepcionsta@recepcionista.com', '$2a$12$ieyUosFWB0bdv9AkT8TSUenZt23O5y3Tj/fqAhK8X6Tlwi5XJMhBa', 2,2);
INSERT INTO delicias_rest.usuarios (nombres, apellido_pat, apellido_mat, telefono, direccion, referencia, dni, email, password, distritos_id, roles_id)
VALUES ('User', 'User', 'User', '999999999', 'Direccion', 'Referencia', '99999999', 'user@user.com', '$2a$12$ieyUosFWB0bdv9AkT8TSUenZt23O5y3Tj/fqAhK8X6Tlwi5XJMhBa', 2,3);
