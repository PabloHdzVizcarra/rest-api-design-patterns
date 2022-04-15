package jvm.pablohdz.restapidesignpatterns.bridge;

public class PersonalSubscriptionBridge extends SubscriptionAbstractionBridge {
  protected static final String TYPE = "Personal";
  protected static final int PRICE = 100;
  public PersonalSubscriptionBridge(StateSubscriptionBridge state) {
    super(state);
  }
  
  @Override
  public SubscriptionDto startSubscription() {
    SubscriptionDto subscriptionCreated = super.startSubscription();
    subscriptionCreated.setType(TYPE);
    subscriptionCreated.setPrice(PRICE);
    
    stateDto = subscriptionCreated;
    return stateDto;
  }
  
  public void applyPersonalDiscount() {
    int oldPrice = stateDto.getPrice();
    int newPrice = oldPrice - (oldPrice * 5) / 100;
    stateDto.setPrice(newPrice);
  }
}
