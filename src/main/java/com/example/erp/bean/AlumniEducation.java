package com.example.erp.bean;


import javax.persistence.*;

@Entity
@Table(name = "AlumniEducation")
public class AlumniEducation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer alumniEducationId;

    private Integer alumniId;
    private String degree;
    private String passingYear;
    private String joiningYear;
    private String collegeName;
    private String address;

    public AlumniEducation(){
    }

    public AlumniEducation(Integer alumniEducationId, Integer alumniId, String degree, String passingYear, String joiningYear, String collegeName, String address) {
        this.alumniEducationId = alumniEducationId;
        this.alumniId = alumniId;
        this.degree = degree;
        this.passingYear = passingYear;
        this.joiningYear = joiningYear;
        this.collegeName = collegeName;
        this.address = address;
    }

    public Integer getAlumniEducationId() {
        return alumniEducationId;
    }

    public void setAlumniEducationId(Integer alumniEducationId) {
        this.alumniEducationId = alumniEducationId;
    }

    public Integer getAlumniId() {
        return alumniId;
    }

    public void setAlumniId(Integer alumniId) {
        this.alumniId = alumniId;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getPassingYear() {
        return passingYear;
    }

    public void setPassingYear(String passingYear) {
        this.passingYear = passingYear;
    }

    public String getJoiningYear() {
        return joiningYear;
    }

    public void setJoiningYear(String joiningYear) {
        this.joiningYear = joiningYear;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
