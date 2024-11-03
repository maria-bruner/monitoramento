CREATE TABLE IF NOT EXISTS `acidentes` (
  `id_acidente` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_acidente` datetime(6) NOT NULL,
  `localizacao` varchar(255) NOT NULL,
  `qtd_veiculo` int(11) NOT NULL,
  `usuario_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_acidente`),
  KEY `FK5c15l4mj3vkrafi9l0xmm0hol` (`usuario_id`),
  CONSTRAINT `FK5c15l4mj3vkrafi9l0xmm0hol` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id_usuario`)
);