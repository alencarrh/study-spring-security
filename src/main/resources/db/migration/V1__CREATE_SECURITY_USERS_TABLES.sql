CREATE TABLE users
(
    id bigserial PRIMARY KEY,
    username VARCHAR(50)  NOT NULL,
    password VARCHAR(100) NOT NULL
);
GRANT ALL ON SEQUENCE users_id_seq TO estudo_user;

CREATE TABLE authorities
(
    id bigserial PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);
GRANT ALL ON SEQUENCE authorities_id_seq TO estudo_user;


CREATE TABLE users_authorities
(
    user_id  bigserial NOT NULL,
    authority_id bigserial NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (authority_id) REFERENCES authorities (id),
    UNIQUE (user_id, authority_id)
);
