package model.dto;

import model.Professor;
import model.Student;
import org.springframework.hateoas.RepresentationModel;

public class ReadAddressDTO extends RepresentationModel<ReadAddressDTO> {

    private Integer id;

    private String street;

    private String city;

    private String state;

    private String postalCode;

    private String country;

    private Integer idProfessor;

    private Integer idStudent;

    public ReadAddressDTO() {

    }

    public ReadAddressDTO(Integer id, String street, String city, String state, String postalCode, String country, Integer idProfessor, Integer idStudent) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.idProfessor = idProfessor;
        this.idStudent = idStudent;
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

    public Integer getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Integer idProfessor) {
        this.idProfessor = idProfessor;
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }
}
