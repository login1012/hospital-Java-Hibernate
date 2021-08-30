/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.hospital2.lab5;

import ru.sfedu.hospital2.lab5.model.Survey;
import ru.sfedu.hospital2.lab5.model.Appointment;
import ru.sfedu.hospital2.lab5.model.Patient;
import ru.sfedu.hospital2.lab5.model.Employee;
import ru.sfedu.hospital2.lab5.model.Diagnosis;
import ru.sfedu.hospital2.lab5.model.Hospital;
import ru.sfedu.hospital2.lab5.model.Payment;
import ru.sfedu.hospital2.lab5.model.Hospitalization;
import ru.sfedu.hospital2.lab5.model.MedicalInsurance;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import ru.sfedu.hospital2.enums.RequestStatus;
import ru.sfedu.hospital2.utils.HibernateUtil;

/**
 *
 * @author Liza
 */
public class DataProvider{
     private static final Logger log = LogManager.getLogger(DataProvider.class);

     private Session getSession() {
       return HibernateUtil.getSessionFactory().openSession();
     }

    /**
     * Insert entity
     * @param <T>
     * @param entity
     * @return
     */
    public <T> RequestStatus insertEntity(T entity) {
       Session session = getSession();
       session.beginTransaction();
       try {
         session.save(entity);
         session.getTransaction().commit();
         session.close();
         return RequestStatus.SUCCESS;
       } catch (Exception e) {
         log.error(e);
         session.close();
         return RequestStatus.FAIL;
       }
     }

    /**
     * Delete entity
     * @param <T>
     * @param entity
     * @return
     */
    public <T> RequestStatus deleteEntity(T entity) {
       Session session = getSession();
       session.beginTransaction();
       try {
         session.delete(entity);
         session.getTransaction().commit();
         session.close();
         return RequestStatus.SUCCESS;
       } catch (Exception e) {
         log.error(e);
         session.close();
         return RequestStatus.FAIL;
       }
     }

    /**
     * Update entity
     * @param <T>
     * @param entity
     * @return
     */
    public <T> RequestStatus updateEntity(T entity) {
       Session session = getSession();
       session.beginTransaction();
       try {
         session.update(entity);
         session.getTransaction().commit();
         session.close();
         return RequestStatus.SUCCESS;
       } catch (Exception e) {
         log.error(e);
         session.close();
         return RequestStatus.FAIL;
       }
     }
     
    /**
     * Get entity
     * @param <T>
     * @param entity
     * @return
     */
    private <T> Optional<T> getEntity(Class<T> Class, long id) {
       Session session = getSession();
       session.beginTransaction();
       try {
         T item = session.get(Class, id);
         session.close();
         return item != null ? Optional.of(item) : Optional.empty();
       } catch (Exception e) {
         log.error(e);
         session.close();
         return Optional.empty();
       }
     }    
      
    /**
     *
     * @param employee
     * @return
     */
    public RequestStatus insertEmployee(Employee employee) {
        try{
            log.info(employee);
            return insertEntity(employee);
        }catch(Exception e){
            log.error(e);
            return RequestStatus.FAIL;
        }
     }

    /**
     *
     * @param employee
     * @return
     */
    public RequestStatus deleteEmployee(Employee employee) {
        try{
            log.info(employee);
            return deleteEntity(employee);
        }catch(Exception e){
            log.error(e);
            return RequestStatus.FAIL;
        }
     }

    /**
     *
     * @param employee
     * @return
     */
    public RequestStatus updateEmployee(Employee employee) {
        try{
            log.info(employee);
            return updateEntity(employee);
        }catch(Exception e){
            log.error(e);
            return RequestStatus.FAIL;
        }
     }

    /**
     *
     * @param patient
     * @return
     */
    public RequestStatus insertPatient(Patient patient) {
        try{
            log.info(patient);
            return insertEntity(patient);
        }catch(Exception e){
            log.error(e);
            return RequestStatus.FAIL;
        }
     }

    /**
     *
     * @param patient
     * @return
     */
    public RequestStatus deletePatient(Patient patient) {
        try{
            log.info(patient);
            return deleteEntity(patient);
        }catch(Exception e){
            log.error(e);
            return RequestStatus.FAIL;
        }
     }

    /**
     *
     * @param patient
     * @return
     */
    public RequestStatus updatePatient(Patient patient) {
        try{
            log.info(patient);
            return updateEntity(patient);
        }catch(Exception e){
            log.error(e);
            return RequestStatus.FAIL;
        }
     }

    /**
     *
     * @param appointment
     * @return
     */
    public RequestStatus insertAppointment(Appointment appointment) {
        try{
            log.info(appointment);
            return insertEntity(appointment);
        }catch(Exception e){
            log.error(e);
            return RequestStatus.FAIL;
        }
     }

    /**
     *
     * @param appointment
     * @return
     */
    public RequestStatus deleteAppointment(Appointment appointment) {
        try{
            log.info(appointment);
            return deleteEntity(appointment);
        }catch(Exception e){
            log.error(e);
            return RequestStatus.FAIL;
        }
     }

    /**
     *
     * @param appointment
     * @return
     */
    public RequestStatus updateAppointment(Appointment appointment) {
        try{
            log.info(appointment);
            return updateEntity(appointment);
        }catch(Exception e){
            log.error(e);
            return RequestStatus.FAIL;
        }
     }
     
    /**
     *
     * @param survey
     * @return
     */
    public RequestStatus insertSurvey(Survey survey) {
        try{
            log.info(survey);
            return insertEntity(survey);
        }catch(Exception e){
            log.error(e);
            return RequestStatus.FAIL;
        }
     }

    /**
     *
     * @param survey
     * @return
     */
    public RequestStatus deleteSurvey(Survey survey) {
        try{
            log.info(survey);
            return deleteEntity(survey);
        }catch(Exception e){
            log.error(e);
            return RequestStatus.FAIL;
        }
     }

    /**
     *
     * @param survey
     * @return
     */
    public RequestStatus updateSurvey(Survey survey) {
        try{
            log.info(survey);
            return updateEntity(survey);
        }catch(Exception e){
            log.error(e);
            return RequestStatus.FAIL;
        }
     }
     
    /**
     *
     * @param id
     * @return
     */
    public Optional<Employee> getEmployeeById(long id) {
       try{
            log.info(getEntity(Employee.class, id));
            return getEntity(Employee.class, id);
        }catch(Exception e){
            log.error(e);
            return Optional.empty();
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public RequestStatus deleteEmployeeById(long id) {
         try{
            log.info(id);
            return deleteEntity(getEmployeeById(id).get());
        }catch(Exception e){
            log.error(e);
            return RequestStatus.FAIL;
        }
    } 
     
    /**
     *
     * @param id
     * @return
     */
    public Optional<Patient> getPatientById(long id) {
        try{
            log.info(getEntity(Patient.class, id));
            return getEntity(Patient.class, id);
        }catch(Exception e){
            log.error(e);
            return Optional.empty();
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public RequestStatus deletePatientById(long id) {
       try{
            log.info(id);
            return deleteEntity(getPatientById(id).get());
        }catch(Exception e){
            log.error(e);
            return RequestStatus.FAIL;
        }
    } 
         
    /**
     *
     * @param id
     * @return
     */
    public Optional<Appointment> getAppointmentById(long id) {
      try{
            log.info(getEntity(Appointment.class, id));
            return getEntity(Appointment.class, id);
        }catch(Exception e){
            log.error(e);
            return Optional.empty();
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public RequestStatus deleteAppointmentById(long id) {
        try{
            log.info(id);
            return deleteEntity(getAppointmentById(id).get());
        }catch(Exception e){
            log.error(e);
            return RequestStatus.FAIL;
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public Optional<Survey> getSurveyById(long id) {
        try{
            log.info(getEntity(Survey.class, id));
            return getEntity(Survey.class, id);
        }catch(Exception e){
            log.error(e);
            return Optional.empty();
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public RequestStatus deleteSurveyById(long id) {
      try{
            log.info(id);
            return deleteEntity(getSurveyById(id).get());
        }catch(Exception e){
            log.error(e);
            return RequestStatus.FAIL;
        }
    }
    
    /**
     *
     * @param id
     * @return
     */
    public Optional<Diagnosis> getDiagnosisById(long id) {
        try{
            log.info(getEntity(Diagnosis.class, id));
            return getEntity(Diagnosis.class, id);
        }catch(Exception e){
            log.error(e);
            return Optional.empty();
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public RequestStatus deleteDiagnosisById(long id) {
       try{
            log.info(id);
            return deleteEntity(getDiagnosisById(id).get());
        }catch(Exception e){
            log.error(e);
            return RequestStatus.FAIL;
        }
    } 

    /**
     *
     * @param diagnosis
     * @return
     */
    public RequestStatus insertDiagnosis(Diagnosis diagnosis) {
        try{
            log.info(diagnosis);
            return insertEntity(diagnosis);
        }catch(Exception e){
            log.error(e);
            return RequestStatus.FAIL;
        }
     }

    /**
     *
     * @param diagnosis
     * @return
     */
    public RequestStatus deleteDiagnosis(Diagnosis diagnosis) {
        try{
            log.info(diagnosis);
            return deleteEntity(diagnosis);
        }catch(Exception e){
            log.error(e);
            return RequestStatus.FAIL;
        }
     }

    /**
     *
     * @param diagnosis
     * @return
     */
    public RequestStatus updateDiagnosis(Diagnosis diagnosis) {
        try{
            log.info(diagnosis);
            return updateEntity(diagnosis);
        }catch(Exception e){
            log.error(e);
            return RequestStatus.FAIL;
        }
     }

    /**
     *
     * @param id
     * @return
     */
    public Optional<Payment> getPaymentById(long id) {
        try{
            log.info(getEntity(Payment.class, id));
            return getEntity(Payment.class, id);
        }catch(Exception e){
            log.error(e);
            return Optional.empty();
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public RequestStatus deletePaymentById(long id) {
      try{
            log.info(id);
            return deleteEntity(getPaymentById(id).get());
        }catch(Exception e){
            log.error(e);
            return RequestStatus.FAIL;
        }
    } 

    /**
     *
     * @param payment
     * @return
     */
    public RequestStatus insertPayment(Payment payment) {
        try{
            log.info(payment);
            return insertEntity(payment);
        }catch(Exception e){
            log.error(e);
            return RequestStatus.FAIL;
        }
     }

    /**
     *
     * @param payment
     * @return
     */
    public RequestStatus deletePayment(Payment payment) {
        try{
            log.info(payment);
            return deleteEntity(payment);
        }catch(Exception e){
            log.error(e);
            return RequestStatus.FAIL;
        }
     }

    /**
     *
     * @param payment
     * @return
     */
    public RequestStatus updatePayment(Payment payment) {
        try{
            log.info(payment);
            return updateEntity(payment);
        }catch(Exception e){
            log.error(e);
            return RequestStatus.FAIL;
        }
     }

    /**
     *
     * @param id
     * @return
     */
    public Optional<MedicalInsurance> getMedicalInsuranceById(long id) {
       try{
            log.info(getEntity(MedicalInsurance.class, id));
            return getEntity(MedicalInsurance.class, id);
        }catch(Exception e){
            log.error(e);
            return Optional.empty();
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public RequestStatus deleteMedicalInsuranceById(long id) {
       try{
            log.info(id);
            return deleteEntity(getMedicalInsuranceById(id).get());
        }catch(Exception e){
            log.error(e);
            return RequestStatus.FAIL;
        }
    } 

    /**
     *
     * @param medicalInsurance
     * @return
     */
    public RequestStatus insertMedicalInsurance(MedicalInsurance medicalInsurance) {
        try{
            log.info(medicalInsurance);
            return insertEntity(medicalInsurance);
        }catch(Exception e){
            log.error(e);
            return RequestStatus.FAIL;
        }
     }

    /**
     *
     * @param medicalInsurance
     * @return
     */
    public RequestStatus deleteMedicalInsurance(MedicalInsurance medicalInsurance) {
        try{
            log.info(medicalInsurance);
            return deleteEntity(medicalInsurance);
        }catch(Exception e){
            log.error(e);
            return RequestStatus.FAIL;
        }
     }

    /**
     *
     * @param medicalInsurance
     * @return
     */
    public RequestStatus updateMedicalInsurance(MedicalInsurance medicalInsurance) {
        try{
            log.info(medicalInsurance);
            return updateEntity(medicalInsurance);
        }catch(Exception e){
            log.error(e);
            return RequestStatus.FAIL;
        }
     }

    /**
     *
     * @param id
     * @return
     */
    public Optional<Hospitalization> getHospitalizationById(long id) {
       try{
            log.info(getEntity(Hospitalization.class, id));
            return getEntity(Hospitalization.class, id);
        }catch(Exception e){
            log.error(e);
            return Optional.empty();
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public RequestStatus deleteHospitalizationById(long id) {
        try{
            log.info(id);
            return deleteEntity(getHospitalizationById(id).get());
        }catch(Exception e){
            log.error(e);
            return RequestStatus.FAIL;
        }
    } 

    /**
     *
     * @param hospitalization
     * @return
     */
    public RequestStatus insertHospitalization(Hospitalization hospitalization) {
        try{
            log.info(hospitalization);
            return insertEntity(hospitalization);
        }catch(Exception e){
            log.error(e);
            return RequestStatus.FAIL;
        }
     }

    /**
     *
     * @param hospitalization
     * @return
     */
    public RequestStatus deleteHospitalization(Hospitalization hospitalization) {
        try{
            log.info(hospitalization);
            return deleteEntity(hospitalization);
        }catch(Exception e){
            log.error(e);
            return RequestStatus.FAIL;
        }
     }

    /**
     *
     * @param hospitalization
     * @return
     */
    public RequestStatus updateHospitalization(Hospitalization hospitalization) {
        try{
            log.info(hospitalization);
            return updateEntity(hospitalization);
        }catch(Exception e){
            log.error(e);
            return RequestStatus.FAIL;
        }
     }

    /**
     *
     * @param id
     * @return
     */
    public Optional<Hospital> getHospitalById(long id) {
        try{
            log.info(getEntity(Hospital.class, id));
            return getEntity(Hospital.class, id);
        }catch(Exception e){
            log.error(e);
            return Optional.empty();
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public RequestStatus deleteHospitalById(long id) {
       try{
            log.info(id);
            return deleteEntity(getHospitalById(id).get());
        }catch(Exception e){
            log.error(e);
            return RequestStatus.FAIL;
        }
    } 

    /**
     *
     * @param hospital
     * @return
     */
    public RequestStatus insertHospital(Hospital hospital) {
        try{
            log.info(hospital);
            return insertEntity(hospital);
        }catch(Exception e){
            log.error(e);
            return RequestStatus.FAIL;
        }
     }

    /**
     *
     * @param hospital
     * @return
     */
    public RequestStatus deleteHospital(Hospital hospital) {
        try{
            log.info(hospital);
            return deleteEntity(hospital);
        }catch(Exception e){
            log.error(e);
            return RequestStatus.FAIL;
        }
     }

    /**
     *
     * @param hospital
     * @return
     */
    public RequestStatus updateHospital(Hospital hospital) {
        try{
            log.info(hospital);
            return updateEntity(hospital);
        }catch(Exception e){
            log.error(e);
            return RequestStatus.FAIL;
        }
     }
}
