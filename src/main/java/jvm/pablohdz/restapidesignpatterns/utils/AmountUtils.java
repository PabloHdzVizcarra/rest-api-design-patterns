package jvm.pablohdz.restapidesignpatterns.utils;

public class AmountUtils {

  public static int reduceAmountInPercent(int amount, int percent) {
    return amount - (amount * percent / 100);
  }
}
