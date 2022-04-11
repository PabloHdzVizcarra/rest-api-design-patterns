package jvm.pablohdz.restapidesignpatterns.component;

import java.util.HashMap;
import java.util.Map;
import jvm.pablohdz.restapidesignpatterns.model.ChargeFlyweight;
import jvm.pablohdz.restapidesignpatterns.model.ChargeFlyweightCash;
import jvm.pablohdz.restapidesignpatterns.model.ChargeFlyweightDebit;
import jvm.pablohdz.restapidesignpatterns.types.ChargeTypesEnum;
import jvm.pablohdz.restapidesignpatterns.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ChargeFlyweightFactory {
  private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
  private final Map<Integer, ChargeFlyweight> chargeFactory = new HashMap<>();
  
  public ChargeFlyweight getChargeFromFactory(int companyId, String type) {
    ChargeFlyweight chargeCategory = chargeFactory.get(companyId);
    if (chargeCategory == null) {
      switch (ChargeTypesEnum.valueOfType(type)) {
        case CASH -> {
          chargeCategory = new ChargeFlyweightCash(createId(), "full_charge", companyId);
          logger.info("new charge cash created");
        }
        case DEBIT -> {
          chargeCategory = new ChargeFlyweightDebit(createId(), "basic_price", companyId);
          logger.info("new charge debit created");
        }
        default -> throw new IllegalArgumentException("the type: " + type + " is not valid");
      }
      chargeFactory.put(companyId, chargeCategory);
    }
    logger.info("return charger from memory");
    return chargeCategory;
  }
  
  private String createId() {
    return "charge_" + StringUtils.generateRandomIdWithLength(8);
  }
}
