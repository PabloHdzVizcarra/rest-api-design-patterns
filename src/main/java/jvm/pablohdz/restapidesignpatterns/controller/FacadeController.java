package jvm.pablohdz.restapidesignpatterns.controller;

import jvm.pablohdz.restapidesignpatterns.dto.CreateUserRequest;
import jvm.pablohdz.restapidesignpatterns.model.ConversationModel;
import jvm.pablohdz.restapidesignpatterns.service.FacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/facade")
public class FacadeController {
    private final FacadeService facadeService;
    
    @Autowired
    public FacadeController(FacadeService facadeService) {
        this.facadeService = facadeService;
    }
    
    @GetMapping
    public ResponseEntity<String> getInfo() {
        return ResponseEntity.ok("Try to apply the facade design pattern in this controller");
    }
    
    @PostMapping
    public ResponseEntity<ConversationModel> createUser(@RequestBody CreateUserRequest request) {
        ConversationModel conversation = facadeService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(conversation);
    }
}
