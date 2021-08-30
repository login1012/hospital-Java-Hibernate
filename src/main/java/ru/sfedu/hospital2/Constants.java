/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.hospital2;

/**
 *
 * @author Liza
 */
public class Constants {
    public static final String SQL_ALL_SCHEMAS = "SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA";
    public static final String SQL_ALL_CATALOGS = "SELECT CATALOG_NAME FROM INFORMATION_SCHEMA.CATALOGS";
    public static final String SQL_ALL_USERS = "SELECT NAME FROM INFORMATION_SCHEMA.USERS ";
    public static final String SQL_HELP = "SELECT COUNT(TOPIC) FROM INFORMATION_SCHEMA.HELP";
    public static final String ID = "SELECT max(ID) as MAXID FROM TEST_ENTITY";
    public static final String CREDITACCOUNT_ID = "SELECT max(ID) as MAXID FROM CreditAccount";
    public static final String DEBITACCOUNT_ID = "SELECT max(ID) as MAXID FROM DebitAccount";
    public static final String CHECK_PATIENT="SELECT COUNT(id) FROM TEST_ENTITY WHERE id=%d";
    
    public static final String HIBERNATE_PATH = "config";
    public static final String DEFAULT_HIBERNATE_PATH = "./src/main/resources/hibernate.cfg.xml";

    public static final String CONFIG_PATH = "config";
    public static final String DEFAULT_CONFIG_PATH = "./src/main/resources/environment.properties";

    public static final String HIBERNATE_MAPPED_SOURCE_CLASS_PATH = "./src/main/resources/hibernate-mapSup.cfg.xml";
    public static final String HIBERNATE_TABLE_PER_CLASS_PATH = "./src/main/resources/hibernate-tablePerClass.cfg.xml";
    public static final String HIBERNATE_SINGLE_TABLE_PATH = "./src/main/resources/hibernate-single.cfg.xml";
    public static final String HIBERNATE_JOINED_TABLE_PATH = "./src/main/resources/hibernate-joined.cfg.xml";

    public static final String SQL_SELECT_CREDIT_ACCOUNT = "from CreditAccount";
    public static final String SQL_SELECT_DEBIT_ACCOUNT = "from DebitAccount";
    
    public static final String SQL_SELECT_TEST_ENTITY = "from TestEntity";
    public static final String SQL_SELECT_LAB4_ENTITY = "from FourthEntity";
    
    public static final String HQL_SELECT_EMPLOYEE = "from employee";
    public static final String HQL_SELECT_PATIENT = "from Patient";
    public static final String HQL_SELECT_APPOINTMENT = "from Appointment";
    public static final String HQL_SELECT_HOSPITAL = "from Hospital";
    
    public static final String NSQL_SELECT_EMPLOYEE = "SELECT * FROM EMPLOYEE WHERE ID = 1";
    public static final String NSQL_SELECT_PATIENT = "SELECT * FROM PATIENT";
    public static final String NSQL_SELECT_APPOINTMENT = "SELECT * FROM APPOINTMENT";
    public static final String NSQL_SELECT_HOSPITAL = "SELECT * FROM HOSPITAL";
    public static final String NSQL_SELECT_SERVICE = "SELECT * FROM SERVICE";
    public static final String NSQL_SELECT_DOCUMENT = "SELECT * FROM DOCUMENT";
    
    //Info 
    
     public static final String NAME = "Name";
     public static final long PHONE = 223322;
     public static final String PASSPORT = "07AB"; 
     public static final String ALLERGY = "Penicillin"; 
     public static final String SPECIALTY = "Anything";
     public static final String COMPETENCE = "Something";
     public static final int WARDS = 5; 
     public static final String SPECIALIZATION = "Heartache";
     public static final String TYPE = "Ultrasound"; 
     public static final String REPORT = "Health";
     public static final String DIAGNOSIS="Neurosis";
     public static final String MEDICINE="Sedatives";    
     public static final String MEDICAL_TESTS="";
     
    //Warnings
     
     public static final String PASSPORT_ERROR="This passport number already exists";
     public static final String ERROR="No such records";
     public static final String ALREADY="Already exists";
     
     //Joined Table
     
     public static final String PASSPORT_IDENT="SELECT COUNT(id) FROM joined_patient WHERE passport='%s'";
     public static final String EMPLOYEE_IDENT="SELECT COUNT(id) FROM joined_employee WHERE id=%d";
     public static final String PATIENT_IDENT="SELECT COUNT(id) FROM joined_patient WHERE id=%d";
     public static final String SERVICE_IDENT="SELECT COUNT(id) FROM joined_service WHERE id=%d";
     public static final String HOSPITAL_IDENT="SELECT COUNT(id) FROM joined_hospital WHERE id=%d";
     public static final String APPOINTMENT_IDENT="SELECT COUNT(id) FROM joined_appointment WHERE id=%d";
     public static final String SURVEY_IDENT="SELECT COUNT(id) FROM joined_survey WHERE id=%d";
     public static final String HOSPITALIZATION_IDENT="SELECT COUNT(id) FROM joined_hospitalization WHERE id=%d";
     public static final String MEDICALINSURANCE_IDENT="SELECT COUNT(id) FROM joined_medicalinsurance WHERE id=%d";
     public static final String PAYMENT_IDENT="SELECT COUNT(id) FROM joined_payment WHERE id=%d";
     public static final String DIAGNOSIS_IDENT="SELECT COUNT(id) FROM joined_diagnosis WHERE id=%d";
     
     public static final String EMPLOYEE = "Select id from joined_employee";
     public static final String PATIENT = "Select id from joined_patient";
     public static final String HOSPITAL = "Select id from joined_hospital";   
     public static final String APPOINTMENT = "Select id from joined_appointment";   
     public static final String DIAGNOSISGET = "Select id from joined_diagnosis";   
     public static final String SURVEY = "Select id from joined_survey";   
     
     public static final String MAX_EMPLOYEE = "SELECT max(ID) FROM joined_employee";
     public static final String MAX_APPOINTMENT = "SELECT max(ID) FROM joined_appointment";
     public static final String MAX_DIAGNOSIS = "SELECT max(ID) FROM joined_diagnosis";
     public static final String MAX_HOSPITAL = "SELECT max(ID) FROM joined_hospital";
     public static final String MAX_HOSPITALIZATION = "SELECT max(ID) FROM joined_hospitalization";
     public static final String MAX_MEDICALINSURANCE = "SELECT max(ID) FROM joined_medicalinsurance";
     public static final String MAX_PATIENT = "SELECT max(ID) FROM joined_patient";
     public static final String MAX_PAYMENT = "SELECT max(ID) FROM joined_payment";
     public static final String MAX_SURVEY = "SELECT max(ID) FROM joined_survey";
     
     //MappedSuperclass
     
     public static final String MAPPED_PASSPORT_IDENT="SELECT COUNT(id) FROM mapped_patient WHERE passport='%s'";
     public static final String MAPPED_EMPLOYEE_IDENT="SELECT COUNT(id) FROM mapped_employee WHERE id=%d";
     public static final String MAPPED_PATIENT_IDENT="SELECT COUNT(id) FROM mapped_patient WHERE id=%d";
     public static final String MAPPED_SERVICE_IDENT="SELECT COUNT(id) FROM mapped_appointment WHERE id=%d";
     public static final String MAPPED_HOSPITAL_IDENT="SELECT COUNT(id) FROM mapped_hospital WHERE id=%d";
     public static final String MAPPED_APPOINTMENT_IDENT="SELECT COUNT(id) FROM mapped_appointment WHERE id=%d";
     public static final String MAPPED_SURVEY_IDENT="SELECT COUNT(id) FROM mapped_survey WHERE id=%d";
     public static final String MAPPED_HOSPITALIZATION_IDENT="SELECT COUNT(id) FROM mapped_hospitalization WHERE id=%d";
     public static final String MAPPED_MEDICALINSURANCE_IDENT="SELECT COUNT(id) FROM mapped_medicalinsurance WHERE id=%d";
     public static final String MAPPED_PAYMENT_IDENT="SELECT COUNT(id) FROM mapped_payment WHERE id=%d";
     public static final String MAPPED_DIAGNOSIS_IDENT="SELECT COUNT(id) FROM mapped_diagnosis WHERE id=%d";
     
     public static final String MAPPED_EMPLOYEE = "Select id from mapped_employee";
     public static final String MAPPED_PATIENT = "Select id from mapped_patient";
     public static final String MAPPED_HOSPITAL = "Select id from mapped_hospital";   
     public static final String MAPPED_APPOINTMENT = "Select id from mapped_appointment";   
     public static final String MAPPED_DIAGNOSISGET = "Select id from mapped_diagnosis";   
     public static final String MAPPED_SURVEY = "Select id from mapped_survey"; 
     
     public static final String MAPPED_MAX_EMPLOYEE = "SELECT max(ID) FROM mapped_employee";
     public static final String MAPPED_MAX_APPOINTMENT = "SELECT max(ID) FROM mapped_appointment";
     public static final String MAPPED_MAX_DIAGNOSIS = "SELECT max(ID) FROM mapped_diagnosis";
     public static final String MAPPED_MAX_HOSPITAL = "SELECT max(ID) FROM mapped_hospital";
     public static final String MAPPED_MAX_HOSPITALIZATION = "SELECT max(ID) FROM mapped_hospitalization";
     public static final String MAPPED_MAX_MEDICALINSURANCE = "SELECT max(ID) FROM mapped_medicalinsurance";
     public static final String MAPPED_MAX_PATIENT = "SELECT max(ID) FROM mapped_patient";
     public static final String MAPPED_MAX_PAYMENT = "SELECT max(ID) FROM mapped_payment";
     public static final String MAPPED_MAX_SURVEY = "SELECT max(ID) FROM mapped_survey";
     
     
      //Single Table
     
     public static final String SINGLE_PASSPORT_IDENT="SELECT COUNT(id) FROM single_person WHERE passport='single_%s' and DTYPE='single_patient'";
     public static final String SINGLE_EMPLOYEE_IDENT="SELECT COUNT(id) FROM single_person WHERE id=%d and DTYPE='single_employee'";
     public static final String SINGLE_PATIENT_IDENT="SELECT COUNT(id) FROM single_person WHERE id=%d and DTYPE='single_patient'";
     public static final String SINGLE_SERVICE_IDENT="SELECT COUNT(id) FROM single_service WHERE id=%d and DTYPE='single_appointment'";
     public static final String SINGLE_HOSPITAL_IDENT="SELECT COUNT(id) FROM single_hospital WHERE id=%d";
     public static final String SINGLE_APPOINTMENT_IDENT="SELECT COUNT(id) FROM single_service WHERE id=%d and DTYPE='single_appointment'";
     public static final String SINGLE_SURVEY_IDENT="SELECT COUNT(id) FROM single_service WHERE id=%d and DTYPE='single_survey'";
     public static final String SINGLE_HOSPITALIZATION_IDENT="SELECT COUNT(id) FROM single_documents WHERE id=%d and DTYPE='single_hospitalization'";
     public static final String SINGLE_MEDICALINSURANCE_IDENT="SELECT COUNT(id) FROM single_documents WHERE id=%d and DTYPE='single_medicalinsurance'";
     public static final String SINGLE_PAYMENT_IDENT="SELECT COUNT(id) FROM single_documents WHERE id=%d and DTYPE='single_payment'";
     public static final String SINGLE_DIAGNOSIS_IDENT="SELECT COUNT(id) FROM single_documents WHERE id=%d and DTYPE='single_diagnosis'";
     
     public static final String SINGLE_EMPLOYEE = "Select id from single_person WHERE DTYPE='single_employee'";
     public static final String SINGLE_PATIENT = "Select id from single_person WHERE DTYPE='single_patient'";
     public static final String SINGLE_HOSPITAL = "Select id from single_hospital";   
     public static final String SINGLE_APPOINTMENT = "Select id from single_service WHERE DTYPE='single_appointment'";   
     public static final String SINGLE_DIAGNOSISGET = "Select id from single_documents WHERE DTYPE='single_diagnosis'";   
     public static final String SINGLE_SURVEY = "Select id from single_service WHERE DTYPE='single_survey'"; 
     
     public static final String SINGLE_MAX_EMPLOYEE = "SELECT max(ID) FROM single_person WHERE DTYPE='single_employee'";
     public static final String SINGLE_MAX_APPOINTMENT = "SELECT max(ID) FROM single_service WHERE DTYPE='single_appointment'";
     public static final String SINGLE_MAX_DIAGNOSIS = "SELECT max(ID) FROM single_documents WHERE DTYPE='single_diagnosis'";
     public static final String SINGLE_MAX_HOSPITAL = "SELECT max(ID) FROM single_hospital";
     public static final String SINGLE_MAX_HOSPITALIZATION = "SELECT max(ID) FROM single_documents WHERE DTYPE='single_hospitalization'";
     public static final String SINGLE_MAX_MEDICALINSURANCE = "SELECT max(ID) FROM single_documents WHERE DTYPE='single_medicalinsurance'";
     public static final String SINGLE_MAX_PATIENT = "SELECT max(ID) FROM single_person WHERE DTYPE='single_patient'";
     public static final String SINGLE_MAX_PAYMENT = "SELECT max(ID) FROM single_documents WHERE DTYPE='single_payment'";
     public static final String SINGLE_MAX_SURVEY = "SELECT max(ID) FROM single_service WHERE DTYPE='single_survey'";

     //Table Per Class
     
     public static final String TABLEPERCLASS_PASSPORT_IDENT="SELECT COUNT(id) FROM tableperclass_patient WHERE passport='%s'";
     public static final String TABLEPERCLASS_EMPLOYEE_IDENT="SELECT COUNT(id) FROM tableperclass_employee WHERE id=%d";
     public static final String TABLEPERCLASS_PATIENT_IDENT="SELECT COUNT(id) FROM tableperclass_patient WHERE id=%d";
     public static final String TABLEPERCLASS_SERVICE_IDENT="SELECT COUNT(id) FROM tableperclass_appointment WHERE id=%d";
     public static final String TABLEPERCLASS_HOSPITAL_IDENT="SELECT COUNT(id) FROM tableperclass_hospital WHERE id=%d";
     public static final String TABLEPERCLASS_APPOINTMENT_IDENT="SELECT COUNT(id) FROM tableperclass_appointment WHERE id=%d";
     public static final String TABLEPERCLASS_SURVEY_IDENT="SELECT COUNT(id) FROM tableperclass_survey WHERE id=%d";
     public static final String TABLEPERCLASS_HOSPITALIZATION_IDENT="SELECT COUNT(id) FROM tableperclass_hospitalization WHERE id=%d";
     public static final String TABLEPERCLASS_MEDICALINSURANCE_IDENT="SELECT COUNT(id) FROM tableperclass_medicalinsurance WHERE id=%d";
     public static final String TABLEPERCLASS_PAYMENT_IDENT="SELECT COUNT(id) FROM tableperclass_payment WHERE id=%d";
     public static final String TABLEPERCLASS_DIAGNOSIS_IDENT="SELECT COUNT(id) FROM tableperclass_diagnosis WHERE id=%d";
     
     public static final String TABLEPERCLASS_EMPLOYEE = "Select id from tableperclass_employee";
     public static final String TABLEPERCLASS_PATIENT = "Select id from tableperclass_patient";
     public static final String TABLEPERCLASS_HOSPITAL = "Select id from tableperclass_hospital";   
     public static final String TABLEPERCLASS_APPOINTMENT = "Select id from tableperclass_appointment";   
     public static final String TABLEPERCLASS_DIAGNOSISGET = "Select id from tableperclass_diagnosis";   
     public static final String TABLEPERCLASS_SURVEY = "Select id from tableperclass_survey"; 
     
     public static final String TABLEPERCLASS_MAX_EMPLOYEE = "SELECT max(ID) FROM tableperclass_employee";
     public static final String TABLEPERCLASS_MAX_APPOINTMENT = "SELECT max(ID) FROM tableperclass_appointment";
     public static final String TABLEPERCLASS_MAX_DIAGNOSIS = "SELECT max(ID) FROM tableperclass_diagnosis";
     public static final String TABLEPERCLASS_MAX_HOSPITAL = "SELECT max(ID) FROM tableperclass_hospital";
     public static final String TABLEPERCLASS_MAX_HOSPITALIZATION = "SELECT max(ID) FROM tableperclass_hospitalization";
     public static final String TABLEPERCLASS_MAX_MEDICALINSURANCE = "SELECT max(ID) FROM tableperclass_medicalinsurance";
     public static final String TABLEPERCLASS_MAX_PATIENT = "SELECT max(ID) FROM tableperclass_patient";
     public static final String TABLEPERCLASS_MAX_PAYMENT = "SELECT max(ID) FROM tableperclass_payment";
     public static final String TABLEPERCLASS_MAX_SURVEY = "SELECT max(ID) FROM tableperclass_survey";
     
     //Fourth lab
     public static final String SET_MAX_HOSPITAL = "SELECT max(ID) FROM fourth_hospital";
     public static final String SET_HOSPITALIZATION_IDENT="SELECT COUNT(id) FROM fourth_hospital WHERE id=%d";
     public static final String SET_HOSPITAL_IDENT="SELECT COUNT(id) FROM fourth_hospital WHERE id=%d";
     
     
     
}
