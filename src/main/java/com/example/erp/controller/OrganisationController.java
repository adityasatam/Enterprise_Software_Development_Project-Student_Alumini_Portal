package com.example.erp.controller;

import com.example.erp.Global;
import com.example.erp.bean.Alumni;
import com.example.erp.bean.AlumniOrganisation;
import com.example.erp.bean.Students;
import com.example.erp.services.OrganisationService;
import com.example.erp.services.OrganisationService;
import com.example.erp.services.StudentsService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Path("org")
public class OrganisationController {
    @POST
    @Path("/login")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerStudent(Alumni alumni) throws URISyntaxException {
        System.out.println(alumni.getAlumni_id());
        System.out.println(alumni.getAlumni_password());

        OrganisationService organisationService = new OrganisationService();
        int result = organisationService.alumniLogin(alumni);
        if(result == 1){
            StudentsService studentsService = new StudentsService();
            Global.gStudent = studentsService.getStudentDetails(Global.loginId);
            return Response.ok().build();
        } else {
            return Response.noContent().build();
        }
    }

    @POST
    @Path("/getOrganisationById")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getOrganisationDetailsById(String str){
        List<String> alumniOrganisationList = new ArrayList<>();
        System.out.println(str);
        System.out.println("id:"+ str.charAt(6));
        int id = Integer.parseInt(""+str.charAt(6));
        System.out.println("id:"+ id);
        OrganisationService organisationService = new OrganisationService();
        AlumniOrganisation alumniOrganisation = organisationService.getOrganisationById(id, Global.loginId);
        System.out.println(alumniOrganisation.getAlumni_Org_Name());
        alumniOrganisationList.add(alumniOrganisation.getAlumni_Org_Name());
        alumniOrganisationList.add(alumniOrganisation.getAlumni_Org_Position());
        alumniOrganisationList.add(alumniOrganisation.getAlumni_Org_Joining_Date());
        alumniOrganisationList.add(alumniOrganisation.getAlumni_Org_Leaving_Date());
        return Response.ok().entity(alumniOrganisationList).build();
    }

    @POST
    @Path("/register_organisation")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerNewOrganisation(AlumniOrganisation alumniOrganisation) throws URISyntaxException {
        System.out.println(alumniOrganisation.getAlumni_Id());
        System.out.println(alumniOrganisation.getAlumni_Org_Name());
        System.out.println("Org Name2");
        alumniOrganisation.setAlumni_Id(Global.loginId);
        OrganisationService organisationService = new OrganisationService();
        organisationService.addOrganisation(alumniOrganisation);
        return Response.ok().build();
    }

    @POST
    @Path("/updateOrganisation")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateOrganisation(AlumniOrganisation alumniOrganisation) throws URISyntaxException {
        System.out.println(alumniOrganisation.getAlumni_Org_Name());
        alumniOrganisation.setAlumni_Id(Global.loginId);
        OrganisationService organisationService = new OrganisationService();
        organisationService.updateOrganisation(alumniOrganisation);
        return Response.ok().build();
    }

    @POST
    @Path("/deleteOrganisation")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteOrganisation(AlumniOrganisation alumniOrganisation) throws URISyntaxException {
        System.out.println(alumniOrganisation.getAlumni_Org_Name());
        alumniOrganisation.setAlumni_Id(Global.loginId);
        OrganisationService organisationService = new OrganisationService();
        organisationService.deleteOrganisation(alumniOrganisation);
        return Response.ok().build();
    }

    @GET
    @Path("/getorganisation")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentDetails() {
        List<String> organisationList = new ArrayList<>();
        Integer id = Global.loginId;
        System.out.println("ID: "+ id);
        OrganisationService organisationService = new OrganisationService();
        List<AlumniOrganisation> alumniOrganisation = organisationService.getOrganisationDetails(id);
        System.out.println("Org Name: "+ alumniOrganisation.get(0).getAlumni_Org_Name());
        organisationList.add(""+alumniOrganisation.size());
        organisationList.add(Global.gStudent.getFirst_name());
        organisationList.add(Global.gStudent.getLast_name());
        System.out.println("Org Name1: ");
        for (AlumniOrganisation organisation : alumniOrganisation) {
            organisationList.add((organisation.getAlumni_Org_Name()));
            organisationList.add((organisation.getAlumni_Org_Position()));
            organisationList.add((organisation.getAlumni_Org_Joining_Date()));
            organisationList.add((organisation.getAlumni_Org_Leaving_Date()));
            organisationList.add((""+organisation.getAlumni_Org_Id()));
        }
        return Response.ok().entity(organisationList).build();
    }
}
