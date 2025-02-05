package model;

import jakarta.persistence.*;

@Table
@Entity(name = "TB-STUDENT")
public class Student extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "STUDENT-NUMBER")
    private String studentNumber;

    @Column(name = "AVERAGE-MARK")
    private String averageMark;

    public Student () {

    }

    public Student(String name, String phoneNumber, String emailAddress, String studentNumber, String averageMark) {
        super(name, phoneNumber, emailAddress);
        this.studentNumber = studentNumber;
        this.averageMark = averageMark;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(String averageMark) {
        this.averageMark = averageMark;
    }

    public void isEligibleToEnroll () {

    }

    public void getSeminarsTaken () {

    }
}
