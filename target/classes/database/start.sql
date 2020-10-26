CREATE DATABASE IF NOT EXISTS teacherstudent;

USE teacherstudent;

CREATE TABLE IF NOT EXISTS coursestudent(
                cid bigint,
                sid bigint,
                primary key (cid,sid),
                FOREIGN KEY (cid) references course(id),
                FOREIGN KEY (sid) references student(id)
);

CREATE TABLE IF NOT EXISTS student(
                id bigint auto_increment primary key,
                _name nvarchar(50)
                );

CREATE TABLE IF NOT EXISTS course(
                id bigint auto_increment primary key,
                _name nvarchar(50)
                );

CREATE TABLE IF NOT EXISTS teacher(
                id bigint auto_increment primary key,
                _name nvarchar(50),
                cid bigint,
                FOREIGN KEY (cid) references course(id)
);
