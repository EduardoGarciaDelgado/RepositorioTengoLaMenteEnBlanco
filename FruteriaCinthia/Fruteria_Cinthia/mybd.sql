-- phpMyAdmin SQL Dump
-- version 4.7.3
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:8889
-- Tiempo de generación: 16-05-2018 a las 22:21:43
-- Versión del servidor: 5.6.35-log
-- Versión de PHP: 7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de datos: `mydb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Compra`
--

CREATE TABLE `Compra` (
  `idCompra` int(11) NOT NULL,
  `FechaCompra` date DEFAULT NULL,
  `PrecioTotalCompra` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `Compra`
--

INSERT INTO `Compra` (`idCompra`, `FechaCompra`, `PrecioTotalCompra`) VALUES
(1, '2018-04-18', 0),
(2, '2018-04-24', 0),
(3, '2018-04-14', 0),
(4, '2018-04-14', 0),
(5, '2018-04-14', 0),
(6, '2018-04-14', 0),
(7, '2018-04-14', 0),
(8, '2018-04-14', 0),
(9, '2018-04-14', 0),
(10, '2018-04-14', 0),
(11, '2018-04-14', 0),
(12, '2018-04-14', 0),
(13, '2018-04-14', 36),
(14, '2018-04-14', 0),
(15, '2018-04-14', 0),
(16, '2018-04-14', 0),
(17, '2018-04-14', 0),
(18, '2018-04-14', 40),
(19, '2018-04-14', 0),
(20, '2018-04-14', 57),
(21, '2018-04-14', 30),
(22, '2018-04-14', 500),
(23, '2018-04-16', 54),
(24, '2018-04-16', 200),
(25, '2018-04-16', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Detalle_Compras`
--

CREATE TABLE `Detalle_Compras` (
  `idDetalle_Compras` int(11) NOT NULL,
  `Cantidad` float DEFAULT NULL,
  `Precio` varchar(45) DEFAULT NULL,
  `Producto_idProducto` int(11) NOT NULL,
  `Proveedor_idProveedor` int(11) NOT NULL,
  `Compra_idCompra` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `Detalle_Compras`
--

INSERT INTO `Detalle_Compras` (`idDetalle_Compras`, `Cantidad`, `Precio`, `Producto_idProducto`, `Proveedor_idProveedor`, `Compra_idCompra`) VALUES
(1, 5, '75', 1, 1, 1),
(2, 3, '39', 2, 1, 1),
(3, 4, '72', 3, 2, 2),
(4, 3, '12.0', 19, 4, 13),
(5, 2, '21.0', 19, 4, 17),
(6, 2, '20.0', 19, 4, 18),
(7, 2, '15.0', 19, 4, 20),
(8, 3, '9.0', 16, 2, 20),
(9, 2, '15.0', 19, 4, 21),
(10, 10, '8.0', 16, 2, 22),
(11, 10, '7.0', 17, 2, 22),
(12, 10, '20.0', 18, 1, 22),
(13, 10, '15.0', 19, 4, 22),
(14, 2, '7.0', 17, 2, 23),
(15, 2, '20.0', 18, 1, 23),
(16, 10, '20.0', 21, 4, 24);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Detalle_Ventas`
--

CREATE TABLE `Detalle_Ventas` (
  `idDetalle_Ventas` int(11) NOT NULL,
  `Cantidad` float DEFAULT NULL,
  `PrecioVenta` float DEFAULT NULL,
  `Producto_idProducto` int(11) NOT NULL,
  `Venta_idVenta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `Detalle_Ventas`
--

INSERT INTO `Detalle_Ventas` (`idDetalle_Ventas`, `Cantidad`, `PrecioVenta`, `Producto_idProducto`, `Venta_idVenta`) VALUES
(1, 2, 30, 1, 1),
(2, 3, 54, 3, 1),
(3, 2, 26, 2, 1),
(4, 2, 12, 16, 6),
(5, 2, 12, 16, 7),
(6, 3, 23, 18, 12),
(7, 2, 22, 19, 14),
(8, 3, 12, 16, 14),
(9, 2, 12, 16, 15),
(10, 2, 22, 19, 17),
(11, 3, 23, 18, 18),
(12, 2, 22, 19, 19),
(13, 2, 22, 19, 20),
(14, 2, 12, 16, 22),
(15, 3, 22, 19, 22),
(16, 2, 12, 16, 23),
(17, 3, 22, 19, 23),
(18, 1, 9, 17, 24),
(19, 4, 23, 18, 24),
(20, 2, 23, 18, 25),
(21, 2, 9, 17, 25),
(22, 3, 8, 20, 26),
(23, 2, 22, 19, 26),
(24, 8, 25, 21, 27);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Producto`
--

CREATE TABLE `Producto` (
  `idProducto` int(11) NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `Precio` float DEFAULT NULL,
  `PrecioVenta` float DEFAULT NULL,
  `FechaCaducidad` date DEFAULT NULL,
  `Proveedor_idProveedor` int(11) NOT NULL,
  `Cantidad` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `Producto`
--

INSERT INTO `Producto` (`idProducto`, `Nombre`, `Precio`, `PrecioVenta`, `FechaCaducidad`, `Proveedor_idProveedor`, `Cantidad`) VALUES
(1, 'Coca Cola 600ml', 15, NULL, '2018-04-28', 1, 10),
(2, 'Delaware Punch 600ml', 13, NULL, '2018-05-26', 1, 10),
(3, 'Cremax 322gr', 18, NULL, '2018-06-23', 2, 10),
(9, 'Flipy 25gr', 8, NULL, '2018-12-12', 2, 20),
(13, 'Emperador 30gr', 13, NULL, '2018-12-28', 2, 17),
(16, 'Chokis 300gr', 8, 12, '2018-03-08', 2, 10),
(17, 'Piruetas', 7, 9, '2018-01-01', 2, 10),
(18, 'Sprite', 20, 23, '2018-01-01', 1, 10),
(19, 'Tomates', 15, 22, '2018-01-01', 4, 8),
(20, 'Jumex', 6, 8, '2018-01-01', 1, 7),
(21, 'Star Fruit', 20, 25, '2018-12-01', 4, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Proveedor`
--

CREATE TABLE `Proveedor` (
  `idProveedor` int(11) NOT NULL,
  `NombreProveedor` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `Proveedor`
--

INSERT INTO `Proveedor` (`idProveedor`, `NombreProveedor`) VALUES
(1, 'Coca Cola Company'),
(2, 'Gamesa'),
(4, 'Ricardo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ReporteExistencia`
--

CREATE TABLE `ReporteExistencia` (
  `idReporteExistencia` int(11) NOT NULL,
  `Compra_idCompra` int(11) NOT NULL,
  `Venta_idVenta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Venta`
--

CREATE TABLE `Venta` (
  `idVenta` int(11) NOT NULL,
  `FechaVenta` date DEFAULT NULL,
  `PrecioTotalVenta` float DEFAULT NULL,
  `Ganancia` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `Venta`
--

INSERT INTO `Venta` (`idVenta`, `FechaVenta`, `PrecioTotalVenta`, `Ganancia`) VALUES
(1, '2018-04-30', 0, NULL),
(2, '2018-04-13', 0, NULL),
(3, '2018-04-13', 0, NULL),
(4, '2018-04-13', 0, NULL),
(5, '2018-04-13', 0, NULL),
(6, '2018-04-13', 24, NULL),
(7, '2018-04-13', 24, NULL),
(8, '2018-04-14', 0, NULL),
(9, '2018-04-14', 0, NULL),
(10, '2018-04-14', 0, 0),
(11, '2018-04-14', 0, 0),
(12, '2018-04-14', 0, 0),
(13, '2018-04-14', 0, 0),
(14, '2018-04-14', 80, 0),
(15, '2018-04-14', 24, 0),
(16, '2018-04-14', 0, 0),
(17, '2018-04-14', 44, 0),
(18, '2018-04-14', 69, 0),
(19, '2018-04-14', 44, 0),
(20, '2018-04-14', 44, 0),
(21, '2018-04-14', 0, 0),
(22, '2018-04-14', 0, 0),
(23, '2018-04-14', 90, 29),
(24, '2018-04-14', 101, 14),
(25, '2018-04-14', 64, 10),
(26, '2018-04-16', 68, 20),
(27, '2018-04-16', 200, 40);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Compra`
--
ALTER TABLE `Compra`
  ADD PRIMARY KEY (`idCompra`);

--
-- Indices de la tabla `Detalle_Compras`
--
ALTER TABLE `Detalle_Compras`
  ADD PRIMARY KEY (`idDetalle_Compras`),
  ADD KEY `fk_Detalle_Compras_Producto1_idx` (`Producto_idProducto`),
  ADD KEY `fk_Detalle_Compras_Proveedor1_idx` (`Proveedor_idProveedor`),
  ADD KEY `fk_Detalle_Compras_Compra1_idx` (`Compra_idCompra`);

--
-- Indices de la tabla `Detalle_Ventas`
--
ALTER TABLE `Detalle_Ventas`
  ADD PRIMARY KEY (`idDetalle_Ventas`),
  ADD KEY `fk_Detalle_Ventas_Producto1_idx` (`Producto_idProducto`),
  ADD KEY `fk_Detalle_Ventas_Venta1_idx` (`Venta_idVenta`);

--
-- Indices de la tabla `Producto`
--
ALTER TABLE `Producto`
  ADD PRIMARY KEY (`idProducto`,`Proveedor_idProveedor`),
  ADD KEY `fk_Producto_Proveedor1_idx` (`Proveedor_idProveedor`);

--
-- Indices de la tabla `Proveedor`
--
ALTER TABLE `Proveedor`
  ADD PRIMARY KEY (`idProveedor`);

--
-- Indices de la tabla `ReporteExistencia`
--
ALTER TABLE `ReporteExistencia`
  ADD PRIMARY KEY (`idReporteExistencia`),
  ADD KEY `fk_ReporteExistencia_Compra1_idx` (`Compra_idCompra`),
  ADD KEY `fk_ReporteExistencia_Venta1_idx` (`Venta_idVenta`);

--
-- Indices de la tabla `Venta`
--
ALTER TABLE `Venta`
  ADD PRIMARY KEY (`idVenta`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Compra`
--
ALTER TABLE `Compra`
  MODIFY `idCompra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT de la tabla `Detalle_Compras`
--
ALTER TABLE `Detalle_Compras`
  MODIFY `idDetalle_Compras` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT de la tabla `Detalle_Ventas`
--
ALTER TABLE `Detalle_Ventas`
  MODIFY `idDetalle_Ventas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT de la tabla `Producto`
--
ALTER TABLE `Producto`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT de la tabla `Proveedor`
--
ALTER TABLE `Proveedor`
  MODIFY `idProveedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `ReporteExistencia`
--
ALTER TABLE `ReporteExistencia`
  MODIFY `idReporteExistencia` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `Venta`
--
ALTER TABLE `Venta`
  MODIFY `idVenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `Detalle_Compras`
--
ALTER TABLE `Detalle_Compras`
  ADD CONSTRAINT `fk_Detalle_Compras_Compra1` FOREIGN KEY (`Compra_idCompra`) REFERENCES `Compra` (`idCompra`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Detalle_Compras_Producto1` FOREIGN KEY (`Producto_idProducto`) REFERENCES `Producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Detalle_Compras_Proveedor1` FOREIGN KEY (`Proveedor_idProveedor`) REFERENCES `Proveedor` (`idProveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `Detalle_Ventas`
--
ALTER TABLE `Detalle_Ventas`
  ADD CONSTRAINT `fk_Detalle_Ventas_Producto1` FOREIGN KEY (`Producto_idProducto`) REFERENCES `Producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Detalle_Ventas_Venta1` FOREIGN KEY (`Venta_idVenta`) REFERENCES `Venta` (`idVenta`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `Producto`
--
ALTER TABLE `Producto`
  ADD CONSTRAINT `fk_Producto_Proveedor1` FOREIGN KEY (`Proveedor_idProveedor`) REFERENCES `Proveedor` (`idProveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `ReporteExistencia`
--
ALTER TABLE `ReporteExistencia`
  ADD CONSTRAINT `fk_ReporteExistencia_Compra1` FOREIGN KEY (`Compra_idCompra`) REFERENCES `Compra` (`idCompra`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_ReporteExistencia_Venta1` FOREIGN KEY (`Venta_idVenta`) REFERENCES `Venta` (`idVenta`) ON DELETE NO ACTION ON UPDATE NO ACTION;
