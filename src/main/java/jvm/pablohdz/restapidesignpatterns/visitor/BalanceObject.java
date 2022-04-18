package jvm.pablohdz.restapidesignpatterns.visitor;

import java.util.List;

public class BalanceObject {
  private final String object;
  private List<BalanceElement> available;

  private List<VisitorAmountDto> amountList;
  private List<String> currencyListDiscountOfTheDay;

  public BalanceObject() {
    this.object = "balance";
  }

  public void setAvailable(List<BalanceElement> available) {
    this.available = available;
  }

  public void verifyAmountsWithDiscount() {
    ReduceAmountVisitor visitor = new ReduceAmountVisitor();
    amountList = available.stream()
        .map(amount -> amount.acceptVisitor(visitor))
        .toList();
  }

  public List<VisitorAmountDto> getAmountsWithDiscount() {
    return amountList;
  }

  public void setCurrenciesWithDiscountOfTheDay(List<String> currencies) {
    this.currencyListDiscountOfTheDay = currencies;
  }

  public void verifyAmountsWithDiscountOfTheDay() {
    AmountOffersDayVisitor visitor = new AmountOffersDayVisitor(currencyListDiscountOfTheDay);
    amountList = available.stream()
        .map(amount -> amount.acceptVisitor(visitor))
        .toList();
  }
  
  public String getObject() {
    return object;
  }
}
