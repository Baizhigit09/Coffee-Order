CREATE TABLE categories (
                            id   BIGSERIAL PRIMARY KEY,
                            name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE drinks (
                        id          BIGSERIAL PRIMARY KEY,
                        name        VARCHAR(150)   NOT NULL,
                        description VARCHAR(500),
                        price       NUMERIC(10, 2) NOT NULL CHECK (price > 0),
                        available   BOOLEAN        NOT NULL DEFAULT TRUE,
                        category_id BIGINT         NOT NULL REFERENCES categories (id),
                        created_at  TIMESTAMP      NOT NULL DEFAULT now()
);

CREATE INDEX idx_drinks_category ON drinks (category_id);