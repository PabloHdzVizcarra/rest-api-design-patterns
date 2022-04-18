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
    ObserverBankGoodAccount observerBankGoodAccount = Mockito.spy(new ObserverBankGoodAccount());

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
    ObserverBankGoodAccount observerBankGoodAccount = Mockito.spy(new ObserverBankGoodAccount());
  
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
    ObserverBankGoodAccount observerBankGoodAccount = Mockito.spy(new ObserverBankGoodAccount());
    bankAccountObject.register(observerBankBadAccount);
    bankAccountObject.register(observerBankGoodAccount);
    bankAccountObject.notifyRegisteredBankAccounts(notification);
    
    // Assert
  }
}
