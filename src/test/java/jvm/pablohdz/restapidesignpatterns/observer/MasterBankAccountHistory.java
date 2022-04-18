package jvm.pablohdz.restapidesignpatterns.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MasterBankAccountHistory {
  private static MasterBankAccountHistory masterBankAccount;
  private static Map<String, List<OperationDto>> operationsHistory;
  
  private MasterBankAccountHistory() {
    operationsHistory = new HashMap<>();
  }
  
  public static MasterBankAccountHistory getInstance() {
    if (masterBankAccount == null) {
      masterBankAccount = new MasterBankAccountHistory();
      operationsHistory = new HashMap<>();
    }
    return masterBankAccount;
  }
  
  public static void setOperationById(String id, OperationDto operation) {
    createListIfNotExists(id);
    operationsHistory.get(id).add(operation);
  }
  
  private static void createListIfNotExists(String id) {
    if (!operationsHistory.containsKey(id)) {
      operationsHistory.put(id, new ArrayList<>());
    }
  }
  
  public static List<OperationDto> getHistoryById(String id) {
    return operationsHistory.get(id);
  }
}
