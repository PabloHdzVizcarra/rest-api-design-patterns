package jvm.pablohdz.restapidesignpatterns.example.composite;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompositeEmployee implements Employee {
  private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
  private int employeeCount = 0;
  private String name;
  private String dept;
  private List<Employee> controls;
  
  public CompositeEmployee(String name, String dept) {
    this.name = name;
    this.dept = dept;
    this.controls = new ArrayList<>();
  }
  
  public void addEmployee(Employee employee) {
    controls.add(employee);
  }
  
  public void removeEmployee(Employee employee) {
    controls.remove(employee);
  }
  
  @Override
  public void printStructures() {
    logger.info("{} works in {}", name, dept);
    controls.forEach(Employee::printStructures);
  }
  
  @Override
  public int getEmployeeCount() {
    employeeCount = controls.size();
    for (Employee e : controls) {
        employeeCount += e.getEmployeeCount();
    }
    return employeeCount;
  }
}
