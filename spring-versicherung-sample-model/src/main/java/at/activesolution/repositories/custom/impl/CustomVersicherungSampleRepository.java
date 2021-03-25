package at.activesolution.repositories.custom.impl;

import at.activesolution.entities.*;
import at.activesolution.repositories.custom.api.ICustomVersicherungSampleRepository;
import com.mysema.query.types.Custom;
import com.mysema.query.types.Param;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.jpa.HibernateQuery;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.TransactionManager;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import java.util.*;

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
    public void addPerson(Person newPerson) {

        entityManager.persist(newPerson);

        /*Set<Vehicle> vehicles = new HashSet<Vehicle>();
        Set<Contract> contracts = new HashSet<Contract>();

        Person newPerson = new Person();
        newPerson.setFirstname("TestFirstname");
        newPerson.setLastname("testLastname");
        newPerson.setEmail("testmail@mail.com");
        newPerson.setBirthDate(new Date("1978/12/11"));
        newPerson.setGender("Male");
        newPerson.setIdentityNumber("245689875");
        newPerson.setAddress("H - 1100 Budapest");
        newPerson.setContracts(contracts);
        newPerson.setVehicles(vehicles);

        Vehicle newVehicle = new Vehicle();
        newVehicle.setVehiclePerson(newPerson);
        newVehicle.setColor("RED");
        newVehicle.setLicensePlateNumber("TTT-345");
        newVehicle.setTypeOfVehicle("Nissan");
        newVehicle.setPerform(34);
        newVehicle.setPerform(50);

        Contract newContract = new Contract();
        newContract.setContractPerson(newPerson);
        newContract.setTypeOfContract("Kfz");
        newContract.setPaket("Vollcasco");
        newContract.setStatus("Vorschlag");
        newContract.setPrice(80);

        newPerson.getVehicles().add(newVehicle);
        newPerson.getContracts().add(newContract);
*/
    }

    @Override
    @Transactional
    public Person updatePersonFirstname(Long id, String newFirstname) {

        Person updatedPerson = entityManager.find(Person.class, id);
        updatedPerson.setFirstname(newFirstname);

        entityManager.persist(updatedPerson);

        return updatedPerson;
    }

    @Override
    @Transactional
    public void deletePerson(Long id) {
        Person deletedPerson = entityManager.find(Person.class, id);

        entityManager.remove(deletedPerson);
    }
}
