insert into user(id, email, pwd, active, role) values (1, 'admin@test.com', '123', 1, 'ADMIN'), (2, 'faculty@test.com', '123', 1, 'FACULTY'), (3, 'student@test.com', '123', 1, 'STUDENT');
insert into author(id, name) values ( 1, 'Humayun Ahammed'), (2, 'Arif Azad');
insert into book_category(id, name) values (1, 'Novel'), (2, 'Short Story'), (3, 'Documentary');
insert into book(id, isbn, title, category_id, active) values ( 1, 1000001, 'Sesh Bikele', 1, 1), (2, 1000002, 'Green Dome', 3, 1), (3, 1000003, 'Bela Seshe', 1, 1);
insert into book_author(book_id, author_id) values (1, 1), (2, 2), (3, 1), (3,2);
insert into book_copy(id, book_id, borrowed) values (1, 1, 0), (2, 1, 1), (3, 2, 0), (4, 2, 1), (5, 3, 1), (6, 3, 1), (7, 3, 0);
insert into borrow_log(id, user_id, book_copy_id, created) values (1, 2, 2, NOW()), (2, 2, 4, NOW() - 1), (3, 3, 5, NOW() -1), (4, 3, 6, NOW() -2);