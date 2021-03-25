package at.activesolution.services.impl;

import at.activesolution.entities.*;
import at.activesolution.repositories.IVersicherungSampleRespository;
import at.activesolution.repositories.custom.impl.CustomVersicherungSampleRepository;
import at.activesolution.services.api.IVersicherungSampleService;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class VersicherungSampleServiceImpl implements IVersicherungSampleService {

    VersicherungSampleServiceImpl(){ }

    @Autowired
    private IVersicherungSampleRespository versicherungSampleRepository;

    @Autowired
    private CustomVersicherungSampleRepository customVersicherungSampleRepository;

    @Override
    public List<Person> getPersonsWithVehiclesAndContracts() {
        return customVersicherungSampleRepository.getPersonsWithVehiclesAndContracts();
    }

    @Override
    public Person getOnePersonWithVehiclesAndContractsById(Long id) {
        return customVersicherungSampleRepository.getOnePersonWithVehiclesAndContractsById(id);
    }

    @Override
    public Person getOnePersonWithVehiclesAndContractsByIdentityNumber(String identityNumber) {
        return customVersicherungSampleRepository.getOnePersonWithVehiclesAndContractsByIdentityNumber(identityNumber);
    }

    @Override
    public void addPerson(Person newPerson) {
        customVersicherungSampleRepository.addPerson(newPerson);
    }

    @Override
    public Person updatePersonFirstname(Long id, String newFirstname) {
       return customVersicherungSampleRepository.updatePersonFirstname(id, newFirstname);
    }

    @Override
    public void deletePerson(Long id) {
        customVersicherungSampleRepository.deletePerson(id);
    }
}
