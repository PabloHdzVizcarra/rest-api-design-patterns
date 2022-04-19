package jvm.pablohdz.restapidesignpatterns.example.flyweight;

import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlyweightPatternExample {
  private static final Logger logger = LoggerFactory.getLogger(FlyweightPatternExample.class.getSimpleName());

  public static void main(String[] args) throws InterruptedException {
    RobotFactory robotFactory = new RobotFactory();
    System.out.println("Flyweight pattern example");
    
    Robot myRobot;

    for (int i = 0; i < 3; i++) {
      myRobot = RobotFactory.getRobotFromFactory("small");
      
      Thread.sleep(1000);
      myRobot.showMe(getRandomColor());
    }
    int numOfDistinctRobots = robotFactory.totalObjectsCreated();
    logger.info("Till now, total no of distinct robot objects created: {}", numOfDistinctRobots);

    for (int i = 0; i < 5; i++) {
      myRobot = RobotFactory.getRobotFromFactory("large");
  
      Thread.sleep(1000);
      myRobot.showMe(getRandomColor());
    }
    numOfDistinctRobots = robotFactory.totalObjectsCreated();
    logger.info("Till now, total no of distinct robot objects created: {}", numOfDistinctRobots);

    for (int i = 0; i < 4; i++) {
      myRobot = RobotFactory.getRobotFromFactory("fixed");
      Thread.sleep(1000);
      myRobot.showMe(getRandomColor());
    }
  
    numOfDistinctRobots = robotFactory.totalObjectsCreated();
    logger.info("Till now, total no of distinct robot objects created: {}", numOfDistinctRobots);
  }
  
  private static String getRandomColor() {
    Random random = new Random();
    int randomNext = random.nextInt();
    if (randomNext % 2 == 0) {
      return "red";
    } else {
      return "green";
    }
  }
}
