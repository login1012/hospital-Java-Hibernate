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
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Calendar.HOUR;
import static java.util.Calendar.MINUTE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import ru.sfedu.hospital2.Constants;
import ru.sfedu.hospital2.enums.DiagnosisType;
import ru.sfedu.hospital2.enums.HospitalizationStatus;
import ru.sfedu.hospital2.enums.MedicalTests;
import ru.sfedu.hospital2.enums.ServiceStatus;

/**
 *
 * @author Liza
 */
public class Generator {
    private static final Logger log = LogManager.getLogger(Generator.class);
    private static DataProvider provider = new DataProvider();
    
    private Session getSession() {
       return ru.sfedu.hospital2.utils.HibernateUtil.getSessionFactory().openSession();
     }
    
    public  List<Patient> generatePatient() {
        List<Patient> patientList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            Patient patient = new Patient();
            patient.setName(Constants.NAME);
            patient.setPhone(random.nextLong());
            patient.setPassport(Constants.PASSPORT+i);
            patient.setAllergy(Constants.ALLERGY);
            patientList.add(patient);
            log.debug(patient.toString());
        }
        return patientList;
    }
    
    public  List<Employee> generateEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            Employee employee = new Employee();
                employee.setName(Constants.NAME);
                employee.setPhone(random.nextLong());
                employee.setSpecialty(Constants.SPECIALTY);
                employee.setCompetence(Constants.COMPETENCE);
            employeeList.add(employee);
            log.debug(employee.toString());
        }
        return employeeList;
    }
    
     public  List<Appointment> generateAppointment() {
        List<Appointment> appointmentList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            Appointment appointment = new Appointment();
                Calendar calendar = Calendar.getInstance();
                Employee employee = generateEmployee().get(0);
                provider.insertEmployee(employee);
                log.debug(employee.toString());            
                appointment.setDoctor(employee);
                Patient patient = generatePatient().get(0);
                provider.insertPatient(patient);
                log.debug(patient.toString());
                appointment.setPatient(patient);
                appointment.setDay(calendar.get(DAY_OF_MONTH));        
                appointment.setMonth(calendar.get(MONTH));        
                appointment.setYear(calendar.get(YEAR));    
                appointment.setHour(calendar.get(HOUR));
                appointment.setMinute(calendar.get(MINUTE));    
                appointment.setStatus(ServiceStatus.APPOINTED);
                appointment.setSpecialization(Constants.SPECIALIZATION);
                log.debug(appointment.toString());
                appointmentList.add(appointment);
        }
        return appointmentList;
    }
    
      public  List<Survey> generateSurvey() {
        List<Survey> surveyList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            Survey survey = new Survey();               
                Employee employee = generateEmployee().get(0);
                provider.insertEmployee(employee);
                log.debug(employee.toString());            
                survey.setDoctor(employee);
                Patient patient = generatePatient().get(0);
                provider.insertPatient(patient);
                log.debug(patient.toString());
                survey.setPatient(patient);
                Calendar calendar = Calendar.getInstance();
                survey.setDay(calendar.get(DAY_OF_MONTH));        
                survey.setMonth(calendar.get(MONTH));        
                survey.setYear(calendar.get(YEAR));    
                survey.setHour(calendar.get(HOUR));    
                survey.setMinute(calendar.get(MINUTE));    
                survey.setStatus(ServiceStatus.MEDICALTEST);
                survey.setType(Constants.TYPE);
                survey.setReport(Constants.REPORT);
                log.debug(survey.toString());
            surveyList.add(survey);
        }
        return surveyList;
    }            
      
      public  List<Diagnosis> generateDiagnosis() {
        Appointment appointment = generateAppointment().get(0);
        provider.insertAppointment(appointment);
        log.debug(appointment.toString());            
        List<Diagnosis> diagnosisList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            Diagnosis diagnosis = new Diagnosis();
                diagnosis.setSignature(false);                
                diagnosis.setAppointment(appointment);               
                diagnosis.setMedicine(Constants.MEDICINE);
                diagnosis.setMedicalTests(Constants.MEDICAL_TESTS);           
                 Calendar calendar = Calendar.getInstance();
                diagnosis.setDay(calendar.get(DAY_OF_MONTH));        
                diagnosis.setMonth(calendar.get(MONTH));        
                diagnosis.setYear(calendar.get(YEAR));    
                diagnosis.setHour(calendar.get(HOUR));    
                diagnosis.setMinute(calendar.get(MINUTE));
                diagnosis.setDiagnosis(Constants.DIAGNOSIS);
                diagnosisList.add(diagnosis);
        }
        return diagnosisList;
    } 
      
      public  List<Payment> generatePayment() {
        List<Payment> paymentList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            Payment payment = new Payment(); 
             Appointment appointment = generateAppointment().get(0);
             provider.insertAppointment(appointment);
             log.debug(appointment.toString());            
                payment.setAppointment(appointment);
                payment.setSignature(false); 
                payment.setNumber(456);
                payment.setPrice(15);
                Calendar calendar = Calendar.getInstance();
                payment.setDay(calendar.get(DAY_OF_MONTH));        
                payment.setMonth(calendar.get(MONTH));        
                payment.setYear(calendar.get(YEAR));    
                payment.setHour(calendar.get(HOUR));    
                payment.setMinute(calendar.get(MINUTE));
            paymentList.add(payment);
        }
        return paymentList;
    } 
       public  List<MedicalInsurance> generateMedicalInsurance() {
        List<MedicalInsurance> medicalInsuranceList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            MedicalInsurance medicalInsurance = new MedicalInsurance(); 
             Appointment appointment = generateAppointment().get(0);
             provider.insertAppointment(appointment);
             log.debug(appointment.toString());            
                medicalInsurance.setAppointment(appointment);
                medicalInsurance.setSignature(false); 
                medicalInsurance.setNumber(456);
                medicalInsurance.setReimbursement(15);
                Calendar calendar = Calendar.getInstance();
                medicalInsurance.setDay(calendar.get(DAY_OF_MONTH));        
                medicalInsurance.setMonth(calendar.get(MONTH));        
                medicalInsurance.setYear(calendar.get(YEAR));    
                medicalInsurance.setHour(calendar.get(HOUR));    
                medicalInsurance.setMinute(calendar.get(MINUTE));
            medicalInsuranceList.add(medicalInsurance);
        }
        return medicalInsuranceList;
    } 
        public  List<Hospitalization> generateHospitalization() {
        List<Hospital> hospitalList = generateHospital();
        hospitalList.stream().forEach(item -> provider.insertHospital(item));      
        log.debug(hospitalList.toString());          
        List<Hospitalization> hospitalizationList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < hospitalList.size(); i++) {
            Appointment appointment = generateAppointment().get(0);
             provider.insertAppointment(appointment);
             log.debug(appointment.toString());            
            Hospitalization hospitalization = new Hospitalization();
                hospitalization.setAppointment(appointment);
                hospitalization.setHospital(hospitalList);
                hospitalization.setSignature(false);
                hospitalization.setWard(1);
                hospitalization.setId(appointment.getId());
                hospitalization.setStatus(HospitalizationStatus.HOSPITALIZED);
                 Calendar calendar = Calendar.getInstance();
                hospitalization.setDay(appointment.getDay());        
                hospitalization.setMonth(appointment.getYear());        
                hospitalization.setYear(appointment.getYear());    
                hospitalization.setHour(appointment.getHour());    
                hospitalization.setMinute(appointment.getMinute());
            hospitalizationList.add(hospitalization);
            log.debug(hospitalization.toString());
        }
        log.debug(hospitalizationList.toString());
        return hospitalizationList;
    } 
     
      public  List<Hospital> generateHospital() {                 
        List<Hospital> hospitalList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Hospital hospital = new Hospital();
            hospital.setName(Constants.NAME);
            hospital.setWardsNumber(Constants.WARDS);
            hospitalList.add(hospital);
            log.debug(hospital.toString());
        }
        return hospitalList;
    } 
}
