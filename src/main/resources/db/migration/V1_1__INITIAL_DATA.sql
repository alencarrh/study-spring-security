INSERT INTO authorities (id, name) values (1, 'READ');
INSERT INTO authorities (id, name) values (2, 'WRITE');

INSERT INTO users (id, username, password) values (1111, 'user', '12345');
INSERT INTO users (id, username, password) values (2222, 'admin', '12345');

INSERT INTO users_authorities (user_id, authority_id) values (1111, 1);
INSERT INTO users_authorities (user_id, authority_id) values (2222, 1);
INSERT INTO users_authorities (user_id, authority_id) values (2222, 2);