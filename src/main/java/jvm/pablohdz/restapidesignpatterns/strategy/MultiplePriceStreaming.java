package jvm.pablohdz.restapidesignpatterns.strategy;

public class MultiplePriceStreaming implements PriceStreaming {
  
  @Override
  public double getPrice(int price) {
    return lessPercentage(price);
  }
  
  private double lessPercentage(double price) {
    return price - (price * 0.2);
  }
}
