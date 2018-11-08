insert into categories
values(1,{ts '2018-11-08 18:00:00.69'},'Konflikt','Soziales',null);
insert into categories
values(2,{ts '2018-11-08 18:00:00.69'},'Schule','Ausbildung',null);
insert into categories
values(3,{ts '2018-11-08 18:00:00.69'},'Sport','Freizeit',null);

insert into institutions
values(1,{ts '2018-11-08 18:00:00.69'},'Salzburg',null);
insert into institutions
values(2,{ts '2018-11-08 18:00:00.69'},'Graz',null);
insert into institutions
values(3,{ts '2018-11-08 18:00:00.69'},'Wien',null);

insert into clients
values(1,{ts '2018-11-08 18:00:00.69'},{ts '2018-11-08'},'Mike',false,'lastname',null,1);
insert into clients
values(2,{ts '2018-11-08 18:00:00.69'},{ts '2018-11-08'},'Eli',false,'lastname',null,2);
insert into clients
values(3,{ts '2018-11-08 18:00:00.69'},{ts '2018-11-08'},'Paul',false,'lastname',null,2);
insert into clients
values(4,{ts '2018-11-08 18:00:00.69'},{ts '2018-11-08'},'Lena',true,'lastname',null,3);
insert into clients
values(5,{ts '2018-11-08 18:00:00.69'},{ts '2018-11-08'},'Philly',false,'Vanilly',null,1);

insert into supervisors
values(1,{ts '2018-11-08 18:00:00.69'},'Mike','Supervisor','xxSuperPasswordxx',null,1);
insert into supervisors
values(2,{ts '2018-11-08 18:00:00.69'},'Hans','Supervisor','xxSuperPassword1xx',null,3);
insert into supervisors
values(3,{ts '2018-11-08 18:00:00.69'},'Wurst','Supervisor','xxSuperPassword2xx',null,2);

insert into entries
values(1,{ts '2018-11-08 18:00:00.69'},'Elias und Phil haben sich gestrin lol',null,1);
insert into entries
values(2,{ts '2018-11-08 18:00:00.69'},'etwas ganz schlimmes',null,2);
insert into entries
values(3,{ts '2018-11-08 18:00:00.69'},'elias was so bad',null,3);
insert into entries
values(4,{ts '2018-11-08 18:00:00.69'},'irgendwas',null,2);
insert into entries
values(5,{ts '2018-11-08 18:00:00.69'},'waaaaaaaaaaaaaaaaaaat',null,2);

--(EntryID,CategoryID)
insert into categories_entries
values(1,2);
insert into categories_entries
values(1,3);

--(EntryID,ClientID)
insert into clients_entries
values(1,2);
insert into clients_entries
values(3,2);