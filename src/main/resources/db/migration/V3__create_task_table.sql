--Task table
CREATE TABLE task
(
    id         BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    group_id   BIGINT,
    short_desc varchar(255) not null,
    details    text,
    start_date date         not null,
    end_date   date
);

create sequence task_sequence start with 1 increment by 1;

--Task data
insert into task (group_id,short_desc, details, start_date, end_date)
values (1,'Testas', '', '2024-03-10', '2024-03-10');


--Task group relation table
CREATE TABLE task_group
(
    TASK_id  BIGINT REFERENCES task (id),
    group_id BIGINT REFERENCES "group" (id)
);

insert into task_group (task_id, group_id)
values (1, 1);

