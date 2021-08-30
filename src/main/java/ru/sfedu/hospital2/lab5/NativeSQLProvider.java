/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.hospital2.lab5;

import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import ru.sfedu.hospital2.Constants;
import ru.sfedu.hospital2.lab5.model.*;

/**
 *
 * @author Liza
 */
public class NativeSQLProvider implements IProvider{
    private static final Logger log = LogManager.getLogger(NativeSQLProvider.class);


    private Session getSession() {
      return HibernateUtil.getSessionFactory().openSession();
    }  
    
    public Optional<Employee> getEmployee(long employeeId) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Employee> query = session.createQuery("select em from employee em where em.id=:id", Employee.class)
                .setParameter("id", employeeId);
        Employee employee = (Employee) query.getSingleResult();
        log.debug(query);
        session.getTransaction().commit();
        session.close();
        return Optional.ofNullable(employee);
    }
    
    
    @Override
    public Optional<List<Employee>> selectAllEmployee() {
      Session session = getSession();
      session.beginTransaction();
      try {
        String sql = Constants.NSQL_SELECT_EMPLOYEE;
        NativeQuery query = session.createSQLQuery(sql).addEntity(Employee.class);
        List resList = query.list();
        return resList != null ? Optional.of(resList) : Optional.empty();
      } catch (HibernateException e) {
        e.printStackTrace();
        return Optional.empty();
      } finally {
        session.close();
      }
    }

    @Override
    public Optional<List<Patient>> selectAllPatient() {
      Session session = getSession();
      session.beginTransaction();
      try {
        String sql = Constants.NSQL_SELECT_PATIENT;
        NativeQuery query = session.createSQLQuery(sql).addEntity(Patient.class);
        List resList = query.list();
        return resList != null ? Optional.of(resList) : Optional.empty();
      } catch (HibernateException e) {
        e.printStackTrace();
        return Optional.empty();
      } finally {
        session.close();
      }
    }

    @Override
    public Optional<List<Appointment>> selectAllAppointment() {
      Session session = getSession();
      session.beginTransaction();
      try {
        String sql = Constants.NSQL_SELECT_APPOINTMENT;
        NativeQuery query = session.createSQLQuery(sql).addEntity(Appointment.class);
        List resList = query.list();
        return resList != null ? Optional.of(resList) : Optional.empty();
      } catch (HibernateException e) {
        e.printStackTrace();
        return Optional.empty();
      } finally {
        session.close();
      }
    }

    @Override
    public Optional<List<Hospital>> selectAllHospital() {
      Session session = getSession();
      session.beginTransaction();
      try {
        String sql = Constants.NSQL_SELECT_HOSPITAL;
        NativeQuery query = session.createSQLQuery(sql).addEntity(Hospital.class);
        List resList = query.list();
        log.debug(resList.get(0));
        return resList != null ? Optional.of(resList) : Optional.empty();
      } catch (HibernateException e) {
        e.printStackTrace();
        return Optional.empty();
      } finally {
        session.close();
      }
    }
       
}