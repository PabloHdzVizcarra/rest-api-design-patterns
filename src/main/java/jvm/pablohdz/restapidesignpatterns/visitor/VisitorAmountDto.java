package jvm.pablohdz.restapidesignpatterns.visitor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VisitorAmountDto {
  private int amount;
  private String currency;
  private int bankAccount;
  private int card;
}
