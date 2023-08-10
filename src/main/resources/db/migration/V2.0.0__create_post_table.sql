CREATE TABLE author (
    id SERIAL PRIMARY KEY,
    name VARCHAR,
    nationality VARCHAR
);

CREATE TABLE post (
    id SERIAL PRIMARY KEY,
    message VARCHAR,
    authorId INTEGER NOT NULL REFERENCES author(id)
);
