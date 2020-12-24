package com.example.erp.dao;

import com.example.erp.bean.Alumni;
import com.example.erp.bean.AlumniEducation;
import com.example.erp.bean.Students;

import java.util.List;

public interface AlumniDao {
    public abstract int alumniLogin(Alumni alumni);

    public abstract void addEducation(AlumniEducation alumniEducation);

    public abstract List<AlumniEducation> getEducationDetails(Integer id);

    public abstract AlumniEducation getEducationById(Integer id, Integer alumniId);

    public abstract void updateEducation(AlumniEducation alumniEducation);

    public abstract void deleteEducation(AlumniEducation alumniEducation);
}
