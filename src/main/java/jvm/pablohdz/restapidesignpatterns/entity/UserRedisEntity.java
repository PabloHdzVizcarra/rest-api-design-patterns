package jvm.pablohdz.restapidesignpatterns.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;


@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("UserRedisEntity")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRedisEntity implements Serializable {
    @Id
    @Indexed
    private String id;
    private String name;
    private Boolean active;
}
