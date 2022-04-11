package jvm.pablohdz.restapidesignpatterns.model;

import jvm.pablohdz.restapidesignpatterns.dto.ChargeFlyweightDto;
import jvm.pablohdz.restapidesignpatterns.dto.PriceFlyweight;

public interface ChargeFlyweight {

  void setPriceCharge(PriceFlyweight price);
  
  ChargeFlyweightDto createDto();
}
