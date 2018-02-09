insert into tbl_permission (id, code, name, description) values (1, 'USER', 'User', 'User management');
insert into tbl_permission (id, code, name, description) values (2, 'COMPANY', 'Company', 'Company management');

insert into tbl_role (id, code, name, description) values (1, 'ADMIN', 'Admin', 'Admin role');
insert into tbl_role (id, code, name, description) values (2, 'USER', 'User', 'User role');

insert into tbl_user (id, first_name, last_name, username, password, user_type, last_login, role_id) values (1, 'Manjula', 'Jayawardana', 'manju', '$2a$10$trT3.R/Nfey62eczbKEnueTcIbJXW.u1ffAo/XfyLpofwNDbEB86O', 'ADMIN', null, 1);
