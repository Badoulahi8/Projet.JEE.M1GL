-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 27, 2021 at 11:14 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gestion_banque`
--

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `idclient` int(11) NOT NULL,
  `numeroclient` varchar(20) NOT NULL,
  `nomclient` varchar(50) NOT NULL,
  `adresseclient` varchar(100) NOT NULL,
  `telephoneclient` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`idclient`, `numeroclient`, `nomclient`, `adresseclient`, `telephoneclient`) VALUES
(1, 'NUM-0001', 'Diop', 'Pikine', '774848888'),
(2, 'NUM-0002', 'Samba Seck', 'Kaolack', '7737882921'),
(3, 'NUM-0003', 'Saliou', 'Pikine', '774325400'),
(4, 'NUM-0004', 'Wade', 'Medina', '772930281'),
(5, 'NUM-0005', 'Thierno', 'Yeumbeul', '884994029');

-- --------------------------------------------------------

--
-- Table structure for table `compte`
--

CREATE TABLE `compte` (
  `idcompte` int(11) NOT NULL,
  `numerocompte` varchar(20) NOT NULL,
  `montantcompte` double NOT NULL,
  `datecreation` varchar(100) NOT NULL,
  `numeroclient` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `compte`
--

INSERT INTO `compte` (`idcompte`, `numerocompte`, `montantcompte`, `datecreation`, `numeroclient`) VALUES
(14, 'CMP-NUM-0001', 2500, '2021/03/03', 'NUM-0001'),
(15, 'CMP-NUM-0002', 5455, '2021/03/04', 'NUM-0002'),
(16, 'CMP-NUM-0003', 6000, '2021/03/04', 'NUM-0003'),
(17, 'CMP-NUM-0004', 0, '2021/03/13', 'NUM-0004'),
(18, 'CMP-NUM-0005', 0, '2021/03/13', 'NUM-0005');

-- --------------------------------------------------------

--
-- Table structure for table `employe`
--

CREATE TABLE `employe` (
  `idemploye` int(11) NOT NULL,
  `nomemploye` varchar(30) NOT NULL,
  `prenomemploye` varchar(50) NOT NULL,
  `login` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employe`
--

INSERT INTO `employe` (`idemploye`, `nomemploye`, `prenomemploye`, `login`, `password`) VALUES
(1, 'Sall', 'Thierno', 'sall@gmail.com', 'passer');

-- --------------------------------------------------------

--
-- Table structure for table `operation`
--

CREATE TABLE `operation` (
  `idoperation` int(11) NOT NULL,
  `typeoperation` varchar(20) NOT NULL,
  `dateheureoperation` varchar(30) NOT NULL,
  `numeroclient` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `operation`
--

INSERT INTO `operation` (`idoperation`, `typeoperation`, `dateheureoperation`, `numeroclient`) VALUES
(1, 'Depot', '2021/03/06', 'NUM-0002'),
(2, 'Retraite', '2021/03/06', 'NUM-0002'),
(3, 'Depot', '2021/03/20 09:30:32', 'NUM-0003'),
(4, 'Depot', '2021/03/27 09:44:21', 'NUM-0003');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`idclient`);

--
-- Indexes for table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`idcompte`);

--
-- Indexes for table `employe`
--
ALTER TABLE `employe`
  ADD PRIMARY KEY (`idemploye`);

--
-- Indexes for table `operation`
--
ALTER TABLE `operation`
  ADD PRIMARY KEY (`idoperation`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `idclient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `compte`
--
ALTER TABLE `compte`
  MODIFY `idcompte` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `employe`
--
ALTER TABLE `employe`
  MODIFY `idemploye` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `operation`
--
ALTER TABLE `operation`
  MODIFY `idoperation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
