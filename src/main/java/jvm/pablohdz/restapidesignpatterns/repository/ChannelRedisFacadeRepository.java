package jvm.pablohdz.restapidesignpatterns.repository;

import jvm.pablohdz.restapidesignpatterns.entity.ChannelRedisEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRedisFacadeRepository extends CrudRepository<ChannelRedisEntity, Long> {

}
