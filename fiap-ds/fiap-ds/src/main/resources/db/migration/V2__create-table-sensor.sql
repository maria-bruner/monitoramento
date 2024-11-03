CREATE TABLE IF NOT EXISTS `sensor_trafego` (
  `id_sensor_trafego` bigint(20) NOT NULL AUTO_INCREMENT,
  `localizacao` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `ultimo_ativo` datetime(6) DEFAULT NULL,
  `usuario_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_sensor_trafego`),
  KEY `FKiy3s3re8pnh709u4669sok85m` (`usuario_id`),
  CONSTRAINT `FKiy3s3re8pnh709u4669sok85m` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id_usuario`)
);