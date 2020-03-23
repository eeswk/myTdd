DROP TABLE IF EXISTS user;

CREATE TABLE user (
  id VARCHAR(20) PRIMARY KEY,
  password VARCHAR(250) NOT NULL,
  email varchar(255) NOT NULL

);

CREATE TABLE survey (
  id INT(11) PRIMARY KEY,
  respondentId INT(11) NULL

);

CREATE TABLE respondent (
  respondentId INT(11) PRIMARY KEY,
  answerId INT(11) NULL
);

CREATE TABLE answer (
  id INT(11) PRIMARY KEY
);

/*use test;

drop table user;

create table user (
  id varchar(20) not null,
  password varchar(255) not null,
  email varchar(255),
  primary key (id)
) engine = InnoDB charset utf8;
 */