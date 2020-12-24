package com.example.erp.services;

import com.example.erp.bean.Alumni;
import com.example.erp.bean.AlumniOrganisation;
import com.example.erp.dao.OrganisationDao;
import com.example.erp.dao.impl.OrganisationDAOImpl;


import java.util.List;

public class OrganisationService {
    OrganisationDao organisationDao = new OrganisationDAOImpl();
    public int alumniLogin(Alumni alumni){
        return organisationDao.alumniLogin(alumni);
    }

    public void addOrganisation(AlumniOrganisation alumniOrganisation){
        new OrganisationDAOImpl().addOrganisation(alumniOrganisation);
    }

    public AlumniOrganisation getOrganisationById(Integer id, Integer alumniId){
        return organisationDao.getOrganisationById(id, alumniId);
    }

    public void updateOrganisation(AlumniOrganisation alumniOrganisation){
        new OrganisationDAOImpl().updateOrganisation(alumniOrganisation);
    }

    public void deleteOrganisation(AlumniOrganisation alumniOrganisation){
        new OrganisationDAOImpl().deleteOrganisation(alumniOrganisation);
    }


    public List<AlumniOrganisation> getOrganisationDetails(Integer id){
        return organisationDao.getOrganisationDetails(id);
    }
}
