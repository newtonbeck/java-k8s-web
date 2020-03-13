DROP DATABASE IF EXISTS `my_blog`;
CREATE DATABASE `my_blog`;

USE `my_blog`;

DROP TABLE IF EXISTS `Posts`;
CREATE TABLE `Posts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `summary` TEXT DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `Posts` VALUES (1,'Meu primeiro post', 'O que falar neste primeiro post?');
INSERT INTO `Posts` VALUES (2,'Como é competir num campeonato de kart?', 'Neste post vou contar tudo para vocês sobre como é competir no Pé de Pano Kart');
INSERT INTO `Posts` VALUES (3,'Como estou me protegendo do Corona?', 'Vou contar pra vocês 10 dicas de como vocês podem se proteger do Corona vírus');
