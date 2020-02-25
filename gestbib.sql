-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mer. 15 mai 2019 à 17:07
-- Version du serveur :  10.1.31-MariaDB
-- Version de PHP :  7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gestbib`
--

-- --------------------------------------------------------

--
-- Structure de la table `book`
--

CREATE TABLE `book` (
  `book_id` int(12) NOT NULL,
  `title` varchar(35) NOT NULL,
  `author` varchar(25) NOT NULL,
  `theme` varchar(25) NOT NULL,
  `page` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `book`
--

INSERT INTO `book` (`book_id`, `title`, `author`, `theme`, `page`) VALUES
(1, 'c++', 'steph', 'programming', 300),
(1111, 'fer', 'fre', 'fre', 11);

-- --------------------------------------------------------

--
-- Structure de la table `librian`
--

CREATE TABLE `librian` (
  `IdLib` int(5) NOT NULL,
  `UserName` varchar(30) NOT NULL,
  `PassLib` varchar(30) NOT NULL,
  `EmailLib` varchar(30) NOT NULL,
  `AnnNaissLib` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `librian`
--

INSERT INTO `librian` (`IdLib`, `UserName`, `PassLib`, `EmailLib`, `AnnNaissLib`) VALUES
(1, 'Manager', 'manager123', 'manager@gmail.com', '1985-04-09');

-- --------------------------------------------------------

--
-- Structure de la table `livre`
--

CREATE TABLE `livre` (
  `NumLiv` int(5) NOT NULL,
  `TitreLiv` varchar(30) NOT NULL,
  `AuteurLiv` varchar(30) NOT NULL,
  `TypeLiv` varchar(30) NOT NULL,
  `NumbCopLiv` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `livre`
--

INSERT INTO `livre` (`NumLiv`, `TitreLiv`, `AuteurLiv`, `TypeLiv`, `NumbCopLiv`) VALUES
(1, 'Java Programmation', 'Edward Neon', 'Informatique', 4),
(2, 'Initiation a l\'algorithme', 'Cristof Nathan', 'Informatique', 2),
(3, 'Battaile d\'algerie', 'Krim Belkacem', 'Histoire', 2),
(4, 'Ahadith', 'Ibn Taimia', 'Religion', 5);

-- --------------------------------------------------------

--
-- Structure de la table `student`
--

CREATE TABLE `student` (
  `NmStud` int(5) NOT NULL,
  `NomStud` varchar(30) NOT NULL,
  `PrenStud` varchar(30) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `AnnNaiss` date NOT NULL,
  `Password` varchar(30) NOT NULL,
  `NumInsc` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `student`
--

INSERT INTO `student` (`NmStud`, `NomStud`, `PrenStud`, `Email`, `AnnNaiss`, `Password`, `NumInsc`) VALUES
(1, 'admin', 'admin', 'admin@ymail.com', '1996-06-23', 'admin', '123456789'),
(2, 'nassim', 'arab', 'nassimarab@gmail.com', '1997-05-16', 'nassim123', '987654321'),
(4, 'root', 'root', 'root@yahoo.fr', '2018-04-18', 'toor', '22222');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `librian`
--
ALTER TABLE `librian`
  ADD PRIMARY KEY (`IdLib`);

--
-- Index pour la table `livre`
--
ALTER TABLE `livre`
  ADD PRIMARY KEY (`NumLiv`);

--
-- Index pour la table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`NmStud`),
  ADD UNIQUE KEY `NumInsc` (`NumInsc`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `librian`
--
ALTER TABLE `librian`
  MODIFY `IdLib` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `livre`
--
ALTER TABLE `livre`
  MODIFY `NumLiv` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `student`
--
ALTER TABLE `student`
  MODIFY `NmStud` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
