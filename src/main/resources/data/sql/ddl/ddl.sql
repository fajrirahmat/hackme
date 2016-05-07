create database hackme;

use hackme;

create table user(
	user_id varchar(64) not null,
    name varchar(128),
    password varchar(512) not null,
    primary key(user_id)
);

CREATE TABLE IF NOT EXISTS `invoice` (
  `no_faktur` varchar(10) not null,
  `tgl_faktur` datetime DEFAULT CURRENT_TIMESTAMP,
  `last_user` varchar(36) DEFAULT NULL,
  `dari_kepada` varchar(34) DEFAULT NULL,
  `last_update` datetime DEFAULT CURRENT_TIMESTAMP,
  `keterangan` varchar(1024) DEFAULT NULL,
  primary key(no_faktur)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `invoice_item`
--

CREATE TABLE IF NOT EXISTS `invoice_item` (
	`id_invoice_item` varchar(10) not null,
  `id_invoice` varchar(10) not null,
  `nama_perkiraan` varchar(128) DEFAULT NULL,
  `cc` varchar(22) DEFAULT NULL,
  `uraian` varchar(50) DEFAULT NULL,
  `debit` decimal(40,2) DEFAULT 0, 
  `kredit` decimal(40,2) DEFAULT 0,
  primary key(id_invoice_item),
  foreign key(id_invoice) references invoice(no_faktur) on delete cascade
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

create table ACCOUNT_CLASS(
	code varchar(3) not null primary key,
    name varchar(32) not null
);

create table ACCOUNT_SUBCLASS(
	code varchar(3) not null primary key,
    parent_code varchar(3) not null,
    name varchar(32) not null,
    foreign key(parent_code) references ACCOUNT_CLASS(code)
);

CREATE TABLE ACCOUNT_CODE(
	code varchar(5) not null primary key,
    parent_code varchar(3) not null,
    name varchar(64) not null,
    foreign key(parent_code) references ACCOUNT_SUBCLASS(code)
);

CREATE TABLE DASHBOARD_MESSAGE(
	ID BIGINT NOT NULL auto_increment PRIMARY KEY,
    MESSAGE VARCHAR(1024) DEFAULT 'There is no description about transaction',
    POST_DATE DATETIME DEFAULT CURRENT_TIMESTAMP,
    POST_USER VARCHAR(64) NOT NULL,
    foreign key(POST_USER) REFERENCES USER(USER_ID)
);

CREATE TABLE MESSAGE_CONFIG(
	table_id varchar(128) not null,
    message varchar(1024) not null,
    status varchar(10)  not null
);