create table if not exists account
(
    id bigint primary key auto_increment,
    email varchar not null unique,
    pwd varchar not null,
    active tinyint not null,
    role varchar not null
);

create table author
(
    id   bigint primary key auto_increment,
    name varchar not null
);

create table book_category
(
    id   bigint primary key auto_increment,
    name varchar not null
);

create table book
(
    id          bigint primary key auto_increment,
    isbn        bigint  not null,
    title       varchar not null,
    category_id int     not null,
    active      tinyint not null,
    foreign key (category_id) references book_category(id)
);

create table book_author
(
    book_id   bigint not null auto_increment,
    author_id bigint not null,
    primary key (book_id, author_id),
    foreign key (book_id) references book (id),
    foreign key (author_id) references author (id)
);

create table book_copy
(
    id       bigint primary key auto_increment,
    book_id  bigint  not null,
    borrowed tinyint not null,
    foreign key (book_id) references book(id)
);

create table borrow_log
(
   id    bigint primary key auto_increment,
   account_id bigint not null,
   book_copy_id bigint not null unique,
   created datetime not null,
   foreign key (account_id) references account(id),
   foreign key (book_copy_id) references book_copy(id)
);