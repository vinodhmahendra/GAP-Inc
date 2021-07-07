DROP TABLE IF EXISTS customers ;

CREATE TABLE customers (
  id INT NOT NULL,
  firstname VARCHAR(200) NULL,
  lastname VARCHAR(200) NULL,
  email VARCHAR(200) NULL,
  PRIMARY KEY (`id`));