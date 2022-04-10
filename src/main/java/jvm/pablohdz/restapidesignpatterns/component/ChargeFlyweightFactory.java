package jvm.pablohdz.restapidesignpatterns.component;

import java.util.HashMap;
import java.util.Map;
import jvm.pablohdz.restapidesignpatterns.model.ChargeFlyweight;
import jvm.pablohdz.restapidesignpatterns.model.ChargeFlyweightDebit;
import jvm.pablohdz.restapidesignpatterns.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ChargeFlyweightFactory {
  private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
  private final Map<Integer, ChargeFlyweight> chargeFactory = new HashMap<>();
  
  public ChargeFlyweight getChargeFromFactory(int companyId) {
    ChargeFlyweight chargeCategory = chargeFactory.get(companyId);
    if (chargeCategory == null) {
      String id = "charge_" + StringUtils.generateRandomIdWithLength(8);
      chargeCategory = new ChargeFlyweightDebit(id, "basic_price", companyId);
      chargeFactory.put(companyId, chargeCategory);
      logger.info("new charge created");
    } else {
      logger.info("get charge form memory");
    }
    
    return chargeCategory;
  }
}
