package jvm.pablohdz.restapidesignpatterns.example.flyweight;

import java.util.HashMap;
import java.util.Map;

public class RobotFactory {
  static Map<String, Robot> robotFactory = new HashMap<>();

  public int totalObjectsCreated() {
    return robotFactory.size();
  }

  public static synchronized Robot getRobotFromFactory(String robotType) {
    Robot robotCategory = robotFactory.get(robotType);

    if (robotCategory == null) {
      switch (robotType) {
        case "small":
          System.out.println("we do not have small robot at present");
          robotCategory = new SmallRobot();
          break;

        case "large":
          System.out.println("we do not have large robot at present");
          robotCategory = new LargeRobot();
          break;

        case "fixed":
          System.out.println("we do not have fixed robot at present");
          robotCategory = new FixedSizeRobot();
          break;
        default:
          throw new RuntimeException("Robot factory can create only small, large or fixed size "
              + "robots");
      }
      robotFactory.put(robotType, robotCategory);
    } else {
      System.out.println("we have " + robotType + " robot at present");
    }

    return robotCategory;
  }
}
