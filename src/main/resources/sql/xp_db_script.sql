DROP DATABASE IF EXISTS `xp-adventure-group-one` ;
CREATE DATABASE `xp-adventure-group-one` DEFAULT CHARACTER SET utf8 ;
USE `xp-adventure-group-one` ;

DROP TABLE IF EXISTS Activity;
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

DROP TABLE IF EXISTS EquipmentTypes;
CREATE TABLE EquipmentTypes
(
	equipmentType VARCHAR(40) NOT NULL,
	PRIMARY KEY (equipmentType)
);

DROP TABLE IF EXISTS Equipment;
create table Equipment
(
	id int auto_increment,
	equipmentType varchar(40) not null,
	needsRepair boolean default false not null,
	PRIMARY KEY (id),
    FOREIGN KEY (equipmentType) REFERENCES EquipmentTypes(equipmentType)
);

DROP TABLE IF EXISTS ActivityEquipment;
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

DROP TABLE IF EXISTS Customer;
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

DROP TABLE IF EXISTS Instructor;
create table Instructor
(
	id int auto_increment,
	firstName varchar(40) not null,
	lastName varchar(40) not null,
	constraint Instructor_pk
		primary key (id)
);

DROP TABLE IF EXISTS Booking;
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

INSERT INTO activity(id, name, description, ageLimit, heightLimit, price, equipment_price) VALUES (default, "Go Cart", "description yo", 16, 160, 400, 0);
INSERT INTO activity(id, name, description, ageLimit, heightLimit, price, equipment_price) VALUES (default, "Sumo Wrestling", "description yo", 0, 0, 85, 0);
INSERT INTO activity(id, name, description, ageLimit, heightLimit, price, equipment_price) VALUES (default, "Paint Ball", "description yo", 16, 0, 250, 1);
INSERT INTO activity(id, name, description, ageLimit, heightLimit, price, equipment_price) VALUES (default, "Minigolf", "description yo", 0, 0, 100, 0);

insert into equipment (id, type, needsRepair) VALUES (default, "Hjelm", false);
insert into equipment (id, type, needsRepair) VALUES (default, "Dragt", false);
insert into equipment (id, type, needsRepair) VALUES (default, "Dragt", false);
insert into equipment (id, type, needsRepair) VALUES (default, "Dragt", false);
insert into equipment (id, type, needsRepair) VALUES (default, "Maske", false);
insert into equipment (id, type, needsRepair) VALUES (default, "Handsker", false);
insert into equipment (id, type, needsRepair) VALUES (default, "Sko", false);
insert into equipment (id, type, needsRepair) VALUES (default, "Gevær", false);
insert into equipment (id, type, needsRepair) VALUES (default, "Putter", false);
insert into equipment (id, type, needsRepair) VALUES (default, "Bolde", false);

alter table instructor
	add activityId int null;

alter table instructor
	add constraint instructor_activity_fk
		foreign key (activityId) references activity (id);


insert into instructor (id, firstName, lastName, activityId) values (default, "Hans", "Jensen", 1);
insert into instructor (id, firstName, lastName, activityId) values (default, "Malene", "Svendsen", 1);
insert into instructor (id, firstName, lastName, activityId) values (default, "Helena", "Nielsen", 2);
insert into instructor (id, firstName, lastName, activityId) values (default, "Pete", "Bropen", 2);
insert into instructor (id, firstName, lastName, activityId) values (default, "Søren", "Sørensen", 3);
insert into instructor (id, firstName, lastName, activityId) values (default, "Kenneth", "Mortensen", 3);
insert into instructor (id, firstName, lastName, activityId) values (default, "Ulla", "Larsen", 4);
insert into instructor (id, firstName, lastName, activityId) values (default, "Rasmus", "Hansen", 4);


insert into activityequipment (id, activityId, equipmentId) VALUES (default, 1, 1);
insert into activityequipment (id, activityId, equipmentId) VALUES (default, 1, 2);
insert into activityequipment (id, activityId, equipmentId) VALUES (default, 2, 3);
insert into activityequipment (id, activityId, equipmentId) VALUES (default, 3, 4);
insert into activityequipment (id, activityId, equipmentId) VALUES (default, 3, 5);
insert into activityequipment (id, activityId, equipmentId) VALUES (default, 3, 6);
insert into activityequipment (id, activityId, equipmentId) VALUES (default, 3, 7);
insert into activityequipment (id, activityId, equipmentId) VALUES (default, 3, 8);
insert into activityequipment (id, activityId, equipmentId) VALUES (default, 4, 9);
insert into activityequipment (id, activityId, equipmentId) VALUES (default, 4, 10);

