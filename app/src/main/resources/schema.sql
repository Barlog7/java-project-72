DROP TABLE IF EXISTS url_checks;
DROP TABLE IF EXISTS urls;


CREATE TABLE urls (
    id  SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE url_checks (
    id  SERIAL PRIMARY KEY NOT NULL,
    statuscode integer NOT NULL,
    title VARCHAR(255),
    h1 VARCHAR(255),
    description text,
    url_id bigint REFERENCES urls (id),
    created_at TIMESTAMP NOT NULL
);