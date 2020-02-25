-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 10, 2018 at 02:24 AM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `librarydatabases`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `book_id` int(12) NOT NULL,
  `title` varchar(60) NOT NULL,
  `author` varchar(25) NOT NULL,
  `theme` varchar(25) NOT NULL,
  `page` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`book_id`, `title`, `author`, `theme`, `page`) VALUES
(1, 'cracking', 'gayle laakmann', 'security', 532),
(2, 'algorithms to live', 'brian christian', 'computer science', 242),
(4, 'the java language', 'gilad bracha', 'programming', 200),
(5, 'java in a box', 'bruce eckel', 'programming', 222),
(6, 'java script pocket', 'david flanagan', 'programming', 125),
(7, 'computer networks', 'andrew', 'netwok', 125),
(8, 'ccna official exam', 'wendell odom', 'network', 100),
(10, 'The Wall Street journal ', 'walt mossberg', 'networks mathematics', 300),
(11, 'linux securitu', 'barrett', 'security', 175),
(12, 'pricipe quantum mechanics', 'paul derack', 'physics', 220),
(14, 'stephen hawking', 'stephen hawking', 'phisics', 333);

-- --------------------------------------------------------

--
-- Table structure for table `borrowed_book`
--

CREATE TABLE `borrowed_book` (
  `num` int(2) NOT NULL,
  `student_id` varchar(25) NOT NULL,
  `book_id` varchar(25) NOT NULL,
  `date_of_borrow` date DEFAULT NULL,
  `date_back` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `borrowed_book`
--

INSERT INTO `borrowed_book` (`num`, `student_id`, `book_id`, `date_of_borrow`, `date_back`) VALUES
(185, '16/00/01', '4', '2018-05-10', '2018-07-10'),
(186, '16/00/12', '10', '2018-05-10', '2018-07-10');

-- --------------------------------------------------------

--
-- Table structure for table `examplaire`
--

CREATE TABLE `examplaire` (
  `id` varchar(6) NOT NULL,
  `title` varchar(60) NOT NULL,
  `author` varchar(25) NOT NULL,
  `theme` varchar(25) NOT NULL,
  `page` int(11) NOT NULL,
  `qte` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `examplaire`
--

INSERT INTO `examplaire` (`id`, `title`, `author`, `theme`, `page`, `qte`) VALUES
('1', 'cracking', 'gayle laakmann', 'security', 532, 5),
('10', 'The Wall Street journal ', 'walt mossberg', 'networks mathematics', 300, 4),
('11', 'linux securitu', 'barrett', 'security', 175, 5),
('12', 'pricipe quantum mechanics', 'paul derack', 'physics', 220, 5),
('14', 'stephen hawking', 'stephen hawking', 'phisics', 333, 5),
('2', 'algorithms to live', 'brian christian', 'computer science', 242, 5),
('4', 'the java language', 'gilad bracha', 'programming', 200, 4),
('5', 'java in a box', 'bruce eckel', 'programming', 222, 5),
('6', 'java script pocket', 'david flanagan', 'programming', 125, 5),
('7', 'computer networks', 'andrew', 'netwok', 125, 5),
('8', 'ccna official exam', 'wendell odom', 'network', 100, 5);

-- --------------------------------------------------------

--
-- Table structure for table `librian`
--

CREATE TABLE `librian` (
  `UserId` varchar(20) NOT NULL,
  `PassWord` varchar(20) NOT NULL,
  `FirstName` varchar(25) NOT NULL,
  `LastName` varchar(25) NOT NULL,
  `PhoneNumber` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `librian`
--

INSERT INTO `librian` (`UserId`, `PassWord`, `FirstName`, `LastName`, `PhoneNumber`) VALUES
('zaki11', '1111', 'abouch', 'zakaria', 775682817);

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `num_res` int(11) NOT NULL,
  `student_id` varchar(10) NOT NULL,
  `book_id` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `StudentId` varchar(10) NOT NULL,
  `FirstName` varchar(25) NOT NULL,
  `LastName` varchar(25) NOT NULL,
  `Branch` varchar(20) NOT NULL,
  `Year` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`StudentId`, `FirstName`, `LastName`, `Branch`, `Year`) VALUES
('16/00/01', 'Zakaria', 'Abouchi', 'Informatique', 3),
('16/00/02', 'Nassim', 'Arab', 'Informatique', 3),
('16/00/02/3', 'Ramzi', 'Bouhadouza', 'Informatique', 3),
('16/00/04', 'Fateh', 'Boujlida', 'Informatique', 3),
('16/00/05', 'Sofian', 'Abouchi', 'Math Informatique', 1),
('16/00/06', 'Karim', 'Manaouil', 'Math Informatique', 2),
('16/00/07', 'Ishak', 'Zouaoui', 'Math Informatique', 1),
('16/00/08', 'Anis', 'Haroun', 'Math', 4),
('16/00/09', 'Taki', 'Derbal', 'Math', 4),
('16/00/10', 'Younes', 'Derbal', 'Phisique', 2),
('16/00/11', 'Mohamed', 'Bounab', 'Phisique', 2),
('16/00/12', 'Ilyes', 'Boulahouat', 'Informatique', 3);

-- --------------------------------------------------------

--
-- Table structure for table `student_login`
--

CREATE TABLE `student_login` (
  `student_id` varchar(30) NOT NULL,
  `pass_word` varchar(20) NOT NULL,
  `security_question` varchar(50) NOT NULL,
  `answer` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_login`
--

INSERT INTO `student_login` (`student_id`, `pass_word`, `security_question`, `answer`) VALUES
('16/00/01', '1111', 'your best freind', 'karim'),
('16/00/05', '0000', 'your nick name ?', 'toli'),
('16/00/12', '3333', 'your prefered car', 'super5');

-- --------------------------------------------------------

--
-- Table structure for table `super_admin`
--

CREATE TABLE `super_admin` (
  `UserName` varchar(25) NOT NULL,
  `PassWord` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `super_admin`
--

INSERT INTO `super_admin` (`UserName`, `PassWord`) VALUES
('zakaria', '1111');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`book_id`);

--
-- Indexes for table `borrowed_book`
--
ALTER TABLE `borrowed_book`
  ADD PRIMARY KEY (`num`);

--
-- Indexes for table `examplaire`
--
ALTER TABLE `examplaire`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `librian`
--
ALTER TABLE `librian`
  ADD PRIMARY KEY (`UserId`);

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`num_res`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`StudentId`);

--
-- Indexes for table `student_login`
--
ALTER TABLE `student_login`
  ADD PRIMARY KEY (`student_id`);

--
-- Indexes for table `super_admin`
--
ALTER TABLE `super_admin`
  ADD PRIMARY KEY (`UserName`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `borrowed_book`
--
ALTER TABLE `borrowed_book`
  MODIFY `num` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=187;
--
-- AUTO_INCREMENT for table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `num_res` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
