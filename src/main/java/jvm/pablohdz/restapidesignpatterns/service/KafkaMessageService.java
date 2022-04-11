package jvm.pablohdz.restapidesignpatterns.service;

import jvm.pablohdz.restapidesignpatterns.model.NotificationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageService {
  private final KafkaTemplate<String, NotificationMessage> kafkaTemplateNotification;

  @Autowired
  public KafkaMessageService(KafkaTemplate<String, NotificationMessage> kafkaTemplateNotification) {
    this.kafkaTemplateNotification = kafkaTemplateNotification;
  }

  public void sendMessageNotification(Object body) {
    kafkaTemplateNotification.send("flyweight", new NotificationMessage("app", "flyweight", body));
  }
}
