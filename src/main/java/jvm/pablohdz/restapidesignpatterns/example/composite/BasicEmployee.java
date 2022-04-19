package jvm.pablohdz.restapidesignpatterns.example.composite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicEmployee implements Employee {
  private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
  private String name;
  private String dept;
  private int employeeCount = 0;
  
  public BasicEmployee(String name, String dept) {
    this.name = name;
    this.dept = dept;
  }
  
  @Override
  public void printStructures() {
    logger.info("{} works in {}", name, dept);
  }
  
  @Override
  public int getEmployeeCount() {
    return employeeCount;
  }
}
