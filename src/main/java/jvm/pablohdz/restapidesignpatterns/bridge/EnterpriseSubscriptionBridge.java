package jvm.pablohdz.restapidesignpatterns.bridge;

public class EnterpriseSubscriptionBridge extends SubscriptionAbstractionBridge {
  protected static final String TYPE = "Enterprise";
  protected static final int PRICE = 1000;
  
  public EnterpriseSubscriptionBridge(StateSubscriptionBridge state) {
    super(state);
  }
  
  @Override
  public SubscriptionDto startSubscription() {
    SubscriptionDto subscriptionCreated = super.startSubscription();
    subscriptionCreated.setType(TYPE);
    subscriptionCreated.setPrice(PRICE);
    
    long oneYearBefore = DateUtils.createDateBeforeMonths(12);
    subscriptionCreated.setCreatedAt(oneYearBefore);
  
    stateDto = subscriptionCreated;
    return stateDto;
  }
  
  public SubscriptionDto applyEnterpriseDiscount() {
    long createdAt = stateDto.getCreatedAt();
    if (DateUtils.verifyThatThisDateIsThreeMonthsOld(createdAt)) {
      stateDto.setPrice((int) (stateDto.getPrice() - (stateDto.getPrice() * 0.3)));
    }
  
    return stateDto;
  }
}
