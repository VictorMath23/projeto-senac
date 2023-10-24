-- MySQL Script generated by MySQL Workbench
-- Tue Mar  7 21:37:38 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `firsts` DEFAULT CHARACTER SET utf8 ;
USE `firsts` ;

-- -----------------------------------------------------
-- Table `mydb`.`gestor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `firsts`.`gestor` (
  `id` INT NOT NULL AUTO_INCREMENT, 
  `nome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `matricula` INT,
  `area` INT NOT NULL,
  `comite` CHAR(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`area`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `firsts`.`area` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `area` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Beneficio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `firsts`.`beneficio` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `beneficio` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ideia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `firsts`.`ideia` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `dono` VARCHAR(50) NOT NULL,
  `proposta` VARCHAR(300) NOT NULL,
  `area_id` INT NOT NULL,
  `Beneficio_id` INT NOT NULL,
  `gestor_id` INT NOT NULL,
  `data_ideia` DATETIME NOT NULL,
  `status` VARCHAR(20) NULL,
  PRIMARY KEY (`id`, `area_id`, `Beneficio_id`, `gestor_id`),
  INDEX `fk_ideia_area_idx` (`area_id` ASC) VISIBLE,
  INDEX `fk_ideia_Beneficio1_idx` (`Beneficio_id` ASC) VISIBLE,
  INDEX `fk_ideia_gestor1_idx` (`gestor_id` ASC) VISIBLE,
  CONSTRAINT `fk_ideia_area`
    FOREIGN KEY (`area_id`)
    REFERENCES `firsts`.`area` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ideia_Beneficio1`
    FOREIGN KEY (`Beneficio_id`)
    REFERENCES `firsts`.`Beneficio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ideia_gestor1`
    FOREIGN KEY (`gestor_id`)
    REFERENCES `firsts`.`gestor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
