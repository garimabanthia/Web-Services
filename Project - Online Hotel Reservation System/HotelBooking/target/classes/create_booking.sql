
delimiter ;
DROP SCHEMA IF EXISTS `cs548_hotel`; 
CREATE SCHEMA `cs548_hotel` ;
use `cs548_hotel`;

delimiter $$


CREATE TABLE `customer` (
  `customerID` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `phoneNumber` varchar(45) DEFAULT NULL,
  `emailAddress` varchar(45) DEFAULT NULL,
  `mailingAddress` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`customerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `card_info` (
  `cardNumber` int(11) NOT NULL,
  `cardType` varchar(45) NOT NULL,
  `expiryMonth` varchar(45) NOT NULL,
  `expiryYear` int(11) NOT NULL,
  `CCV` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CCREATE TABLE `reservation` (
  `reservationID` int(11) NOT NULL AUTO_INCREMENT,
  `roomType` varchar(45) DEFAULT NULL,
  `checkINDate` date DEFAULT NULL,
  `checkOUTDate` date DEFAULT NULL,
  `amountPaid` float DEFAULT NULL,
  `totalAmount` float DEFAULT NULL,
  PRIMARY KEY (`reservationID`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

CREATE TABLE `room_inventory` (
  `economic` int(11) NOT NULL,
  `deluxe` int(11) NOT NULL,
  `executive` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


