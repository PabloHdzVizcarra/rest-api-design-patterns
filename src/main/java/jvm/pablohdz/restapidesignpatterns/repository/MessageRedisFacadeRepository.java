package jvm.pablohdz.restapidesignpatterns.repository;

import jvm.pablohdz.restapidesignpatterns.entity.MessageRedisEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRedisFacadeRepository extends CrudRepository<MessageRedisEntity, String> {

}
