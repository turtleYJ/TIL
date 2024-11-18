insert into users (username, password) values ('user1', '$2a$10$z7MgpQAMwhkJtg39h4b.Au1kvmMmd4teVcXAHesna2SvxrTw3aDt.');
insert into users (username, password) values ('user2', '$2a$10$MaYMok7K5SQsPQlFl9d2m.CrU5MomLzNWCRmSNgenksedaBY64gNu');

insert into authorities (username, authority)
    values ('user1', 'ROLE_USER');
insert into authorities (username, authority)
    values ('user2', 'ROLE_USER');

commit;
