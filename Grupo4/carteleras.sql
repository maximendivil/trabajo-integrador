-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-03-2017 a las 23:21:26
-- Versión del servidor: 10.1.13-MariaDB
-- Versión de PHP: 5.5.37

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `carteleras`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`id`) VALUES
(10),
(11),
(12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `legajo` varchar(255) DEFAULT NULL,
  `id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`legajo`, `id`) VALUES
('11982/1', 13),
('12000/1', 14),
('11900/1', 15);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cartelera`
--

CREATE TABLE `cartelera` (
  `id` bigint(20) NOT NULL,
  `borrado` int(11) NOT NULL,
  `fechaCreacion` datetime DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cartelera`
--

INSERT INTO `cartelera` (`id`, `borrado`, `fechaCreacion`, `nombre`) VALUES
(1, 0, '2017-01-25 20:06:41', 'Ingresantes'),
(2, 0, '2017-01-25 20:06:41', 'Primer año'),
(3, 0, '2017-01-25 20:06:41', 'Segundo año'),
(4, 0, '2017-01-25 20:06:41', 'Tercer año'),
(5, 0, '2017-01-25 20:06:41', 'Cuarto año'),
(6, 0, '2017-01-25 20:06:41', 'Quinto año'),
(7, 0, '2017-01-25 20:06:41', 'Institucional'),
(8, 0, '2017-01-25 20:06:41', 'Eventos'),
(9, 0, '2017-01-25 20:06:41', 'Ofrecimientos laborales');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentario`
--

CREATE TABLE `comentario` (
  `id` bigint(20) NOT NULL,
  `borrado` int(11) NOT NULL,
  `fechaCreacion` datetime DEFAULT NULL,
  `texto` varchar(255) DEFAULT NULL,
  `PERSONA_ID` bigint(20) NOT NULL,
  `PUBLICACION_ID` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `comentario`
--

INSERT INTO `comentario` (`id`, `borrado`, `fechaCreacion`, `texto`, `PERSONA_ID`, `PUBLICACION_ID`) VALUES
(28, 0, '2017-01-25 20:06:44', 'Comentario 1', 13, 22),
(29, 0, '2017-01-25 20:06:44', 'Comentario 2', 14, 23),
(30, 0, '2017-01-25 20:06:44', 'Comentario 3', 15, 24),
(31, 0, '2017-01-25 20:06:44', 'Comentario 4', 16, 25),
(32, 0, '2017-01-25 20:06:44', 'Comentario 5', 17, 26),
(33, 0, '2017-01-25 20:06:44', 'Comentario 6', 19, 27);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habilitadas`
--

CREATE TABLE `habilitadas` (
  `PUBLICADOR_ID` bigint(20) NOT NULL,
  `CARTELERA_ID` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `habilitadas`
--

INSERT INTO `habilitadas` (`PUBLICADOR_ID`, `CARTELERA_ID`) VALUES
(16, 3),
(16, 4),
(17, 3),
(17, 4),
(17, 5),
(18, 3),
(18, 4),
(18, 5),
(19, 7),
(19, 8),
(20, 7),
(20, 8),
(21, 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(34),
(34),
(34),
(34);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `intereses`
--

CREATE TABLE `intereses` (
  `PERSONA_ID` bigint(20) NOT NULL,
  `CARTELERA_ID` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `intereses`
--

INSERT INTO `intereses` (`PERSONA_ID`, `CARTELERA_ID`) VALUES
(13, 5),
(13, 6),
(13, 9),
(14, 4),
(14, 5),
(14, 7),
(14, 9),
(15, 5),
(15, 6),
(15, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `id` bigint(20) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `borrado` int(11) NOT NULL,
  `dni` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fechaNacimiento` datetime DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `rol` int(11) NOT NULL,
  `usuario` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`id`, `apellido`, `borrado`, `dni`, `email`, `fechaNacimiento`, `nombre`, `password`, `rol`, `usuario`) VALUES
(10, 'Oreja', 0, 30123456, 'admin1@admin.com', '2017-01-25 20:06:42', 'Facundo', 'admin', 1, 'admin1'),
(11, 'Cuida Bici', 0, 30123456, 'admin2@admin.com', '2017-01-25 20:06:42', 'Viejo', 'admin', 1, 'admin2'),
(12, 'Maddog', 0, 30123456, 'admin3@admin.com', '2017-01-25 20:06:42', 'John', 'admin', 1, 'admin3'),
(13, 'Mendivil', 0, 36734753, 'maximendivil22@gmail.com', '1907-07-17 00:00:00', 'Maximiliano', '123', 3, 'maximendivil'),
(14, 'Ringuelet', 0, 123456, 'ezeringue@gmail.com', '1927-03-16 00:00:00', 'Ezequiel', '123', 3, 'ezeringue'),
(15, 'La Frazia', 0, 321654, 'ellucho@gmail.com', '2017-01-25 20:06:42', 'Luciano', '123', 3, 'lucholafrazia'),
(16, 'Fava', 0, 12345678, 'laurafava@gmail.com', '2017-01-25 20:06:43', 'Laura', '123', 2, 'laurafava'),
(17, 'Rossi', 0, 12345678, 'gustavorossi@gmail.com', '2017-01-25 20:06:43', 'Gustavo', '123', 2, 'grossi'),
(18, 'Perez', 0, 12345678, 'jppez@gmail.com', '2017-01-25 20:06:43', 'Juan Pablo', '123', 2, 'jpperez'),
(19, '1', 0, 12345678, 'publicador1@gmail.com', '2017-01-25 20:06:43', 'Publicador', '123', 4, 'publicador1'),
(20, '2', 0, 12345678, 'publicador2@gmail.com', '2017-01-25 20:06:43', 'Publicador', '123', 4, 'publicador2'),
(21, '3', 0, 12345678, 'publicador3@gmail.com', '2017-01-25 20:06:43', 'Publicador', '123', 4, 'publicador3');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesor`
--

CREATE TABLE `profesor` (
  `id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `profesor`
--

INSERT INTO `profesor` (`id`) VALUES
(16),
(17),
(18);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `publicacion`
--

CREATE TABLE `publicacion` (
  `id` bigint(20) NOT NULL,
  `borrado` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fechaCreacion` datetime DEFAULT NULL,
  `multimedia` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `CARTELERA_ID` bigint(20) NOT NULL,
  `PERSONA_ID` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `publicacion`
--

INSERT INTO `publicacion` (`id`, `borrado`, `descripcion`, `fechaCreacion`, `multimedia`, `titulo`, `CARTELERA_ID`, `PERSONA_ID`) VALUES
(22, 0, 'Descripción de la publicación de la cartelera "Ingresantes"', '2017-01-25 20:06:43', 'casa', 'Publicación 1', 1, 16),
(23, 0, 'Descripción de la publicación de la cartelera "Primer año"', '2017-01-25 20:06:43', 'casa', 'Publicación 1', 2, 17),
(24, 0, 'Descripción de la publicación de la cartelera "Segundo año"', '2017-01-25 20:06:43', 'casa', 'Publicación 1', 3, 18),
(25, 0, 'Descripción de la publicación de la cartelera "Tercer año"', '2017-01-25 20:06:43', 'casa', 'Publicación 1', 4, 19),
(26, 0, 'Descripción de la publicación de la cartelera "Cuarto año"', '2017-01-25 20:06:43', 'casa', 'Publicación 1', 5, 20),
(27, 0, 'Descripción de la publicación de la cartelera "Quinto Año"', '2017-01-25 20:06:43', 'casa', 'Publicación 1', 6, 21),
(28, 0, 'Descripción de la publicación de la cartelera "Ingresantes"', '2017-03-16 00:00:00', 'cualquier cosa', 'Publicación 2', 1, 10),
(29, 0, 'Descripción de la publicación de la cartelera "Ingresantes"', '2017-03-16 00:00:00', 'cualquier cosa', 'Publicación 3', 1, 10),
(30, 0, 'Descripción de la publicación de la cartelera "Ingresantes"', '2017-03-16 00:00:00', 'cualquier cosa', 'Publicación 4', 1, 10),
(31, 0, 'Descripción de la publicación de la cartelera "Ingresantes"', '2017-03-16 00:00:00', 'cualquier cosa', 'Publicación 5', 1, 10),
(32, 0, 'Descripción de la publicación de la cartelera "Ingresantes"', '2017-03-16 00:00:00', 'cualquier cosa', 'Publicación 6', 1, 10),
(33, 0, 'Descripción de la publicación de la cartelera "Primer año"', '2017-03-16 00:00:00', 'cualquier cosa', 'Publicación 2', 2, 10),
(34, 0, 'Descripción de la publicación de la cartelera "Primer año"', '2017-03-16 00:00:00', 'cualquier cosa', 'Publicación 3', 2, 10),
(35, 0, 'Descripción de la publicación de la cartelera "Primer año"', '2017-03-16 00:00:00', 'cualquier cosa', 'Publicación 4', 2, 10),
(36, 0, 'Descripción de la publicación de la cartelera "Primer año"', '2017-03-16 00:00:00', 'cualquier cosa', 'Publicación 5', 2, 10),
(37, 0, 'Descripción de la publicación de la cartelera "Primer año"', '2017-03-16 00:00:00', 'cualquier cosa', 'Publicación 6', 2, 10),
(38, 0, 'Descripción de la publicación de la cartelera "Segundo año"', '2017-03-16 00:00:00', 'cualquier cosa', 'Publicación 2', 3, 10),
(39, 0, 'Descripción de la publicación de la cartelera "Segundo año"', '2017-03-16 00:00:00', 'cualquier cosa', 'Publicación 3', 3, 10),
(40, 0, 'Descripción de la publicación de la cartelera "Segundo año"', '2017-03-16 00:00:00', 'cualquier cosa', 'Publicación 4', 3, 10),
(41, 0, 'Descripción de la publicación de la cartelera "Segundo año"', '2017-03-16 00:00:00', 'cualquier cosa', 'Publicación 5', 3, 10),
(42, 0, 'Descripción de la publicación de la cartelera "Segundo año"', '2017-03-16 00:00:00', 'cualquier cosa', 'Publicación 6', 3, 10),
(43, 0, 'Descripción de la publicación de la cartelera "Tercer año"', '2017-03-16 00:00:00', 'cualquier cosa', 'Publicación 2', 4, 10),
(44, 0, 'Descripción de la publicación de la cartelera "Tercer año"', '2017-03-16 00:00:00', 'cualquier cosa', 'Publicación 3', 4, 10),
(45, 0, 'Descripción de la publicación de la cartelera "Tercer año"', '2017-03-16 00:00:00', 'cualquier cosa', 'Publicación 4', 4, 10),
(46, 0, 'Descripción de la publicación de la cartelera "Tercer año"', '2017-03-16 00:00:00', 'cualquier cosa', 'Publicación 5', 4, 10),
(47, 0, 'Descripción de la publicación de la cartelera "Tercer año"', '2017-03-16 00:00:00', 'cualquier cosa', 'Publicación 6', 4, 10),
(48, 0, 'Descripción de la publicación de la cartelera "Cuarto año"', '2017-03-16 00:00:00', 'cualquier cosa', 'Publicación 2', 5, 10),
(49, 0, 'Descripción de la publicación de la cartelera "Cuarto año"', '2017-03-16 00:00:00', 'cualquier cosa', 'Publicación 3', 5, 10),
(50, 0, 'Descripción de la publicación de la cartelera "Cuarto año"', '2017-03-16 00:00:00', 'cualquier cosa', 'Publicación 4', 5, 10),
(51, 0, 'Descripción de la publicación de la cartelera "Cuarto año"', '2017-03-16 00:00:00', 'cualquier cosa', 'Publicación 5', 5, 10),
(52, 0, 'Descripción de la publicación de la cartelera "Cuarto año"', '2017-03-16 00:00:00', 'cualquier cosa', 'Publicación 6', 5, 10),
(53, 0, 'Descripción de la publicación de la cartelera "Quinto año"', '2017-03-16 00:00:00', 'cualquier cosa', 'Publicación 2', 6, 10),
(54, 0, 'Descripción de la publicación de la cartelera "Quinto año"', '2017-03-16 00:00:00', 'cualquier cosa', 'Publicación 3', 6, 10),
(55, 0, 'Descripción de la publicación de la cartelera "Quinto año"', '2017-03-16 00:00:00', 'cualquier cosa', 'Publicación 4', 6, 10),
(56, 0, 'Descripción de la publicación de la cartelera "Institucional"', '2017-03-16 00:00:00', 'cualquier cosa', 'Publicación 1', 7, 10),
(57, 0, 'Descripción de la publicación de la cartelera "Institucional"', '2017-03-16 00:00:00', 'cualquier cosa', 'Publicación 2', 7, 10),
(58, 0, 'Descripción de la publicación de la cartelera "Institucional"', '2017-03-16 00:00:00', 'cualquier cosa', 'Publicación 3', 7, 10),
(59, 0, 'Descripción de la publicación de la cartelera "Eventos"', '2017-03-16 00:00:00', 'cualquier cosa', 'Publicación 1', 8, 10),
(60, 0, 'Descripción de la publicación de la cartelera "Eventos"', '2017-03-16 00:00:00', 'cualquier cosa', 'Publicación 2', 8, 10),
(61, 0, 'Descripción de la publicación de la cartelera "Ofrecimientos Laborales"', '2017-03-16 00:00:00', 'cualquier cosa', 'Publicación 1', 9, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `publicador`
--

CREATE TABLE `publicador` (
  `id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `publicador`
--

INSERT INTO `publicador` (`id`) VALUES
(10),
(11),
(12),
(16),
(17),
(18),
(19),
(20),
(21);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `cartelera`
--
ALTER TABLE `cartelera`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `comentario`
--
ALTER TABLE `comentario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5iarnipx1s8wgny1x6a31t6f7` (`PERSONA_ID`),
  ADD KEY `FKclsdhfe4dagse6axfb3bwbqi7` (`PUBLICACION_ID`);

--
-- Indices de la tabla `habilitadas`
--
ALTER TABLE `habilitadas`
  ADD PRIMARY KEY (`PUBLICADOR_ID`,`CARTELERA_ID`),
  ADD KEY `FK62xib3olaqthk7osldpic2hhm` (`CARTELERA_ID`);

--
-- Indices de la tabla `intereses`
--
ALTER TABLE `intereses`
  ADD PRIMARY KEY (`PERSONA_ID`,`CARTELERA_ID`),
  ADD KEY `FKh6jhmuxbjgepe0otaj901gskk` (`CARTELERA_ID`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `profesor`
--
ALTER TABLE `profesor`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `publicacion`
--
ALTER TABLE `publicacion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1bcm08ovsow2odrvppigstbmr` (`CARTELERA_ID`),
  ADD KEY `FK5818jtagt26bdpg6w8ln9mekc` (`PERSONA_ID`);

--
-- Indices de la tabla `publicador`
--
ALTER TABLE `publicador`
  ADD PRIMARY KEY (`id`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD CONSTRAINT `FKiskgukte9xb5vqx34pmgm4080` FOREIGN KEY (`id`) REFERENCES `publicador` (`id`);

--
-- Filtros para la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD CONSTRAINT `FKf38m37ariic0uprdwmnsu06ny` FOREIGN KEY (`id`) REFERENCES `persona` (`id`);

--
-- Filtros para la tabla `comentario`
--
ALTER TABLE `comentario`
  ADD CONSTRAINT `FK5iarnipx1s8wgny1x6a31t6f7` FOREIGN KEY (`PERSONA_ID`) REFERENCES `persona` (`id`),
  ADD CONSTRAINT `FKclsdhfe4dagse6axfb3bwbqi7` FOREIGN KEY (`PUBLICACION_ID`) REFERENCES `publicacion` (`id`);

--
-- Filtros para la tabla `habilitadas`
--
ALTER TABLE `habilitadas`
  ADD CONSTRAINT `FK62xib3olaqthk7osldpic2hhm` FOREIGN KEY (`CARTELERA_ID`) REFERENCES `cartelera` (`id`),
  ADD CONSTRAINT `FKetvr2riioudapq4momeo093em` FOREIGN KEY (`PUBLICADOR_ID`) REFERENCES `publicador` (`id`);

--
-- Filtros para la tabla `intereses`
--
ALTER TABLE `intereses`
  ADD CONSTRAINT `FKh6jhmuxbjgepe0otaj901gskk` FOREIGN KEY (`CARTELERA_ID`) REFERENCES `cartelera` (`id`),
  ADD CONSTRAINT `FKr73oywywfowl0h68owav514yp` FOREIGN KEY (`PERSONA_ID`) REFERENCES `alumno` (`id`);

--
-- Filtros para la tabla `profesor`
--
ALTER TABLE `profesor`
  ADD CONSTRAINT `FKbk695fgjqa7pfqxpl0jr661u0` FOREIGN KEY (`id`) REFERENCES `publicador` (`id`);

--
-- Filtros para la tabla `publicacion`
--
ALTER TABLE `publicacion`
  ADD CONSTRAINT `FK1bcm08ovsow2odrvppigstbmr` FOREIGN KEY (`CARTELERA_ID`) REFERENCES `cartelera` (`id`),
  ADD CONSTRAINT `FK5818jtagt26bdpg6w8ln9mekc` FOREIGN KEY (`PERSONA_ID`) REFERENCES `publicador` (`id`);

--
-- Filtros para la tabla `publicador`
--
ALTER TABLE `publicador`
  ADD CONSTRAINT `FKlp5ev0obkv0ulq2g3tybountx` FOREIGN KEY (`id`) REFERENCES `persona` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
