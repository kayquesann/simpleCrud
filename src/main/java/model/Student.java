package model;

public class Student extends Person {

    private String studentNumber;

    private String averageMark;

    public Student(String name, String phoneNumber, String emailAddress, String studentNumber, String averageMark) {
        super(name, phoneNumber, emailAddress);
        this.studentNumber = studentNumber;
        this.averageMark = averageMark;
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
