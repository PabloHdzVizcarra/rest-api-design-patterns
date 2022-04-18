package jvm.pablohdz.restapidesignpatterns.observer;

public enum NotificationTypeEnum {
  EXPENDITURE("Expenditure"),
  INCOME  ("Income"),
  TRANSFER ("Transfer");

  private final String description;

  NotificationTypeEnum(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
  
  public static NotificationTypeEnum getEnum(String description) {
    for (NotificationTypeEnum e : values()) {
      if (e.getDescription().equalsIgnoreCase(description)) {
        return e;
      }
    }
    throw new IllegalArgumentException("No enum with description " + description);
  }

}
