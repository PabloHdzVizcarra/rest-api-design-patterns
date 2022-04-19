package jvm.pablohdz.restapidesignpatterns.example.flyweight;

public class FixedSizeRobot implements Robot {
  private final String robotTypeCreated;

  public FixedSizeRobot() {
    this.robotTypeCreated = "FixedSizeRobot";
    System.out.println("Robot created: " + this.robotTypeCreated);
  }

  @Override
  public void showMe(String color) {
    System.out.println(" with " + " blue (default) color");
  }
  
}
