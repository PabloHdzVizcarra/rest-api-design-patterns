package jvm.pablohdz.restapidesignpatterns.model;

import static org.junit.jupiter.api.Assertions.*;

import jvm.pablohdz.restapidesignpatterns.bridge.EnterpriseSubscriptionBridge;
import jvm.pablohdz.restapidesignpatterns.bridge.PauseSubscriptionState;
import jvm.pablohdz.restapidesignpatterns.bridge.PersonalSubscriptionBridge;
import jvm.pablohdz.restapidesignpatterns.bridge.StartSubscriptionState;
import jvm.pablohdz.restapidesignpatterns.bridge.SubscriptionDto;
import jvm.pablohdz.restapidesignpatterns.exception.SubscriptionPersonalNotPaused;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SubscriptionAbstractionBridgeTest {

  public static final int PRICE_ZERO = 0;
  public static final int ENTERPRISE_PRICE_SUBSCRIPTION = 1000;
  private PersonalSubscriptionBridge personalSubscription;
  private EnterpriseSubscriptionBridge enterpriseSubscription;

  @BeforeEach
  void setUp() {
    personalSubscription = new PersonalSubscriptionBridge(new StartSubscriptionState());
    enterpriseSubscription = new EnterpriseSubscriptionBridge(new StartSubscriptionState());
  }

  @Test
  void subscriptionStartTest() {
    SubscriptionDto subscriptionStartDto = personalSubscription.startSubscription();

    assertEquals(subscriptionStartDto.getType(), "Personal");
    assertNotNull(subscriptionStartDto.getId());
    assertFalse(subscriptionStartDto.getUpdatedAt() > System.currentTimeMillis());
    assertEquals(100, subscriptionStartDto.getPrice());
  }

  @Test
  void givenValidSubscription_whenPause_thenPauseSubscriptionOK() {
    SubscriptionDto subscriptionStartDto = personalSubscription.startSubscription();

    assertEquals(subscriptionStartDto.getType(), "Personal");
    assertNotNull(subscriptionStartDto.getId());
    assertEquals(100, subscriptionStartDto.getPrice());

    SubscriptionDto subscriptionStateDto = personalSubscription.pauseSubscription();
    assertTrue(subscriptionStateDto.isPaused());
  }

  @Test
  void givenPersonalSubscription_whenApplyPersonalDiscount_thenReducePrice() {
    SubscriptionDto subscriptionStartDto = personalSubscription.startSubscription();

    assertEquals(subscriptionStartDto.getType(), "Personal");
    assertNotNull(subscriptionStartDto.getId());
    assertEquals(100, subscriptionStartDto.getPrice());

    SubscriptionDto subscriptionStateDto = personalSubscription.pauseSubscription();
    assertTrue(subscriptionStateDto.isPaused());

    int oldPrice = subscriptionStateDto.getPrice();

    personalSubscription.applyPersonalDiscount();

    assertTrue(oldPrice > subscriptionStateDto.getPrice());
  }

  @Test
  void givenPersonalSubscription_whenApplyStatePaused_thenPausedSubscriptionAndStopPrice() {
    SubscriptionDto subscriptionStartDto = personalSubscription.startSubscription();

    assertEquals(subscriptionStartDto.getType(), "Personal");
    assertNotNull(subscriptionStartDto.getId());
    assertEquals(100, subscriptionStartDto.getPrice());

    PauseSubscriptionState pauseSubscriptionState = new PauseSubscriptionState();
    personalSubscription.setState(pauseSubscriptionState);

    SubscriptionDto subscriptionStateDto = personalSubscription.pauseSubscription();

    int actualPrice = subscriptionStateDto.getPrice();
    boolean actualIsPaused = subscriptionStateDto.isPaused();
    boolean actualIsStart = subscriptionStateDto.isStart();

    assertEquals(0, actualPrice);
    assertTrue(actualIsPaused);
    assertTrue(actualIsStart);
  }

  @Test
  void givenPersonalSubscriptionPaused_whenTryResume_thenResumeTheSubscriptionAndPrice() {
    personalSubscription.startSubscription();
    PauseSubscriptionState pauseSubscriptionState = new PauseSubscriptionState();
    personalSubscription.setState(pauseSubscriptionState);
    personalSubscription.pauseSubscription();
    SubscriptionDto subscriptionResume = personalSubscription.resumeSubscription();

    assertFalse(subscriptionResume.isPaused());
    assertTrue(subscriptionResume.isStart());
  }

  @Test
  void givenPersonalSubscriptionNotPaused_whenTryResume_thenThrowException() {
    personalSubscription.startSubscription();

    assertThrows(
        SubscriptionPersonalNotPaused.class, () -> personalSubscription.resumeSubscription());
  }

  @Test
  void givenEnterpriseSubscription_thenCreateOk() {
    SubscriptionDto subscriptionCreated = enterpriseSubscription.startSubscription();
    int actualPrice = subscriptionCreated.getPrice();
    String actualType = subscriptionCreated.getType();
    
    assertEquals(ENTERPRISE_PRICE_SUBSCRIPTION, actualPrice);
    assertEquals("Enterprise", actualType);
  }
  
  @Test
  void givenEnterpriseSubscription_whenApplyEnterpriseDiscount_thenReducePrice() {
    SubscriptionDto subscriptionCreated = enterpriseSubscription.startSubscription();
    int oldPrice = subscriptionCreated.getPrice();
  
    SubscriptionDto enterpriseSubscription = this.enterpriseSubscription.applyEnterpriseDiscount();
    int actualPrice = enterpriseSubscription.getPrice();
  
    assertTrue(oldPrice > actualPrice);
  }
}
