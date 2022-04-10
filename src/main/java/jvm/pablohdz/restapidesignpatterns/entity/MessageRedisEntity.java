package jvm.pablohdz.restapidesignpatterns.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("MessageRedis")
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageRedisEntity {
    @Id
    @Indexed
    private String id;
    private String content;
    private String author;
}
