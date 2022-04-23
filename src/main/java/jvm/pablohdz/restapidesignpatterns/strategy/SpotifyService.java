package jvm.pablohdz.restapidesignpatterns.strategy;

public class SpotifyService extends StreamingService{
  
  public SpotifyService() {
    this.priceStreaming = new AudioPriceStreaming();
  }
  
  @Override
  public String serviceName() {
    return "Spotify";
  }
}
