package jvm.pablohdz.restapidesignpatterns.example.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Concrete Implementor or State */
public class OnState implements State {
  private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

  @Override
  public void moveState() {
    logger.info("On State");
  }
  
  @Override
  public void hardPressed() {
    logger.info("The device is already On. not press the button so hard.");
  }
}
