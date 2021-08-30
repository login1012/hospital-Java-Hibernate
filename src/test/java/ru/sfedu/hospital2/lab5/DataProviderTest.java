/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.hospital2.lab5;

import ru.sfedu.hospital2.lab5.*;
import ru.sfedu.hospital2.lab5.model.*;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.sfedu.hospital2.enums.RequestStatus;
import ru.sfedu.hospital2.enums.ServiceStatus;
/**
 *
 * @author Liza
 */
public class DataProviderTest {
        static final Logger log = LogManager.getLogger(DataProviderTest.class);
        private static final DataProvider provider = new DataProvider();
        public static Generator generator = new Generator();
    
    public DataProviderTest() {
    }
       
    /*@Before
    public void setUp() {
        generator.generateEmployee().stream().forEach(item -> provider.insertEmployee(item));
        generator.generatePatient().stream().forEach(item -> provider.insertPatient(item));
        generator.generateSurvey().stream().forEach(item -> provider.insertSurvey(item));
        generator.generateAppointment().stream().forEach(item -> provider.insertAppointment(item));
        
    }*/
   
     /**
     * Successful test of insertEmployee method, of class DataProvider.
     */
    @Test
    public void testInsertEmployee() {
        Employee employee = generator.generateEmployee().get(0);
        log.debug(employee.getId());
        assertEquals(provider.insertEmployee(employee), RequestStatus.SUCCESS);        
    }
    
    /**
     * Failed test of insertEmployee method, of class DataProvider.
     */
    @Test
    public void testInsertEmployeeFail() {
        Employee employee = generator.generateEmployee().get(0);
        employee.setName(null);
        assertEquals(provider.insertEmployee(employee), RequestStatus.FAIL);
    }
    /**
     * Successful test of deleteEmployee method, of class DataProvider.
     */
    @Test
    public void testDeleteEmployee() {
        Employee employee = generator.generateEmployee().get(0);
        provider.insertEmployee(employee);
        log.debug(employee.getId());
        assertEquals(provider.deleteEmployee(employee), RequestStatus.SUCCESS);        
    }
    
    /**
     * Failed test of deleteEmployee method, of class DataProvider.
     */
    @Test
    public void testDeleteEmployeeFail() {
        Appointment appointment = generator.generateAppointment().get(0);
        provider.insertAppointment(appointment);
        log.debug(appointment.getDoctor().toString());
        assertEquals(provider.deleteEmployee(appointment.getDoctor()), RequestStatus.FAIL);
    }
    /**
     * Successful test of updateEmployee method, of class DataProvider.
     */
    @Test
    public void testUpdateEmployee() {
        Employee employee = generator.generateEmployee().get(0);
        log.debug(employee.getId());
        provider.insertEmployee(employee);
        employee.setName("UPDATE");
        assertEquals(provider.updateEmployee(employee), RequestStatus.SUCCESS);        
    }
    
    /**
     * Failed test of updateEmployee method, of class DataProvider.
     */
    @Test
    public void testUpdateEmployeeFail() {
        Employee employee = generator.generateEmployee().get(0);
        log.debug(employee.getId());
        provider.insertEmployee(employee);
        employee.setName(null);
        assertEquals(provider.updateEmployee(employee), RequestStatus.FAIL); 
    }
     /**
     * Successful test of getEmployee method, of class DataProvider.
     */
    @Test
    public void testGetEmployee() {
        Employee employee = generator.generateEmployee().get(0);
        log.debug(employee.getId());
        provider.insertEmployee(employee);
        assertEquals(provider.getEmployeeById(employee.getId()).get().getId(), employee.getId());        
    }
    
    /**
     * Failed test of getEmployee method, of class DataProvider.
     */
    @Test
    public void testGetEmployeeFail() {
        assertEquals(provider.getEmployeeById(0), Optional.empty()); 
    }
    
     /**
     * Successful test of insertPatient method, of class DataProvider.
     */
    @Test
    public void testInsertPatient() {
        Patient patient = generator.generatePatient().get(0);
        log.debug(patient.getId());
        assertEquals(provider.insertPatient(patient), RequestStatus.SUCCESS);        
    }
    
    /**
     * Failed test of insertPatient method, of class DataProvider.
     */
    @Test
    public void testInsertPatientFail() {
        Patient patient = generator.generatePatient().get(0);
        patient.setName(null);
        assertEquals(provider.insertPatient(patient), RequestStatus.FAIL);
    }
    /**
     * Successful test of deletePatient method, of class DataProvider.
     */
    @Test
    public void testDeletePatient() {
        Patient patient = generator.generatePatient().get(0);
        provider.insertPatient(patient);
        log.debug(patient.getId());
        assertEquals(provider.deletePatient(patient), RequestStatus.SUCCESS);        
    }
    
    /**
     * Failed test of deletePatient method, of class DataProvider.
     */
    @Test
    public void testDeletePatientFail() {
        Appointment appointment = generator.generateAppointment().get(0);
        provider.insertAppointment(appointment);
        log.debug(appointment.getDoctor().toString());
        assertEquals(provider.deletePatient(appointment.getPatient()), RequestStatus.FAIL);
    }
    /**
     * Successful test of updatePatient method, of class DataProvider.
     */
    @Test
    public void testUpdatePatient() {
        Patient patient = generator.generatePatient().get(0);
        log.debug(patient.getId());
        provider.insertPatient(patient);
        patient.setName("UPDATE");
        assertEquals(provider.updatePatient(patient), RequestStatus.SUCCESS);        
    }
    
    /**
     * Failed test of updatePatient method, of class DataProvider.
     */
    @Test
    public void testUpdatePatientFail() {
        Patient patient = generator.generatePatient().get(0);
        log.debug(patient.getId());
        provider.insertPatient(patient);
        patient.setName(null);
        assertEquals(provider.updatePatient(patient), RequestStatus.FAIL); 
    }
     /**
     * Successful test of getPatient method, of class DataProvider.
     */
    @Test
    public void testGetPatient() {
        Patient patient = generator.generatePatient().get(0);
        log.debug(patient.getId());
        provider.insertPatient(patient);
        assertEquals(provider.getPatientById(patient.getId()).get().getId(), patient.getId());        
    }
    
    /**
     * Failed test of getPatient method, of class DataProvider.
     */
    @Test
    public void testGetPatientFail() {
        assertEquals(provider.getPatientById(0), Optional.empty()); 
    }
    
    /**
     * Successful test of insertSurvey method, of class DataProvider.
     */
    @Test
    public void testInsertSurvey() {
        Survey survey = generator.generateSurvey().get(0);
        log.debug(survey.getId());
        assertEquals(provider.insertSurvey(survey), RequestStatus.SUCCESS);        
    }
    
    /**
     * Failed test of insertSurvey method, of class DataProvider.
     */
    @Test
    public void testInsertSurveyFail() {
        Survey survey = generator.generateSurvey().get(0);
        survey.setStatus(null);
        assertEquals(provider.insertSurvey(survey), RequestStatus.FAIL);
    }
    /**
     * Successful test of deleteSurvey method, of class DataProvider.
     */
    @Test
    public void testDeleteSurvey() {
        Survey survey = generator.generateSurvey().get(0);
        provider.insertSurvey(survey);
        log.debug(survey.getId());
        assertEquals(provider.deleteSurvey(survey), RequestStatus.SUCCESS);        
    }
    
    /**
     * Failed test of deleteSurvey method, of class DataProvider.
     */
    @Test
    public void testDeleteSurveyFail() {
        Survey survey = generator.generateSurvey().get(0);
        provider.insertSurvey(survey);
        log.debug(survey.getId());
        assertEquals(provider.deleteSurvey(survey), RequestStatus.SUCCESS);  
    }
    /**
     * Successful test of updateSurvey method, of class DataProvider.
     */
    @Test
    public void testUpdateSurvey() {
        Survey survey = generator.generateSurvey().get(0);
        log.debug(survey.getId());
        provider.insertSurvey(survey);
        survey.setStatus(ServiceStatus.PAID);
        assertEquals(provider.updateSurvey(survey), RequestStatus.SUCCESS);        
    }
    
    /**
     * Failed test of updateSurvey method, of class DataProvider.
     */
    @Test
    public void testUpdateSurveyFail() {
        Survey survey = generator.generateSurvey().get(0);
        log.debug(survey.getId());
        provider.insertSurvey(survey);
        survey.setStatus(null);
        assertEquals(provider.updateSurvey(survey), RequestStatus.FAIL);   
    }
     /**
     * Successful test of getSurvey method, of class DataProvider.
     */
    @Test
    public void testGetSurvey() {
        Survey survey = generator.generateSurvey().get(0);
        log.debug(survey.getId());
        provider.insertSurvey(survey);
        assertEquals(provider.getSurveyById(survey.getId()).get().getId(), survey.getId());        
    }
    
    /**
     * Failed test of getSurvey method, of class DataProvider.
     */
    @Test
    public void testGetSurveyFail() {
        assertEquals(provider.getSurveyById(0), Optional.empty()); 
    }
    
     /**
     * Successful test of insertAppointment method, of class DataProvider.
     */
    @Test
    public void testInsertAppointment() {
        Appointment appointment = generator.generateAppointment().get(0);
        log.debug(appointment.getId());
        assertEquals(provider.insertAppointment(appointment), RequestStatus.SUCCESS);        
    }
    
    /**
     * Failed test of insertAppointment method, of class DataProvider.
     */
    @Test
    public void testInsertAppointmentFail() {
        Appointment appointment = generator.generateAppointment().get(0);
        appointment.setStatus(null);
        assertEquals(provider.insertAppointment(appointment), RequestStatus.FAIL);
    }
    /**
     * Successful test of deleteAppointment method, of class DataProvider.
     */
    @Test
    public void testDeleteAppointment() {
        Appointment appointment = generator.generateAppointment().get(0);
        provider.insertAppointment(appointment);
        log.debug(appointment.getId());
        assertEquals(provider.deleteAppointment(appointment), RequestStatus.SUCCESS);        
    }
    
    /**
     * Failed test of deleteAppointment method, of class DataProvider.
     */
    @Test
    public void testDeleteAppointmentFail() {
        Diagnosis diagnosis = generator.generateDiagnosis().get(0);
        provider.insertDiagnosis(diagnosis);
        Appointment appointment = diagnosis.getAppointment();
        log.debug(appointment.getId());
        assertEquals(provider.deleteAppointment(appointment), RequestStatus.FAIL);  
    }
    /**
     * Successful test of updateAppointment method, of class DataProvider.
     */
    @Test
    public void testUpdateAppointment() {
        Appointment appointment = generator.generateAppointment().get(0);
        log.debug(appointment.getId());
        provider.insertAppointment(appointment);
        appointment.setStatus(ServiceStatus.PAID);
        assertEquals(provider.updateAppointment(appointment), RequestStatus.SUCCESS);        
    }
    
    /**
     * Failed test of updateAppointment method, of class DataProvider.
     */
    @Test
    public void testUpdateAppointmentFail() {
        Appointment appointment = generator.generateAppointment().get(0);
        log.debug(appointment.getId());
        provider.insertAppointment(appointment);
        appointment.setStatus(null);
        assertEquals(provider.updateAppointment(appointment), RequestStatus.FAIL);   
    }
     /**
     * Successful test of getAppointment method, of class DataProvider.
     */
    @Test
    public void testGetAppointment() {
        Appointment appointment = generator.generateAppointment().get(0);      
        provider.insertAppointment(appointment);
        log.debug(appointment.getId());
        assertEquals(provider.getAppointmentById(appointment.getId()).get().getId(), appointment.getId());        
    }
    
    /**
     * Failed test of getAppointment method, of class DataProvider.
     */
    @Test
    public void testGetAppointmentFail() {
        assertEquals(provider.getAppointmentById(0), Optional.empty()); 
    }
    
     /**
     * Successful test of insertPayment method, of class DataProvider.
     */
    @Test
    public void testInsertPayment() {
        Payment payment = generator.generatePayment().get(0);
        log.debug(payment.getId());
        assertEquals(provider.insertPayment(payment), RequestStatus.SUCCESS);        
    }
    
    /**
     * Failed test of insertPayment method, of class DataProvider.
     */
    @Test
    public void testInsertPaymentFail() {
        Payment payment = generator.generatePayment().get(0);
        Appointment appointment = new Appointment();
        payment.setAppointment(appointment);
        assertEquals(provider.insertPayment(payment), RequestStatus.FAIL);
    }
    /**
     * Successful test of deletePayment method, of class DataProvider.
     */
    @Test
    public void testDeletePayment() {
        Payment payment = generator.generatePayment().get(0);
        provider.insertPayment(payment);
        log.debug(payment.getId());
        assertEquals(provider.deletePayment(payment), RequestStatus.SUCCESS);        
    }
    
    /**
     * Failed test of deletePayment method, of class DataProvider.
     */
    @Test
    public void testDeletePaymentFail() {
        Payment payment = generator.generatePayment().get(0);
        provider.insertPayment(payment);
        log.debug(payment.getId());
        assertEquals(provider.deletePayment(payment), RequestStatus.SUCCESS);  
    }
    /**
     * Successful test of updatePayment method, of class DataProvider.
     */
    @Test
    public void testUpdatePayment() {
        Payment payment = generator.generatePayment().get(0);
        log.debug(payment.getId());
        provider.insertPayment(payment);
        payment.setSignature(true);
        assertEquals(provider.updatePayment(payment), RequestStatus.SUCCESS);        
    }
    
    /**
     * Failed test of updatePayment method, of class DataProvider.
     */
    @Test
    public void testUpdatePaymentFail() {
        Payment payment = generator.generatePayment().get(0);
        log.debug(payment.getId());
        provider.insertPayment(payment);
        Appointment appointment = new Appointment();
        payment.setAppointment(appointment);
        assertEquals(provider.updatePayment(payment), RequestStatus.FAIL);   
    }
     /**
     * Successful test of getPayment method, of class DataProvider.
     */
    @Test
    public void testGetPayment() {
        Payment payment = generator.generatePayment().get(0);       
        provider.insertPayment(payment);
        log.debug(payment.getId());
       assertEquals(provider.getPaymentById(payment.getId()), Optional.empty());        
    }
    
    /**
     * Failed test of getPayment method, of class DataProvider.
     */
    @Test
    public void testGetPaymentFail() {
        assertEquals(provider.getPaymentById(0), Optional.empty()); 
    }
    
    
     /**
     * Successful test of insertMedicalInsurance method, of class DataProvider.
     */
    @Test
    public void testInsertMedicalInsurance() {
        MedicalInsurance medicalInsurance = generator.generateMedicalInsurance().get(0);
        log.debug(medicalInsurance.getId());
        assertEquals(provider.insertMedicalInsurance(medicalInsurance), RequestStatus.SUCCESS);        
    }
    
    /**
     * Failed test of insertMedicalInsurance method, of class DataProvider.
     */
    @Test
    public void testInsertMedicalInsuranceFail() {
        MedicalInsurance medicalInsurance = generator.generateMedicalInsurance().get(0);
        Appointment appointment = new Appointment();
        medicalInsurance.setAppointment(appointment);
        assertEquals(provider.insertMedicalInsurance(medicalInsurance), RequestStatus.FAIL);
    }
    /**
     * Successful test of deleteMedicalInsurance method, of class DataProvider.
     */
    @Test
    public void testDeleteMedicalInsurance() {
        MedicalInsurance medicalInsurance = generator.generateMedicalInsurance().get(0);
        provider.insertMedicalInsurance(medicalInsurance);
        log.debug(medicalInsurance.getId());
        assertEquals(provider.deleteMedicalInsurance(medicalInsurance), RequestStatus.SUCCESS);        
    }
    
    /**
     * Failed test of deleteMedicalInsurance method, of class DataProvider.
     */
    @Test
    public void testDeleteMedicalInsuranceFail() {
        MedicalInsurance medicalInsurance = generator.generateMedicalInsurance().get(0);
        provider.insertMedicalInsurance(medicalInsurance);
        log.debug(medicalInsurance.getId());
        assertEquals(provider.deleteMedicalInsurance(medicalInsurance), RequestStatus.SUCCESS);  
    }
    /**
     * Successful test of updateMedicalInsurance method, of class DataProvider.
     */
    @Test
    public void testUpdateMedicalInsurance() {
        MedicalInsurance medicalInsurance = generator.generateMedicalInsurance().get(0);
        log.debug(medicalInsurance.getId());
        provider.insertMedicalInsurance(medicalInsurance);
        medicalInsurance.setSignature(true);
        assertEquals(provider.updateMedicalInsurance(medicalInsurance), RequestStatus.SUCCESS);        
    }
    
    /**
     * Failed test of updateMedicalInsurance method, of class DataProvider.
     */
    @Test
    public void testUpdateMedicalInsuranceFail() {
        MedicalInsurance medicalInsurance = generator.generateMedicalInsurance().get(0);
        log.debug(medicalInsurance.getId());
        provider.insertMedicalInsurance(medicalInsurance);
        Appointment appointment = new Appointment();
        medicalInsurance.setAppointment(appointment);
        assertEquals(provider.updateMedicalInsurance(medicalInsurance), RequestStatus.FAIL);   
    }
     /**
     * Successful test of getMedicalInsurance method, of class DataProvider.
     */
    @Test
    public void testGetMedicalInsurance() {
        MedicalInsurance medicalInsurance = generator.generateMedicalInsurance().get(0);
        log.debug(medicalInsurance.getId());
        provider.insertMedicalInsurance(medicalInsurance);
        assertEquals(provider.getMedicalInsuranceById(medicalInsurance.getId()), Optional.empty());        
    }
    
    /**
     * Failed test of getMedicalInsurance method, of class DataProvider.
     */
    @Test
    public void testGetMedicalInsuranceFail() {
        assertEquals(provider.getMedicalInsuranceById(0), Optional.empty()); 
    }
    
    
     /**
     * Successful test of insertDiagnosis method, of class DataProvider.
     */
    @Test
    public void testInsertDiagnosis() {
        Diagnosis diagnosis = generator.generateDiagnosis().get(0);
        log.debug(diagnosis.getId());
        assertEquals(provider.insertDiagnosis(diagnosis), RequestStatus.SUCCESS);        
    }
    
    /**
     * Failed test of insertDiagnosis method, of class DataProvider.
     */
    @Test
    public void testInsertDiagnosisFail() {
        Diagnosis diagnosis = generator.generateDiagnosis().get(0);
        Appointment appointment = new Appointment();
        diagnosis.setAppointment(appointment);
        assertEquals(provider.insertDiagnosis(diagnosis), RequestStatus.FAIL);
    }
    /**
     * Successful test of deleteDiagnosis method, of class DataProvider.
     */
    @Test
    public void testDeleteDiagnosis() {
        Diagnosis diagnosis = generator.generateDiagnosis().get(0);
        provider.insertDiagnosis(diagnosis);
        log.debug(diagnosis.getId());
        assertEquals(provider.deleteDiagnosis(diagnosis), RequestStatus.SUCCESS);        
    }
    
    /**
     * Failed test of deleteDiagnosis method, of class DataProvider.
     */
    @Test
    public void testDeleteDiagnosisFail() {
        Diagnosis diagnosis = generator.generateDiagnosis().get(0);
        provider.insertDiagnosis(diagnosis);
        log.debug(diagnosis.getId());
        assertEquals(provider.deleteDiagnosis(diagnosis), RequestStatus.SUCCESS);  
    }
    /**
     * Successful test of updateDiagnosis method, of class DataProvider.
     */
    @Test
    public void testUpdateDiagnosis() {
        Diagnosis diagnosis = generator.generateDiagnosis().get(0);
        log.debug(diagnosis.getId());
        provider.insertDiagnosis(diagnosis);
        diagnosis.setSignature(true);
        assertEquals(provider.updateDiagnosis(diagnosis), RequestStatus.SUCCESS);        
    }
    
    /**
     * Failed test of updateDiagnosis method, of class DataProvider.
     */
    @Test
    public void testUpdateDiagnosisFail() {
        Diagnosis diagnosis = generator.generateDiagnosis().get(0);
        log.debug(diagnosis.getId());
        provider.insertDiagnosis(diagnosis);
        Appointment appointment = new Appointment();
        diagnosis.setAppointment(appointment);
        assertEquals(provider.updateDiagnosis(diagnosis), RequestStatus.FAIL);   
    }
     /**
     * Successful test of getDiagnosis method, of class DataProvider.
     */
    @Test
    public void testGetDiagnosis() {
        Diagnosis diagnosis = generator.generateDiagnosis().get(0);
        log.debug(diagnosis.getId());
        provider.insertDiagnosis(diagnosis);
        assertEquals(provider.getDiagnosisById(diagnosis.getId()).get().getId(), diagnosis.getId());        
    }
    
    /**
     * Failed test of getDiagnosis method, of class DataProvider.
     */
    @Test
    public void testGetDiagnosisFail() {
        assertEquals(provider.getDiagnosisById(0), Optional.empty()); 
    }
    
    
     /**
     * Successful test of insertHospital method, of class DataProvider.
     */
    @Test
    public void testInsertHospital() {
        Hospital hospital = generator.generateHospital().get(0);
        log.debug(hospital.getId());
        assertEquals(provider.insertHospital(hospital), RequestStatus.SUCCESS);        
    }
    
    /**
     * Failed test of insertHospital method, of class DataProvider.
     */
    @Test
    public void testInsertHospitalFail() {
        Hospital hospital = generator.generateHospital().get(0);
        Appointment appointment = new Appointment();
        hospital.setName(null);
        assertEquals(provider.insertHospital(hospital), RequestStatus.FAIL);
    }
    /**
     * Successful test of deleteHospital method, of class DataProvider.
     */
    @Test
    public void testDeleteHospital() {
        Hospital hospital = generator.generateHospital().get(0);
        provider.insertHospital(hospital);
        log.debug(hospital.getId());
        assertEquals(provider.deleteHospital(hospital), RequestStatus.SUCCESS);        
    }
    
    /**
     * Failed test of deleteHospital method, of class DataProvider.
     */
    @Test
    public void testDeleteHospitalFail() {
        Hospital hospital = generator.generateHospital().get(0);
        provider.insertHospital(hospital);
        log.debug(hospital.getId());
        assertEquals(provider.deleteHospital(hospital), RequestStatus.SUCCESS);  
    }
    /**
     * Successful test of updateHospital method, of class DataProvider.
     */
    @Test
    public void testUpdateHospital() {
        Hospital hospital = generator.generateHospital().get(0);
        log.debug(hospital.getId());
        provider.insertHospital(hospital);
        hospital.setName("UPDATE");
        assertEquals(provider.updateHospital(hospital), RequestStatus.SUCCESS);        
    }
    
    /**
     * Failed test of updateHospital method, of class DataProvider.
     */
    @Test
    public void testUpdateHospitalFail() {
        Hospital hospital = generator.generateHospital().get(0);
        log.debug(hospital.getId());
        provider.insertHospital(hospital);
        Appointment appointment = new Appointment();
        hospital.setName(null);
        assertEquals(provider.updateHospital(hospital), RequestStatus.FAIL);   
    }
     /**
     * Successful test of getHospital method, of class DataProvider.
     */
    @Test
    public void testGetHospital() {
        Hospital hospital = generator.generateHospital().get(0);
        log.debug(hospital.getId());
        provider.insertHospital(hospital);
        assertEquals(provider.getHospitalById(hospital.getId()).get().getId(), hospital.getId());        
    }
    
    /**
     * Failed test of getHospital method, of class DataProvider.
     */
    @Test
    public void testGetHospitalFail() {
        assertEquals(provider.getHospitalById(0), Optional.empty()); 
    }  
    
     /**
     * Successful test of insertHospitalization method, of class DataProvider.
     */
    @Test
    public void testInsertHospitalization() {
        Hospitalization hospitalization = generator.generateHospitalization().get(0);
        log.debug(hospitalization.getId());
        assertEquals(provider.insertHospitalization(hospitalization), RequestStatus.SUCCESS);        
    }
    
    /**
     * Failed test of insertHospitalization method, of class DataProvider.
     */
    @Test
    public void testInsertHospitalizationFail() {
        Hospitalization hospitalization = generator.generateHospitalization().get(0);
        Appointment appointment = new Appointment();
        hospitalization.setAppointment(appointment);
        assertEquals(provider.insertHospitalization(hospitalization), RequestStatus.FAIL);
    }
    /**
     * Successful test of deleteHospitalization method, of class DataProvider.
     */
    @Test
    public void testDeleteHospitalization() {
        Hospitalization hospitalization = generator.generateHospitalization().get(0);
        provider.insertHospitalization(hospitalization);
        log.debug(hospitalization.getId());
        assertEquals(provider.deleteHospitalization(hospitalization), RequestStatus.SUCCESS);        
    }
    
    /**
     * Failed test of deleteHospitalization method, of class DataProvider.
     */
    @Test
    public void testDeleteHospitalizationFail() {
        Hospitalization hospitalization = generator.generateHospitalization().get(0);
        provider.insertHospitalization(hospitalization);
        log.debug(hospitalization.getId());
        assertEquals(provider.deleteHospitalization(hospitalization), RequestStatus.SUCCESS);  
    }
    /**
     * Successful test of updateHospitalization method, of class DataProvider.
     */
    @Test
    public void testUpdateHospitalization() {
        Hospitalization hospitalization = generator.generateHospitalization().get(0);
        log.debug(hospitalization.getId());
        provider.insertHospitalization(hospitalization);
        hospitalization.setSignature(true);
        assertEquals(provider.updateHospitalization(hospitalization), RequestStatus.SUCCESS);        
    }
    
    /**
     * Failed test of updateHospitalization method, of class DataProvider.
     */
    @Test
    public void testUpdateHospitalizationFail() {
        Hospitalization hospitalization = generator.generateHospitalization().get(0);
        log.debug(hospitalization.getId());
        provider.insertHospitalization(hospitalization);
        Appointment appointment = new Appointment();
        hospitalization.setAppointment(appointment);
        assertEquals(provider.updateHospitalization(hospitalization), RequestStatus.FAIL);   
    }
     /**
     * Successful test of getHospitalization method, of class DataProvider.
     */
    @Test
    public void testGetHospitalization() {
        Hospitalization hospitalization = generator.generateHospitalization().get(0);
        log.debug(hospitalization.getId());
        provider.insertHospitalization(hospitalization);
        assertEquals(provider.getHospitalizationById(hospitalization.getId()).get().getId(), hospitalization.getId());        
    }
    
    /**
     * Failed test of getHospitalization method, of class DataProvider.
     */
    @Test
    public void testGetHospitalizationFail() {
        assertEquals(provider.getHospitalizationById(0), Optional.empty()); 
    }
    
    @Test
    public void cascadeDeleteManyToMany() {        
        generator.generateHospitalization().stream().forEach(item -> provider.insertHospitalization(item));
        provider.deleteHospitalById(3);
    }
    @Test
    public void cascadeDeleteOneToOnePrimaryKeyJoinColumn() {        
        generator.generateHospitalization().stream().forEach(item -> provider.insertHospitalization(item));
        provider.deleteHospitalizationById(2);
        provider.deleteAppointmentById(2);
    }
    
    @Test
    public void cascadeDeleteOneToOneGeneratedKey() {        
        generator.generatePayment().stream().forEach(item -> provider.insertPayment(item));
        generator.generatePayment().stream().forEach(item -> provider.insertPayment(item));
        generator.generatePayment().stream().forEach(item -> provider.insertPayment(item));
        provider.deleteAppointmentById(1); //delete both
        provider.deletePaymentById(2); //delete only payment record
    }
    
    @Test
    public void cascadeDeleteOneToOneForeignKey() {        
        generator.generateAppointment().stream().forEach(item -> provider.insertAppointment(item));
        generator.generateAppointment().stream().forEach(item -> provider.insertAppointment(item));
        generator.generateAppointment().stream().forEach(item -> provider.insertAppointment(item));
        provider.deleteAppointmentById(1); //delete patient, doctor and appointment
    }
    
    @Test
    public void cascadeDeleteOneToManyManyToOne() {        
        //generator.generateAppointment().stream().forEach(item -> provider.insertAppointment(item));
        generator.generateDiagnosis().stream().forEach(item -> provider.insertDiagnosis(item));
        generator.generateDiagnosis().stream().forEach(item -> provider.insertDiagnosis(item));
        Appointment appointment = provider.getAppointmentById(1).get();
        Set <Diagnosis> diagnosis = appointment.getDiagnosis();
        diagnosis.stream().forEach(item -> provider.deleteDiagnosis(item));
        provider.deleteAppointmentById(1); //delete patient, doctor and appointment       
    }
    
    @Test
    public void Notes() {
        //generator.generateHospitalization().stream().forEach(item -> provider.insertHospitalization(item));
        //generator.generateDiagnosis().stream().forEach(item -> provider.insertDiagnosis(item));
        //assertEquals(provider.insertDiagnosis(generator.generateDiagnosis().get(0)), RequestStatus.SUCCESS);
        //assertEquals(provider.insertPayment(generator.generatePayment().get(0)), RequestStatus.SUCCESS);
        //ssertEquals(provider.insertHospitalization(generator.generateHospitalization().get(0)), RequestStatus.SUCCESS);        
       /*generator.generateHospitalization().stream().forEach(item -> provider.insertHospitalization(item));
        generator.generateHospitalization().stream().forEach(item -> provider.insertHospitalization(item));*/
        //generator.generateAppointment().stream().forEach(item -> provider.insertAppointment(item));
        //generator.generateDiagnosis().stream().forEach(item -> provider.insertDiagnosis(item));
       // generator.generateDiagnosis().stream().forEach(item -> provider.insertDiagnosis(item));
        //generator.generateDiagnosis().stream().forEach(item -> provider.insertDiagnosis(item));
       // generator.generateSurvey().stream().forEach(item -> provider.insertSurvey(item));
        //generator.generateAppointment().stream().forEach(item -> provider.insertAppointment(item));
        //generator.generateHospitalization().stream().forEach(item -> provider.insertHospitalization(item));
        //generator.generatePayment().stream().forEach(item -> provider.insertPayment(item));
        //generator.generateDiagnosis().stream().forEach(item -> provider.insertDiagnosis(item));
        //provider.deleteHospitalizationById(2);
        //provider.deleteAppointmentById(7);
        //provider.updateAppointment(provider.getAppointmentById(3).get());
        //provider.deleteEmployeeById(1);
       //provider.deleteSurveyById(1);
      //provider.deleteDiagnosisById(1);
       //provider.deleteHospitalizationById(1);
      // provider.deletePaymentById(1);
        //generator.generateHospitalization().stream().forEach(item -> provider.insertHospitalization(item));
       // generator.generateHospitalization().stream().forEach(item -> provider.insertHospitalization(item));
       // generator.generateHospitalization().stream().forEach(item -> provider.insertHospitalization(item));
       //generator.generateHospital().stream().forEach(item -> provider.insertHospital(item));
       //generator.generateHospitalization();
      // provider.deleteHospitalById(8);
    }
    
}
