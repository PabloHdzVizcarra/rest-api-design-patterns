package jvm.pablohdz.restapidesignpatterns.example.composite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class CompositeEmployeeTest {
  private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

  @Test
  void compositePatternExample() {
    logger.info("Composite pattern example");
    // 2 teachers other than HOD works in mathematics department
    BasicEmployee mathTeacher1 = new BasicEmployee("Math Teacher-1", "Maths");
    BasicEmployee mathTeacher2 = new BasicEmployee("Math Teacher-2", "Maths");
    
    // teachers other than HOD works in Computer Science department
    BasicEmployee csTeacher1 = new BasicEmployee("CS Teacher-1", "CS");
    BasicEmployee csTeacher2 = new BasicEmployee("CS Teacher-2", "CS");
    BasicEmployee csTeacher3 = new BasicEmployee("CS Teacher-2", "CS");
    
    // The college has 2 Head of departmens-one for Mathematics and one for Computer Science
    CompositeEmployee hodMaths = new CompositeEmployee("Mrs.S.Das HOD-Math", "Maths");
    CompositeEmployee hodCS = new CompositeEmployee("Mr.K.Das HOD-CS", "CS");
    
    // principal of the college
    CompositeEmployee principal = new CompositeEmployee("Mrs.S.John Principal", "Principal");
    
    // Teachers of Mathematics department directly reposts to HOD of Mathematics
    hodMaths.addEmployee(mathTeacher1);
    hodMaths.addEmployee(mathTeacher2);
    
    // Teachers of Computer Science department directly reposts to HOD of Computer Science
    hodCS.addEmployee(csTeacher1);
    hodCS.addEmployee(csTeacher2);
    hodCS.addEmployee(csTeacher3);
    
    // Principal is on top of the college.HOD -Maths and Comp. Sc directly report to him.
    principal.addEmployee(hodMaths);
    principal.addEmployee(hodCS);
    
    // testing the structure of a principal object.
    principal.printStructures();
    logger.info("At present Principal has control over {} number of employees.",
        principal.getEmployeeCount());
    
    assertEquals(7, principal.getEmployeeCount());
    
    logger.info("Testing the structure of a HOD-CS object");
    // Print details of HOD-CS object
    hodCS.printStructures();
    logger.info("At present HOD-CS has control over {} number of employees.",
        hodCS.getEmployeeCount());
    assertEquals(3, hodCS.getEmployeeCount());
    
    logger.info("Testing the structure of a HOD-Math object");
    // Print details of HOD-Math object
    hodMaths.printStructures();
    logger.info("At present HOD-Math has control over {} number of employees.",
        hodMaths.getEmployeeCount());
    assertEquals(2, hodMaths.getEmployeeCount());
    
    // leaf node
    logger.info("Testing the structure of the leaf node");
    mathTeacher1.printStructures();
    logger.info("At present Math Teacher-1 has control over {} number of employees.",
        mathTeacher1.getEmployeeCount());
    assertEquals(0, mathTeacher1.getEmployeeCount());
    
    hodCS.removeEmployee(csTeacher2);
    logger.info("After removing CS Teacher-2 from HOD-CS, the organization structure is as follows:");
    principal.printStructures();
  
    logger.info("At present Principal has control over {} number of employees.",
        principal.getEmployeeCount());
    assertEquals(6, principal.getEmployeeCount());
    
    logger.info("At present HOD-CS has control over {} number of employees.", hodCS.getEmployeeCount());
    assertEquals(2, hodCS.getEmployeeCount());
    logger.info("At present HOD-Math has control over {} number of employees.", hodMaths.getEmployeeCount());
    assertEquals(2, hodMaths.getEmployeeCount());
  }
}