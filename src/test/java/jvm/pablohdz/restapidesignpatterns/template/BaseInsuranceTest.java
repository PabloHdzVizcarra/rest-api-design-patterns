package jvm.pablohdz.restapidesignpatterns.template;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BaseInsuranceTest {

  public static final InsuranceUser USER_FIVE_ACCIDENTS_POLICY_BASIC =
      new InsuranceUser("Tony", 5, InsurancePolicy.BASIC);

  public static final InsuranceUser USER_TEN_ACCIDENTS_POLICY_BASIC =
      new InsuranceUser("Tony", 10, InsurancePolicy.BASIC);

  public static final InsuranceUser USER_TEN_ACCIDENTS_POLICY_MEDIUM =
      new InsuranceUser("Tony", 10, InsurancePolicy.MEDIUM);

  public static final InsuranceUser USER_TEN_ACCIDENTS_POLICY_PREMIUM =
      new InsuranceUser("Tony", 10, InsurancePolicy.PREMIUM);
  
  public static final InsuranceUser USER_FIFTEEN_ACCIDENTS_POLICY_BASIC =
      new InsuranceUser("Tony", 15, InsurancePolicy.BASIC);
  
  public static final InsuranceUser USER_FIFTEEN_ACCIDENTS_POLICY_MEDIUM =
      new InsuranceUser("Tony", 15, InsurancePolicy.MEDIUM);
  
  public static final InsuranceUser USER_FIFTEEN_ACCIDENTS_POLICY_PREMIUM =
      new InsuranceUser("Tony", 15, InsurancePolicy.PREMIUM);
  
  @Test
  void givenUserWithFiveAccidentsInTheYear_whenCalculatePriceInsurance() {
    // Arrange
    BaseInsurance fewAccidentsInsurance =
        new FewAccidentsInsurance(USER_FIVE_ACCIDENTS_POLICY_BASIC);

    // Act
    int priceRenovation = fewAccidentsInsurance.calculateInsuranceRenovationYear();

    // Assert
    assertEquals(1350, priceRenovation);
  }

  @Test
  void givenUserWithSomeAccidentsInTheYear_whenCalculatePrice() {
    // Arrange
    BaseInsurance someAccidentsInsurance =
        new SomeAccidentsInsurance(USER_TEN_ACCIDENTS_POLICY_BASIC);

    // Act
    int priceRenovation = someAccidentsInsurance.calculateInsuranceRenovationYear();

    // Assert
    assertEquals(1600, priceRenovation);
  }

  @Test
  void givenUserWithSomeAccidentsInTheYearMediumPolicy_whenCalculatePrice() {
    // Arrange
    BaseInsurance someAccidentsInsurance =
        new SomeAccidentsInsurance(USER_TEN_ACCIDENTS_POLICY_MEDIUM);

    // Act
    int priceRenovation = someAccidentsInsurance.calculateInsuranceRenovationYear();

    // Assert
    assertEquals(1900, priceRenovation);
  }

  @Test
  void givenUserWithSomeAccidentsInTheYearPremiumPolicy_whenCalculatePrice() {
    // Arrange
    BaseInsurance someAccidentsInsurance =
        new SomeAccidentsInsurance(USER_TEN_ACCIDENTS_POLICY_PREMIUM);

    // Act
    int priceRenovation = someAccidentsInsurance.calculateInsuranceRenovationYear();

    // Assert
    assertEquals(2300, priceRenovation);
  }

  @Test
  void givenUserWithHighAccidentsInTheYear_whenCalculatePrice() {
    // Arrange
    BaseInsurance highAccidentsInsurance =
        new HighAccidentsInsurance(USER_FIFTEEN_ACCIDENTS_POLICY_BASIC);

    // Act
    int priceRenovation = highAccidentsInsurance.calculateInsuranceRenovationYear();

    // Assert
    assertEquals(1950, priceRenovation);
  }
  
  @Test
  void givenUserWithHighAccidentsInTheYearMediumPolicy_whenCalculatePrice() {
    // Arrange
    BaseInsurance highAccidentsInsurance =
        new HighAccidentsInsurance(USER_FIFTEEN_ACCIDENTS_POLICY_MEDIUM);

    // Act
    int priceRenovation = highAccidentsInsurance.calculateInsuranceRenovationYear();

    // Assert
    assertEquals(2250, priceRenovation);
  }
  
  @Test
  void givenUserWithHighAccidentsInTheYearPremiumPolicy_whenCalculatePrice() {
    // Arrange
    BaseInsurance highAccidentsInsurance =
        new HighAccidentsInsurance(USER_FIFTEEN_ACCIDENTS_POLICY_PREMIUM);

    // Act
    int priceRenovation = highAccidentsInsurance.calculateInsuranceRenovationYear();

    // Assert
    assertEquals(2650, priceRenovation);
  }
}
