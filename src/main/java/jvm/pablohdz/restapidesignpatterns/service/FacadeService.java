package jvm.pablohdz.restapidesignpatterns.service;

import jvm.pablohdz.restapidesignpatterns.dto.CreateUserRequest;
import jvm.pablohdz.restapidesignpatterns.model.ConversationFacade;
import jvm.pablohdz.restapidesignpatterns.model.ConversationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacadeService {
  private final ConversationFacade conversationFacade;

  @Autowired
  public FacadeService(ConversationFacade conversationFacade) {
    this.conversationFacade = conversationFacade;
  }

  public ConversationModel createUser(CreateUserRequest request) {
    String username = request.getUsername();
    String message = request.getMessage();
    ConversationModel messageConversation =
            conversationFacade.createMessageConversation(username, message);
    return messageConversation;
  }
}
