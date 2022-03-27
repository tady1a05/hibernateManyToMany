# hibernateManyToMany

Create table hb_instructor_tracker.student(
	id int(11) not null auto_increment,
    first_name varchar(45) default null,
    last_name varchar(45) default null,
    email varchar(45) default null,
    primary key(id)
);

Create table hb_instructor_tracker.student_course(
	student_id int(11) not null,
    course_id int(11) not null,
    foreign key(student_id) references hb_instructor_tracker.student(id),
    foreign key(course_id) references hb_instructor_tracker.course(id),
    primary key(student_id,course_id)
);
