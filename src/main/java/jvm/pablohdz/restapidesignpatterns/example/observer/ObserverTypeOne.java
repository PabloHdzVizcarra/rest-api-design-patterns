package jvm.pablohdz.restapidesignpatterns.example.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObserverTypeOne implements ObserverI {
  private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
  String nameOfObserver;
  
  public ObserverTypeOne(String nameOfObserver) {
    this.nameOfObserver = nameOfObserver;
  }
  
  @Override
  public void update(int updatedValue) {
    logger.info("{} has received an alert: Updated myValue in Subject is: {}",
        nameOfObserver, updatedValue);
  }
}
