package at.activesolution.repositories.custom.api;

import at.activesolution.entities.*;
import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public interface ICustomVersicherungSampleRepository {

    List<Person> getPersonWithVehiclesAndContracts();
}
