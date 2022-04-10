package jvm.pablohdz.restapidesignpatterns.model;

import jvm.pablohdz.restapidesignpatterns.dto.PriceFlyweight;
import lombok.Getter;

@Getter
public class ChargeFlyweightDebit implements ChargeFlyweight {
  private final String id;
  private final String name;
  private PriceFlyweight price;
  private final int companyId;
  
  public ChargeFlyweightDebit(String id, String name, int companyId) {
    this.id = id;
    this.name = name;
    this.companyId = companyId;
  }
  
  @Override
  public void setPriceCharge(PriceFlyweight price) {
    this.price = price;
  }
}
