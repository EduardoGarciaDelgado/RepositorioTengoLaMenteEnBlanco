-- phpMyAdmin SQL Dump
-- version 4.7.3
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:8889
-- Tiempo de generación: 18-04-2018 a las 23:52:29
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
(2, '2018-04-24', 0);

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
(3, 4, '72', 3, 2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Detalle_Ventas`
--

CREATE TABLE `Detalle_Ventas` (
  `idDetalle_Ventas` int(11) NOT NULL,
  `Cantidad` float DEFAULT NULL,
  `Precio` float DEFAULT NULL,
  `Producto_idProducto` int(11) NOT NULL,
  `Venta_idVenta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `Detalle_Ventas`
--

INSERT INTO `Detalle_Ventas` (`idDetalle_Ventas`, `Cantidad`, `Precio`, `Producto_idProducto`, `Venta_idVenta`) VALUES
(1, 2, 30, 1, 1),
(2, 3, 54, 3, 1),
(3, 2, 26, 2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Producto`
--

CREATE TABLE `Producto` (
  `idProducto` int(11) NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `Precio` float DEFAULT NULL,
  `FechaCaducidad` date DEFAULT NULL,
  `Proveedor_idProveedor` int(11) NOT NULL,
  `Cantidad` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `Producto`
--

INSERT INTO `Producto` (`idProducto`, `Nombre`, `Precio`, `FechaCaducidad`, `Proveedor_idProveedor`, `Cantidad`) VALUES
(1, 'Coca Cola 600ml', 15, '2018-04-28', 1, 10),
(2, 'Delaware Punch 600ml', 13, '2018-05-26', 1, 10),
(3, 'Cremax 322gr', 18, '2018-06-23', 2, 10),
(9, 'Flipy 25gr', 8, '2018-12-12', 2, 20),
(13, 'Emperador 30gr', 13, '2018-12-28', 2, 17);

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
(2, 'Gamesa');

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
  `PrecioTotalVenta` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `Venta`
--

INSERT INTO `Venta` (`idVenta`, `FechaVenta`, `PrecioTotalVenta`) VALUES
(1, '2018-04-30', 0);

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
  MODIFY `idCompra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `Detalle_Compras`
--
ALTER TABLE `Detalle_Compras`
  MODIFY `idDetalle_Compras` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `Detalle_Ventas`
--
ALTER TABLE `Detalle_Ventas`
  MODIFY `idDetalle_Ventas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `Producto`
--
ALTER TABLE `Producto`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT de la tabla `Proveedor`
--
ALTER TABLE `Proveedor`
  MODIFY `idProveedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `ReporteExistencia`
--
ALTER TABLE `ReporteExistencia`
  MODIFY `idReporteExistencia` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `Venta`
--
ALTER TABLE `Venta`
  MODIFY `idVenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
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
