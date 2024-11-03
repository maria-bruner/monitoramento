CREATE TABLE IF NOT EXISTS `rotas` (
  `id_rota` bigint(20) NOT NULL AUTO_INCREMENT,
  `destino` varchar(255) DEFAULT NULL,
  `localizacao_atual` varchar(255) DEFAULT NULL,
  `usuario_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_rota`),
  KEY `FK6q26v794nl8bjfy8q9ea6utl2` (`usuario_id`),
  CONSTRAINT `FK6q26v794nl8bjfy8q9ea6utl2` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id_usuario`)
);
