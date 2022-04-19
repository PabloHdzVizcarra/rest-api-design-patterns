package jvm.pablohdz.restapidesignpatterns.example.visitor2;

public interface Employee {
  void printStructures();

  void acceptVisitor(Visitor visitor);
}
