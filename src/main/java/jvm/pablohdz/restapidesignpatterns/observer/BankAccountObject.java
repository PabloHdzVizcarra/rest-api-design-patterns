package jvm.pablohdz.restapidesignpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class BankAccountObject implements BankAccount {
  private final String id;
  private final double balance;
  private final String name;
  private final List<ObserverBank> observers;

  public BankAccountObject(String id, double balance, String name) {
    this.id = id;
    this.balance = balance;
    this.name = name;
    this.observers = new ArrayList<>();
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
    notification.setBalance(balance);
    notification.setNameBankAccount(name);
    notification.setIdBankAccount(id);
    this.observers.forEach(observer -> observer.update(notification));
  }
}
