package jvm.pablohdz.restapidesignpatterns.model;

import jvm.pablohdz.restapidesignpatterns.dto.UserConversation;
import jvm.pablohdz.restapidesignpatterns.dto.UserRedisDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConversationFacade {
  private final UserConversation userConversation;
//  private ChannelConversation channelConversation;
//  private MessageConversation messageConversation;
  
  @Autowired
  public ConversationFacade(UserConversation userConversation) {
    this.userConversation = userConversation;
  }
  
  public ConversationModel createMessageConversation(String username) {
    UserRedisDto userDto = userConversation.createUser(username);
    ConversationModel conversationModel = new ConversationModel();
    conversationModel.setUser(userDto);
    return conversationModel;
  }
}
