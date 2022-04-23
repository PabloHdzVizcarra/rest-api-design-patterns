package jvm.pablohdz.restapidesignpatterns.strategy;

public class TotalPlayService extends StreamingService{
  
  public TotalPlayService() {
    this.priceStreaming = new MultiplePriceStreaming();
  }
  
  @Override
  public String serviceName() {
    return "TotalPlay";
  }
}
