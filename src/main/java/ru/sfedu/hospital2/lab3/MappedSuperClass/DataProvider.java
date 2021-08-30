/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the updateor.
 */
package ru.sfedu.hospital2.lab3.MappedSuperClass;

import ru.sfedu.hospital2.lab3.MappedSuperClass.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import ru.sfedu.hospital2.lab3.MappedSuperClass.model.Appointment;
import ru.sfedu.hospital2.lab3.MappedSuperClass.model.Diagnosis;
import ru.sfedu.hospital2.lab3.MappedSuperClass.model.Employee;
import ru.sfedu.hospital2.lab3.MappedSuperClass.model.Hospital;
import ru.sfedu.hospital2.lab3.MappedSuperClass.model.Hospitalization;
import ru.sfedu.hospital2.lab3.MappedSuperClass.model.MedicalInsurance;
import ru.sfedu.hospital2.lab3.MappedSuperClass.model.Patient;
import ru.sfedu.hospital2.lab3.MappedSuperClass.model.Payment;
import ru.sfedu.hospital2.lab3.MappedSuperClass.model.Survey;
import ru.sfedu.hospital2.enums.HospitalizationStatus;
import ru.sfedu.hospital2.enums.RequestStatus;
import ru.sfedu.hospital2.enums.ServiceStatus;
import ru.sfedu.hospital2.enums.TypeOfPayment;

/**
 * Interface implemented by DataProviders
 * @author Liza
 */
public interface DataProvider {
    
    /*Employee*/
    
    /**
     * Employee creation method
     * @param employee
     * @param name
     * @param phone
     * @param specialty
     * @param competence
     * @return RequestStatus
     * @throws java.lang.Exception
     */
    RequestStatus createEmployee(Employee employee)throws Exception;
    
    /**
     * Employee selection method
     * 
     * @param id
     * @return Employee object
     * @throws java.lang.Exception
     */
    Optional<Employee> getEmployee(long id)throws Exception;
    
    /**
     * Employee update method
     * 
     * @param id
     * @param employee id
     * @return RequestStatus
     * @throws java.lang.Exception
     */
    RequestStatus updateEmployee(Employee employee)throws Exception;
    
    /**
     * Employee delete method
     * 
     * @param id
     * @return RequestStatus
     * @throws java.lang.Exception
     */
    RequestStatus deleteEmployee(long id)throws Exception;
    
    /*Patient*/
    
    /**
     * Patient creation method
     * @param name
     * @param phone
     * @param passport
     * @param allergy
     * @return Patient object
     * @throws java.lang.Exception
     */
    RequestStatus createPatient(Patient patient)throws Exception;
    
     /**
     * Patient selection method
     * 
     * @param id
     * @return Patient object
     * @throws java.lang.Exception
     */
    Optional<Patient> getPatient(long id)throws Exception;
    
    /**
     * Patient update method
     * 
     * @param patient
     * @return RequestStatus
     * @throws java.lang.Exception
     */
    RequestStatus updatePatient(Patient patient)throws Exception;
    
    /**
     * Patient delete method
     * 
     * @param id
     * @return RequestStatus
     * @throws java.lang.Exception
     */
    RequestStatus deletePatient(long id)throws Exception;
    
    /*Survey*/
        
    /**
     * Survey creation method
     * @param patientId
     * @param doctorId
     * @param date
     * @param type
     * @param report
     * @return RequestStatus
     * @throws java.lang.Exception
     */
    RequestStatus createSurvey(Survey survey)throws Exception;
    
    /**
     * Survey selection method
     * 
     * @param id
     * @return Survey object
     * @throws java.lang.Exception
     */
    Optional<Survey> getSurvey(long id)throws Exception;
    
    /**
     * Survey update method
     * 
     * @param survey
     * @return RequestStatus
     * @throws java.lang.Exception
     */
    RequestStatus updateSurvey(Survey survey)throws Exception;
    
    /**
     * Survey delete method
     * 
     * @param id
     * @return RequestStatus
     * @throws java.lang.Exception
     */
    RequestStatus deleteSurvey(long id)throws Exception;
    
    /*Appointment*/    
    
    /**
     * Appointment creation method
     * @param patientId
     * @param doctorId
     * @param specialization
     * @param status
     * @param date
     * @return Appointment object
     * @throws java.lang.Exception
     */
    RequestStatus createAppointment(Appointment appointment)throws Exception;
    
    /**
     * Appointment selection method
     * 
     * @param id
     * @return Appointment object
     * @throws java.lang.Exception
     */
    Optional <Appointment> getAppointment(long id)throws Exception;
    
    /**
     * Appointment update method
     * 
     * @param id
     * @param appointment
     * @return RequestStatus
     * @throws java.lang.Exception
     */
    RequestStatus updateAppointment(Appointment appointment)throws Exception;
    
    /**
     * Appointment delete method
     * 
     * @param id
     * @return RequestStatus
     * @throws java.lang.Exception
     */
    RequestStatus deleteAppointment(long id)throws Exception;
    
     /*Diagnosis*/
    
    /**
     * Diagnosis creation method
     * @param signature
     * @param patientId
     * @param serviceId
     * @param diagnosisInf
     * @param medicine
     * @param MedicalTests
     * @return Diagnosis object
     * @throws java.lang.Exception
     */
    RequestStatus createDiagnosis(Diagnosis diagnosis)throws Exception;
            
    /**
     * Diagnosis selection method
     * 
     * @param id
     * @return Diagnosis object
     * @throws java.lang.Exception
     */
    Optional<Diagnosis> getDiagnosis(long id)throws Exception;
    
    /**
     * Diagnosis update method
     * 
     * @param diagnosis
     * @return RequestStatus
     * @throws java.lang.Exception
     */
    RequestStatus updateDiagnosis(Diagnosis diagnosis)throws Exception;
    
    /**
     * Diagnosis delete method
     * 
     * @param id
     * @return RequestStatus
     * @throws java.lang.Exception
     */
    RequestStatus deleteDiagnosis(long id)throws Exception;
    
    /*Payment*/
    
    /**
     * Diagnosis creation method
     * @param signature
     * @param serviceId
     * @param number
     * @param price
     * @return Payment object
     * @throws java.lang.Exception
     */
    RequestStatus createPayment(Payment payment)throws Exception;
    
     /**
     * Payment selection method
     * 
     * @param id
     * @return Payment object
     * @throws java.lang.Exception
     */
    Optional<Payment> getPayment(long id)throws Exception;
    
    /**
     * Payment update method
     * 
     * @param payment
     * @return RequestStatus
     * @throws java.lang.Exception
     */
    RequestStatus updatePayment(Payment payment)throws Exception;
    
    /**
     * Payment delete method
     * 
     * @param id
     * @return RequestStatus
     * @throws java.lang.Exception
     */
    RequestStatus deletePayment(long id)throws Exception;
    
     /*MedicalInsurance*/
    
    /**
     * Diagnosis creation method
     * @param signature
     * @param serviceId
     * @param reimbursement
     * @param number
     * @return Appointment object
     * @throws java.lang.Exception
     */
    RequestStatus createMedicalInsurance(MedicalInsurance medicalInsurance)throws Exception;
    
    /**
     * MedicalInsurance selection method
     * 
     * @param id
     * @return MedicalInsurance object
     * @throws java.lang.Exception
     */
    Optional<MedicalInsurance> getMedicalInsurance(long id)throws Exception;
    
    /**
     * MedicalInsurance update method
     * 
     * @param medicalInsurance
     * @return RequestStatus
     * @throws java.lang.Exception
     */
    RequestStatus updateMedicalInsurance(MedicalInsurance medicalInsurance)throws Exception;
    
    /**
     * MedicalInsurance delete method
     * 
     * @param id
     * @return RequestStatus
     * @throws java.lang.Exception
     */
    RequestStatus deleteMedicalInsurance(long id)throws Exception;
    
    /*Hospitalization*/
    
    /**
     * Hospitalization creation method
     * @param signature
     * @param diagnosisId
     * @param hospitalId
     * @param ward
     * @param status
     * @return Hoapitalization object
     * @throws java.lang.Exception
     */
    RequestStatus createHospitalization(Hospitalization hospitalization)throws Exception;
    
    /**
     * Hospitalization selection method
     * 
     * @param id
     * @return Hospitalization object
     * @throws java.lang.Exception
     */
    Optional<Hospitalization> getHospitalization(long id)throws Exception;
    
    /**
     * Hospitalization update method
     * 
     * @param id
     * @param hospitalization
     * @return RequestStatus
     * @throws java.lang.Exception
     */
    RequestStatus updateHospitalization(Hospitalization hospitalization)throws Exception;
    
    /**
     * Hospitalization delete method
     * 
     * @param id
     * @return RequestStatus
     * @throws java.lang.Exception
     */
    RequestStatus deleteHospitalization(long id)throws Exception;
    
    /*Hospital*/
    
    /**
     * Hospital creation method
     * @param name
     * @param wardsNumber
     * @return Hospital object
     * @throws java.lang.Exception
     */
    RequestStatus createHospital(Hospital hospital)throws Exception;
    
    /**
     * Hospital selection method
     * 
     * @param id
     * @return Hospital object
     * @throws java.lang.Exception
     */
    Optional<Hospital> getHospital(long id)throws Exception;
    
    /**
     * Hospital update method
     * 
     * @param hospital
     * @return RequestStatus
     * @throws java.lang.Exception
     */
    RequestStatus updateHospital(Hospital hospital)throws Exception;
    
    /**
     * Hospital delete method
     * 
     * @param id
     * @return RequestStatus
     * @throws java.lang.Exception
     */
    RequestStatus deleteHospital(long id)throws Exception;
    
    
}
