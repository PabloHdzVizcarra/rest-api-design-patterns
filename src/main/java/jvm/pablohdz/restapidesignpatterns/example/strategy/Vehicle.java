package jvm.pablohdz.restapidesignpatterns.example.strategy;

public abstract class Vehicle {
  // A context object contains references to the strategy objects
  TransportMedium transportMedium;

  public Vehicle() {}

  public void showTransportMedium() {
    // Delegate the task to the corresponding strategy object
    transportMedium.transport();
  }

  // The code that does not vary
  public void commonJob() {
    System.out.println("We all can be used to transport");
  }

  // Each strategy object has its own implementation of the method
  public abstract void showMe();

  public void setTransportMedium(TransportMedium transportMedium) {
    this.transportMedium = transportMedium;
  }
}
