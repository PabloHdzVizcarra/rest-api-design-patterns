package jvm.pablohdz.restapidesignpatterns.bridge;

abstract class SubscriptionAbstractionBridge {
  
  protected StateSubscriptionBridge state;
  protected SubscriptionDto stateDto;
  
  public SubscriptionAbstractionBridge(StateSubscriptionBridge state) {
    this.state = state;
  }
  
  public StateSubscriptionBridge getState() {
    return state;
  }
  
  public void setState(StateSubscriptionBridge state) {
    this.state = state;
  }

  public SubscriptionDto startSubscription() {
    SubscriptionDto subscriptionStateDto = new SubscriptionDto();
    stateDto = state.startSubscription(subscriptionStateDto);
    return stateDto;
  }
  
  public SubscriptionDto pauseSubscription() {
    stateDto =  state.pauseSubscription(stateDto);
    return stateDto;
  }
  
  public SubscriptionDto resumeSubscription() {
    stateDto =  state.resumeSubscription(stateDto);
    restorePriceSubscription(stateDto);
    return stateDto;
  }
  
  private void restorePriceSubscription(SubscriptionDto stateDto) {
  }
}
