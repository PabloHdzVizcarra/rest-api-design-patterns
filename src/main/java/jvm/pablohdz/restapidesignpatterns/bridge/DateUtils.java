package jvm.pablohdz.restapidesignpatterns.bridge;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import javax.validation.constraints.NotNull;

public class DateUtils {
  public static long createDateBeforeMonths(int months) {
    return System.currentTimeMillis() - ((long) months * 30 * 24 * 60 * 60 * 1000);
  }
  
  public static boolean verifyThatThisDateIsThreeMonthsOld(long date) {
    return (System.currentTimeMillis() - date) > (3L * 30 * 24 * 60 * 60 * 1000);
  }
  
  public static String parseMillisToLocalISODate(@NotNull long millis) {
    ZoneOffset offSet = ZoneOffset.UTC;
    LocalDateTime date = LocalDateTime.ofEpochSecond(millis / 1000, 0, offSet);
    return date.toString();
  }
  
  public static long createDateBeforeYears(int i) {
    return System.currentTimeMillis() - ((long) i * 365 * 24 * 60 * 60 * 1000);
  }
  
  public static String getCurrentDateFormatYYYYMMDD() {
    return LocalDateTime.now().toString();
  }
  
}
