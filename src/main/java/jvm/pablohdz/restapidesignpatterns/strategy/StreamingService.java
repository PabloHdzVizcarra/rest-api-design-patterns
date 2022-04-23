package jvm.pablohdz.restapidesignpatterns.strategy;

public abstract class StreamingService {
  protected final int PRICE_STREAMING_SERVICE = 1000;
  protected PriceStreaming priceStreaming;
  
  public StreamingService() {
  }
  
  public void setPriceStreaming(PriceStreaming priceStreaming) {
    this.priceStreaming = priceStreaming;
  }
  
  public double getPrice() {
    return priceStreaming.getPrice(PRICE_STREAMING_SERVICE);
  }
  
  public int commonPrice() {
    return PRICE_STREAMING_SERVICE;
  }
  
  public abstract String serviceName();
}
