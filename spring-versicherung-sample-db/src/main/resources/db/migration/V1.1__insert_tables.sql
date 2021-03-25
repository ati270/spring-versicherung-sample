insert into person(firstname, lastname, birthdate, gender, address, email, identitynumber)
values ('Martin', 'Müller', TO_DATE('1970/09/07', 'yyyy/mm/dd'), 'Male', 'A - 1110 Wien',
        'martin.mueller@activesolution.at', '4781225434');

commit;

insert into vehicle(licenseplatenumber, typeofvehicle, color, yearofmanufacture, fuel, perform, p_id)
values ('ABC-122', 'Audi A3', 'Red', TO_DATE('2017/05/03', 'yyyy/mm/dd'), 'diesel', 20, 1);

commit;

insert into contract(status, typeofcontract, paket, price, p_id)
values ('Vorschlag', 'KFZ', 'Vollcasco', 30, 1);

commit;
