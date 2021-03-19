package at.activesolution.services.impl;

import at.activesolution.entities.Contract;
import at.activesolution.entities.Vehicle;
import at.activesolution.repositories.IVersicherungSampleRespository;
import at.activesolution.services.api.IVersicherungSampleService;
import at.activesolution.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VersicherungSampleServiceImpl implements IVersicherungSampleService {

    @Autowired
    private IVersicherungSampleRespository versicherungSampleRepository;

    @Override
    public List<Person> getPersons() {
        return versicherungSampleRepository.findAll();
    }

    @Override
    public Optional<Person> getPersonById(Long id) {
        return versicherungSampleRepository.findById(id);
    }


}
