package at.activesolution.controller;

import at.activesolution.entities.Contract;
import at.activesolution.entities.Vehicle;
import at.activesolution.services.impl.VersicherungSampleServiceImpl;
import at.activesolution.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class VersicherungSampleController {

    @Autowired
    private VersicherungSampleServiceImpl versicherungSampleService;

    // GET requests
    @GetMapping("")  //same as @RequestMapping
    public List<Person> getPersons(){
        return versicherungSampleService.getPersons();

    }

    @GetMapping("/{id}")
    public Optional<Person> getPerson(@PathVariable Long id){
        return versicherungSampleService.getPersonById(id);
    }
    // POST requests

    /*@PostMapping("")
    public Person addPerson(){}*/

    /*@PostMapping("")
    public Contract addContract(){}*/
}
