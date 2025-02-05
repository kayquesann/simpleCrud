package model;

import jakarta.persistence.*;

@Table
@Entity(name = "TB-PROFESSOR")
public class Professor extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "SALARY", nullable = false)
    private double salary;

    public Professor () {

    }

    public Professor(String name, String phoneNumber, String emailAddress, double salary) {
        super(name, phoneNumber, emailAddress);
        this.salary = salary;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
