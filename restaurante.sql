-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.7.17-log - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para restaurante
CREATE DATABASE IF NOT EXISTS `restaurante` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `restaurante`;

-- Volcando estructura para tabla restaurante.acumulador
CREATE TABLE IF NOT EXISTS `acumulador` (
  `nombre` varchar(50) DEFAULT NULL,
  `acumulador` int(11) DEFAULT NULL,
  `Prefijo` varchar(5) DEFAULT NULL,
  `id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla restaurante.acumulador: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `acumulador` DISABLE KEYS */;
INSERT INTO `acumulador` (`nombre`, `acumulador`, `Prefijo`, `id`) VALUES
	('FACTURA', 102, 'FACT-', 1);
/*!40000 ALTER TABLE `acumulador` ENABLE KEYS */;

-- Volcando estructura para tabla restaurante.comidas
CREATE TABLE IF NOT EXISTS `comidas` (
  `idcomidas` int(11) NOT NULL AUTO_INCREMENT,
  `plato` varchar(100) NOT NULL,
  `urlimagen` varchar(100) NOT NULL,
  `ingredientes` varchar(500) NOT NULL,
  `jornada_idjornada` int(11) NOT NULL,
  `semana_idsemana` int(11) NOT NULL,
  `precio` int(11) NOT NULL,
  PRIMARY KEY (`idcomidas`,`jornada_idjornada`,`semana_idsemana`),
  KEY `fk_comidas_jornada1_idx` (`jornada_idjornada`),
  KEY `fk_comidas_semana1_idx` (`semana_idsemana`),
  CONSTRAINT `fk_comidas_jornada1` FOREIGN KEY (`jornada_idjornada`) REFERENCES `jornada` (`idjornada`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_comidas_semana1` FOREIGN KEY (`semana_idsemana`) REFERENCES `semana` (`idsemana`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla restaurante.comidas: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `comidas` DISABLE KEYS */;
INSERT INTO `comidas` (`idcomidas`, `plato`, `urlimagen`, `ingredientes`, `jornada_idjornada`, `semana_idsemana`, `precio`) VALUES
	(1, 'Hotcakes con Moras y Yoghurt', 'hotcakesmorayyoghurt.jpg', 'Ideal para un brunch o desayuno familiar, disfruta de estos deliciosos hotcakes con moras y yoghurt con tus seres queridos, ésta receta les encantará a todos.', 1, 1, 7000),
	(2, 'Tostadas Francesas', 'tostadas.png', 'Deliciosas Para acompañar tu desayuno. Tipicas americanas.', 1, 2, 7000),
	(3, 'Cazuela Cremosa de Atun', 'cazuelacremosadeatun.jpg', 'Esta receta es de un delicioso platillo de una cazuela cremosa de atún. Ideal para que disfrutes como ensalada o plato fuerte en tu comida, o incluso como almuerzo a medio dia.', 2, 1, 10000),
	(4, 'Sudado de Pescado con Coco', 'sudadopescadococo.jpg', 'El sudado de pescado con coco es una exquisita receta para compartir en el almuerzo con la familia.', 2, 2, 10000),
	(5, 'Ensalada César Tradicional', 'ensaladacesar.jpg', 'Esta receta es de una deliciosa ensalada que te encantará, la puedes compartir con tu familia en la cena en cualquier ocasión.', 3, 1, 8000),
	(6, 'Ensalada de Kale. Espinacas y Atún', 'ensaladakale.jpg', 'Esta cena es refrescante, rica y está repleta de hierro que te ayuda a prevenir la anemia. Si quieres cenar fuera de casa, te puedes llevar la ensalada. Solo guarda el atún en un tupper y la verdura en otro. Aderézala con limón y especias.', 3, 2, 10000);
/*!40000 ALTER TABLE `comidas` ENABLE KEYS */;

-- Volcando estructura para tabla restaurante.detalle_comida_factura
CREATE TABLE IF NOT EXISTS `detalle_comida_factura` (
  `iddetalle` int(11) NOT NULL AUTO_INCREMENT,
  `comidas_idcomidas` int(11) NOT NULL,
  `factura_id` varchar(10) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` int(11) NOT NULL,
  `preciounitario` int(11) NOT NULL,
  PRIMARY KEY (`iddetalle`,`comidas_idcomidas`,`factura_id`),
  KEY `fk_detalle_comidas1_idx` (`comidas_idcomidas`),
  KEY `fk_detalle_comida_factura1_idx` (`factura_id`),
  CONSTRAINT `FK_detalle_comida_factura_factura` FOREIGN KEY (`factura_id`) REFERENCES `factura` (`idfactura`),
  CONSTRAINT `fk_detalle_comidas1` FOREIGN KEY (`comidas_idcomidas`) REFERENCES `comidas` (`idcomidas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla restaurante.detalle_comida_factura: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `detalle_comida_factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_comida_factura` ENABLE KEYS */;

-- Volcando estructura para tabla restaurante.factura
CREATE TABLE IF NOT EXISTS `factura` (
  `idfactura` varchar(15) NOT NULL,
  `subtotal` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  `usuarios_idUsuarios` int(11) NOT NULL,
  `fecha_pedido` date NOT NULL,
  `transporte` enum('SI','NO') NOT NULL,
  `valor_transporte` int(11) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  PRIMARY KEY (`idfactura`),
  KEY `fk_usuarios_has_comidas_usuarios1_idx` (`usuarios_idUsuarios`),
  CONSTRAINT `fk_usuarios_has_comidas_usuarios1` FOREIGN KEY (`usuarios_idUsuarios`) REFERENCES `usuarios` (`idUsuarios`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla restaurante.factura: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;

-- Volcando estructura para tabla restaurante.jornada
CREATE TABLE IF NOT EXISTS `jornada` (
  `idjornada` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idjornada`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla restaurante.jornada: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `jornada` DISABLE KEYS */;
INSERT INTO `jornada` (`idjornada`, `nombre`) VALUES
	(1, 'DESAYUNO'),
	(2, 'ALMUERZO'),
	(3, 'CENA');
/*!40000 ALTER TABLE `jornada` ENABLE KEYS */;

-- Volcando estructura para tabla restaurante.semana
CREATE TABLE IF NOT EXISTS `semana` (
  `idsemana` int(11) NOT NULL AUTO_INCREMENT,
  `dia` varchar(45) NOT NULL,
  PRIMARY KEY (`idsemana`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla restaurante.semana: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `semana` DISABLE KEYS */;
INSERT INTO `semana` (`idsemana`, `dia`) VALUES
	(1, 'LUNES'),
	(2, 'MARTES'),
	(3, 'MIERCOLES'),
	(4, 'JUEVES'),
	(5, 'VIERNES');
/*!40000 ALTER TABLE `semana` ENABLE KEYS */;

-- Volcando estructura para tabla restaurante.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `idUsuarios` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `contrasena` varchar(45) NOT NULL,
  PRIMARY KEY (`idUsuarios`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla restaurante.usuarios: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` (`idUsuarios`, `nombre`, `contrasena`) VALUES
	(1, 'opamo', 'opamo'),
	(2, 'sergio', '1234'),
	(3, 'andrea', 'andrea1');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
