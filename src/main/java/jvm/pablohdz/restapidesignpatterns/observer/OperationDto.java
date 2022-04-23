package jvm.pablohdz.restapidesignpatterns.observer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationDto {
  private String message;
  private NotificationTypeEnum notificationType;
  private HistoryTypeNotification type;
}
