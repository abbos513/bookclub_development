insert into role(id,name) values (10,'ROLE_ADMIN');
insert into role(id,name) values (30,'ROLE_USER');
insert into users(id,account_non_expired,account_non_locked,credentials_non_expired,enabled,password,phone_number) values (100,true,true,true,true,'$2a$10$bu8VAaYrSit.UgXLTO4qJe3GjCi1350X.RP3dbOFrRFMfiPO0tEr.','username');
insert into users(id,account_non_expired,account_non_locked,credentials_non_expired,enabled,password,phone_number) values (200,true,true,true,true,'$2a$10$bu8VAaYrSit.UgXLTO4qJe3GjCi1350X.RP3dbOFrRFMfiPO0tEr.','username 2');
insert into user_role(user_id, role_id) values (100,30);
insert into user_role(user_id, role_id) values (200,30);