-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Lun 22 Mai 2017 à 22:38
-- Version du serveur :  5.7.10-log
-- Version de PHP :  5.6.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `rades_gestion_stock`
--

-- --------------------------------------------------------

--
-- Structure de la table `gestion_stock`
--

CREATE TABLE `gestion_stock` (
  `id` int(20) NOT NULL,
  `nom_prenom` varchar(300) NOT NULL,
  `produit` varchar(300) NOT NULL,
  `date` varchar(300) NOT NULL,
  `quantite` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `gestion_stock`
--

INSERT INTO `gestion_stock` (`id`, `nom_prenom`, `produit`, `date`, `quantite`) VALUES
(1, 'kharaz ayooub', '1', '1', 1),
(8, 'kharaz ayooub', '1', '23232', 2);

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `id` int(30) NOT NULL,
  `designiation` varchar(300) NOT NULL,
  `marque` varchar(300) NOT NULL,
  `n_serie` varchar(300) NOT NULL,
  `quantite` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `produit`
--

INSERT INTO `produit` (`id`, `designiation`, `marque`, `n_serie`, `quantite`) VALUES
(1, '1', '1', '1', 1),
(2, '1', '1', '1', 1),
(28, '1', '1', '1', 1);

-- --------------------------------------------------------

--
-- Structure de la table `salarie`
--

CREATE TABLE `salarie` (
  `id` int(30) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `statut` varchar(30) NOT NULL,
  `mail` varchar(30) NOT NULL,
  `tel` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `salarie`
--

INSERT INTO `salarie` (`id`, `nom`, `prenom`, `statut`, `mail`, `tel`) VALUES
(1, 'ayooub', 'kharaz', '1', '1', '1'),
(12, '1', '1', '1', '1', '1'),
(128, '1', '1', '1', '1', '1');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `gestion_stock`
--
ALTER TABLE `gestion_stock`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `salarie`
--
ALTER TABLE `salarie`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `gestion_stock`
--
ALTER TABLE `gestion_stock`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
--
-- AUTO_INCREMENT pour la table `salarie`
--
ALTER TABLE `salarie`
  MODIFY `id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=129;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
