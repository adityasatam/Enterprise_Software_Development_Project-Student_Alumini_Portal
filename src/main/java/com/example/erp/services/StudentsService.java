package com.example.erp.services;

import com.example.erp.bean.Students;
import com.example.erp.dao.StudentsDAO;
import com.example.erp.dao.impl.StudentsDAOImpl;


public class StudentsService {
    public void addStudent(Students student){
        new StudentsDAOImpl().addStudent(student);
    }

    public void updateStudent(Students student){
        new StudentsDAOImpl().updateStudent(student);
    }

    StudentsDAO studentsDAO = new StudentsDAOImpl();
    public Students getStudentDetails(Integer id){
        return studentsDAO.getStudentDetails(id);
    }
}
