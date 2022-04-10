package jvm.pablohdz.restapidesignpatterns.object;

import jvm.pablohdz.restapidesignpatterns.dto.ChannelDto;
import jvm.pablohdz.restapidesignpatterns.entity.ChannelRedisEntity;
import jvm.pablohdz.restapidesignpatterns.repository.ChannelRedisFacadeRepository;
import jvm.pablohdz.restapidesignpatterns.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChannelConversation {
  
  public static final String CHANNEL_ID_PREFIX = "channel_";
  private final ChannelRedisFacadeRepository repository;

  @Autowired
  public ChannelConversation(ChannelRedisFacadeRepository repository) {
    this.repository = repository;
  }
  
  
  public ChannelDto createConversation(String channel) {
    ChannelRedisEntity channelRedisEntity = new ChannelRedisEntity();
    channelRedisEntity.setChannel(channel);
    channelRedisEntity.setDescription("channel communication with the whatsapp API");
    channelRedisEntity.setActive(true);
    channelRedisEntity.setId(generateId());
  
    ChannelRedisEntity save = repository.save(channelRedisEntity);
    
    return new ChannelDto(save.getId(), save.getChannel(), save.getDescription());
  }
  
  private String generateId() {
    return CHANNEL_ID_PREFIX + StringUtils.generateRandomIdWithLength(8);
  }
}
