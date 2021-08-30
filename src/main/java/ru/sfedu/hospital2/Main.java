/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.hospital2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.hospital2.enums.RequestStatus;
import ru.sfedu.hospital2.lab1.HibernateMetadataProvider;
import ru.sfedu.hospital2.lab2.TestEntityProvider;
import ru.sfedu.hospital2.lab2.model.Address;
import ru.sfedu.hospital2.lab2.model.TestEntity;

/**
 *
 * @author Liza
 */
public class Main {
    
    private static final Logger log = (Logger) LogManager.getLogger(Main.class);
    public static void main(String[] args){
        if (args.length==0){
            System.out.print("Not enough arguments");
        }
         switch (args[0].toLowerCase()) {
            case "lab1":
              lab1(args);
              break;
            case "lab2":
              lab2(args);
              break;
            case "lab3":
              lab3(args);
              break;
            /*case "lab4":
              lab4(args);
                break;
            case "lab5":
              lab5(args);
                break;*/
            default:
                log.info("========================WRONG========================");
                break;
        }        
    }  

    private static void lab1(String[] args) {
        switch (args[1]) {
        case "getAmountOfHelp":
         getAmountOfHelp();
        break;
        case "getAllSchemas":
         getAllSchemas();
        break;
        case "getAllCatalogs":
         getAllCatalogs();
        break;
        case "getAllUsers":
         getAllUsers();
        break;
         default:
                log.info("========================WRONG========================");
                break;
        }
  
    }
     
    private static void getAmountOfHelp() {
        final ru.sfedu.hospital2.lab1.HibernateMetadataProvider provider = new ru.sfedu.hospital2.lab1.HibernateMetadataProvider();
         provider.getAmountOfHelp();
        //HibernateMetadataProvider.getAllSchemas().forEach(x -> System.out.println(x));
  }
    private static void getAllSchemas() {
        final ru.sfedu.hospital2.lab1.HibernateMetadataProvider provider = new ru.sfedu.hospital2.lab1.HibernateMetadataProvider();
        provider.getAllSchemas();
  }
    private static void getAllCatalogs() {
         final ru.sfedu.hospital2.lab1.HibernateMetadataProvider provider = new ru.sfedu.hospital2.lab1.HibernateMetadataProvider();
         provider.getAllCatalogs();
  }
    private static void getAllUsers() {
        final ru.sfedu.hospital2.lab1.HibernateMetadataProvider provider = new ru.sfedu.hospital2.lab1.HibernateMetadataProvider();
         provider.getAllUsers();
  }
    
    private static void lab2(String[] args) {
        final ru.sfedu.hospital2.lab2.TestEntityProvider provider = new ru.sfedu.hospital2.lab2.TestEntityProvider();
        switch (args[1]) {
        case "get":
          get2(args);
          break;
        case "insert":
          insert2(args);
          break;
        case "update":
          update2(args);
          break;
        case "delete":
          delete2(args);
          break;
          default:
                log.info("========================WRONG========================");
                break;
    }
  }

    private static void get2(String[] args) {
        final ru.sfedu.hospital2.lab2.TestEntityProvider provider = new ru.sfedu.hospital2.lab2.TestEntityProvider();
        Optional<TestEntity> entity = provider.get(Long.valueOf(args[2]));
        if (entity.isEmpty()){
            log.error("No such element");
        } else log.info(entity.get().toString());
  }
    private static String insert2(String[] args) {
       final ru.sfedu.hospital2.lab2.TestEntityProvider provider = new ru.sfedu.hospital2.lab2.TestEntityProvider();
       TestEntity test = new TestEntity();
       Address address = new Address();
       test.setName(args[2]);
       test.setDescription(args[3]);
       address.setCity(args[4]);
       address.setDistrict(args[5]);
       address.setRegion(args[6]);
       test.setAddress(address);
       var entity = provider.insert(test);
    return entity.toString();
  }
    private static String update2(String[] args) {
       final TestEntityProvider provider = new TestEntityProvider();
       TestEntity test = provider.get(Long.parseLong(args[2])).get();
       Address address = new Address();
       test.setName(args[3]);
       test.setDescription(args[4]);
       address.setCity(args[5]);
       address.setDistrict(args[6]);
       address.setRegion(args[7]);
       test.setAddress(address);
       var entity = provider.update(test);
       return entity.toString();
  }
    private static String delete2(String[] args) {
        final TestEntityProvider provider = new TestEntityProvider();
        if(provider.get(Long.parseLong(args[2])).isPresent()){
            return provider.delete(Long.parseLong(args[2])).toString();
        } else return ("There is no such object");      
  }
    
    private static String lab3(String[] args) {
    ru.sfedu.hospital2.lab3.MappedSuperClass.HibernateDataProvider providerMPS = 
                  new ru.sfedu.hospital2.lab3.MappedSuperClass.HibernateDataProvider();
    ru.sfedu.hospital2.lab3.TablePerClass.HibernateDataProvider providerTPC = 
                  new ru.sfedu.hospital2.lab3.TablePerClass.HibernateDataProvider();
     ru.sfedu.hospital2.lab3.SingleTable.HibernateDataProvider providerST = 
                  new ru.sfedu.hospital2.lab3.SingleTable.HibernateDataProvider();
      ru.sfedu.hospital2.lab3.JoinedTable.HibernateDataProvider providerJT = 
                  new ru.sfedu.hospital2.lab3.JoinedTable.HibernateDataProvider();
    switch (args[1]) {
        case "getJT":
            return providerJT.getPatient(Long.parseLong(args[2])).toString();
        case "getMPS":
            return providerMPS.getPatient(Long.parseLong(args[2])).toString();
        case "getST":
            return providerST.getPatient(Long.parseLong(args[2])).toString();
        case "getTPC":
            return providerTPC.getPatient(Long.parseLong(args[2])).toString();
        default:
                return ("========================WRONG========================");       
    }
  }

/*private static String lab4(String[] args) {
    final ru.sfedu.hospital2.lab4.HibernateDataProvider provider
                = new ru.sfedu.hospital2.lab4.HibernateDataProvider();
    final ru.sfedu.hospital2.lab4.model.
    switch (args[1]) {
      case "setget":
          return provider.
      case "listget":
          return
      case "mapget":
          return
      case "setcompget":
          return
      case "mapcompget":   
          return
      default:
          return
    }
}
        private static String lab5(String[] args) {
             final ru.sfedu.hospital2.lab5.provider.HQLProvider providerHQL
                = new ru.sfedu.hospital2.lab5.provider.HQLProvider();
            final ru.sfedu.hospital2.lab5.provider.NativeSQLProvider providerNQL
                    = new ru.sfedu.hospital2.lab5.provider.NativeSQLProvider();
            final ru.sfedu.hospital2.lab5.provider.CriteriaProvider providerCriteria
                    = new ru.sfedu.hospital2.lab5.provider.CriteriaProvider();
            final ru.sfedu.hospital2.lab5.provider.DataProvider simpleProvider
                    = new ru.sfedu.hospital2.lab5.provider.DataProvider();
            
            switch (args[1]) {
                case "hql":
                    return providerHQL.selectAllHospital().toString();
                case "nsql":
                    return providerNQL.selectAllHospital().toString();
                case "criteria":
                    return providerCriteria.selectAllHospital().toString();
                default:
                    return("Error");
            }
        }*/
}