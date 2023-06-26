DROP database IF EXISTS finance_tracker;
CREATE database IF NOT EXISTS finance_tracker;
use finance_tracker;

DROP TABLE IF EXISTS `report`;
CREATE TABLE IF not EXISTS `report` (
    `reportID` VARCHAR(255) NOT NULL,
    `reportName` VARCHAR(255) NOT NULL,
    `userID` VARCHAR(255) NOT NULL,
    `startDate` DATE NOT NULL,
    `finishDate` DATE NOT NULL
);
ALTER TABLE `report` ADD PRIMARY KEY(`reportID`);

DROP TABLE IF EXISTS `budget`;
CREATE TABLE if NOT EXISTS `budget` (
    `budgetID` VARCHAR(255) NOT NULL,
    `budgetName` VARCHAR(255) NOT NULL,
    `userID` VARCHAR(255) NOT NULL,
    `categoryID` VARCHAR(255) NOT NULL,
    `budgetAmount` BIGINT NOT NULL,
    `usedAmount` BIGINT NOT NULL,
    `Balance` BIGINT NOT NULL,
    `startDate` DATE NOT NULL,
    `endDate` DATE NOT NULL
);
ALTER TABLE
    `budget` ADD PRIMARY KEY(`budgetID`);

DROP table IF EXISTS `category`;    
CREATE TABLE if NOT EXISTS `category` (
    `categoryID` VARCHAR(255) NOT NULL,
    `categoryName` VARCHAR(255) NOT NULL
);
ALTER TABLE `category` ADD PRIMARY KEY(`categoryID`);

DROP table IF EXISTS `income_table`;
CREATE TABLE IF not EXISTS `income_table` (
    `incomeID` VARCHAR(255) NOT NULL,
    `userID` VARCHAR(255) NOT NULL,
    `amount` BIGINT NOT NULL
);
ALTER TABLE `income_table` ADD PRIMARY KEY(`incomeID`);

DROP table IF EXISTS `user_info`;
CREATE TABLE if NOT exists `user_info`(
    `userID` VARCHAR(255) NOT NULL,
    `username` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `user_amount` BIGINT NOT NULL
);
ALTER TABLE `user_info` ADD PRIMARY KEY(`userID`);

DROP table IF EXISTS `transaction_info`;
CREATE TABLE if NOT EXISTS `transaction_info` (
    `transactionID` VARCHAR(255) NOT NULL,
    `userID` VARCHAR(255) NOT NULL,
    `categoryID` VARCHAR(255) NOT NULL,
    `Amount` BIGINT NOT NULL,
    `Date` DATE NOT NULL,
    `time` TIME NOT NULL
);

ALTER TABLE `transaction_info` ADD PRIMARY KEY(`transactionID`);

DROP table IF EXISTS `Goal`;
CREATE TABLE if NOT EXISTS `Goal` (
    `goal_ID` VARCHAR(255) NOT NULL,
    `userID` VARCHAR(255) NOT NULL,
    `goalAmount` BIGINT NOT NULL,
    `Amount` BIGINT NOT NULL,
    `dateStarted` DATE NOT NULL,
    `dateFinished` DATE NOT NULL,
    `Duration` INT NOT NULL
);
ALTER TABLE `Goal` ADD PRIMARY KEY(`goal_ID`);
ALTER TABLE `budget` ADD CONSTRAINT `budget_categoryid_foreign` FOREIGN KEY(`categoryID`) REFERENCES `category`(`categoryID`);
ALTER TABLE `income_table` ADD CONSTRAINT `income_table_userid_foreign` FOREIGN KEY(`userID`) REFERENCES `user_info`(`userID`);
ALTER TABLE `report` ADD CONSTRAINT `report_userid_foreign` FOREIGN KEY(`userID`) REFERENCES `income_table`(`userID`);
ALTER TABLE `budget` ADD CONSTRAINT `budget_userid_foreign` FOREIGN KEY(`userID`) REFERENCES `income_table`(`userID`);
ALTER TABLE `Goal` ADD CONSTRAINT `Goal_userid_foreign` FOREIGN KEY(`userID`) REFERENCES `income_table`(`userID`);
ALTER TABLE `transaction_info` ADD CONSTRAINT `transaction_info_categoryid_foreign` FOREIGN KEY(`categoryID`) REFERENCES `category`(`categoryID`);
ALTER TABLE `transaction_info` ADD CONSTRAINT `transaction_info_userid_foreign` FOREIGN KEY(`userID`) REFERENCES `income_table`(`userID`);
