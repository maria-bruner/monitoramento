CREATE TABLE IF NOT EXISTS `rota_boqueios` (
  `id_rota` bigint(20) NOT NULL,
  `local_bloqueado` varchar(255) DEFAULT NULL,
  KEY `FKg03lk1o3re2ek6xvyxx4x1c80` (`id_rota`),
  CONSTRAINT `FKg03lk1o3re2ek6xvyxx4x1c80` FOREIGN KEY (`id_rota`) REFERENCES `rotas` (`id_rota`)
);