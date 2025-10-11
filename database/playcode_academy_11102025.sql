-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 11 Okt 2025 pada 14.22
-- Versi server: 10.4.28-MariaDB
-- Versi PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `playcode_academy`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `classes`
--

CREATE TABLE `classes` (
  `id` int(11) NOT NULL,
  `courses_id` int(11) NOT NULL,
  `class_name` varchar(255) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `capacity` int(11) NOT NULL,
  `coach_id` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `classes`
--

INSERT INTO `classes` (`id`, `courses_id`, `class_name`, `start_date`, `end_date`, `capacity`, `coach_id`, `created_at`) VALUES
(1, 1, 'Creator', '2025-04-04', '2025-04-19', 20, 1, '2025-04-04 06:05:27'),
(3, 1, 'Innovator', '2025-04-01', '2025-04-30', 40, 1, '2025-04-04 06:08:34');

-- --------------------------------------------------------

--
-- Struktur dari tabel `class_registrations`
--

CREATE TABLE `class_registrations` (
  `id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `registered_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `class_registrations`
--

INSERT INTO `class_registrations` (`id`, `class_id`, `student_id`, `registered_date`, `created_at`) VALUES
(1, 1, 26, '2025-04-22 04:57:49', '2025-04-22 04:57:49'),
(2, 1, 27, '2025-04-22 04:58:00', '2025-04-22 04:58:00'),
(3, 1, 28, '2025-04-22 04:58:13', '2025-04-22 04:58:13'),
(4, 3, 106, '2025-04-22 04:58:23', '2025-04-22 04:58:23'),
(5, 3, 55, '2025-04-22 04:58:35', '2025-04-22 04:58:35'),
(6, 3, 51, '2025-04-22 04:58:46', '2025-04-22 04:58:46'),
(7, 3, 49, '2025-04-22 04:59:40', '2025-04-22 04:59:40'),
(8, 1, 44, '2025-10-10 12:41:15', '2025-10-10 12:41:15');

-- --------------------------------------------------------

--
-- Struktur dari tabel `class_schedules`
--

CREATE TABLE `class_schedules` (
  `id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  `day_of_week` enum('Senin','Selasa','Rabu','Kamis','Jumat','Sabtu','Minggu') NOT NULL,
  `start_time` time NOT NULL,
  `end_time` time NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `class_schedules`
--

INSERT INTO `class_schedules` (`id`, `class_id`, `day_of_week`, `start_time`, `end_time`, `created_at`) VALUES
(1, 1, 'Senin', '08:00:00', '12:00:00', '2025-04-05 01:04:17'),
(3, 3, 'Sabtu', '08:00:00', '10:00:00', '2025-10-10 12:39:53');

-- --------------------------------------------------------

--
-- Struktur dari tabel `courses`
--

CREATE TABLE `courses` (
  `id` int(11) NOT NULL,
  `courses_name` varchar(100) NOT NULL,
  `description` text DEFAULT NULL,
  `duration` int(11) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `courses`
--

INSERT INTO `courses` (`id`, `courses_name`, `description`, `duration`, `price`, `created_at`) VALUES
(1, 'Game 2D', 'Membuat game 2 dimensi', 2, 1000000.00, '2025-04-02 10:00:52');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tablename`
--

CREATE TABLE `tablename` (
  `username` varchar(512) DEFAULT NULL,
  `password` varchar(512) DEFAULT NULL,
  `nama` varchar(512) DEFAULT NULL,
  `email` varchar(512) DEFAULT NULL,
  `no_hp` int(11) DEFAULT NULL,
  `alamat` varchar(512) DEFAULT NULL,
  `tgl_lahir` varchar(512) DEFAULT NULL,
  `jenis_kelamin` varchar(512) DEFAULT NULL,
  `level` varchar(512) DEFAULT NULL,
  `status` varchar(512) DEFAULT NULL,
  `created_at` varchar(512) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tablename`
--

INSERT INTO `tablename` (`username`, `password`, `nama`, `email`, `no_hp`, `alamat`, `tgl_lahir`, `jenis_kelamin`, `level`, `status`, `created_at`) VALUES
('bambang', 'e10adc3949ba59abbe56e057f20f883e', 'Bambang Sutrisno', 'bambang.sutrisno@gmail.com', 2147483647, 'Jl. Merdeka No. 10, Jakarta', '1985-05-15', 'Laki-laki', 'pengajar', '1', '2025-04-21 11:30:00'),
('siti', 'e10adc3949ba59abbe56e057f20f883e', 'Siti Nurhaliza', 'siti.nurhaliza@gmail.com', 2147483647, 'Jl. Pahlawan No. 5, Bandung', '1990-07-22', 'Perempuan', 'pengajar', '1', '2025-04-21 11:30:00'),
('agus', 'e10adc3949ba59abbe56e057f20f883e', 'Agus Hermawan', 'agus.hermawan@gmail.com', 2147483647, 'Jl. Diponegoro No. 15, Surabaya', '1982-03-10', 'Laki-laki', 'pengajar', '1', '2025-04-21 11:30:00'),
('dewi', 'e10adc3949ba59abbe56e057f20f883e', 'Dewi Sartika', 'dewi.sartika@gmail.com', 2147483647, 'Jl. Gatot Subroto No. 7, Yogyakarta', '1988-11-05', 'Perempuan', 'pengajar', '1', '2025-04-21 11:30:00'),
('budi', 'e10adc3949ba59abbe56e057f20f883e', 'Budi Santoso', 'budi.santoso@gmail.com', 2147483647, 'Jl. Ahmad Yani No. 20, Semarang', '1984-09-18', 'Laki-laki', 'pengajar', '1', '2025-04-21 11:30:00'),
('rina', 'e10adc3949ba59abbe56e057f20f883e', 'Rina Wulandari', 'rina.wulandari@gmail.com', 2147483647, 'Jl. Sudirman No. 25, Malang', '1992-02-14', 'Perempuan', 'pengajar', '1', '2025-04-21 11:30:00'),
('hadi', 'e10adc3949ba59abbe56e057f20f883e', 'Hadi Prasetyo', 'hadi.prasetyo@gmail.com', 2147483647, 'Jl. Veteran No. 12, Surakarta', '1981-12-30', 'Laki-laki', 'pengajar', '1', '2025-04-21 11:30:00'),
('anita', 'e10adc3949ba59abbe56e057f20f883e', 'Anita Wijaya', 'anita.wijaya@gmail.com', 2147483647, 'Jl. Pemuda No. 8, Denpasar', '1989-06-25', 'Perempuan', 'pengajar', '1', '2025-04-21 11:30:00'),
('dodi', 'e10adc3949ba59abbe56e057f20f883e', 'Dodi Setiawan', 'dodi.setiawan@gmail.com', 2147483647, 'Jl. Imam Bonjol No. 30, Makassar', '1983-08-12', 'Laki-laki', 'pengajar', '1', '2025-04-21 11:30:00'),
('lina', 'e10adc3949ba59abbe56e057f20f883e', 'Lina Marpaung', 'lina.marpaung@gmail.com', 2147483647, 'Jl. Kartini No. 9, Medan', '1991-04-20', 'Perempuan', 'pengajar', '1', '2025-04-21 11:30:00'),
('joko', 'e10adc3949ba59abbe56e057f20f883e', 'Joko Widodo', 'joko.widodo@gmail.com', 2147483647, 'Jl. Gajah Mada No. 11, Solo', '1980-10-05', 'Laki-laki', 'pengajar', '1', '2025-04-21 11:30:00'),
('siska', 'e10adc3949ba59abbe56e057f20f883e', 'Siska Purnama', 'siska.purnama@gmail.com', 2147483647, 'Jl. Hayam Wuruk No. 14, Bandung', '1993-01-15', 'Perempuan', 'pengajar', '1', '2025-04-21 11:30:00'),
('rudi', 'e10adc3949ba59abbe56e057f20f883e', 'Rudi Hartono', 'rudi.hartono@gmail.com', 2147483647, 'Jl. Thamrin No. 22, Jakarta', '1985-07-28', 'Laki-laki', 'pengajar', '1', '2025-04-21 11:30:00'),
('nina', 'e10adc3949ba59abbe56e057f20f883e', 'Nina Handayani', 'nina.handayani@gmail.com', 2147483647, 'Jl. Juanda No. 17, Surabaya', '1990-09-30', 'Perempuan', 'pengajar', '1', '2025-04-21 11:30:00'),
('arief', 'e10adc3949ba59abbe56e057f20f883e', 'Arief Budiman', 'arief.budiman@gmail.com', 2147483647, 'Jl. Asia Afrika No. 19, Bandung', '1982-05-22', 'Laki-laki', 'pengajar', '1', '2025-04-21 11:30:00'),
('dian', 'e10adc3949ba59abbe56e057f20f883e', 'Dian Sastro', 'dian.sastro@gmail.com', 2147483647, 'Jl. Wahid Hasyim No. 6, Jakarta', '1988-03-17', 'Perempuan', 'pengajar', '1', '2025-04-21 11:30:00'),
('andi', 'e10adc3949ba59abbe56e057f20f883e', 'Andi Firmansyah', 'andi.firmansyah@gmail.com', 2147483647, 'Jl. Pangeran Diponegoro No. 13, Yogyakarta', '1984-11-11', 'Laki-laki', 'pengajar', '1', '2025-04-21 11:30:00'),
('maya', 'e10adc3949ba59abbe56e057f20f883e', 'Maya Septianti', 'maya.septianti@gmail.com', 2147483647, 'Jl. Padjajaran No. 16, Bogor', '1992-08-03', 'Perempuan', 'pengajar', '1', '2025-04-21 11:30:00'),
('deni', 'e10adc3949ba59abbe56e057f20f883e', 'Deni Mahendra', 'deni.mahendra@gmail.com', 2147483647, 'Jl. Raya Bogor No. 21, Depok', '1981-02-09', 'Laki-laki', 'pengajar', '1', '2025-04-21 11:30:00'),
('putri', 'e10adc3949ba59abbe56e057f20f883e', 'Putri Handayani', 'putri.handayani@gmail.com', 2147483647, 'Jl. Cendrawasih No. 4, Makassar', '1989-10-14', 'Perempuan', 'pengajar', '1', '2025-04-21 11:30:00'),
('tirta', 'e10adc3949ba59abbe56e057f20f883e', 'Tirta Wijaya', 'tirta.wijaya@gmail.com', 2147483647, 'Jl. Mangga Dua No. 31, Jakarta', '1995-03-22', 'Laki-laki', 'siswa', '1', '2025-04-21 11:30:00'),
('indah', 'e10adc3949ba59abbe56e057f20f883e', 'Indah Permata', 'indah.permata@gmail.com', 2147483647, 'Jl. Cikutra No. 27, Bandung', '1996-07-12', 'Perempuan', 'siswa', '1', '2025-04-21 11:30:00'),
('dika', 'e10adc3949ba59abbe56e057f20f883e', 'Dika Pratama', 'dika.pratama@gmail.com', 2147483647, 'Jl. Darmo No. 18, Surabaya', '1994-11-25', 'Laki-laki', 'siswa', '1', '2025-04-21 11:30:00'),
('ratna', 'e10adc3949ba59abbe56e057f20f883e', 'Ratna Dewi', 'ratna.dewi@gmail.com', 2147483647, 'Jl. Cikini No. 33, Jakarta', '1997-01-05', 'Perempuan', 'siswa', '1', '2025-04-21 11:30:00'),
('galih', 'e10adc3949ba59abbe56e057f20f883e', 'Galih Ramadhan', 'galih.ramadhan@gmail.com', 2147483647, 'Jl. Setiabudhi No. 23, Bandung', '1995-05-20', 'Laki-laki', 'siswa', '1', '2025-04-21 11:30:00'),
('kirana', 'e10adc3949ba59abbe56e057f20f883e', 'Kirana Sari', 'kirana.sari@gmail.com', 2147483647, 'Jl. Kaliurang No. 29, Yogyakarta', '1996-09-15', 'Perempuan', 'siswa', '1', '2025-04-21 11:30:00'),
('ilham', 'e10adc3949ba59abbe56e057f20f883e', 'Ilham Nugroho', 'ilham.nugroho@gmail.com', 2147483647, 'Jl. Basuki Rahmat No. 24, Surabaya', '1994-12-30', 'Laki-laki', 'siswa', '1', '2025-04-21 11:30:00'),
('laras', 'e10adc3949ba59abbe56e057f20f883e', 'Laras Sekar', 'laras.sekar@gmail.com', 2147483647, 'Jl. Gatot Subroto No. 35, Jakarta', '1997-04-10', 'Perempuan', 'siswa', '1', '2025-04-21 11:30:00'),
('aditya', 'e10adc3949ba59abbe56e057f20f883e', 'Aditya Firmansyah', 'aditya.firmansyah@gmail.com', 2147483647, 'Jl. Dago No. 26, Bandung', '1995-08-07', 'Laki-laki', 'siswa', '1', '2025-04-21 11:30:00'),
('intan', 'e10adc3949ba59abbe56e057f20f883e', 'Intan Permata', 'intan.permata@gmail.com', 2147483647, 'Jl. Malioboro No. 32, Yogyakarta', '1996-11-18', 'Perempuan', 'siswa', '1', '2025-04-21 11:30:00'),
('bayu', 'e10adc3949ba59abbe56e057f20f883e', 'Bayu Pratama', 'bayu.pratama@gmail.com', 2147483647, 'Jl. Pahlawan No. 28, Semarang', '1994-02-14', 'Laki-laki', 'siswa', '1', '2025-04-21 11:30:00'),
('nadia', 'e10adc3949ba59abbe56e057f20f883e', 'Nadia Safitri', 'nadia.safitri@gmail.com', 2147483647, 'Jl. Sudirman No. 37, Jakarta', '1997-06-25', 'Perempuan', 'siswa', '1', '2025-04-21 11:30:00'),
('rizki', 'e10adc3949ba59abbe56e057f20f883e', 'Rizki Maulana', 'rizki.maulana@gmail.com', 2147483647, 'Jl. Buah Batu No. 29, Bandung', '1995-10-03', 'Laki-laki', 'siswa', '1', '2025-04-21 11:30:00'),
('dinda', 'e10adc3949ba59abbe56e057f20f883e', 'Dinda Kirana', 'dinda.kirana@gmail.com', 2147483647, 'Jl. Diponegoro No. 39, Yogyakarta', '1996-12-19', 'Perempuan', 'siswa', '1', '2025-04-21 11:30:00'),
('ridwan', 'e10adc3949ba59abbe56e057f20f883e', 'Ridwan Kamil', 'ridwan.kamil@gmail.com', 2147483647, 'Jl. Veteran No. 30, Surabaya', '1994-03-27', 'Laki-laki', 'siswa', '1', '2025-04-21 11:30:00'),
('rini', 'e10adc3949ba59abbe56e057f20f883e', 'Rini Wulandari', 'rini.wulandari@gmail.com', 2147483647, 'Jl. Merdeka No. 41, Jakarta', '1997-07-08', 'Perempuan', 'siswa', '1', '2025-04-21 11:30:00'),
('firman', 'e10adc3949ba59abbe56e057f20f883e', 'Firman Utama', 'firman.utama@gmail.com', 2147483647, 'Jl. Pajajaran No. 31, Bandung', '1995-11-15', 'Laki-laki', 'siswa', '1', '2025-04-21 11:30:00'),
('diana', 'e10adc3949ba59abbe56e057f20f883e', 'Diana Puspita', 'diana.puspita@gmail.com', 2147483647, 'Jl. Malioboro No. 43, Yogyakarta', '1996-02-28', 'Perempuan', 'siswa', '1', '2025-04-21 11:30:00'),
('fauzi', 'e10adc3949ba59abbe56e057f20f883e', 'Fauzi Rahman', 'fauzi.rahman@gmail.com', 2147483647, 'Jl. Pemuda No. 32, Surabaya', '1994-04-05', 'Laki-laki', 'siswa', '1', '2025-04-21 11:30:00'),
('novita', 'e10adc3949ba59abbe56e057f20f883e', 'Novita Sari', 'novita.sari@gmail.com', 2147483647, 'Jl. Thamrin No. 45, Jakarta', '1997-08-17', 'Perempuan', 'siswa', '1', '2025-04-21 11:30:00'),
('agung', 'e10adc3949ba59abbe56e057f20f883e', 'Agung Prabowo', 'agung.prabowo@gmail.com', 2147483647, 'Jl. Cihampelas No. 33, Bandung', '1995-12-24', 'Laki-laki', 'siswa', '1', '2025-04-21 11:30:00'),
('wulan', 'e10adc3949ba59abbe56e057f20f883e', 'Wulan Anggraini', 'wulan.anggraini@gmail.com', 2147483647, 'Jl. Kaliurang No. 47, Yogyakarta', '1996-04-09', 'Perempuan', 'siswa', '1', '2025-04-21 11:30:00'),
('yusuf', 'e10adc3949ba59abbe56e057f20f883e', 'Yusuf Mahendra', 'yusuf.mahendra@gmail.com', 2147483647, 'Jl. Darmo No. 34, Surabaya', '1994-06-13', 'Laki-laki', 'siswa', '1', '2025-04-21 11:30:00'),
('elsa', 'e10adc3949ba59abbe56e057f20f883e', 'Elsa Pitaloka', 'elsa.pitaloka@gmail.com', 2147483647, 'Jl. Kemang No. 49, Jakarta', '1997-10-28', 'Perempuan', 'siswa', '1', '2025-04-21 11:30:00'),
('fandi', 'e10adc3949ba59abbe56e057f20f883e', 'Fandi Ahmad', 'fandi.ahmad@gmail.com', 2147483647, 'Jl. Dipatiukur No. 35, Bandung', '1995-01-31', 'Laki-laki', 'siswa', '1', '2025-04-21 11:30:00'),
('tiwi', 'e10adc3949ba59abbe56e057f20f883e', 'Tiwi Kusuma', 'tiwi.kusuma@gmail.com', 2147483647, 'Jl. Gejayan No. 51, Yogyakarta', '1996-05-22', 'Perempuan', 'siswa', '1', '2025-04-21 11:30:00'),
('hendra', 'e10adc3949ba59abbe56e057f20f883e', 'Hendra Gunawan', 'hendra.gunawan@gmail.com', 2147483647, 'Jl. Mayjen Sungkono No. 36, Surabaya', '1994-07-19', 'Laki-laki', 'siswa', '1', '2025-04-21 11:30:00'),
('riska', 'e10adc3949ba59abbe56e057f20f883e', 'Riska Amelia', 'riska.amelia@gmail.com', 2147483647, 'Jl. Menteng No. 53, Jakarta', '1997-11-03', 'Perempuan', 'siswa', '1', '2025-04-21 11:30:00'),
('irfan', 'e10adc3949ba59abbe56e057f20f883e', 'Irfan Hakim', 'irfan.hakim@gmail.com', 2147483647, 'Jl. Pasir Kaliki No. 37, Bandung', '1995-03-09', 'Laki-laki', 'siswa', '1', '2025-04-21 11:30:00'),
('fitri', 'e10adc3949ba59abbe56e057f20f883e', 'Fitri Karlina', 'fitri.karlina@gmail.com', 2147483647, 'Jl. Prawirotaman No. 55, Yogyakarta', '1996-06-14', 'Perempuan', 'siswa', '1', '2025-04-21 11:30:00'),
('surya', 'e10adc3949ba59abbe56e057f20f883e', 'Surya Wijaya', 'surya.wijaya@gmail.com', 2147483647, 'Jl. Raya Gubeng No. 38, Surabaya', '1994-08-25', 'Laki-laki', 'siswa', '1', '2025-04-21 11:30:00'),
('citra', 'e10adc3949ba59abbe56e057f20f883e', 'Citra Dewi', 'citra.dewi@gmail.com', 2147483647, 'Jl. Fatmawati No. 57, Jakarta', '1997-12-11', 'Perempuan', 'siswa', '1', '2025-04-21 11:30:00'),
('taufik', 'e10adc3949ba59abbe56e057f20f883e', 'Taufik Hidayat', 'taufik.hidayat@gmail.com', 2147483647, 'Jl. Sukajadi No. 39, Bandung', '1995-04-16', 'Laki-laki', 'siswa', '1', '2025-04-21 11:30:00'),
('anggi', 'e10adc3949ba59abbe56e057f20f883e', 'Anggi Permatasari', 'anggi.permatasari@gmail.com', 2147483647, 'Jl. Babarsari No. 59, Yogyakarta', '1996-07-29', 'Perempuan', 'siswa', '1', '2025-04-21 11:30:00'),
('andre', 'e10adc3949ba59abbe56e057f20f883e', 'Andre Taulany', 'andre.taulany@gmail.com', 2147483647, 'Jl. Urip Sumoharjo No. 40, Surabaya', '1994-09-08', 'Laki-laki', 'siswa', '1', '2025-04-21 11:30:00'),
('mega', 'e10adc3949ba59abbe56e057f20f883e', 'Mega Putri', 'mega.putri@gmail.com', 2147483647, 'Jl. Rasuna Said No. 61, Jakarta', '1998-01-17', 'Perempuan', 'siswa', '1', '2025-04-21 11:30:00'),
('wisnu', 'e10adc3949ba59abbe56e057f20f883e', 'Wisnu Wardana', 'wisnu.wardana@gmail.com', 2147483647, 'Jl. Merdeka No. 41, Bandung', '1995-05-26', 'Laki-laki', 'siswa', '1', '2025-04-21 11:30:00'),
('sinta', 'e10adc3949ba59abbe56e057f20f883e', 'Sinta Dewi', 'sinta.dewi@gmail.com', 2147483647, 'Jl. Affandi No. 63, Yogyakarta', '1996-09-02', 'Perempuan', 'siswa', '1', '2025-04-21 11:30:00'),
('eko', 'e10adc3949ba59abbe56e057f20f883e', 'Eko Prasetyo', 'eko.prasetyo@gmail.com', 2147483647, 'Jl. Ahmad Yani No. 42, Surabaya', '1994-10-19', 'Laki-laki', 'siswa', '1', '2025-04-21 11:30:00'),
('ayu', 'e10adc3949ba59abbe56e057f20f883e', 'Ayu Lestari', 'ayu.lestari@gmail.com', 2147483647, 'Jl. Sudirman No. 65, Jakarta', '1998-02-25', 'Perempuan', 'siswa', '1', '2025-04-21 11:30:00'),
('dimas', 'e10adc3949ba59abbe56e057f20f883e', 'Dimas Anggara', 'dimas.anggara@gmail.com', 2147483647, 'Jl. Setiabudi No. 43, Bandung', '1995-06-30', 'Laki-laki', 'siswa', '1', '2025-04-21 11:30:00'),
('lestari', 'e10adc3949ba59abbe56e057f20f883e', 'Lestari Dewi', 'lestari.dewi@gmail.com', 2147483647, 'Jl. Solo No. 67, Yogyakarta', '1996-10-11', 'Perempuan', 'siswa', '1', '2025-04-21 11:30:00'),
('febri', 'e10adc3949ba59abbe56e057f20f883e', 'Febri Hariyanto', 'febri.hariyanto@gmail.com', 2147483647, 'Jl. Diponegoro No. 44, Surabaya', '1994-11-27', 'Laki-laki', 'siswa', '1', '2025-04-21 11:30:00'),
('nining', 'e10adc3949ba59abbe56e057f20f883e', 'Nining Pratiwi', 'nining.pratiwi@gmail.com', 2147483647, 'Jl. Panglima Polim No. 69, Jakarta', '1998-03-05', 'Perempuan', 'siswa', '1', '2025-04-21 11:30:00'),
('ari', 'e10adc3949ba59abbe56e057f20f883e', 'Ari Wibowo', 'ari.wibowo@gmail.com', 2147483647, 'Jl. Pasteur No. 45, Bandung', '1995-08-07', 'Laki-laki', 'siswa', '1', '2025-04-21 11:30:00'),
('yanti', 'e10adc3949ba59abbe56e057f20f883e', 'Yanti Setiawati', 'yanti.setiawati@gmail.com', 2147483647, 'Jl. Colombo No. 71, Yogyakarta', '1996-11-22', 'Perempuan', 'siswa', '1', '2025-04-21 11:30:00'),
('anton', 'e10adc3949ba59abbe56e057f20f883e', 'Anton Wijaya', 'anton.wijaya@gmail.com', 2147483647, 'Jl. Pemuda No. 46, Surabaya', '1994-12-01', 'Laki-laki', 'siswa', '1', '2025-04-21 11:30:00'),
('tiara', 'e10adc3949ba59abbe56e057f20f883e', 'Tiara Lestari', 'tiara.lestari@gmail.com', 2147483647, 'Jl. Kuningan No. 73, Jakarta', '1998-04-13', 'Perempuan', 'siswa', '1', '2025-04-21 11:30:00'),
('wahyu', 'e10adc3949ba59abbe56e057f20f883e', 'Wahyu Hidayat', 'wahyu.hidayat@gmail.com', 2147483647, 'Jl. Ir. H. Juanda No. 47, Bandung', '1995-09-18', 'Laki-laki', 'siswa', '1', '2025-04-21 11:30:00'),
('sari', 'e10adc3949ba59abbe56e057f20f883e', 'Sari Indah', 'sari.indah@gmail.com', 2147483647, 'Jl. Janti No. 75, Yogyakarta', '1996-12-23', 'Perempuan', 'siswa', '1', '2025-04-21 11:30:00'),
('ferry', 'e10adc3949ba59abbe56e057f20f883e', 'Ferry Irawan', 'ferry.irawan@gmail.com', 2147483647, 'Jl. Tunjungan No. 48, Surabaya', '1995-01-09', 'Laki-laki', 'siswa', '1', '2025-04-21 11:30:00'),
('nia', 'e10adc3949ba59abbe56e057f20f883e', 'Nia Ramadhani', 'nia.ramadhani@gmail.com', 2147483647, 'Jl. Casablanca No. 77, Jakarta', '1998-05-21', 'Perempuan', 'siswa', '1', '2025-04-21 11:30:00'),
('rangga', 'e10adc3949ba59abbe56e057f20f883e', 'Rangga Putra', 'rangga.putra@gmail.com', 2147483647, 'Jl. Surapati No. 49, Bandung', '1995-10-31', 'Laki-laki', 'siswa', '1', '2025-04-21 11:30:00'),
('lia', 'e10adc3949ba59abbe56e057f20f883e', 'Lia Anggraeni', 'lia.anggraeni@gmail.com', 2147483647, 'Jl. Kaliurang No. 79, Yogyakarta', '1997-01-07', 'Perempuan', 'siswa', '1', '2025-04-21 11:30:00'),
('reza', 'e10adc3949ba59abbe56e057f20f883e', 'Reza Rahadian', 'reza.rahadian@gmail.com', 2147483647, 'Jl. Raya Darmo No. 50, Surabaya', '1995-02-12', 'Laki-laki', 'siswa', '1', '2025-04-21 11:30:00'),
('devi', 'e10adc3949ba59abbe56e057f20f883e', 'Devi Permatasari', 'devi.permatasari@gmail.com', 2147483647, 'Jl. Antasari No. 81, Jakarta', '1998-06-29', 'Perempuan', 'siswa', '1', '2025-04-21 11:30:00'),
('gunawan', 'e10adc3949ba59abbe56e057f20f883e', 'Gunawan Santoso', 'gunawan.santoso@gmail.com', 2147483647, 'Jl. Braga No. 51, Bandung', '1995-11-04', 'Laki-laki', 'siswa', '1', '2025-04-21 11:30:00'),
('tika', 'e10adc3949ba59abbe56e057f20f883e', 'Tika Putri', 'tika.putri@gmail.com', 2147483647, 'Jl. Gejayan No. 83, Yogyakarta', '1997-02-18', 'Perempuan', 'siswa', '1', '2025-04-21 11:30:00'),
('rama', 'e10adc3949ba59abbe56e057f20f883e', 'Rama Wijaya', 'rama.wijaya@gmail.com', 2147483647, 'Jl. Pahlawan No. 52, Surabaya', '1995-03-25', 'Laki-laki', 'siswa', '1', '2025-04-21 11:30:00'),
('shinta', 'e10adc3949ba59abbe56e057f20f883e', 'Shinta Dewi', 'shinta.dewi@gmail.com', 2147483647, 'Jl. Tebet No. 85, Jakarta', '1998-07-10', 'Perempuan', 'siswa', '1', '2025-04-21 11:30:00');

-- --------------------------------------------------------

--
-- Struktur dari tabel `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `no_hp` varchar(15) DEFAULT NULL,
  `alamat` varchar(255) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `jenis_kelamin` enum('Laki-laki','Perempuan','','') NOT NULL,
  `level` enum('siswa','pengajar') NOT NULL,
  `status` tinyint(1) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `nama`, `email`, `no_hp`, `alamat`, `tgl_lahir`, `jenis_kelamin`, `level`, `status`, `created_at`) VALUES
(1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'admin', 'test', '08937837', 'test', '2025-03-23', 'Laki-laki', 'pengajar', 1, '2025-03-23 03:11:03'),
(5, 'ramdhan', 'admin', 'Ramdhan', 'ramdhanrs85@gmail.com', '0895332906033', 'Kp.Tipar', '2002-11-23', 'Laki-laki', 'pengajar', 1, '2025-04-07 10:28:05'),
(6, 'bambang', 'e10adc3949ba59abbe56e057f20f883e', 'Bambang Sutrisno', 'bambang.sutrisno@gmail.com', '081234567890', 'Jl. Merdeka No. 10, Jakarta', '1985-05-15', 'Laki-laki', 'pengajar', 1, '2025-04-21 04:30:00'),
(7, 'siti', 'e10adc3949ba59abbe56e057f20f883e', 'Siti Nurhaliza', 'siti.nurhaliza@gmail.com', '081234567891', 'Jl. Pahlawan No. 5, Bandung', '1990-07-22', 'Perempuan', 'pengajar', 1, '2025-04-21 04:30:00'),
(8, 'agus', 'e10adc3949ba59abbe56e057f20f883e', 'Agus Hermawan', 'agus.hermawan@gmail.com', '081234567892', 'Jl. Diponegoro No. 15, Surabaya', '1982-03-10', 'Laki-laki', 'pengajar', 1, '2025-04-21 04:30:00'),
(9, 'dewi', 'e10adc3949ba59abbe56e057f20f883e', 'Dewi Sartika', 'dewi.sartika@gmail.com', '081234567893', 'Jl. Gatot Subroto No. 7, Yogyakarta', '1988-11-05', 'Perempuan', 'pengajar', 1, '2025-04-21 04:30:00'),
(10, 'budi', 'e10adc3949ba59abbe56e057f20f883e', 'Budi Santoso', 'budi.santoso@gmail.com', '081234567894', 'Jl. Ahmad Yani No. 20, Semarang', '1984-09-18', 'Laki-laki', 'pengajar', 1, '2025-04-21 04:30:00'),
(11, 'rina', 'e10adc3949ba59abbe56e057f20f883e', 'Rina Wulandari', 'rina.wulandari@gmail.com', '081234567895', 'Jl. Sudirman No. 25, Malang', '1992-02-14', 'Perempuan', 'pengajar', 1, '2025-04-21 04:30:00'),
(12, 'hadi', 'e10adc3949ba59abbe56e057f20f883e', 'Hadi Prasetyo', 'hadi.prasetyo@gmail.com', '081234567896', 'Jl. Veteran No. 12, Surakarta', '1981-12-30', 'Laki-laki', 'pengajar', 1, '2025-04-21 04:30:00'),
(13, 'anita', 'e10adc3949ba59abbe56e057f20f883e', 'Anita Wijaya', 'anita.wijaya@gmail.com', '081234567897', 'Jl. Pemuda No. 8, Denpasar', '1989-06-25', 'Perempuan', 'pengajar', 1, '2025-04-21 04:30:00'),
(14, 'dodi', 'e10adc3949ba59abbe56e057f20f883e', 'Dodi Setiawan', 'dodi.setiawan@gmail.com', '081234567898', 'Jl. Imam Bonjol No. 30, Makassar', '1983-08-12', 'Laki-laki', 'pengajar', 1, '2025-04-21 04:30:00'),
(15, 'lina', 'e10adc3949ba59abbe56e057f20f883e', 'Lina Marpaung', 'lina.marpaung@gmail.com', '081234567899', 'Jl. Kartini No. 9, Medan', '1991-04-20', 'Perempuan', 'pengajar', 1, '2025-04-21 04:30:00'),
(16, 'joko', 'e10adc3949ba59abbe56e057f20f883e', 'Joko Widodo', 'joko.widodo@gmail.com', '081234567800', 'Jl. Gajah Mada No. 11, Solo', '1980-10-05', 'Laki-laki', 'pengajar', 1, '2025-04-21 04:30:00'),
(17, 'siska', 'e10adc3949ba59abbe56e057f20f883e', 'Siska Purnama', 'siska.purnama@gmail.com', '081234567801', 'Jl. Hayam Wuruk No. 14, Bandung', '1993-01-15', 'Perempuan', 'pengajar', 1, '2025-04-21 04:30:00'),
(18, 'rudi', 'e10adc3949ba59abbe56e057f20f883e', 'Rudi Hartono', 'rudi.hartono@gmail.com', '081234567802', 'Jl. Thamrin No. 22, Jakarta', '1985-07-28', 'Laki-laki', 'pengajar', 1, '2025-04-21 04:30:00'),
(19, 'nina', 'e10adc3949ba59abbe56e057f20f883e', 'Nina Handayani', 'nina.handayani@gmail.com', '081234567803', 'Jl. Juanda No. 17, Surabaya', '1990-09-30', 'Perempuan', 'pengajar', 1, '2025-04-21 04:30:00'),
(20, 'arief', 'e10adc3949ba59abbe56e057f20f883e', 'Arief Budiman', 'arief.budiman@gmail.com', '081234567804', 'Jl. Asia Afrika No. 19, Bandung', '1982-05-22', 'Laki-laki', 'pengajar', 1, '2025-04-21 04:30:00'),
(21, 'dian', 'e10adc3949ba59abbe56e057f20f883e', 'Dian Sastro', 'dian.sastro@gmail.com', '081234567805', 'Jl. Wahid Hasyim No. 6, Jakarta', '1988-03-17', 'Perempuan', 'pengajar', 1, '2025-04-21 04:30:00'),
(22, 'andi', 'e10adc3949ba59abbe56e057f20f883e', 'Andi Firmansyah', 'andi.firmansyah@gmail.com', '081234567806', 'Jl. Pangeran Diponegoro No. 13, Yogyakarta', '1984-11-11', 'Laki-laki', 'pengajar', 1, '2025-04-21 04:30:00'),
(23, 'maya', 'e10adc3949ba59abbe56e057f20f883e', 'Maya Septianti', 'maya.septianti@gmail.com', '081234567807', 'Jl. Padjajaran No. 16, Bogor', '1992-08-03', 'Perempuan', 'pengajar', 1, '2025-04-21 04:30:00'),
(24, 'deni', 'e10adc3949ba59abbe56e057f20f883e', 'Deni Mahendra', 'deni.mahendra@gmail.com', '081234567808', 'Jl. Raya Bogor No. 21, Depok', '1981-02-09', 'Laki-laki', 'pengajar', 1, '2025-04-21 04:30:00'),
(25, 'putri', 'e10adc3949ba59abbe56e057f20f883e', 'Putri Handayani', 'putri.handayani@gmail.com', '081234567809', 'Jl. Cendrawasih No. 4, Makassar', '1989-10-14', 'Perempuan', 'pengajar', 1, '2025-04-21 04:30:00'),
(26, 'tirta', 'e10adc3949ba59abbe56e057f20f883e', 'Tirta Wijaya', 'tirta.wijaya@gmail.com', '081234567810', 'Jl. Mangga Dua No. 31, Jakarta', '1995-03-22', 'Laki-laki', 'siswa', 1, '2025-04-21 04:30:00'),
(27, 'indah', 'e10adc3949ba59abbe56e057f20f883e', 'Indah Permata', 'indah.permata@gmail.com', '081234567811', 'Jl. Cikutra No. 27, Bandung', '1996-07-12', 'Perempuan', 'siswa', 1, '2025-04-21 04:30:00'),
(28, 'dika', 'e10adc3949ba59abbe56e057f20f883e', 'Dika Pratama', 'dika.pratama@gmail.com', '081234567812', 'Jl. Darmo No. 18, Surabaya', '1994-11-25', 'Laki-laki', 'siswa', 1, '2025-04-21 04:30:00'),
(29, 'ratna', 'e10adc3949ba59abbe56e057f20f883e', 'Ratna Dewi', 'ratna.dewi@gmail.com', '081234567813', 'Jl. Cikini No. 33, Jakarta', '1997-01-05', 'Perempuan', 'siswa', 1, '2025-04-21 04:30:00'),
(30, 'galih', 'e10adc3949ba59abbe56e057f20f883e', 'Galih Ramadhan', 'galih.ramadhan@gmail.com', '081234567814', 'Jl. Setiabudhi No. 23, Bandung', '1995-05-20', 'Laki-laki', 'siswa', 1, '2025-04-21 04:30:00'),
(31, 'kirana', 'e10adc3949ba59abbe56e057f20f883e', 'Kirana Sari', 'kirana.sari@gmail.com', '081234567815', 'Jl. Kaliurang No. 29, Yogyakarta', '1996-09-15', 'Perempuan', 'siswa', 1, '2025-04-21 04:30:00'),
(32, 'ilham', 'e10adc3949ba59abbe56e057f20f883e', 'Ilham Nugroho', 'ilham.nugroho@gmail.com', '081234567816', 'Jl. Basuki Rahmat No. 24, Surabaya', '1994-12-30', 'Laki-laki', 'siswa', 1, '2025-04-21 04:30:00'),
(33, 'laras', 'e10adc3949ba59abbe56e057f20f883e', 'Laras Sekar', 'laras.sekar@gmail.com', '081234567817', 'Jl. Gatot Subroto No. 35, Jakarta', '1997-04-10', 'Perempuan', 'siswa', 1, '2025-04-21 04:30:00'),
(34, 'aditya', 'e10adc3949ba59abbe56e057f20f883e', 'Aditya Firmansyah', 'aditya.firmansyah@gmail.com', '081234567818', 'Jl. Dago No. 26, Bandung', '1995-08-07', 'Laki-laki', 'siswa', 1, '2025-04-21 04:30:00'),
(35, 'intan', 'e10adc3949ba59abbe56e057f20f883e', 'Intan Permata', 'intan.permata@gmail.com', '081234567819', 'Jl. Malioboro No. 32, Yogyakarta', '1996-11-18', 'Perempuan', 'siswa', 1, '2025-04-21 04:30:00'),
(36, 'bayu', 'e10adc3949ba59abbe56e057f20f883e', 'Bayu Pratama', 'bayu.pratama@gmail.com', '081234567820', 'Jl. Pahlawan No. 28, Semarang', '1994-02-14', 'Laki-laki', 'siswa', 1, '2025-04-21 04:30:00'),
(37, 'nadia', 'e10adc3949ba59abbe56e057f20f883e', 'Nadia Safitri', 'nadia.safitri@gmail.com', '081234567821', 'Jl. Sudirman No. 37, Jakarta', '1997-06-25', 'Perempuan', 'siswa', 1, '2025-04-21 04:30:00'),
(38, 'rizki', 'e10adc3949ba59abbe56e057f20f883e', 'Rizki Maulana', 'rizki.maulana@gmail.com', '081234567822', 'Jl. Buah Batu No. 29, Bandung', '1995-10-03', 'Laki-laki', 'siswa', 1, '2025-04-21 04:30:00'),
(39, 'dinda', 'e10adc3949ba59abbe56e057f20f883e', 'Dinda Kirana', 'dinda.kirana@gmail.com', '081234567823', 'Jl. Diponegoro No. 39, Yogyakarta', '1996-12-19', 'Perempuan', 'siswa', 1, '2025-04-21 04:30:00'),
(40, 'ridwan', 'e10adc3949ba59abbe56e057f20f883e', 'Ridwan Kamil', 'ridwan.kamil@gmail.com', '081234567824', 'Jl. Veteran No. 30, Surabaya', '1994-03-27', 'Laki-laki', 'siswa', 1, '2025-04-21 04:30:00'),
(41, 'rini', 'e10adc3949ba59abbe56e057f20f883e', 'Rini Wulandari', 'rini.wulandari@gmail.com', '081234567825', 'Jl. Merdeka No. 41, Jakarta', '1997-07-08', 'Perempuan', 'siswa', 1, '2025-04-21 04:30:00'),
(42, 'firman', 'e10adc3949ba59abbe56e057f20f883e', 'Firman Utama', 'firman.utama@gmail.com', '081234567826', 'Jl. Pajajaran No. 31, Bandung', '1995-11-15', 'Laki-laki', 'siswa', 1, '2025-04-21 04:30:00'),
(43, 'diana', 'e10adc3949ba59abbe56e057f20f883e', 'Diana Puspita', 'diana.puspita@gmail.com', '081234567827', 'Jl. Malioboro No. 43, Yogyakarta', '1996-02-28', 'Perempuan', 'siswa', 1, '2025-04-21 04:30:00'),
(44, 'fauzi', 'e10adc3949ba59abbe56e057f20f883e', 'Fauzi Rahman', 'fauzi.rahman@gmail.com', '081234567828', 'Jl. Pemuda No. 32, Surabaya', '1994-04-05', 'Laki-laki', 'siswa', 1, '2025-04-21 04:30:00'),
(45, 'novita', 'e10adc3949ba59abbe56e057f20f883e', 'Novita Sari', 'novita.sari@gmail.com', '081234567829', 'Jl. Thamrin No. 45, Jakarta', '1997-08-17', 'Perempuan', 'siswa', 1, '2025-04-21 04:30:00'),
(46, 'agung', 'e10adc3949ba59abbe56e057f20f883e', 'Agung Prabowo', 'agung.prabowo@gmail.com', '081234567830', 'Jl. Cihampelas No. 33, Bandung', '1995-12-24', 'Laki-laki', 'siswa', 1, '2025-04-21 04:30:00'),
(47, 'wulan', 'e10adc3949ba59abbe56e057f20f883e', 'Wulan Anggraini', 'wulan.anggraini@gmail.com', '081234567831', 'Jl. Kaliurang No. 47, Yogyakarta', '1996-04-09', 'Perempuan', 'siswa', 1, '2025-04-21 04:30:00'),
(48, 'yusuf', 'e10adc3949ba59abbe56e057f20f883e', 'Yusuf Mahendra', 'yusuf.mahendra@gmail.com', '081234567832', 'Jl. Darmo No. 34, Surabaya', '1994-06-13', 'Laki-laki', 'siswa', 1, '2025-04-21 04:30:00'),
(49, 'elsa', 'e10adc3949ba59abbe56e057f20f883e', 'Elsa Pitaloka', 'elsa.pitaloka@gmail.com', '081234567833', 'Jl. Kemang No. 49, Jakarta', '1997-10-28', 'Perempuan', 'siswa', 1, '2025-04-21 04:30:00'),
(50, 'fandi', 'e10adc3949ba59abbe56e057f20f883e', 'Fandi Ahmad', 'fandi.ahmad@gmail.com', '081234567834', 'Jl. Dipatiukur No. 35, Bandung', '1995-01-31', 'Laki-laki', 'siswa', 1, '2025-04-21 04:30:00'),
(51, 'tiwi', 'e10adc3949ba59abbe56e057f20f883e', 'Tiwi Kusuma', 'tiwi.kusuma@gmail.com', '081234567835', 'Jl. Gejayan No. 51, Yogyakarta', '1996-05-22', 'Perempuan', 'siswa', 1, '2025-04-21 04:30:00'),
(52, 'hendra', 'e10adc3949ba59abbe56e057f20f883e', 'Hendra Gunawan', 'hendra.gunawan@gmail.com', '081234567836', 'Jl. Mayjen Sungkono No. 36, Surabaya', '1994-07-19', 'Laki-laki', 'siswa', 1, '2025-04-21 04:30:00'),
(53, 'riska', 'e10adc3949ba59abbe56e057f20f883e', 'Riska Amelia', 'riska.amelia@gmail.com', '081234567837', 'Jl. Menteng No. 53, Jakarta', '1997-11-03', 'Perempuan', 'siswa', 1, '2025-04-21 04:30:00'),
(54, 'irfan', 'e10adc3949ba59abbe56e057f20f883e', 'Irfan Hakim', 'irfan.hakim@gmail.com', '081234567838', 'Jl. Pasir Kaliki No. 37, Bandung', '1995-03-09', 'Laki-laki', 'siswa', 1, '2025-04-21 04:30:00'),
(55, 'fitri', 'e10adc3949ba59abbe56e057f20f883e', 'Fitri Karlina', 'fitri.karlina@gmail.com', '081234567839', 'Jl. Prawirotaman No. 55, Yogyakarta', '1996-06-14', 'Perempuan', 'siswa', 1, '2025-04-21 04:30:00'),
(106, 'surya', 'e10adc3949ba59abbe56e057f20f883e', 'Surya Wijaya', 'surya.wijaya@gmail.com', '081234567840', 'Jl. Raya Gubeng No. 38, Surabaya', '1994-08-25', 'Laki-laki', 'siswa', 1, '2025-04-21 04:30:00');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `classes`
--
ALTER TABLE `classes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `courses_id` (`courses_id`),
  ADD KEY `coach_id` (`coach_id`);

--
-- Indeks untuk tabel `class_registrations`
--
ALTER TABLE `class_registrations`
  ADD PRIMARY KEY (`id`),
  ADD KEY `class_id` (`class_id`),
  ADD KEY `student_id` (`student_id`);

--
-- Indeks untuk tabel `class_schedules`
--
ALTER TABLE `class_schedules`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Classid` (`class_id`);

--
-- Indeks untuk tabel `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `course_name` (`courses_name`);

--
-- Indeks untuk tabel `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `classes`
--
ALTER TABLE `classes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `class_registrations`
--
ALTER TABLE `class_registrations`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT untuk tabel `class_schedules`
--
ALTER TABLE `class_schedules`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `courses`
--
ALTER TABLE `courses`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=108;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `classes`
--
ALTER TABLE `classes`
  ADD CONSTRAINT `classes_ibfk_1` FOREIGN KEY (`courses_id`) REFERENCES `courses` (`id`),
  ADD CONSTRAINT `classes_ibfk_2` FOREIGN KEY (`coach_id`) REFERENCES `users` (`id`);

--
-- Ketidakleluasaan untuk tabel `class_registrations`
--
ALTER TABLE `class_registrations`
  ADD CONSTRAINT `class_registrations_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `classes` (`id`),
  ADD CONSTRAINT `class_registrations_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `users` (`id`);

--
-- Ketidakleluasaan untuk tabel `class_schedules`
--
ALTER TABLE `class_schedules`
  ADD CONSTRAINT `class_schedules_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `classes` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
