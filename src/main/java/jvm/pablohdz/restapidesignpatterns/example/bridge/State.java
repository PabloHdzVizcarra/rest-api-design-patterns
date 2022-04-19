package jvm.pablohdz.restapidesignpatterns.example.bridge;

/** Is the Implementor */
public interface State {
  void moveState();
  
  void hardPressed();
}
