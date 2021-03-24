insert into person(firstname, lastname, birthdate, gender, address, email, identitynumber)
values('Attila', 'Mustermann', TO_DATE('1989/04/22', 'yyyy/mm/dd'), 'Male', 'H - 9200 Gyor', 'attila.mustermann@activesolution.at', '698555');

insert into vehicle(licenseplatenumber, typeofvehicle, color, yearofmanufacture, fuel, perform, p_id)
values ('KKK-999', 'Ford Mondeo', 'Yellow', TO_DATE('2017/09/03', 'yyyy/mm/dd'), 'diesel', 47, 1);

commit;

insert into contract(status, typeofcontract, paket, price, p_id)
values('Vorschlag', 'KFZ', 'Vollcasco', 12, 1);

commit;


