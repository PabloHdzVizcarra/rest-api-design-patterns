package jvm.pablohdz.restapidesignpatterns.visitor;

import lombok.Getter;

@Getter
public class BalanceElement implements Balance {
  private final int amount;
  private final String currency;
  private final int bankAccount;
  private final int card;

  public BalanceElement(int amount, String currency, int bankAccount, int card) {
    this.amount = amount;
    this.currency = currency;
    this.bankAccount = bankAccount;
    this.card = card;
  }

  @Override
  public VisitorAmountDto acceptVisitor(VisitorBalance visitor) {
    return visitor.visit(this);
  }
}
