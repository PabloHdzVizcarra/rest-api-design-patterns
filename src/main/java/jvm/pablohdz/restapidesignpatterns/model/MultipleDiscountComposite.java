package jvm.pablohdz.restapidesignpatterns.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class MultipleDiscountComposite implements DiscountComposite{
  private final String id;
  private final String name;
  private final String object;
  private final int discount;
  private final List<DiscountComposite> discountList;
  
  public MultipleDiscountComposite(String id, String name, int discount) {
    this.id = id;
    this.name = name;
    this.discount = discount;
    this.object = "discount";
    this.discountList = new ArrayList<>();
  }
  
  public void addDiscount(DiscountComposite discountComposite) {
    discountList.add(discountComposite);
  }
  
  public void removeDiscount(DiscountComposite discountComposite) {
    discountList.remove(discountComposite);
  }
  
  @Override
  public int getDiscountValue() {
    return discount;
  }
  
  @Override
  public int getSumOfAllDiscounts() {
    return discountList.stream().mapToInt(DiscountComposite::getDiscountValue).sum();
  }
}
