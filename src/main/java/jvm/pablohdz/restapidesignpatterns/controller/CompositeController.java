package jvm.pablohdz.restapidesignpatterns.controller;

import jvm.pablohdz.restapidesignpatterns.dto.DiscountDto;
import jvm.pablohdz.restapidesignpatterns.dto.DiscountRequest;
import jvm.pablohdz.restapidesignpatterns.service.CompositeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/composite")
public class CompositeController {
  private final CompositeService compositeService;

  @Autowired
  public CompositeController(CompositeService compositeService) {
    this.compositeService = compositeService;
  }

  @GetMapping
  public String info() {
    return "implementation of composite pattern in this endpoint";
  }

  @PostMapping
  public ResponseEntity<?> createDiscount(@RequestBody DiscountRequest request) {
    DiscountDto body = compositeService.createDiscount(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(body);
  }
}
