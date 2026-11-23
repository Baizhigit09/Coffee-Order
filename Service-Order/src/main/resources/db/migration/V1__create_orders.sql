CREATE TABLE orders (
                        id          BIGSERIAL PRIMARY KEY,
                        user_id     BIGINT         NOT NULL,          -- просто число, внешнего ключа нет: users в другой базе
                        status      VARCHAR(20)    NOT NULL DEFAULT 'CREATED',
                        total_price NUMERIC(12, 2) NOT NULL CHECK (total_price >= 0),
                        created_at  TIMESTAMP      NOT NULL DEFAULT now(),
                        updated_at  TIMESTAMP      NOT NULL DEFAULT now()
);

CREATE TABLE order_items (
                             id         BIGSERIAL PRIMARY KEY,
                             order_id   BIGINT         NOT NULL REFERENCES orders (id) ON DELETE CASCADE,
                             drink_id   BIGINT         NOT NULL,           -- id из Menu-service, тоже без FK
                             drink_name VARCHAR(150)   NOT NULL,           -- копия названия на момент заказа
                             unit_price NUMERIC(10, 2) NOT NULL CHECK (unit_price > 0),   -- копия цены на момент заказа
                             quantity   INTEGER        NOT NULL CHECK (quantity > 0)
);

CREATE INDEX idx_orders_user ON orders (user_id);
CREATE INDEX idx_order_items_order ON order_items (order_id);