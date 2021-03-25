package at.activesolution.repositories.custom.api;

import at.activesolution.entities.*;
import java.util.List;

public interface ICustomVersicherungSampleRepository {

    // GET ALL PERSONS WITH VEHICLES AND CONTRACTS
    List<Person> getPersonsWithVehiclesAndContracts();

    // GET SELECTED PERSON BY ID WITH VEHICLES AND CONTRACTS
    Person getOnePersonWithVehiclesAndContractsById(Long id);

    // GET SELECTED PERSON BY IDENTITY NUMBER WITH VEHICLES AND CONTRACTS
    Person getOnePersonWithVehiclesAndContractsByIdentityNumber(String identityNumber);

    // ADD NEW PERSON
    void addPerson(Person newPerson);

    // UPDATE PERSON
    Person updatePersonFirstname(Long id, String newFirstname);

    // DELETE PERSON
    void deletePerson(Long id);

}
