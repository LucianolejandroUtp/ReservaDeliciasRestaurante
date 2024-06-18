-- liquibase formatted sql
-- changeset Lucy:eventPlatosTable

DROP EVENT IF EXISTS update_stock_daily;

CREATE EVENT update_stock_daily
    ON SCHEDULE EVERY 1 DAY
    STARTS CURRENT_DATE + INTERVAL 4 HOUR
    DO
    UPDATE platos
    SET stock = 20;