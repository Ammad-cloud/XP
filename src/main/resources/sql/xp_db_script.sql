create table Activity
(
	id int auto_increment,
	name varchar(40) not null,
	description varchar(255) not null,
	ageLimit int not null,
	heightLimit int not null,
	price double not null,
	constraint Activity_pk
		primary key (id)
);

create table Equipment
(
	id int auto_increment,
	type varchar(40) not null,
	needsRepair boolean default false not null,
	constraint Equipment_pk
		primary key (id)
);

create table ActivityEquipment
(
	id int auto_increment,
	activityId int not null,
	equipmentId int not null,
	constraint ActivityEquipment_pk
		primary key (id),
	constraint ActivityEquipment_fk
		foreign key (activityId) references Activity(id),
	constraint ActivityEquipment__fk
		foreign key (equipmentId) references Equipment(id)
);

create table Customer
(
	id int auto_increment,
	firstName varchar(40) not null,
	lastName varchar(40) not null,
	phone int not null,
	email varchar(40) not null,
	constraint Customer_pk
		primary key (id)
);

create table Instructor
(
	id int auto_increment,
	firstName varchar(40) not null,
	lastName varchar(40) not null,
	constraint Instructor_pk
		primary key (id)
);

create table Booking
(
	id int auto_increment,
	dateTime datetime not null,
	customerId int not null,
	activityId int not null,
	equipmentId int not null,
	instructorId int not null,
	participants int not null,
	constraint Booking_pk
		primary key (id),
	constraint BookingCustomer_fk
		foreign key (customerId) references Customer(id),
	constraint BookingActivity_fk
		foreign key (activityId) references Activity(id),
	constraint BookingEquipment_fk
		foreign key (equipmentId) references Equipment(id),
	constraint BookingInstructor_fk
		foreign key (instructorId) references Instructor(id)
);


