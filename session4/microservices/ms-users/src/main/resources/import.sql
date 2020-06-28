insert into users (username, password, email, enabled) values ('eargume', '123456', 'eargume@kuroshan.com', true)
insert into users (username, password, email, enabled) values ('klozano', '123456', 'klozano@kuroshan.com', true)

insert into roles (name) values ('ROLE_USER');
insert into roles (name) values ('ROLE_ADMIN');

insert into users_roles (user_id, role_id) values (1, 1);
insert into users_roles (user_id, role_id) values (2, 2);
insert into users_roles (user_id, role_id) values (2, 1);
