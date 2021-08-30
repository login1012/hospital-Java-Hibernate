/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.hospital2.lab2;

import java.util.Date;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.sfedu.hospital2.enums.RequestStatus;
import ru.sfedu.hospital2.lab2.model.Address;
import ru.sfedu.hospital2.lab2.model.TestEntity;

/**
 *
 * @author Liza
 */
public class TestEntityProviderTest {
        private static final Logger log = LogManager.getLogger(TestEntityProviderTest.class);
        private static final TestEntityProvider provider = new TestEntityProvider();
          
        /**
        * Successful test of insertTestEntity method, of class TestEntityProvider.
        */
        @Test
        public void insertTestEntitySuccess() {
            log.debug("insertTestEntitySuccess");
            Address address = new Address();
            address.setCity("Rostov");
            address.setDistrict("Zorge");
            address.setRegion("Rostovskaya");
            TestEntity testEntity = new TestEntity();
            testEntity.setName("Name");
            testEntity.setDescription("Description");
            testEntity.setAddress(address);
            log.info(testEntity.toString());
            assertEquals(provider.insert(testEntity), RequestStatus.SUCCESS);
        }
        
        /**
        * Failed test of insertTestEntity method, of class TestEntityProvider.
        */
        
        @Test
        public void insertTestEntityFailed() {
            log.debug("insertTestEntitySuccess");
            TestEntity testEntity = new TestEntity();
            assertEquals(provider.insert(testEntity), RequestStatus.FAIL);
         }
        
        /**
        * Successful test of updateTestEntity method, of class TestEntityProvider.
        */       
        @Test
        public void updateTestEntitySuccess() {
            log.debug("updateTestEntity");
            insertTestEntitySuccess();
            TestEntity entity = provider.get(provider.getMaxId().get()).get();
            log.debug(entity.toString());
            entity.setName("MyName");
            entity.setDescription("MyDescription");
             log.info(entity.toString());
            assertEquals(provider.update(entity), RequestStatus.SUCCESS);
        }
        
        /**
        * Failed test of updateTestEntity method, of class TestEntityProvider.
        */  
        @Test
        public void updateTestEntityFailed() {
            log.debug("updateTestEntity");
            insertTestEntitySuccess();
            TestEntity entity = provider.get(provider.getMaxId().get()).get();
            log.debug(entity);
            entity.setAddress(null);
            assertEquals(provider.update(entity), RequestStatus.FAIL);
        }
       
        /**
        * Successful test of getTestEntity method, of class TestEntityProvider.
        */
        @Test
        public void getTestEntitySuccess() {
            log.debug("getTestEntity");
            insertTestEntitySuccess();
            TestEntity testEntity = provider.get(provider.getMaxId().get()).get();
             log.info(testEntity.toString());
            assertEquals(testEntity.getId(), provider.getMaxId().get().intValue());
        }
        
        /**
        * Failed test of getTestEntity method, of class TestEntityProvider.
        */
        @Test
        public void getTestEntityFailed() {
            log.debug("getTestEntity");
            insertTestEntitySuccess();
            TestEntity testEntity = provider.get(provider.getMaxId().get()).get();
            assertNotEquals(testEntity.getId(), 0);
        }
        
        /**
        * Successful test of deleteTestEntity method, of class TestEntityProvider.
        */
        @Test
        public void deleteTestEntitySuccess() {
            log.debug("deleteTestEntity");
            insertTestEntitySuccess();
            long id = provider.get(provider.getMaxId().get()).get().getId();
            assertEquals(provider.delete(id), RequestStatus.SUCCESS);
        }
        
        /**
        * Failed test of deleteTestEntity method, of class TestEntityProvider.
        */
        @Test
        public void deleteTestEntityFailed() {
            log.debug("deleteTestEntity");
            long id = 0;
            assertEquals(provider.delete(id), RequestStatus.FAIL);
        }
        
        @Test
        public void getTestEntity() {
            insertTestEntitySuccess();
            Optional<TestEntity> testEntity = provider.get(Long.valueOf(1));
             log.info(testEntity.toString());
        }
        

}
