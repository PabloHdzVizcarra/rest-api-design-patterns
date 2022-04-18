package jvm.pablohdz.restapidesignpatterns.visitor;

import static jvm.pablohdz.restapidesignpatterns.utils.AmountUtils.reduceAmountInPercent;

public class ReduceAmountVisitor implements VisitorBalance {

  @Override
  public VisitorAmountDto visit(BalanceElement balance) {
    VisitorAmountDto dto = new VisitorAmountDto();
    dto.setCard(balance.getCard());
    dto.setBankAccount(balance.getBankAccount());
    dto.setCurrency(balance.getCurrency());

    int oldAmount = balance.getAmount();
    int reduceAmount = reduceAmountInPercent(oldAmount, 10);

    dto.setAmount(reduceAmount);

    return dto;
  }
}
