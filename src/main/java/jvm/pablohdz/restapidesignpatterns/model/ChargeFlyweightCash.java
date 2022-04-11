package jvm.pablohdz.restapidesignpatterns.model;

import jvm.pablohdz.restapidesignpatterns.dto.ChargeFlyweightDto;
import jvm.pablohdz.restapidesignpatterns.dto.PriceFlyweight;
import jvm.pablohdz.restapidesignpatterns.types.ChargeTypesEnum;
import lombok.Getter;

@Getter
public class ChargeFlyweightCash implements ChargeFlyweight {
  private final String id;
  private final String name;
  private PriceFlyweight price;
  private final int companyId;
  private final String type;
  
  public ChargeFlyweightCash(String id, String name, int companyId) {
    this.id = id;
    this.name = name;
    this.companyId = companyId;
    this.type = ChargeTypesEnum.DEBIT.toString();
  }
  
  @Override
  public void setPriceCharge(PriceFlyweight price) {
    this.price = price;
  }
  
  @Override
  public ChargeFlyweightDto createDto() {
    return new ChargeFlyweightDto(name, id, companyId, type, price);
  }
}
