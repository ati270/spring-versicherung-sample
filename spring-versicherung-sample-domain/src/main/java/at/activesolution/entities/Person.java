package at.activesolution.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name = "person", schema = "versicherung_sample")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstname")
    @NotBlank(message = "Firstname is mandatory")
    private String firstname;

    @Column(name = "lastname")
    @NotBlank(message = "Lastname is mandatory")
    private String lastname;

    @Column(name = "birthdate")
    @NotBlank(message = "Birthdate is mandatory")
    private Date birthDate;

    @Column(name = "gender")
    private String gender;

    @Column(name = "address")
    private String address;

    @Email(message = "Email should be valid")
    @Column(name = "email")
    private String email;

    @Column(name = "identitynumber")
    @NotBlank(message = "ID number is mandatory")
    @Size(min = 3, max = 20, message = "ID number must be between 5 and 20 characters")
    private String identityNumber;

    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Column(nullable = true)
    @JsonManagedReference
    protected Set<Vehicle> vehicleList;


    public Person(){}

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Set<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(Set<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }
}
