package com.example.erp.dao.impl;

import com.example.erp.Global;
import com.example.erp.bean.Alumni;
import com.example.erp.bean.AlumniOrganisation;
import com.example.erp.bean.Students;
import com.example.erp.dao.OrganisationDao;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class OrganisationDAOImpl implements OrganisationDao {
    @Override
    public int alumniLogin(Alumni alumni) {
        try (Session session = SessionUtil.getSession()) {
            session.beginTransaction();
            /////Checking...
            Query query = session.createQuery("from Alumni where alumni_id= :id");
            query.setLong("id", alumni.getAlumni_id());
            Alumni alumni1 = (Alumni) query.uniqueResult();
            System.out.println("Id="+alumni1.getAlumni_id()+", Password="+alumni1.getAlumni_password());
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
    public void addOrganisation(AlumniOrganisation alumniOrganisation) {
        try (Session session = SessionUtil.getSession()) {
            session.beginTransaction();
            Integer id = (Integer) session.save(alumniOrganisation);
            System.out.println("Alumin Organisation created with id:" + id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<AlumniOrganisation> getOrganisationDetails(Integer id) {
        try (Session session = SessionUtil.getSession()) {
            List<AlumniOrganisation> alumniOrganisationList;
            session.beginTransaction();
            alumniOrganisationList= session.createQuery("from AlumniOrganisation where alumni_id= :id").setLong("id", id).list();
//            AlumniOrganisation alumniOrganisation = (AlumniOrganisation) query.uniqueResult();
            System.out.println("org"+ alumniOrganisationList.get(0).getAlumni_Org_Name());
            return alumniOrganisationList;
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public AlumniOrganisation getOrganisationById(Integer id, Integer alumniId) {
        try (Session session = SessionUtil.getSession()) {
            session.beginTransaction();
            /////Checking...
            Query query = session.createQuery("from AlumniOrganisation where alumni_org_id= :id and alumni_id=:alumniId");
            query.setLong("id", id);
            query.setLong("alumniId", alumniId);
            AlumniOrganisation alumniOrganisation = (AlumniOrganisation) query.uniqueResult();
            if(alumniOrganisation.getAlumni_Id().equals(id)){
                return alumniOrganisation;
            }
        } catch (Exception e){
            return null;
        }
        return null;
    }

    @Override
    public void updateOrganisation(AlumniOrganisation alumniOrganisation) {
        try (Session session = SessionUtil.getSession()) {
            session.beginTransaction();
            Query query = session.createQuery("update AlumniOrganisation set alumni_org_name=:alumni_org_name, alumni_org_position=:alumni_org_position," +
                    "alumni_org_joining_date=:alumni_org_joining_date, alumni_org_leaving_date=: alumni_org_leaving_date " +
                    "where alumni_id=:alumniId and alumni_org_id=:id");
            query.setParameter("alumni_org_name", alumniOrganisation.getAlumni_Org_Name());
            query.setParameter("alumni_org_position", alumniOrganisation.getAlumni_Org_Position());
            query.setParameter("alumni_org_joining_date", alumniOrganisation.getAlumni_Org_Joining_Date());
            query.setParameter("alumni_org_leaving_date", alumniOrganisation.getAlumni_Org_Leaving_Date());
            query.setParameter("alumniId", alumniOrganisation.getAlumni_Id());
            query.setParameter("id", alumniOrganisation.getAlumni_Org_Id());
            int result = query.executeUpdate();
            session.getTransaction().commit();
            System.out.println("No of rows updated: "+result);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrganisation(AlumniOrganisation alumniOrganisation) {
        try (Session session = SessionUtil.getSession()) {
            session.beginTransaction();
            Query query = session.createQuery("delete from AlumniOrganisation where alumni_org_id= :id AND alumni_id= :alumniId");
            query.setParameter("id", alumniOrganisation.getAlumni_Org_Id());
            query.setParameter("alumniId", alumniOrganisation.getAlumni_Id());
            int result = query.executeUpdate();
            session.getTransaction().commit();
            System.out.println("No of rows updated: "+result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
