# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table event (
  id                        bigint not null,
  name                      varchar(255),
  stroke                    varchar(255),
  distance                  integer,
  units                     varchar(255),
  constraint pk_event primary key (id))
;

create table times (
  id                        bigint not null,
  event_id                  bigint,
  time                      varchar(255),
  date                      varchar(255),
  swimmer_id                bigint,
  constraint pk_times primary key (id))
;

create table user (
  id                        bigint not null,
  name                      varchar(255),
  school                    varchar(255),
  constraint pk_user primary key (id))
;


create table event_user (
  event_id                       bigint not null,
  user_id                        bigint not null,
  constraint pk_event_user primary key (event_id, user_id))
;
create sequence event_seq;

create sequence times_seq;

create sequence user_seq;

alter table times add constraint fk_times_event_1 foreign key (event_id) references event (id) on delete restrict on update restrict;
create index ix_times_event_1 on times (event_id);
alter table times add constraint fk_times_swimmer_2 foreign key (swimmer_id) references user (id) on delete restrict on update restrict;
create index ix_times_swimmer_2 on times (swimmer_id);



alter table event_user add constraint fk_event_user_event_01 foreign key (event_id) references event (id) on delete restrict on update restrict;

alter table event_user add constraint fk_event_user_user_02 foreign key (user_id) references user (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists event;

drop table if exists event_user;

drop table if exists times;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists event_seq;

drop sequence if exists times_seq;

drop sequence if exists user_seq;

