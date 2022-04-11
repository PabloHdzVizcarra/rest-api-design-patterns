package jvm.pablohdz.restapidesignpatterns.service;

import java.util.List;
import jvm.pablohdz.restapidesignpatterns.component.ChargeFlyweightFactory;
import jvm.pablohdz.restapidesignpatterns.dto.ChargeFlyweightDto;
import jvm.pablohdz.restapidesignpatterns.dto.CreateChargesRequest;
import jvm.pablohdz.restapidesignpatterns.dto.PriceFlyweight;
import jvm.pablohdz.restapidesignpatterns.model.ChargeFlyweight;
import jvm.pablohdz.restapidesignpatterns.model.ChargeFlyweightCash;
import jvm.pablohdz.restapidesignpatterns.types.ChargeTypesEnum;
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
    String typeCharge = request.getTypeCharge();
  
    return listPrices.stream()
        .map(
            price -> {
              
              ChargeFlyweight chargeFromFactory =
                   factory.getChargeFromFactory(companyId, typeCharge);
              PriceFlyweight priceFlyweight = new PriceFlyweight(price);
              chargeFromFactory.setPriceCharge(priceFlyweight);

              return chargeFromFactory.createDto();
            })
        .toList();
  }
}
