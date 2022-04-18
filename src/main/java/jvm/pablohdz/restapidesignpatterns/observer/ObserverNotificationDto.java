package jvm.pablohdz.restapidesignpatterns.observer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObserverNotificationDto {
  private NotificationTypeEnum typeNotification;
  private double price;
}
