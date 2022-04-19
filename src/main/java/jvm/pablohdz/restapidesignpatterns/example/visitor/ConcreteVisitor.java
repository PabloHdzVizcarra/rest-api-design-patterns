package jvm.pablohdz.restapidesignpatterns.example.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConcreteVisitor implements Visitor {
  private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

  @Override
  public void visit(MyClass myClassObject) {
    logger.info("Current value of myInt: {}", myClassObject.getMyInt());
    logger.info("Visitor will make it double and display it");
    logger.info("New value of myInt: {}", myClassObject.getMyInt() * 2);
    
    logger.info("End of visit");
  }
}
