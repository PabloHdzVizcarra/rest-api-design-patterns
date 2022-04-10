package jvm.pablohdz.restapidesignpatterns.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("UserRedis")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRedis implements Serializable {
    @Id
    private String id;
    private String name;
    private Boolean active;
}
