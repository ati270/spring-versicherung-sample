package at.activesolution.repositories.custom.impl;

import at.activesolution.entities.Person;
import at.activesolution.entities.QPerson;
import at.activesolution.entities.QVehicle;
import at.activesolution.entities.Vehicle;
import at.activesolution.repositories.custom.api.ICustomVersicherungSampleRepository;
import com.querydsl.jpa.impl.JPAQuery;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Named
public class CustomVersicherungSampleRepository implements ICustomVersicherungSampleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Person> getOnePersonMoreVehicles() {
        final JPAQuery<Person> jpaQuery = new JPAQuery(entityManager);
        return jpaQuery.from(QPerson.person).select(QPerson.person).fetch();
    }
}
