package jvm.pablohdz.restapidesignpatterns.example.visitor2;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompositeEmployee implements Employee {
  private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
  private String name;
  private String department;
  private final int yearsOfExperience;
  private List<Employee> controls;
  
  public CompositeEmployee(String name, String department, int yearsOfExperience) {
    this.name = name;
    this.department = department;
    this.yearsOfExperience = yearsOfExperience;
    this.controls = new ArrayList<>();
  }
  
  public void addEmployee(Employee employee) {
    controls.add(employee);
  }
  
  public void removeEmployee(Employee employee) {
    controls.remove(employee);
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
  
  public List<Employee> getControls() {
    return controls;
  }
  
  @Override
  public void printStructures() {
    logger.info("{} works in {} department Experience : {}",
        getName(), getDepartment(), getYearsOfExperience());
    
    controls.forEach(Employee::printStructures);
  }
  
  @Override
  public void acceptVisitor(Visitor visitor) {
    visitor.visitTheElement(this);
  }
}
