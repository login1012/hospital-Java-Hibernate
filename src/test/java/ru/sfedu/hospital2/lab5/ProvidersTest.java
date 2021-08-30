package ru.sfedu.hospital2.lab5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import ru.sfedu.hospital2.lab5.model.Employee;

public class ProvidersTest extends DataProviderTest {
   private static final DataProvider provider = new DataProvider();
   static final Logger logger = LogManager.getLogger(ProvidersTest.class);
   
   private static Employee employee;

  @Before
   public void setUp() {
    employee = generator.generateEmployee().get(0);
    provider.insertEmployee(employee);
  }
  
  @Test
    public void criteriaTest() {
        CriteriaProvider iProvider = new CriteriaProvider();
        Optional<List<Employee>> optEmployee = iProvider.selectAllEmployee();
        logger.info(optEmployee.get());
        assertTrue(optEmployee.isPresent());
    }
    
    @Test
    public void hqlTest() {
        HQLProvider iProvider = new HQLProvider();
        Optional<List<Employee>> optEmployee = iProvider.selectAllEmployee();  
        logger.info(optEmployee.get());
        Assertions.assertTrue(optEmployee.isPresent());
    }
    
    @Test
    public void nativeSQLTest() {
       NativeSQLProvider iProvider = new NativeSQLProvider();
       Optional<List<Employee>> optEmployee = iProvider.selectAllEmployee();       
        logger.info(optEmployee.get());
        Assertions.assertTrue(optEmployee.isPresent());
    }
}
