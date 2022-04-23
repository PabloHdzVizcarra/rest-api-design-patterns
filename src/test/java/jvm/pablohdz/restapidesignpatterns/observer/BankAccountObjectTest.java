package jvm.pablohdz.restapidesignpatterns.observer;

import static org.junit.jupiter.api.Assertions.*;

import jvm.pablohdz.restapidesignpatterns.utils.StringUtils;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BankAccountObjectTest {

  @Test
  void givenBankAccountObject_whenReceiveNotification_thenVerifyCallAllObserversSubscribed() {
    // Arrange
    String id = "ba_" + StringUtils.generateRandomIdWithLength(10);
    BankAccountObject bankAccountObject = new BankAccountObject(id, 100, "Personal Bank Account");

    // Act
    ObserverBankBadAccount observerBankBadAccount = Mockito.spy(new ObserverBankBadAccount());
    observerBankBadAccount.setHistory(MasterBankAccountHistory.getInstance());
    ObserverBankGoodAccount observerBankGoodAccount = Mockito.spy(new ObserverBankGoodAccount());
    observerBankGoodAccount.setHistory(MasterBankAccountHistory.getInstance());

    bankAccountObject.register(observerBankBadAccount);
    bankAccountObject.register(observerBankGoodAccount);

    ObserverNotificationDto notification =
        new ObserverNotificationDto(NotificationTypeEnum.EXPENDITURE, 50);
    bankAccountObject.notifyRegisteredBankAccounts(notification);

    // Assert
    Mockito.verify(observerBankBadAccount, Mockito.times(1)).update(notification);
    Mockito.verify(observerBankGoodAccount, Mockito.times(1)).update(notification);
  }
  
  @Test
  void givenBankAccountObject_whenReceiveNotification_thenVerifyCallAllObserversSubscribedAndVerifyCallBankBadAccount() {
    // Arrange
    String id = "ba_" + StringUtils.generateRandomIdWithLength(10);
    BankAccountObject bankAccountObject = new BankAccountObject(id, 100, "Personal Bank Account");
    ObserverNotificationDto notification =
        new ObserverNotificationDto(NotificationTypeEnum.EXPENDITURE, 50);
  
    // Act
    ObserverBankBadAccount observerBankBadAccount = Mockito.spy(new ObserverBankBadAccount());
    observerBankBadAccount.setHistory(MasterBankAccountHistory.getInstance());
    ObserverBankGoodAccount observerBankGoodAccount = Mockito.spy(new ObserverBankGoodAccount());
    observerBankGoodAccount.setHistory(MasterBankAccountHistory.getInstance());
  
    bankAccountObject.register(observerBankBadAccount);
    bankAccountObject.register(observerBankGoodAccount);
    bankAccountObject.notifyRegisteredBankAccounts(notification);

    // Assert
    Mockito.verify(observerBankBadAccount, Mockito.times(1)).update(notification);
    Mockito.verify(observerBankGoodAccount, Mockito.times(1)).update(notification);
    
    // Act
    bankAccountObject.unregister(observerBankBadAccount);
    bankAccountObject.notifyRegisteredBankAccounts(notification);
    
    // Assert
    Mockito.verify(observerBankBadAccount, Mockito.times(1)).update(notification);
    Mockito.verify(observerBankGoodAccount, Mockito.times(2)).update(notification);
  }

  @Test
  void givenBankAccountWith100Dollars_whenCreateExpenditure_thenSendNotificationToMasterAccount() {
    // Arrange
    String id = "ba_" + StringUtils.generateRandomIdWithLength(10);
    BankAccountObject bankAccountObject = new BankAccountObject(id, 100, "Personal Bank Account");
    ObserverNotificationDto notification =
        new ObserverNotificationDto(NotificationTypeEnum.EXPENDITURE, 50);
    
    // Act
    ObserverBankBadAccount observerBankBadAccount = Mockito.spy(new ObserverBankBadAccount());
    observerBankBadAccount.setHistory(MasterBankAccountHistory.getInstance());
    ObserverBankGoodAccount observerBankGoodAccount = Mockito.spy(new ObserverBankGoodAccount());
    observerBankGoodAccount.setHistory(MasterBankAccountHistory.getInstance());
    bankAccountObject.register(observerBankBadAccount);
    bankAccountObject.register(observerBankGoodAccount);
    bankAccountObject.notifyRegisteredBankAccounts(notification);
  }

  @Test
  void givenBankAccount_whenTwoOperationsPerformed_thenHistoryHaveOperations() {
    // Arrange
    String id = "ba_" + StringUtils.generateRandomIdWithLength(10);
    BankAccountObject bankAccountObject = new BankAccountObject(id, 100, "Personal Bank Account");
    ObserverNotificationDto notification =
        new ObserverNotificationDto(NotificationTypeEnum.EXPENDITURE, 50);
    
    // Act
    ObserverBankBadAccount observerBankBadAccount = Mockito.spy(new ObserverBankBadAccount());
    observerBankBadAccount.setHistory(MasterBankAccountHistory.getInstance());
    ObserverBankGoodAccount observerBankGoodAccount = Mockito.spy(new ObserverBankGoodAccount());
    observerBankGoodAccount.setHistory(MasterBankAccountHistory.getInstance());
    
    bankAccountObject.register(observerBankBadAccount);
    bankAccountObject.register(observerBankGoodAccount);
    bankAccountObject.notifyRegisteredBankAccounts(notification);
    bankAccountObject.notifyRegisteredBankAccounts(notification);
    
    // Assert
    assertEquals(4, MasterBankAccountHistory.getHistoryById(id).size());
    // must be greater than one because each test generate operations
    assertEquals(3, MasterBankAccountHistory.getIdsOperations().size());
    Mockito.verify(observerBankBadAccount, Mockito.times(2)).update(notification);
    Mockito.verify(observerBankGoodAccount, Mockito.times(2)).update(notification);
  }

  @Test
  void givenBankAccountWithOneHundredDollars_whenExpenditureOfSixteenDollars_thenSendYellowNotification() {
    // Arrange
    String id = "ba_" + StringUtils.generateRandomIdWithLength(10);
    BankAccountObject bankAccountObject = new BankAccountObject(id, 100, "Personal Bank Account");
    ObserverNotificationDto notification =
        new ObserverNotificationDto(NotificationTypeEnum.EXPENDITURE, 60);
    
    // Act
    ObserverBankBadAccount observerBankBadAccount = Mockito.spy(new ObserverBankBadAccount());
    observerBankBadAccount.setHistory(MasterBankAccountHistory.getInstance());
    ObserverBankGoodAccount observerBankGoodAccount = Mockito.spy(new ObserverBankGoodAccount());
    observerBankGoodAccount.setHistory(MasterBankAccountHistory.getInstance());
    
    bankAccountObject.register(observerBankBadAccount);
    bankAccountObject.register(observerBankGoodAccount);
    bankAccountObject.notifyRegisteredBankAccounts(notification);
    
    // Assert
    Mockito.verify(observerBankBadAccount, Mockito.times(1)).update(notification);
    Mockito.verify(observerBankGoodAccount, Mockito.times(1)).update(notification);
    assertEquals(2, MasterBankAccountHistory.getHistoryById(id).size());
  
  }
}
