package jvm.pablohdz.restapidesignpatterns.example.template;

public abstract class BasicEngineering {
  public final void completeCourse() {
    // the course must be completed in order to pass
    // 1. Math
    // 2. Soft Skills
    // 3. Special Paper
    completeMath();
    completeSoftSkills();
    completeSpecialPaper();
    
    if (isAdditionalPapersNeeded()) {
      completeAdditionalPapersHook();
    }
  }
  
  public abstract void completeSpecialPaper();
  
  private void completeSoftSkills() {
    System.out.println("2. Soft Skills");
  }
  
  private void completeMath() {
    System.out.println("1. Mathematics");
  }
  
  public void completeAdditionalPapersHook() {
    System.out.println("4. Additional Papers are needed for this course.");
  }

  /**
   * This method act how a hook, all children can be overridden this method
   *
   * @return true if additional papers are needed
   */
  public boolean isAdditionalPapersNeeded() {
    return true;
  }
}
