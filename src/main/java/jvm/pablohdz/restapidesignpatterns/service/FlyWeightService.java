package jvm.pablohdz.restapidesignpatterns.service;

import java.util.List;
import jvm.pablohdz.restapidesignpatterns.component.ChargeFlyweightFactory;
import jvm.pablohdz.restapidesignpatterns.dto.ChargeFlyweightDto;
import jvm.pablohdz.restapidesignpatterns.dto.CreateChargesRequest;
import jvm.pablohdz.restapidesignpatterns.dto.PriceFlyweight;
import jvm.pablohdz.restapidesignpatterns.model.ChargeFlyweight;
import jvm.pablohdz.restapidesignpatterns.model.NotificationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlyWeightService {
  private final ChargeFlyweightFactory factory;
  private final KafkaMessageService kafkaMessageService;

  @Autowired
  public FlyWeightService(ChargeFlyweightFactory factory, KafkaMessageService kafkaMessageService) {
    this.factory = factory;
    this.kafkaMessageService = kafkaMessageService;
  }

  public List<ChargeFlyweightDto> createCharges(CreateChargesRequest request) {
    Integer companyId = request.getCompanyId();
    List<Integer> listPrices = request.getListPrices();
    String typeCharge = request.getTypeCharge();
  
    List<ChargeFlyweightDto> chargeList = listPrices.stream()
        .map(
            price -> {
              ChargeFlyweight chargeFromFactory =
                  factory.getChargeFromFactory(companyId, typeCharge);
              PriceFlyweight priceFlyweight = new PriceFlyweight(price);
              chargeFromFactory.setPriceCharge(priceFlyweight);
            
              return chargeFromFactory.createDto();
            })
        .toList();
    
    kafkaMessageService.sendMessageNotification(new NotificationMessage("design-patterns",
        "flyweight", chargeList));
    return chargeList;
  }
}
