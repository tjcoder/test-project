-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.6.17 - MySQL Community Server (GPL)
-- ОС Сервера:                   Win64
-- HeidiSQL Версия:              9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Дамп структуры базы данных test
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `test`;


-- Дамп структуры для таблица test.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `age` int(10) unsigned NOT NULL DEFAULT '0',
  `isAdmin` bit(1) NOT NULL DEFAULT b'0',
  `createdDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- Дамп данных таблицы test.user: ~10 rows (приблизительно)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT IGNORE INTO `user` (`id`, `name`, `age`, `isAdmin`, `createdDate`) VALUES
	(1, 'Taalaybek', 27, b'1', '2016-01-29 22:58:53'),
	(2, 'Ruslan', 27, b'0', '2016-01-29 22:56:11'),
	(4, 'John', 23, b'0', '2016-01-29 23:08:14'),
	(5, 'Maria', 32, b'0', '2016-01-29 23:08:25'),
	(6, 'Andrew', 43, b'0', '2016-01-29 23:08:39'),
	(7, 'Sergey', 18, b'0', '2016-01-29 23:08:47'),
	(8, 'Alex', 65, b'0', '2016-01-29 23:09:02'),
	(9, 'Lev Tolstoy', 100, b'0', '2016-01-29 23:09:19'),
	(10, 'Test test', 34, b'0', '2016-01-29 23:09:29'),
	(11, 'Last Name', 34, b'0', '2016-01-29 23:09:41'),
	(12, 'Test Name', 34, b'0', '2016-01-31 01:34:59');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
