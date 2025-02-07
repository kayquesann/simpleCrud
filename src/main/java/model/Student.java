package model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB-STUDENT")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "NAME",nullable = false)
    private String name;

    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;

    @Column(name = "EMAIL_ADDRESS", nullable = false)
    private String emailAddress;

    @Column(name = "STUDENT_NUMBER")
    private String studentNumber;

    @Column(name = "AVERAGE_MARK")
    private double averageMark;

    @JoinColumn(name = "ID_ADDRESS")
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Address studentAddress;


    public Student () {

    }

    public Student(Integer id, String name, String phoneNumber, String emailAddress, String studentNumber, double averageMark, Address studentAddress) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.studentNumber = studentNumber;
        this.averageMark = averageMark;
        this.studentAddress = studentAddress;
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

    public Address getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(Address studentAddress) {
        this.studentAddress = studentAddress;
    }

    public boolean isEligibleToEnroll () {
        return averageMark >= 6.0;
    }

    public String getSeminarsTaken () {
        return "Seminários cursados por " + name;
    }

    public void purchaseParkingPass () {
        System.out.println(name + " comprou um passe de estacionamento.");
    }
}
