CREATE TABLE users
(
    user_id bigint NOT NULL AUTO_INCREMENT,
    nickname VARCHAR(30),
    email VARCHAR(50),
    password VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (user_id)
)

-- CREATE TABLE article
-- (
--     article_id bigint NOT NULL AUTO_INCREMENT,
--     title VARCHAR(80) NOT NULL,
--     content TEXT NOT NULL,
--     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
--     author_id bigint NOT NULL,
--     view_count bigint DEFAULT 0 NOT NULL,
--     PRIMARY KEY (id),
--     KEY idx_author_id (author_id)
-- )

-- CREATE TABLE comment
-- (
--     id bigint NOT NULL AUTO_INCREMENT,
--     content TEXT NOT NULL,
--     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
--     author_id bigint NOT NULL,
--     article_id NOT NULL,
--     PRIMARY KEY (id),
--     KEY idx_article_id (article_id)
-- )