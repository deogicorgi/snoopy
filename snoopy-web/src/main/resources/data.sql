insert into role(name, description, is_enabled)
values ('ROLE_ADMIN', '관리자', 1);
insert into role(name, description, is_enabled)
values ('ROLE_USER', '사용자', 1);
insert into role(name, description, is_enabled)
values ('ROLE_GUEST', '비회원', 1);

insert into privilege(name, description)
values ('READ', '읽기 권한');
insert into privilege(name, description)
values ('WRITE', '쓰기 권한');
insert into privilege(name, description)
values ('ADD_USER', '유저 추가 권한');
insert into privilege(name, description)
values ('UPDATE_USER', '유저 수정 권한');
insert into privilege(name, description)
values ('DELETE_USER', '유저 삭제 권한');

insert into role_privilege(role_id, privilege_id)
values (1, 1);
insert into role_privilege(role_id, privilege_id)
values (1, 2);
insert into role_privilege(role_id, privilege_id)
values (1, 3);
insert into role_privilege(role_id, privilege_id)
values (1, 4);
insert into role_privilege(role_id, privilege_id)
values (1, 5);
insert into role_privilege(role_id, privilege_id)
values (3, 1);
insert into role_privilege(role_id, privilege_id)
values (2, 1);
insert into role_privilege(role_id, privilege_id)
values (2, 2);