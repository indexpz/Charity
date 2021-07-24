CREATE
DATABASE IF NOT EXISTS charity_donation CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

INSERT INTO 'donations' ('name', 'quantity')
VALUES  ('Pierwsza', 1),
        ('Druga', 2),
        ('Trzecia', 3);

drop database charity_donation;