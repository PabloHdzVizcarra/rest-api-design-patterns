package jvm.pablohdz.restapidesignpatterns.example.template;

public class TemplateMethodExample {
  public static void main(String[] args) {
    System.out.println("\nTemplate Method Pattern\n");
  
    BasicEngineering preferredCourse = new ComputerScience();
    System.out.println("Computer Sc. course will be completed in following order:");
    preferredCourse.completeCourse();
    System.out.println("\n");
    
    preferredCourse = new Electronics();
    System.out.println("Electrical Eng. course will be completed in following order:");
    preferredCourse.completeCourse();
  }
}
