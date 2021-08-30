/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.hospital2.lab5;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.Optional;
import org.hibernate.SessionFactory;
import ru.sfedu.hospital2.Constants;
import ru.sfedu.hospital2.lab5.model.*;
import ru.sfedu.hospital2.utils.HibernateUtil;

/**
 *
 * @author Liza
 */

public class HQLProvider implements IProvider {
    private static final Logger log = LogManager.getLogger(HQLProvider.class);

    private Session getSession() {
      return HibernateUtil.getSessionFactory().openSession();
    }
    
    public Optional<Employee> getEmployee(long employeeId) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from employee em where em.id=:id").setParameter("id", employeeId);
        Employee employee = (Employee) query.getSingleResult();
        log.debug(query);
        session.getTransaction().commit();
        session.close();
        return Optional.ofNullable(employee);
    }
    
    private <T> Optional<List<T>> selectAllEntity(String sqlQuery) {
      Session session = getSession();
      session.beginTransaction();
      try {
        Query query = session.createQuery(sqlQuery);
        List resList = query.getResultList();
        log.debug(resList);
        session.close();
        return resList != null ? Optional.of(resList) : Optional.empty();
      } catch (Exception e) {
        log.error(e);
        session.close();
        return Optional.empty();
      }
    }

    @Override
    public Optional<List<Employee>> selectAllEmployee() {
      return selectAllEntity(Constants.HQL_SELECT_EMPLOYEE);
    }

    @Override
    public Optional<List<Patient>> selectAllPatient() {
      return selectAllEntity(Constants.HQL_SELECT_PATIENT);
    }

    @Override
    public Optional<List<Appointment>> selectAllAppointment() {
      return selectAllEntity(Constants.HQL_SELECT_APPOINTMENT);
    }

    @Override
    public Optional<List<Hospital>> selectAllHospital() {
      return selectAllEntity(Constants.HQL_SELECT_HOSPITAL);
    }

}