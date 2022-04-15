package jvm.pablohdz.restapidesignpatterns.bridge;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class DateUtilsTest {

  @Test
  void currentDateLessThreeMonths() {
    long dateOldThreeMonths = DateUtils.createDateBeforeMonths(3);
  
    String localDateTime = DateUtils.parseMillisToLocalISODate(dateOldThreeMonths);
    String currentDate = DateUtils.getCurrentDateFormatYYYYMMDD();
    System.out.println(localDateTime);
  }
  
  @Test
  void currentDateLessOneYear() {
    long dateOldOneYear = DateUtils.createDateBeforeYears(1);
  
    String localDateTime = DateUtils.parseMillisToLocalISODate(dateOldOneYear);
    System.out.println(localDateTime);
  }
}