-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 01 oct. 2019 à 08:43
-- Version du serveur :  5.7.26
-- Version de PHP :  7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `applisport`
--
CREATE DATABASE IF NOT EXISTS `applisport` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `applisport`;

-- --------------------------------------------------------

--
-- Structure de la table `activite`
--

DROP TABLE IF EXISTS `activite`;
CREATE TABLE IF NOT EXISTS `activite` (
  `idActivite` int(11) NOT NULL AUTO_INCREMENT,
  `Type` varchar(45) NOT NULL,
  `Valeur` double NOT NULL,
  `Date` datetime NOT NULL,
  `User_idUser` int(11) NOT NULL,
  PRIMARY KEY (`idActivite`),
  KEY `fk_Activite_User_idx` (`User_idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(45) NOT NULL,
  `Prenom` varchar(45) NOT NULL,
  `Mdp` varchar(45) NOT NULL,
  `Mail` varchar(45) NOT NULL UNIQUE,
  `Age` int(11) DEFAULT NULL,
  `Sexe` varchar(45) DEFAULT NULL,
  `Poids` double DEFAULT NULL,
  `Taille` double DEFAULT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`idUser`, `Nom`, `Prenom`, `Mdp`, `Mail`, `Age`, `Sexe`, `Poids`, `Taille`) VALUES
(1, 'Esperance', 'Vincent', 'VE', 've@gmail.com', 23, 'M', 60, 1.73),
(2, 'Pflieger', 'Audrey', 'AP', 'ap@gmail.com', NULL, NULL, NULL, NULL);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `activite`
--
ALTER TABLE `activite`
  ADD CONSTRAINT `fk_Activite_User` FOREIGN KEY (`User_idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
