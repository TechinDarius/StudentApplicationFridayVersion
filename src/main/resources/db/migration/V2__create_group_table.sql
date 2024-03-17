--Group table
CREATE TABLE "group"
(
    id      BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name    varchar(255) not null,
    details varchar(255)

);

create sequence group_sequence start with 1 increment by 1;

insert into "group" (name, details)
values ('Test Group', 'This is test group');

--Person group relation table
CREATE TABLE person_group
(
    pid      bigint REFERENCES PERSON (pid),
    group_id BIGINT REFERENCES "group" (id)
);

insert into person_group (pid, group_id)
values (38203020577, 1);