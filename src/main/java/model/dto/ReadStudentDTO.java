package model.dto;

import org.springframework.hateoas.RepresentationModel;

public class ReadStudentDTO extends RepresentationModel<ReadStudentDTO> {

    private Integer id;

    private String name;

    private String phoneNumber;

    private String emailAddress;

    private String cityName;

    private String studentNumber;

    private double averageMark;

    public ReadStudentDTO() {

    }

    public ReadStudentDTO(Integer id, String name, String phoneNumber, String emailAddress, String studentNumber, double averageMark, String cityName) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.cityName = cityName;
        this.studentNumber = studentNumber;
        this.averageMark = averageMark;
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

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }
}
