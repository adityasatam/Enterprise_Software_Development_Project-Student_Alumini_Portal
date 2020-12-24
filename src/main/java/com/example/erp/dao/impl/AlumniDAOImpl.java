package com.example.erp.dao.impl;

import com.example.erp.Global;
import com.example.erp.bean.Alumni;
import com.example.erp.bean.AlumniEducation;
import com.example.erp.bean.Students;
import com.example.erp.dao.AlumniDao;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AlumniDAOImpl implements AlumniDao {
    @Override
    public int alumniLogin(Alumni alumni) {
        try (Session session = SessionUtil.getSession()) {
            session.beginTransaction();
            /////Checking...
            Query query = session.createQuery("from Alumni where alumni_id= :id");
            query.setLong("id", alumni.getAlumni_id());
            Alumni alumni1 = (Alumni) query.uniqueResult();
            System.out.println("Employee Name="+alumni1.getAlumni_id()+", City="+alumni1.getAlumni_password());
            if(alumni.getAlumni_id().equals(alumni1.getAlumni_id()) && alumni.getAlumni_password().equals(alumni1.getAlumni_password())){
                Global.loginId = alumni.getAlumni_id();
                Global.password = alumni.getAlumni_password();
                return 1;
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            return 0;
        }
        return 0;
    }

    @Override
    public void addEducation(AlumniEducation alumniEducation) {
        try (Session session = SessionUtil.getSession()) {
            session.beginTransaction();
            Integer id = (Integer) session.save(alumniEducation);
            System.out.println("Alumin Education created with id:" + id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<AlumniEducation> getEducationDetails(Integer id) {
        try (Session session = SessionUtil.getSession()) {
            List<AlumniEducation> alumniEducationList;
            session.beginTransaction();
            alumniEducationList= session.createQuery("from AlumniEducation where alumniId= :id").setLong("id", id).list();
//            AlumniEducation alumniEducation = (AlumniEducation) query.uniqueResult();
            System.out.println("edu"+ alumniEducationList.get(0).getDegree());
            return alumniEducationList;
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public AlumniEducation getEducationById(Integer id, Integer alumniId) {
        try (Session session = SessionUtil.getSession()) {
            session.beginTransaction();
            /////Checking...
            Query query = session.createQuery("from AlumniEducation where alumniEducationId= :id and alumniId=:alumniId");
            query.setLong("id", id);
            query.setLong("alumniId", alumniId);
            AlumniEducation alumniEducation = (AlumniEducation) query.uniqueResult();
            if(alumniEducation.getAlumniEducationId().equals(id)){
                return alumniEducation;
            }
        } catch (Exception e){
            return null;
        }
        return null;
    }

    @Override
    public void updateEducation(AlumniEducation alumniEducation) {
        try (Session session = SessionUtil.getSession()) {
            session.beginTransaction();
            Query query = session.createQuery("update AlumniEducation set address=:address, collegeName=:collegeName," +
                    "degree=:degree, joiningYear=: joiningYear, passingYear=: passingYear " +
                    "where alumniId=:alumniId and alumniEducationId=:id");
            query.setParameter("address", alumniEducation.getAddress());
            query.setParameter("collegeName", alumniEducation.getCollegeName());
            query.setParameter("degree", alumniEducation.getDegree());
            query.setParameter("joiningYear", alumniEducation.getJoiningYear());
            query.setParameter("passingYear", alumniEducation.getPassingYear());
            query.setParameter("alumniId", alumniEducation.getAlumniId());
            query.setParameter("id", alumniEducation.getAlumniEducationId());
            int result = query.executeUpdate();
            session.getTransaction().commit();
            System.out.println("No of rows updated: "+result);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEducation(AlumniEducation alumniEducation) {
        try (Session session = SessionUtil.getSession()) {
            session.beginTransaction();
            Query query = session.createQuery("delete from AlumniEducation where alumniEducationId= :id AND alumniId= :alumniId");
            query.setParameter("id", alumniEducation.getAlumniEducationId());
            query.setParameter("alumniId", alumniEducation.getAlumniId());
            int result = query.executeUpdate();
            session.getTransaction().commit();
            System.out.println("No of rows updated: "+result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
