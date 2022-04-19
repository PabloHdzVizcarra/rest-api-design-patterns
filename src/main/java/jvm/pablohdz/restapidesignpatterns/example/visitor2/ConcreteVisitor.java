package jvm.pablohdz.restapidesignpatterns.example.visitor2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConcreteVisitor implements Visitor {
  private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

  @Override
  public void visitTheElement(CompositeEmployee employees) {
    // Promote them if experience is greater than 15 years
    boolean eligibleForPromotion = employees.getYearsOfExperience() > 15;
    logger.info("{} from {} is eligible for promotion? {}",
        employees.getName(), employees.getDepartment(), eligibleForPromotion);
  
  }
  
  @Override
  public void visitTheElement(SimpleEmployee employee) {
    // Promote them if experience is greater than 12 years
    boolean eligibleForPromotion = employee.getYearsOfExperience() > 12;
    logger.info("{} from {} is eligible for promotion? {}",
        employee.getName(), employee.getDepartment(), eligibleForPromotion);
  }
}
