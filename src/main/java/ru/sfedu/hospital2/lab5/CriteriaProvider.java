/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.hospital2.lab5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;
import org.hibernate.SessionFactory;
import ru.sfedu.hospital2.lab5.model.*;
import ru.sfedu.hospital2.utils.HibernateUtil;

/**
 *
 * @author Liza
 */
public class CriteriaProvider implements IProvider{
      private static final Logger log = LogManager.getLogger(CriteriaProvider.class);

      private Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
      }
      
      public Optional<Employee> getEmployee(long employeeId) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);
        criteriaQuery.select(employeeRoot).where(criteriaBuilder.equal(employeeRoot.get("id"), employeeId));
        Employee employee = session.createQuery(criteriaQuery).getSingleResult();
        session.getTransaction().commit();
        session.close();
        return Optional.ofNullable(employee);
    }
      
      
      @Override
      public Optional<List<Employee>> selectAllEmployee() {
        Session session = getSession();
        try {
          CriteriaBuilder cb = session.getCriteriaBuilder();
          CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
          Root<Employee> root = cr.from(Employee.class);
          cr.select(root);
          Query<Employee> query = session.createQuery(cr);
          List<Employee> resList = query.getResultList();
          return resList != null ? Optional.of(resList) : Optional.empty();
        } catch (Exception e) {
          log.error(e);
          session.close();
          return Optional.empty();
        }
      }

      @Override
      public Optional<List<Patient>> selectAllPatient() {
        Session session = getSession();
        try {
          CriteriaBuilder cb = session.getCriteriaBuilder();
          CriteriaQuery<Patient> cr = cb.createQuery(Patient.class);
          Root<Patient> root = cr.from(Patient.class);
          cr.select(root);
          Query<Patient> query = session.createQuery(cr);
          List<Patient> resList = query.getResultList();
          return resList != null ? Optional.of(resList) : Optional.empty();
        } catch (Exception e) {
          log.error(e);
          session.close();
          return Optional.empty();
        }
      }

      @Override
      public Optional<List<Appointment>> selectAllAppointment() {
        Session session = getSession();
        try {
          CriteriaBuilder cb = session.getCriteriaBuilder();
          CriteriaQuery<Appointment> cr = cb.createQuery(Appointment.class);
          Root<Appointment> root = cr.from(Appointment.class);
          cr.select(root);
          Query<Appointment> query = session.createQuery(cr);
          List<Appointment> resList = query.getResultList();
          return resList != null ? Optional.of(resList) : Optional.empty();
        } catch (Exception e) {
          log.error(e);
          session.close();
          return Optional.empty();
        }
      }

      @Override
      public Optional<List<Hospital>> selectAllHospital() {
        Session session = getSession();
        try {
          CriteriaBuilder cb = session.getCriteriaBuilder();
          CriteriaQuery<Hospital> cr = cb.createQuery(Hospital.class);
          Root<Hospital> root = cr.from(Hospital.class);
          cr.select(root);
          Query<Hospital> query = session.createQuery(cr);
          List<Hospital> resList = query.getResultList();
          return resList != null ? Optional.of(resList) : Optional.empty();
        } catch (Exception e) {
          log.error(e);
          session.close();
          return Optional.empty();
        }
      }

}
