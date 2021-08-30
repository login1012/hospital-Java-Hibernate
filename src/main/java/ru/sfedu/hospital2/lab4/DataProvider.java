/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the updateor.
 */
package ru.sfedu.hospital2.lab4;

import ru.sfedu.hospital2.lab4.model.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import ru.sfedu.hospital2.enums.HospitalizationStatus;
import ru.sfedu.hospital2.enums.RequestStatus;
import ru.sfedu.hospital2.enums.ServiceStatus;
import ru.sfedu.hospital2.enums.TypeOfPayment;

/**
 * Interface implemented by DataProviders
 * @author Liza
 */
public interface DataProvider {
   
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
