DROP TABLE IF EXISTS ventas;
DROP TABLE IF EXISTS cliente;
DROP TABLE IF EXISTS producto;

CREATE TABLE cliente (
                         id BIGINT PRIMARY KEY,
                         nombre VARCHAR(75),
                         email VARCHAR(100)
);

CREATE TABLE producto (
                          id BIGINT PRIMARY KEY,
                          modelo VARCHAR(100),
                          precio FLOAT,
                          stock INT
);

CREATE TABLE ventas (
                        idVenta INT PRIMARY KEY,
                        idProducto BIGINT,
                        cantidad INT,
                        idCliente BIGINT,
                        nombreCliente VARCHAR(75),
                        fecha TIMESTAMP,
                        totalVenta FLOAT,
                        FOREIGN KEY (idProducto) REFERENCES producto(id),
                        FOREIGN KEY (idCliente) REFERENCES cliente(id)
);