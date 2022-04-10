package jvm.pablohdz.restapidesignpatterns.object;

import jvm.pablohdz.restapidesignpatterns.dto.UserRedisDto;
import jvm.pablohdz.restapidesignpatterns.entity.UserRedisEntity;
import jvm.pablohdz.restapidesignpatterns.repository.UserRedisFacadeRepository;
import jvm.pablohdz.restapidesignpatterns.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConversation {
  private final UserRedisFacadeRepository repository;

  @Autowired
  public UserConversation(UserRedisFacadeRepository repository) {
    this.repository = repository;
  }

  public UserRedisDto createUser(String name) {
    String id = "user_" + StringUtils.generateRandomIdWithLength(8);

    UserRedisEntity userRedis = new UserRedisEntity(id, name, true);
    UserRedisEntity userSaved = repository.save(userRedis);

    return new UserRedisDto(userSaved.getId(), userSaved.getName());
  }
}
