package jvm.pablohdz.restapidesignpatterns.visitor;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BalanceObjectTest {
  private BalanceObject balanceObject;

  @BeforeEach
  void setUp() {
    balanceObject = new BalanceObject();
  }

  @Test
  void givenBalanceWithThreeSub_whenVisitElements_thenReduceAmount() {
    ArrayList<BalanceElement> balanceElements = new ArrayList<>();
    balanceElements.add(new BalanceElement(10, "cad", 0, 2217713));
    balanceElements.add(new BalanceElement(124, "nok", 0, 2685));
    balanceElements.add(new BalanceElement(67, "gbp", 0, 7254790));
    balanceElements.add(new BalanceElement(1024, "czk", 0, 779902));
    balanceElements.add(new BalanceElement(46, "aud", 0, 1854));
    
    balanceObject.setAvailable(balanceElements);
    balanceObject.verifyAmountsWithDiscount();
    List<VisitorAmountDto> amountsWithDiscountList =  balanceObject.getAmountsWithDiscount();
    
    assertEquals(amountsWithDiscountList.size(), 5);
    assertEquals(amountsWithDiscountList.get(0).getAmount(), 9);
    assertEquals(amountsWithDiscountList.get(1).getAmount(), 112);
    assertEquals(amountsWithDiscountList.get(2).getAmount(), 61);
    assertEquals(amountsWithDiscountList.get(3).getAmount(), 922);
    assertEquals(amountsWithDiscountList.get(4).getAmount(), 42);
  }
  
  @Test
  void givenBalance_whenVisitElementsVerifyDiscountOfTheDay_thenReduceAmountFivePercent() {
    ArrayList<BalanceElement> balanceElements = new ArrayList<>();
    balanceElements.add(new BalanceElement(10, "cad", 0, 2217713));
    balanceElements.add(new BalanceElement(124, "nok", 0, 2685));
    balanceElements.add(new BalanceElement(67, "gbp", 0, 7254790));
    balanceElements.add(new BalanceElement(1024, "czk", 0, 779902));
    balanceElements.add(new BalanceElement(46, "aud", 0, 1854));
  
    balanceObject.setAvailable(balanceElements);
    balanceObject.setCurrenciesWithDiscountOfTheDay(List.of("nok", "aud"));
    balanceObject.verifyAmountsWithDiscountOfTheDay();
    
    List<VisitorAmountDto> amountsWithDiscountList =  balanceObject.getAmountsWithDiscount();

    assertEquals(5, amountsWithDiscountList.size());
    assertEquals("balance", balanceObject.getObject());
    assertEquals(10, amountsWithDiscountList.get(0).getAmount());
    assertEquals(118, amountsWithDiscountList.get(1).getAmount());
    assertEquals(67, amountsWithDiscountList.get(2).getAmount());
    assertEquals(1024, amountsWithDiscountList.get(3).getAmount());
    assertEquals(44, amountsWithDiscountList.get(4).getAmount());
  }

  @Test
  void givenBalance_whenVisitElementsVerifyDiscountOfTheDayTwo_thenReduceAmountFivePercent() {
    ArrayList<BalanceElement> balanceElements = new ArrayList<>();
    balanceElements.add(new BalanceElement(10, "cad", 0, 2217713));
    balanceElements.add(new BalanceElement(124, "nok", 0, 2685));
    balanceElements.add(new BalanceElement(67, "gbp", 0, 7254790));
    balanceElements.add(new BalanceElement(1024, "czk", 0, 779902));
    balanceElements.add(new BalanceElement(46, "aud", 0, 1854));
    
    balanceObject.setAvailable(balanceElements);
    balanceObject.setCurrenciesWithDiscountOfTheDay(List.of("cad", "czk"));
    balanceObject.verifyAmountsWithDiscountOfTheDay();
    
    List<VisitorAmountDto> amountsWithDiscountList =  balanceObject.getAmountsWithDiscount();
    
    assertEquals(amountsWithDiscountList.size(), 5);
    assertEquals(balanceObject.getObject(), "balance");
    assertEquals(amountsWithDiscountList.get(0).getAmount(), 10);
    assertEquals(amountsWithDiscountList.get(1).getAmount(), 124);
    assertEquals(amountsWithDiscountList.get(2).getAmount(), 67);
    assertEquals(amountsWithDiscountList.get(3).getAmount(), 973);
    assertEquals(amountsWithDiscountList.get(4).getAmount(), 46);
  }
}