package jvm.pablohdz.restapidesignpatterns.example.visitor2;

import java.util.ArrayList;

public class ModifiedVisitorPatternExample {
  public static void main(String[] args) {
    System.out.println("Modified Visitor Pattern Example");

    SimpleEmployee mathTeacher1 = new SimpleEmployee("Math Teacher-1", "Maths", 13);
    SimpleEmployee mathTeacher2 = new SimpleEmployee("Math Teacher-2", "Maths", 6);
    
    SimpleEmployee englishTeacher1 = new SimpleEmployee("English Teacher-1", "English", 13);
    SimpleEmployee englishTeacher2 = new SimpleEmployee("English Teacher-2", "English", 10);
    SimpleEmployee englishTeacher3 = new SimpleEmployee("English Teacher-3", "English", 7);
    
    // The college has 2 head of departments from Maths and English
    CompositeEmployee hodEnglish = new CompositeEmployee("Mr.V.Sar-car(HOD-ENGLISH)", "English", 16);
    CompositeEmployee hodMaths = new CompositeEmployee("Mrs.S.Das(HOD-Maths)", "Maths", 20);
  
    CompositeEmployee principal = new CompositeEmployee("Dr.S.Som(Principal)", "", 20);
    
    // Teachers of Mathematics directly report to HOD of Mathematics
    hodMaths.addEmployee(mathTeacher1);
    hodMaths.addEmployee(mathTeacher2);
    
    // Teachers of English directly report to HOD of English
    hodEnglish.addEmployee(englishTeacher1);
    hodEnglish.addEmployee(englishTeacher2);
    hodEnglish.addEmployee(englishTeacher3);
    
    // Principal directly reports to HOD of Mathematics and HOD of English
    principal.addEmployee(hodMaths);
    principal.addEmployee(hodEnglish);
    
    principal.printStructures();
  
    ConcreteVisitor visitor = new ConcreteVisitor();
    ArrayList<Employee> employeeContainer = new ArrayList<>();
  
    employeeContainer.addAll(principal.getControls());
    employeeContainer.addAll(hodMaths.getControls());
    employeeContainer.addAll(hodEnglish.getControls());
    
    employeeContainer.forEach(employee -> employee.acceptVisitor(visitor));
  }
}
