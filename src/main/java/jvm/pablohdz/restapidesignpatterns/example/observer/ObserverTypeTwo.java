package jvm.pablohdz.restapidesignpatterns.example.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObserverTypeTwo implements ObserverI {
  private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
  String nameOfObserver;
  
  public ObserverTypeTwo(String nameOfObserver) {
    this.nameOfObserver = nameOfObserver;
  }
  
  @Override
  public void update(int updatedValue) {
     logger.info("Observer {} has been notified of the update {}", nameOfObserver, updatedValue);
  }
}
