package jvm.pablohdz.restapidesignpatterns.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountDto {
  private String id;
  private String name;
  private String object;
  private int discount;
}
