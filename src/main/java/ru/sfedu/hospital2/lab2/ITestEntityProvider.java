/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.hospital2.lab2;

import java.util.Optional;
import ru.sfedu.hospital2.enums.RequestStatus;
import ru.sfedu.hospital2.lab2.model.TestEntity;

/**
 *
 * @author Liza
 */
public interface ITestEntityProvider {
    
     /**
     * Get method
     * @param id
     * @return Optional TestEntity
     */   
    Optional<TestEntity> get (long id);
    
     /**
     * Insert method
     * @param entity
     * @return RequestStatus
     */ 
    RequestStatus insert(TestEntity entity);
    
     /**
     * Delete method
     * @param id
     * @return RequestStatus
     */ 
    RequestStatus delete(long id);
    
     /**
     * Update method
     * @param entity
     * @return RequestStatus
     */ 
    RequestStatus update(TestEntity entity);
   
}
