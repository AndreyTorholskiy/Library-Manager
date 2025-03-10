-- Додавання книг
INSERT INTO books (title, author, genre, available) VALUES
('1984', 'George Orwell', 'Dystopian', true),
('Brave New World', 'Aldous Huxley', 'Science Fiction', true),
('The Catcher in the Rye', 'J.D. Salinger', 'Classic', true);

-- Додавання читачів
INSERT INTO readers (name, email) VALUES
('John Doe', 'john@example.com'),
('Jane Smith', 'jane@example.com');

-- Додавання оренд (John Doe бере "1984")
INSERT INTO rents (book_id, reader_id, rent_date, return_date) VALUES
(1, 1, '2025-03-10', NULL);