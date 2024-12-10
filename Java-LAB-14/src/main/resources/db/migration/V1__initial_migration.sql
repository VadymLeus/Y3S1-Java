USE todo;

CREATE TABLE IF NOT EXISTS todo_items (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(255),
    `is_completed` TINYINT(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
