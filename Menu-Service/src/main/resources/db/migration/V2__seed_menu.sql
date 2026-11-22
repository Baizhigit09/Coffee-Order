INSERT INTO categories (name) VALUES ('Кофе'), ('Чай'), ('Десерты');

INSERT INTO drinks (name, description, price, category_id) VALUES
                                                               ('Эспрессо',    'Классический крепкий кофе',  800.00, (SELECT id FROM categories WHERE name = 'Кофе')),
                                                               ('Капучино',    'Эспрессо с молочной пеной', 1300.00, (SELECT id FROM categories WHERE name = 'Кофе')),
                                                               ('Латте',       'Мягкий кофе с молоком',     1400.00, (SELECT id FROM categories WHERE name = 'Кофе')),
                                                               ('Чёрный чай',  'Цейлонский чай',             700.00, (SELECT id FROM categories WHERE name = 'Чай')),
                                                               ('Зелёный чай', 'Китайский листовой чай',     700.00, (SELECT id FROM categories WHERE name = 'Чай')),
                                                               ('Чизкейк',     'Нью-Йоркский чизкейк',      1600.00, (SELECT id FROM categories WHERE name = 'Десерты'));