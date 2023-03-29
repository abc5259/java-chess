CREATE TABLE chess_position
(
    id     BIGINT       NOT NULL AUTO_INCREMENT,
    file   CHAR(1)      NOT NULL,
    `rank` CHAR(1)      NOT NULL,
    piece  VARCHAR(255) NOT NULL,
    team   VARCHAR(255) NOT NULL,
    UNIQUE (file, `rank`, piece, team),
    PRIMARY KEY (id)
);

CREATE TABLE chess_game
(
    id   BIGINT       NOT NULL AUTO_INCREMENT,
    turn VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE move_log
(
    id                 BIGINT NOT NULL AUTO_INCREMENT,
    chess_game_id      BIGINT NOT NULL,
    source_position_id BIGINT NOT NULL,
    target_position_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (chess_game_id) REFERENCES chess_game (id),
    FOREIGN KEY (source_position_id) REFERENCES chess_position (id),
    FOREIGN KEY (target_position_id) REFERENCES chess_position (id)
);

CREATE TABLE player
(
    id   BIGINT       NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE chess_room
(
    id            BIGINT       NOT NULL AUTO_INCREMENT,
    chess_game_id BIGINT       NOT NULL,
    player_id     BIGINT       NOT NULL,
    state         VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (chess_game_id) REFERENCES chess_game (id),
    FOREIGN KEY (player_id) REFERENCES player (id)
);

INSERT INTO chess_position (file, `rank`, piece, team)
VALUES ('a', '1', 'EMPTY', 'NONE'),
       ('a', '2', 'EMPTY', 'NONE'),
       ('a', '3', 'EMPTY', 'NONE'),
       ('a', '4', 'EMPTY', 'NONE'),
       ('a', '5', 'EMPTY', 'NONE'),
       ('a', '6', 'EMPTY', 'NONE'),
       ('a', '7', 'EMPTY', 'NONE'),
       ('a', '8', 'EMPTY', 'NONE'),
       ('b', '1', 'EMPTY', 'NONE'),
       ('b', '2', 'EMPTY', 'NONE'),
       ('b', '3', 'EMPTY', 'NONE'),
       ('b', '4', 'EMPTY', 'NONE'),
       ('b', '5', 'EMPTY', 'NONE'),
       ('b', '6', 'EMPTY', 'NONE'),
       ('b', '7', 'EMPTY', 'NONE'),
       ('b', '8', 'EMPTY', 'NONE'),
       ('c', '1', 'EMPTY', 'NONE'),
       ('c', '2', 'EMPTY', 'NONE'),
       ('c', '3', 'EMPTY', 'NONE'),
       ('c', '4', 'EMPTY', 'NONE'),
       ('c', '5', 'EMPTY', 'NONE'),
       ('c', '6', 'EMPTY', 'NONE'),
       ('c', '7', 'EMPTY', 'NONE'),
       ('c', '8', 'EMPTY', 'NONE'),
       ('d', '1', 'EMPTY', 'NONE'),
       ('d', '2', 'EMPTY', 'NONE'),
       ('d', '3', 'EMPTY', 'NONE'),
       ('d', '4', 'EMPTY', 'NONE'),
       ('d', '5', 'EMPTY', 'NONE'),
       ('d', '6', 'EMPTY', 'NONE'),
       ('d', '7', 'EMPTY', 'NONE'),
       ('d', '8', 'EMPTY', 'NONE'),
       ('e', '1', 'EMPTY', 'NONE'),
       ('e', '2', 'EMPTY', 'NONE'),
       ('e', '3', 'EMPTY', 'NONE'),
       ('e', '4', 'EMPTY', 'NONE'),
       ('e', '5', 'EMPTY', 'NONE'),
       ('e', '6', 'EMPTY', 'NONE'),
       ('e', '7', 'EMPTY', 'NONE'),
       ('e', '8', 'EMPTY', 'NONE'),
       ('f', '1', 'EMPTY', 'NONE'),
       ('f', '2', 'EMPTY', 'NONE'),
       ('f', '3', 'EMPTY', 'NONE'),
       ('f', '4', 'EMPTY', 'NONE'),
       ('f', '5', 'EMPTY', 'NONE'),
       ('f', '6', 'EMPTY', 'NONE'),
       ('f', '7', 'EMPTY', 'NONE'),
       ('f', '8', 'EMPTY', 'NONE'),
       ('g', '1', 'EMPTY', 'NONE'),
       ('g', '2', 'EMPTY', 'NONE'),
       ('g', '3', 'EMPTY', 'NONE'),
       ('g', '4', 'EMPTY', 'NONE'),
       ('g', '5', 'EMPTY', 'NONE'),
       ('g', '6', 'EMPTY', 'NONE'),
       ('g', '7', 'EMPTY', 'NONE'),
       ('g', '8', 'EMPTY', 'NONE'),
       ('h', '1', 'EMPTY', 'NONE'),
       ('h', '2', 'EMPTY', 'NONE'),
       ('h', '3', 'EMPTY', 'NONE'),
       ('h', '4', 'EMPTY', 'NONE'),
       ('h', '5', 'EMPTY', 'NONE'),
       ('h', '6', 'EMPTY', 'NONE'),
       ('h', '7', 'EMPTY', 'NONE'),
       ('h', '8', 'EMPTY', 'NONE');

INSERT INTO chess_position (file, `rank`, piece, team)
VALUES ('a', '1', 'KING', 'WHITE'),
       ('a', '2', 'KING', 'WHITE'),
       ('a', '3', 'KING', 'WHITE'),
       ('a', '4', 'KING', 'WHITE'),
       ('a', '5', 'KING', 'WHITE'),
       ('a', '6', 'KING', 'WHITE'),
       ('a', '7', 'KING', 'WHITE'),
       ('a', '8', 'KING', 'WHITE'),
       ('b', '1', 'KING', 'WHITE'),
       ('b', '2', 'KING', 'WHITE'),
       ('b', '3', 'KING', 'WHITE'),
       ('b', '4', 'KING', 'WHITE'),
       ('b', '5', 'KING', 'WHITE'),
       ('b', '6', 'KING', 'WHITE'),
       ('b', '7', 'KING', 'WHITE'),
       ('b', '8', 'KING', 'WHITE'),
       ('c', '1', 'KING', 'WHITE'),
       ('c', '2', 'KING', 'WHITE'),
       ('c', '3', 'KING', 'WHITE'),
       ('c', '4', 'KING', 'WHITE'),
       ('c', '5', 'KING', 'WHITE'),
       ('c', '6', 'KING', 'WHITE'),
       ('c', '7', 'KING', 'WHITE'),
       ('c', '8', 'KING', 'WHITE'),
       ('d', '1', 'KING', 'WHITE'),
       ('d', '2', 'KING', 'WHITE'),
       ('d', '3', 'KING', 'WHITE'),
       ('d', '4', 'KING', 'WHITE'),
       ('d', '5', 'KING', 'WHITE'),
       ('d', '6', 'KING', 'WHITE'),
       ('d', '7', 'KING', 'WHITE'),
       ('d', '8', 'KING', 'WHITE'),
       ('e', '1', 'KING', 'WHITE'),
       ('e', '2', 'KING', 'WHITE'),
       ('e', '3', 'KING', 'WHITE'),
       ('e', '4', 'KING', 'WHITE'),
       ('e', '5', 'KING', 'WHITE'),
       ('e', '6', 'KING', 'WHITE'),
       ('e', '7', 'KING', 'WHITE'),
       ('e', '8', 'KING', 'WHITE'),
       ('f', '1', 'KING', 'WHITE'),
       ('f', '2', 'KING', 'WHITE'),
       ('f', '3', 'KING', 'WHITE'),
       ('f', '4', 'KING', 'WHITE'),
       ('f', '5', 'KING', 'WHITE'),
       ('f', '6', 'KING', 'WHITE'),
       ('f', '7', 'KING', 'WHITE'),
       ('f', '8', 'KING', 'WHITE'),
       ('g', '1', 'KING', 'WHITE'),
       ('g', '2', 'KING', 'WHITE'),
       ('g', '3', 'KING', 'WHITE'),
       ('g', '4', 'KING', 'WHITE'),
       ('g', '5', 'KING', 'WHITE'),
       ('g', '6', 'KING', 'WHITE'),
       ('g', '7', 'KING', 'WHITE'),
       ('g', '8', 'KING', 'WHITE'),
       ('h', '1', 'KING', 'WHITE'),
       ('h', '2', 'KING', 'WHITE'),
       ('h', '3', 'KING', 'WHITE'),
       ('h', '4', 'KING', 'WHITE'),
       ('h', '5', 'KING', 'WHITE'),
       ('h', '6', 'KING', 'WHITE'),
       ('h', '7', 'KING', 'WHITE'),
       ('h', '8', 'KING', 'WHITE');

INSERT INTO chess_position (file, `rank`, piece, team)
VALUES ('a', '1', 'KING', 'BLACK'),
       ('a', '2', 'KING', 'BLACK'),
       ('a', '3', 'KING', 'BLACK'),
       ('a', '4', 'KING', 'BLACK'),
       ('a', '5', 'KING', 'BLACK'),
       ('a', '6', 'KING', 'BLACK'),
       ('a', '7', 'KING', 'BLACK'),
       ('a', '8', 'KING', 'BLACK'),
       ('b', '1', 'KING', 'BLACK'),
       ('b', '2', 'KING', 'BLACK'),
       ('b', '3', 'KING', 'BLACK'),
       ('b', '4', 'KING', 'BLACK'),
       ('b', '5', 'KING', 'BLACK'),
       ('b', '6', 'KING', 'BLACK'),
       ('b', '7', 'KING', 'BLACK'),
       ('b', '8', 'KING', 'BLACK'),
       ('c', '1', 'KING', 'BLACK'),
       ('c', '2', 'KING', 'BLACK'),
       ('c', '3', 'KING', 'BLACK'),
       ('c', '4', 'KING', 'BLACK'),
       ('c', '5', 'KING', 'BLACK'),
       ('c', '6', 'KING', 'BLACK'),
       ('c', '7', 'KING', 'BLACK'),
       ('c', '8', 'KING', 'BLACK'),
       ('d', '1', 'KING', 'BLACK'),
       ('d', '2', 'KING', 'BLACK'),
       ('d', '3', 'KING', 'BLACK'),
       ('d', '4', 'KING', 'BLACK'),
       ('d', '5', 'KING', 'BLACK'),
       ('d', '6', 'KING', 'BLACK'),
       ('d', '7', 'KING', 'BLACK'),
       ('d', '8', 'KING', 'BLACK'),
       ('e', '1', 'KING', 'BLACK'),
       ('e', '2', 'KING', 'BLACK'),
       ('e', '3', 'KING', 'BLACK'),
       ('e', '4', 'KING', 'BLACK'),
       ('e', '5', 'KING', 'BLACK'),
       ('e', '6', 'KING', 'BLACK'),
       ('e', '7', 'KING', 'BLACK'),
       ('e', '8', 'KING', 'BLACK'),
       ('f', '1', 'KING', 'BLACK'),
       ('f', '2', 'KING', 'BLACK'),
       ('f', '3', 'KING', 'BLACK'),
       ('f', '4', 'KING', 'BLACK'),
       ('f', '5', 'KING', 'BLACK'),
       ('f', '6', 'KING', 'BLACK'),
       ('f', '7', 'KING', 'BLACK'),
       ('f', '8', 'KING', 'BLACK'),
       ('g', '1', 'KING', 'BLACK'),
       ('g', '2', 'KING', 'BLACK'),
       ('g', '3', 'KING', 'BLACK'),
       ('g', '4', 'KING', 'BLACK'),
       ('g', '5', 'KING', 'BLACK'),
       ('g', '6', 'KING', 'BLACK'),
       ('g', '7', 'KING', 'BLACK'),
       ('g', '8', 'KING', 'BLACK'),
       ('h', '1', 'KING', 'BLACK'),
       ('h', '2', 'KING', 'BLACK'),
       ('h', '3', 'KING', 'BLACK'),
       ('h', '4', 'KING', 'BLACK'),
       ('h', '5', 'KING', 'BLACK'),
       ('h', '6', 'KING', 'BLACK'),
       ('h', '7', 'KING', 'BLACK'),
       ('h', '8', 'KING', 'BLACK');

INSERT INTO chess_position (file, `rank`, piece, team)
VALUES ('a', '1', 'QUEEN', 'WHITE'),
       ('a', '2', 'QUEEN', 'WHITE'),
       ('a', '3', 'QUEEN', 'WHITE'),
       ('a', '4', 'QUEEN', 'WHITE'),
       ('a', '5', 'QUEEN', 'WHITE'),
       ('a', '6', 'QUEEN', 'WHITE'),
       ('a', '7', 'QUEEN', 'WHITE'),
       ('a', '8', 'QUEEN', 'WHITE'),
       ('b', '1', 'QUEEN', 'WHITE'),
       ('b', '2', 'QUEEN', 'WHITE'),
       ('b', '3', 'QUEEN', 'WHITE'),
       ('b', '4', 'QUEEN', 'WHITE'),
       ('b', '5', 'QUEEN', 'WHITE'),
       ('b', '6', 'QUEEN', 'WHITE'),
       ('b', '7', 'QUEEN', 'WHITE'),
       ('b', '8', 'QUEEN', 'WHITE'),
       ('c', '1', 'QUEEN', 'WHITE'),
       ('c', '2', 'QUEEN', 'WHITE'),
       ('c', '3', 'QUEEN', 'WHITE'),
       ('c', '4', 'QUEEN', 'WHITE'),
       ('c', '5', 'QUEEN', 'WHITE'),
       ('c', '6', 'QUEEN', 'WHITE'),
       ('c', '7', 'QUEEN', 'WHITE'),
       ('c', '8', 'QUEEN', 'WHITE'),
       ('d', '1', 'QUEEN', 'WHITE'),
       ('d', '2', 'QUEEN', 'WHITE'),
       ('d', '3', 'QUEEN', 'WHITE'),
       ('d', '4', 'QUEEN', 'WHITE'),
       ('d', '5', 'QUEEN', 'WHITE'),
       ('d', '6', 'QUEEN', 'WHITE'),
       ('d', '7', 'QUEEN', 'WHITE'),
       ('d', '8', 'QUEEN', 'WHITE'),
       ('e', '1', 'QUEEN', 'WHITE'),
       ('e', '2', 'QUEEN', 'WHITE'),
       ('e', '3', 'QUEEN', 'WHITE'),
       ('e', '4', 'QUEEN', 'WHITE'),
       ('e', '5', 'QUEEN', 'WHITE'),
       ('e', '6', 'QUEEN', 'WHITE'),
       ('e', '7', 'QUEEN', 'WHITE'),
       ('e', '8', 'QUEEN', 'WHITE'),
       ('f', '1', 'QUEEN', 'WHITE'),
       ('f', '2', 'QUEEN', 'WHITE'),
       ('f', '3', 'QUEEN', 'WHITE'),
       ('f', '4', 'QUEEN', 'WHITE'),
       ('f', '5', 'QUEEN', 'WHITE'),
       ('f', '6', 'QUEEN', 'WHITE'),
       ('f', '7', 'QUEEN', 'WHITE'),
       ('f', '8', 'QUEEN', 'WHITE'),
       ('g', '1', 'QUEEN', 'WHITE'),
       ('g', '2', 'QUEEN', 'WHITE'),
       ('g', '3', 'QUEEN', 'WHITE'),
       ('g', '4', 'QUEEN', 'WHITE'),
       ('g', '5', 'QUEEN', 'WHITE'),
       ('g', '6', 'QUEEN', 'WHITE'),
       ('g', '7', 'QUEEN', 'WHITE'),
       ('g', '8', 'QUEEN', 'WHITE'),
       ('h', '1', 'QUEEN', 'WHITE'),
       ('h', '2', 'QUEEN', 'WHITE'),
       ('h', '3', 'QUEEN', 'WHITE'),
       ('h', '4', 'QUEEN', 'WHITE'),
       ('h', '5', 'QUEEN', 'WHITE'),
       ('h', '6', 'QUEEN', 'WHITE'),
       ('h', '7', 'QUEEN', 'WHITE'),
       ('h', '8', 'QUEEN', 'WHITE');

INSERT INTO chess_position (file, `rank`, piece, team)
VALUES ('a', '1', 'QUEEN', 'BLACK'),
       ('a', '2', 'QUEEN', 'BLACK'),
       ('a', '3', 'QUEEN', 'BLACK'),
       ('a', '4', 'QUEEN', 'BLACK'),
       ('a', '5', 'QUEEN', 'BLACK'),
       ('a', '6', 'QUEEN', 'BLACK'),
       ('a', '7', 'QUEEN', 'BLACK'),
       ('a', '8', 'QUEEN', 'BLACK'),
       ('b', '1', 'QUEEN', 'BLACK'),
       ('b', '2', 'QUEEN', 'BLACK'),
       ('b', '3', 'QUEEN', 'BLACK'),
       ('b', '4', 'QUEEN', 'BLACK'),
       ('b', '5', 'QUEEN', 'BLACK'),
       ('b', '6', 'QUEEN', 'BLACK'),
       ('b', '7', 'QUEEN', 'BLACK'),
       ('b', '8', 'QUEEN', 'BLACK'),
       ('c', '1', 'QUEEN', 'BLACK'),
       ('c', '2', 'QUEEN', 'BLACK'),
       ('c', '3', 'QUEEN', 'BLACK'),
       ('c', '4', 'QUEEN', 'BLACK'),
       ('c', '5', 'QUEEN', 'BLACK'),
       ('c', '6', 'QUEEN', 'BLACK'),
       ('c', '7', 'QUEEN', 'BLACK'),
       ('c', '8', 'QUEEN', 'BLACK'),
       ('d', '1', 'QUEEN', 'BLACK'),
       ('d', '2', 'QUEEN', 'BLACK'),
       ('d', '3', 'QUEEN', 'BLACK'),
       ('d', '4', 'QUEEN', 'BLACK'),
       ('d', '5', 'QUEEN', 'BLACK'),
       ('d', '6', 'QUEEN', 'BLACK'),
       ('d', '7', 'QUEEN', 'BLACK'),
       ('d', '8', 'QUEEN', 'BLACK'),
       ('e', '1', 'QUEEN', 'BLACK'),
       ('e', '2', 'QUEEN', 'BLACK'),
       ('e', '3', 'QUEEN', 'BLACK'),
       ('e', '4', 'QUEEN', 'BLACK'),
       ('e', '5', 'QUEEN', 'BLACK'),
       ('e', '6', 'QUEEN', 'BLACK'),
       ('e', '7', 'QUEEN', 'BLACK'),
       ('e', '8', 'QUEEN', 'BLACK'),
       ('f', '1', 'QUEEN', 'BLACK'),
       ('f', '2', 'QUEEN', 'BLACK'),
       ('f', '3', 'QUEEN', 'BLACK'),
       ('f', '4', 'QUEEN', 'BLACK'),
       ('f', '5', 'QUEEN', 'BLACK'),
       ('f', '6', 'QUEEN', 'BLACK'),
       ('f', '7', 'QUEEN', 'BLACK'),
       ('f', '8', 'QUEEN', 'BLACK'),
       ('g', '1', 'QUEEN', 'BLACK'),
       ('g', '2', 'QUEEN', 'BLACK'),
       ('g', '3', 'QUEEN', 'BLACK'),
       ('g', '4', 'QUEEN', 'BLACK'),
       ('g', '5', 'QUEEN', 'BLACK'),
       ('g', '6', 'QUEEN', 'BLACK'),
       ('g', '7', 'QUEEN', 'BLACK'),
       ('g', '8', 'QUEEN', 'BLACK'),
       ('h', '1', 'QUEEN', 'BLACK'),
       ('h', '2', 'QUEEN', 'BLACK'),
       ('h', '3', 'QUEEN', 'BLACK'),
       ('h', '4', 'QUEEN', 'BLACK'),
       ('h', '5', 'QUEEN', 'BLACK'),
       ('h', '6', 'QUEEN', 'BLACK'),
       ('h', '7', 'QUEEN', 'BLACK'),
       ('h', '8', 'QUEEN', 'BLACK');

INSERT INTO chess_position (file, `rank`, piece, team)
VALUES ('a', '1', 'KNIGHT', 'WHITE'),
       ('a', '2', 'KNIGHT', 'WHITE'),
       ('a', '3', 'KNIGHT', 'WHITE'),
       ('a', '4', 'KNIGHT', 'WHITE'),
       ('a', '5', 'KNIGHT', 'WHITE'),
       ('a', '6', 'KNIGHT', 'WHITE'),
       ('a', '7', 'KNIGHT', 'WHITE'),
       ('a', '8', 'KNIGHT', 'WHITE'),
       ('b', '1', 'KNIGHT', 'WHITE'),
       ('b', '2', 'KNIGHT', 'WHITE'),
       ('b', '3', 'KNIGHT', 'WHITE'),
       ('b', '4', 'KNIGHT', 'WHITE'),
       ('b', '5', 'KNIGHT', 'WHITE'),
       ('b', '6', 'KNIGHT', 'WHITE'),
       ('b', '7', 'KNIGHT', 'WHITE'),
       ('b', '8', 'KNIGHT', 'WHITE'),
       ('c', '1', 'KNIGHT', 'WHITE'),
       ('c', '2', 'KNIGHT', 'WHITE'),
       ('c', '3', 'KNIGHT', 'WHITE'),
       ('c', '4', 'KNIGHT', 'WHITE'),
       ('c', '5', 'KNIGHT', 'WHITE'),
       ('c', '6', 'KNIGHT', 'WHITE'),
       ('c', '7', 'KNIGHT', 'WHITE'),
       ('c', '8', 'KNIGHT', 'WHITE'),
       ('d', '1', 'KNIGHT', 'WHITE'),
       ('d', '2', 'KNIGHT', 'WHITE'),
       ('d', '3', 'KNIGHT', 'WHITE'),
       ('d', '4', 'KNIGHT', 'WHITE'),
       ('d', '5', 'KNIGHT', 'WHITE'),
       ('d', '6', 'KNIGHT', 'WHITE'),
       ('d', '7', 'KNIGHT', 'WHITE'),
       ('d', '8', 'KNIGHT', 'WHITE'),
       ('e', '1', 'KNIGHT', 'WHITE'),
       ('e', '2', 'KNIGHT', 'WHITE'),
       ('e', '3', 'KNIGHT', 'WHITE'),
       ('e', '4', 'KNIGHT', 'WHITE'),
       ('e', '5', 'KNIGHT', 'WHITE'),
       ('e', '6', 'KNIGHT', 'WHITE'),
       ('e', '7', 'KNIGHT', 'WHITE'),
       ('e', '8', 'KNIGHT', 'WHITE'),
       ('f', '1', 'KNIGHT', 'WHITE'),
       ('f', '2', 'KNIGHT', 'WHITE'),
       ('f', '3', 'KNIGHT', 'WHITE'),
       ('f', '4', 'KNIGHT', 'WHITE'),
       ('f', '5', 'KNIGHT', 'WHITE'),
       ('f', '6', 'KNIGHT', 'WHITE'),
       ('f', '7', 'KNIGHT', 'WHITE'),
       ('f', '8', 'KNIGHT', 'WHITE'),
       ('g', '1', 'KNIGHT', 'WHITE'),
       ('g', '2', 'KNIGHT', 'WHITE'),
       ('g', '3', 'KNIGHT', 'WHITE'),
       ('g', '4', 'KNIGHT', 'WHITE'),
       ('g', '5', 'KNIGHT', 'WHITE'),
       ('g', '6', 'KNIGHT', 'WHITE'),
       ('g', '7', 'KNIGHT', 'WHITE'),
       ('g', '8', 'KNIGHT', 'WHITE'),
       ('h', '1', 'KNIGHT', 'WHITE'),
       ('h', '2', 'KNIGHT', 'WHITE'),
       ('h', '3', 'KNIGHT', 'WHITE'),
       ('h', '4', 'KNIGHT', 'WHITE'),
       ('h', '5', 'KNIGHT', 'WHITE'),
       ('h', '6', 'KNIGHT', 'WHITE'),
       ('h', '7', 'KNIGHT', 'WHITE'),
       ('h', '8', 'KNIGHT', 'WHITE');

INSERT INTO chess_position (file, `rank`, piece, team)
VALUES ('a', '1', 'KNIGHT', 'BLACK'),
       ('a', '2', 'KNIGHT', 'BLACK'),
       ('a', '3', 'KNIGHT', 'BLACK'),
       ('a', '4', 'KNIGHT', 'BLACK'),
       ('a', '5', 'KNIGHT', 'BLACK'),
       ('a', '6', 'KNIGHT', 'BLACK'),
       ('a', '7', 'KNIGHT', 'BLACK'),
       ('a', '8', 'KNIGHT', 'BLACK'),
       ('b', '1', 'KNIGHT', 'BLACK'),
       ('b', '2', 'KNIGHT', 'BLACK'),
       ('b', '3', 'KNIGHT', 'BLACK'),
       ('b', '4', 'KNIGHT', 'BLACK'),
       ('b', '5', 'KNIGHT', 'BLACK'),
       ('b', '6', 'KNIGHT', 'BLACK'),
       ('b', '7', 'KNIGHT', 'BLACK'),
       ('b', '8', 'KNIGHT', 'BLACK'),
       ('c', '1', 'KNIGHT', 'BLACK'),
       ('c', '2', 'KNIGHT', 'BLACK'),
       ('c', '3', 'KNIGHT', 'BLACK'),
       ('c', '4', 'KNIGHT', 'BLACK'),
       ('c', '5', 'KNIGHT', 'BLACK'),
       ('c', '6', 'KNIGHT', 'BLACK'),
       ('c', '7', 'KNIGHT', 'BLACK'),
       ('c', '8', 'KNIGHT', 'BLACK'),
       ('d', '1', 'KNIGHT', 'BLACK'),
       ('d', '2', 'KNIGHT', 'BLACK'),
       ('d', '3', 'KNIGHT', 'BLACK'),
       ('d', '4', 'KNIGHT', 'BLACK'),
       ('d', '5', 'KNIGHT', 'BLACK'),
       ('d', '6', 'KNIGHT', 'BLACK'),
       ('d', '7', 'KNIGHT', 'BLACK'),
       ('d', '8', 'KNIGHT', 'BLACK'),
       ('e', '1', 'KNIGHT', 'BLACK'),
       ('e', '2', 'KNIGHT', 'BLACK'),
       ('e', '3', 'KNIGHT', 'BLACK'),
       ('e', '4', 'KNIGHT', 'BLACK'),
       ('e', '5', 'KNIGHT', 'BLACK'),
       ('e', '6', 'KNIGHT', 'BLACK'),
       ('e', '7', 'KNIGHT', 'BLACK'),
       ('e', '8', 'KNIGHT', 'BLACK'),
       ('f', '1', 'KNIGHT', 'BLACK'),
       ('f', '2', 'KNIGHT', 'BLACK'),
       ('f', '3', 'KNIGHT', 'BLACK'),
       ('f', '4', 'KNIGHT', 'BLACK'),
       ('f', '5', 'KNIGHT', 'BLACK'),
       ('f', '6', 'KNIGHT', 'BLACK'),
       ('f', '7', 'KNIGHT', 'BLACK'),
       ('f', '8', 'KNIGHT', 'BLACK'),
       ('g', '1', 'KNIGHT', 'BLACK'),
       ('g', '2', 'KNIGHT', 'BLACK'),
       ('g', '3', 'KNIGHT', 'BLACK'),
       ('g', '4', 'KNIGHT', 'BLACK'),
       ('g', '5', 'KNIGHT', 'BLACK'),
       ('g', '6', 'KNIGHT', 'BLACK'),
       ('g', '7', 'KNIGHT', 'BLACK'),
       ('g', '8', 'KNIGHT', 'BLACK'),
       ('h', '1', 'KNIGHT', 'BLACK'),
       ('h', '2', 'KNIGHT', 'BLACK'),
       ('h', '3', 'KNIGHT', 'BLACK'),
       ('h', '4', 'KNIGHT', 'BLACK'),
       ('h', '5', 'KNIGHT', 'BLACK'),
       ('h', '6', 'KNIGHT', 'BLACK'),
       ('h', '7', 'KNIGHT', 'BLACK'),
       ('h', '8', 'KNIGHT', 'BLACK');

INSERT INTO chess_position (file, `rank`, piece, team)
VALUES ('a', '1', 'BISHOP', 'WHITE'),
       ('a', '2', 'BISHOP', 'WHITE'),
       ('a', '3', 'BISHOP', 'WHITE'),
       ('a', '4', 'BISHOP', 'WHITE'),
       ('a', '5', 'BISHOP', 'WHITE'),
       ('a', '6', 'BISHOP', 'WHITE'),
       ('a', '7', 'BISHOP', 'WHITE'),
       ('a', '8', 'BISHOP', 'WHITE'),
       ('b', '1', 'BISHOP', 'WHITE'),
       ('b', '2', 'BISHOP', 'WHITE'),
       ('b', '3', 'BISHOP', 'WHITE'),
       ('b', '4', 'BISHOP', 'WHITE'),
       ('b', '5', 'BISHOP', 'WHITE'),
       ('b', '6', 'BISHOP', 'WHITE'),
       ('b', '7', 'BISHOP', 'WHITE'),
       ('b', '8', 'BISHOP', 'WHITE'),
       ('c', '1', 'BISHOP', 'WHITE'),
       ('c', '2', 'BISHOP', 'WHITE'),
       ('c', '3', 'BISHOP', 'WHITE'),
       ('c', '4', 'BISHOP', 'WHITE'),
       ('c', '5', 'BISHOP', 'WHITE'),
       ('c', '6', 'BISHOP', 'WHITE'),
       ('c', '7', 'BISHOP', 'WHITE'),
       ('c', '8', 'BISHOP', 'WHITE'),
       ('d', '1', 'BISHOP', 'WHITE'),
       ('d', '2', 'BISHOP', 'WHITE'),
       ('d', '3', 'BISHOP', 'WHITE'),
       ('d', '4', 'BISHOP', 'WHITE'),
       ('d', '5', 'BISHOP', 'WHITE'),
       ('d', '6', 'BISHOP', 'WHITE'),
       ('d', '7', 'BISHOP', 'WHITE'),
       ('d', '8', 'BISHOP', 'WHITE'),
       ('e', '1', 'BISHOP', 'WHITE'),
       ('e', '2', 'BISHOP', 'WHITE'),
       ('e', '3', 'BISHOP', 'WHITE'),
       ('e', '4', 'BISHOP', 'WHITE'),
       ('e', '5', 'BISHOP', 'WHITE'),
       ('e', '6', 'BISHOP', 'WHITE'),
       ('e', '7', 'BISHOP', 'WHITE'),
       ('e', '8', 'BISHOP', 'WHITE'),
       ('f', '1', 'BISHOP', 'WHITE'),
       ('f', '2', 'BISHOP', 'WHITE'),
       ('f', '3', 'BISHOP', 'WHITE'),
       ('f', '4', 'BISHOP', 'WHITE'),
       ('f', '5', 'BISHOP', 'WHITE'),
       ('f', '6', 'BISHOP', 'WHITE'),
       ('f', '7', 'BISHOP', 'WHITE'),
       ('f', '8', 'BISHOP', 'WHITE'),
       ('g', '1', 'BISHOP', 'WHITE'),
       ('g', '2', 'BISHOP', 'WHITE'),
       ('g', '3', 'BISHOP', 'WHITE'),
       ('g', '4', 'BISHOP', 'WHITE'),
       ('g', '5', 'BISHOP', 'WHITE'),
       ('g', '6', 'BISHOP', 'WHITE'),
       ('g', '7', 'BISHOP', 'WHITE'),
       ('g', '8', 'BISHOP', 'WHITE'),
       ('h', '1', 'BISHOP', 'WHITE'),
       ('h', '2', 'BISHOP', 'WHITE'),
       ('h', '3', 'BISHOP', 'WHITE'),
       ('h', '4', 'BISHOP', 'WHITE'),
       ('h', '5', 'BISHOP', 'WHITE'),
       ('h', '6', 'BISHOP', 'WHITE'),
       ('h', '7', 'BISHOP', 'WHITE'),
       ('h', '8', 'BISHOP', 'WHITE');

INSERT INTO chess_position (file, `rank`, piece, team)
VALUES ('a', '1', 'BISHOP', 'BLACK'),
       ('a', '2', 'BISHOP', 'BLACK'),
       ('a', '3', 'BISHOP', 'BLACK'),
       ('a', '4', 'BISHOP', 'BLACK'),
       ('a', '5', 'BISHOP', 'BLACK'),
       ('a', '6', 'BISHOP', 'BLACK'),
       ('a', '7', 'BISHOP', 'BLACK'),
       ('a', '8', 'BISHOP', 'BLACK'),
       ('b', '1', 'BISHOP', 'BLACK'),
       ('b', '2', 'BISHOP', 'BLACK'),
       ('b', '3', 'BISHOP', 'BLACK'),
       ('b', '4', 'BISHOP', 'BLACK'),
       ('b', '5', 'BISHOP', 'BLACK'),
       ('b', '6', 'BISHOP', 'BLACK'),
       ('b', '7', 'BISHOP', 'BLACK'),
       ('b', '8', 'BISHOP', 'BLACK'),
       ('c', '1', 'BISHOP', 'BLACK'),
       ('c', '2', 'BISHOP', 'BLACK'),
       ('c', '3', 'BISHOP', 'BLACK'),
       ('c', '4', 'BISHOP', 'BLACK'),
       ('c', '5', 'BISHOP', 'BLACK'),
       ('c', '6', 'BISHOP', 'BLACK'),
       ('c', '7', 'BISHOP', 'BLACK'),
       ('c', '8', 'BISHOP', 'BLACK'),
       ('d', '1', 'BISHOP', 'BLACK'),
       ('d', '2', 'BISHOP', 'BLACK'),
       ('d', '3', 'BISHOP', 'BLACK'),
       ('d', '4', 'BISHOP', 'BLACK'),
       ('d', '5', 'BISHOP', 'BLACK'),
       ('d', '6', 'BISHOP', 'BLACK'),
       ('d', '7', 'BISHOP', 'BLACK'),
       ('d', '8', 'BISHOP', 'BLACK'),
       ('e', '1', 'BISHOP', 'BLACK'),
       ('e', '2', 'BISHOP', 'BLACK'),
       ('e', '3', 'BISHOP', 'BLACK'),
       ('e', '4', 'BISHOP', 'BLACK'),
       ('e', '5', 'BISHOP', 'BLACK'),
       ('e', '6', 'BISHOP', 'BLACK'),
       ('e', '7', 'BISHOP', 'BLACK'),
       ('e', '8', 'BISHOP', 'BLACK'),
       ('f', '1', 'BISHOP', 'BLACK'),
       ('f', '2', 'BISHOP', 'BLACK'),
       ('f', '3', 'BISHOP', 'BLACK'),
       ('f', '4', 'BISHOP', 'BLACK'),
       ('f', '5', 'BISHOP', 'BLACK'),
       ('f', '6', 'BISHOP', 'BLACK'),
       ('f', '7', 'BISHOP', 'BLACK'),
       ('f', '8', 'BISHOP', 'BLACK'),
       ('g', '1', 'BISHOP', 'BLACK'),
       ('g', '2', 'BISHOP', 'BLACK'),
       ('g', '3', 'BISHOP', 'BLACK'),
       ('g', '4', 'BISHOP', 'BLACK'),
       ('g', '5', 'BISHOP', 'BLACK'),
       ('g', '6', 'BISHOP', 'BLACK'),
       ('g', '7', 'BISHOP', 'BLACK'),
       ('g', '8', 'BISHOP', 'BLACK'),
       ('h', '1', 'BISHOP', 'BLACK'),
       ('h', '2', 'BISHOP', 'BLACK'),
       ('h', '3', 'BISHOP', 'BLACK'),
       ('h', '4', 'BISHOP', 'BLACK'),
       ('h', '5', 'BISHOP', 'BLACK'),
       ('h', '6', 'BISHOP', 'BLACK'),
       ('h', '7', 'BISHOP', 'BLACK'),
       ('h', '8', 'BISHOP', 'BLACK');

INSERT INTO chess_position (file, `rank`, piece, team)
VALUES ('a', '1', 'ROOK', 'WHITE'),
       ('a', '2', 'ROOK', 'WHITE'),
       ('a', '3', 'ROOK', 'WHITE'),
       ('a', '4', 'ROOK', 'WHITE'),
       ('a', '5', 'ROOK', 'WHITE'),
       ('a', '6', 'ROOK', 'WHITE'),
       ('a', '7', 'ROOK', 'WHITE'),
       ('a', '8', 'ROOK', 'WHITE'),
       ('b', '1', 'ROOK', 'WHITE'),
       ('b', '2', 'ROOK', 'WHITE'),
       ('b', '3', 'ROOK', 'WHITE'),
       ('b', '4', 'ROOK', 'WHITE'),
       ('b', '5', 'ROOK', 'WHITE'),
       ('b', '6', 'ROOK', 'WHITE'),
       ('b', '7', 'ROOK', 'WHITE'),
       ('b', '8', 'ROOK', 'WHITE'),
       ('c', '1', 'ROOK', 'WHITE'),
       ('c', '2', 'ROOK', 'WHITE'),
       ('c', '3', 'ROOK', 'WHITE'),
       ('c', '4', 'ROOK', 'WHITE'),
       ('c', '5', 'ROOK', 'WHITE'),
       ('c', '6', 'ROOK', 'WHITE'),
       ('c', '7', 'ROOK', 'WHITE'),
       ('c', '8', 'ROOK', 'WHITE'),
       ('d', '1', 'ROOK', 'WHITE'),
       ('d', '2', 'ROOK', 'WHITE'),
       ('d', '3', 'ROOK', 'WHITE'),
       ('d', '4', 'ROOK', 'WHITE'),
       ('d', '5', 'ROOK', 'WHITE'),
       ('d', '6', 'ROOK', 'WHITE'),
       ('d', '7', 'ROOK', 'WHITE'),
       ('d', '8', 'ROOK', 'WHITE'),
       ('e', '1', 'ROOK', 'WHITE'),
       ('e', '2', 'ROOK', 'WHITE'),
       ('e', '3', 'ROOK', 'WHITE'),
       ('e', '4', 'ROOK', 'WHITE'),
       ('e', '5', 'ROOK', 'WHITE'),
       ('e', '6', 'ROOK', 'WHITE'),
       ('e', '7', 'ROOK', 'WHITE'),
       ('e', '8', 'ROOK', 'WHITE'),
       ('f', '1', 'ROOK', 'WHITE'),
       ('f', '2', 'ROOK', 'WHITE'),
       ('f', '3', 'ROOK', 'WHITE'),
       ('f', '4', 'ROOK', 'WHITE'),
       ('f', '5', 'ROOK', 'WHITE'),
       ('f', '6', 'ROOK', 'WHITE'),
       ('f', '7', 'ROOK', 'WHITE'),
       ('f', '8', 'ROOK', 'WHITE'),
       ('g', '1', 'ROOK', 'WHITE'),
       ('g', '2', 'ROOK', 'WHITE'),
       ('g', '3', 'ROOK', 'WHITE'),
       ('g', '4', 'ROOK', 'WHITE'),
       ('g', '5', 'ROOK', 'WHITE'),
       ('g', '6', 'ROOK', 'WHITE'),
       ('g', '7', 'ROOK', 'WHITE'),
       ('g', '8', 'ROOK', 'WHITE'),
       ('h', '1', 'ROOK', 'WHITE'),
       ('h', '2', 'ROOK', 'WHITE'),
       ('h', '3', 'ROOK', 'WHITE'),
       ('h', '4', 'ROOK', 'WHITE'),
       ('h', '5', 'ROOK', 'WHITE'),
       ('h', '6', 'ROOK', 'WHITE'),
       ('h', '7', 'ROOK', 'WHITE'),
       ('h', '8', 'ROOK', 'WHITE');

INSERT INTO chess_position (file, `rank`, piece, team)
VALUES ('a', '1', 'ROOK', 'BLACK'),
       ('a', '2', 'ROOK', 'BLACK'),
       ('a', '3', 'ROOK', 'BLACK'),
       ('a', '4', 'ROOK', 'BLACK'),
       ('a', '5', 'ROOK', 'BLACK'),
       ('a', '6', 'ROOK', 'BLACK'),
       ('a', '7', 'ROOK', 'BLACK'),
       ('a', '8', 'ROOK', 'BLACK'),
       ('b', '1', 'ROOK', 'BLACK'),
       ('b', '2', 'ROOK', 'BLACK'),
       ('b', '3', 'ROOK', 'BLACK'),
       ('b', '4', 'ROOK', 'BLACK'),
       ('b', '5', 'ROOK', 'BLACK'),
       ('b', '6', 'ROOK', 'BLACK'),
       ('b', '7', 'ROOK', 'BLACK'),
       ('b', '8', 'ROOK', 'BLACK'),
       ('c', '1', 'ROOK', 'BLACK'),
       ('c', '2', 'ROOK', 'BLACK'),
       ('c', '3', 'ROOK', 'BLACK'),
       ('c', '4', 'ROOK', 'BLACK'),
       ('c', '5', 'ROOK', 'BLACK'),
       ('c', '6', 'ROOK', 'BLACK'),
       ('c', '7', 'ROOK', 'BLACK'),
       ('c', '8', 'ROOK', 'BLACK'),
       ('d', '1', 'ROOK', 'BLACK'),
       ('d', '2', 'ROOK', 'BLACK'),
       ('d', '3', 'ROOK', 'BLACK'),
       ('d', '4', 'ROOK', 'BLACK'),
       ('d', '5', 'ROOK', 'BLACK'),
       ('d', '6', 'ROOK', 'BLACK'),
       ('d', '7', 'ROOK', 'BLACK'),
       ('d', '8', 'ROOK', 'BLACK'),
       ('e', '1', 'ROOK', 'BLACK'),
       ('e', '2', 'ROOK', 'BLACK'),
       ('e', '3', 'ROOK', 'BLACK'),
       ('e', '4', 'ROOK', 'BLACK'),
       ('e', '5', 'ROOK', 'BLACK'),
       ('e', '6', 'ROOK', 'BLACK'),
       ('e', '7', 'ROOK', 'BLACK'),
       ('e', '8', 'ROOK', 'BLACK'),
       ('f', '1', 'ROOK', 'BLACK'),
       ('f', '2', 'ROOK', 'BLACK'),
       ('f', '3', 'ROOK', 'BLACK'),
       ('f', '4', 'ROOK', 'BLACK'),
       ('f', '5', 'ROOK', 'BLACK'),
       ('f', '6', 'ROOK', 'BLACK'),
       ('f', '7', 'ROOK', 'BLACK'),
       ('f', '8', 'ROOK', 'BLACK'),
       ('g', '1', 'ROOK', 'BLACK'),
       ('g', '2', 'ROOK', 'BLACK'),
       ('g', '3', 'ROOK', 'BLACK'),
       ('g', '4', 'ROOK', 'BLACK'),
       ('g', '5', 'ROOK', 'BLACK'),
       ('g', '6', 'ROOK', 'BLACK'),
       ('g', '7', 'ROOK', 'BLACK'),
       ('g', '8', 'ROOK', 'BLACK'),
       ('h', '1', 'ROOK', 'BLACK'),
       ('h', '2', 'ROOK', 'BLACK'),
       ('h', '3', 'ROOK', 'BLACK'),
       ('h', '4', 'ROOK', 'BLACK'),
       ('h', '5', 'ROOK', 'BLACK'),
       ('h', '6', 'ROOK', 'BLACK'),
       ('h', '7', 'ROOK', 'BLACK'),
       ('h', '8', 'ROOK', 'BLACK');

INSERT INTO chess_position (file, `rank`, piece, team)
VALUES ('a', '1', 'PAWN', 'WHITE'),
       ('a', '2', 'PAWN', 'WHITE'),
       ('a', '3', 'PAWN', 'WHITE'),
       ('a', '4', 'PAWN', 'WHITE'),
       ('a', '5', 'PAWN', 'WHITE'),
       ('a', '6', 'PAWN', 'WHITE'),
       ('a', '7', 'PAWN', 'WHITE'),
       ('a', '8', 'PAWN', 'WHITE'),
       ('b', '1', 'PAWN', 'WHITE'),
       ('b', '2', 'PAWN', 'WHITE'),
       ('b', '3', 'PAWN', 'WHITE'),
       ('b', '4', 'PAWN', 'WHITE'),
       ('b', '5', 'PAWN', 'WHITE'),
       ('b', '6', 'PAWN', 'WHITE'),
       ('b', '7', 'PAWN', 'WHITE'),
       ('b', '8', 'PAWN', 'WHITE'),
       ('c', '1', 'PAWN', 'WHITE'),
       ('c', '2', 'PAWN', 'WHITE'),
       ('c', '3', 'PAWN', 'WHITE'),
       ('c', '4', 'PAWN', 'WHITE'),
       ('c', '5', 'PAWN', 'WHITE'),
       ('c', '6', 'PAWN', 'WHITE'),
       ('c', '7', 'PAWN', 'WHITE'),
       ('c', '8', 'PAWN', 'WHITE'),
       ('d', '1', 'PAWN', 'WHITE'),
       ('d', '2', 'PAWN', 'WHITE'),
       ('d', '3', 'PAWN', 'WHITE'),
       ('d', '4', 'PAWN', 'WHITE'),
       ('d', '5', 'PAWN', 'WHITE'),
       ('d', '6', 'PAWN', 'WHITE'),
       ('d', '7', 'PAWN', 'WHITE'),
       ('d', '8', 'PAWN', 'WHITE'),
       ('e', '1', 'PAWN', 'WHITE'),
       ('e', '2', 'PAWN', 'WHITE'),
       ('e', '3', 'PAWN', 'WHITE'),
       ('e', '4', 'PAWN', 'WHITE'),
       ('e', '5', 'PAWN', 'WHITE'),
       ('e', '6', 'PAWN', 'WHITE'),
       ('e', '7', 'PAWN', 'WHITE'),
       ('e', '8', 'PAWN', 'WHITE'),
       ('f', '1', 'PAWN', 'WHITE'),
       ('f', '2', 'PAWN', 'WHITE'),
       ('f', '3', 'PAWN', 'WHITE'),
       ('f', '4', 'PAWN', 'WHITE'),
       ('f', '5', 'PAWN', 'WHITE'),
       ('f', '6', 'PAWN', 'WHITE'),
       ('f', '7', 'PAWN', 'WHITE'),
       ('f', '8', 'PAWN', 'WHITE'),
       ('g', '1', 'PAWN', 'WHITE'),
       ('g', '2', 'PAWN', 'WHITE'),
       ('g', '3', 'PAWN', 'WHITE'),
       ('g', '4', 'PAWN', 'WHITE'),
       ('g', '5', 'PAWN', 'WHITE'),
       ('g', '6', 'PAWN', 'WHITE'),
       ('g', '7', 'PAWN', 'WHITE'),
       ('g', '8', 'PAWN', 'WHITE'),
       ('h', '1', 'PAWN', 'WHITE'),
       ('h', '2', 'PAWN', 'WHITE'),
       ('h', '3', 'PAWN', 'WHITE'),
       ('h', '4', 'PAWN', 'WHITE'),
       ('h', '5', 'PAWN', 'WHITE'),
       ('h', '6', 'PAWN', 'WHITE'),
       ('h', '7', 'PAWN', 'WHITE'),
       ('h', '8', 'PAWN', 'WHITE');

INSERT INTO chess_position (file, `rank`, piece, team)
VALUES ('a', '1', 'PAWN', 'BLACK'),
       ('a', '2', 'PAWN', 'BLACK'),
       ('a', '3', 'PAWN', 'BLACK'),
       ('a', '4', 'PAWN', 'BLACK'),
       ('a', '5', 'PAWN', 'BLACK'),
       ('a', '6', 'PAWN', 'BLACK'),
       ('a', '7', 'PAWN', 'BLACK'),
       ('a', '8', 'PAWN', 'BLACK'),
       ('b', '1', 'PAWN', 'BLACK'),
       ('b', '2', 'PAWN', 'BLACK'),
       ('b', '3', 'PAWN', 'BLACK'),
       ('b', '4', 'PAWN', 'BLACK'),
       ('b', '5', 'PAWN', 'BLACK'),
       ('b', '6', 'PAWN', 'BLACK'),
       ('b', '7', 'PAWN', 'BLACK'),
       ('b', '8', 'PAWN', 'BLACK'),
       ('c', '1', 'PAWN', 'BLACK'),
       ('c', '2', 'PAWN', 'BLACK'),
       ('c', '3', 'PAWN', 'BLACK'),
       ('c', '4', 'PAWN', 'BLACK'),
       ('c', '5', 'PAWN', 'BLACK'),
       ('c', '6', 'PAWN', 'BLACK'),
       ('c', '7', 'PAWN', 'BLACK'),
       ('c', '8', 'PAWN', 'BLACK'),
       ('d', '1', 'PAWN', 'BLACK'),
       ('d', '2', 'PAWN', 'BLACK'),
       ('d', '3', 'PAWN', 'BLACK'),
       ('d', '4', 'PAWN', 'BLACK'),
       ('d', '5', 'PAWN', 'BLACK'),
       ('d', '6', 'PAWN', 'BLACK'),
       ('d', '7', 'PAWN', 'BLACK'),
       ('d', '8', 'PAWN', 'BLACK'),
       ('e', '1', 'PAWN', 'BLACK'),
       ('e', '2', 'PAWN', 'BLACK'),
       ('e', '3', 'PAWN', 'BLACK'),
       ('e', '4', 'PAWN', 'BLACK'),
       ('e', '5', 'PAWN', 'BLACK'),
       ('e', '6', 'PAWN', 'BLACK'),
       ('e', '7', 'PAWN', 'BLACK'),
       ('e', '8', 'PAWN', 'BLACK'),
       ('f', '1', 'PAWN', 'BLACK'),
       ('f', '2', 'PAWN', 'BLACK'),
       ('f', '3', 'PAWN', 'BLACK'),
       ('f', '4', 'PAWN', 'BLACK'),
       ('f', '5', 'PAWN', 'BLACK'),
       ('f', '6', 'PAWN', 'BLACK'),
       ('f', '7', 'PAWN', 'BLACK'),
       ('f', '8', 'PAWN', 'BLACK'),
       ('g', '1', 'PAWN', 'BLACK'),
       ('g', '2', 'PAWN', 'BLACK'),
       ('g', '3', 'PAWN', 'BLACK'),
       ('g', '4', 'PAWN', 'BLACK'),
       ('g', '5', 'PAWN', 'BLACK'),
       ('g', '6', 'PAWN', 'BLACK'),
       ('g', '7', 'PAWN', 'BLACK'),
       ('g', '8', 'PAWN', 'BLACK'),
       ('h', '1', 'PAWN', 'BLACK'),
       ('h', '2', 'PAWN', 'BLACK'),
       ('h', '3', 'PAWN', 'BLACK'),
       ('h', '4', 'PAWN', 'BLACK'),
       ('h', '5', 'PAWN', 'BLACK'),
       ('h', '6', 'PAWN', 'BLACK'),
       ('h', '7', 'PAWN', 'BLACK'),
       ('h', '8', 'PAWN', 'BLACK');
