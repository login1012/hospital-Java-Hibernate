/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.hospital2.lab2;

import java.math.BigInteger;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import ru.sfedu.hospital2.Constants;
import ru.sfedu.hospital2.enums.RequestStatus;
import ru.sfedu.hospital2.lab2.model.TestEntity;
import ru.sfedu.hospital2.utils.HibernateUtil;

/**
 *
 * @author Liza
 */
public class TestEntityProvider implements ITestEntityProvider{
    
    private static Logger log = LogManager.getLogger(TestEntityProvider.class);
    
    
     /**
     * Get method
     * @param id
     * @return Optional TestEntity
     */   
    @Override
    public Optional<TestEntity> get(long id) {
        try{                    
            Session check = getSession();
            check.beginTransaction();
            NativeQuery query = check.createNativeQuery(String.format(Constants.CHECK_PATIENT, id));
            log.debug(String.format(Constants.CHECK_PATIENT, id));
            BigInteger result = (BigInteger) query.uniqueResult();
            check.close();
            if (result.compareTo(BigInteger.ZERO)==0){
                log.error(Constants.ERROR);
                return Optional.empty();
            }     
            Session session = getSession();
            session.beginTransaction();
            TestEntity testEntity = session.get(TestEntity.class, id);
            log.debug(id);
            session.getTransaction().commit(); 
            return Optional.of(testEntity);
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
        public  RequestStatus insert(TestEntity entity) {       
        try {
            Session session = getSession();
            session.beginTransaction();
            session.save(entity);
            log.debug(entity.toString());
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
     public RequestStatus delete(long id) {
         try{
            Session session = getSession();
            session.beginTransaction();
            Optional<TestEntity> entity = get(id);
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
    public RequestStatus update(TestEntity entity) {
    try {
        Session session = getSession();
        session.beginTransaction();
        if (get(entity.getId()).isPresent()) {
                session.update(entity);
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
     * Get max ID method
     * @return RequestStatus
     */ 
    public Optional<Integer> getMaxId() {
        try{
            Session session = getSession();
            session.beginTransaction();
            NativeQuery query = session.createNativeQuery(Constants.ID);
            log.debug(Constants.ID);
            BigInteger id = (BigInteger) query.uniqueResult();
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
    
    /**
     * Get session
     * @return Session
     */
    private Session getSession(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        return sessionFactory.openSession();
    }
}
