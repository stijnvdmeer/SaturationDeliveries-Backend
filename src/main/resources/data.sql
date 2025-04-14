insert into category(name)
VALUES ('Italians'),
('Mexicaans');

insert into sub_category(name)
Values ('Pastas'),
       ('Sausen'),
       ('Kruiden'),
       ('Wraps');

insert into products (calories, carbohydrates, fats, sugars, proteins, salts, name, price, stock, pending, category_id, sub_category_id)
VALUES
    (10, 4, 3, 4, 5, 5, 'Taco Kruiden', 1.12, 10, 0, 2, 3),
    (20, 4, 3, 4, 5, 1, 'Penne alle Ovu', 2, 5, 1, 1, 1),
    (25, 1,2,3,4,5, 'Penne', 1, 5, 3, 1, 1)