CREATE USER 'hoteldb_user'@'localhost' IDENTIFIED BY 'spring';

GRANT ALL PRIVILEGES ON cs548_hotels.* TO 'hoteldb_user'@'localhost' WITH GRANT OPTION;

SHOW GRANTS FOR 'hoteldb_user'@'localhost';