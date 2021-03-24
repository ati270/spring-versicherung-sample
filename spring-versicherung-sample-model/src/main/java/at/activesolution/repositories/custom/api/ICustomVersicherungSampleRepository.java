package at.activesolution.repositories.custom.api;

import at.activesolution.entities.*;
import java.util.List;

public interface ICustomVersicherungSampleRepository {

    List<Person> getPersonsWithVehiclesAndContracts();

    Person getOnePersonWithVehiclesAndContractsById(Long id);

    Person getOnePersonWithVehiclesAndContractsByIdentityNumber(String identityNumber);

    Person addPerson();

}
