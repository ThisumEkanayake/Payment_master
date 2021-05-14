-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 14, 2021 at 04:52 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `paydb`
--

-- --------------------------------------------------------

--
-- Table structure for table `paydb`
--

CREATE TABLE `paydb` (
  `paymentID` varchar(10) NOT NULL,
  `amount` varchar(10) NOT NULL,
  `date` varchar(20) NOT NULL,
  `accountNo` double NOT NULL,
  `paymentType` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `paydb`
--

INSERT INTO `paydb` (`paymentID`, `amount`, `date`, `accountNo`, `paymentType`) VALUES
('254', '80000', '2021%2F4%2F13', 600, 'credit'),
('692', '12500', '2021/4/24', 25, 'cash'),
('0', '40000', '2021.5.10', 45, 'cash');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
