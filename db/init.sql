CREATE TABLE `USER`(
                       `ID` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
                       `USERNAME` VARCHAR(150) NOT NULL,
                       `PASSWORD` VARCHAR(150) NOT NULL,
                       `PROFILE_PHOTO` VARCHAR(255) NOT NULL,
                       `REGISTRATION_DATE` DATE NOT NULL,
                       `CUSTOMER_ID` BIGINT UNSIGNED NOT NULL
);
ALTER TABLE
    `USER` ADD UNIQUE `user_username_unique`(`USERNAME`);
CREATE TABLE `CUSTOMER`(
                           `ID` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
                           `FIRSTNAME` VARCHAR(100) NOT NULL,
                           `LASTNAME` VARCHAR(100) NOT NULL,
                           `USERNAME` VARCHAR(100) NOT NULL,
                           `BIRTHDATE` DATE NOT NULL,
                           `EMAIL` VARCHAR(100) NULL,
                           `PHONE_NUMBER` VARCHAR(50) NOT NULL
);
ALTER TABLE
    `CUSTOMER` ADD INDEX `customer_firstname_index`(`FIRSTNAME`);
ALTER TABLE
    `CUSTOMER` ADD INDEX `customer_lastname_index`(`LASTNAME`);
ALTER TABLE
    `CUSTOMER` ADD INDEX `customer_username_index`(`USERNAME`);
ALTER TABLE
    `CUSTOMER` ADD INDEX `customer_birthdate_index`(`BIRTHDATE`);
ALTER TABLE
    `CUSTOMER` ADD UNIQUE `customer_email_unique`(`EMAIL`);
ALTER TABLE
    `CUSTOMER` ADD UNIQUE `customer_phone_number_unique`(`PHONE_NUMBER`);
CREATE TABLE `GIFT`(
                       `ID` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
                       `NAME` VARCHAR(100) NOT NULL,
                       `STATE` ENUM('NEW', 'LIKE NEW', 'VERY GOOD', 'GOOD', 'WORN', 'DEFECTIVE') NOT NULL ,
                       `DIMENSION` VARCHAR(100) NULL,
                       `WEIGHT` DECIMAL(8, 2) NULL,
                       `DESCRIPTION` LONGTEXT NOT NULL,
                       `PHOTO` VARCHAR(255) NOT NULL,
                       `AVAILABILITY` DATE NOT NULL,
                       `USER_ID` BIGINT UNSIGNED NOT NULL
);
ALTER TABLE
    `GIFT` ADD INDEX `gift_name_index`(`NAME`);
CREATE TABLE `TRANSACTION`(
                              `ID` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
                              `GIFT_ID` BIGINT UNSIGNED NOT NULL,
                              `NAME` VARCHAR(255) NOT NULL,
                              `START_DATE` DATETIME NOT NULL,
                              `END_DATE` DATETIME NOT NULL,
                              `STATUS` ENUM('WAITING', 'APPROVED', 'FINISHED') NOT NULL
);
ALTER TABLE
    `TRANSACTION` ADD INDEX `transaction_name_index`(`NAME`);
CREATE TABLE `MESSAGE`(
                          `ID` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
                          `TRANSACTION_ID` BIGINT UNSIGNED NOT NULL,
                          `CONTENT` LONGTEXT NOT NULL,
                          `SEND_DATE` DATETIME NOT NULL,
                          `FILE_ID` BIGINT UNSIGNED NOT NULL
);
CREATE TABLE `ADDRESS`(
                          `ID` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
                          `CUSTOMER_ID` BIGINT UNSIGNED NOT NULL,
                          `STREET` VARCHAR(100) NOT NULL,
                          `ZIP` VARCHAR(50) NOT NULL,
                          `CITY` VARCHAR(100) NOT NULL,
                          `COUNTRY` VARCHAR(100) NOT NULL,
                          `OTHER_ADDRESS` VARCHAR(255) NULL
);
ALTER TABLE
    `ADDRESS` ADD INDEX `address_street_index`(`STREET`);
ALTER TABLE
    `ADDRESS` ADD INDEX `address_zip_index`(`ZIP`);
ALTER TABLE
    `ADDRESS` ADD INDEX `address_city_index`(`CITY`);
CREATE TABLE `MEDIAFILE`(
                            `ID` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
                            `FILE_IDENTIFIER` VARCHAR(255) NOT NULL,
                            `FILE_NAME` VARCHAR(255) NOT NULL,
                            `MIME_TYPE` ENUM('PHOTO', 'VIDEO', 'AUDIO') NOT NULL,
                            `SIZE` INT NOT NULL,
                            `UPLOAD_DATE` DATETIME NOT NULL
);
ALTER TABLE
    `MEDIAFILE` ADD INDEX `mediafile_file_name_index`(`FILE_NAME`);
CREATE TABLE `EVALUATION`(
                             `ID` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
                             `TRANSACTION_ID` BIGINT UNSIGNED NOT NULL,
                             `RATING` ENUM('ONE', 'TWO', 'THREE', 'FOUR', 'FIVE') NOT NULL,
                             `DESCRIPTION` LONGTEXT NOT NULL
);
ALTER TABLE
    `MESSAGE` ADD CONSTRAINT `message_file_id_foreign` FOREIGN KEY(`FILE_ID`) REFERENCES `MEDIAFILE`(`ID`);
ALTER TABLE
    `EVALUATION` ADD CONSTRAINT `evaluation_transaction_id_foreign` FOREIGN KEY(`TRANSACTION_ID`) REFERENCES `TRANSACTION`(`ID`);
ALTER TABLE
    `ADDRESS` ADD CONSTRAINT `address_customer_id_foreign` FOREIGN KEY(`CUSTOMER_ID`) REFERENCES `CUSTOMER`(`ID`);
ALTER TABLE
    `TRANSACTION` ADD CONSTRAINT `transaction_gift_id_foreign` FOREIGN KEY(`GIFT_ID`) REFERENCES `GIFT`(`ID`);
ALTER TABLE
    `USER` ADD CONSTRAINT `user_customer_id_foreign` FOREIGN KEY(`CUSTOMER_ID`) REFERENCES `CUSTOMER`(`ID`);
ALTER TABLE
    `MESSAGE` ADD CONSTRAINT `message_transaction_id_foreign` FOREIGN KEY(`TRANSACTION_ID`) REFERENCES `TRANSACTION`(`ID`);
ALTER TABLE
    `GIFT` ADD CONSTRAINT `gift_user_id_foreign` FOREIGN KEY(`USER_ID`) REFERENCES `USER`(`ID`);