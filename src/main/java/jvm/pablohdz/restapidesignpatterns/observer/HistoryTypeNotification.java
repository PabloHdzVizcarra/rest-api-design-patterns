package jvm.pablohdz.restapidesignpatterns.observer;

/**
 * Type of notifications sent for the history.
 * */
public enum HistoryTypeNotification {
  GREEN_NOTIFICATION("GREEN_NOTIFICATION"),
  YELLOW_NOTIFICATION("YELLOW_NOTIFICATION"),
  RED_NOTIFICATION("RED_NOTIFICATION");

  private final String value;

  HistoryTypeNotification(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public HistoryTypeNotification getNotification(String value) {
    for (HistoryTypeNotification notification : HistoryTypeNotification.values()) {
      if (notification.getValue().equals(value)) {
        return notification;
      }
    }
    throw new IllegalArgumentException("Invalid notification type: " + value);
  }
}
