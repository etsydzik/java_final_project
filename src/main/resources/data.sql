INSERT INTO USER (id, name, login, password) VALUES (1, 'eugene', 'tyger', '2222'),
(2, 'admin', 'dmitry', '3333');

INSERT INTO CAR (id, model, manufacture_date, car_number, engine_power) VALUES (1, 'fiat', 2008, '9013-IP4', 1.4);

INSERT INTO APPLICATION (id, start_time, end_time, user_id, car_id) VALUES (1, DATE '2016-11-15', DATE '2016-11-25', 1, 1);
