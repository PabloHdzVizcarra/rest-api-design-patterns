package jvm.pablohdz.restapidesignpatterns.template;

import static jvm.pablohdz.restapidesignpatterns.utils.AmountUtils.getPercent;

public class FewAccidentsInsurance extends BaseInsurance {
  private final InsuranceUser user;
  
  public FewAccidentsInsurance(InsuranceUser user) {
    this.user = user;
    setInsurancePolicy(user.getPolicy());
  }
  
  @Override
  public int calculatePriceRenovationYear() {
    int accidentsInTheYear = user.getNumberOfAccidentsInTheYear();
    return getPercent(baseInsurancePrice, accidentsInTheYear);
  }
  
}
