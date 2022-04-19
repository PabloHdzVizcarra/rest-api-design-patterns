package jvm.pablohdz.restapidesignpatterns.bridge;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionDto {
  private String id;
  private boolean isStart;
  private boolean isPaused;
  private boolean isFinished;
  private long updatedAt;
  private String type;
  private int price;
  private long createdAt;
}
