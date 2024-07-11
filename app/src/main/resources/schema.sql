DROP TABLE IF EXISTS url_checks;
DROP TABLE IF EXISTS urls;


CREATE TABLE urls (
    ID  SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE url_checks (
    ID  SERIAL PRIMARY KEY,
    statusCode integer,
    title VARCHAR(255),
    h1 VARCHAR(255),
    description text,
    urlId bigint REFERENCES urls (ID),
    created_at TIMESTAMP NOT NULL
);