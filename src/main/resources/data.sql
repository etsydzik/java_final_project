INSERT INTO USER (id, name, login, password) VALUES (1, 'eugene', 'eugene', '1111'),
(2, 'dmitry', 'dmitry', '2222');

INSERT INTO CAR (id, model, manufacture_date, car_number, engine_power) VALUES (1, 'fiat', 2008, '9013-IP4', 1.4);
INSERT INTO CAR (id, model, manufacture_date, car_number, engine_power) VALUES (2, 'BMW', 2016, '7777-IP7', 4.0);

INSERT INTO APPLICATION (id, start_time, end_time, user_id, car_id) VALUES (1, DATE '2016-11-15', DATE '2016-11-25', 1, 1);
INSERT INTO APPLICATION (id, start_time, end_time, user_id, car_id) VALUES (2, DATE '2016-11-15', DATE '2016-11-25', 2, 2);
