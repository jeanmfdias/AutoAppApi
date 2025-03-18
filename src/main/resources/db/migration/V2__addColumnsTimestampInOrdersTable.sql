ALTER TABLE orders ADD COLUMN updated_at TIMESTAMP;

ALTER TABLE order_items ADD COLUMN created_at TIMESTAMP;
ALTER TABLE order_items ADD COLUMN updated_at TIMESTAMP;