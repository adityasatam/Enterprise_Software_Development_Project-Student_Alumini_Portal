package com.example.erp.bean;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Alumni")
public class Alumni {
    @Id
    private Integer alumni_id;
    private String alumni_password;

    public Alumni(){

    }

    public Alumni(Integer alumni_id, String alumni_password) {
        this.alumni_id = alumni_id;
        this.alumni_password = alumni_password;
    }

    public Integer getAlumni_id() {
        return alumni_id;
    }

    public void setAlumni_id(Integer alumni_id) {
        this.alumni_id = alumni_id;
    }

    public String getAlumni_password() {
        return alumni_password;
    }

    public void setAlumni_password(String alumni_password) {
        this.alumni_password = alumni_password;
    }
}
