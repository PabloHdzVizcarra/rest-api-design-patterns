package jvm.pablohdz.restapidesignpatterns.bridge;

public interface StateSubscriptionBridge {
  
  SubscriptionDto startSubscription(SubscriptionDto subscriptionStateDto);
  
  SubscriptionDto pauseSubscription(SubscriptionDto subscriptionStart);
  
  SubscriptionDto resumeSubscription(SubscriptionDto subscriptionPaused);
}
