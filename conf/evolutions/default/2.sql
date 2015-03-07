# --- Sample dataset

# --- !Ups


insert into user (id,name,school) values (  10,'Martin Simonini','Omaha North');
insert into user (id,name,school) values (20,'Dan Dan','Central High School');
insert into user (id,name,school) values (  30,'Harry Potter','Hogwarts');
insert into user (id,name,school) values (  40,'Lil Wayne','Jail');
insert into user (id,name,school) values (  50,'Mike Mike','Northwest High school');

insert into event (id,name,stroke,distance,units) values(10,'Swim-a-Thon','Freestyle','8000','Meters');
insert into event (id,name,stroke,distance,units) values(20,'Sprints','Freestyle','1000','Yards');
insert into event (id,name,stroke,distance,units) values(30,'Fly Workout','ButterFly','500','inches');
insert into event (id,name,stroke,distance,units) values(40,'Metro prep','IM','200','Lightyears');
insert into event (id,name,stroke,distance,units) values(50,'Distance work','Backstroke','5000','Smiles');

insert into times(id,event_id,time,date, swimmer_id) values (10,10,'1:1:02','12/21/12',10);
insert into times(id,event_id,time,date,swimmer_id) values (14,10,'10:10:020','03/07/2015',20);
insert into times(id,event_id,time,date,swimmer_id) values (11,10,'998:1:02','04/30/98',30);
insert into times(id,event_id,time,date,swimmer_id) values (12,10,'4478:10:02','09/09/09',40);
insert into times(id,event_id,time,date,swimmer_id) values (13,10,'198:12231:02','10/10/3030',50);

