package jvm.pablohdz.restapidesignpatterns.example.template;

public class Electronics extends BasicEngineering{
  
  @Override
  public void completeSpecialPaper() {
    System.out.println("3. Digital Logic Design");
  }
  
  @Override
  public boolean isAdditionalPapersNeeded() {
    return false;
  }
}
