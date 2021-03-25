package at.activesolution.services.api;

import at.activesolution.entities.Contract;
import at.activesolution.entities.Person;
import at.activesolution.entities.Vehicle;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface IVersicherungSampleService {

    List<Person> getPersonsWithVehiclesAndContracts();

    Person getOnePersonWithVehiclesAndContractsById(Long id);

    Person getOnePersonWithVehiclesAndContractsByIdentityNumber(String identityNumber);

    void addPerson(Person newPerson);

    Person updatePersonFirstname(Long id, String newFirstname);

    void deletePerson(Long id);
}
