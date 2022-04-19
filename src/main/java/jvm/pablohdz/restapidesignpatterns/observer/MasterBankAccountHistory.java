package jvm.pablohdz.restapidesignpatterns.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
  
  public void setOperationById(String id, OperationDto operation) {
    createListIfNotExists(id);
    operationsHistory.get(id).add(operation);
  }
  
  private void createListIfNotExists(String id) {
    if (!operationsHistory.containsKey(id)) {
      operationsHistory.put(id, new ArrayList<>());
    }
  }
  
  public static List<OperationDto> getHistoryById(String id) {
    return operationsHistory.get(id);
  }
  
  public static Set<String> getIdsOperations() {
    return operationsHistory.keySet();
  }
  
}
