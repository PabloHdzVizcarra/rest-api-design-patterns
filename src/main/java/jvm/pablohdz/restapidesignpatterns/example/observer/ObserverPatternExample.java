package jvm.pablohdz.restapidesignpatterns.example.observer;

public class ObserverPatternExample {
  public static void main(String[] args) {
    System.out.println("Observer Pattern Example");
  
    ObserverI myObserverOne = new ObserverTypeOne("Roy");
    ObserverI myObserverTwo = new ObserverTypeOne("Kevin");
    ObserverI myObserverThree = new ObserverTypeTwo("Bose");
  
    Subject subject = new Subject();
    
    subject.register(myObserverOne);
    subject.register(myObserverTwo);
    subject.register(myObserverThree);
    
    subject.setFlag(5);
    
    subject.unregister(myObserverOne);
    
    subject.setFlag(50);
    subject.register(myObserverOne);
    
    subject.setFlag(100);
  }
}
