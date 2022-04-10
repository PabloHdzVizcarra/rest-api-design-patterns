package jvm.pablohdz.restapidesignpatterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableRedisRepositories
public class RestApiDesignPatternsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiDesignPatternsApplication.class, args);
	}

}
