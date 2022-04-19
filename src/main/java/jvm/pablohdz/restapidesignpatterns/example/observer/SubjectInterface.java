package jvm.pablohdz.restapidesignpatterns.example.observer;

public interface SubjectInterface {
  void register(ObserverI observer);

  void unregister(ObserverI observer);

  void notifyRegisteredUsers(int notificationValue);
}
