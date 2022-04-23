package jvm.pablohdz.restapidesignpatterns.observer;

import jvm.pablohdz.restapidesignpatterns.utils.AmountUtils;

public class ObserverBankBadAccount implements ObserverBank {
  private MasterBankAccountHistory history;

  public void setHistory(MasterBankAccountHistory history) {
    this.history = history;
  }

  @Override
  public void update(ObserverNotificationDto notification) {
    if (notification.getPrice() > AmountUtils.getPercent(notification.getPrice(), 50)) {
      OperationDto operationDto = new OperationDto();
      operationDto.setMessage("your account is in warning state");
      operationDto.setType(HistoryTypeNotification.YELLOW_NOTIFICATION);
      operationDto.setNotificationType(notification.getTypeNotification());
      history.setOperationById(notification.getIdBankAccount(), operationDto);
    }
  }
}
