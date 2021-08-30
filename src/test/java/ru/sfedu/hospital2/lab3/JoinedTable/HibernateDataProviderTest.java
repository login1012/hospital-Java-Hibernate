/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.hospital2.lab3.JoinedTable;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.sfedu.hospital2.enums.RequestStatus;
import ru.sfedu.hospital2.lab3.JoinedTable.model.Appointment;
import ru.sfedu.hospital2.lab3.JoinedTable.model.Diagnosis;
import ru.sfedu.hospital2.lab3.JoinedTable.model.Employee;
import ru.sfedu.hospital2.lab3.JoinedTable.model.Hospital;
import ru.sfedu.hospital2.lab3.JoinedTable.model.Hospitalization;
import ru.sfedu.hospital2.lab3.JoinedTable.model.MedicalInsurance;
import ru.sfedu.hospital2.lab3.JoinedTable.model.Patient;
import ru.sfedu.hospital2.lab3.JoinedTable.model.Payment;
import ru.sfedu.hospital2.lab3.JoinedTable.model.Survey;

/**
 *
 * @author Liza
 */
public class HibernateDataProviderTest {   
    
    private static final Logger log = LogManager.getLogger(HibernateDataProviderTest.class);
    private static final HibernateDataProvider provider = new HibernateDataProvider();
    public static JoinedGenerator generator = new JoinedGenerator();
    
    /*@Before
    public void setUp() {
        generator.generateEmployee().stream().forEach(item -> provider.createEmployee(item));
        generator.generatePatient().stream().forEach(item -> provider.createPatient(item));
        generator.generateHospital().stream().forEach(item -> provider.createHospital(item));
        generator.generateAppointment().stream().forEach(item -> provider.createAppointment(item));
        generator.generateSurvey().stream().forEach(item -> provider.createSurvey(item));
        generator.generateDiagnosis().stream().forEach(item -> provider.createDiagnosis(item));
        generator.generateHospitalization().stream().forEach(item -> provider.createHospitalization(item));
        generator.generateMedicalInsurance().stream().forEach(item -> provider.createMedicalInsurance(item));
        generator.generatePayment().stream().forEach(item -> provider.createPayment(item));
        
    }*/


    /**
    /**
     * Success Test of getEmployee method, of class HibernateDataProvider.
     */
    @Test
    public void testGetEmployee() {
        generator.generateEmployee().stream().forEach(item -> provider.createEmployee(item));
        Employee employee = provider.getEmployee(provider.maxEmployee().get()).get();
        assertEquals(employee.getId(), provider.maxEmployee().get().intValue());
    }
    
    /**
     * Failed Test of getEmployee method, of class HibernateDataProvider.
     */
    @Test
    public void testGetEmployeeFail() {
        generator.generateEmployee().stream().forEach(item -> provider.createEmployee(item));
        Employee employee = provider.getEmployee(provider.maxEmployee().get()).get();
        assertEquals(employee.getId(), provider.maxEmployee().get().intValue());
    }
    
    /**
     * Success Test of createEmployee method, of class HibernateDataProvider.
     */
    @Test
    public void testCreateEmployee() {
        List<Employee> employee = generator.generateEmployee();
        assertEquals(provider.createEmployee(employee.get(0)), RequestStatus.SUCCESS);
    }
    
    /**
     * Failed Test of createEmployee method, of class HibernateDataProvider.
     */
    @Test
    public void testCreateEmployeeFail() {
        List<Employee> employee = generator.generateEmployee();
        assertEquals(provider.createEmployee(employee.get(1)), RequestStatus.SUCCESS);
    }

    /**
     * Success Test of deleteEmployee method, of class HibernateDataProvider.
     */
    @Test
    public void testDeleteEmployee() {
        generator.generateEmployee().stream().forEach(item -> provider.createEmployee(item));
        Employee employee = provider.getEmployee(provider.maxEmployee().get()).get();
        assertEquals(provider.deleteEmployee(employee.getId()), RequestStatus.SUCCESS);
    }

    
    /**
     * Fail Test of deleteEmployee method, of class HibernateDataProvider.
     */
    @Test
    public void testDeleteEmployeeFail() {
        Employee employee = provider.getEmployee(provider.maxEmployee().get()).get();
        assertEquals(provider.deleteEmployee(employee.getId()), RequestStatus.SUCCESS);
    }
    
    /**
     * Success Test of updateEmployee method, of class HibernateDataProvider.
     */
    @Test
    public void testUpdateEmployee() {
        generator.generateEmployee().stream().forEach(item -> provider.createEmployee(item));
        Employee employee = provider.getEmployee(provider.maxEmployee().get()).get();
        employee.setName("UPDATENAME");
        assertEquals(provider.updateEmployee(employee), RequestStatus.SUCCESS);
    }
    
    /**
     * Failed Test of updateEmployee method, of class HibernateDataProvider.
     */
    @Test
    public void testUpdateEmployeeFail() {
        generator.generateEmployee().stream().forEach(item -> provider.createEmployee(item));
        Employee employee = provider.getEmployee(provider.maxEmployee().get()).get();
        employee.setName("UPDATENAME");
        assertEquals(provider.updateEmployee(employee), RequestStatus.SUCCESS);
    }
    
    /**
     * Success Test of getAppointment method, of class HibernateDataProvider.
     */
    @Test
    public void testGetAppointment() {
        generator.generateAppointment().stream().forEach(item -> provider.createAppointment(item));
        Appointment appointment = provider.getAppointment(provider.maxAppointment().get()).get();
        assertEquals(appointment.getId(), provider.maxAppointment().get().intValue());
    }
    
    /**
     * Failed Test of getAppointment method, of class HibernateDataProvider.
     */
    @Test
    public void testGetAppointmentFail() {
        generator.generateAppointment().stream().forEach(item -> provider.createAppointment(item));
        Appointment appointment = provider.getAppointment(provider.maxAppointment().get()).get();
        assertEquals(appointment.getId(), provider.maxAppointment().get().intValue());
    }
    
    /**
     * Success Test of createAppointment method, of class HibernateDataProvider.
     */
    @Test
    public void testCreateAppointment() {
        List<Appointment> appointment = generator.generateAppointment();
        assertEquals(provider.createAppointment(appointment.get(0)), RequestStatus.SUCCESS);
    }
    
    /**
     * Failed Test of createAppointment method, of class HibernateDataProvider.
     */
    @Test
    public void testCreateAppointmentFail() {
        List<Appointment> appointment = generator.generateAppointment();
        assertEquals(provider.createAppointment(appointment.get(1)), RequestStatus.SUCCESS);
    }

    /**
     * Success Test of deleteAppointment method, of class HibernateDataProvider.
     */
    @Test
    public void testDeleteAppointment() {
        generator.generateAppointment().stream().forEach(item -> provider.createAppointment(item));
        Appointment appointment = provider.getAppointment(provider.maxAppointment().get()).get();
        assertEquals(provider.deleteAppointment(appointment.getId()), RequestStatus.SUCCESS);
    }

    
    /**
     * Fail Test of deleteAppointment method, of class HibernateDataProvider.
     */
    @Test
    public void testDeleteAppointmentFail() {
         generator.generateAppointment().stream().forEach(item -> provider.createAppointment(item));
        Appointment appointment = provider.getAppointment(provider.maxAppointment().get()).get();
        assertEquals(provider.deleteAppointment(appointment.getId()), RequestStatus.SUCCESS);
    }
    
    /**
     * Success Test of updateAppointment method, of class HibernateDataProvider.
     */
    @Test
    public void testUpdateAppointment() {
         generator.generateAppointment().stream().forEach(item -> provider.createAppointment(item));
        Appointment appointment = provider.getAppointment(provider.maxAppointment().get()).get();
        appointment.setSpecialization("UPDATE");
        assertEquals(provider.updateAppointment(appointment), RequestStatus.SUCCESS);
    }
    
    /**
     * Failed Test of updateAppointment method, of class HibernateDataProvider.
     */
    @Test
    public void testUpdateAppointmentFail() {
         generator.generateAppointment().stream().forEach(item -> provider.createAppointment(item));
        Appointment appointment = provider.getAppointment(provider.maxAppointment().get()).get();
        appointment.setSpecialization("UPDATE");
        assertEquals(provider.updateAppointment(appointment), RequestStatus.SUCCESS);
    }
    
    /**
     * Success Test of getDiagnosis method, of class HibernateDataProvider.
     */
    @Test
    public void testGetDiagnosis() {
         generator.generateDiagnosis().stream().forEach(item -> provider.createDiagnosis(item));
        Diagnosis diagnosis = provider.getDiagnosis(provider.maxDiagnosis().get()).get();
        assertEquals(diagnosis.getId(), provider.maxDiagnosis().get().intValue());
    }
    
    /**
     * Failed Test of getDiagnosis method, of class HibernateDataProvider.
     */
    @Test
    public void testGetDiagnosisFail() {
         generator.generateDiagnosis().stream().forEach(item -> provider.createDiagnosis(item));
        Diagnosis diagnosis = provider.getDiagnosis(provider.maxDiagnosis().get()).get();
        assertEquals(diagnosis.getId(), provider.maxDiagnosis().get().intValue());
    }
    
    /**
     * Success Test of createDiagnosis method, of class HibernateDataProvider.
     */
    @Test
    public void testCreateDiagnosis() {
        List<Diagnosis> diagnosis = generator.generateDiagnosis();
        assertEquals(provider.createDiagnosis(diagnosis.get(0)), RequestStatus.SUCCESS);
    }
    
    /**
     * Failed Test of createDiagnosis method, of class HibernateDataProvider.
     */
    @Test
    public void testCreateDiagnosisFail() {
        List<Diagnosis> diagnosis = generator.generateDiagnosis();
        assertEquals(provider.createDiagnosis(diagnosis.get(0)), RequestStatus.SUCCESS);
    }

    /**
     * Success Test of deleteDiagnosis method, of class HibernateDataProvider.
     */
    @Test
    public void testDeleteDiagnosis() {
        generator.generateDiagnosis().stream().forEach(item -> provider.createDiagnosis(item));
        Diagnosis diagnosis = provider.getDiagnosis(provider.maxDiagnosis().get()).get();
        assertEquals(provider.deleteDiagnosis(diagnosis.getId()), RequestStatus.SUCCESS);
    }

    
    /**
     * Fail Test of deleteDiagnosis method, of class HibernateDataProvider.
     */
    @Test
    public void testDeleteDiagnosisFail() {
        Diagnosis diagnosis = provider.getDiagnosis(provider.maxDiagnosis().get()).get();
        assertEquals(provider.deleteDiagnosis(diagnosis.getId()), RequestStatus.SUCCESS);
    }
    
    /**
     * Success Test of updateDiagnosis method, of class HibernateDataProvider.
     */
    @Test
    public void testUpdateDiagnosis() {
         generator.generateDiagnosis().stream().forEach(item -> provider.createDiagnosis(item));
        Diagnosis diagnosis = provider.getDiagnosis(provider.maxDiagnosis().get()).get();
        diagnosis.setDiagnosis("UPDATE");
        assertEquals(provider.updateDiagnosis(diagnosis), RequestStatus.SUCCESS);
    }
    
    /**
     * Failed Test of updateDiagnosis method, of class HibernateDataProvider.
     */
    @Test
    public void testUpdateDiagnosisFail() {
        Diagnosis diagnosis = provider.getDiagnosis(provider.maxDiagnosis().get()).get();
        diagnosis.setDiagnosis("UPDATE");
        assertEquals(provider.updateDiagnosis(diagnosis), RequestStatus.SUCCESS);
    }
    
    /**
     * Success Test of getHospital method, of class HibernateDataProvider.
     */
    @Test
    public void testGetHospital() {
        generator.generateHospital().stream().forEach(item -> provider.createHospital(item));
        Hospital hospital = provider.getHospital(provider.maxHospital().get()).get();
        assertEquals(hospital.getId(), provider.maxHospital().get().intValue());
    }
    
    /**
     * Failed Test of getHospital method, of class HibernateDataProvider.
     */
    @Test
    public void testGetHospitalFail() {
        Hospital hospital = provider.getHospital(provider.maxHospital().get()).get();
        assertEquals(hospital.getId(), provider.maxHospital().get().intValue());
    }
    
    /**
     * Success Test of createHospital method, of class HibernateDataProvider.
     */
    @Test
    public void testCreateHospital() {
        List<Hospital> hospital = generator.generateHospital();
        assertEquals(provider.createHospital(hospital.get(1)), RequestStatus.SUCCESS);
    }
    
    /**
     * Failed Test of createHospital method, of class HibernateDataProvider.
     */
    @Test
    public void testCreateHospitalFail() {
        List<Hospital> hospital = generator.generateHospital();
        assertEquals(provider.createHospital(hospital.get(1)), RequestStatus.SUCCESS);
    }

    /**
     * Success Test of deleteHospital method, of class HibernateDataProvider.
     */
    @Test
    public void testDeleteHospital() {
        Hospital hospital = provider.getHospital(provider.maxHospital().get()).get();
        assertEquals(provider.deleteHospital(hospital.getId()), RequestStatus.SUCCESS);
    }

    
    /**
     * Fail Test of deleteHospital method, of class HibernateDataProvider.
     */
    @Test
    public void testDeleteHospitalFail() {
        Hospital hospital = provider.getHospital(provider.maxHospital().get()).get();
        assertEquals(provider.deleteHospital(hospital.getId()), RequestStatus.SUCCESS);
    }
    
    /**
     * Success Test of updateHospital method, of class HibernateDataProvider.
     */
    @Test
    public void testUpdateHospital() {
        Hospital hospital = provider.getHospital(provider.maxHospital().get()).get();
        hospital.setName("UPDATENAME");
        assertEquals(provider.updateHospital(hospital), RequestStatus.SUCCESS);
    }
    
    /**
     * Failed Test of updateHospital method, of class HibernateDataProvider.
     */
    @Test
    public void testUpdateHospitalFail() {
        Hospital hospital = provider.getHospital(provider.maxHospital().get()).get();
        hospital.setName("UPDATENAME");
        assertEquals(provider.updateHospital(hospital), RequestStatus.SUCCESS);
    }
    
    /**
     * Success Test of getHospitalization method, of class HibernateDataProvider.
     */
    @Test
    public void testGetHospitalization() {
         generator.generateHospitalization().stream().forEach(item -> provider.createHospitalization(item));
        Hospitalization hospitalization = provider.getHospitalization(provider.maxHospitalization().get()).get();
        assertEquals(hospitalization.getId(), provider.maxHospitalization().get().intValue());
    }
    
    /**
     * Failed Test of getHospitalization method, of class HibernateDataProvider.
     */
    @Test
    public void testGetHospitalizationFail() {
        Hospitalization hospitalization = provider.getHospitalization(provider.maxHospitalization().get()).get();
        assertEquals(hospitalization.getId(), provider.maxHospitalization().get().intValue());
    }
    
    /**
     * Success Test of createHospitalization method, of class HibernateDataProvider.
     */
    @Test
    public void testCreateHospitalization() {
        List<Hospitalization> hospitalization = generator.generateHospitalization();
        assertEquals(provider.createHospitalization(hospitalization.get(1)), RequestStatus.SUCCESS);
    }
    
    /**
     * Failed Test of createHospitalization method, of class HibernateDataProvider.
     */
    @Test
    public void testCreateHospitalizationFail() {
        List<Hospitalization> hospitalization = generator.generateHospitalization();
        assertEquals(provider.createHospitalization(hospitalization.get(1)), RequestStatus.SUCCESS);
    }

    /**
     * Success Test of deleteHospitalization method, of class HibernateDataProvider.
     */
    @Test
    public void testDeleteHospitalization() {
        generator.generateHospitalization().stream().forEach(item -> provider.createHospitalization(item));
        Hospitalization hospitalization = provider.getHospitalization(provider.maxHospitalization().get()).get();
        assertEquals(provider.deleteHospitalization(hospitalization.getId()), RequestStatus.SUCCESS);
    }

    
    /**
     * Fail Test of deleteHospitalization method, of class HibernateDataProvider.
     */
    @Test
    public void testDeleteHospitalizationFail() {
        generator.generateHospitalization().stream().forEach(item -> provider.createHospitalization(item));
        Hospitalization hospitalization = provider.getHospitalization(provider.maxHospitalization().get()).get();
        assertEquals(provider.deleteHospitalization(hospitalization.getId()), RequestStatus.SUCCESS);
    }
    
    /**
     * Success Test of updateHospitalization method, of class HibernateDataProvider.
     */
    @Test
    public void testUpdateHospitalization() {
         generator.generateHospitalization().stream().forEach(item -> provider.createHospitalization(item));
        Hospitalization hospitalization = provider.getHospitalization(provider.maxHospitalization().get()).get();
        log.debug(hospitalization.getId()+" Test ");
        hospitalization.setHour(15);
        assertEquals(provider.updateHospitalization(hospitalization), RequestStatus.SUCCESS);
    }
    
    /**
     * Failed Test of updateHospitalization method, of class HibernateDataProvider.
     */
    @Test
    public void testUpdateHospitalizationFail() {
         generator.generateHospitalization().stream().forEach(item -> provider.createHospitalization(item));
        Hospitalization hospitalization = provider.getHospitalization(provider.maxHospitalization().get()).get();
        hospitalization.setHour(15);
        assertEquals(provider.updateHospitalization(hospitalization), RequestStatus.SUCCESS);
    }
    
    /**
     * Success Test of getMedicalInsurance method, of class HibernateDataProvider.
     */
    @Test
    public void testGetMedicalInsurance() {
         generator.generateMedicalInsurance().stream().forEach(item -> provider.createMedicalInsurance(item));
        MedicalInsurance medicalInsurance = provider.getMedicalInsurance(provider.maxMedicalInsurance().get()).get();
        assertEquals(medicalInsurance.getId(), provider.maxMedicalInsurance().get().intValue());
    }
    
    /**
     * Failed Test of getMedicalInsurance method, of class HibernateDataProvider.
     */
    @Test
    public void testGetMedicalInsuranceFail() {
         generator.generateMedicalInsurance().stream().forEach(item -> provider.createMedicalInsurance(item));
        MedicalInsurance medicalInsurance = provider.getMedicalInsurance(provider.maxMedicalInsurance().get()).get();
        log.debug(medicalInsurance.getId() + "Test");
        assertEquals(medicalInsurance.getId(), provider.maxMedicalInsurance().get().intValue());
    }
    
    /**
     * Success Test of createMedicalInsurance method, of class HibernateDataProvider.
     */
    @Test
    public void testCreateMedicalInsurance() {
        generator.generateMedicalInsurance().stream().forEach(item -> provider.createMedicalInsurance(item));
        List<MedicalInsurance> medicalInsurance = generator.generateMedicalInsurance();
        assertEquals(provider.createMedicalInsurance(medicalInsurance.get(1)), RequestStatus.SUCCESS);
    }
    
    /**
     * Failed Test of createMedicalInsurance method, of class HibernateDataProvider.
     */
    @Test
    public void testCreateMedicalInsuranceFail() {
        List<MedicalInsurance> medicalInsurance = generator.generateMedicalInsurance();
        assertEquals(provider.createMedicalInsurance(medicalInsurance.get(1)), RequestStatus.SUCCESS);
    }

    /**
     * Success Test of deleteMedicalInsurance method, of class HibernateDataProvider.
     */
    @Test
    public void testDeleteMedicalInsurance() {
         generator.generateMedicalInsurance().stream().forEach(item -> provider.createMedicalInsurance(item));
        MedicalInsurance medicalInsurance = provider.getMedicalInsurance(provider.maxMedicalInsurance().get()).get();
        assertEquals(provider.deleteMedicalInsurance(medicalInsurance.getId()), RequestStatus.SUCCESS);
    }

    
    /**
     * Fail Test of deleteMedicalInsurance method, of class HibernateDataProvider.
     */
    @Test
    public void testDeleteMedicalInsuranceFail() {
        generator.generateMedicalInsurance().stream().forEach(item -> provider.createMedicalInsurance(item));
        MedicalInsurance medicalInsurance = provider.getMedicalInsurance(provider.maxMedicalInsurance().get()).get();
        assertEquals(provider.deleteMedicalInsurance(medicalInsurance.getId()), RequestStatus.SUCCESS);
    }
    
    /**
     * Success Test of updateMedicalInsurance method, of class HibernateDataProvider.
     */
    @Test
    public void testUpdateMedicalInsurance() {
         generator.generateMedicalInsurance().stream().forEach(item -> provider.createMedicalInsurance(item));
        MedicalInsurance medicalInsurance = provider.getMedicalInsurance(provider.maxMedicalInsurance().get()).get();
        medicalInsurance.setReimbursement(999);
        assertEquals(provider.updateMedicalInsurance(medicalInsurance), RequestStatus.SUCCESS);
    }
    
    /**
     * Failed Test of updateMedicalInsurance method, of class HibernateDataProvider.
     */
    @Test
    public void testUpdateMedicalInsuranceFail() {
        MedicalInsurance medicalInsurance = provider.getMedicalInsurance(provider.maxMedicalInsurance().get()).get();
        medicalInsurance.setReimbursement(999);
        assertEquals(provider.updateMedicalInsurance(medicalInsurance), RequestStatus.SUCCESS);
    }
    
    /**
     * Success Test of getPatient method, of class HibernateDataProvider.
     */
    @Test
    public void testGetPatient() {
         generator.generatePatient().stream().forEach(item -> provider.createPatient(item));
        Patient patient = provider.getPatient(provider.maxPatient().get()).get();
        assertEquals(patient.getId(), provider.maxPatient().get().intValue());
    }
    
    /**
     * Failed Test of getPatient method, of class HibernateDataProvider.
     */
    @Test
    public void testGetPatientFail() {
        Patient patient = provider.getPatient(provider.maxPatient().get()).get();
        assertEquals(patient.getId(), provider.maxPatient().get().intValue());
    }
    
    /**
     * Success Test of createPatient method, of class HibernateDataProvider.
     */
    @Test
    public void testCreatePatient() {
        Patient patient = generator.generatePatient().get(0);
        Date date = new Date();
        patient.setPassport(date.toString());
        assertEquals(provider.createPatient(patient), RequestStatus.SUCCESS);
    }
    
    /**
     * Failed Test of createPatient method, of class HibernateDataProvider.
     */
    @Test
    public void testCreatePatientFail() {
        List<Patient> patient = generator.generatePatient();
        Date date = new Date();
        patient.get(0).setPassport(date.toString());
        assertEquals(provider.createPatient(patient.get(0)), RequestStatus.SUCCESS);
    }

    /**
     * Success Test of deletePatient method, of class HibernateDataProvider.
     */
    @Test
    public void testDeletePatient() {
         generator.generatePatient().stream().forEach(item -> provider.createPatient(item));
        Patient patient = provider.getPatient(provider.maxPatient().get()).get();
        assertEquals(provider.deletePatient(patient.getId()), RequestStatus.SUCCESS);
    }

    
    /**
     * Fail Test of deletePatient method, of class HibernateDataProvider.
     */
    @Test
    public void testDeletePatientFail() {
        Patient patient = provider.getPatient(provider.maxPatient().get()).get();
        assertEquals(provider.deletePatient(patient.getId()), RequestStatus.SUCCESS);
    }
    
    /**
     * Success Test of updatePatient method, of class HibernateDataProvider.
     */
    @Test
    public void testUpdatePatient() {
        Patient patient = provider.getPatient(provider.maxPatient().get()).get();
        patient.setName("UPDATENAME");
        assertEquals(provider.updatePatient(patient), RequestStatus.SUCCESS);
    }
    
    /**
     * Failed Test of updatePatient method, of class HibernateDataProvider.
     */
    @Test
    public void testUpdatePatientFail() {
        Patient patient = provider.getPatient(provider.maxPatient().get()).get();
        patient.setName("UPDATENAME");
        assertEquals(provider.updatePatient(patient), RequestStatus.SUCCESS);
    }
    
    /**
     * Success Test of getPayment method, of class HibernateDataProvider.
     */
    @Test
    public void testGetPayment() {
         generator.generatePayment().stream().forEach(item -> provider.createPayment(item));
        Payment payment = provider.getPayment(provider.maxPayment().get()).get();
        assertEquals(payment.getId(), provider.maxPayment().get().intValue());
    }
    
    /**
     * Failed Test of getPayment method, of class HibernateDataProvider.
     */
    @Test
    public void testGetPaymentFail() {
        generator.generatePayment().stream().forEach(item -> provider.createPayment(item));
        Payment payment = provider.getPayment(provider.maxPayment().get()).get();
        assertEquals(payment.getId(), provider.maxPayment().get().intValue());
    }
    
    /**
     * Success Test of createPayment method, of class HibernateDataProvider.
     */
    @Test
    public void testCreatePayment() {
        List<Payment> payment = generator.generatePayment();
        assertEquals(provider.createPayment(payment.get(1)), RequestStatus.SUCCESS);
    }
    
    /**
     * Failed Test of createPayment method, of class HibernateDataProvider.
     */
    @Test
    public void testCreatePaymentFail() {
        List<Payment> payment = generator.generatePayment();
        assertEquals(provider.createPayment(payment.get(1)), RequestStatus.SUCCESS);
    }

    /**
     * Success Test of deletePayment method, of class HibernateDataProvider.
     */
    @Test
    public void testDeletePayment() {
        generator.generatePayment().stream().forEach(item -> provider.createPayment(item));
        Payment payment = provider.getPayment(provider.maxPayment().get()).get();
        assertEquals(provider.deletePayment(payment.getId()), RequestStatus.SUCCESS);
    }

    
    /**
     * Fail Test of deletePayment method, of class HibernateDataProvider.
     */
    @Test
    public void testDeletePaymentFail() {
         generator.generatePayment().stream().forEach(item -> provider.createPayment(item));
        Payment payment = provider.getPayment(provider.maxPayment().get()).get();
        assertEquals(provider.deletePayment(payment.getId()), RequestStatus.SUCCESS);
    }
    
    /**
     * Success Test of updatePayment method, of class HibernateDataProvider.
     */
    @Test
    public void testUpdatePayment() {
        generator.generatePayment().stream().forEach(item -> provider.createPayment(item));
        Payment payment = provider.getPayment(provider.maxPayment().get()).get();
        payment.setPrice(999);
        assertEquals(provider.updatePayment(payment), RequestStatus.SUCCESS);
    }
    
    /**
     * Failed Test of updatePayment method, of class HibernateDataProvider.
     */
    @Test
    public void testUpdatePaymentFail() {
        Payment payment = provider.getPayment(provider.maxPayment().get()).get();
        payment.setPrice(999);
        assertEquals(provider.updatePayment(payment), RequestStatus.SUCCESS);
    }
    
    /**
     * Success Test of getSurvey method, of class HibernateDataProvider.
     */
    @Test
    public void testGetSurvey() {
        generator.generateSurvey().stream().forEach(item -> provider.createSurvey(item));
        Survey survey = provider.getSurvey(provider.maxSurvey().get()).get();
        assertEquals(survey.getId(), provider.maxSurvey().get().intValue());
    }
    
    /**
     * Failed Test of getSurvey method, of class HibernateDataProvider.
     */
    @Test
    public void testGetSurveyFail() {
        generator.generateSurvey().stream().forEach(item -> provider.createSurvey(item));
        Survey survey = provider.getSurvey(provider.maxSurvey().get()).get();
        assertEquals(survey.getId(), provider.maxSurvey().get().intValue());
    }
    
    /**
     * Success Test of createSurvey method, of class HibernateDataProvider.
     */
    @Test
    public void testCreateSurvey() {
        List<Survey> survey = generator.generateSurvey();
        assertEquals(provider.createSurvey(survey.get(1)), RequestStatus.SUCCESS);
    }
    
    /**
     * Failed Test of createSurvey method, of class HibernateDataProvider.
     */
    @Test
    public void testCreateSurveyFail() {
        List<Survey> survey = generator.generateSurvey();
        assertEquals(provider.createSurvey(survey.get(1)), RequestStatus.SUCCESS);
    }

    /**
     * Success Test of deleteSurvey method, of class HibernateDataProvider.
     */
    @Test
    public void testDeleteSurvey() {
         generator.generateSurvey().stream().forEach(item -> provider.createSurvey(item));
        Survey survey = provider.getSurvey(provider.maxSurvey().get()).get();
        assertEquals(provider.deleteSurvey(survey.getId()), RequestStatus.SUCCESS);
    }

    
    /**
     * Fail Test of deleteSurvey method, of class HibernateDataProvider.
     */
    @Test
    public void testDeleteSurveyFail() {
        generator.generateSurvey().stream().forEach(item -> provider.createSurvey(item));
        Survey survey = provider.getSurvey(provider.maxSurvey().get()).get();
        assertEquals(provider.deleteSurvey(survey.getId()), RequestStatus.SUCCESS);
    }
    
    /**
     * Success Test of updateSurvey method, of class HibernateDataProvider.
     */
    @Test
    public void testUpdateSurvey() {
         generator.generateSurvey().stream().forEach(item -> provider.createSurvey(item));
        Survey survey = provider.getSurvey(provider.maxSurvey().get()).get();
        survey.setReport("UPDATE");
        assertEquals(provider.updateSurvey(survey), RequestStatus.SUCCESS);
    }
    
    /**
     * Failed Test of updateSurvey method, of class HibernateDataProvider.
     */
    @Test
    public void testUpdateSurveyFail() {
        generator.generateSurvey().stream().forEach(item -> provider.createSurvey(item));
        Survey survey = provider.getSurvey(provider.maxSurvey().get()).get();
        survey.setReport("UPDATE");
        assertEquals(provider.updateSurvey(survey), RequestStatus.SUCCESS);
    }
}
