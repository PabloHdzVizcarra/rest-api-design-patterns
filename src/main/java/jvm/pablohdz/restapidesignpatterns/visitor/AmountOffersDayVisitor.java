package jvm.pablohdz.restapidesignpatterns.visitor;

import static jvm.pablohdz.restapidesignpatterns.utils.AmountUtils.reduceAmountInPercent;

import java.util.List;

public class AmountOffersDayVisitor implements VisitorBalance {
  private final List<String> currencyWithOffersDay;
  
  public AmountOffersDayVisitor(List<String> currencyWithOffersDay) {
    this.currencyWithOffersDay = currencyWithOffersDay;
  }
  
  @Override
  public VisitorAmountDto visit(BalanceElement balance) {
    VisitorAmountDto dto = new VisitorAmountDto();
    dto.setCard(balance.getCard());
    dto.setBankAccount(balance.getBankAccount());
    dto.setCurrency(balance.getCurrency());
    
    if (currencyWithOffersDay.contains(balance.getCurrency())) {
      int oldAmount = balance.getAmount();
      int reducedAmount = reduceAmountInPercent(oldAmount, 5);
      dto.setAmount(reducedAmount);
    } else {
      dto.setAmount(balance.getAmount());
    }
    return dto;
  }
}
