package jvm.pablohdz.restapidesignpatterns.strategy;

public class VideoPriceStreaming implements PriceStreaming {
  
  @Override
  public double getPrice(int price) {
    return lessPercent(price);
  }
  
  private double lessPercent(int price) {
    return price - (price * 0.7);
  }
}
