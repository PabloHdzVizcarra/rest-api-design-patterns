package jvm.pablohdz.restapidesignpatterns.example.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Is the Abstraction */
abstract class ElectronicGoods {
  private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
  protected State state;
  
  public ElectronicGoods(State state) {
    this.state = state;
  }
  
  public State getState() {
    return state;
  }
  
  public void setState(State state) {
    this.state = state;
  }
  
  public void moveToCurrentState() {
    logger.info("The electronic items is functioning at: ");
    state.moveState();
  }
  
  public void hardButtonPressed() {
    logger.info("The hard button was pressed");
    state.hardPressed();
  }
}
