package jvm.pablohdz.restapidesignpatterns.example.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Concrete Implementor or State */
public class OffState implements State {
  private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

  @Override
  public void moveState() {
    logger.info("Off State");
  }
  
  @Override
  public void hardPressed() {
    logger.info("The device is in Off State");
  }
}
