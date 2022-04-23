package jvm.pablohdz.restapidesignpatterns.strategy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StreamingServiceTest {

  @Test
  void givenNetflixService_whenCalculatePrice_thenReturnWithDiscount() {
    NetflixService netflixService = new NetflixService();
  
    String serviceName = netflixService.serviceName();
    double priceNetflix = netflixService.getPrice();
    int commonPrice = netflixService.commonPrice();
  
    assertEquals("Netflix", serviceName);
    assertEquals(300.0, priceNetflix);
    assertEquals(1000, commonPrice);
  }
  
  @Test
  void givenSpotifyService_whenCalculatePrice_thenReturnWithDiscount() {
    SpotifyService spotifyService = new SpotifyService();
  
    String serviceName = spotifyService.serviceName();
    double priceSpotify = spotifyService.getPrice();
    int commonPrice = spotifyService.commonPrice();
  
    assertEquals("Spotify", serviceName);
    assertEquals(200.0, priceSpotify);
    assertEquals(1000, commonPrice);
  }

  @Test
  void givenTotalPlayService_whenCalculatePrice_thenReturnWithDiscount() {
    TotalPlayService totalPlayService = new TotalPlayService();
  
    String serviceName = totalPlayService.serviceName();
    double priceTotalPlay = totalPlayService.getPrice();
    int commonPrice = totalPlayService.commonPrice();
  
    assertEquals("TotalPlay", serviceName);
    assertEquals(800.0, priceTotalPlay);
    assertEquals(1000, commonPrice);
  
    AudioPriceStreaming audioPriceStreaming = new AudioPriceStreaming();
    totalPlayService.setPriceStreaming(audioPriceStreaming);
    
    assertEquals(200.0, totalPlayService.getPrice());
    assertEquals("TotalPlay", serviceName);
    assertEquals(1000, commonPrice);
  }
}