package jvm.pablohdz.restapidesignpatterns.observer;

public class ObserverBankGoodAccount implements ObserverBank {
  private MasterBankAccountHistory history;
  
  public void setHistory(MasterBankAccountHistory history) {
    this.history = history;
  }
  @Override
  public void update(ObserverNotificationDto notification) {
    OperationDto operationDto =
        new OperationDto("Good Account", notification.getTypeNotification(), HistoryTypeNotification.GREEN_NOTIFICATION);
    history.setOperationById(notification.getIdBankAccount(), operationDto);
  }
}
