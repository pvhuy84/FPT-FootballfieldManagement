-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 12, 2016 at 04:58 AM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `footballfield_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `bookfield`
--

CREATE TABLE `bookfield` (
  `phonenumber` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `field_id` varchar(4) COLLATE utf8mb4_unicode_ci NOT NULL,
  `timepacket_id` int(11) NOT NULL,
  `day` date NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `bookfield`
--

INSERT INTO `bookfield` (`phonenumber`, `field_id`, `timepacket_id`, `day`, `status`) VALUES
('01222333333', 'F01', 4, '2016-11-14', 0);

-- --------------------------------------------------------

--
-- Table structure for table `field`
--

CREATE TABLE `field` (
  `field_id` varchar(4) COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `field`
--

INSERT INTO `field` (`field_id`, `status`) VALUES
('F01', 'normal'),
('F02', 'normal'),
('F03', 'repairing');

-- --------------------------------------------------------

--
-- Table structure for table `timepacket`
--

CREATE TABLE `timepacket` (
  `timepacket_id` int(11) NOT NULL,
  `type` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `timepacket`
--

INSERT INTO `timepacket` (`timepacket_id`, `type`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 2),
(6, 2),
(11, 2),
(12, 2),
(13, 2),
(14, 2),
(7, 3),
(8, 3),
(9, 3),
(10, 3);

-- --------------------------------------------------------

--
-- Table structure for table `type`
--

CREATE TABLE `type` (
  `type` int(11) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `type`
--

INSERT INTO `type` (`type`, `price`) VALUES
(1, 50000),
(2, 60000),
(3, 70000);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `phonenumber` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(25) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(25) COLLATE utf8mb4_unicode_ci NOT NULL,
  `role` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`phonenumber`, `password`, `name`, `role`) VALUES
('01222333333', '123456', 'Hoang Thanh Cong', 0),
('01666555555', '123456', 'Pham Van Huy', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bookfield`
--
ALTER TABLE `bookfield`
  ADD PRIMARY KEY (`phonenumber`),
  ADD KEY `timepacket_id` (`timepacket_id`),
  ADD KEY `field_id` (`field_id`);

--
-- Indexes for table `field`
--
ALTER TABLE `field`
  ADD PRIMARY KEY (`field_id`);

--
-- Indexes for table `timepacket`
--
ALTER TABLE `timepacket`
  ADD PRIMARY KEY (`timepacket_id`),
  ADD KEY `type` (`type`);

--
-- Indexes for table `type`
--
ALTER TABLE `type`
  ADD PRIMARY KEY (`type`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`phonenumber`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `timepacket`
--
ALTER TABLE `timepacket`
  MODIFY `timepacket_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `bookfield`
--
ALTER TABLE `bookfield`
  ADD CONSTRAINT `bookfield_ibfk_1` FOREIGN KEY (`phonenumber`) REFERENCES `user` (`phonenumber`),
  ADD CONSTRAINT `bookfield_ibfk_2` FOREIGN KEY (`timepacket_id`) REFERENCES `timepacket` (`timepacket_id`),
  ADD CONSTRAINT `bookfield_ibfk_3` FOREIGN KEY (`field_id`) REFERENCES `field` (`field_id`);

--
-- Constraints for table `timepacket`
--
ALTER TABLE `timepacket`
  ADD CONSTRAINT `timepacket_ibfk_1` FOREIGN KEY (`type`) REFERENCES `type` (`type`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
