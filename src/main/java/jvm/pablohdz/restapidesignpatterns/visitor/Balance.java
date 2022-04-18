package jvm.pablohdz.restapidesignpatterns.visitor;

public interface Balance {
  VisitorAmountDto acceptVisitor(VisitorBalance visitor);
}
