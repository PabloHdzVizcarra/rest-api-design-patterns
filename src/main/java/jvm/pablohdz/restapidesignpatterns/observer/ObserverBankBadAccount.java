package jvm.pablohdz.restapidesignpatterns.observer;

public class ObserverBankBadAccount implements ObserverBank {
  private MasterBankAccountHistory history;

  public void setHistory(MasterBankAccountHistory history) {
    this.history = history;
  }

  @Override
  public void update(ObserverNotificationDto notification) {
    OperationDto operationDto =
        new OperationDto("EXPENDITURE", notification.getPrice(), NotificationTypeEnum.EXPENDITURE);
    history.setOperationById(notification.getIdBankAccount(), operationDto);
  }
}
