package jvm.pablohdz.restapidesignpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class BankAccountObject implements BankAccount {
  private final String id;
  private final double balance;
  private final String name;
  private List<OperationDto> operationsHistory;
  private List<ObserverBank> observers;

  public BankAccountObject(String id, double balance, String name) {
    this.id = id;
    this.balance = balance;
    this.name = name;
    this.observers = new ArrayList<>();
    this.operationsHistory = new ArrayList<>();
  }

  @Override
  public void register(ObserverBank observer) {
    this.observers.add(observer);
  }

  @Override
  public void unregister(ObserverBank observer) {
    this.observers.remove(observer);
  }

  @Override
  public void notifyRegisteredBankAccounts(ObserverNotificationDto notification) {
    this.observers.forEach(observer -> observer.update(notification));
  }
}
