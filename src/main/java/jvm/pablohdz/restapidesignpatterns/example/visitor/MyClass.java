package jvm.pablohdz.restapidesignpatterns.example.visitor;

public class MyClass implements OriginalInterface {
  private final int myInt;
  
  public MyClass() {
    this.myInt = 5;
  }
  
  public int getMyInt() {
    return myInt;
  }
  
  @Override
  public void acceptVisitor(Visitor visitor) {
    visitor.visit(this);
  }
}
