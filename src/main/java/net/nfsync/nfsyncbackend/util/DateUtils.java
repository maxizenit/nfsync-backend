package net.nfsync.nfsyncbackend.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class DateUtils {

  public LocalDate convertDateToLocalDate(Date date) {
    return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
  }

  public Integer getAgeByBirthdate(LocalDate birthdate) {
    return Math.toIntExact(ChronoUnit.YEARS.between(birthdate, LocalDate.now()));
  }
}
