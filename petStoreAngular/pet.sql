-- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--
-- Host: localhost:8889
-- Generation Time: Jan 23, 2017 at 11:52 PM
-- Server version: 5.5.42
-- PHP Version: 7.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `springdemo`
--

-- --------------------------------------------------------

--
-- Table structure for table `pet`
--

CREATE TABLE `pet` (
  `pet_id` int(11) NOT NULL,
  `name` varchar(127) COLLATE utf8_bin NOT NULL,
  `type` varchar(127) COLLATE utf8_bin NOT NULL,
  `status` varchar(127) COLLATE utf8_bin NOT NULL,
  `image` varchar(255) COLLATE utf8_bin NOT NULL,
  `category` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `pet`
--

INSERT INTO `pet` (`pet_id`, `name`, `type`, `status`, `image`, `category`) VALUES
(10, 'Rebel', 'dog', 'available', 'https://media.petango.com/sms/photos/1686/98d755b0-05e3-4ccb-a3ac-264d485afc31.jpg', 'Retriever'),
(21, 'Traveller', 'dog', 'available', 'https://media.petango.com/sms/photos/1686/c9adcfbb-910a-46fe-a936-25d8abce2733.jpg', 'Argentine Dogo'),
(23, 'Janelle', 'dog', 'available', 'https://media.petango.com/sms/photos/1686/8626a9a8-2fe0-424e-b0a2-3eec278c3ae7.jpg', 'Bulldog'),
(24, 'Gigi', 'cat', 'available', 'https://media.petango.com/sms/photos/1686/fed48f6b-497e-4839-83df-fcf13ec5279d.jpg', 'Domestic Shorthair'),
(25, 'Corin', 'cat', 'Pending', 'https://media.petango.com/sms/photos/1686/a2514220-e0f3-4fdf-881b-11a2894860a5.jpg', ' Domestic Shorthair');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pet`
--
ALTER TABLE `pet`
  ADD PRIMARY KEY (`pet_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pet`
--
ALTER TABLE `pet`
  MODIFY `pet_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=26;