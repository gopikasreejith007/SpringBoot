
create table if not exists person(
    p_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    p_name VARCHAR(255) NOT NULL,
    p_email  VARCHAR(100) NOT NULL
);