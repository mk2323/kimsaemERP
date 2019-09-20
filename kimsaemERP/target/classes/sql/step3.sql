create table password_history(
   id varchar2(20),
   pass_modify_date date,
   password varchar2(100),
   passchangestate varchar2(10));
   
  create table login_history(
     id varchar2(20),
     login_success_time date,
     login_fail_time date,
     login_fail_count number(10),
     last_access_date date,
     is_lock varchar2(10),
     login_lock_count number(10));  
          
 create table login_ip(
	  id varchar2(20),
	  ip varchar2(30),
	  region varchar2(20));
	  
	  
insert into PASSWORD_HISTORY values('9401023jang','2019/07/11',null,'N');
insert into PASSWORD_HISTORY values('0111022kim','2019/08/22',null,'N');
insert into PASSWORD_HISTORY values('92115kim','2019/09/11',null,'N');
insert into PASSWORD_HISTORY values('881011kim','2019/07/11',null,'N');
insert into PASSWORD_HISTORY values('787871lee','2019/09/25',null,'N');

insert into PASSWORD_HISTORY values('17171park','2019/08/18',null,'N');
insert into PASSWORD_HISTORY values('9871kim','2019/07/22',null,'N');
insert into PASSWORD_HISTORY values('lee0idjj','2019/08/29',null,'N');
insert into PASSWORD_HISTORY values('djdiwjs','2019/09/07',null,'N');
insert into PASSWORD_HISTORY values('282djdid','2019/08/15',null,'N');
insert into PASSWORD_HISTORY values('Yeona1231','2019/07/30',null,'N');


update PASSWORD_HISTORY
set password=(select pass from MEMBER where id='9401023jang')
where id='9401023jang';

update PASSWORD_HISTORY
set password=(select pass from MEMBER where id='0111022kim')
where id='0111022kim';

update PASSWORD_HISTORY
set password=(select pass from MEMBER where id='92115kim')
where id='92115kim';

update PASSWORD_HISTORY
set password=(select pass from MEMBER where id='881011kim')
where id='881011kim';

update PASSWORD_HISTORY
set password=(select pass from MEMBER where id='787871lee')
where id='787871lee';

update PASSWORD_HISTORY
set password=(select pass from MEMBER where id='17171park')
where id='17171park';

update PASSWORD_HISTORY
set password=(select pass from MEMBER where id='9871kim')
where id='9871kim';

update PASSWORD_HISTORY
set password=(select pass from MEMBER where id='lee0idjj')
where id='lee0idjj';

update PASSWORD_HISTORY
set password=(select pass from MEMBER where id='djdiwjs')
where id='djdiwjs';

update PASSWORD_HISTORY
set password=(select pass from MEMBER where id='282djdid')
where id='282djdid';

update PASSWORD_HISTORY
set password=(select pass from MEMBER where id='Yeona1231')
where id='Yeona1231';









