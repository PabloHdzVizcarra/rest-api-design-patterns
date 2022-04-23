package jvm.pablohdz.restapidesignpatterns.example.strategy;

public class StrategyPatternExample {
  public static void main(String[] args) {
    System.out.println("*** Strategy Pattern Demo ***");
    Vehicle vehicleContext = new Boat();
    vehicleContext.showMe();
    vehicleContext.showTransportMedium();
    vehicleContext.commonJob();
    System.out.println("____________________________");
    
    vehicleContext = new Aeroplane();
    vehicleContext.showMe();
    vehicleContext.showTransportMedium();
    vehicleContext.commonJob();
    
    System.out.println("____________________________");
    
    vehicleContext = new SpecialVehicle();
    vehicleContext.showMe();
    vehicleContext.showTransportMedium();
    vehicleContext.commonJob();
    System.out.println("____________________________");

    vehicleContext.setTransportMedium(new WaterTransport());
    vehicleContext.showMe();
    vehicleContext.showTransportMedium();
    vehicleContext.commonJob();
  }
}
