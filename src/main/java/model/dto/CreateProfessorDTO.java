package model.dto;

import model.Address;
import model.Professor;

public class CreateProfessorDTO {

    private String name;

    private String phoneNumber;

    private String emailAddress;

    private Address professorAddress;

    private double salary;

    public CreateProfessorDTO() {

    }

    public CreateProfessorDTO(String name, String phoneNumber, String emailAddress, Address professorAddress, double salary) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.professorAddress = professorAddress;
        this.salary = salary;
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

    public Address getProfessorAddress() {
        return professorAddress;
    }

    public void setProfessorAddress(Address professorAddress) {
        this.professorAddress = professorAddress;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}




