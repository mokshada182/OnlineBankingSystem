INSERT INTO users (username, password_hash, email) VALUES
('john_doe', 'hashed_password_1', 'john@example.com'),
('jane_smith', 'hashed_password_2', 'jane@example.com');

INSERT INTO accounts (user_id, account_number, balance) VALUES
(1, 'ACC123456', 1000.00),
(2, 'ACC654321', 1500.00);
