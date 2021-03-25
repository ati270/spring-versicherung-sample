package at.activesolution.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Table(name = "contract", schema = "versicherung_sample")
public class Contract {
    @Id
    @SequenceGenerator(name="CONTRACT_SEQ_GEN", sequenceName="contract_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONTRACT_SEQ_GEN")
    @Column(name = "id")
    private Long id;
    @Column(name = "status")
    private String status;

    @Column(name = "typeofcontract")
    private String typeOfContract;

    @Column(name = "paket")
    private String paket;

    @Column(name = "price")
    private double price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "P_ID")
    @JsonBackReference
    private Person contractPerson;

    public Contract(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTypeOfContract() {
        return typeOfContract;
    }

    public void setTypeOfContract(String typeOfContract) {
        this.typeOfContract = typeOfContract;
    }

    public String getPaket() {
        return paket;
    }

    public void setPaket(String paket) {
        this.paket = paket;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Person getContractPerson() {
        return contractPerson;
    }

    public void setContractPerson(Person contractPerson) {
        this.contractPerson = contractPerson;
    }
}
