package jvm.pablohdz.restapidesignpatterns.controller;

import java.util.List;
import jvm.pablohdz.restapidesignpatterns.dto.ChargeFlyweightDto;
import jvm.pablohdz.restapidesignpatterns.dto.CreateChargesRequest;
import jvm.pablohdz.restapidesignpatterns.service.FlyWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("flyweight")
public class FlyWeightController {
  private final FlyWeightService service;
  
  @Autowired
  public FlyWeightController(FlyWeightService service) {
    this.service = service;
  }
  
  @GetMapping
  public String info() {
    return "implementation of the Flyweight Design Pattern in this controller";
  }
  
  @PostMapping
  public ResponseEntity<List<ChargeFlyweightDto>> createCharge(@RequestBody CreateChargesRequest request) {
    List<ChargeFlyweightDto> charges = service.createCharges(request);
    
    return ResponseEntity.status(HttpStatus.CREATED).body(charges);
  }
}
