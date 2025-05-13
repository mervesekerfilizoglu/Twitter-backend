-- Kullanıcılar
INSERT INTO users (name, username, email, password) VALUES
('Ahmet Yılmaz', 'ahmet', 'ahmet@example.com', '$2a$10$xn3LI0jJ5HvqXZ7JQYzZQO5zv9JQYzZQO5zv9JQYzZQO5zv9JQYzZQO5zv9'),
('Mehmet Demir', 'mehmet', 'mehmet@example.com', '$2a$10$xn3LI0jJ5HvqXZ7JQYzZQO5zv9JQYzZQO5zv9JQYzZQO5zv9JQYzZQO5zv9');

-- Tweetler
INSERT INTO tweet (content, created_at, user_id) VALUES
('Merhaba dünya! Bu benim ilk tweetim.', '2023-05-01 10:00:00', 1),
('Bugün hava çok güzel!', '2023-05-02 14:30:00', 2);

-- Yorumlar
INSERT INTO comment (content, created_at, user_id, tweet_id) VALUES
('Harika bir tweet!', '2023-05-01 10:15:00', 2, 1),
('Katılıyorum, hava gerçekten güzel', '2023-05-02 15:00:00', 1, 2);

-- Beğeniler
INSERT INTO like_table (user_id, tweet_id) VALUES
(2, 1),
(1, 2);