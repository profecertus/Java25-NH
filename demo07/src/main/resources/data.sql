-- ===========================================================================
-- DML - Datos de ejemplo (seed) del modulo de ventas (H2)
-- ===========================================================================
-- Se ejecuta despues de schema.sql. Fijamos los ids a mano para poder enlazar
-- las FKs de forma legible en la demo (con IDENTITY, insertar un id explicito
-- es valido en H2).
--
-- NOTA: al usar este data.sql desactivamos el CommandLineRunner 'seed' de
-- ApiRestApplication para no duplicar los productos (ver esa clase).
-- ===========================================================================

-- --- Productos (catalogo) ---------------------------------------------------
INSERT INTO producto (id, nombre, precio, categoria) VALUES
    (1, 'Laptop',            3000.0, 'tech'),
    (2, 'Mouse',               80.0, 'tech'),
    (3, 'Teclado mecanico',   250.0, 'tech'),
    (4, 'Silla ergonomica',   900.0, 'oficina'),
    (5, 'Escritorio',        1200.0, 'oficina');

-- --- Clientes ---------------------------------------------------------------
INSERT INTO clientes (id, nombre, email) VALUES
    (1, 'Ana Torres',   'ana.torres@example.com'),
    (2, 'Luis Ramirez', 'luis.ramirez@example.com'),
    (3, 'Marta Diaz',   'marta.diaz@example.com');

-- --- Pagos ------------------------------------------------------------------
-- Solo los pedidos ya cobrados tienen pago (relacion 1..1 opcional).
INSERT INTO pagos (id, metodo, monto, fecha_pago) VALUES
    (1, 'TARJETA',        3080.00, TIMESTAMP '2026-07-18 10:16:00'),
    (2, 'TRANSFERENCIA',  1200.00, TIMESTAMP '2026-07-19 09:05:00');

-- --- Pedidos ----------------------------------------------------------------
-- Pedido 1 (Ana): PAGADO con tarjeta -> pago_id = 1
-- Pedido 2 (Luis): PAGADO por transferencia -> pago_id = 2
-- Pedido 3 (Marta): PENDIENTE, aun sin pago -> pago_id = NULL
INSERT INTO pedidos (id, fecha, estado, cliente_id, pago_id) VALUES
    (1, TIMESTAMP '2026-07-18 10:15:00', 'PAGADO',    1, 1),
    (2, TIMESTAMP '2026-07-19 09:00:00', 'PAGADO',    2, 2),
    (3, TIMESTAMP '2026-07-20 15:30:00', 'PENDIENTE', 3, NULL);

-- --- Detalle de pedido (lineas, con clave compuesta) ------------------------
-- Pedido 1: 1 Laptop (3000) + 1 Mouse (80) = 3080  -> coincide con pago 1
INSERT INTO detalle_pedido (pedido_id, producto_id, cantidad, precio_unitario) VALUES
    (1, 1, 1, 3000.00),
    (1, 2, 1,   80.00);

-- Pedido 2: 1 Escritorio (1200) = 1200 -> coincide con pago 2
INSERT INTO detalle_pedido (pedido_id, producto_id, cantidad, precio_unitario) VALUES
    (2, 5, 1, 1200.00);

-- Pedido 3 (pendiente): 2 Teclados (250) + 1 Silla (900) = 1400
INSERT INTO detalle_pedido (pedido_id, producto_id, cantidad, precio_unitario) VALUES
    (3, 3, 2, 250.00),
    (3, 4, 1, 900.00);
