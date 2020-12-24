package com.example.erp.dao;

import com.example.erp.bean.Students;

public interface StudentsDAO {
    public abstract void addStudent(Students student);

    public abstract void updateStudent(Students student);

    public abstract Students getStudentDetails(Integer id);
}
