-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Jeu 21 Décembre 2017 à 21:34
-- Version du serveur :  5.7.19-0ubuntu0.16.04.1
-- Version de PHP :  7.0.22-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gestionecole`
--

-- --------------------------------------------------------

--
-- Structure de la table `absence_student`
--

CREATE TABLE `absence_student` (
  `ID_CRS` int(11) NOT NULL,
  `ID_STD` int(11) NOT NULL,
  `JUSTIFIED` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `absence_student`
--

INSERT INTO `absence_student` (`ID_CRS`, `ID_STD`, `JUSTIFIED`) VALUES
(2, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `class`
--

CREATE TABLE `class` (
  `ID_YEAR` int(11) NOT NULL,
  `ID_STD` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `class`
--

INSERT INTO `class` (`ID_YEAR`, `ID_STD`) VALUES
(2, 1),
(2, 2),
(2, 3),
(2, 4);

-- --------------------------------------------------------

--
-- Structure de la table `courses`
--

CREATE TABLE `courses` (
  `ID_CRS` int(11) NOT NULL,
  `ID_SBJ` int(11) NOT NULL,
  `DATE_CRS` date NOT NULL,
  `Time` time NOT NULL,
  `HOURS_NBR` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `courses`
--

INSERT INTO `courses` (`ID_CRS`, `ID_SBJ`, `DATE_CRS`, `Time`, `HOURS_NBR`) VALUES
(2, 25, '2017-10-31', '01:00:00', 3);

-- --------------------------------------------------------

--
-- Structure de la table `department`
--

CREATE TABLE `department` (
  `ID_DPRT` int(11) NOT NULL,
  `NAME_DPRT` varchar(60) NOT NULL,
  `DESCRIPION_DPRT` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `department`
--

INSERT INTO `department` (`ID_DPRT`, `NAME_DPRT`, `DESCRIPION_DPRT`) VALUES
(1, 'G.I', 'Génie Informatique'),
(2, 'G.I.M', 'Génie Industriel et Maintenance'),
(3, 'T.M', 'Technique de Management'),
(4, 'T.I.M.Q', 'Techniques Instrumentales et Management de la Qualité');

-- --------------------------------------------------------

--
-- Structure de la table `history`
--

CREATE TABLE `history` (
  `ID_HISTORY` int(11) NOT NULL,
  `USERNAME` varchar(34) NOT NULL,
  `DATE_LOG` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `management_student`
--

CREATE TABLE `management_student` (
  `USERNAME` varchar(34) NOT NULL,
  `ID_MANAGER_STD` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `manager_student`
--

CREATE TABLE `manager_student` (
  `ID_MANAGER_STD` int(11) NOT NULL,
  `AS` tinyint(1) NOT NULL,
  `RS` tinyint(1) NOT NULL,
  `US` tinyint(1) NOT NULL,
  `AR` tinyint(1) NOT NULL,
  `RR` tinyint(1) NOT NULL,
  `UR` tinyint(1) NOT NULL,
  `AAS` tinyint(1) NOT NULL,
  `RAS` tinyint(1) NOT NULL,
  `UAS` tinyint(1) NOT NULL,
  `SDEPARTMENT` varchar(8) NOT NULL,
  `SYEAR` varchar(8) NOT NULL,
  `SMODULE` varchar(8) NOT NULL,
  `SSUBJECT` varchar(34) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `manager_user`
--

CREATE TABLE `manager_user` (
  `ID_MANAGER_USER` int(11) NOT NULL,
  `ADD_USER` tinyint(1) NOT NULL,
  `REMOVE_USER` tinyint(1) NOT NULL,
  `UPDATE_USER` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `manager_user`
--

INSERT INTO `manager_user` (`ID_MANAGER_USER`, `ADD_USER`, `REMOVE_USER`, `UPDATE_USER`) VALUES
(1, 1, 1, 1),
(2, 0, 0, 1),
(3, 0, 1, 1),
(4, 1, 0, 1);

-- --------------------------------------------------------

--
-- Structure de la table `module`
--

CREATE TABLE `module` (
  `ID_MDL` int(11) NOT NULL,
  `ID_YEAR` int(11) NOT NULL,
  `NUM_MDL` varchar(3) DEFAULT NULL,
  `NAME_MDL` varchar(60) NOT NULL,
  `SEMESTER` decimal(1,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `module`
--

INSERT INTO `module` (`ID_MDL`, `ID_YEAR`, `NUM_MDL`, `NAME_MDL`, `SEMESTER`) VALUES
(1, 1, 'M01', 'Algorithmique & Bases de Programmation', '1'),
(2, 1, 'M02', 'Architecture des Ordinateurs', '1'),
(3, 1, 'M03', 'Mathématiques', '1'),
(4, 1, 'M04', 'Langues & TEC', '1'),
(5, 1, 'M05', 'cdv', '2'),
(6, 1, 'M06', 'tzertery', '2'),
(7, 1, 'M07', 'hhhcdv', '2'),
(8, 1, 'M08', 'tery', '2'),
(9, 2, 'M01', 'fghtyty', '3'),
(10, 2, 'M02', 'yutyutyu', '3'),
(11, 2, 'M03', 'fghy', '3'),
(12, 2, 'M04', 'yutyu', '3'),
(13, 2, 'M05', 'yutyu', '4'),
(14, 2, 'M06', 'yutyu', '4'),
(15, 2, 'M07', 'dhghtr', '4'),
(16, 2, 'M08', 'dfgfhgf', '4'),
(17, 3, 'M01', 'dfsd', '1'),
(18, 3, 'M02', 'dffs des Ordinateurs', '1'),
(19, 3, 'M03', 'dfdf', '1'),
(20, 3, 'M04', 'fdf & TEC', '1'),
(21, 3, 'M05', 'cdv', '2'),
(22, 3, 'M06', 'tzertery', '2'),
(23, 3, 'M07', 'df', '2'),
(24, 3, 'M08', 'tery', '2'),
(25, 4, 'M01', 'fghtyty', '3'),
(26, 4, 'M02', 'dffs des Ordinateurs', '3'),
(27, 4, 'M03', 'dfdf', '3'),
(28, 4, 'M04', 'fdf & TEC', '3'),
(29, 4, 'M05', 'cdv', '4'),
(30, 4, 'M06', 'tzertery', '4'),
(31, 4, 'M07', 'df', '4'),
(32, 4, 'M08', 'tery', '4'),
(33, 5, 'M01', 'fghtyty', '1'),
(34, 5, 'M02', 'yutyutyu', '1'),
(35, 5, 'M03', 'fghy', '1'),
(36, 5, 'M04', 'yutyu', '1'),
(37, 5, 'M05', 'yutyu', '2'),
(38, 5, 'M06', 'yutyu', '2'),
(39, 5, 'M07', 'dhghtr', '2'),
(40, 5, 'M08', 'dfgfhgf', '2'),
(41, 6, 'M01', 'dfsd', '1'),
(42, 6, 'M02', 'dffs des Ordinateurs', '3'),
(43, 6, 'M03', 'dfdf', '3'),
(44, 6, 'M04', 'fdf & TEC', '3'),
(45, 6, 'M05', 'cdv', '4'),
(46, 6, 'M06', 'tzertery', '4'),
(47, 6, 'M07', 'df', '4'),
(48, 6, 'M08', 'tery', '4'),
(49, 7, 'M01', 'fghtyty', '1'),
(50, 7, 'M02', 'yutyutyu', '1'),
(51, 7, 'M03', 'fghy', '1'),
(52, 7, 'M04', 'yutyu', '1'),
(53, 7, 'M05', 'yutyu', '2'),
(54, 7, 'M06', 'yutyu', '2'),
(55, 7, 'M07', 'dhghtr', '2'),
(56, 7, 'M08', 'dfgfhgf', '2'),
(57, 8, 'M01', 'dfsd', '1'),
(58, 8, 'M02', 'dffs des Ordinateurs', '3'),
(59, 8, 'M03', 'dfdf', '3'),
(60, 8, 'M04', 'fdf & TEC', '3'),
(61, 8, 'M05', 'cdv', '4'),
(62, 8, 'M06', 'tzertery', '4'),
(63, 8, 'M07', 'df', '4'),
(64, 8, 'M08', 'tery', '4');

-- --------------------------------------------------------

--
-- Structure de la table `person`
--

CREATE TABLE `person` (
  `ID_PERSON` int(11) NOT NULL,
  `FIRSTNAME` varchar(34) DEFAULT NULL,
  `LASTNAME` varchar(34) DEFAULT NULL,
  `BRITH_PLACE` varchar(60) DEFAULT NULL,
  `BRITH_DATE` date DEFAULT NULL,
  `CIN` varchar(10) DEFAULT NULL,
  `PHONE` varchar(12) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `URL_PICTURE` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `person`
--

INSERT INTO `person` (`ID_PERSON`, `FIRSTNAME`, `LASTNAME`, `BRITH_PLACE`, `BRITH_DATE`, `CIN`, `PHONE`, `EMAIL`, `URL_PICTURE`) VALUES
(1, 'Soufian', 'azize', 'Marrakech', '1984-01-21', 'TC12352685', '212658148629', 'js@gmail.com', 'None'),
(2, 'ABDelhakim', 'Daryf', 'TIDILI', '1997-05-17', 'TN42365921', '212606741624', 'AbdelhakimDaryf@gmail.com', 'None'),
(3, 'Younas', 'Chakiri', 'Swira', '1996-04-21', 'TN21548796', '212633879521', 'Younas@gmail.com', 'None'),
(4, 'Oussama', 'Filani', '2017-08-17', '1997-06-19', 'TN21517782', '212633329621', 'filon@gmail.com', 'None'),
(5, 'Oussama', 'Lohaibi', 'jdida', '1997-12-30', 'TN21574152', '212614529621', 'Lohaibi@gmail.com', 'None'),
(6, 'CHARAF', 'AITKADIRE', 'IHODJINE', '1988-01-01', 'TN12536421', '0651059328', 'CHARAF@GMAIL.COM', 'None');

-- --------------------------------------------------------

--
-- Structure de la table `results`
--

CREATE TABLE `results` (
  `ID_SBJ` int(11) NOT NULL,
  `ID_STD` int(11) NOT NULL,
  `DS_1` float DEFAULT NULL,
  `DS_2` float DEFAULT NULL,
  `EXAM` float DEFAULT NULL,
  `RATT` float DEFAULT NULL,
  `AR` tinyint(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `results`
--

INSERT INTO `results` (`ID_SBJ`, `ID_STD`, `DS_1`, `DS_2`, `EXAM`, `RATT`, `AR`) VALUES
(25, 1, NULL, NULL, NULL, NULL, 0),
(25, 2, NULL, NULL, NULL, NULL, 0),
(26, 1, NULL, NULL, NULL, NULL, 0),
(26, 2, NULL, NULL, NULL, NULL, 0),
(27, 1, NULL, NULL, NULL, NULL, 0),
(29, 3, NULL, NULL, NULL, NULL, 0);

-- --------------------------------------------------------

--
-- Structure de la table `students`
--

CREATE TABLE `students` (
  `ID_STD` int(11) NOT NULL,
  `ID_PERSON` int(11) NOT NULL,
  `DATE_INSC` date DEFAULT NULL,
  `CNE` decimal(12,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `students`
--

INSERT INTO `students` (`ID_STD`, `ID_PERSON`, `DATE_INSC`, `CNE`) VALUES
(1, 2, '2017-08-01', '1513364364'),
(2, 3, '2017-08-17', '14133256321'),
(3, 4, '2017-08-17', '14133225421'),
(4, 5, '2017-08-17', '14131425321');

-- --------------------------------------------------------

--
-- Structure de la table `subject`
--

CREATE TABLE `subject` (
  `ID_SBJ` int(11) NOT NULL,
  `ID_MDL` int(11) NOT NULL,
  `USERNAME` varchar(34) DEFAULT NULL,
  `NAME_SBJ` varchar(50) NOT NULL,
  `DESCRIPTION_SBJ` varchar(256) DEFAULT NULL,
  `NBR_HOURS` int(11) NOT NULL,
  `PERSENTAGE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `subject`
--

INSERT INTO `subject` (`ID_SBJ`, `ID_MDL`, `USERNAME`, `NAME_SBJ`, `DESCRIPTION_SBJ`, `NBR_HOURS`, `PERSENTAGE`) VALUES
(1, 1, NULL, 'Algo', 'Algorithem', 35, 40),
(2, 1, NULL, 'c', 'Language c', 24, 30),
(3, 1, NULL, 'Structure c', 'Structure de donner', 30, 30),
(4, 2, NULL, 'Sub0modl2', 'Sub0modl2', 36, 40),
(5, 2, NULL, 'Sub1modl2', 'Sub1modl2', 36, 30),
(6, 2, NULL, 'Sub2modl2', 'Sub2modl2', 36, 30),
(7, 3, NULL, 'Sub0modl3', 'Sub0modl3', 36, 40),
(8, 3, NULL, 'Sub1modl3', 'Sub1modl3', 36, 30),
(9, 3, NULL, 'Sub2modl3', 'Sub2modl3', 36, 30),
(10, 4, NULL, 'Sub0modl4', 'Sub0modl4', 36, 40),
(11, 4, NULL, 'Sub1modl4', 'Sub1modl4', 36, 30),
(12, 4, NULL, 'Sub2modl4', 'Sub2modl4', 36, 30),
(13, 5, NULL, 'Sub0modl5', 'Sub0modl5', 36, 40),
(14, 5, NULL, 'Sub1modl5', 'Sub1modl5', 36, 30),
(15, 5, NULL, 'Sub2modl5', 'Sub2modl5', 36, 30),
(16, 6, NULL, 'Sub0modl6', 'Sub0modl6', 36, 40),
(17, 6, NULL, 'Sub1modl6', 'Sub1modl6', 36, 30),
(18, 6, NULL, 'Sub2modl6', 'Sub2modl6', 36, 30),
(19, 7, NULL, 'Sub0modl7', 'Sub0modl7', 36, 40),
(20, 7, NULL, 'Sub1modl7', 'Sub1modl7', 36, 30),
(21, 7, NULL, 'Sub2modl7', 'Sub2modl7', 36, 30),
(22, 8, NULL, 'Sub0modl8', 'Sub0modl8', 36, 40),
(23, 8, NULL, 'Sub1modl8', 'Sub1modl8', 36, 30),
(24, 8, NULL, 'Sub2modl8', 'Sub2modl8', 36, 30),
(25, 9, NULL, 'Sub0modl9', 'Sub0modl9', 36, 40),
(26, 9, NULL, 'Sub1modl9', 'Sub1modl9', 36, 30),
(27, 9, NULL, 'Sub2modl9', 'Sub2modl9', 36, 30),
(28, 10, NULL, 'Sub0modl10', 'Sub0modl10', 36, 40),
(29, 10, NULL, 'Sub1modl10', 'Sub1modl10', 36, 30),
(30, 10, NULL, 'Sub2modl10', 'Sub2modl10', 36, 30),
(31, 11, NULL, 'Sub0modl11', 'Sub0modl11', 36, 40),
(32, 11, NULL, 'Sub1modl11', 'Sub1modl11', 36, 30),
(33, 11, NULL, 'Sub2modl11', 'Sub2modl11', 36, 30),
(34, 12, NULL, 'Sub0modl12', 'Sub0modl12', 36, 40),
(35, 12, NULL, 'Sub1modl12', 'Sub1modl12', 36, 30),
(36, 12, NULL, 'Sub2modl12', 'Sub2modl12', 36, 30),
(37, 13, NULL, 'Sub0modl13', 'Sub0modl13', 36, 40),
(38, 13, NULL, 'Sub1modl13', 'Sub1modl13', 36, 30),
(39, 13, NULL, 'Sub2modl13', 'Sub2modl13', 36, 30),
(40, 14, NULL, 'Sub0modl14', 'Sub0modl14', 36, 40),
(41, 14, NULL, 'Sub1modl14', 'Sub1modl14', 36, 30),
(42, 14, NULL, 'Sub2modl14', 'Sub2modl14', 36, 30),
(43, 15, NULL, 'Sub0modl15', 'Sub0modl15', 36, 40),
(44, 15, NULL, 'Sub1modl15', 'Sub1modl15', 36, 30),
(45, 15, NULL, 'Sub2modl15', 'Sub2modl15', 36, 30),
(46, 16, NULL, 'Sub0modl16', 'Sub0modl16', 36, 40),
(47, 16, NULL, 'Sub1modl16', 'Sub1modl16', 36, 30),
(48, 16, NULL, 'Sub2modl16', 'Sub2modl16', 36, 30),
(49, 17, NULL, 'Sub0modl17', 'Sub0modl17', 36, 40),
(50, 17, NULL, 'Sub1modl17', 'Sub1modl17', 36, 30),
(51, 17, NULL, 'Sub2modl17', 'Sub2modl17', 36, 30),
(52, 18, NULL, 'Sub0modl18', 'Sub0modl18', 36, 40),
(53, 18, NULL, 'Sub1modl18', 'Sub1modl18', 36, 30),
(54, 18, NULL, 'Sub2modl18', 'Sub2modl18', 36, 30),
(55, 19, NULL, 'Sub0modl19', 'Sub0modl19', 36, 40),
(56, 19, NULL, 'Sub1modl19', 'Sub1modl19', 36, 30),
(57, 19, NULL, 'Sub2modl19', 'Sub2modl19', 36, 30),
(58, 20, NULL, 'Sub0modl20', 'Sub0modl20', 36, 40),
(59, 20, NULL, 'Sub1modl20', 'Sub1modl20', 36, 30),
(60, 20, NULL, 'Sub2modl20', 'Sub2modl20', 36, 30),
(61, 21, NULL, 'Sub0modl21', 'Sub0modl21', 36, 40),
(62, 21, NULL, 'Sub1modl21', 'Sub1modl21', 36, 30),
(63, 21, NULL, 'Sub2modl21', 'Sub2modl21', 36, 30),
(64, 22, NULL, 'Sub0modl22', 'Sub0modl22', 36, 40),
(65, 22, NULL, 'Sub1modl22', 'Sub1modl22', 36, 30),
(66, 22, NULL, 'Sub2modl22', 'Sub2modl22', 36, 30),
(67, 23, NULL, 'Sub0modl23', 'Sub0modl23', 36, 40),
(68, 23, NULL, 'Sub1modl23', 'Sub1modl23', 36, 30),
(69, 23, NULL, 'Sub2modl23', 'Sub2modl23', 36, 30),
(70, 24, NULL, 'Sub0modl24', 'Sub0modl24', 36, 40),
(71, 24, NULL, 'Sub1modl24', 'Sub1modl24', 36, 30),
(72, 24, NULL, 'Sub2modl24', 'Sub2modl24', 36, 30),
(73, 25, NULL, 'Sub0modl25', 'Sub0modl25', 36, 40),
(74, 25, NULL, 'Sub1modl25', 'Sub1modl25', 36, 30),
(75, 25, NULL, 'Sub2modl25', 'Sub2modl25', 36, 30),
(76, 26, NULL, 'Sub0modl26', 'Sub0modl26', 36, 40),
(77, 26, NULL, 'Sub1modl26', 'Sub1modl26', 36, 30),
(78, 26, NULL, 'Sub2modl26', 'Sub2modl26', 36, 30),
(79, 27, NULL, 'Sub0modl27', 'Sub0modl27', 36, 40),
(80, 27, NULL, 'Sub1modl27', 'Sub1modl27', 36, 30),
(81, 27, NULL, 'Sub2modl27', 'Sub2modl27', 36, 30),
(82, 28, NULL, 'Sub0modl28', 'Sub0modl28', 36, 40),
(83, 28, NULL, 'Sub1modl28', 'Sub1modl28', 36, 30),
(84, 28, NULL, 'Sub2modl28', 'Sub2modl28', 36, 30),
(85, 29, NULL, 'Sub0modl29', 'Sub0modl29', 36, 40),
(86, 29, NULL, 'Sub1modl29', 'Sub1modl29', 36, 30),
(87, 29, NULL, 'Sub2modl29', 'Sub2modl29', 36, 30),
(88, 30, NULL, 'Sub0modl30', 'Sub0modl30', 36, 40),
(89, 30, NULL, 'Sub1modl30', 'Sub1modl30', 36, 30),
(90, 30, NULL, 'Sub2modl30', 'Sub2modl30', 36, 30),
(91, 31, NULL, 'Sub0modl31', 'Sub0modl31', 36, 40),
(92, 31, NULL, 'Sub1modl31', 'Sub1modl31', 36, 30),
(93, 31, NULL, 'Sub2modl31', 'Sub2modl31', 36, 30),
(94, 32, NULL, 'Sub0modl32', 'Sub0modl32', 36, 40),
(95, 32, NULL, 'Sub1modl32', 'Sub1modl32', 36, 30),
(96, 32, NULL, 'Sub2modl32', 'Sub2modl32', 36, 30),
(97, 33, NULL, 'Sub0modl33', 'Sub0modl33', 36, 40),
(98, 33, NULL, 'Sub1modl33', 'Sub1modl33', 36, 30),
(99, 33, NULL, 'Sub2modl33', 'Sub2modl33', 36, 30),
(100, 34, NULL, 'Sub0modl34', 'Sub0modl34', 36, 40),
(101, 34, NULL, 'Sub1modl34', 'Sub1modl34', 36, 30),
(102, 34, NULL, 'Sub2modl34', 'Sub2modl34', 36, 30),
(103, 35, NULL, 'Sub0modl35', 'Sub0modl35', 36, 40),
(104, 35, NULL, 'Sub1modl35', 'Sub1modl35', 36, 30),
(105, 35, NULL, 'Sub2modl35', 'Sub2modl35', 36, 30),
(106, 36, NULL, 'Sub0modl36', 'Sub0modl36', 36, 40),
(107, 36, NULL, 'Sub1modl36', 'Sub1modl36', 36, 30),
(108, 36, NULL, 'Sub2modl36', 'Sub2modl36', 36, 30),
(109, 37, NULL, 'Sub0modl37', 'Sub0modl37', 36, 40),
(110, 37, NULL, 'Sub1modl37', 'Sub1modl37', 36, 30),
(111, 37, NULL, 'Sub2modl37', 'Sub2modl37', 36, 30),
(112, 38, NULL, 'Sub0modl38', 'Sub0modl38', 36, 40),
(113, 38, NULL, 'Sub1modl38', 'Sub1modl38', 36, 30),
(114, 38, NULL, 'Sub2modl38', 'Sub2modl38', 36, 30),
(115, 39, NULL, 'Sub0modl39', 'Sub0modl39', 36, 40),
(116, 39, NULL, 'Sub1modl39', 'Sub1modl39', 36, 30),
(117, 39, NULL, 'Sub2modl39', 'Sub2modl39', 36, 30),
(118, 40, NULL, 'Sub0modl40', 'Sub0modl40', 36, 40),
(119, 40, NULL, 'Sub1modl40', 'Sub1modl40', 36, 30),
(120, 40, NULL, 'Sub2modl40', 'Sub2modl40', 36, 30),
(121, 41, NULL, 'Sub0modl41', 'Sub0modl41', 36, 40),
(122, 41, NULL, 'Sub1modl41', 'Sub1modl41', 36, 30),
(123, 41, NULL, 'Sub2modl41', 'Sub2modl41', 36, 30),
(124, 42, NULL, 'Sub0modl42', 'Sub0modl42', 36, 40),
(125, 42, NULL, 'Sub1modl42', 'Sub1modl42', 36, 30),
(126, 42, NULL, 'Sub2modl42', 'Sub2modl42', 36, 30),
(127, 43, NULL, 'Sub0modl43', 'Sub0modl43', 36, 40),
(128, 43, NULL, 'Sub1modl43', 'Sub1modl43', 36, 30),
(129, 43, NULL, 'Sub2modl43', 'Sub2modl43', 36, 30),
(130, 44, NULL, 'Sub0modl44', 'Sub0modl44', 36, 40),
(131, 44, NULL, 'Sub1modl44', 'Sub1modl44', 36, 30),
(132, 44, NULL, 'Sub2modl44', 'Sub2modl44', 36, 30),
(133, 45, NULL, 'Sub0modl45', 'Sub0modl45', 36, 40),
(134, 45, NULL, 'Sub1modl45', 'Sub1modl45', 36, 30),
(135, 45, NULL, 'Sub2modl45', 'Sub2modl45', 36, 30),
(136, 46, NULL, 'Sub0modl46', 'Sub0modl46', 36, 40),
(137, 46, NULL, 'Sub1modl46', 'Sub1modl46', 36, 30),
(138, 46, NULL, 'Sub2modl46', 'Sub2modl46', 36, 30),
(139, 47, NULL, 'Sub0modl47', 'Sub0modl47', 36, 40),
(140, 47, NULL, 'Sub1modl47', 'Sub1modl47', 36, 30),
(141, 47, NULL, 'Sub2modl47', 'Sub2modl47', 36, 30),
(142, 48, NULL, 'Sub0modl48', 'Sub0modl48', 36, 40),
(143, 48, NULL, 'Sub1modl48', 'Sub1modl48', 36, 30),
(144, 48, NULL, 'Sub2modl48', 'Sub2modl48', 36, 30),
(145, 49, NULL, 'Sub0modl49', 'Sub0modl49', 36, 40),
(146, 49, NULL, 'Sub1modl49', 'Sub1modl49', 36, 30),
(147, 49, NULL, 'Sub2modl49', 'Sub2modl49', 36, 30),
(148, 50, NULL, 'Sub0modl50', 'Sub0modl50', 36, 40),
(149, 50, NULL, 'Sub1modl50', 'Sub1modl50', 36, 30),
(150, 50, NULL, 'Sub2modl50', 'Sub2modl50', 36, 30),
(151, 51, NULL, 'Sub0modl51', 'Sub0modl51', 36, 40),
(152, 51, NULL, 'Sub1modl51', 'Sub1modl51', 36, 30),
(153, 51, NULL, 'Sub2modl51', 'Sub2modl51', 36, 30),
(154, 52, NULL, 'Sub0modl52', 'Sub0modl52', 36, 40),
(155, 52, NULL, 'Sub1modl52', 'Sub1modl52', 36, 30),
(156, 52, NULL, 'Sub2modl52', 'Sub2modl52', 36, 30),
(157, 53, NULL, 'Sub0modl53', 'Sub0modl53', 36, 40),
(158, 53, NULL, 'Sub1modl53', 'Sub1modl53', 36, 30),
(159, 53, NULL, 'Sub2modl53', 'Sub2modl53', 36, 30),
(160, 54, NULL, 'Sub0modl54', 'Sub0modl54', 36, 40),
(161, 54, NULL, 'Sub1modl54', 'Sub1modl54', 36, 30),
(162, 54, NULL, 'Sub2modl54', 'Sub2modl54', 36, 30),
(163, 55, NULL, 'Sub0modl55', 'Sub0modl55', 36, 40),
(164, 55, NULL, 'Sub1modl55', 'Sub1modl55', 36, 30),
(165, 55, NULL, 'Sub2modl55', 'Sub2modl55', 36, 30),
(166, 56, NULL, 'Sub0modl56', 'Sub0modl56', 36, 40),
(167, 56, NULL, 'Sub1modl56', 'Sub1modl56', 36, 30),
(168, 56, NULL, 'Sub2modl56', 'Sub2modl56', 36, 30),
(169, 57, NULL, 'Sub0modl57', 'Sub0modl57', 36, 40),
(170, 57, NULL, 'Sub1modl57', 'Sub1modl57', 36, 30),
(171, 57, NULL, 'Sub2modl57', 'Sub2modl57', 36, 30),
(172, 58, NULL, 'Sub0modl58', 'Sub0modl58', 36, 40),
(173, 58, NULL, 'Sub1modl58', 'Sub1modl58', 36, 30),
(174, 58, NULL, 'Sub2modl58', 'Sub2modl58', 36, 30),
(175, 59, NULL, 'Sub0modl59', 'Sub0modl59', 36, 40),
(176, 59, NULL, 'Sub1modl59', 'Sub1modl59', 36, 30),
(177, 59, NULL, 'Sub2modl59', 'Sub2modl59', 36, 30),
(178, 60, NULL, 'Sub0modl60', 'Sub0modl60', 36, 40),
(179, 60, NULL, 'Sub1modl60', 'Sub1modl60', 36, 30),
(180, 60, NULL, 'Sub2modl60', 'Sub2modl60', 36, 30),
(181, 61, NULL, 'Sub0modl61', 'Sub0modl61', 36, 40),
(182, 61, NULL, 'Sub1modl61', 'Sub1modl61', 36, 30),
(183, 61, NULL, 'Sub2modl61', 'Sub2modl61', 36, 30),
(184, 62, NULL, 'Sub0modl62', 'Sub0modl62', 36, 40),
(185, 62, NULL, 'Sub1modl62', 'Sub1modl62', 36, 30),
(186, 62, NULL, 'Sub2modl62', 'Sub2modl62', 36, 30),
(187, 63, NULL, 'Sub0modl63', 'Sub0modl63', 36, 40),
(188, 63, NULL, 'Sub1modl63', 'Sub1modl63', 36, 30),
(189, 63, NULL, 'Sub2modl63', 'Sub2modl63', 36, 30),
(190, 64, NULL, 'Sub0modl64', 'Sub0modl64', 36, 40),
(191, 64, NULL, 'Sub1modl64', 'Sub1modl64', 36, 30),
(192, 64, NULL, 'Sub2modl64', 'Sub2modl64', 36, 30);

-- --------------------------------------------------------

--
-- Structure de la table `supervisor_sbj`
--

CREATE TABLE `supervisor_sbj` (
  `ID_MANAGER_STD` int(11) NOT NULL,
  `ID_SBJ` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `USERNAME` varchar(34) NOT NULL,
  `ID_PERSON` int(11) NOT NULL,
  `ID_MANAGER_USER` int(11) DEFAULT NULL,
  `PASSWORD` varchar(20) NOT NULL,
  `POSITION` varchar(34) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`USERNAME`, `ID_PERSON`, `ID_MANAGER_USER`, `PASSWORD`, `POSITION`) VALUES
('ACHERAF', 6, 2, '1245wx', 'PROFFESUER'),
('souf', 1, 1, '124578', 'professuer');

-- --------------------------------------------------------

--
-- Structure de la table `year`
--

CREATE TABLE `year` (
  `ID_YEAR` int(11) NOT NULL,
  `ID_DPRT` int(11) NOT NULL,
  `YEAR` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `year`
--

INSERT INTO `year` (`ID_YEAR`, `ID_DPRT`, `YEAR`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 2, 1),
(4, 2, 2),
(5, 3, 1),
(6, 3, 2),
(7, 4, 1),
(8, 4, 2);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `absence_student`
--
ALTER TABLE `absence_student`
  ADD PRIMARY KEY (`ID_CRS`,`ID_STD`),
  ADD KEY `FK_ABSENCE_STUDENT2` (`ID_STD`);

--
-- Index pour la table `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`ID_YEAR`,`ID_STD`),
  ADD KEY `FK_CLASS2` (`ID_STD`);

--
-- Index pour la table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`ID_CRS`),
  ADD KEY `FK_CONTENT` (`ID_SBJ`);

--
-- Index pour la table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`ID_DPRT`);

--
-- Index pour la table `history`
--
ALTER TABLE `history`
  ADD PRIMARY KEY (`ID_HISTORY`),
  ADD KEY `FK_HISTORY` (`USERNAME`);

--
-- Index pour la table `management_student`
--
ALTER TABLE `management_student`
  ADD PRIMARY KEY (`USERNAME`,`ID_MANAGER_STD`),
  ADD KEY `FK_MANAGEMENT_STUDENT2` (`ID_MANAGER_STD`);

--
-- Index pour la table `manager_student`
--
ALTER TABLE `manager_student`
  ADD PRIMARY KEY (`ID_MANAGER_STD`);

--
-- Index pour la table `manager_user`
--
ALTER TABLE `manager_user`
  ADD PRIMARY KEY (`ID_MANAGER_USER`);

--
-- Index pour la table `module`
--
ALTER TABLE `module`
  ADD PRIMARY KEY (`ID_MDL`),
  ADD KEY `FK_IN_YEAR` (`ID_YEAR`);

--
-- Index pour la table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`ID_PERSON`);

--
-- Index pour la table `results`
--
ALTER TABLE `results`
  ADD PRIMARY KEY (`ID_SBJ`,`ID_STD`),
  ADD KEY `FK_RESULTS2` (`ID_STD`);

--
-- Index pour la table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`ID_STD`),
  ADD KEY `FK_INFO_STUDENTS` (`ID_PERSON`);

--
-- Index pour la table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`ID_SBJ`),
  ADD KEY `FK_MODULE_UNITE` (`ID_MDL`),
  ADD KEY `FK_PROFESSOR` (`USERNAME`);

--
-- Index pour la table `supervisor_sbj`
--
ALTER TABLE `supervisor_sbj`
  ADD PRIMARY KEY (`ID_MANAGER_STD`,`ID_SBJ`),
  ADD KEY `FK_SUPERVISOR_SBJ2` (`ID_SBJ`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`USERNAME`),
  ADD KEY `FK_INFO_USERS` (`ID_PERSON`),
  ADD KEY `FK_MANAGEMENT_PROF` (`ID_MANAGER_USER`);

--
-- Index pour la table `year`
--
ALTER TABLE `year`
  ADD PRIMARY KEY (`ID_YEAR`),
  ADD KEY `FK_DEPARTMENT_UNITE` (`ID_DPRT`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `courses`
--
ALTER TABLE `courses`
  MODIFY `ID_CRS` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `department`
--
ALTER TABLE `department`
  MODIFY `ID_DPRT` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `history`
--
ALTER TABLE `history`
  MODIFY `ID_HISTORY` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `manager_student`
--
ALTER TABLE `manager_student`
  MODIFY `ID_MANAGER_STD` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `manager_user`
--
ALTER TABLE `manager_user`
  MODIFY `ID_MANAGER_USER` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `module`
--
ALTER TABLE `module`
  MODIFY `ID_MDL` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;
--
-- AUTO_INCREMENT pour la table `person`
--
ALTER TABLE `person`
  MODIFY `ID_PERSON` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT pour la table `students`
--
ALTER TABLE `students`
  MODIFY `ID_STD` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `subject`
--
ALTER TABLE `subject`
  MODIFY `ID_SBJ` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=193;
--
-- AUTO_INCREMENT pour la table `year`
--
ALTER TABLE `year`
  MODIFY `ID_YEAR` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `absence_student`
--
ALTER TABLE `absence_student`
  ADD CONSTRAINT `FK_ABSENCE_STUDENT` FOREIGN KEY (`ID_CRS`) REFERENCES `courses` (`ID_CRS`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_ABSENCE_STUDENT2` FOREIGN KEY (`ID_STD`) REFERENCES `students` (`ID_STD`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `class`
--
ALTER TABLE `class`
  ADD CONSTRAINT `FK_CLASS` FOREIGN KEY (`ID_YEAR`) REFERENCES `year` (`ID_YEAR`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_CLASS2` FOREIGN KEY (`ID_STD`) REFERENCES `students` (`ID_STD`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `courses`
--
ALTER TABLE `courses`
  ADD CONSTRAINT `FK_CONTENT` FOREIGN KEY (`ID_SBJ`) REFERENCES `subject` (`ID_SBJ`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `history`
--
ALTER TABLE `history`
  ADD CONSTRAINT `FK_HISTORY` FOREIGN KEY (`USERNAME`) REFERENCES `users` (`USERNAME`);

--
-- Contraintes pour la table `management_student`
--
ALTER TABLE `management_student`
  ADD CONSTRAINT `FK_MANAGEMENT_STUDENT` FOREIGN KEY (`USERNAME`) REFERENCES `users` (`USERNAME`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_MANAGEMENT_STUDENT2` FOREIGN KEY (`ID_MANAGER_STD`) REFERENCES `manager_student` (`ID_MANAGER_STD`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `module`
--
ALTER TABLE `module`
  ADD CONSTRAINT `FK_IN_YEAR` FOREIGN KEY (`ID_YEAR`) REFERENCES `year` (`ID_YEAR`);

--
-- Contraintes pour la table `results`
--
ALTER TABLE `results`
  ADD CONSTRAINT `FK_RESULTS` FOREIGN KEY (`ID_SBJ`) REFERENCES `subject` (`ID_SBJ`),
  ADD CONSTRAINT `FK_RESULTS2` FOREIGN KEY (`ID_STD`) REFERENCES `students` (`ID_STD`);

--
-- Contraintes pour la table `students`
--
ALTER TABLE `students`
  ADD CONSTRAINT `FK_INFO_STUDENTS` FOREIGN KEY (`ID_PERSON`) REFERENCES `person` (`ID_PERSON`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `subject`
--
ALTER TABLE `subject`
  ADD CONSTRAINT `FK_MODULE_UNITE` FOREIGN KEY (`ID_MDL`) REFERENCES `module` (`ID_MDL`),
  ADD CONSTRAINT `FK_PROFESSOR` FOREIGN KEY (`USERNAME`) REFERENCES `users` (`USERNAME`);

--
-- Contraintes pour la table `supervisor_sbj`
--
ALTER TABLE `supervisor_sbj`
  ADD CONSTRAINT `FK_SUPERVISOR_SBJ` FOREIGN KEY (`ID_MANAGER_STD`) REFERENCES `manager_student` (`ID_MANAGER_STD`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_SUPERVISOR_SBJ2` FOREIGN KEY (`ID_SBJ`) REFERENCES `subject` (`ID_SBJ`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `FK_INFO_USERS` FOREIGN KEY (`ID_PERSON`) REFERENCES `person` (`ID_PERSON`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_MANAGEMENT_PROF` FOREIGN KEY (`ID_MANAGER_USER`) REFERENCES `manager_user` (`ID_MANAGER_USER`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `year`
--
ALTER TABLE `year`
  ADD CONSTRAINT `FK_DEPARTMENT_UNITE` FOREIGN KEY (`ID_DPRT`) REFERENCES `department` (`ID_DPRT`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
