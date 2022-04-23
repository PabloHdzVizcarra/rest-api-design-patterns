package jvm.pablohdz.restapidesignpatterns.strategy;

public class NetflixService extends StreamingService {
  
  public NetflixService() {
    priceStreaming = new VideoPriceStreaming();
  }
  
  @Override
  public String serviceName() {
    return "Netflix";
  }
}
