-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Proveedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Proveedor` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Proveedor` (
  `idProveedor` INT NULL AUTO_INCREMENT,
  `NombreProveedor` VARCHAR(45) NULL,
  PRIMARY KEY (`idProveedor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Producto` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Producto` (
  `idProducto` INT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NULL,
  `Precio` FLOAT NULL,
  `FechaCaducidad` DATE NULL,
  `Proveedor_idProveedor` INT NOT NULL,
  PRIMARY KEY (`idProducto`, `Proveedor_idProveedor`),
  INDEX `fk_Producto_Proveedor1_idx` (`Proveedor_idProveedor` ASC),
  CONSTRAINT `fk_Producto_Proveedor1`
    FOREIGN KEY (`Proveedor_idProveedor`)
    REFERENCES `mydb`.`Proveedor` (`idProveedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Detalle_Ventas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Detalle_Ventas` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Detalle_Ventas` (
  `idDetalle_Ventas` INT NULL AUTO_INCREMENT,
  `Cantidad` FLOAT NULL,
  `Precio` FLOAT NULL,
  `Producto_idProducto` INT NOT NULL,
  PRIMARY KEY (`idDetalle_Ventas`),
  INDEX `fk_Detalle_Ventas_Producto1_idx` (`Producto_idProducto` ASC),
  CONSTRAINT `fk_Detalle_Ventas_Producto1`
    FOREIGN KEY (`Producto_idProducto`)
    REFERENCES `mydb`.`Producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Venta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Venta` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Venta` (
  `idVenta` INT NULL AUTO_INCREMENT,
  `FechaVenta` DATE NULL,
  `PrecioTotalVenta` FLOAT NULL,
  `Detalle_Ventas_idDetalle_Ventas` INT NOT NULL,
  PRIMARY KEY (`idVenta`),
  INDEX `fk_Venta_Detalle_Ventas_idx` (`Detalle_Ventas_idDetalle_Ventas` ASC),
  CONSTRAINT `fk_Venta_Detalle_Ventas`
    FOREIGN KEY (`Detalle_Ventas_idDetalle_Ventas`)
    REFERENCES `mydb`.`Detalle_Ventas` (`idDetalle_Ventas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Detalle_Compras`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Detalle_Compras` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Detalle_Compras` (
  `idDetalle_Compras` INT NULL AUTO_INCREMENT,
  `Cantidad` FLOAT NULL,
  `Precio` VARCHAR(45) NULL,
  `Producto_idProducto` INT NOT NULL,
  `Producto_Proveedor_idProveedor` INT NOT NULL,
  PRIMARY KEY (`idDetalle_Compras`),
  INDEX `fk_Detalle_Compras_Producto1_idx` (`Producto_idProducto` ASC, `Producto_Proveedor_idProveedor` ASC),
  CONSTRAINT `fk_Detalle_Compras_Producto1`
    FOREIGN KEY (`Producto_idProducto` , `Producto_Proveedor_idProveedor`)
    REFERENCES `mydb`.`Producto` (`idProducto` , `Proveedor_idProveedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Compra`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Compra` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Compra` (
  `idCompra` INT NULL AUTO_INCREMENT,
  `FechaCompra` DATE NULL,
  `PrecioTotalCompra` FLOAT NULL,
  `Detalle_Compras_idDetalle_Compras` INT NOT NULL,
  PRIMARY KEY (`idCompra`),
  INDEX `fk_Compra_Detalle_Compras1_idx` (`Detalle_Compras_idDetalle_Compras` ASC),
  CONSTRAINT `fk_Compra_Detalle_Compras1`
    FOREIGN KEY (`Detalle_Compras_idDetalle_Compras`)
    REFERENCES `mydb`.`Detalle_Compras` (`idDetalle_Compras`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ReporteExistencia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`ReporteExistencia` ;

CREATE TABLE IF NOT EXISTS `mydb`.`ReporteExistencia` (
  `idReporteExistencia` INT NULL AUTO_INCREMENT,
  `Compra_idCompra` INT NOT NULL,
  `Venta_idVenta` INT NOT NULL,
  PRIMARY KEY (`idReporteExistencia`),
  INDEX `fk_ReporteExistencia_Compra1_idx` (`Compra_idCompra` ASC),
  INDEX `fk_ReporteExistencia_Venta1_idx` (`Venta_idVenta` ASC),
  CONSTRAINT `fk_ReporteExistencia_Compra1`
    FOREIGN KEY (`Compra_idCompra`)
    REFERENCES `mydb`.`Compra` (`idCompra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ReporteExistencia_Venta1`
    FOREIGN KEY (`Venta_idVenta`)
    REFERENCES `mydb`.`Venta` (`idVenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;