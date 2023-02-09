create table customer
(
    id         int unsigned not null auto_increment primary key,
    first_name varchar(45),
    last_name  varchar(45),
    email      varchar(45)
);

insert into customer
values (1, 'David', 'Adams', 'david@luv2code.com'),
       (2, 'John', 'Doe', 'john@luv2code.com'),
       (3, 'Ajay', 'Rao', 'ajay@luv2code.com'),
       (4, 'Mary', 'Public', 'mary@luv2code.com'),
       (5, 'Maxwell', 'Dixon', 'maxwell@luv2code.com');


