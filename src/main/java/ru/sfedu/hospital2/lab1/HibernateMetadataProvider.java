/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.hospital2.lab1;


import java.math.BigInteger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import ru.sfedu.hospital2.Constants;

import java.util.List;
import java.util.Optional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

/**
 *
 * @author Liza
 */
public class HibernateMetadataProvider implements IMetadataProvider{
      private static Logger log = LogManager.getLogger(HibernateMetadataProvider.class);

     /**
     * View all schemas
     * @return String list
     */
      
    @Override
    public Optional<List<String>> getAllSchemas() {
        try{           
            Session session = getSession();
            session.beginTransaction();
            NativeQuery query = session.createNativeQuery(Constants.SQL_ALL_SCHEMAS);  
            log.info(Constants.SQL_ALL_SCHEMAS);
            List resultList = query.getResultList();
            session.getTransaction().commit();
            session.close();
            log.debug(String.format("Get list size: (%s)", resultList != null ? resultList.size() : null));
            return Optional.of(resultList);
        }catch(HibernateException e){
            log.error(e);
            return Optional.empty();
        }
        
    }
    
    /**
     * View all catalogs
     * @return String list
     */
    
    @Override
    public Optional<List<String>> getAllCatalogs() {
        try{
            Session session = getSession();
            session.beginTransaction();
            NativeQuery query = session.createNativeQuery(Constants.SQL_ALL_CATALOGS);
            log.info(Constants.SQL_ALL_CATALOGS);
            List resultList = query.getResultList();
            session.getTransaction().commit();
            session.close();
            log.info(String.format("Get amount of catalogs: (%s)", resultList != null ? resultList.size() : null));
            return Optional.of(resultList);
        }catch(HibernateException e){
            log.error(e);
            return Optional.empty();
        }
    }

    /**
     * View all users
     * @return String list
     */  
    @Override
    public Optional<List<String>> getAllUsers() {
        try{
            Session session = getSession();
            session.beginTransaction();
            NativeQuery query = session.createNativeQuery(Constants.SQL_ALL_USERS);
            log.info(Constants.SQL_ALL_USERS);
            List resultList = query.getResultList();
            session.getTransaction().commit();
            session.close();
            log.info(String.format("Get users: (%s)", resultList != null ? resultList.size() : null));
            return Optional.of(resultList);
        }catch(HibernateException e){
            log.error(e);
            return Optional.empty();
        }
    }

    /**
     * Get the number of help notes
     * @return Number of notes
     */
    @Override
    public Optional<BigInteger> getAmountOfHelp() {
        try{
            Session session = getSession();
            session.beginTransaction();      
            NativeQuery query = session.createNativeQuery(Constants.SQL_HELP);
             log.info(Constants.SQL_HELP);
            BigInteger result = (BigInteger) query.uniqueResult();
            session.getTransaction().commit();
            session.close();
            log.info(String.format("Get amount of help records: (%d)", result != null ? result : null));
            return Optional.of(result);
        }catch(HibernateException e){
            log.error(e);
            return Optional.empty();
        }
    }
    
     /**
     * Get session
     * @return Session
     */
    public Session getSession(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        return sessionFactory.openSession();
    }
      
}
