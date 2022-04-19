package jvm.pablohdz.restapidesignpatterns.example.bridge;

/** Refined Abstraction */
public class Television extends ElectronicGoods {
  
  public Television(State state) {
    super(state);
  }
}
