package jvm.pablohdz.restapidesignpatterns.repository;

import jvm.pablohdz.restapidesignpatterns.entity.UserRedisEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRedisFacadeRepository  extends CrudRepository<UserRedisEntity, String> {

}
