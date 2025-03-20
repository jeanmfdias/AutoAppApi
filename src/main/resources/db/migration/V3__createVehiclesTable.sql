CREATE TABLE vehicles (
    id BIGSERIAL PRIMARY KEY,
    brand VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    factory_year INTEGER NOT NULL,
    model_year INTEGER NOT NULL,
    acquired_price FLOAT NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

ALTER TABLE orders ADD COLUMN vehicle_id BIGSERIAL;
ALTER TABLE orders ADD CONSTRAINT fk_vehicle_id_orders FOREIGN KEY (vehicle_id) REFERENCES vehicles(id) ON DELETE SET NULL;