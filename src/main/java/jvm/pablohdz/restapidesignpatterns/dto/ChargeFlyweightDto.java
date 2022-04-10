package jvm.pablohdz.restapidesignpatterns.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChargeFlyweightDto {
  private String name;
  private String id;
  private Integer companyId;
  private PriceFlyweight price;
}
