package jvm.pablohdz.restapidesignpatterns.example.flyweight;

public class SmallRobot implements Robot {
  private final String robotTypeCreated;

  public SmallRobot() {
    this.robotTypeCreated = "A small robot created";
    System.out.println(robotTypeCreated);
  }

  @Override
  public void showMe(String color) {
    System.out.println("I am a small robot and my color is " + color);
  }
}
