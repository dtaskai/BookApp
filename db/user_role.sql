CREATE TABLE "user"
(
    id       serial primary key,
    username varchar(255) NOT NULL UNIQUE,
    password varchar(100) NOT NULL
);

CREATE TABLE role
(
    id          serial primary key,
    code        varchar(255) NOT NULL UNIQUE,
    description varchar(255)
);

create table user_role
(
    user_id int,
    role_id int,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES "user" (id),
    FOREIGN KEY (role_id) REFERENCES role (id)
);


insert into role (code, description)
values ('user', 'Can use the web app');
insert into role (code, description)
values ('api', 'Can use the REST API.');

insert into "user" (username, password)
values ('user1', '$2y$12$bJ2ZJMBSR6yjXlgy3n9RsOKP.0jCSVqFiwJhegJXthYagbH4Z4aEq');
insert into "user" (username, password)
values ('apiuser', '$2y$12$bJ2ZJMBSR6yjXlgy3n9RsOKP.0jCSVqFiwJhegJXthYagbH4Z4aEq');

insert into user_role (user_id, role_id)
values ((select id from "user" where username = 'user1'), (select id from role where code = 'user'));
insert into user_role (user_id, role_id)
values ((select id from "user" where username = 'apiuser'), (select id from role where code = 'user'));
insert into user_role (user_id, role_id)
values ((select id from "user" where username = 'apiuser'), (select id from role where code = 'api'));

UPDATE "user"
SET password="$2y$12$p9Y35VpNUF/kGnzqDONBmuTUJhR4TDVeAqDVNs3x3mwS09pwgnBwO"
WHERE username = "user1";