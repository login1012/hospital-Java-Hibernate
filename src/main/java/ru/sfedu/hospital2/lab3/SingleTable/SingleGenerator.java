/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.hospital2.lab3.SingleTable;

import ru.sfedu.hospital2.lab3.SingleTable.*;
import ru.sfedu.hospital2.lab3.SingleTable.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Calendar.HOUR;
import static java.util.Calendar.MINUTE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
import java.util.List;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import ru.sfedu.hospital2.lab3.SingleTable.model.Appointment;
import ru.sfedu.hospital2.lab3.SingleTable.model.Patient;
import ru.sfedu.hospital2.Constants;
import ru.sfedu.hospital2.enums.HospitalizationStatus;
import ru.sfedu.hospital2.enums.ServiceStatus;
import ru.sfedu.hospital2.lab1.HibernateUtil;
import ru.sfedu.hospital2.lab3.SingleTable.HibernateDataProvider;
import ru.sfedu.hospital2.lab3.SingleTable.model.Diagnosis;
import ru.sfedu.hospital2.lab3.SingleTable.model.Employee;
import ru.sfedu.hospital2.lab3.SingleTable.model.Hospital;
import ru.sfedu.hospital2.lab3.SingleTable.model.Hospitalization;
import ru.sfedu.hospital2.lab3.SingleTable.model.MedicalInsurance;
import ru.sfedu.hospital2.lab3.SingleTable.model.Payment;
import ru.sfedu.hospital2.lab3.SingleTable.model.Survey;

/**
 *
 * @author Liza
 */
public class SingleGenerator {
    private static final Logger log = LogManager.getLogger(SingleGenerator.class);
    private static HibernateDataProvider provider = new HibernateDataProvider();
    
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
        }
        return employeeList;
    }
    
     public  List<Appointment> generateAppointment() {
         generateEmployee().stream().forEach(item -> provider.createEmployee(item));
         generatePatient().stream().forEach(item -> provider.createPatient(item));
        List<Appointment> appointmentList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            Appointment appointment = new Appointment();
                Calendar calendar = Calendar.getInstance();
                calendar.set(HOUR, 11);
                calendar.set(MINUTE, 00);
                Session employeeSession = provider.getSession();
                employeeSession.beginTransaction();
                NativeQuery employeeQuery = employeeSession.createNativeQuery(Constants.SINGLE_EMPLOYEE);
                List<BigInteger> employee = employeeQuery.getResultList();
                log.debug(employee.toString());
                appointment.setDoctorId(employee.get((int) ((Math.random() * (((employee.size()-1)-1) + 1)) + 1)).longValue());
                Session patientSession = provider.getSession();
                patientSession.beginTransaction();
                NativeQuery patientQuery = patientSession.createNativeQuery(Constants.SINGLE_PATIENT);
                List<BigInteger> patient = patientQuery.getResultList();
                log.debug(patient.toString());
                appointment.setPatientId(patient.get((int) ((Math.random() * (((patient.size()-1)-1) + 1)) + 1)).longValue());
                appointment.setDay(calendar.get(DAY_OF_MONTH));        
                appointment.setMonth(calendar.get(MONTH));        
                appointment.setYear(calendar.get(YEAR));    
                appointment.setHour(calendar.get(HOUR));    
                appointment.setMinute(calendar.get(MINUTE));    
                appointment.setStatus(ServiceStatus.APPOINTED);
                appointment.setSpecialization(Constants.SPECIALIZATION);
                appointmentList.add(appointment);
        }
        return appointmentList;
    }
    
      public  List<Survey> generateSurvey() {
           generateEmployee().stream().forEach(item -> provider.createEmployee(item));
         generatePatient().stream().forEach(item -> provider.createPatient(item));
        List<Survey> surveyList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            Survey survey = new Survey();
                Calendar calendar = Calendar.getInstance();
                Session employeeSession = provider.getSession();
                employeeSession.beginTransaction();
                NativeQuery employeeQuery = employeeSession.createNativeQuery(Constants.SINGLE_EMPLOYEE);
                List<BigInteger>employee = employeeQuery.getResultList();
                survey.setDoctorId(employee.get((int) ((Math.random()*(((employee.size()-1)-1)+1))+ 1)).longValue());;
                Session patientSession = provider.getSession();
                patientSession.beginTransaction();
                NativeQuery patientQuery = patientSession.createNativeQuery(Constants.SINGLE_PATIENT);
                List<BigInteger>patient = patientQuery.getResultList();
                survey.setPatientId(patient.get((int) ((Math.random()*(((patient.size()-1)-1)+1))+ 1)).longValue());;
                calendar.set(HOUR, 11);
                calendar.set(MINUTE, 00);
                survey.setDay(calendar.get(DAY_OF_MONTH));        
                survey.setMonth(calendar.get(MONTH));        
                survey.setYear(calendar.get(YEAR));    
                survey.setHour(calendar.get(HOUR));    
                survey.setMinute(calendar.get(MINUTE));    
                survey.setStatus(ServiceStatus.MEDICALTEST);
                survey.setType(Constants.TYPE);
                survey.setReport(Constants.REPORT);
            surveyList.add(survey);
        }
        return surveyList;
    }
      
     public  List<Diagnosis> generateDiagnosis() {
          generateSurvey().stream().forEach(item -> provider.createSurvey(item));
        List<Diagnosis> diagnosisList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            Diagnosis diagnosis = new Diagnosis();
            diagnosis.setSignature(false);            
                Session serviceSession = provider.getSession();
                serviceSession.beginTransaction();
                NativeQuery serviceQuery = serviceSession.createNativeQuery(Constants.SINGLE_SURVEY);
                List<BigInteger>service = serviceQuery.getResultList();
                diagnosis.setServiceId(service.get((int) ((Math.random()*(((service.size()-1)-1)+1))+ 1)).longValue());;
                /*Session patientSession = provider.getSession();
                patientSession.beginTransaction();
                NativeQuery patientQuery = patientSession.createNativeQuery(Constants.PATIENT);
                List<BigInteger>patient = patientQuery.getResultList();
                diagnosis.setPatientId(patient.get((int) ((Math.random()*(((patient.size()-1)-1)+1))+ 1)).longValue());;*/
                diagnosis.setDiagnosis(Constants.DIAGNOSIS);
                diagnosis.setMedicine(Constants.MEDICINE);
                diagnosis.setMedicalTests(Constants.MEDICAL_TESTS);           
                /*Session appSession = provider.getSession();
                appSession.beginTransaction();
                NativeQuery appQuery = appSession.createNativeQuery(Constants.SURVEY);
                List<BigInteger>appointment = appQuery.getResultList();
                Long appointmentId=(appointment.get((int) ((Math.random()*(((appointment.size()-1)-1)+1))+ 1)).longValue());*/
                    diagnosis.setYear(provider.getSurvey(diagnosis.getServiceId()).get().getYear());
                    diagnosis.setMonth(provider.getSurvey(diagnosis.getServiceId()).get().getMonth());
                    diagnosis.setDay(provider.getSurvey(diagnosis.getServiceId()).get().getDay());
                    diagnosis.setHour(provider.getSurvey(diagnosis.getServiceId()).get().getHour());
                    diagnosis.setMinute(provider.getSurvey(diagnosis.getServiceId()).get().getMinute());
                    diagnosis.setPatientId(provider.getSurvey(diagnosis.getServiceId()).get().getPatientId());
                diagnosisList.add(diagnosis);
        }
        return diagnosisList;
    } 
     
     public  List<Hospitalization> generateHospitalization() {
           generateHospital().stream().forEach(item -> provider.createHospital(item));
          generateAppointment().stream().forEach(item -> provider.createAppointment(item));
        List<Hospitalization> hospitalizationList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            Hospitalization hospitalization = new Hospitalization();
            Session serviceSession = provider.getSession();
                serviceSession.beginTransaction();
                NativeQuery serviceQuery = serviceSession.createNativeQuery(Constants.SINGLE_APPOINTMENT);
                List<BigInteger>service = serviceQuery.getResultList();
                hospitalization.setServiceId(service.get((int) ((Math.random()*(((service.size()-1)-1)+1))+ 1)).longValue());;
                hospitalization.setSignature(false);
                Session hospitalSession = provider.getSession();
                hospitalSession.beginTransaction();
                NativeQuery hospitalQuery = hospitalSession.createNativeQuery(Constants.SINGLE_HOSPITAL);
                List<BigInteger>hospital = hospitalQuery.getResultList();
                hospitalization.setHospitalId(hospital.get((int) ((Math.random()*(((hospital.size()-1)-1)+1))+ 1)).longValue());
                hospitalization.setWard(1);
                /*Session diagnosisSession = provider.getSession();
                diagnosisSession.beginTransaction();
                NativeQuery diagnosisQuery = diagnosisSession.createNativeQuery(Constants.APPOINTMENT);
                List<BigInteger>diagnosis = diagnosisQuery.getResultList();
                Long diagnosisId=(diagnosis.get((int) ((Math.random()*(((diagnosis.size()-1)-1)+1))+ 1)).longValue());*/
                hospitalization.setStatus(HospitalizationStatus.HOSPITALIZED);
                hospitalization.setYear(provider.getAppointment(hospitalization.getServiceId()).get().getYear());
                hospitalization.setMonth(provider.getAppointment(hospitalization.getServiceId()).get().getMonth());
                hospitalization.setDay(provider.getAppointment(hospitalization.getServiceId()).get().getDay());
                hospitalization.setHour(provider.getAppointment(hospitalization.getServiceId()).get().getHour());
                hospitalization.setMinute(provider.getAppointment(hospitalization.getServiceId()).get().getMinute());
            hospitalizationList.add(hospitalization);
        }
        return hospitalizationList;
    } 
     
      public  List<Hospital> generateHospital() {
        List<Hospital> hospitalList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Hospital hospital = new Hospital();
                hospital.setName(Constants.NAME);
                hospital.setWardsNumber(Constants.WARDS);
            hospitalList.add(hospital);
        }
        return hospitalList;
    } 
      
       public  List<Payment> generatePayment() {
             generateAppointment().stream().forEach(item -> provider.createAppointment(item));      
        List<Payment> paymentList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            Payment payment = new Payment();
                Session serviceSession = provider.getSession();
                serviceSession.beginTransaction();
                NativeQuery serviceQuery = serviceSession.createNativeQuery(Constants.SINGLE_APPOINTMENT);
                List<BigInteger>service = serviceQuery.getResultList();
                payment.setServiceId(service.get((int) ((Math.random()*(((service.size()-1)-1)+1))+ 1)).longValue());;
                payment.setSignature(false); 
                payment.setNumber(456);
                payment.setPrice(15);
                payment.setYear(provider.getAppointment(payment.getServiceId()).get().getYear());
                payment.setMonth(provider.getAppointment(payment.getServiceId()).get().getMonth());
                payment.setDay(provider.getAppointment(payment.getServiceId()).get().getDay());
                payment.setHour(provider.getAppointment(payment.getServiceId()).get().getHour());
                payment.setMinute(provider.getAppointment(payment.getServiceId()).get().getMinute());
            paymentList.add(payment);
        }
        return paymentList;
    } 
       
       public  List<MedicalInsurance> generateMedicalInsurance() {
             generateAppointment().stream().forEach(item -> provider.createAppointment(item));      
        List<MedicalInsurance> medicalInsuranceList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            MedicalInsurance medicalInsurance = new MedicalInsurance();
            Session serviceSession = provider.getSession();
                serviceSession.beginTransaction();
                NativeQuery serviceQuery = serviceSession.createNativeQuery(Constants.SINGLE_APPOINTMENT);
                List<BigInteger>service = serviceQuery.getResultList();
                medicalInsurance.setServiceId(service.get((int) ((Math.random()*(((service.size()-1)-1)+1))+ 1)).longValue());; 
                medicalInsurance.setSignature(false); 
                medicalInsurance.setNumber(456);
                medicalInsurance.setReimbursement(15);
                medicalInsurance.setYear(provider.getAppointment(medicalInsurance.getServiceId()).get().getYear());
                medicalInsurance.setMonth(provider.getAppointment(medicalInsurance.getServiceId()).get().getMonth());
                medicalInsurance.setDay(provider.getAppointment(medicalInsurance.getServiceId()).get().getDay());
                medicalInsurance.setHour(provider.getAppointment(medicalInsurance.getServiceId()).get().getHour());
                medicalInsurance.setMinute(provider.getAppointment(medicalInsurance.getServiceId()).get().getMinute());
            medicalInsuranceList.add(medicalInsurance);
        }
        return medicalInsuranceList;
    } 
       
}
