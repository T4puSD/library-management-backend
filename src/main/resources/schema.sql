create table user
(
    id bigint primary key,
    email varchar not null unique,
    pwd varchar not null,
    active tinyint not null,
    role varchar not null
);

create table author
(
    id   bigint primary key,
    name varchar not null
);

create table book_category
(
    id   bigint primary key,
    name varchar not null
);

create table book
(
    id          bigint primary key,
    isbn        bigint  not null,
    title       varchar not null,
    category_id int     not null,
    foreign key (category_id) references book_category(id)
);

create table book_author
(
    book_id   bigint not null,
    author_id bigint not null,
    primary key (book_id, author_id),
    foreign key (book_id) references book (id),
    foreign key (author_id) references author (id)
);

create table book_copy
(
    id       bigint primary key,
    book_id  bigint  not null,
    borrowed tinyint not null,
    foreign key (book_id) references book(id)
);

create table borrow_log
(
   id    bigint primary key,
   user_id bigint not null,
   book_copy_id bigint not null unique,
   created datetime not null,
   foreign key (user_id) references user(id),
   foreign key (book_copy_id) references book_copy(id)
);