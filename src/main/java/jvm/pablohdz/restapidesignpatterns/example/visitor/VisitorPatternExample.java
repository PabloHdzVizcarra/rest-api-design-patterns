package jvm.pablohdz.restapidesignpatterns.example.visitor;


public class VisitorPatternExample {

  public static void main(String[] args) {
    System.out.println("Visitor Pattern Example");
    ConcreteVisitor visitor = new ConcreteVisitor();
    MyClass myClass = new MyClass();
    myClass.acceptVisitor(visitor);
  }
}
