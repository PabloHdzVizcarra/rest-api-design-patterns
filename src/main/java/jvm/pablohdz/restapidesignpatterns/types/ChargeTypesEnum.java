package jvm.pablohdz.restapidesignpatterns.types;

public enum ChargeTypesEnum {
  DEBIT("DEBIT"),
  CASH("CASH");
  
  private final String type;
  
  ChargeTypesEnum(String type) {
    this.type = type;
  }
  
  public static ChargeTypesEnum valueOfType(String type) {
    for (ChargeTypesEnum e: values()) {
      if (e.type.equalsIgnoreCase(type)){
        return e;
      }
    }
    throw new IllegalStateException("the enum don't have the value: " + type);
  }
}
