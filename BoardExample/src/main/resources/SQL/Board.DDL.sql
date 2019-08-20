drop table t_board;
drop sequence seq_board_id;

create sequence seq_board_id;

create table t_board (
--id, title, contents, writer, reg_date, update_date
	id             integer primary key,
	title          varchar(500),
	contents       varchar(5000),
	writer         varchar(500),
	--postgres Date : non time, TimeStamp : all
	reg_date       date default now(),
	update_date    date default now()
);

insert into t_board (id, title, contents, writer)
values(nextval('seq_board_id'), '테스트 제목', '테스트내용', '홍길동');

insert into t_board (id, title, contents, writer)
       select nextval('seq_board_id'), title, contents, writer
         from t_board;
  
create table t_reply (
--id, title, contents, writer, reg_date, update_date
	id             integer primary key,
	pid            integer,
	contents       varchar(5000),
	writer         varchar(500),
	reg_date       date default now(),
	update_date    date default now()
);

create sequence seq_reply_id;

alter table t_reply add constraint fk_reply_board foreign key (pid) references t_board(id);

create index idx_Reply on t_reply(pid);

