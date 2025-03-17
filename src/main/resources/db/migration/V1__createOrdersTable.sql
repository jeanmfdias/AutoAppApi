CREATE TABLE orders (
    id BIGSERIAL PRIMARY KEY,
    odometer FLOAT NOT NULL,
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE order_items (
    id BIGSERIAL PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    type VARCHAR(100) NOT NULL,
    value FLOAT NOT NULL,
    order_id BIGSERIAL NOT NULL,

    CONSTRAINT fk_order_items_order FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE
);