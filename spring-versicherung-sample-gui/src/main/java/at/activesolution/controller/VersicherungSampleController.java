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


    @GetMapping("/persons")
    public List<Person> getPersonWithVehiclesAndContracts(){
        return versicherungSampleService.getPersonWithVehiclesAndContracts();
    }
    // POST requests

    /*@PostMapping("")
    public Person addPerson(){}*/

    /*@PostMapping("")
    public Contract addContract(){}*/
}
