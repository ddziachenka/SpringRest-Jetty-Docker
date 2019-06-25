CREATE DATABASE persons;
USE persons;

CREATE TABLE `person`
(
  `person_id`  int(11)     NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name`  varchar(45) NOT NULL,
  `age`        int(11)     NOT NULL,
  PRIMARY KEY (`person_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 8
  DEFAULT CHARSET = utf8;

INSERT INTO `persons`.`person` (`person_id`, `first_name`, `last_name`, `age`)
VALUES ('1', 'Ivan', 'Ivanov', '35');
INSERT INTO `persons`.`person` (`person_id`, `first_name`, `last_name`, `age`)
VALUES ('2', 'Vadim', 'Vadimov', '32');
INSERT INTO `persons`.`person` (`person_id`, `first_name`, `last_name`, `age`)
VALUES ('3', 'Denis', 'Denisov', '36');