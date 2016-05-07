insert into user(user_id, name, password) values('admin','Admin',password('Admin123!'));

insert into invoice(no_faktur, last_user, dari_kepada, keterangan) values('0000000001','admin','admin','<strong>Coba HTML Injection</strong>');

--NO CLASS ACCOUNT
INSERT INTO ACCOUNT_CLASS(CODE, NAME) VALUES('1','ASSET');
--SUB CLASS
INSERT INTO ACCOUNT_SUBCLASS(CODE,PARENT_CODE, NAME) VALUES('11','1','Aset Lancar');
--NO ACCOUNT
INSERT INTO ACCOUNT_CODE(CODE, PARENT_CODE, NAME) VALUES('1101','11','Kas');
INSERT INTO ACCOUNT_CODE(CODE, PARENT_CODE, NAME) VALUES('1102','11','Surat-surat berharga');
INSERT INTO ACCOUNT_CODE(CODE, PARENT_CODE, NAME) VALUES('1103','11','Piutang Usaha');
INSERT INTO ACCOUNT_CODE(CODE, PARENT_CODE, NAME) VALUES('1104','11','Cadangan Kerugian Piutang Usaha');

INSERT INTO dashboard_message(MESSAGE, POST_USER) VALUES('Test to post a message','admin');
INSERT INTO dashboard_message(MESSAGE, POST_USER) VALUES('It should be ended here','admin');

insert into message_config(table_id, MESSAGE, status) values('invoice','menambahkan invoice baru dengan no faktur ','success');