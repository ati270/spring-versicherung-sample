package at.activesolution.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.Date;

@Entity
@Table(name = "vehicle", schema = "versicherung_sample")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

   @Column(name = "licenseplatenumber")
    private String licensePlateNumber;

    @Column(name = "typeofvehicle")
    private String typeOfVehicle;

    @Column(name = "color")
    @Null
    private String color;

    @Column(name = "yearofmanufacture")
    private Date yearOfManufacture;

    @Column(name = "fuel")
    private String fuel;

    @Column(name = "perform")
    private double perform;

    @ManyToOne(cascade = CascadeType.ALL)// lade es nur wenns benötigt(LAZY) sonst --> (default: eager)
    @JoinColumn(name = "P_ID")
    @JsonBackReference
    private Person person;

    public Vehicle(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public String getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public void setTypeOfVehicle(String typeOfVehicle) {
        this.typeOfVehicle = typeOfVehicle;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(Date yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public double getPerformance() { return perform; }

    public void setPerformance(double perform) {
        this.perform = perform;
    }
}
