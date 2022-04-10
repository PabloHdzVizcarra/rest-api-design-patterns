package jvm.pablohdz.restapidesignpatterns.dto;

import jvm.pablohdz.restapidesignpatterns.entity.UserRedis;
import jvm.pablohdz.restapidesignpatterns.repository.UserRedisFacadeRepository;
import jvm.pablohdz.restapidesignpatterns.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Component;

@Component
public class UserConversation {
  private final UserRedisFacadeRepository repository;

  @Autowired
  public UserConversation(UserRedisFacadeRepository repository) {
    this.repository = repository;
  }

  public UserRedisDto createUser(String name) {
    String id = "user_" + StringUtils.generateRandomIdWithLength(10);

    UserRedis userRedis = new UserRedis(id, name, true);

    return new UserRedisDto(id, name);
  }
}
