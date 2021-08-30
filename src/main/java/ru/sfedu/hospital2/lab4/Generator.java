/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.hospital2.lab4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.HOUR;
import static java.util.Calendar.MINUTE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.hospital2.Constants;
import ru.sfedu.hospital2.enums.HospitalizationStatus;
import ru.sfedu.hospital2.enums.RequestStatus;
import ru.sfedu.hospital2.lab4.HibernateDataProvider;
import ru.sfedu.hospital2.lab4.model.*;

/**
 *
 * @author Liza
 */
public class Generator {
    private static final Logger log = LogManager.getLogger(Generator.class);
    private static final HibernateDataProvider provider = new HibernateDataProvider();

    /**
     * Generate list of hospitalizations
     */
    
    public  List<String> generateHospitalizations() {
        List<String> hospitalizationList = new ArrayList<>();
        Random random = new Random();
        Calendar calendar = Calendar.getInstance();
        int randInt = (int) ( 1 + Math.random() * 6);
        for (int i = 0; i < randInt; i++) {
            Hospitalization hospitalization = new Hospitalization();
            hospitalization.setServiceId((int) ( Math.random() * 11 ));
            hospitalization.setSignature(random.nextBoolean());
            hospitalization.setWard((int) ( 1 + Math.random() * 2));
            hospitalization.setStatus(HospitalizationStatus.HOSPITALIZED);
            hospitalization.setYear(calendar.get(YEAR));
            hospitalization.setMonth(calendar.get(MONTH));
            hospitalization.setDay(calendar.get(DAY_OF_MONTH));
            hospitalization.setHour(HOUR);
            hospitalization.setMinute(MINUTE);
            hospitalization.setHospitalId(provider.maxHospital().get());
            hospitalizationList.add(hospitalization.toString());
        }
        return hospitalizationList;
    } 
    
    /**
     * Generate one hospitalization
     */
    public String generateOneHospitalization(long id) {
            Random random = new Random();
            Calendar calendar = Calendar.getInstance();
            Hospitalization hospitalization = new Hospitalization();
            hospitalization.setServiceId((int) ( Math.random() * 11 ));
            hospitalization.setSignature(random.nextBoolean());
            hospitalization.setWard((int) ( 4 + Math.random() * 6));
            hospitalization.setHospitalId(id);
            hospitalization.setStatus(HospitalizationStatus.HOSPITALIZED);
            hospitalization.setYear(calendar.get(YEAR));
            hospitalization.setMonth(calendar.get(MONTH));
            hospitalization.setDay(calendar.get(DAY_OF_MONTH));
            hospitalization.setHour(HOUR);
            hospitalization.setMinute(MINUTE);
            log.debug("GenerateOneHospitalization "+ hospitalization.toString());
            return hospitalization.toString();
    }    
    
    /**
     * Generate and create hospital
     */
    public void generateHospital() {
        Random random = new Random();
        int randInt = (int) ( 2 + Math.random() * 4);
        List<Hospital> hospitalList = new ArrayList<>();
        for (int i = 0; i < randInt; i++) {
            Hospital hospital = new Hospital();
            hospital.setName(Constants.NAME);
            hospital.setWardsNumber(3);
            ////set.stream().forEach(item -> item.setHospitalId(hospital.getId()));
            hospital.setSet(generateSet());
            hospital.setList(generateHospitalizations());
            hospital.setMap(generateMap());
            hospital.setHospitalization(generateHospitalizationsComp());
            hospital.setHospitalMap(generateMapComp());
            hospitalList.add(hospital);
            provider.createHospital(hospital);
            log.debug(hospital.toString());
        }
        ////hospitalList.stream().forEach(item -> provider.createHospital(item)); 
    }         
        
    /**
     * Generate set from list
     */
    public  Set<String> generateSet() {
        List<String> hospitalizationList = generateHospitalizations();
        Set<String> hospitalizationSet = new HashSet<>(hospitalizationList);        
        return hospitalizationSet;
    } 
    
    /**
     * Insert one hospitalization element into a set.
     */
    
    public RequestStatus insertSet(){
        Hospital hospital = provider.getHospital(1).get(); 
        log.debug("INSERT SET" + hospital.toString());
        log.debug("INSERT SET" + hospital.getSet().toString());
        hospital.getSet().add(generateOneHospitalization(hospital.getId()));
        log.debug("INSERT SET" + hospital.toString());
        log.debug("INSERT SET" + hospital.getSet().toString());
        return RequestStatus.SUCCESS;
    }
    
    /**
     * Update set case
     */
    
    public void updateSet(){
        Hospital hospital = provider.getHospital(1).get(); 
        log.debug("UPDATE SET" + hospital.getSet());
        Set<String> set = hospital.getSet();
        String[] array = new String[set.size()];
        set.toArray(array);       
        array[0].toUpperCase();
        Set<String> set2 = new HashSet<>(Arrays.asList(array));       
        hospital.setSet(set2);
        //hospital.getSet().stream().forEach((item) -> item.toUpperCase());        
        log.debug("UPDATE SET" + hospital.getSet());
    }
    
    /**
     * Delete all elements of set
     */
    
    public void deleteSet(){
        Hospital hospital = provider.getHospital(1).get(); 
        log.debug("DELETE SET" + hospital.toString());
        log.debug("DELETE SET" + hospital.getSet().toString());
        Set<String> set = new HashSet<String>();  
        hospital.setSet(set);
        log.debug("DELETE SET" + hospital.toString());
        log.debug("DELETE SET" + hospital.getSet().toString());
    }
    
     /**
     * Get all elements of set
     */
    
    public void getSet(){
        Hospital hospital = provider.getHospital(1).get();
        hospital.getSet();
        log.debug("GET SET" + hospital.getSet().toString());
    }
       
    /**
     * Insert one element into a list
     */
    
    public void insertList(){
        Hospital hospital = provider.getHospital(1).get(); 
        log.debug("INSERT LIST" + hospital.toString());
        log.debug("INSERT LIST" + hospital.getList().toString());
        hospital.getList().add(generateOneHospitalization(hospital.getId()));
        log.debug("INSERT LIST" + hospital.toString());
        log.debug("INSERT LIST" + hospital.getList().toString());
    }
    
    /**
     * Update list elements
     */
    
    public void updateList(){
        Hospital hospital = provider.getHospital(1).get(); 
        log.debug("UPDATE LIST" + hospital.toString());
        log.debug("UPDATE LIST" + hospital.getList().toString());
        List<String> list = hospital.getList();
        list.set(0, "UPDATE");
        hospital.setList(list);
        log.debug("UPDATE LIST" + hospital.toString());
        log.debug("UPDATE LIST" + hospital.getList().toString());
    }
    
    /**
     * Delete list elements
     */
    
    public RequestStatus deleteList(){
        Hospital hospital = provider.getHospital(1).get(); 
        log.debug("DELETE LIST" + hospital.toString());
        log.debug("DELETE LIST" + hospital.getList().toString());
        List<String> list = hospital.getList();
        list.remove(0);
        hospital.setList(list);
        log.debug("DELETE LIST" + hospital.toString());
        log.debug("DELETE LIST" + hospital.getList().toString());
        return RequestStatus.SUCCESS;
    }
    
    
    /**
     * Get list elements
     */
    
    public void getList(){
        Hospital hospital = provider.getHospital(1).get(); 
        log.debug("GET LIST" + hospital.toString());
        log.debug("GET LIST" + hospital.getList().toString());
        hospital.getList();
        log.debug("GET LIST" + hospital.toString());
        log.debug("GET LIST" + hospital.getList().toString());
    }
    
    /**
     * Generate map from list
     * @return 
     */
    public  Map<String, String> generateMap() {
        Map<String, String> map = new HashMap(); 
        List<String> list = generateHospitalizations();
        for (int i = 0; i < list.size(); i++) {           
            map.put(String.valueOf(i+1), list.get(i));            
        }       
        return map;
    } 
    
    /**
     * Insert one hospitalization element into a map
     */
    
    public void insertMap(){
        Hospital hospital = provider.getHospital(1).get(); 
        log.debug("INSERT MAP" + hospital.toString());
        log.debug("INSERT MAP" + hospital.getMap().toString());
         Map<String, String> map = hospital.getMap();
        map.put(String.valueOf(map.size()), generateOneHospitalization(hospital.getId()));
        hospital.setMap(map);
        log.debug("INSERT MAP" + hospital.toString());
        log.debug("INSERT MAP" + hospital.getMap().toString());
    }
    
    /**
     * Update one hospitalization map element
     */
    
    public void updateMap(){
        Hospital hospital = provider.getHospital(1).get(); 
        log.debug("UPDATE MAP" + hospital.toString());
        log.debug("UPDATE MAP" + hospital.getMap().toString());
        Map<String, String> map = hospital.getMap();
        map.replace("1", "UPDATE");
         hospital.setMap(map);
        log.debug("UPDATE MAP" + hospital.toString());
        log.debug("UPDATE MAP" + hospital.getMap().toString());
    }
    
    /**
     * Delete map
     */
    
    public void deleteMap(){
        Hospital hospital = provider.getHospital(1).get(); 
        log.debug("DELETE MAP" + hospital.toString());
        log.debug("DELETE MAP" + hospital.getMap().toString());
        Map<String, String> map = hospital.getMap();
        map.clear();
        hospital.setMap(map);
        log.debug("DELETE MAP" + hospital.toString());
        log.debug("DELETE MAP" + hospital.getMap().toString());
    }
    
    /**
     * Get map
     */
    
    public void getMap(){
        Hospital hospital = provider.getHospital(1).get(); 
        log.debug("GET MAP" + hospital.toString());
        log.debug("GET MAP" + hospital.getMap().toString());
    }
    
    
    public  Set<Hospitalization> generateHospitalizationsComp() {
        Set<Hospitalization> hospitalizationList = new HashSet<>();  
        Random random = new Random();
        Calendar calendar = Calendar.getInstance();
        int randInt = (int) ( 1 + Math.random() * 6);
        for (int i = 0; i < randInt; i++) {
            Hospitalization hospitalization = new Hospitalization();
            hospitalization.setServiceId((int) ( Math.random() * 11 ));
            hospitalization.setSignature(random.nextBoolean());
            hospitalization.setWard((int) ( 1 + Math.random() * 2));
            hospitalization.setStatus(HospitalizationStatus.HOSPITALIZED);
            hospitalization.setYear(calendar.get(YEAR));
            hospitalization.setMonth(calendar.get(MONTH));
            hospitalization.setDay(calendar.get(DAY_OF_MONTH));
            hospitalization.setHour(HOUR);
            hospitalization.setMinute(MINUTE);
            hospitalization.setHospitalId(provider.maxHospital().get());
            hospitalizationList.add(hospitalization);
        }
        return hospitalizationList;
    } 
    
    /**
     * Generate one hospitalization
     * @param id
     * @return 
     */
    public Hospitalization generateOneHospitalizationComp(long id) {
            Random random = new Random();
            Calendar calendar = Calendar.getInstance();
            Hospitalization hospitalization = new Hospitalization();
            hospitalization.setServiceId((int) ( Math.random() * 11 ));
            hospitalization.setSignature(random.nextBoolean());
            hospitalization.setWard((int) ( 4 + Math.random() * 6));
            hospitalization.setHospitalId(id);
            hospitalization.setStatus(HospitalizationStatus.HOSPITALIZED);
            hospitalization.setYear(calendar.get(YEAR));
            hospitalization.setMonth(calendar.get(MONTH));
            hospitalization.setDay(calendar.get(DAY_OF_MONTH));
            hospitalization.setHour(HOUR);
            hospitalization.setMinute(MINUTE);
            log.debug("GenerateOneHospitalization "+ hospitalization.toString());
            return hospitalization;
    }    
    
    
    
      /**
     * Insert one hospitalization element into a set.
     */
    
    public void insertSetComp(){
        Hospital hospital = provider.getHospital(1).get(); 
        log.debug("INSERT SET COMP" + hospital.toString());
        log.debug("INSERT SET COMP" + hospital.getHospitalization().toString());
        hospital.getHospitalization().add(generateOneHospitalizationComp(hospital.getId()));
        log.debug("INSERT SET COMP" + hospital.toString());
        log.debug("INSERT SET COMP" + hospital.getHospitalization().toString());
    }
    
    /**
     * Update set case
     */
    
    public void updateSetComp(){
        Hospital hospital = provider.getHospital(1).get(); 
        log.debug("UPDATE SET COMP" + hospital.getHospitalization());
        Set<Hospitalization> set = hospital.getHospitalization();
        Hospitalization[] array = new Hospitalization[set.size()];
        set.toArray(array);       
        array[0].setStatus(HospitalizationStatus.DISCHARGED);
        Set<Hospitalization> set2 = new HashSet<>(Arrays.asList(array));       
        hospital.setHospitalization(set2);
        //hospital.getSet().stream().forEach((item) -> item.toUpperCase());        
        log.debug("UPDATE SET COMP" + hospital.getHospitalization());
    }
    
    /**
     * Delete all elements of set
     */
    
    public void deleteSetComp(){
        Hospital hospital = provider.getHospital(1).get(); 
        log.debug("DELETE SET COMP" + hospital.toString());
        log.debug("DELETE SET COMP" + hospital.getSet().toString());
        Set<Hospitalization> set = new HashSet<>();  
        hospital.setHospitalization(set);
        log.debug("DELETE SET COMP" + hospital.toString());
        log.debug("DELETE SET COMP" + hospital.getHospitalization().toString());
    }
    
     /**
     * Get all elements of set
     */
    
    public void getSetComp(){
        Hospital hospital = provider.getHospital(1).get();
        log.debug("GET SET COMP" + hospital.getHospitalization().toString());
    }
    
     /**
     * Generate map from list
     * @return 
     */
    public  Map<String, Hospitalization> generateMapComp() {
        Map<String, Hospitalization> map = new HashMap();
        List<Hospitalization> list = new ArrayList<>(generateHospitalizationsComp());
        for (int i = 0; i < list.size(); i++) {           
            map.put(String.valueOf(i+1), list.get(i));            
        }       
        return map;
    } 
    
     /**
     * Insert one hospitalization element into a map
     */
    
    public void insertMapComp(){
        Hospital hospital = provider.getHospital(1).get(); 
        log.debug("INSERT MAP_COMP" + hospital.toString());
        log.debug("INSERT MAP_COMP" + hospital.getHospitalMap().toString());
        Map<String, Hospitalization> map = hospital.getHospitalMap();
        map.put(String.valueOf(map.size()), generateOneHospitalizationComp(hospital.getId()));
        hospital.setHospitalMap(map);
        log.debug("INSERT MAP_COMP" + hospital.toString());
        log.debug("INSERT MAP_COMP" + hospital.getHospitalMap().toString());
    }
    
    /**
     * Update one hospitalization map element
     */
    
    public void updateMapComp(){
        Hospital hospital = provider.getHospital(1).get(); 
        log.debug("UPDATE MAP_COMP" + hospital.toString());
        log.debug("UPDATE MAP_COMP" + hospital.getHospitalMap().toString());
        Map<String, Hospitalization> map = hospital.getHospitalMap();
        Hospitalization hosp = map.get("1");
        hosp.setStatus(HospitalizationStatus.DISCHARGED);
        map.replace("1", hosp);
        hospital.setHospitalMap(map);
        log.debug("UPDATE MAP_COMP" + hospital.toString());
        log.debug("UPDATE MAP_COMP" + hospital.getMap().toString());
    }
    
    /**
     * Delete map
     */
    
    public void deleteMapComp(){
        Hospital hospital = provider.getHospital(1).get(); 
        log.debug("DELETE MAP_COMP" + hospital.toString());
        log.debug("DELETE MAP_COMP" + hospital.getHospitalMap().toString());
        Map<String, Hospitalization> map = hospital.getHospitalMap();
        map.clear();
        hospital.setHospitalMap(map);
        log.debug("DELETE MAP_COMP" + hospital.toString());
        log.debug("DELETE MAP_COMP" + hospital.getHospitalMap().toString());
    }
    
    /**
     * Get map
     */
    
    public void getMapComp(){
        Hospital hospital = provider.getHospital(1).get(); 
        log.debug("GET MAP_COMP" + hospital.toString());
        log.debug("GET MAP_COMP" + hospital.getHospitalMap().toString());
    }
    
    
    public void deleteHospital(){
        log.debug(provider.deleteHospital(1));        
    }
    
    
}
