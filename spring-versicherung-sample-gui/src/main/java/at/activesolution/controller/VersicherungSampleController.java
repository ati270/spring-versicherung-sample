package at.activesolution.controller;

import at.activesolution.entities.Contract;
import at.activesolution.entities.Vehicle;
import at.activesolution.services.impl.VersicherungSampleServiceImpl;
import at.activesolution.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/persons")
public class VersicherungSampleController {

    @Autowired
    private VersicherungSampleServiceImpl versicherungSampleService;

    @GetMapping("/test")
    public String testMethod(){
        return "Test text";
    }
    // GET requests
    /*@GetMapping("/")  //same as @RequestMapping
    public List<Vehicle> getVehicles(){
        return versicherungSampleService.getVehicles();
    }*/

    /*@GetMapping("/persons/{id}")
    public Optional<Person> getVehicle(@PathVariable Long id){
        return versicherungSampleService.getPersonById(id);
    }*/

    // GET requests
    @GetMapping(value = "")
    public List<Person> getPersonWithVehiclesAndContracts(){
        return versicherungSampleService.getPersonsWithVehiclesAndContracts();
    }

    @GetMapping(value = "/id/{id}")
    public Person getOnePersonWithVehiclesAndContractsById(@PathVariable Long id){
        return versicherungSampleService.getOnePersonWithVehiclesAndContractsById(id);
    }

    @GetMapping(value = "/identitynumber/{identityNumber}")
    public Person getOnePersonWithVehiclesAndContractsByIdentityNumber(@PathVariable String identityNumber){
        return versicherungSampleService.getOnePersonWithVehiclesAndContractsByIdentityNumber(identityNumber);
    }

    // POST requests

    @PostMapping("")
    public Person addPerson(@Valid @RequestBody Person person){
        return versicherungSampleService.addPerson(person);
    }

    /*@PostMapping("")
    public Contract addContract(){}*/
}
