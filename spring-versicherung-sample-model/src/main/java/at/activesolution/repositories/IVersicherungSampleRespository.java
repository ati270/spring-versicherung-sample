package at.activesolution.repositories;

import at.activesolution.entities.Contract;
import at.activesolution.entities.Person;
import at.activesolution.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface IVersicherungSampleRespository  extends JpaRepository<Person, Long> {


    @Query(value = "select v.PERFORM, P.ADDRESS from vehicle v inner join person P on v.P_ID = P.ID", nativeQuery = true)
    public List<Vehicle> getVehicles();
}

