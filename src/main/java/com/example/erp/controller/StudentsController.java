package com.example.erp.controller;
import com.example.erp.*;
import com.example.erp.bean.Alumni;
import com.example.erp.bean.Students;
import com.example.erp.services.AlumniService;
import com.example.erp.services.StudentsService;
import com.example.erp.utils.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Path("students")
public class StudentsController {

    @POST
    @Path("/register")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerStudent(Students student) throws URISyntaxException {
        System.out.println(student.getFirst_name());
        System.out.println(student.getLast_name());
        System.out.println(student.getEmail());

        System.out.println("cgpa: "+ student.getCgpa());
        System.out.println(student.getTotal_credits());
        System.out.println(student.getGraduation_year());
        System.out.println(student.getRoll_number());

        StudentsService studentsService = new StudentsService();
        studentsService.addStudent(student);
        return Response.ok().build();

    }

    @POST
    @Path("/detailsupdate")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateStudent(Students student) throws URISyntaxException {
        System.out.println(student.getLast_name());
        System.out.println(student.getEmail());
        System.out.println("cgpa: "+ student.getCgpa());
        System.out.println(student.getTotal_credits());
        System.out.println(student.getGraduation_year());
        System.out.println(student.getRoll_number());
        StudentsService studentsService = new StudentsService();
        studentsService.updateStudent(student);
        return Response.ok().build();
    }

    @GET
    @Path("/getdetails")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentDetails() {
        List<String> studentDetails = new ArrayList<>();
        Integer id = Global.loginId;
        System.out.println("ID: "+ id);
        StudentsService studentsService = new StudentsService();
        Students student = studentsService.getStudentDetails(id);
//        if(student != null){
        Global.gStudent = student;
        System.out.println("StudentFname: "+ student.getFirst_name());
        System.out.println("Student Email: "+ student.getEmail());
        studentDetails.add(student.getFirst_name());
        studentDetails.add(student.getLast_name());
        studentDetails.add(student.getRoll_number());
        studentDetails.add(""+student.getGraduation_year());
        studentDetails.add(""+student.getCgpa());
        studentDetails.add(""+student.getTotal_credits());
        studentDetails.add(""+student.getEmail());
        return Response.ok().entity(studentDetails).build();
//        } else {
//            return Response.noContent().build();
//        }
    }
}
