package jvm.pablohdz.restapidesignpatterns.example.visitor;

public interface OriginalInterface {

  /** This method has a visitor argument. */
  void acceptVisitor(Visitor visitor);
}
