package jvm.pablohdz.restapidesignpatterns.bridge;

import java.util.Date;
import jvm.pablohdz.restapidesignpatterns.exception.SubscriptionPersonalNotPaused;
import jvm.pablohdz.restapidesignpatterns.utils.StringUtils;

public class StartSubscriptionState implements StateSubscriptionBridge {
  
  @Override
  public SubscriptionDto startSubscription(SubscriptionDto subscriptionStateDto) {
    subscriptionStateDto.setStart(true);
    String id = "sub_" + StringUtils.generateRandomIdWithLength(8);
    subscriptionStateDto.setId(id);
    subscriptionStateDto.setUpdatedAt(new Date().getTime());
    
    return subscriptionStateDto;
  }
  
  @Override
  public SubscriptionDto pauseSubscription(SubscriptionDto subscriptionEmpty) {
    subscriptionEmpty.setPaused(true);
    subscriptionEmpty.setUpdatedAt(new Date().getTime());
    return subscriptionEmpty;
  }
  
  @Override
  public SubscriptionDto resumeSubscription(SubscriptionDto subscriptionPaused) {
    throw new SubscriptionPersonalNotPaused();
  }
}
