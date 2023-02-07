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

drop table if exists course;
create table course
(
    id            int unsigned not null auto_increment primary key,
    title         varchar(128),
    instructor_id int unsigned,
    foreign key (instructor_id) references instructor (id),
    unique (title)
);

create table review
(
    id        int unsigned not null auto_increment primary key,
    comment   varchar(255),
    course_id int unsigned,
    foreign key (course_id) references course (id)
);

create table course_student
(
    course_id int unsigned not null,
    student_id int unsigned not null,
    primary key (course_id, student_id),
    foreign key (course_id) references course (id),
    foreign key (student_id) references student (id)
);
