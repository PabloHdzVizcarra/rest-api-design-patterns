package jvm.pablohdz.restapidesignpatterns.utils;

public class AmountUtils {

  public static int reduceAmountInPercent(int amount, int percent) {
    return amount - (amount * percent / 100);
  }
  
  public static int getPercent(int amount, int percent) {
    return amount * percent / 100;
  }
  
  public static int getPercent(double amount, int percent) {
    return (int) (amount * percent / 100);
  }
}
