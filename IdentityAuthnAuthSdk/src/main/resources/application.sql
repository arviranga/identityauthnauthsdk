CREATE TABLE APPLICATION
(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (id),
    app_name TINYTEXT NOT NULL,
    description TEXT NULL,
    active TINYTEXT NOT NULL,
    time_create DATETIME,
    time_modified DATETIME
);
