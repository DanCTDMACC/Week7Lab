CREATE DATABASE shopping;
USE shopping;
CREATE table items(
	id INT NOT NULL AUTO_INCREMENT,
    store VARCHAR(20) NOT NULL,
    item VARCHAR(20) NOT NULL,
	PRIMARY KEY (id));

INSERT INTO `shopping`.`items` (`store`, `item`) VALUES ('Apple', 'iPhone');
INSERT INTO `shopping`.`items` (`store`, `item`) VALUES ('Apple', 'iPad');