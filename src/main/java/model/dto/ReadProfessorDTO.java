package model.dto;

import org.springframework.hateoas.RepresentationModel;

public class ReadProfessorDTO extends RepresentationModel<ReadProfessorDTO> {

    private Integer id;

    private  String name;

    private String phoneNumber;

    private String emailAddress;

    private String cityName;

    private double salary;

    public ReadProfessorDTO() {

    }

    public ReadProfessorDTO(Integer id, String name, String phoneNumber, String emailAddress, String cityName, double salary) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.cityName = cityName;
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

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
