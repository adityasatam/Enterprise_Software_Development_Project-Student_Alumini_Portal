package com.example.erp.dao.impl;

import com.example.erp.Global;
import com.example.erp.bean.Alumni;
import com.example.erp.bean.Courses;
import com.example.erp.bean.Students;
import com.example.erp.dao.StudentsDAO;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class StudentsDAOImpl implements StudentsDAO {
    @Override
    public void addStudent(Students student) {
        try (Session session = SessionUtil.getSession()) {
            session.beginTransaction();
            Integer id = (Integer) session.save(student);
            System.out.println("Student created with id:" + id);

            /////Checking...
//            Query query = session.createQuery("from Students where student_id= :id");
//            query.setLong("id", 4);
//            Students students = (Students) query.uniqueResult();
//            System.out.println("Employee Name="+students.getFirst_name()+", City="+students.getEmail());

            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStudent(Students student) {
        try (Session session = SessionUtil.getSession()) {
            session.beginTransaction();
            Query query = session.createQuery("update Students set first_name=:first_name, last_name=:last_name," +
                    "cgpa=:cgpa, graduation_year=: graduation_year, roll_number=: roll_number, total_credits=:total_credits," +
                    "email=:email where student_id=:id");
            query.setParameter("first_name", student.getFirst_name());
            query.setParameter("last_name", student.getLast_name());
            query.setParameter("cgpa", student.getCgpa());
            query.setParameter("graduation_year", student.getGraduation_year());
            query.setParameter("roll_number", student.getRoll_number());
            query.setParameter("email", student.getEmail());
            query.setParameter("total_credits", student.getTotal_credits());
            query.setParameter("id", Global.loginId);
            int result = query.executeUpdate();
            session.getTransaction().commit();
            System.out.println("No of rows updated: "+result);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Students getStudentDetails(Integer id) {
        try (Session session = SessionUtil.getSession()) {
            session.beginTransaction();
            /////Checking...
            Query query = session.createQuery("from Students where student_id= :id");
            query.setLong("id", id);
            Students student = (Students) query.uniqueResult();
            if(student.getStudent_id().equals(id)){
                return student;
            }
        } catch (Exception e){
            return null;
        }
        return null;
    }
}
