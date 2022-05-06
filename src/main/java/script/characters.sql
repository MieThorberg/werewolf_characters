use werewolf_characters;
CREATE TABLE `characters`
(
    `name`        varchar(255) NOT NULL,
    `description` varchar(255) DEFAULT NULL,
    `image`       varchar(255) DEFAULT NULL,
    `minplayers`  int          DEFAULT NULL,
    `max`         int          DEFAULT NULL,
    `ability`     varchar(255) DEFAULT NULL,
    PRIMARY KEY (`name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

insert characters values ('Werewolf', 'description', '?', 0, 100, 'kill villagers');
insert characters values ('Villager', 'description', '?', 0, 100, 'none');