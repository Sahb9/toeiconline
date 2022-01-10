create table user(
                     userid bigint not null primary key,
                     name varchar(255) null,
                     password varchar(255) null,
                     fullname varchar(300) null,
                     createddate timestamp null


)
create table role(
                     roleid bigint not null primary key,
                     name varchar(100) null

)
CREATE TABLE `listenguideline` (
                                   `listenguidelineid` bigint NOT NULL primary key AUTO_INCREMENT,
                                   `title` varchar(512)  NULL,
                                   `image` varchar(255)  NULL,
                                   `content` text  NULL,
                                   `createddate` timestamp  NULL ,
                                   `modifieddate` timestamp NULL

);
CREATE TABLE `comment` (
                           `commentid` bigint primary key NOT NULL AUTO_INCREMENT,
                           `content` text null ,
                           `userid` bigint NULL,
                           `listenguidelineid` bigint NULL,
                           `createddate` timestamp NULL

)