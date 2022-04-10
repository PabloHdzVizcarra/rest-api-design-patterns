package jvm.pablohdz.restapidesignpatterns.object;

import jvm.pablohdz.restapidesignpatterns.dto.MessageRedisDto;
import jvm.pablohdz.restapidesignpatterns.entity.MessageRedisEntity;
import jvm.pablohdz.restapidesignpatterns.repository.MessageRedisFacadeRepository;
import jvm.pablohdz.restapidesignpatterns.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMessage {
  private final MessageRedisFacadeRepository repository;

  @Autowired
  public UserMessage(MessageRedisFacadeRepository repository) {
    this.repository = repository;
  }

  public MessageRedisDto createConversation(String message) {
    MessageRedisEntity messageRedisEntity = new MessageRedisEntity();
    messageRedisEntity.setContent(message);
    messageRedisEntity.setAuthor("john");
    messageRedisEntity.setId("message_" + StringUtils.generateRandomIdWithLength(8));

    MessageRedisEntity save = repository.save(messageRedisEntity);

    return new MessageRedisDto(save.getId(), save.getContent());
  }
}
