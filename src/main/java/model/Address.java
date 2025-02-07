package model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB-ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "STREET", nullable = false)
    private String street;

    @Column(name = "CITY", nullable = false)
    private String city;

    @Column(name = "STATE", nullable = false)
    private String state;

    @Column(name = "POSTAL_CODE", nullable = false)
    private String postalCode;

    @Column(name = "COUNTRY", nullable = false)
    private String country;

    @OneToOne(mappedBy = "studentAddress")
    private Student student;

    @OneToOne(mappedBy = "professorAddress")
    private Professor professor;

    public Address() {

    }

    public Address(Integer id, String street, String city, String state, String postalCode, String country, Student student, Professor professor) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.student = student;
        this.professor = professor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public boolean validate () {
        return street != null && !street.isEmpty() &&
                city != null && !city.isEmpty() &&
                state != null && !state.isEmpty() &&
                postalCode != null && !postalCode.isEmpty() &&
                country != null && !country.isEmpty();
    }

    public String outputAsLabel () {
        return street + ", " + city + " - " + state + ", " + postalCode + ", " + country;
    }
}
