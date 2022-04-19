package jvm.pablohdz.restapidesignpatterns.example.flyweight;

public class LargeRobot implements Robot {
  // this is an intrinsic state
  private final String robotTypeCreated;

  public LargeRobot() {
    this.robotTypeCreated = "Large Robot";
    System.out.println(robotTypeCreated);
  }

  @Override
  public void showMe(String color) {
    System.out.println("I am a " + robotTypeCreated + " and my color is " + color);
  }
}
