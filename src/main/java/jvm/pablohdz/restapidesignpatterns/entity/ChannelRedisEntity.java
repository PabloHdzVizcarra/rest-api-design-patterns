package jvm.pablohdz.restapidesignpatterns.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("CHANNEL")
public class ChannelRedisEntity {
  @Id
  @Indexed
  private String id;
  private String channel;
  private String description;
  private Boolean active;
}
