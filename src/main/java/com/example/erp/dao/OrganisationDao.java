package com.example.erp.dao;

import com.example.erp.bean.Alumni;
import com.example.erp.bean.AlumniOrganisation;
import com.example.erp.bean.Students;

import java.util.List;

public interface OrganisationDao {
    public abstract int alumniLogin(Alumni alumni);

    public abstract void addOrganisation(AlumniOrganisation alumniOrganisation);

    public abstract List<AlumniOrganisation> getOrganisationDetails(Integer id);

    public abstract AlumniOrganisation getOrganisationById(Integer id, Integer alumniId);

    public abstract void updateOrganisation(AlumniOrganisation alumniOrganisation);

    public abstract void deleteOrganisation(AlumniOrganisation alumniOrganisation);
}
