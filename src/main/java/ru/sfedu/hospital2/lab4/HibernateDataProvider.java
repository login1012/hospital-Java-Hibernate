/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.hospital2.lab4;


import ru.sfedu.hospital2.lab4.DataProvider;
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
import ru.sfedu.hospital2.lab4.model.*;


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
     * @return Optional Hospitalization
     */   
    @Override
    public Optional<Hospitalization> getHospitalization (long id) {
        try{
            Session identSession = getSession();
            identSession.beginTransaction();
            NativeQuery query = identSession.createNativeQuery(String.format(Constants.SET_HOSPITALIZATION_IDENT, id));
            log.debug(String.format(Constants.SET_HOSPITALIZATION_IDENT, id));
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
            /*NativeQuery service = session.createNativeQuery(String.format(Constants.SERVICE_IDENT, hospitalization.getServiceId()));          
            NativeQuery hospital = session.createNativeQuery(String.format(Constants.SET_HOSPITAL_IDENT, hospitalization.getHospitalId()));          
            log.info(Constants.SERVICE_IDENT, Constants.SET_HOSPITAL_IDENT);
            BigInteger serviceResult = (BigInteger) service.uniqueResult();
            BigInteger hospitalResult = (BigInteger) hospital.uniqueResult();
            if (serviceResult.compareTo(BigInteger.ZERO)==0||hospitalResult.compareTo(BigInteger.ZERO)==0){
                log.error(Constants.ERROR);
                return RequestStatus.FAIL;
            }*/
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
     * @return Optional Hospital
     */   
    @Override
    public Optional<Hospital> getHospital (long id) {
        try{
             Session identSession = getSession();
            identSession.beginTransaction();
            NativeQuery query = identSession.createNativeQuery(String.format(Constants.SET_HOSPITAL_IDENT, id));
            log.debug(String.format(Constants.SET_HOSPITAL_IDENT, id));
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
    

    public Optional<Integer> maxHospital() {
        try{
            Session session = getSession();
            session.beginTransaction();
            NativeQuery query = session.createNativeQuery(Constants.SET_MAX_HOSPITAL);
            log.debug(Constants.SET_MAX_HOSPITAL);
            BigInteger id = (BigInteger) query.uniqueResult();
            //Long id = (Long) query.uniqueResult();
            int max;
            if (id != null){
                max = id.intValue() + 1;
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
            NativeQuery query = session.createNativeQuery(Constants.MAX_HOSPITALIZATION);
            log.debug(Constants.MAX_HOSPITALIZATION);
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