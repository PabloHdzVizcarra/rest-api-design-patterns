package jvm.pablohdz.restapidesignpatterns.example.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject implements SubjectInterface {
  private int flag;
  List<ObserverI> observerList;
  
  public Subject() {
    this.observerList = new ArrayList<>();
  }
  
  @Override
  public void register(ObserverI observer) {
    observerList.add(observer);
  }
  
  @Override
  public void unregister(ObserverI observer) {
    observerList.remove(observer);
  }
  
  @Override
  public void notifyRegisteredUsers(int notificationValue) {
    observerList.forEach(observer -> observer.update(notificationValue));
  }
  
  public int getFlag() {
    return flag;
  }
  
  public void setFlag(int flag) {
    this.flag = flag;
    notifyRegisteredUsers(flag);
  }
}
