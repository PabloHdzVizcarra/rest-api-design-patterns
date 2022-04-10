package jvm.pablohdz.restapidesignpatterns.service;

import java.util.List;
import jvm.pablohdz.restapidesignpatterns.component.ChargeFlyweightFactory;
import jvm.pablohdz.restapidesignpatterns.dto.ChargeFlyweightDto;
import jvm.pablohdz.restapidesignpatterns.dto.CreateChargesRequest;
import jvm.pablohdz.restapidesignpatterns.dto.PriceFlyweight;
import jvm.pablohdz.restapidesignpatterns.model.ChargeFlyweightDebit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlyWeightService {
  private final ChargeFlyweightFactory factory;

  @Autowired
  public FlyWeightService(ChargeFlyweightFactory factory) {
    this.factory = factory;
  }

  public List<ChargeFlyweightDto> createCharges(CreateChargesRequest request) {
    Integer companyId = request.getCompanyId();
    List<Integer> listPrices = request.getListPrices();

    return listPrices.stream()
        .map(
            price -> {
              ChargeFlyweightDebit chargeFromFactory =
                  (ChargeFlyweightDebit) factory.getChargeFromFactory(companyId);
              PriceFlyweight priceFlyweight = new PriceFlyweight(price);
              chargeFromFactory.setPriceCharge(priceFlyweight);
  
              return new ChargeFlyweightDto(
                  chargeFromFactory.getName(),
                  chargeFromFactory.getId(),
                  chargeFromFactory.getCompanyId(),
                  chargeFromFactory.getPrice());
            }).toList();
  }
}
