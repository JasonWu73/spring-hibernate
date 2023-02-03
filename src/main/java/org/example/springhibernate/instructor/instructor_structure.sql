drop table if exists instructor_detail;
create table instructor_detail
(
    id              int unsigned not null auto_increment primary key,
    youtube_channel varchar(128),
    hobby           varchar(45)
);

drop table if exists instructor;
create table instructor
(
    id                   int unsigned not null auto_increment primary key,
    first_name           varchar(45),
    last_name            varchar(45),
    email                varchar(45),
    instructor_detail_id int unsigned,
    foreign key (instructor_detail_id) references instructor_detail (id)
);
