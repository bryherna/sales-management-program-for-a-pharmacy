-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-09-2022 a las 00:26:07
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_boticacedhyfarma`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarProducto` (IN `_idProducto` INT(11))  BEGIN
	DELETE FROM producto where producto.idProducto = _idProducto;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spListaClientesGeneral` ()  BEGIN
	SELECT * FROM cliente cli inner join persona per on cli.idPersona = per.idPersona inner join pais p on per.idPais = p.idPais;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spListarDatosUsuariosPorId` (IN `_idUsuario` INT(11))  BEGIN

	SELECT * FROM usuario u inner join tipousuario tu on u.idTipoUsuario = tu.idTipoUsuario inner join trabajador tra on u.idTrabajador = tra.idTrabajador inner join persona per on tra.idPersona = per.idPersona WHERE u.idUsuario =_idUsuario ;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ActualizarUsuario` (IN `_idUsuario` INT(11), IN `_nombreUsuario` VARCHAR(40), IN `_idTipoUsuario` INT(11), IN `_idTrabajador` INT(11), IN `_password_usuario` VARCHAR(40), IN `_estadoUsuario` TINYINT(1))  BEGIN
	UPDATE usuario set usuario.nombreUsuario = _nombreUsuario, usuario.idTipoUsuario = _idTipoUsuario,
    usuario.idTrabajador = _idTrabajador, usuario.password_usuario = _password_usuario, usuario.estadoUsuario = _estadoUsuario
    WHERE usuario.idUsuario =_idUsuario ;


END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_AgregarCliente` (IN `_idCliente` INT, IN `_idPersona` INT, IN `_fechaInicio` DATE)  BEGIN
	INSERT INTO cliente (idCliente,idPersona,fechaInicio) VALUES (_idCliente,_idPersona,_fechaInicio);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_AgregarDetalleVenta` (IN `_idDetalleVenta` INT(11), IN `_idProducto` INT(11), IN `_idVenta` INT(11), IN `_precioProducto` DECIMAL(10,2), IN `_cantidad` INT(11))  BEGIN
	INSERT INTO detalleventa (idDetalleVenta,idProducto,idVenta,precioProducto,cantidad) VALUES (_idDetalleVenta,_idProducto,_idVenta,_precioProducto,_cantidad);

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_AgregarPersona` (IN `_idPersona` INT, IN `_idPais` INT, IN `_perApellidosNombres` VARCHAR(50), IN `_perFechaNac` DATE, IN `_perDni` VARCHAR(8), IN `_perEstado` TINYINT(1), IN `_perTelefono` VARCHAR(40), IN `_perDireccion` VARCHAR(40), IN `_perSexo` VARCHAR(2), IN `_perCorreo` VARCHAR(40))  BEGIN
	INSERT INTO persona (idPersona,idPais,perApellidosNombres,perFechaNac,perDni,perEstado,perTelefono,perDireccion,perSexo,perCorreo) values (_idPersona,_idPais,_perApellidosNombres,_perFechaNac,_perDni,_perEstado,_perTelefono,_perDireccion, _perSexo, _perCorreo );
	
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_AgregarTrabajador` (IN `_idTrabajador` INT(11), IN `_idPersona` INT(11), IN `_idCargoTrabajador` INT(11), IN `_idProfesion` INT(11), IN `_idRoles` INT(11), IN `_idTurno` INT(11), IN `_fechaInicio` DATE)  BEGIN
	INSERT INTO trabajador (idTrabajador,idPersona,idCargoTrabajador,idProfesion,idRoles,idTurno,fechaInicio) VALUES (_idTrabajador,_idPersona,_idCargoTrabajador,_idProfesion,_idRoles,_idTurno,_fechaInicio);

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_AgregarUsuario` (IN `_idUsuario` INT(11), IN `_nombreUsuario` VARCHAR(40), IN `_idTipoUsuario` INT(11), IN `_idTrabajador` INT(11), IN `_password_usuario` VARCHAR(40), IN `_estadoUsuario` TINYINT(1))  BEGIN
	INSERT INTO usuario (idUsuario,nombreUsuario,idTipoUsuario,idTrabajador,password_usuario,estadoUsuario) VALUES (_idUsuario,_nombreUsuario,_idTipoUsuario,_idTrabajador,_password_usuario,_estadoUsuario);

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_AgregarVenta` (IN `_idVenta` INT, IN `_idCliente` INT, IN `_idTrabajador` INT, IN `_idComprobanteVenta` INT, IN `_totalVenta` DECIMAL(10,2), IN `_fechaVenta` DATETIME, IN `_idModoPago` INT)  BEGIN
    
    INSERT INTO venta (idVenta,idCliente, idTrabajador,idComprobanteVenta,totalVenta,fechaVenta,idModoPago) VALUES (_idVenta,_idCliente, _idTrabajador,_idComprobanteVenta, _totalVenta,_fechaVenta,_idModoPago);
    
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscarClienteDNI` (IN `_dni` VARCHAR(8))  BEGIN
	SELECT * FROM cliente cli INNER join persona per on cli.idPersona = per.idPersona where per.perDni = _dni;
	
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_eliminarTrabajador` (IN `_idTrabajador` INT(11))  BEGIN
	DELETE trabajador, persona FROM trabajador inner join persona on trabajador.idPersona = persona.idPersona WHERE trabajador.idTrabajador = _idTrabajador;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_EliminarUsuario` (IN `_idUsuario` INT(11))  BEGIN
	DELETE FROM usuario WHERE usuario.idUsuario = _idUsuario;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listarTrabajadores` ()  BEGIN
	SELECT * FROM trabajador tra inner join persona per on tra.idPersona = per.idPersona inner join cargotrabajador ct on tra.idCargoTrabajador = ct.idCargoTrabajador inner join profesion pro on tra.idProfesion = pro.idProfesion inner join roles rol on tra.idRoles = rol.idRoles inner join turno tur on tra.idTurno = tur.idTurno inner join pais pa on per.idPais = pa.idPais;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listarUsuarios` ()  BEGIN

	SELECT * FROM usuario u inner join tipousuario tu on u.idTipoUsuario = tu.idTipoUsuario inner join trabajador tra on u.idTrabajador = tra.idTrabajador inner join persona per on tra.idPersona = per.idPersona;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_logearse` (IN `nomUsuario` VARCHAR(40), IN `passwordUsuario` VARCHAR(40))  BEGIN
	
    SELECT * FROM usuario WHERE usuario.nombreUsuario = nomUsuario  AND usuario.password_usuario= passwordUsuario;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ModificarPersona` (IN `_idPersona` INT(11), IN `_idPais` INT(11), IN `_perApellidosNombres` VARCHAR(50), IN `_perFechaNac` DATE, IN `_perDni` VARCHAR(8), IN `_perEstado` TINYINT(1), IN `_perTelefono` VARCHAR(40), IN `_perDireccion` VARCHAR(40), IN `_perSexo` VARCHAR(2), IN `_perCorreo` VARCHAR(40))  BEGIN

	UPDATE persona set persona.idPais = _idPais, persona.perApellidosNombres = _perApellidosNombres,
    persona.perFechaNac = _perFechaNac, persona.perDni = _perDni, persona.perEstado = _perEstado,
    persona.perTelefono = _perTelefono, persona.perDireccion = _perDireccion, persona.perSexo = _perSexo,
    persona.perCorreo = _perCorreo WHERE persona.idPersona = _idPersona;


END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_modificarProducto` (IN `_idProducto` INT(11), IN `_idPresentacion` INT(11), IN `_idLaboratorio` INT(11), IN `_nomProducto` VARCHAR(30), IN `_precioVenta` DECIMAL(10,2), IN `_descripcion` VARCHAR(350), IN `_stock` INT(11), IN `_caducidad` DATE, IN `_lote` VARCHAR(40))  BEGIN
		UPDATE producto set producto.idPresentacion = _idPresentacion, producto.idLaboratorio = _idLaboratorio,producto.nomProducto = _nomProducto, producto.precioVenta = _precioVenta,
        producto.descripcion = _descripcion, producto.stock = _stock, producto.caducidad = _caducidad, producto.lote = _lote
        WHERE producto.idProducto = _idProducto ;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ModificarTrabajador` (IN `_idTrabajador` INT(11), IN `_idPersona` INT(11), IN `_idCargoTrabajador` INT(11), IN `_idProfesion` INT(11), IN `_idRoles` INT(11), IN `_idTurno` INT(11), IN `_fechaInicio` DATE)  BEGIN
	UPDATE trabajador set trabajador.idPersona = _idPersona, trabajador.idCargoTrabajador = _idCargoTrabajador,
    trabajador.idProfesion = _idProfesion, trabajador.idRoles = _idRoles, trabajador.idTurno = _idTurno, trabajador.fechaInicio = _fechaInicio
    WHERE trabajador.idTrabajador = _idTrabajador;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrarProducto` (IN `_idProducto` INT(11), IN `_idPresentacion` INT(11), IN `_idLaboratorio` INT(11), IN `_nomProducto` VARCHAR(30), IN `_precioVenta` DECIMAL(10,2), IN `_descripcion` VARCHAR(350), IN `_stock` INT(11), IN `_caducidad` DATE, IN `_lote` VARCHAR(40))  BEGIN
	INSERT INTO producto (idProducto,idPresentacion,idLaboratorio,nomProducto,precioVenta,descripcion,stock,caducidad,lote) VALUES (_idProducto,_idPresentacion,_idLaboratorio,_nomProducto,_precioVenta,_descripcion,_stock,_caducidad,_lote);


END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_reporteProductos` ()  BEGIN

	SELECT * FROM producto pro inner join presentacion pre on pro.idPresentacion = pre.idPresentacion inner join laboratorio lab on pro.idLaboratorio = lab.idLaboratorio;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_retornarPersonaIDTrabajador` (IN `id_trabajador` INT)  BEGIN
	SELECT * FROM persona p inner join trabajador tra on p.idPersona= tra.idPersona where tra.idTrabajador=id_trabajador;
	
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_retornarProductoPorID` (IN `_idProducto` INT)  BEGIN
SELECT * FROM producto pro inner join presentacion pre on pro.idPresentacion = pre.idPresentacion inner join laboratorio lab on pro.idLaboratorio = lab.idLaboratorio where pro.idProducto = _idProducto;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_retornarProductoPorNombre` (IN `_nomProducto` VARCHAR(30))  BEGIN
	SELECT * FROM producto pro inner join presentacion pre on pro.idPresentacion = pre.idPresentacion inner join laboratorio lab on pro.idLaboratorio = lab.idLaboratorio where pro.nomProducto LIKE CONCAT('%',_nomProducto,'%');

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_retornarRolesTrabajador` (IN `_idRoles` INT)  BEGIN
	SELECT * FROM roles where roles.idRoles = _idRoles;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_retornarTipoUsuarioID` (IN `id_tipoUsuario` INT)  BEGIN	
	SELECT * FROM tipousuario where tipousuario.idTipoUsuario= id_tipoUsuario;


END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_retornarTrabajadorDNI` (IN `dni` VARCHAR(8))  BEGIN
	SELECT * FROM trabajador tra inner join persona per on tra.idPersona = per.idPersona inner join cargotrabajador ct on tra.idCargoTrabajador = ct.idCargoTrabajador inner join profesion pro on tra.idProfesion = pro.idProfesion inner join roles rol on tra.idRoles = rol.idRoles inner join turno tur on tra.idTurno = tur.idTurno inner join pais pa on per.idPais = pa.idPais WHERE per.perDni LIKE CONCAT('%',dni,'%');
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_retornarTrabajadorID` (IN `id_trabajador` INT)  BEGIN
	SELECT * FROM trabajador where trabajador.idTrabajador = id_trabajador;

END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cargotrabajador`
--

CREATE TABLE `cargotrabajador` (
  `idCargoTrabajador` int(11) NOT NULL,
  `nomCargoTrabajador` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cargotrabajador`
--

INSERT INTO `cargotrabajador` (`idCargoTrabajador`, `nomCargoTrabajador`) VALUES
(1, 'VENTAS');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `idPersona` int(11) NOT NULL,
  `fechaInicio` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idCliente`, `idPersona`, `fechaInicio`) VALUES
(1, 2, '2021-10-26'),
(2, 3, '2021-10-27'),
(3, 6, '2021-12-07'),
(4, 7, '2021-12-15'),
(5, 9, '2021-12-15');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comprobanteventa`
--

CREATE TABLE `comprobanteventa` (
  `idComprobanteVenta` int(11) NOT NULL,
  `nomComprobanteVenta` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `comprobanteventa`
--

INSERT INTO `comprobanteventa` (`idComprobanteVenta`, `nomComprobanteVenta`) VALUES
(1, 'BOLETA ELECTRONICA'),
(2, 'FACTURA ELECTRONICA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleventa`
--

CREATE TABLE `detalleventa` (
  `idDetalleVenta` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `idVenta` int(11) NOT NULL,
  `precioProducto` decimal(10,2) NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detalleventa`
--

INSERT INTO `detalleventa` (`idDetalleVenta`, `idProducto`, `idVenta`, `precioProducto`, `cantidad`) VALUES
(5, 1, 6, '2.50', 5),
(6, 2, 6, '2.00', 10),
(7, 1, 7, '2.50', 3),
(8, 2, 7, '2.00', 10),
(9, 1, 8, '2.50', 5),
(10, 2, 8, '2.00', 10);

--
-- Disparadores `detalleventa`
--
DELIMITER $$
CREATE TRIGGER `ingresoVenta` AFTER INSERT ON `detalleventa` FOR EACH ROW BEGIN
UPDATE producto set producto.stock = producto.stock - NEW.cantidad WHERE producto.idProducto = NEW.idProducto;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `totalVenta` AFTER INSERT ON `detalleventa` FOR EACH ROW BEGIN
	UPDATE venta set venta.totalVenta = venta.totalVenta + (NEW.precioProducto* NEW.cantidad)
    WHERE venta.idVenta = NEW.idVenta;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `laboratorio`
--

CREATE TABLE `laboratorio` (
  `idLaboratorio` int(11) NOT NULL,
  `nomLaboratorio` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `laboratorio`
--

INSERT INTO `laboratorio` (`idLaboratorio`, `nomLaboratorio`) VALUES
(1, 'TEVA'),
(2, 'MEGA'),
(3, 'MEDROCK');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `modopago`
--

CREATE TABLE `modopago` (
  `idModoPago` int(11) NOT NULL,
  `nomModoPago` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `modopago`
--

INSERT INTO `modopago` (`idModoPago`, `nomModoPago`) VALUES
(1, 'VENTA EN EFECTIVO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pais`
--

CREATE TABLE `pais` (
  `idPais` int(11) NOT NULL,
  `nomPais` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pais`
--

INSERT INTO `pais` (`idPais`, `nomPais`) VALUES
(1, 'PERU'),
(2, 'ARGENTINA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `idPersona` int(11) NOT NULL,
  `idPais` int(11) NOT NULL,
  `perApellidosNombres` varchar(50) NOT NULL,
  `perFechaNac` date NOT NULL,
  `perDni` varchar(8) NOT NULL,
  `perEstado` tinyint(1) NOT NULL,
  `perTelefono` varchar(40) DEFAULT NULL,
  `perDireccion` varchar(40) DEFAULT NULL,
  `perSexo` varchar(2) NOT NULL,
  `perCorreo` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`idPersona`, `idPais`, `perApellidosNombres`, `perFechaNac`, `perDni`, `perEstado`, `perTelefono`, `perDireccion`, `perSexo`, `perCorreo`) VALUES
(1, 1, 'BRYAM ALEX', '1997-04-03', '6454534', 1, '345676', 'av. las rosas 872', 'M', 'hernar@hotmail.com'),
(2, 1, 'ROJAS DAVILA MARIA FERNANDA', '1997-03-02', '82721', 0, '12781', 'av. las palmeras 123', 'F', 'rojas@hotmail.com'),
(3, 2, ' DEL CAMPO UGARTE DANIELA', '1998-04-02', '43211', 1, '443121', 'av. las rosas 123', 'F', 'dani@hotmail.com'),
(6, 1, 'de la torre carolina fernanda', '1997-04-05', '12345', 1, '543211', 'av.los pinos 123', 'F', 'caro@hotmail.com'),
(7, 2, 'villareal carmen fernanda', '1998-04-03', '736362', 1, '234567', 'av. las rosas 123', 'F', 'carmen@hotmail.com'),
(9, 2, 'DE LA TORRE VALENTINA MIA', '1998-05-01', '765432', 1, '23456', 'av. las sauces 987', 'F', 'mia@hotmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `presentacion`
--

CREATE TABLE `presentacion` (
  `idPresentacion` int(11) NOT NULL,
  `nomPresentacion` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `presentacion`
--

INSERT INTO `presentacion` (`idPresentacion`, `nomPresentacion`) VALUES
(1, 'TABLETA MASTICABLE'),
(2, 'CÁPSULA BLANDA'),
(3, 'TABLETA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL,
  `idPresentacion` int(11) NOT NULL,
  `idLaboratorio` int(11) NOT NULL,
  `nomProducto` varchar(30) NOT NULL,
  `precioVenta` decimal(10,2) NOT NULL,
  `descripcion` varchar(350) NOT NULL,
  `stock` int(11) NOT NULL,
  `caducidad` date NOT NULL,
  `lote` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `idPresentacion`, `idLaboratorio`, `nomProducto`, `precioVenta`, `descripcion`, `stock`, `caducidad`, `lote`) VALUES
(1, 2, 2, 'LIVOLIN FORTE', '2.50', 'LIVOLIN FORTE X 30 CAPSULAS FOSFOLIPIDOS CON VITAMINAS', 5, '2022-01-28', '7631C092'),
(2, 1, 1, 'BISMUTOL', '2.00', 'BISMUTOL X 262 mg - TABLETA MASTICABLE - CAJA ENVASE BLISTER', 40, '2022-05-20', '3452EF021');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesion`
--

CREATE TABLE `profesion` (
  `idProfesion` int(11) NOT NULL,
  `nomProfesion` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `profesion`
--

INSERT INTO `profesion` (`idProfesion`, `nomProfesion`) VALUES
(1, 'tecnico de informatica');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `idRoles` int(11) NOT NULL,
  `nomRol` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`idRoles`, `nomRol`) VALUES
(1, 'VENDEDOR'),
(2, 'ADMINISTRADOR');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipousuario`
--

CREATE TABLE `tipousuario` (
  `idTipoUsuario` int(11) NOT NULL,
  `nombreTipoUsuario` varchar(40) NOT NULL,
  `descripcionTipoUsuario` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipousuario`
--

INSERT INTO `tipousuario` (`idTipoUsuario`, `nombreTipoUsuario`, `descripcionTipoUsuario`) VALUES
(0, 'ADMINISTRADOR', 'ACCESO TOTAL'),
(1, 'VENDEDOR', 'acceso a listar, y agregar');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `trabajador`
--

CREATE TABLE `trabajador` (
  `idTrabajador` int(11) NOT NULL,
  `idPersona` int(11) NOT NULL,
  `idCargoTrabajador` int(11) NOT NULL,
  `idProfesion` int(11) NOT NULL,
  `idRoles` int(11) NOT NULL,
  `idTurno` int(11) NOT NULL,
  `fechaInicio` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `trabajador`
--

INSERT INTO `trabajador` (`idTrabajador`, `idPersona`, `idCargoTrabajador`, `idProfesion`, `idRoles`, `idTurno`, `fechaInicio`) VALUES
(1, 1, 1, 1, 1, 1, '2021-10-20');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `turno`
--

CREATE TABLE `turno` (
  `idTurno` int(11) NOT NULL,
  `nombreTurno` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `turno`
--

INSERT INTO `turno` (`idTurno`, `nombreTurno`) VALUES
(1, 'MAÑANA'),
(2, 'TARDE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `nombreUsuario` varchar(40) NOT NULL,
  `idTipoUsuario` int(11) NOT NULL,
  `idTrabajador` int(11) NOT NULL,
  `password_usuario` varchar(40) NOT NULL,
  `estadoUsuario` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `nombreUsuario`, `idTipoUsuario`, `idTrabajador`, `password_usuario`, `estadoUsuario`) VALUES
(8, 'lojaByram', 1, 1, '123', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `idVenta` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idTrabajador` int(11) NOT NULL,
  `idComprobanteVenta` int(11) NOT NULL,
  `totalVenta` decimal(10,2) DEFAULT NULL,
  `fechaVenta` datetime NOT NULL,
  `idModoPago` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`idVenta`, `idCliente`, `idTrabajador`, `idComprobanteVenta`, `totalVenta`, `fechaVenta`, `idModoPago`) VALUES
(6, 1, 1, 1, '32.50', '2021-12-08 07:33:47', 1),
(7, 3, 1, 1, '27.50', '2021-12-14 16:44:49', 1),
(8, 1, 1, 1, '32.50', '2021-12-16 03:14:48', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cargotrabajador`
--
ALTER TABLE `cargotrabajador`
  ADD PRIMARY KEY (`idCargoTrabajador`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`),
  ADD KEY `foreign_key_persona_id` (`idPersona`);

--
-- Indices de la tabla `comprobanteventa`
--
ALTER TABLE `comprobanteventa`
  ADD PRIMARY KEY (`idComprobanteVenta`);

--
-- Indices de la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  ADD PRIMARY KEY (`idDetalleVenta`),
  ADD KEY `foreign_key_producto_id` (`idProducto`),
  ADD KEY `foreign_key_venta_id` (`idVenta`);

--
-- Indices de la tabla `laboratorio`
--
ALTER TABLE `laboratorio`
  ADD PRIMARY KEY (`idLaboratorio`);

--
-- Indices de la tabla `modopago`
--
ALTER TABLE `modopago`
  ADD PRIMARY KEY (`idModoPago`);

--
-- Indices de la tabla `pais`
--
ALTER TABLE `pais`
  ADD PRIMARY KEY (`idPais`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`idPersona`),
  ADD KEY `foreign_key_pais_id` (`idPais`);

--
-- Indices de la tabla `presentacion`
--
ALTER TABLE `presentacion`
  ADD PRIMARY KEY (`idPresentacion`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`),
  ADD KEY `foreign_key_presentacion_id` (`idPresentacion`),
  ADD KEY `foreign_key_laboratorio_id` (`idLaboratorio`);

--
-- Indices de la tabla `profesion`
--
ALTER TABLE `profesion`
  ADD PRIMARY KEY (`idProfesion`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`idRoles`);

--
-- Indices de la tabla `tipousuario`
--
ALTER TABLE `tipousuario`
  ADD PRIMARY KEY (`idTipoUsuario`);

--
-- Indices de la tabla `trabajador`
--
ALTER TABLE `trabajador`
  ADD PRIMARY KEY (`idTrabajador`),
  ADD KEY `foreignkey_persona_id` (`idPersona`),
  ADD KEY `foreignkey_cargoTrabajador_id` (`idCargoTrabajador`),
  ADD KEY `foreignkey_profesion_id` (`idProfesion`),
  ADD KEY `foreignkey_roles_id` (`idRoles`),
  ADD KEY `foreignkey_turno_id` (`idTurno`);

--
-- Indices de la tabla `turno`
--
ALTER TABLE `turno`
  ADD PRIMARY KEY (`idTurno`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`),
  ADD KEY `foreign_key_tipoUsuario_id` (`idTipoUsuario`),
  ADD KEY `foreign_key_trabajador_id` (`idTrabajador`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`idVenta`),
  ADD KEY `foreign_key_cliente_id` (`idCliente`),
  ADD KEY `foreign_key_modoPago_id` (`idModoPago`),
  ADD KEY `fk_trabajador` (`idTrabajador`),
  ADD KEY `foreign_key_comprobante_id` (`idComprobanteVenta`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cargotrabajador`
--
ALTER TABLE `cargotrabajador`
  MODIFY `idCargoTrabajador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `comprobanteventa`
--
ALTER TABLE `comprobanteventa`
  MODIFY `idComprobanteVenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  MODIFY `idDetalleVenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `laboratorio`
--
ALTER TABLE `laboratorio`
  MODIFY `idLaboratorio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `modopago`
--
ALTER TABLE `modopago`
  MODIFY `idModoPago` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `pais`
--
ALTER TABLE `pais`
  MODIFY `idPais` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `idPersona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `presentacion`
--
ALTER TABLE `presentacion`
  MODIFY `idPresentacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `profesion`
--
ALTER TABLE `profesion`
  MODIFY `idProfesion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `idRoles` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `trabajador`
--
ALTER TABLE `trabajador`
  MODIFY `idTrabajador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `turno`
--
ALTER TABLE `turno`
  MODIFY `idTurno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `idVenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `foreign_key_persona_id` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`);

--
-- Filtros para la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  ADD CONSTRAINT `foreign_key_producto_id` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`),
  ADD CONSTRAINT `foreign_key_venta_id` FOREIGN KEY (`idVenta`) REFERENCES `venta` (`idVenta`);

--
-- Filtros para la tabla `persona`
--
ALTER TABLE `persona`
  ADD CONSTRAINT `foreign_key_pais_id` FOREIGN KEY (`idPais`) REFERENCES `pais` (`idPais`);

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `foreign_key_laboratorio_id` FOREIGN KEY (`idLaboratorio`) REFERENCES `laboratorio` (`idLaboratorio`),
  ADD CONSTRAINT `foreign_key_presentacion_id` FOREIGN KEY (`idPresentacion`) REFERENCES `presentacion` (`idPresentacion`);

--
-- Filtros para la tabla `trabajador`
--
ALTER TABLE `trabajador`
  ADD CONSTRAINT `foreignkey_cargoTrabajador_id` FOREIGN KEY (`idCargoTrabajador`) REFERENCES `cargotrabajador` (`idCargoTrabajador`),
  ADD CONSTRAINT `foreignkey_persona_id` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`),
  ADD CONSTRAINT `foreignkey_profesion_id` FOREIGN KEY (`idProfesion`) REFERENCES `profesion` (`idProfesion`),
  ADD CONSTRAINT `foreignkey_roles_id` FOREIGN KEY (`idRoles`) REFERENCES `roles` (`idRoles`),
  ADD CONSTRAINT `foreignkey_turno_id` FOREIGN KEY (`idTurno`) REFERENCES `turno` (`idTurno`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `foreign_key_tipoUsuario_id` FOREIGN KEY (`idTipoUsuario`) REFERENCES `tipousuario` (`idTipoUsuario`),
  ADD CONSTRAINT `foreign_key_trabajador_id` FOREIGN KEY (`idTrabajador`) REFERENCES `trabajador` (`idTrabajador`);

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `fk_trabajador` FOREIGN KEY (`idTrabajador`) REFERENCES `trabajador` (`idTrabajador`),
  ADD CONSTRAINT `foreign_key_cliente_id` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`),
  ADD CONSTRAINT `foreign_key_comprobante_id` FOREIGN KEY (`idComprobanteVenta`) REFERENCES `comprobanteventa` (`idComprobanteVenta`),
  ADD CONSTRAINT `foreign_key_modoPago_id` FOREIGN KEY (`idModoPago`) REFERENCES `modopago` (`idModoPago`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
