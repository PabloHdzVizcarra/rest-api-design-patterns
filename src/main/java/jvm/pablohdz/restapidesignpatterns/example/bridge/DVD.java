package jvm.pablohdz.restapidesignpatterns.example.bridge;

/** Refined Abstraction */
public class DVD extends ElectronicGoods {
  
  public DVD(State state) {
    super(state);
  }
  
  public void doublePress() {
    hardButtonPressed();
    hardButtonPressed();
  }
}
