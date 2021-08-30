/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.hospital2.lab1;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Liza
 */
public class HibernateMetadataProviderTest {

    private static Logger log = LogManager.getLogger(HibernateMetadataProvider.class);
    
    /**
     * Successful test of getAllSchemas method, of class HibernateMetadataProvider.
     */
    @Test
    public void testGetAllSchemasSuccess() {
        HibernateMetadataProvider instance = new HibernateMetadataProvider();
        Optional<List<String>> expResult = null;
        Optional<List<String>> result = instance.getAllSchemas();
        result.stream().forEach((item) -> log.info(item));
        assertNotEquals(expResult, result);
    }

    /**
     * Failed test of getAllSchemas method, of class HibernateMetadataProvider.
     */
    @Test
    public void testGetAllSchemasFail() {
        HibernateMetadataProvider instance = new HibernateMetadataProvider();
        Optional<List<String>> expResult = null;
        Optional<List<String>> result = instance.getAllSchemas();
        result.stream().forEach((item) -> log.info(item));
        assertNotEquals(expResult, result);
    }
    
    /**
     * Successfull test of getAllCatalogs method, of class HibernateMetadataProvider.
     */
    @Test
    public void testGetAllCatalogsSuccess() {
        HibernateMetadataProvider instance = new HibernateMetadataProvider();
        Optional<List<String>> expResult = null;
        Optional<List<String>> result = instance.getAllCatalogs();
        result.stream().forEach((item) -> log.info(item));
        assertNotEquals(expResult, result);
    }

    /**
     * Failed test of getAllCatalogs method, of class HibernateMetadataProvider.
     */
    @Test
    public void testGetAllCatalogsFail() {
       HibernateMetadataProvider instance = new HibernateMetadataProvider();
        Optional<List<String>> expResult = null;
        Optional<List<String>> result = instance.getAllCatalogs();
        result.stream().forEach((item) -> log.info(item));
        assertNotEquals(expResult, result);
    }
    
    /**
     * Successfull test of getAllUsers method, of class HibernateMetadataProvider.
     */
    @Test
    public void testGetAllUsersSuccess() {
        HibernateMetadataProvider instance = new HibernateMetadataProvider();
        Optional<List<String>> expResult = null;
        Optional<List<String>> result = instance.getAllUsers();
        result.stream().forEach((item) -> log.info(item));
        assertNotEquals(expResult, result);
    }
    
    /**
     * Failed test of getAllUsers method, of class HibernateMetadataProvider.
     */
    @Test
    public void testGetAllUsersFail() {
        HibernateMetadataProvider instance = new HibernateMetadataProvider();
        Optional<List<String>> expResult = null;
        Optional<List<String>> result = instance.getAllUsers();
        result.stream().forEach((item) -> log.info(item));
        assertNotEquals(expResult, result);
    }

    /**
     * Successfull test of getAmountOfHelp method, of class HibernateMetadataProvider.
     */
    @Test
    public void testGetAmountOfHelpSuccess() {
        HibernateMetadataProvider instance = new HibernateMetadataProvider();
        Optional<BigInteger> expResult = null;
        Optional<BigInteger> result = instance.getAmountOfHelp();
        log.info(result.get());
        assertNotEquals(expResult, result);
    }
    
    /**
     * Failed test of getAmountOfHelp method, of class HibernateMetadataProvider.
     */
    @Test
    public void testGetAmountOfHelpFail() {
        HibernateMetadataProvider instance = new HibernateMetadataProvider();
        Optional<BigInteger> expResult = null;
        Optional<BigInteger> result = instance.getAmountOfHelp();
        log.info(result.get());
        assertNotEquals(expResult, result);
    }
    
}
