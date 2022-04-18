package jvm.pablohdz.restapidesignpatterns.observer;

public interface BankAccount {
  void register(ObserverBank observer);

  void unregister(ObserverBank observer);

  void notifyRegisteredBankAccounts(ObserverNotificationDto notification);
}
