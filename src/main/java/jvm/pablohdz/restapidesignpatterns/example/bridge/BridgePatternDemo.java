package jvm.pablohdz.restapidesignpatterns.example.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BridgePatternDemo {
  private static final Logger logger = LoggerFactory.getLogger(BridgePatternDemo.class.getSimpleName());

  public static void main(String[] args) {
    logger.info("Bridge Pattern Demo");
  
    State presentState = new OnState();
    ElectronicGoods eItem = new Television(presentState);
    eItem.moveToCurrentState();
    eItem.hardButtonPressed();
    
    // check off state
    OffState offState = new OffState();
    eItem.setState(offState);
    eItem.moveToCurrentState();
    eItem.hardButtonPressed();
    
    logger.info("dealing with DVD now");
    presentState = new OnState();
    eItem = new DVD(presentState);
    eItem.setState(presentState);
    eItem.moveToCurrentState();
    
    presentState = new OffState();
    (new DVD(presentState)).doublePress();
    ((DVD)eItem).doublePress();
  
  }
}
