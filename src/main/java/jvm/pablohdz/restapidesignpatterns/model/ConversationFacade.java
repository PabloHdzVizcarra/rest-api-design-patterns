package jvm.pablohdz.restapidesignpatterns.model;

import jvm.pablohdz.restapidesignpatterns.dto.MessageRedisDto;
import jvm.pablohdz.restapidesignpatterns.object.UserConversation;
import jvm.pablohdz.restapidesignpatterns.dto.UserRedisDto;
import jvm.pablohdz.restapidesignpatterns.object.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConversationFacade {
  private final UserConversation userConversation;
  //  private ChannelConversation channelConversation;
  private final UserMessage userMessage;

  @Autowired
  public ConversationFacade(UserConversation userConversation, UserMessage userMessage) {
    this.userConversation = userConversation;
    this.userMessage = userMessage;
  }

  public ConversationModel createMessageConversation(String username, String message) {
    UserRedisDto userDto = userConversation.createUser(username);
    ConversationModel conversationModel = new ConversationModel();
    conversationModel.setUser(userDto);

    MessageRedisDto messageRedisDto = userMessage.createConversation(message);
    conversationModel.setMessage(messageRedisDto);

    return conversationModel;
  }
}
