package jvm.pablohdz.restapidesignpatterns.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateChargesRequest {
  private Integer companyId;
  private List<Integer> listPrices;
}
