package jvm.pablohdz.restapidesignpatterns.bridge;

import java.util.Date;
import jvm.pablohdz.restapidesignpatterns.exception.SubscriptionPersonalNotPaused;
import jvm.pablohdz.restapidesignpatterns.utils.StringUtils;

public class PauseSubscriptionState implements StateSubscriptionBridge {
  
  @Override
  public SubscriptionDto startSubscription(SubscriptionDto subscriptionStateDto) {
    SubscriptionDto dto = new SubscriptionDto();
    dto.setStart(false);
    String id = "sub_" + StringUtils.generateRandomIdWithLength(8);
    dto.setId(id);
    dto.setUpdatedAt(new Date().getTime());
    return dto;
  }
  
  @Override
  public SubscriptionDto pauseSubscription(SubscriptionDto subscriptionWithData) {
    subscriptionWithData.setPrice(0);
    subscriptionWithData.setPaused(true);
    subscriptionWithData.setUpdatedAt(new Date().getTime());
    return subscriptionWithData;
  }
  
  @Override
  public SubscriptionDto resumeSubscription(SubscriptionDto subscriptionPaused) {
    if (!subscriptionPaused.isPaused())
      throw new SubscriptionPersonalNotPaused();
    
    subscriptionPaused.setPaused(false);
    return subscriptionPaused;
  }
}
