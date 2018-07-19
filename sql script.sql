CREATE DATABASE cabine;

USE cabine;

DROP TABLE IF EXISTS `utilisateur`;



CREATE TABLE `utilisateur` (
  `idUser` bigint(20) NOT NULL AUTO_INCREMENT,
 
 `login` varchar(255) DEFAULT NULL,
 
 `pwd` varchar(255) DEFAULT NULL,
 
 `role` varchar(255) DEFAULT NULL,

  `DTYPE` varchar(31) NOT NULL,
 `etatUser` varchar(255) DEFAULT NULL,
 
 `cin` int(11) DEFAULT NULL,
 
 `DateNaiss` date DEFAULT NULL,
 
 `dossier` varchar(255) DEFAULT NULL,
 
 `nom` varchar(255) DEFAULT NULL,
 
 `prenom` varchar(255) DEFAULT NULL,
 
 `sexe` varchar(255) DEFAULT NULL,
 
 `tel` int(11) DEFAULT NULL,
 
 PRIMARY KEY (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `bilan`;



CREATE TABLE `bilan` (
  `idBilan` int(11) NOT NULL AUTO_INCREMENT,
 
 `dateBilan` datetime DEFAULT NULL,
 
 `libelleBilan` varchar(255) DEFAULT NULL,
 
 `idUtilisateur` bigint(20) DEFAULT NULL,
 
 PRIMARY KEY (`idBilan`),
 
 KEY `FKqlwd40ye84ajxsgqdd2n4433k` (`idUtilisateur`),
 
 CONSTRAINT `FKqlwd40ye84ajxsgqdd2n4433k` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `message`;



CREATE TABLE `message` (
  `idMsg` int(11) NOT NULL AUTO_INCREMENT,
 
 `contenuMsg` varchar(255) DEFAULT NULL,
  
`idUtilisateur` bigint(20) DEFAULT NULL,
 
 PRIMARY KEY (`idMsg`),
 
 KEY `FKd4a30qad4htlrv4lvuevunpfg` (`idUtilisateur`),
 
 CONSTRAINT `FKd4a30qad4htlrv4lvuevunpfg` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `rendez_vous`;



CREATE TABLE `rendez_vous` (
  `idRdv` int(11) NOT NULL AUTO_INCREMENT,
 
 `dateRdv` date DEFAULT NULL,
  
`etatRdv` varchar(255) DEFAULT NULL,
 
 `heureRdv` time DEFAULT NULL,
 
 `idUtilisateur` bigint(20) DEFAULT NULL,
  
PRIMARY KEY (`idRdv`),
  KEY `FKsugugqqy5yxxacfb6llvp03uk` (`idUtilisateur`),
 
 CONSTRAINT `FKsugugqqy5yxxacfb6llvp03uk` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `visite`;



CREATE TABLE `visite` (
  `idVisite` int(11) NOT NULL AUTO_INCREMENT,
 
 `dateVisite` date DEFAULT NULL,
 
 `heureVisite` time DEFAULT NULL,
  
`motifVisite` varchar(255) DEFAULT NULL,
  
`idUtilisateur` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idVisite`),
 
 KEY `FKij7cxc4ooppusdrtylw219cva` (`idUtilisateur`),
  
CONSTRAINT `FKij7cxc4ooppusdrtylw219cva` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `patient_bilan`;


CREATE TABLE `patient_bilan` (
  `idUtilisateur` bigint(20) NOT NULL,
 
 `idBilan` int(11) NOT NULL,
  UNIQUE KEY `UK_qw1upirfxsm5mjtn5fvgbmkwu` (`idBilan`),
 
 KEY `FKmalmic0q6c179wvct7ypfq136` (`idUtilisateur`),
  CONSTRAINT `FKmalmic0q6c179wvct7ypfq136` 
FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`idUser`),
  
CONSTRAINT `FKmkgoto9kvpd8mm2bg67jxp91y` FOREIGN KEY (`idBilan`) REFERENCES `bilan` (`idBilan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;





CREATE TABLE `patient_rendezvous` (
  `idUtilisateur` bigint(20) NOT NULL,
  
`idRdv` int(11) NOT NULL,
  UNIQUE KEY `UK_9dvm5gc9rp2muxfh7wjyl4mch` (`idRdv`),
  
KEY `FK9v5qk07yfxayq0j8qqa6glgu8` (`idUtilisateur`),
  
CONSTRAINT `FK9v5qk07yfxayq0j8qqa6glgu8` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`idUser`),
  
CONSTRAINT `FKrg7xafu95xgahyubtff9a7dac` FOREIGN KEY (`idRdv`) REFERENCES `rendez_vous` (`idRdv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




DROP TABLE IF EXISTS `patient_visite`;


CREATE TABLE `patient_visite` (
  `idUtilisateur` bigint(20) NOT NULL,
 
 `idVisite` int(11) NOT NULL,
  
UNIQUE KEY `UK_gpt6rphx9o6kbuvqhv4pwn6mo` (`idVisite`),
 
 KEY `FK2oycnwa9emi1n7ynctl07sxct` (`idUtilisateur`),
  
CONSTRAINT `FK2oycnwa9emi1n7ynctl07sxct` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`idUser`),
 
 CONSTRAINT `FK9aqxpwta5xyko4pler3ra6vh5` FOREIGN KEY (`idVisite`) REFERENCES `visite` (`idVisite`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;






DROP TABLE IF EXISTS `utilisateur_message`;



CREATE TABLE `utilisateur_message` (
  `idUtilisateur` bigint(20) NOT NULL,
 
 `idMsg` int(11) NOT NULL,
  UNIQUE KEY `UK_gm3ib92d1gcvngw125tpn0o56` (`idMsg`),
  
KEY `FKe24eunwkba1mgi237dbhowmo9` (`idUtilisateur`),
  
CONSTRAINT `FKe24eunwkba1mgi237dbhowmo9` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`idUser`),
  
CONSTRAINT `FKkmmxbbioglj14cuqhvflta00p` FOREIGN KEY (`idMsg`) REFERENCES `message` (`idMsg`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
