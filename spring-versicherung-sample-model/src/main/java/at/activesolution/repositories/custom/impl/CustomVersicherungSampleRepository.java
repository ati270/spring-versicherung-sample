package at.activesolution.repositories.custom.impl;

import at.activesolution.entities.*;
import at.activesolution.repositories.custom.api.ICustomVersicherungSampleRepository;
import com.mysema.query.types.Custom;
import com.mysema.query.types.Param;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.jpa.HibernateQuery;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.TransactionManager;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Named
public class CustomVersicherungSampleRepository implements ICustomVersicherungSampleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Person> getPersonsWithVehiclesAndContracts() {
        final JPAQuery<Person>  jpaQuery  = new JPAQuery(entityManager);
        final QPerson person = QPerson.person;
        return jpaQuery.from(person).select(person).fetch();
    }

    @Override
    public Person getOnePersonWithVehiclesAndContractsById(Long id) {
        final JPAQuery<Person>  jpaQuery  = new JPAQuery(entityManager);
        final QPerson person = QPerson.person;
        return jpaQuery.from(person).select(person).where(person.id.eq(id)).fetchOne();
    }

    @Override
    public Person getOnePersonWithVehiclesAndContractsByIdentityNumber(String identityNumber) {
        final JPAQuery<Person>  jpaQuery  = new JPAQuery(entityManager);
        final QPerson person = QPerson.person;
        return jpaQuery.from(person).select(person).where(person.identityNumber.eq(identityNumber)).fetchOne();
    }

    @Override
    @Transactional
    public Person addPerson() {
        Person newPerson = new Person();
        entityManager.persist(newPerson);
        return newPerson;
    }


    /*
    insert into vehicle(licenseplatenumber, typeofvehicle, color, yearofmanufacture, fuel, perform, p_id)
values ('KKK-999', 'Ford Mondeo', 'Yellow', TO_DATE('2017/09/03', 'yyyy/mm/dd'), 'diesel', 47, 25);

commit;

select * from vehicle;

insert into contract(status, typeofcontract, paket, price, p_id)
values('Vorschlag', 'KFZ', 'Vollcasco', 12, 25);

commit;

select * from contract;

insert into person(firstname, lastname, birthdate, gender, address, email, identitynumber)
values('Attila', 'Mustermann', TO_DATE('1989/04/22', 'yyyy/mm/dd'), 'Male', 'H - 9200 Gyor', 'attila.mustermann@activesolution.at', '698555');

     */
}
