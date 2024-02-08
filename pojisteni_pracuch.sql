-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Počítač: 127.0.0.1
-- Vytvořeno: Pon 22. led 2024, 03:13
-- Verze serveru: 10.4.28-MariaDB
-- Verze PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Databáze: `pojisteni_pracuch`
--

-- --------------------------------------------------------

--
-- Struktura tabulky `pojistenci`
--

CREATE TABLE `pojistenci` (
  `pojistenci_id` bigint(20) NOT NULL,
  `jmeno` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `telefon` varchar(20) DEFAULT NULL,
  `ulice` varchar(255) DEFAULT NULL,
  `cislopopisne` varchar(10) DEFAULT NULL,
  `mesto` varchar(255) DEFAULT NULL,
  `psc` varchar(10) DEFAULT NULL,
  `pohlavi` enum('MUŽ','ŽENA','JINÉ') DEFAULT NULL,
  `prijmeni` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Vypisuji data pro tabulku `pojistenci`
--

INSERT INTO `pojistenci` (`pojistenci_id`, `jmeno`, `email`, `telefon`, `ulice`, `cislopopisne`, `mesto`, `psc`, `pohlavi`, `prijmeni`) VALUES
(39, 'Charleeei', '55.45@gmail.com', '554554554', 'U dubu ', '55', 'Bratislava', '55', 'MUŽ', 'Novy'),
(40, 'David', 'david@email.com', '444444444', 'Trida 4', '404', 'Kosice', '24680', 'MUŽ', 'Petrov'),
(42, 'Frank', 'frank@email.com', '666666666', 'Ulice 6', '606', 'Ostrava', '86420', 'MUŽ', 'Svobodny'),
(45, 'Ivy', 'ivy@email.com', '999999999', 'Ulice 9', '909', 'Plzen', '53197', 'ŽENA', 'Svobodova'),
(46, 'John', 'john@email.com', '123123123', 'Trida 10', '1010', 'Ostrava', '42069', 'MUŽ', 'Novy'),
(47, 'Jan', 'jan@email.com', '123456789', 'Vodičkova 123', '123', 'Praha', '12345', 'MUŽ', 'Novák'),
(48, 'Eva', 'eva@email.com', '987654321', 'Karlovo náměstí 456', '456', 'Brno', '54321', 'ŽENA', 'Svobodová'),
(51, 'Jan', 'jan@email.com', '123456789', 'Hlavní', '10', 'Praha', '11000', 'MUŽ', 'Novák'),
(52, 'Eva', 'eva@email.com', '987654321', 'Náměstí', '5', 'Brno', '60200', 'ŽENA', 'Svobodová'),
(53, 'Petr', 'petr@email.com', '111222333', 'U Lesa', '7', 'Ostrava', '70800', 'MUŽ', 'Kučera'),
(54, 'Marie', 'marie@email.com', '444555666', 'Dlouhá', '25', 'Plzeň', '30100', 'ŽENA', 'Hájková'),
(55, 'Tomáš', 'tomas@email.com', '777888999', 'Krátká', '12', 'Liberec', '46001', 'MUŽ', 'Novotný'),
(56, 'Jana', 'jana@email.com', '555444333', 'Školní', '3', 'České Budějovice', '37005', 'ŽENA', 'Procházková'),
(57, 'Miroslav', 'miroslav@email.com', '222333444', 'Horská', '9', 'Hradec Králové', '50009', 'MUŽ', 'Bartoš'),
(58, 'Zuzana', 'zuzana@email.com', '666777888', 'Růžová', '14', 'Pardubice', '53002', 'ŽENA', 'Kovaříková'),
(59, 'Lukáš', 'lukas@email.com', '333222111', 'U Potoka', '6', 'Olomouc', '77900', 'MUŽ', 'Doležal'),
(60, 'Kateřina', 'katerina@email.com', '999888777', 'Náměstí', '18', 'Zlín', '76001', 'ŽENA', 'Malá'),
(61, 'Martin', 'martin@email.com', '123987456', 'Javorová', '8', 'Český Těšín', '73701', 'MUŽ', 'Veselý'),
(62, 'Veronika', 'veronika@email.com', '987123654', 'Kopanina', '16', 'Kladno', '27201', 'ŽENA', 'Krejčířová'),
(63, 'Michal', 'michal@email.com', '111222333', 'Zahradní', '21', 'Havířov', '73601', 'MUŽ', 'Šťastný'),
(64, 'Karolína', 'karolina@email.com', '555666777', 'U Lesa', '17', 'Karviná', '73301', 'ŽENA', 'Holubová'),
(65, 'Ondřej', 'ondrej@email.com', '777888999', 'Na vyhlídce', '3', 'Ústí nad Labem', '40001', 'MUŽ', 'Pavlík'),
(66, 'Natálie', 'natalie@email.com', '444555666', 'Mírová', '14', 'Znojmo', '66902', 'ŽENA', 'Machová'),
(67, 'David', 'david@email.com', '222333444', 'Křižovatka', '5', 'Teplice', '41501', 'MUŽ', 'Sýkora'),
(68, 'Adéla', 'adela@email.com', '666777888', 'Dlouhá', '20', 'Chomutov', '43001', 'ŽENA', 'Bartošová'),
(69, 'Jiří', 'jiri@email.com', '333222111', 'Pod hradem', '7', 'Kutná Hora', '28401', 'MUŽ', 'Kratochvíl'),
(70, 'Simona', 'simona@email.com', '999888777', 'Horní', '12', 'Jihlava', '58601', 'ŽENA', 'Kopecká'),
(75, 'Martin', 'martin.pracuch@gmail.com', '789865231', 'Starobělská', '47', 'Ostrava', '70200', 'MUŽ', 'Pracuch');

-- --------------------------------------------------------

--
-- Struktura tabulky `pojisteni`
--

CREATE TABLE `pojisteni` (
  `pojisteni_id` bigint(20) NOT NULL,
  `pojistenci_id` bigint(20) DEFAULT NULL,
  `castka` int(11) NOT NULL,
  `platnost_do` date DEFAULT NULL,
  `platnost_od` date DEFAULT NULL,
  `typ_pojisteni` enum('CESTOVNÍ_POJIŠTĚNÍ','NEMOCENSKÉ_POJIŠTĚNÍ','POJIŠTĚNÍ_MAJETKU','POJIŠTĚNÍ_ODPOVĚDNOSTI','POVINNÉ_RUČENÍ','PRO_PODNIKATELE_A_FIRMY','ŽIVOTNÍ_POJIŠTĚNÍ') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Vypisuji data pro tabulku `pojisteni`
--

INSERT INTO `pojisteni` (`pojisteni_id`, `pojistenci_id`, `castka`, `platnost_do`, `platnost_od`, `typ_pojisteni`) VALUES
(116, 39, 1, '2024-02-07', '2024-01-04', 'POJIŠTĚNÍ_ODPOVĚDNOSTI'),
(117, 40, 3000, '2024-10-31', '2024-01-01', 'ŽIVOTNÍ_POJIŠTĚNÍ'),
(118, 42, 2500, '2024-09-30', '2024-01-01', 'NEMOCENSKÉ_POJIŠTĚNÍ'),
(119, 45, 1800, '2024-12-31', '2024-01-01', 'POJIŠTĚNÍ_MAJETKU'),
(120, 46, 2200, '2024-11-30', '2024-01-01', 'POJIŠTĚNÍ_ODPOVĚDNOSTI'),
(121, 47, 2700, '2024-10-31', '2024-01-01', 'PRO_PODNIKATELE_A_FIRMY'),
(122, 48, 1900, '2024-09-30', '2024-01-01', 'CESTOVNÍ_POJIŠTĚNÍ'),
(123, 51, 2000, '2024-12-31', '2024-01-01', 'ŽIVOTNÍ_POJIŠTĚNÍ'),
(124, 52, 2500, '2024-11-30', '2024-01-01', 'POVINNÉ_RUČENÍ'),
(126, 54, 2200, '2024-09-30', '2024-01-01', 'POJIŠTĚNÍ_ODPOVĚDNOSTI'),
(127, 55, 2700, '2024-08-31', '2024-01-01', 'PRO_PODNIKATELE_A_FIRMY'),
(128, 56, 1900, '2024-07-31', '2024-01-01', 'CESTOVNÍ_POJIŠTĚNÍ'),
(129, 57, 2100, '2024-06-30', '2024-01-01', 'NEMOCENSKÉ_POJIŠTĚNÍ'),
(130, 58, 2300, '2024-05-31', '2024-01-01', 'POVINNÉ_RUČENÍ'),
(131, 59, 2600, '2024-04-30', '2024-01-01', 'POJIŠTĚNÍ_MAJETKU'),
(132, 60, 2400, '2024-03-31', '2024-01-01', 'ŽIVOTNÍ_POJIŠTĚNÍ'),
(133, 61, 2000, '2024-02-29', '2024-01-01', 'CESTOVNÍ_POJIŠTĚNÍ'),
(134, 62, 3000, '2024-01-31', '2024-01-01', 'PRO_PODNIKATELE_A_FIRMY'),
(135, 63, 1900, '2023-12-31', '2023-01-01', 'NEMOCENSKÉ_POJIŠTĚNÍ'),
(136, 64, 2200, '2023-11-30', '2023-01-01', 'POVINNÉ_RUČENÍ'),
(137, 65, 2500, '2023-10-31', '2023-01-01', 'POJIŠTĚNÍ_ODPOVĚDNOSTI'),
(138, 66, 2700, '2023-09-30', '2023-01-01', 'ŽIVOTNÍ_POJIŠTĚNÍ'),
(139, 67, 1800, '2023-08-31', '2023-01-01', 'CESTOVNÍ_POJIŠTĚNÍ'),
(141, 39, 13, '2024-02-01', '2024-01-13', 'NEMOCENSKÉ_POJIŠTĚNÍ'),
(142, 39, 1, '2024-02-07', '2024-01-12', 'POJIŠTĚNÍ_MAJETKU'),
(143, 39, 0, '2024-01-27', '2024-01-17', 'CESTOVNÍ_POJIŠTĚNÍ'),
(144, 39, 0, '2024-02-07', '2024-01-11', 'POVINNÉ_RUČENÍ');

-- --------------------------------------------------------

--
-- Struktura tabulky `pojistna_udalost`
--

CREATE TABLE `pojistna_udalost` (
  `udalost_id` bigint(20) NOT NULL,
  `pojistenci_id` bigint(20) DEFAULT NULL,
  `pojisteni_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktura tabulky `roles`
--

CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Vypisuji data pro tabulku `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Struktura tabulky `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Vypisuji data pro tabulku `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`) VALUES
(1, 'Martin Pracuch', 'martin.pracuch@gmail.com', '$2a$10$8lBgDPT1.FsAKxu8LophFu8K/1xbFPBIEGHtmwa.vigQTnMB/aYMG'),
(2, 'Petr Adámek', 'petr.adamek@gmail.com', '$2a$10$Wzm.DF.rQZ4PV6z95.NC/.jcILpSOE4jRtGfVPEH4gmrE4hH3SheK'),
(3, 'Pavel Žlutý', 'pavel.zluty@seznam.cz', '$2a$10$AyTYNeeg5isvaKGmfQ9SLuLe72vWZBmM.eVsm5Ysccx5xXALFRX3O'),
(4, 'Martin Pažák', 'martin.pazak@gmail.com', '$2a$10$jg5lUqCwDeTEiC7aAn2YK.44RTz1Wb.UUvRnlqbNdMOS..tnTj36C'),
(5, 'David Masiar', 'david.masiar@gmail.com', '$2a$10$g/H2e9RF/PW9.DeER38kaOWKrfMW.eadDA0TXCF.Xhn9OWyNv/mmK');

-- --------------------------------------------------------

--
-- Struktura tabulky `users_roles`
--

CREATE TABLE `users_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Vypisuji data pro tabulku `users_roles`
--

INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 2),
(5, 1);

--
-- Indexy pro exportované tabulky
--

--
-- Indexy pro tabulku `pojistenci`
--
ALTER TABLE `pojistenci`
  ADD PRIMARY KEY (`pojistenci_id`);

--
-- Indexy pro tabulku `pojisteni`
--
ALTER TABLE `pojisteni`
  ADD PRIMARY KEY (`pojisteni_id`),
  ADD KEY `FK9rfhkkosqemyinqr9bwv34atr` (`pojistenci_id`);

--
-- Indexy pro tabulku `pojistna_udalost`
--
ALTER TABLE `pojistna_udalost`
  ADD PRIMARY KEY (`udalost_id`),
  ADD KEY `FKtm6wf848qkqs5u5fpg83aowco` (`pojistenci_id`),
  ADD KEY `FK66blkwxvt8tjecucry1q9wr55` (`pojisteni_id`);

--
-- Indexy pro tabulku `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexy pro tabulku `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexy pro tabulku `users_roles`
--
ALTER TABLE `users_roles`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `role_id` (`role_id`);

--
-- AUTO_INCREMENT pro tabulky
--

--
-- AUTO_INCREMENT pro tabulku `pojistenci`
--
ALTER TABLE `pojistenci`
  MODIFY `pojistenci_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=76;

--
-- AUTO_INCREMENT pro tabulku `pojisteni`
--
ALTER TABLE `pojisteni`
  MODIFY `pojisteni_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=146;

--
-- AUTO_INCREMENT pro tabulku `pojistna_udalost`
--
ALTER TABLE `pojistna_udalost`
  MODIFY `udalost_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pro tabulku `roles`
--
ALTER TABLE `roles`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pro tabulku `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Omezení pro exportované tabulky
--

--
-- Omezení pro tabulku `pojisteni`
--
ALTER TABLE `pojisteni`
  ADD CONSTRAINT `FK9rfhkkosqemyinqr9bwv34atr` FOREIGN KEY (`pojistenci_id`) REFERENCES `pojistenci` (`pojistenci_id`);

--
-- Omezení pro tabulku `pojistna_udalost`
--
ALTER TABLE `pojistna_udalost`
  ADD CONSTRAINT `FK66blkwxvt8tjecucry1q9wr55` FOREIGN KEY (`pojisteni_id`) REFERENCES `pojisteni` (`pojisteni_id`),
  ADD CONSTRAINT `FKtm6wf848qkqs5u5fpg83aowco` FOREIGN KEY (`pojistenci_id`) REFERENCES `pojistenci` (`pojistenci_id`);

--
-- Omezení pro tabulku `users_roles`
--
ALTER TABLE `users_roles`
  ADD CONSTRAINT `users_roles_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `users_roles_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
