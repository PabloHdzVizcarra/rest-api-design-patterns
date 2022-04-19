package jvm.pablohdz.restapidesignpatterns.example.visitor2;

public interface Visitor {
  void visitTheElement(CompositeEmployee employees);
  
  void visitTheElement(SimpleEmployee employee);
}
