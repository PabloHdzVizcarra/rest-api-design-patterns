package jvm.pablohdz.restapidesignpatterns.model;

import lombok.Getter;

@Getter
public class BasicDiscountComposite implements DiscountComposite {
  private final String id;
  private final String name;
  private final String object;
  private final int discount;
  
  public BasicDiscountComposite(String id, String name, int discount) {
    this.id = id;
    this.name = name;
    this.discount = discount;
    this.object = "discount";
  }
  
  @Override
  public int getDiscountValue() {
    return discount;
  }
  
  @Override
  public int getSumOfAllDiscounts() {
    return discount;
  }
}
