package jvm.pablohdz.restapidesignpatterns.visitor;

public interface VisitorBalance {
  VisitorAmountDto visit(BalanceElement balance);
}