/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.hospital2.lab3.MappedSuperClass;

import java.math.BigInteger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;
import java.util.Optional;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import ru.sfedu.hospital2.Constants;
import ru.sfedu.hospital2.enums.RequestStatus;
import ru.sfedu.hospital2.lab3.MappedSuperClass.HibernateUtil;
import ru.sfedu.hospital2.lab3.MappedSuperClass.DataProvider;
import ru.sfedu.hospital2.lab3.MappedSuperClass.model.Appointment;
import ru.sfedu.hospital2.lab3.MappedSuperClass.model.Diagnosis;
import ru.sfedu.hospital2.lab3.MappedSuperClass.model.Employee;
import ru.sfedu.hospital2.lab3.MappedSuperClass.model.Hospital;
import ru.sfedu.hospital2.lab3.MappedSuperClass.model.Hospitalization;
import ru.sfedu.hospital2.lab3.MappedSuperClass.model.MedicalInsurance;
import ru.sfedu.hospital2.lab3.MappedSuperClass.model.Patient;
import ru.sfedu.hospital2.lab3.MappedSuperClass.model.Payment;
import ru.sfedu.hospital2.lab3.MappedSuperClass.model.Survey;
/**
 *
 * @author Liza
 */
public class HibernateDataProvider implements DataProvider{
   private static final Logger log = LogManager.getLogger(HibernateDataProvider.class);

   /**
     * Get session
     * @return Session
     */
    public Session getSession(){
         return HibernateUtil.getSessionFactory().openSession();
    }
    
    /**
     * Get method
     * @param id
     * @return Optional Employee
     */   
    @Override
    public Optional<Employee> getEmployee (long id) {
        try{
            Session identSession = getSession();
            identSession.beginTransaction();
            NativeQuery query = identSession.createNativeQuery(String.format(Constants.MAPPED_EMPLOYEE_IDENT, id));
            log.debug(String.format(Constants.MAPPED_EMPLOYEE_IDENT, id));
            BigInteger result = (BigInteger) query.uniqueResult();
            if (result.compareTo(BigInteger.ZERO)==0){
                log.error(Constants.ERROR);
                return Optional.empty();
            }              
            Session session = getSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            log.debug(id);
            session.getTransaction().commit();
            session.close();
            log.info(employee.toString());
            return Optional.of(employee);
        }catch(HibernateException e){
            log.error(e);
            return Optional.empty();
        }
    }
    
     /**
     * Insert method
     * @param entity
     * @return RequestStatus
     */ 
    @Override
        public  RequestStatus createEmployee(Employee employee) {       
        try {
            Session session = getSession();
            session.beginTransaction();
            session.save(employee);
            log.debug(employee.toString());
            session.getTransaction().commit(); 
            session.close();
            log.info(RequestStatus.SUCCESS);
            return RequestStatus.SUCCESS;
        } catch (Exception e) {
            log.error(e);
          return RequestStatus.FAIL;
        }
    }
    
    /**
     * Delete method
     * @param id
     * @return RequestStatus
     */ 
    @Override
     public RequestStatus deleteEmployee(long id) {
         try{
            Session session = getSession();
            session.beginTransaction();
            Optional<Employee> entity = getEmployee(id);
            log.debug(id);
            if (entity.isPresent()) {               
                session.delete(entity.get());
                session.getTransaction().commit();
                session.close();
                log.info(RequestStatus.SUCCESS);
                return RequestStatus.SUCCESS;
            } else {
                log.info(RequestStatus.FAIL);
                return RequestStatus.FAIL;
            }
        } catch (Exception e) {
            log.error(e);
            return RequestStatus.FAIL;
        }
  }
     
    /**
     * Update method
     * @param employee
     * @return RequestStatus
     */ 
    @Override
    public RequestStatus updateEmployee(Employee employee) {
    try {
        Session session = getSession();
        session.beginTransaction();
        if (getEmployee(employee.getId()).isPresent()) {
                session.update(employee);
                session.getTransaction().commit();
                session.close();
                log.info(RequestStatus.SUCCESS);
                return RequestStatus.SUCCESS;
            } else {
                log.info(RequestStatus.FAIL);
                return RequestStatus.FAIL;
            }
      } catch (Exception e) {
        log.error(e);
        return RequestStatus.FAIL;
      }
    }
    
    /**
     * Get method
     * @param id
     * @return Optional Patient
     */   
    @Override
    public Optional<Patient> getPatient (long id) {
        try{
             Session identSession = getSession();
            identSession.beginTransaction();
            NativeQuery query = identSession.createNativeQuery(String.format(Constants.MAPPED_PATIENT_IDENT, id));
            log.debug(String.format(Constants.MAPPED_PATIENT_IDENT, id));
            BigInteger result = (BigInteger) query.uniqueResult();
            if (result.compareTo(BigInteger.ZERO)==0){
                log.error(Constants.ERROR);
                return Optional.empty();
            }              
            Session session = getSession();
            session.beginTransaction();
            Patient patient = session.get(Patient.class, id);
            log.debug(id);
            session.getTransaction().commit();
            session.close();
            log.info(patient.toString());
            return Optional.of(patient);
        }catch(HibernateException e){
            log.error(e);
            return Optional.empty();
        }
    }
    
     /**
     * Insert method
     * @param patient
     * @param entity
     * @return RequestStatus
     */ 
    @Override
        public  RequestStatus createPatient(Patient patient) {       
        try {
            Session session = getSession();
            session.beginTransaction();
            NativeQuery query = session.createNativeQuery(String.format(Constants.MAPPED_PASSPORT_IDENT, patient.getPassport()));          
            log.info(String.format(Constants.MAPPED_PASSPORT_IDENT, patient.getPassport()));
            BigInteger result = (BigInteger) query.uniqueResult();
            /*if (result.compareTo(BigInteger.ZERO)!=0){
                log.error(Constants.ALREADY);
                return RequestStatus.FAIL;
            }   */
            session.save(patient);
            log.debug(patient.toString());
            session.getTransaction().commit(); 
            session.close();
            log.info(RequestStatus.SUCCESS);
            return RequestStatus.SUCCESS;
        } catch (Exception e) {
            log.error(e);
          return RequestStatus.FAIL;
        }
    }
    
    /**
     * Delete method
     * @param id
     * @return RequestStatus
     */ 
    @Override
     public RequestStatus deletePatient(long id) {
         try{
            Session session = getSession();
            session.beginTransaction();
            Optional<Patient> entity = getPatient(id);
            log.debug(id);
            if (entity.isPresent()) {
                session.delete(entity.get());
                session.getTransaction().commit();
                session.close();
                log.info(RequestStatus.SUCCESS);
                return RequestStatus.SUCCESS;
            } else {
                log.info(RequestStatus.FAIL);
                return RequestStatus.FAIL;
            }
        } catch (Exception e) {
            log.error(e);
            return RequestStatus.FAIL;
        }
  }
     
    /**
     * Update method
     * @param entity
     * @return RequestStatus
     */ 
    @Override
    public RequestStatus updatePatient(Patient patient) {
    try {
        Session session = getSession();
        session.beginTransaction();
        if (getPatient(patient.getId()).isPresent()) {
                session.update(patient);
                session.getTransaction().commit();
                session.close();
                log.info(RequestStatus.SUCCESS);
                return RequestStatus.SUCCESS;
            } else {
                log.info(RequestStatus.FAIL);
                return RequestStatus.FAIL;
            }
      } catch (Exception e) {
        log.error(e);
        return RequestStatus.FAIL;
      }
    }
    
    /**
     * Get method
     * @param id
     * @return Optional Appointment
     */   
    @Override
    public Optional<Appointment> getAppointment (long id) {
        try{
            Session identSession = getSession();
            identSession.beginTransaction();
            NativeQuery query = identSession.createNativeQuery(String.format(Constants.MAPPED_APPOINTMENT_IDENT, id));
            log.debug(String.format(Constants.MAPPED_APPOINTMENT_IDENT, id));
            BigInteger result = (BigInteger) query.uniqueResult();
            if (result.compareTo(BigInteger.ZERO)==0){
                log.error(Constants.ERROR);
                return Optional.empty();
            }   
            Session session = getSession();
            session.beginTransaction();
            Appointment appointment = session.get(Appointment.class, id);
            log.debug(id);
            session.getTransaction().commit();
            session.close();
            log.info(appointment.toString());
            return Optional.of(appointment);
        }catch(HibernateException e){
            log.error(e);
            return Optional.empty();
        }
    }
    
     /**
     * Insert method
     * @param appointment
     * @param entity
     * @return RequestStatus
     */ 
    @Override
        public  RequestStatus createAppointment(Appointment appointment) {       
        try {
            Session session = getSession();
            session.beginTransaction();
            NativeQuery employee = session.createNativeQuery(String.format(Constants.MAPPED_EMPLOYEE_IDENT, appointment.getDoctorId()));          
            NativeQuery patient = session.createNativeQuery(String.format(Constants.MAPPED_PATIENT_IDENT, appointment.getPatientId()));          
            log.info(String.format(Constants.MAPPED_EMPLOYEE_IDENT, appointment.getDoctorId()));
            log.info(String.format(Constants.MAPPED_PATIENT_IDENT, appointment.getPatientId()));            
            BigInteger employeeResult = (BigInteger) employee.uniqueResult();
            BigInteger patientResult = (BigInteger) patient.uniqueResult();
            if (patientResult.compareTo(BigInteger.ZERO)==0||employeeResult.compareTo(BigInteger.ZERO)==0){
                log.error(Constants.ERROR);
                return RequestStatus.FAIL;
            }              
            session.save(appointment);
            log.debug(appointment.toString());
            session.getTransaction().commit(); 
            session.close();
            log.info(RequestStatus.SUCCESS);
            return RequestStatus.SUCCESS;
        } catch (Exception e) {
            log.error(e);
          return RequestStatus.FAIL;
        }
    }
    
    /**
     * Delete method
     * @param id
     * @return RequestStatus
     */ 
    @Override
     public RequestStatus deleteAppointment(long id) {
         try{
            Session session = getSession();
            session.beginTransaction();
            Optional<Appointment> entity = getAppointment(id);
            log.debug(id);
            if (entity.isPresent()) {
                session.delete(entity.get());
                session.getTransaction().commit();
                session.close();
                log.info(RequestStatus.SUCCESS);
                return RequestStatus.SUCCESS;
            } else {
                log.info(RequestStatus.FAIL);
                return RequestStatus.FAIL;
            }
        } catch (Exception e) {
            log.error(e);
            return RequestStatus.FAIL;
        }
  }
     
    /**
     * Update method
     * @param entity
     * @return RequestStatus
     */ 
    @Override
    public RequestStatus updateAppointment(Appointment appointment) {
    try {
        Session session = getSession();
        session.beginTransaction();
        if (getAppointment(appointment.getId()).isPresent()) {
                session.update(appointment);
                session.getTransaction().commit();
                session.close();
                log.info(RequestStatus.SUCCESS);
                return RequestStatus.SUCCESS;
            } else {
                log.info(RequestStatus.FAIL);
                return RequestStatus.FAIL;
            }
      } catch (Exception e) {
        log.error(e);
        return RequestStatus.FAIL;
      }
    }
    
    /**
     * Get method
     * @param id
     * @return Optional Survey
     */   
    @Override
    public Optional<Survey> getSurvey (long id) {
        try{
            Session identSession = getSession();
            identSession.beginTransaction();
            NativeQuery query = identSession.createNativeQuery(String.format(Constants.MAPPED_SURVEY_IDENT, id));
            log.debug(String.format(Constants.MAPPED_SURVEY_IDENT, id));
            BigInteger result = (BigInteger) query.uniqueResult();
            if (result.compareTo(BigInteger.ZERO)==0){
                log.error(Constants.ERROR);
                return Optional.empty();
            }              
            Session session = getSession();
            session.beginTransaction();
            Survey survey = session.get(Survey.class, id);
            log.debug(id);
            session.getTransaction().commit();
            session.close();
            log.info(survey.toString());
            return Optional.of(survey);
        }catch(HibernateException e){
            log.error(e);
            return Optional.empty();
        }
    }
    
     /**
     * Insert method
     * @param survey
     * @param entity
     * @return RequestStatus
     */ 
    @Override
        public  RequestStatus createSurvey(Survey survey) {       
        try {
            Session session = getSession();
            session.beginTransaction();
            NativeQuery employee = session.createNativeQuery(String.format(Constants.MAPPED_EMPLOYEE_IDENT, survey.getDoctorId()));          
            NativeQuery patient = session.createNativeQuery(String.format(Constants.MAPPED_PATIENT_IDENT, survey.getPatientId()));          
            log.info(String.format(Constants.MAPPED_EMPLOYEE_IDENT, survey.getDoctorId()));
            log.info(String.format(Constants.MAPPED_PATIENT_IDENT, survey.getPatientId()));
            BigInteger employeeResult = (BigInteger) employee.uniqueResult();
            BigInteger patientResult = (BigInteger) patient.uniqueResult();
            if (employeeResult.compareTo(BigInteger.ZERO)==0||patientResult.compareTo(BigInteger.ZERO)==0){
                log.error(Constants.ERROR);
                return RequestStatus.FAIL;
            }   
            session.save(survey);
            log.debug(survey.toString());
            session.getTransaction().commit(); 
            session.close();
            log.info(RequestStatus.SUCCESS);
            return RequestStatus.SUCCESS;
        } catch (Exception e) {
            log.error(e);
          return RequestStatus.FAIL;
        }
    }
    
    /**
     * Delete method
     * @param id
     * @return RequestStatus
     */ 
    @Override
     public RequestStatus deleteSurvey(long id) {
         try{
            Session session = getSession();
            session.beginTransaction();
            Optional<Survey> entity = getSurvey(id);
            log.debug(id);
            if (entity.isPresent()) {
                session.delete(entity.get());
                session.getTransaction().commit();
                session.close();
                log.info(RequestStatus.SUCCESS);
                return RequestStatus.SUCCESS;
            } else {
                log.info(RequestStatus.FAIL);
                return RequestStatus.FAIL;
            }
        } catch (Exception e) {
            log.error(e);
            return RequestStatus.FAIL;
        }
  }
     
    /**
     * Update method
     * @param entity
     * @return RequestStatus
     */ 
    @Override
    public RequestStatus updateSurvey(Survey survey) {
    try {
        Session session = getSession();
        session.beginTransaction();
        if (getSurvey(survey.getId()).isPresent()) {
                session.update(survey);
                session.getTransaction().commit();
                session.close();
                log.info(RequestStatus.SUCCESS);
                return RequestStatus.SUCCESS;
            } else {
                log.info(RequestStatus.FAIL);
                return RequestStatus.FAIL;
            }
      } catch (Exception e) {
        log.error(e);
        return RequestStatus.FAIL;
      }
    }
    
    /**
     * Get method
     * @param id
     * @return Optional Hospitalization
     */   
    @Override
    public Optional<Hospitalization> getHospitalization (long id) {
        try{
            Session identSession = getSession();
            identSession.beginTransaction();
            NativeQuery query = identSession.createNativeQuery(String.format(Constants.MAPPED_HOSPITALIZATION_IDENT, id));
            log.debug(String.format(Constants.MAPPED_HOSPITALIZATION_IDENT, id));
            BigInteger result = (BigInteger) query.uniqueResult();
            if (result.compareTo(BigInteger.ZERO)==0){
                log.error(Constants.ERROR);
                return Optional.empty();
            }              
            Session session = getSession();
            session.beginTransaction();
            Hospitalization hospitalization = session.get(Hospitalization.class, id);
            log.debug(id);
            session.getTransaction().commit();
            session.close();
            log.info(hospitalization.toString());
            return Optional.of(hospitalization);
        }catch(HibernateException e){
            log.error(e);
            return Optional.empty();
        }
    }
    
     /**
     * Insert method
     * @param hospitalization
     * @param entity
     * @return RequestStatus
     */ 
    @Override
        public  RequestStatus createHospitalization(Hospitalization hospitalization) {       
        try {
            Session session = getSession();
            session.beginTransaction();
            NativeQuery service = session.createNativeQuery(String.format(Constants.MAPPED_SERVICE_IDENT, hospitalization.getServiceId()));          
            NativeQuery hospital = session.createNativeQuery(String.format(Constants.MAPPED_HOSPITAL_IDENT, hospitalization.getHospitalId()));          
            log.info(Constants.MAPPED_SERVICE_IDENT, Constants.MAPPED_HOSPITAL_IDENT);
            BigInteger serviceResult = (BigInteger) service.uniqueResult();
            BigInteger hospitalResult = (BigInteger) hospital.uniqueResult();
            if (serviceResult.compareTo(BigInteger.ZERO)==0||hospitalResult.compareTo(BigInteger.ZERO)==0){
                log.error(Constants.ERROR);
                return RequestStatus.FAIL;
            }      
            session.save(hospitalization);
            log.debug(hospitalization.toString());
            session.getTransaction().commit(); 
            session.close();
            log.info(RequestStatus.SUCCESS);
            return RequestStatus.SUCCESS;
        } catch (Exception e) {
            log.error(e);
          return RequestStatus.FAIL;
        }
    }
    
    /**
     * Delete method
     * @param id
     * @return RequestStatus
     */ 
    @Override
     public RequestStatus deleteHospitalization(long id) {
         try{
            Session session = getSession();
            session.beginTransaction();
            Optional<Hospitalization> entity = getHospitalization(id);
            log.debug(id);
            if (entity.isPresent()) {
                session.delete(entity.get());
                session.getTransaction().commit();
                session.close();
                log.info(RequestStatus.SUCCESS);
                return RequestStatus.SUCCESS;
            } else {
                log.info(RequestStatus.FAIL);
                return RequestStatus.FAIL;
            }
        } catch (Exception e) {
            log.error(e);
            return RequestStatus.FAIL;
        }
  }
     
    /**
     * Update method
     * @param entity
     * @return RequestStatus
     */ 
    @Override
    public RequestStatus updateHospitalization(Hospitalization hospitalization) {
    try {
        Session session = getSession();
        session.beginTransaction();
        if (getHospitalization(hospitalization.getId()).isPresent()) {
                session.update(hospitalization);
                session.getTransaction().commit();
                session.close();
                log.info(RequestStatus.SUCCESS);
                return RequestStatus.SUCCESS;
            } else {
                log.info(RequestStatus.FAIL);
                return RequestStatus.FAIL;
            }
      } catch (Exception e) {
        log.error(e);
        return RequestStatus.FAIL;
      }
    }
    
    /**
     * Get method
     * @param id
     * @return Optional MedicalInsurance
     */   
    @Override
    public Optional<MedicalInsurance> getMedicalInsurance (long id) {
        try{
             Session identSession = getSession();
            identSession.beginTransaction();
            NativeQuery query = identSession.createNativeQuery(String.format(Constants.MAPPED_MEDICALINSURANCE_IDENT, id));
            log.debug(String.format(Constants.MAPPED_MEDICALINSURANCE_IDENT, id));
            BigInteger result = (BigInteger) query.uniqueResult();
            if (result.compareTo(BigInteger.ZERO)==0){
                log.error(Constants.ERROR);
                return Optional.empty();
            }
            Session session = getSession();
            session.beginTransaction();
            MedicalInsurance medicalInsurance = session.get(MedicalInsurance.class, id);
            log.debug(id);
            session.getTransaction().commit();
            session.close();
            log.info(medicalInsurance.toString());
            return Optional.of(medicalInsurance);
        }catch(HibernateException e){
            log.error(e);
            return Optional.empty();
        }
    }
    
     /**
     * Insert method
     * @param medicalInsurance
     * @param entity
     * @return RequestStatus
     */ 
    @Override
        public  RequestStatus createMedicalInsurance(MedicalInsurance medicalInsurance) {       
        try {
            Session session = getSession();
            session.beginTransaction();
            NativeQuery service = session.createNativeQuery(String.format(Constants.MAPPED_SERVICE_IDENT, medicalInsurance.getServiceId()));          
            log.info(Constants.MAPPED_SERVICE_IDENT);
            BigInteger serivceResult = (BigInteger) service.uniqueResult();
            if (serivceResult.compareTo(BigInteger.ZERO)==0){
                log.error(Constants.ERROR);
                return RequestStatus.FAIL;
            }   
   
            session.save(medicalInsurance);
            log.debug(medicalInsurance.toString());
            session.getTransaction().commit(); 
            session.close();
            log.info(RequestStatus.SUCCESS);
            return RequestStatus.SUCCESS;
        } catch (Exception e) {
            log.error(e);
          return RequestStatus.FAIL;
        }
    }
    
    /**
     * Delete method
     * @param id
     * @return RequestStatus
     */ 
    @Override
     public RequestStatus deleteMedicalInsurance(long id) {
         try{
            Session session = getSession();
            session.beginTransaction();
            Optional<MedicalInsurance> entity = getMedicalInsurance(id);
            log.debug(id);
            if (entity.isPresent()) {
                session.delete(entity.get());
                session.getTransaction().commit();
                session.close();
                log.info(RequestStatus.SUCCESS);
                return RequestStatus.SUCCESS;
            } else {
                log.info(RequestStatus.FAIL);
                return RequestStatus.FAIL;
            }
        } catch (Exception e) {
            log.error(e);
            return RequestStatus.FAIL;
        }
  }
     
    /**
     * Update method
     * @param entity
     * @return RequestStatus
     */ 
    @Override
    public RequestStatus updateMedicalInsurance(MedicalInsurance medicalInsurance) {
    try {
        Session session = getSession();
        session.beginTransaction();
        if (getMedicalInsurance(medicalInsurance.getId()).isPresent()) {
                session.update(medicalInsurance);
                session.getTransaction().commit();
                session.close();
                log.info(RequestStatus.SUCCESS);
                return RequestStatus.SUCCESS;
            } else {
                log.info(RequestStatus.FAIL);
                return RequestStatus.FAIL;
            }
      } catch (Exception e) {
        log.error(e);
        return RequestStatus.FAIL;
      }
    }
    
    /**
     * Get method
     * @param id
     * @return Optional Payment
     */   
    @Override
    public Optional<Payment> getPayment (long id) {
        try{
            Session identSession = getSession();
            identSession.beginTransaction();
            NativeQuery query = identSession.createNativeQuery(String.format(Constants.MAPPED_PAYMENT_IDENT, id));
            log.debug(String.format(Constants.MAPPED_PAYMENT_IDENT, id));
            BigInteger result = (BigInteger) query.uniqueResult();
            if (result.compareTo(BigInteger.ZERO)==0){
                log.error(Constants.ERROR);
                return Optional.empty();
            }    
            Session session = getSession();
            session.beginTransaction();
            Payment payment = session.get(Payment.class, id);
            log.debug(id);
            session.getTransaction().commit();
            session.close();
            log.info(payment.toString());
            return Optional.of(payment);
        }catch(HibernateException e){
            log.error(e);
            return Optional.empty();
        }
    }
    
     /**
     * Insert method
     * @param payment
     * @param entity
     * @return RequestStatus
     */ 
    @Override
        public  RequestStatus createPayment(Payment payment) {       
        try {
            Session session = getSession();
            session.beginTransaction();
            NativeQuery service = session.createNativeQuery(String.format(Constants.MAPPED_SERVICE_IDENT, payment.getServiceId()));          
            log.info(Constants.MAPPED_SERVICE_IDENT);
            BigInteger employeeResult = (BigInteger) service.uniqueResult();
            if (employeeResult.compareTo(BigInteger.ZERO)==0){
                log.error(Constants.ERROR);
                return RequestStatus.FAIL;
            }    
            session.save(payment);
            log.debug(payment.toString());
            session.getTransaction().commit(); 
            session.close();
            log.info(RequestStatus.SUCCESS);
            return RequestStatus.SUCCESS;
        } catch (Exception e) {
            log.error(e);
          return RequestStatus.FAIL;
        }
    }
    
    /**
     * Delete method
     * @param id
     * @return RequestStatus
     */ 
    @Override
     public RequestStatus deletePayment(long id) {
         try{
            Session session = getSession();
            session.beginTransaction();
            Optional<Payment> entity = getPayment(id);
            log.debug(id);
            if (entity.isPresent()) {
                session.delete(entity.get());
                session.getTransaction().commit();
                session.close();
                log.info(RequestStatus.SUCCESS);
                return RequestStatus.SUCCESS;
            } else {
                log.info(RequestStatus.FAIL);
                return RequestStatus.FAIL;
            }
        } catch (Exception e) {
            log.error(e);
            return RequestStatus.FAIL;
        }
  }
     
    /**
     * Update method
     * @param entity
     * @return RequestStatus
     */ 
    @Override
    public RequestStatus updatePayment(Payment payment) {
    try {
        Session session = getSession();
        session.beginTransaction();
        if (getPayment(payment.getId()).isPresent()) {
                session.update(payment);
                session.getTransaction().commit();
                session.close();
                log.info(RequestStatus.SUCCESS);
                return RequestStatus.SUCCESS;
            } else {
                log.info(RequestStatus.FAIL);
                return RequestStatus.FAIL;
            }
      } catch (Exception e) {
        log.error(e);
        return RequestStatus.FAIL;
      }
    }
    
    /**
     * Get method
     * @param id
     * @return Optional Diagnosis
     */   
    @Override
    public Optional<Diagnosis> getDiagnosis (long id) {
        try{
            Session identSession = getSession();
            identSession.beginTransaction();
            NativeQuery query = identSession.createNativeQuery(String.format(Constants.MAPPED_DIAGNOSIS_IDENT, id));
            log.debug(String.format(Constants.MAPPED_DIAGNOSIS_IDENT, id));
            BigInteger result = (BigInteger) query.uniqueResult();
            if (result.compareTo(BigInteger.ZERO)==0){
                log.error(Constants.ERROR);
                return Optional.empty();
            }              
            Session session = getSession();
            session.beginTransaction();
            Diagnosis diagnosis = session.get(Diagnosis.class, id);
            log.debug(id);
            session.getTransaction().commit();
            session.close();
            log.info(diagnosis.toString());
            return Optional.of(diagnosis);
        }catch(HibernateException e){
            log.error(e);
            return Optional.empty();
        }
    }
    
     /**
     * Insert method
     * @param diagnosis
     * @param entity
     * @return RequestStatus
     */ 
    @Override
        public  RequestStatus createDiagnosis(Diagnosis diagnosis) {       
        try {
            Session session = getSession();
            session.beginTransaction();
            NativeQuery service = session.createNativeQuery(String.format(Constants.MAPPED_SURVEY_IDENT, diagnosis.getServiceId()));          
            //NativeQuery patient = session.createNativeQuery(String.format(Constants.PATIENT_IDENT, diagnosis.getPatientId()));          
            log.info(String.format(Constants.MAPPED_SURVEY_IDENT, diagnosis.getServiceId()));
            //log.info(String.format(Constants.PATIENT_IDENT, diagnosis.getPatientId()));
            BigInteger serviceResult = (BigInteger) service.uniqueResult();
            //BigInteger patientResult = (BigInteger) patient.uniqueResult();
            if (serviceResult.compareTo(BigInteger.ZERO)==0){//||patientResult.compareTo(BigInteger.ZERO)==0){
                log.error(Constants.ERROR);
                return RequestStatus.FAIL;
            }   

            session.save(diagnosis);
            log.debug(diagnosis.toString());
            session.getTransaction().commit(); 
            session.close();
            log.info(RequestStatus.SUCCESS);
            return RequestStatus.SUCCESS;
        } catch (Exception e) {
            log.error(e);
          return RequestStatus.FAIL;
        }
    }
    
    /**
     * Delete method
     * @param id
     * @return RequestStatus
     */ 
    @Override
     public RequestStatus deleteDiagnosis(long id) {
         try{
            Session session = getSession();
            session.beginTransaction();
            Optional<Diagnosis> entity = getDiagnosis(id);
            log.debug(id);
            if (entity.isPresent()) {
                session.delete(entity.get());
                session.getTransaction().commit();
                session.close();
                log.info(RequestStatus.SUCCESS);
                return RequestStatus.SUCCESS;
            } else {
                log.info(RequestStatus.FAIL);
                return RequestStatus.FAIL;
            }
        } catch (Exception e) {
            log.error(e);
            return RequestStatus.FAIL;
        }
  }
     
    /**
     * Update method
     * @param entity
     * @return RequestStatus
     */ 
    @Override
    public RequestStatus updateDiagnosis(Diagnosis diagnosis) {
    try {
        Session session = getSession();
        session.beginTransaction();
        if (getDiagnosis(diagnosis.getId()).isPresent()) {
                session.update(diagnosis);
                session.getTransaction().commit();
                session.close();
                log.info(RequestStatus.SUCCESS);
                return RequestStatus.SUCCESS;
            } else {
                log.info(RequestStatus.FAIL);
                return RequestStatus.FAIL;
            }
      } catch (Exception e) {
        log.error(e);
        return RequestStatus.FAIL;
      }
    }
    
    /**
     * Get method
     * @param id
     * @return Optional Hospital
     */   
    @Override
    public Optional<Hospital> getHospital (long id) {
        try{
             Session identSession = getSession();
            identSession.beginTransaction();
            NativeQuery query = identSession.createNativeQuery(String.format(Constants.MAPPED_HOSPITAL_IDENT, id));
            log.debug(String.format(Constants.MAPPED_HOSPITAL_IDENT, id));
            BigInteger result = (BigInteger) query.uniqueResult();
            if (result.compareTo(BigInteger.ZERO)==0){
                log.error(Constants.ERROR);
                return Optional.empty();
            }       
            Session session = getSession();
            session.beginTransaction();
            Hospital hospital = session.get(Hospital.class, id);
            log.debug(id);
            session.getTransaction().commit();
            session.close();
            log.info(hospital.toString());
            return Optional.of(hospital);
        }catch(HibernateException e){
            log.error(e);
            return Optional.empty();
        }
    }
    
     /**
     * Insert method
     * @param hospital
     * @param entity
     * @return RequestStatus
     */ 
    @Override
        public  RequestStatus createHospital(Hospital hospital) {       
        try {
            Session session = getSession();
            session.beginTransaction();
            session.save(hospital);
            log.debug(hospital.toString());
            session.getTransaction().commit(); 
            session.close();
            log.info(RequestStatus.SUCCESS);
            return RequestStatus.SUCCESS;
        } catch (Exception e) {
            log.error(e);
          return RequestStatus.FAIL;
        }
    }
    
    /**
     * Delete method
     * @param id
     * @return RequestStatus
     */ 
    @Override
     public RequestStatus deleteHospital(long id) {
         try{
            Session session = getSession();
            session.beginTransaction();
            Optional<Hospital> entity = getHospital(id);
            log.debug(id);
            if (entity.isPresent()) {
                session.delete(entity.get());
                session.getTransaction().commit();
                session.close();
                log.info(RequestStatus.SUCCESS);
                return RequestStatus.SUCCESS;
            } else {
                log.info(RequestStatus.FAIL);
                return RequestStatus.FAIL;
            }
        } catch (Exception e) {
            log.error(e);
            return RequestStatus.FAIL;
        }
  }
     
    /**
     * Update method
     * @param entity
     * @return RequestStatus
     */ 
    @Override
    public RequestStatus updateHospital(Hospital hospital) {
    try {
        Session session = getSession();
        session.beginTransaction();
        if (getHospital(hospital.getId()).isPresent()) {
                session.update(hospital);
                session.getTransaction().commit();
                session.close();
                log.info(RequestStatus.SUCCESS);
                return RequestStatus.SUCCESS;
            } else {
                log.info(RequestStatus.FAIL);
                return RequestStatus.FAIL;
            }
      } catch (Exception e) {
        log.error(e);
        return RequestStatus.FAIL;
      }
    }
    
    public Optional<Integer> maxEmployee() {
        try{
            Session session = getSession();
            session.beginTransaction();
            NativeQuery query = session.createNativeQuery(Constants.MAPPED_MAX_EMPLOYEE);
            log.debug(Constants.MAPPED_MAX_EMPLOYEE);
            BigInteger id = (BigInteger) query.uniqueResult();
            //Long id = (Long) query.uniqueResult();
            int max;
            if (id != null){
                max = id.intValue();
            } else max  = 1;
            session.close();
            log.info("MaxId = " + max);
            return Optional.of(max);
        }catch(Exception e){
            log.error(e);
            return Optional.empty();
        }
    }
    public Optional<Integer> maxAppointment() {
        try{
            Session session = getSession();
            session.beginTransaction();
            NativeQuery query = session.createNativeQuery(Constants.MAPPED_MAX_APPOINTMENT);
            log.debug(Constants.MAPPED_MAX_APPOINTMENT);
            BigInteger id = (BigInteger) query.uniqueResult();
            //Long id = (Long) query.uniqueResult();
            int max;
            if (id != null){
                max = id.intValue();
            } else max  = 1;
            session.close();
            log.info("MaxId = " + max);
            return Optional.of(max);
        }catch(Exception e){
            log.error(e);
            return Optional.empty();
        }
    }
    
    public Optional<Integer> maxDiagnosis() {
        try{
            Session session = getSession();
            session.beginTransaction();
            NativeQuery query = session.createNativeQuery(Constants.MAPPED_MAX_DIAGNOSIS);
            log.debug(Constants.MAPPED_MAX_DIAGNOSIS);
            BigInteger id = (BigInteger) query.uniqueResult();
            //Long id = (Long) query.uniqueResult();
            int max;
            if (id != null){
                max = id.intValue();
            } else max  = 1;
            session.close();
            log.info("MaxId = " + max);
            return Optional.of(max);
        }catch(Exception e){
            log.error(e);
            return Optional.empty();
        }
    }
    
    public Optional<Integer> maxHospital() {
        try{
            Session session = getSession();
            session.beginTransaction();
            NativeQuery query = session.createNativeQuery(Constants.MAPPED_MAX_HOSPITAL);
            log.debug(Constants.MAPPED_MAX_HOSPITAL);
            BigInteger id = (BigInteger) query.uniqueResult();
            //Long id = (Long) query.uniqueResult();
            int max;
            if (id != null){
                max = id.intValue();
            } else max  = 1;
            session.close();
            log.info("MaxId = " + max);
            return Optional.of(max);
        }catch(Exception e){
            log.error(e);
            return Optional.empty();
        }
    }
    
    public Optional<Integer> maxMedicalInsurance() {
        try{
            Session session = getSession();
            session.beginTransaction();
            NativeQuery query = session.createNativeQuery(Constants.MAPPED_MAX_MEDICALINSURANCE);
            log.debug(Constants.MAPPED_MAX_MEDICALINSURANCE);
            BigInteger id = (BigInteger) query.uniqueResult();
            //Long id = (Long) query.uniqueResult();
            int max;
            if (id != null){
                max = id.intValue();
            } else max  = 1;
            session.close();
            log.info("MaxId = " + max);
            return Optional.of(max);
        }catch(Exception e){
            log.error(e);
            return Optional.empty();
        }
    }
    
    public Optional<Integer> maxPatient() {
        try{
            Session session = getSession();
            session.beginTransaction();
            NativeQuery query = session.createNativeQuery(Constants.MAPPED_MAX_PATIENT);
            log.debug(Constants.MAPPED_MAX_PATIENT);
            BigInteger id = (BigInteger) query.uniqueResult();
            //Long id = (Long) query.uniqueResult();
            int max;
            if (id != null){
                max = id.intValue();
            } else max  = 1;
            session.close();
            log.info("MaxId = " + max);
            return Optional.of(max);
        }catch(Exception e){
            log.error(e);
            return Optional.empty();
        }
    }
    
    public Optional<Integer> maxPayment() {
        try{
            Session session = getSession();
            session.beginTransaction();
            NativeQuery query = session.createNativeQuery(Constants.MAPPED_MAX_PAYMENT);
            log.debug(Constants.MAPPED_MAX_PAYMENT);
            BigInteger id = (BigInteger) query.uniqueResult();
            //Long id = (Long) query.uniqueResult();
            int max;
            if (id != null){
                max = id.intValue();
            } else max  = 1;
            session.close();
            log.info("MaxId = " + max);
            return Optional.of(max);
        }catch(Exception e){
            log.error(e);
            return Optional.empty();
        }
    }
    
    public Optional<Integer> maxSurvey() {
        try{
            Session session = getSession();
            session.beginTransaction();
            NativeQuery query = session.createNativeQuery(Constants.MAPPED_MAX_SURVEY);
            log.debug(Constants.MAPPED_MAX_SURVEY);
            BigInteger id = (BigInteger) query.uniqueResult();
            //Long id = (Long) query.uniqueResult();
            int max;
            if (id != null){
                max = id.intValue();
            } else max  = 1;
            session.close();
            log.info("MaxId = " + max);
            return Optional.of(max);
        }catch(Exception e){
            log.error(e);
            return Optional.empty();
        }
    }
    
    public Optional<Integer> maxHospitalization() {
        try{
            Session session = getSession();
            session.beginTransaction();
            NativeQuery query = session.createNativeQuery(Constants.MAPPED_MAX_HOSPITALIZATION);
            log.debug(Constants.MAPPED_MAX_HOSPITALIZATION);
            BigInteger id = (BigInteger) query.uniqueResult();
            //Long id = (Long) query.uniqueResult();
            int max;
            if (id != null){
                max = id.intValue();
            } else max  = 1;
            session.close();
            log.info("MaxId = " + max);
            return Optional.of(max);
        }catch(Exception e){
            log.error(e);
            return Optional.empty();
        }
    }
}