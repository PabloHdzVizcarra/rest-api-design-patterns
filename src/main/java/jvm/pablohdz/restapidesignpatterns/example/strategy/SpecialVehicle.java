package jvm.pablohdz.restapidesignpatterns.example.strategy;

public class SpecialVehicle extends Vehicle {
  
  public SpecialVehicle() {
    
    // Initialize with AirTransportStrategy
    transportMedium = new AirTransport();
  }
  
  @Override
  public void showMe() {
    System.out.println("I'm a special vehicle who can transport both in air and water");
  }
}
