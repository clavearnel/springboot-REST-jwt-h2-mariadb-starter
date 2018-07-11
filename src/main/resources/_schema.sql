INSERT INTO `authority` (`id`, `name`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');


INSERT INTO `users` (`id`, `email`, `enabled`, `first_name`, `last_name`, `last_password_reset_date`, `password`, `phone_number`, `username`) VALUES
(1, 'user@example.com', b'1', 'User', 'Name', '2017-10-01 21:58:58', '$2a$10$jTxxqUMyHTv4K7yXs6HuvuwmybACzZtWWfbg1KT276xlzLL0eKSci', NULL, 'user'),
(2, 'admin@example.com', b'1', 'Admin', 'Names', '2017-10-01 18:57:58', '$2a$10$jTxxqUMyHTv4K7yXs6HuvuwmybACzZtWWfbg1KT276xlzLL0eKSci', '+0987654321', 'admin');


INSERT INTO `user_authority` (`user_id`, `authority_id`) VALUES
(2, 1),
(2, 2),
(1, 2);