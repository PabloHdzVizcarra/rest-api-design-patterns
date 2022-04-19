package jvm.pablohdz.restapidesignpatterns.example.visitor2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleEmployee implements Employee {
  private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
  private String name;
  private String department;
  private final int yearsOfExperience;
  
  public SimpleEmployee(String name, String department, int yearsOfExperience) {
    this.name = name;
    this.department = department;
    this.yearsOfExperience = yearsOfExperience;
  }
  
  public String getName() {
    return name;
  }
  
  public String getDepartment() {
    return department;
  }
  
  public int getYearsOfExperience() {
    return yearsOfExperience;
  }
  
  @Override
  public void printStructures() {
    logger.info("{} works in {} department Experience : {}",
        getName(), getDepartment(), getYearsOfExperience());
  }
  
  @Override
  public void acceptVisitor(Visitor visitor) {
    visitor.visitTheElement(this);
  }
}
