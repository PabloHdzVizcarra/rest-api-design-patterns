package jvm.pablohdz.restapidesignpatterns.service;

import jvm.pablohdz.restapidesignpatterns.dto.DiscountDto;
import jvm.pablohdz.restapidesignpatterns.dto.DiscountRequest;
import jvm.pablohdz.restapidesignpatterns.model.BasicDiscountComposite;
import jvm.pablohdz.restapidesignpatterns.model.MultipleDiscountComposite;
import jvm.pablohdz.restapidesignpatterns.utils.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class CompositeService {
  
  public DiscountDto createDiscount(DiscountRequest request) {
    int discount = request.getDiscount();
    createId();
    MultipleDiscountComposite multipleDiscountComposite = new MultipleDiscountComposite(
        createId(), "better discount", discount
    );
    
    request.getExtraDiscounts().forEach(elem -> {
      BasicDiscountComposite basicDiscountComposite = new BasicDiscountComposite(
          createId(), "basic discount", elem);
      multipleDiscountComposite.addDiscount(basicDiscountComposite);
    });
    
    
    return new DiscountDto(
        multipleDiscountComposite.getId(),
        multipleDiscountComposite.getName(),
        multipleDiscountComposite.getObject(),
        multipleDiscountComposite.getSumOfAllDiscounts());
  }
  
  private String createId() {
    return "id_" + StringUtils.generateRandomIdWithLength(8);
  }
}
