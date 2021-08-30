/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.hospital2.lab1;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Liza
 */
public interface IMetadataProvider {

    /**
     * View all schemas
     * @return List of string
     */    
    Optional<List<String>> getAllSchemas();
    
     /**
     * View all catalogs
     * @return String list
     */
    Optional<List<String>> getAllUsers();

    /**
     * View all users
     * @return Results list
     */
    Optional<List<String>> getAllCatalogs();

    /**
     * Get the number of help notes
     * @return Number of notes
     */
    Optional<BigInteger> getAmountOfHelp();
}
