CREATE TABLE domain_CONFIG
(
    domain_id INT UNSIGNED NOT NULL,
    config_name TINYTEXT NOT NULL,
    config_value TEXT NOT NULL,
    array_index INT,
    description TINYTEXT NULL,
    active TINYTEXT NOT NULL,
    time_create DATETIME,
    time_modified DATETIME
);

