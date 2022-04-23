package jvm.pablohdz.restapidesignpatterns.template;

public abstract class BaseInsurance {
  protected final int baseInsurancePrice = 1000;
  protected int calculatePrice;
  private InsurancePolicy insurancePolicy;

  public int calculateInsuranceRenovationYear() {
    calculatePrice = baseInsurancePrice;
    calculatePrice += calculateYearInflation();
    calculatePrice += calculateTypeOfInsurancePolicy(insurancePolicy);
    calculatePrice += calculatePriceRenovationYear();
    return calculatePrice;
  }

  public abstract int calculatePriceRenovationYear();

  private int calculateTypeOfInsurancePolicy(InsurancePolicy insurancePolicy) {
    int cost;
    switch (insurancePolicy) {
      case BASIC -> cost = 100;
      case MEDIUM -> cost = 400;
      case PREMIUM -> cost = 800;
      default -> throw new IllegalArgumentException("Invalid insurance policy");
    }
    return cost;
  }

  private int calculateYearInflation() {
    return 200;
  }

  public void setInsurancePolicy(InsurancePolicy insurancePolicy) {
    this.insurancePolicy = insurancePolicy;
  }
}
