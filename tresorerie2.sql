-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Lun 12 Juin 2017 à 03:05
-- Version du serveur :  10.1.21-MariaDB
-- Version de PHP :  5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `tresorerie2`
--

-- --------------------------------------------------------

--
-- Structure de la table `administrateur`
--

CREATE TABLE `administrateur` (
  `login` varchar(25) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `administrateur`
--

INSERT INTO `administrateur` (`login`, `password`) VALUES
('admin', '123');

-- --------------------------------------------------------

--
-- Structure de la table `attestation_rib`
--

CREATE TABLE `attestation_rib` (
  `ID` int(11) NOT NULL,
  `Code_Frs` int(11) NOT NULL,
  `Saisie_Arret` varchar(100) NOT NULL,
  `Commande_Marche` varchar(100) NOT NULL,
  `Banque` int(11) NOT NULL,
  `Date_Ecrit` varchar(20) NOT NULL,
  `Dte_MAJ` varchar(20) NOT NULL,
  `N_Ordre` int(11) NOT NULL,
  `Arrivee` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `attestation_rib`
--

INSERT INTO `attestation_rib` (`ID`, `Code_Frs`, `Saisie_Arret`, `Commande_Marche`, `Banque`, `Date_Ecrit`, `Dte_MAJ`, `N_Ordre`, `Arrivee`) VALUES
(1, 810, 'hello', 'ok', 1, 'mly youssef', 'casablance', 12, 'ok'),
(2, 810, 'ok', 'er', 1, 'mly youssef', 'casablance', 123, 'qwe'),
(3, 810, 'qwe 32', 'qazswx', 1, 'mly youssef', 'casablance', 123213, 'desw');

-- --------------------------------------------------------

--
-- Structure de la table `banque`
--

CREATE TABLE `banque` (
  `id_Ville` int(11) NOT NULL,
  `Banque` varchar(100) NOT NULL,
  `N_Compte` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `banque`
--

INSERT INTO `banque` (`id_Ville`, `Banque`, `N_Compte`) VALUES
(1, 'sogefcoring', 1),
(3, 'Banque Populaire', 901),
(2, 'bmce', 123456754);

-- --------------------------------------------------------

--
-- Structure de la table `fournisseur`
--

CREATE TABLE `fournisseur` (
  `Code_Frs` int(11) NOT NULL,
  `Fournisseur` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `fournisseur`
--

INSERT INTO `fournisseur` (`Code_Frs`, `Fournisseur`) VALUES
(810, 'cometalaux sarl'),
(7617, 'BIG THERM');

-- --------------------------------------------------------

--
-- Structure de la table `ville`
--

CREATE TABLE `ville` (
  `id` int(11) NOT NULL,
  `Ville` varchar(50) NOT NULL,
  `Agence` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `ville`
--

INSERT INTO `ville` (`id`, `Ville`, `Agence`) VALUES
(1, 'casablance', 'mly youssef'),
(2, 'el jadida', 'bcp factoring'),
(3, 'Safi', 'Banque Populaire');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `administrateur`
--
ALTER TABLE `administrateur`
  ADD PRIMARY KEY (`login`,`password`);

--
-- Index pour la table `attestation_rib`
--
ALTER TABLE `attestation_rib`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Banque` (`Banque`),
  ADD KEY `Code_Frs` (`Code_Frs`);

--
-- Index pour la table `banque`
--
ALTER TABLE `banque`
  ADD PRIMARY KEY (`N_Compte`),
  ADD KEY `banque_ibfk_1` (`id_Ville`);

--
-- Index pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  ADD PRIMARY KEY (`Code_Frs`);

--
-- Index pour la table `ville`
--
ALTER TABLE `ville`
  ADD PRIMARY KEY (`id`,`Ville`,`Agence`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `attestation_rib`
--
ALTER TABLE `attestation_rib`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `attestation_rib`
--
ALTER TABLE `attestation_rib`
  ADD CONSTRAINT `attestation_rib_ibfk_1` FOREIGN KEY (`Banque`) REFERENCES `banque` (`N_Compte`),
  ADD CONSTRAINT `attestation_rib_ibfk_2` FOREIGN KEY (`Code_Frs`) REFERENCES `fournisseur` (`Code_Frs`);

--
-- Contraintes pour la table `banque`
--
ALTER TABLE `banque`
  ADD CONSTRAINT `banque_ibfk_1` FOREIGN KEY (`id_Ville`) REFERENCES `ville` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
