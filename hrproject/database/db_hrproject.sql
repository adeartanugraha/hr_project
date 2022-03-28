-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 16, 2022 at 06:21 AM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 7.4.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_hrproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_absent`
--

CREATE TABLE `data_absent` (
  `id_absent` bigint(20) NOT NULL,
  `id_user` bigint(20) NOT NULL,
  `id_schedule` bigint(20) NOT NULL,
  `id_token` bigint(20) NOT NULL,
  `used_at` datetime NOT NULL,
  `status` tinyint(4) NOT NULL COMMENT '0 = "in" & 1 = "out"',
  `is_late` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `data_absent`
--

INSERT INTO `data_absent` (`id_absent`, `id_user`, `id_schedule`, `id_token`, `used_at`, `status`, `is_late`) VALUES
(846068708837130, 846067400050653, 846067746053320, 846068622041482, '2022-02-02 13:11:45', 1, 0),
(846068722417206, 846067425911716, 846067746053320, 846068622041482, '2022-02-02 16:58:05', 0, 1),
(846068722440807, 846067425911716, 846067746053320, 846068622041482, '2022-02-02 16:58:28', 0, 0),
(846068722471227, 846067425911716, 846067746053320, 846068622041482, '2022-02-02 16:58:59', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `data_industry`
--

CREATE TABLE `data_industry` (
  `id_industry` bigint(20) NOT NULL,
  `name_industry` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `data_industry`
--

INSERT INTO `data_industry` (`id_industry`, `name_industry`) VALUES
(846067421570739, 'industry'),
(846067421577212, 'industry'),
(846067428074067, 'in');

-- --------------------------------------------------------

--
-- Table structure for table `data_schedule`
--

CREATE TABLE `data_schedule` (
  `id_schedule` bigint(20) NOT NULL,
  `id_industry` bigint(20) NOT NULL,
  `day` tinyint(4) NOT NULL,
  `time_in` time NOT NULL,
  `time_out` time NOT NULL,
  `isoff` tinyint(4) NOT NULL COMMENT '0 = YES and 1 = NO'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `data_schedule`
--

INSERT INTO `data_schedule` (`id_schedule`, `id_industry`, `day`, `time_in`, `time_out`, `isoff`) VALUES
(846067746053320, 846067421570739, 3, '08:50:44', '15:00:44', 1),
(846068528373994, 846067421570739, 0, '08:45:44', '19:15:44', 0),
(846068530847571, 846067421570739, 0, '08:45:44', '19:15:44', 0),
(846068530864612, 846067421570739, 0, '08:45:44', '19:15:44', 0),
(846068530917807, 846067421570739, 0, '08:45:44', '19:15:44', 0),
(846068530958206, 846067421570739, 0, '08:45:44', '19:15:44', 0),
(846068531138640, 846067421570739, 0, '08:45:44', '19:15:44', 0),
(846068531143886, 846067421570739, 0, '08:45:44', '19:15:44', 1),
(846068702567919, 846067421570739, 2, '08:45:44', '19:15:44', 1),
(846068702738726, 846067421570739, -1, '08:45:44', '19:15:44', 1);

-- --------------------------------------------------------

--
-- Table structure for table `data_token`
--

CREATE TABLE `data_token` (
  `token_code` bigint(20) NOT NULL,
  `is_active` tinyint(4) NOT NULL,
  `created_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `data_token`
--

INSERT INTO `data_token` (`token_code`, `is_active`, `created_at`) VALUES
(846068550168830, 0, NULL),
(846068550177056, 0, NULL),
(846068551353617, -1, NULL),
(846068551358806, 1, NULL),
(846068551363759, 0, NULL),
(846068622041482, 0, '2022-02-01 13:05:09');

-- --------------------------------------------------------

--
-- Table structure for table `data_user`
--

CREATE TABLE `data_user` (
  `id_user` bigint(20) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `data_user`
--

INSERT INTO `data_user` (`id_user`, `username`, `password`) VALUES
(846067400050653, 'bagusmade', 'adesaga07'),
(846067425911716, 'made', 'test1234'),
(846069905397394, 'megel', '12345678');

-- --------------------------------------------------------

--
-- Table structure for table `main_schedule`
--

CREATE TABLE `main_schedule` (
  `id_mainschedule` bigint(20) NOT NULL,
  `id_schedule` bigint(20) NOT NULL,
  `id_industry` bigint(20) NOT NULL,
  `id_user` bigint(20) NOT NULL,
  `status` tinyint(4) NOT NULL COMMENT '0 = wfo and 1 = wfh'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `main_schedule`
--

INSERT INTO `main_schedule` (`id_mainschedule`, `id_schedule`, `id_industry`, `id_user`, `status`) VALUES
(846067746265492, 846067746053320, 846067421570739, 846067425911716, 1),
(846068712979466, 846067746053320, 846067421570739, 846067400050653, 1),
(846069904524114, 846067746053320, 846067421570739, 846067425911716, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data_absent`
--
ALTER TABLE `data_absent`
  ADD PRIMARY KEY (`id_absent`),
  ADD KEY `idx_id_user` (`id_user`),
  ADD KEY `idx_id_schedule` (`id_schedule`) USING BTREE,
  ADD KEY `idx_id_token` (`id_token`);

--
-- Indexes for table `data_industry`
--
ALTER TABLE `data_industry`
  ADD PRIMARY KEY (`id_industry`);

--
-- Indexes for table `data_schedule`
--
ALTER TABLE `data_schedule`
  ADD PRIMARY KEY (`id_schedule`),
  ADD KEY `idx_id_industry` (`id_industry`);

--
-- Indexes for table `data_token`
--
ALTER TABLE `data_token`
  ADD PRIMARY KEY (`token_code`);

--
-- Indexes for table `data_user`
--
ALTER TABLE `data_user`
  ADD PRIMARY KEY (`id_user`);

--
-- Indexes for table `main_schedule`
--
ALTER TABLE `main_schedule`
  ADD PRIMARY KEY (`id_mainschedule`),
  ADD KEY `idx_id_schedule` (`id_schedule`),
  ADD KEY `idx_id_industry` (`id_industry`),
  ADD KEY `idx_id_user` (`id_user`) USING BTREE;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `data_absent`
--
ALTER TABLE `data_absent`
  ADD CONSTRAINT `data_absent_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `data_user` (`id_user`),
  ADD CONSTRAINT `data_absent_ibfk_2` FOREIGN KEY (`id_schedule`) REFERENCES `data_schedule` (`id_schedule`),
  ADD CONSTRAINT `data_absent_ibfk_3` FOREIGN KEY (`id_token`) REFERENCES `data_token` (`token_code`);

--
-- Constraints for table `data_schedule`
--
ALTER TABLE `data_schedule`
  ADD CONSTRAINT `data_schedule_ibfk_1` FOREIGN KEY (`id_industry`) REFERENCES `data_industry` (`id_industry`);

--
-- Constraints for table `main_schedule`
--
ALTER TABLE `main_schedule`
  ADD CONSTRAINT `main_schedule_ibfk_1` FOREIGN KEY (`id_schedule`) REFERENCES `data_schedule` (`id_schedule`),
  ADD CONSTRAINT `main_schedule_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `data_user` (`id_user`),
  ADD CONSTRAINT `main_schedule_ibfk_3` FOREIGN KEY (`id_industry`) REFERENCES `data_industry` (`id_industry`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
