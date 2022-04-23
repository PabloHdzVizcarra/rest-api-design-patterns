package jvm.pablohdz.restapidesignpatterns.template;

import static jvm.pablohdz.restapidesignpatterns.utils.AmountUtils.getPercent;

public class SomeAccidentsInsurance extends BaseInsurance {
  private final InsuranceUser user;

  public SomeAccidentsInsurance(InsuranceUser user) {
    this.user = user;
    setInsurancePolicy(user.getPolicy());
  }
  
  @Override
  public int calculatePriceRenovationYear() {
    int accidentsInTheYear = user.getNumberOfAccidentsInTheYear();
    accidentsInTheYear = plusAccidents(accidentsInTheYear);
    return getPercent(baseInsurancePrice, accidentsInTheYear);
  }
  
  private int plusAccidents(int accidentsInTheYear) {
    accidentsInTheYear += 20;
    return accidentsInTheYear;
  }
}
