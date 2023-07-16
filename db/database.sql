DROP database IF EXISTS finance_tracker;
CREATE database IF NOT EXISTS finance_tracker;
use finance_tracker;

DROP TABLE IF EXISTS `report`;
CREATE TABLE IF not EXISTS `report` (
    `reportID` INT(3) NOT NULL AUTO_INCREMENT,
    `reportName` VARCHAR(255) NOT NULL,
    `userID` INT(4) NOT NULL,
    `startDate` DATE NOT NULL,
    `finishDate` DATE NOT NULL,
    PRIMARY KEY(`reportID`)
);

DROP TABLE IF EXISTS `budget`;
CREATE TABLE if NOT EXISTS `budget` (
    `budgetID` INT(3) NOT NULL AUTO_INCREMENT,
    `budgetName` VARCHAR(255) NOT NULL,
    `userID` INT(4) NOT NULL,
    `categoryID` VARCHAR(6) NOT NULL,
    `budgetAmount` BIGINT NOT NULL,
    `usedAmount` BIGINT NOT NULL,
    `Balance` BIGINT NOT NULL,
    `startDate` DATE NOT NULL,
    `endDate` DATE NOT NULL,
    PRIMARY KEY(`budgetID`)
);

DROP table IF EXISTS `category`;    
CREATE TABLE if NOT EXISTS `category` (
    `categoryID` VARCHAR(6) NOT NULL,
    `categoryName` VARCHAR(255) NOT NULL,
    PRIMARY KEY(`categoryID`)
);

DROP table IF EXISTS `user_info`;
CREATE TABLE if NOT exists `user_info`(
    `userID` INT(4) auto_increment NOT NULL,
    `username` VARCHAR(255) NOT NULL,
    `name` VARCHAR(255) NOT NULL default "",
    `email` VARCHAR(255) NOT NULL default "",
    `password` VARCHAR(255) NOT NULL,
    `Gender` VARCHAR(255) NOT NULL default "",
    `created_at` datetime not null default current_timestamp(),
    `updated_at` datetime not null default current_timestamp() ON UPDATE current_timestamp(),
    PRIMARY KEY(`userID`),
    UNIQUE KEY email (email)
);

DROP table IF EXISTS `transaction_info`;
CREATE TABLE if NOT EXISTS `transaction_info` (
    `transactionID` INT(11) NOT NULL AUTO_INCREMENT,
    `userID` INT(4) NOT NULL,
    `categoryID` VARCHAR(6) NOT NULL,
    `Amount` BIGINT NOT NULL,
    `Date` DATE NOT NULL,
    PRIMARY KEY(`transactionID`)
);

DROP table IF EXISTS `Goal`;
CREATE TABLE if NOT EXISTS `Goal` (
    `goal_ID` INT(3) NOT NULL AUTO_INCREMENT,
    `userID` INT(4) NOT NULL,
    `goalAmount` BIGINT NOT NULL,
    `Amount` BIGINT NOT NULL,
    `dateStarted` DATE NOT NULL,
    `dateFinished` DATE NOT NULL,
    `Duration` INT NOT NULL,PRIMARY KEY(`goal_ID`)
);

ALTER TABLE `budget` ADD CONSTRAINT `budget_categoryid_foreign` FOREIGN KEY(`categoryID`) REFERENCES `category`(`categoryID`);
ALTER TABLE `report` ADD CONSTRAINT `report_userid_foreign` FOREIGN KEY(`userID`) REFERENCES `user_info`(`userID`);
ALTER TABLE `budget` ADD CONSTRAINT `budget_userid_foreign` FOREIGN KEY(`userID`) REFERENCES `user_info`(`userID`);
ALTER TABLE `Goal` ADD CONSTRAINT `Goal_userid_foreign` FOREIGN KEY(`userID`) REFERENCES `user_info`(`userID`);
ALTER TABLE `transaction_info` ADD CONSTRAINT `transaction_info_categoryid_foreign` FOREIGN KEY(`categoryID`) REFERENCES `category`(`categoryID`);
ALTER TABLE `transaction_info` ADD CONSTRAINT `transaction_info_userid_foreign` FOREIGN KEY(`userID`) REFERENCES `user_info`(`userID`);

use finance_tracker;
 
ALTER TABLE category
ADD COLUMN description varchar(255);

ALTER TABLE category
ADD COLUMN parent_category_id varchar(255);

ALTER TABLE category
RENAME COLUMN categoryName TO name;

INSERT INTO Category (categoryID, name, description, parent_category_id)
VALUES ('C-001', 'Income', 'All sources of income', NULL);

INSERT INTO Category (categoryID, name, description, parent_category_id)
VALUES ('C-002', 'Expenses', 'All types of expenses', NULL);



INSERT INTO Category (categoryID, name, description, parent_category_id)
VALUES ('C-003', 'Salary', 'Regular salary income', 'C-001');

INSERT INTO Category (categoryID, name, description, parent_category_id)
VALUES ('C-004', 'Freelance Income', 'Income from freelance work', 'C-001');

INSERT INTO Category (categoryID, name, description, parent_category_id)
VALUES ('C-005', 'Rental Income', 'Income from property rentals', 'C-001');

INSERT INTO Category (categoryID, name, description, parent_category_id)
VALUES ('C-006', 'Investment Income', 'Income from investments', 'C-001');



INSERT INTO Category (categoryID, name, description, parent_category_id)
VALUES ('C-007', 'Housing', 'Expenses related to housing', 'C-002');

INSERT INTO Category (categoryID, name, description, parent_category_id)
VALUES ('C-008', 'Transportation', 'Expenses on transportation', 'C-002');

INSERT INTO Category (categoryID, name, description, parent_category_id)
VALUES ('C-009', 'Food and Dining', 'Expenses on food and dining', 'C-002');

INSERT INTO Category (categoryID, name, description, parent_category_id)
VALUES ('C-010', 'Entertainment', 'Expenses on entertainment', 'C-002');

INSERT INTO Category (categoryID, name, description, parent_category_id)
VALUES ('C-011', 'Shopping', 'Expenses on shopping', 'C-002');

INSERT INTO Category (categoryID, name, description, parent_category_id)
VALUES ('C-012', 'Health', 'Expenses on health', 'C-002');

INSERT INTO Category (categoryID, name, description, parent_category_id)
VALUES ('C-013', 'Debt Payments', 'Expenses on debt payments', 'C-002');

INSERT INTO Category (categoryID, name, description, parent_category_id)
VALUES ('C-014', 'Education', 'Expenses on education', 'C-002');


INSERT INTO Category (categoryID, name, description, parent_category_id)
VALUES ('C-015', 'Rent/Mortgage', 'Monthly rent or mortgage payments', 'C-007');

INSERT INTO Category (categoryID, name, description, parent_category_id)
VALUES ('C-016', 'Utilities', 'Expenses for utilities like electricity, water, etc.', 'C-007');

INSERT INTO Category (categoryID, name, description, parent_category_id)
VALUES ('C-017', 'Home Maintenance', 'Expenses for home maintenance and repairs', 'C-007');



INSERT INTO Category (categoryID, name, description, parent_category_id)
VALUES ('C-018', 'Fuel', 'Expenses on fuel', 'C-008');

INSERT INTO Category (categoryID, name, description, parent_category_id)
VALUES ('C-019', 'Vehicle Maintenance', 'Expenses for vehicle maintenance and repairs', 'C-008');

INSERT INTO Category (categoryID, name, description, parent_category_id)
VALUES ('C-020', 'Public Transportation', 'Expenses for public transportation', 'C-008');



INSERT INTO Category (categoryID, name, description, parent_category_id)
VALUES ('C-021', 'Groceries', 'Expenses on groceries', 'C-009');

INSERT INTO Category (categoryID, name, description, parent_category_id)
VALUES ('C-022', 'Restaurants', 'Expenses on dining at restaurants', 'C-009');

INSERT INTO Category (categoryID, name, description, parent_category_id)
VALUES ('C-023', 'Fast Food', 'Expenses on fast food', 'C-009');



INSERT INTO Category (categoryID, name, description, parent_category_id)
VALUES ('C-024', 'Movies', 'Expenses on movies', 'C-010');

INSERT INTO Category (categoryID, name, description, parent_category_id)
VALUES ('C-025', 'Concerts', 'Expenses on concerts', 'C-010');

INSERT INTO Category (categoryID, name, description, parent_category_id)
VALUES ('C-026', 'Sports Events', 'Expenses on sports events', 'C-010');



INSERT INTO Category (categoryID, name, description, parent_category_id)
VALUES ('C-027', 'Clothing', 'Expenses on clothing', 'C-011');

INSERT INTO Category (categoryID, name, description, parent_category_id)
VALUES ('C-028', 'Electronics', 'Expenses on electronics', 'C-011');

INSERT INTO Category (categoryID, name, description, parent_category_id)
VALUES ('C-029', 'Personal Care', 'Expenses on personal care items', 'C-011');



INSERT INTO Category (categoryID, name, description, parent_category_id)
VALUES ('C-030', 'Insurance', 'Expenses on insurance', 'C-012');

INSERT INTO Category (categoryID, name, description, parent_category_id)
VALUES ('C-031', 'Medical Expenses', 'Expenses on medical treatments and medications', 'C-012');

INSERT INTO Category (categoryID, name, description, parent_category_id)
VALUES ('C-032', 'Fitness', 'Expenses on fitness-related activities', 'C-012');

-- Inserting subcategories under "Debt Payments"

INSERT INTO Category (categoryID, name, description, parent_category_id)
VALUES ('C-033', 'Loans', 'Expenses on loan payments', 'C-013');

INSERT INTO Category (categoryID, name, description, parent_category_id)
VALUES ('C-034', 'Credit Cards', 'Expenses on credit card payments', 'C-013');


INSERT INTO Category (categoryID, name, description, parent_category_id)
VALUES ('C-035', 'Tuition Fees', 'Expenses on tuition fees', 'C-014');

INSERT INTO Category (categoryID, name, description, parent_category_id)
VALUES ('C-036', 'Books and Supplies', 'Expenses on books and supplies', 'C-014');

INSERT INTO Category (categoryID, name, description, parent_category_id)
VALUES ('C-037', 'Online Courses', 'Expenses on online courses', 'C-014');

SELECT * FROM Category WHERE parent_category_id = null and categoryID = 'C-001';
SELECT * FROM Category WHERE parent_category_id = 'C-002';
SELECT * FROM Category WHERE parent_category_id = 'C-003';
SELECT * FROM Category WHERE parent_category_id = 'C-004';
SELECT * FROM Category WHERE parent_category_id = 'C-005';
SELECT * FROM Category WHERE parent_category_id = 'C-006';
SELECT * FROM Category WHERE parent_category_id = 'C-007';
SELECT * FROM Category WHERE parent_category_id = 'C-008';
SELECT * FROM Category WHERE parent_category_id = 'C-009';
SELECT * FROM Category WHERE parent_category_id = 'C-010';

