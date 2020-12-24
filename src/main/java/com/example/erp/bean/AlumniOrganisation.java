package com.example.erp.bean;


import javax.persistence.*;

@Entity
@Table(name = "AlumniOrganisation")
public class AlumniOrganisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer alumni_org_id;
    private Integer alumni_id;
    private String alumni_org_name;
    private String alumni_org_position;
    private String alumni_org_joining_date;
    private String alumni_org_leaving_date;

    public AlumniOrganisation(){
    }

    public AlumniOrganisation(Integer alumni_org_id, Integer alumni_id, String alumni_org_name, String alumni_org_position, String alumni_org_joining_date, String alumni_org_leaving_date) {
        this.alumni_org_id = alumni_org_id;
        this.alumni_id = alumni_id;
        this.alumni_org_name = alumni_org_name;
        this.alumni_org_position = alumni_org_position;
        this.alumni_org_joining_date = alumni_org_joining_date;
        this.alumni_org_leaving_date = alumni_org_leaving_date;
    }

    public Integer getAlumni_Org_Id() {
        return alumni_org_id;
    }

    public void setAlumni_Org_Id(Integer alumni_org_id) {
        this.alumni_org_id = alumni_org_id;
    }

    public Integer getAlumni_Id() {
        return alumni_id;
    }

    public void setAlumni_Id(Integer alumni_id) {
        this.alumni_id = alumni_id;
    }

    public String getAlumni_Org_Name() {
        return alumni_org_name;
    }

    public void setAlumni_Org_Name(String alumni_org_name) {
        this.alumni_org_name = alumni_org_name;
    }

    public String getAlumni_Org_Position() {
        return alumni_org_position;
    }

    public void setAlumni_Org_Position(String alumni_org_position) {
        this.alumni_org_position = alumni_org_position;
    }

    public String getAlumni_Org_Joining_Date() {
        return alumni_org_joining_date;
    }

    public void setAlumni_Org_Joining_Date(String alumni_org_joining_date) {
        this.alumni_org_joining_date = alumni_org_joining_date;
    }

    public String getAlumni_Org_Leaving_Date() {
        return alumni_org_leaving_date;
    }

    public void setAlumni_Org_Leaving_Date(String alumni_org_leaving_date) {
        this.alumni_org_leaving_date = alumni_org_leaving_date;
    }
}
