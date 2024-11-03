CREATE TABLE IF NOT EXISTS `semaforos` (
  `id_semaforo` bigint(20) NOT NULL AUTO_INCREMENT,
  `localizacao` varchar(255) NOT NULL,
  `qtd_veiculo` int(11) DEFAULT NULL,
  `tempo_verde` int(11) NOT NULL,
  `usuario_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_semaforo`),
  KEY `FKe88k52ca8f7034d8xffn4cwd4` (`usuario_id`),
  CONSTRAINT `FKe88k52ca8f7034d8xffn4cwd4` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id_usuario`)
);