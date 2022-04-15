package jvm.pablohdz.restapidesignpatterns.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountRequest {
  private int discount;
  private List<Integer> extraDiscounts;
}
