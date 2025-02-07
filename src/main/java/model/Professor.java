package model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB-PROFESSOR")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "NAME",nullable = false)
    private String name;

    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;

    @Column(name = "EMAIL_ADDRESS", nullable = false)
    private String emailAddress;

    @Column(name = "SALARY", nullable = false)
    private double salary;

    @JoinColumn(name = "ID_ADDRESS")
    @OneToOne
    private Address professorAddress;

    public Professor () {

    }

    public Professor(Integer id, String name, String phoneNumber, String emailAddress, double salary) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Address getProfessorAddress() {
        return professorAddress;
    }

    public void setProfessorAddress(Address professorAddress) {
        this.professorAddress = professorAddress;
    }

    public void purchaseParkingPass () {
        System.out.println(name + " comprou um passe de estacionamento.");
    }
}
