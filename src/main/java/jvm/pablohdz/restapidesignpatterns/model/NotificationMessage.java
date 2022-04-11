package jvm.pablohdz.restapidesignpatterns.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationMessage {
  private String serviceName;
  private String designPattern;
  private Object body;
}
