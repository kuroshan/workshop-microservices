-- password: 123456
insert into users (username, password, email, enabled) values ('user', '$2a$10$RJorbfyOiZskAYj3D3nvZexJ8U9YCMtrPoYoQR9TJPrypCluv897C', 'user@kuroshan.com', true)
insert into users (username, password, email, enabled) values ('admin', '$2a$10$g23HCEkssqbtG5XOZ39NLOx6iAxyJRkgcyPmnJ7TM0LdwE5E7ePYu', 'admin@kuroshan.com', true)

insert into roles (name) values ('ROLE_USER');
insert into roles (name) values ('ROLE_ADMIN');

insert into users_roles (user_id, role_id) values (1, 1);
insert into users_roles (user_id, role_id) values (2, 2);
insert into users_roles (user_id, role_id) values (2, 1);
