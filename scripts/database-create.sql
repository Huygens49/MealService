-- Database: meals_dev

-- DROP DATABASE meals_dev;

CREATE DATABASE meals_dev
    WITH
    OWNER = huygens
    ENCODING = 'UTF8'
    LC_COLLATE = 'en_US.UTF-8'
    LC_CTYPE = 'en_US.UTF-8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

ALTER DATABASE meals_dev
    SET search_path TO meals;